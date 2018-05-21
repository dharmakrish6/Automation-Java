package moolya.goomo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GetAirportDetailsTest {

	WebDriver driver;
	String code = "";

	@BeforeClass
	public void setup(){
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.iata.org/publications/Pages/code-search.aspx");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test(dataProvider="getData")
	public void getdetailsTest(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		code = uniqueValue;
		WebElement searchBy = driver.findElement(By.id("ctl00_SPWebPartManager1_g_e3b09024_878e_4522_bd47_acfefd1000b0_ctl00_ddlImLookingFor"));
		Select s = new Select(searchBy);
		s.selectByVisibleText("Location code");
		driver.findElement(By.id("ctl00_SPWebPartManager1_g_e3b09024_878e_4522_bd47_acfefd1000b0_ctl00_txtSearchCriteria")).sendKeys(uniqueValue);
		driver.findElement(By.id("ctl00_SPWebPartManager1_g_e3b09024_878e_4522_bd47_acfefd1000b0_ctl00_butSearch")).click();
		WebElement table = driver.findElement(By.xpath("//table[@class='datatable']"));
		waitUntilElementClickable(table);
		WebElement cityCode = driver.findElement(By.xpath("//tbody//td[2]"));
		Assert.assertTrue(cityCode.getText().equals(uniqueValue), "Code not found!");
		String cityName = cityCode.findElement(By.xpath("../td[1]")).getText();
		JavaUtils.writeValueToExcel("Codes", uniqueValue, "City", cityName);
		String airportName = cityCode.findElement(By.xpath("../td[3]")).getText();
		JavaUtils.writeValueToExcel("Codes", uniqueValue, "Airport", airportName);
		System.out.println(uniqueValue+" Completed!");
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		String dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dir+"/test-data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Codes");
		Iterator<Row> it = sh.rowIterator();
		it.next();
		int rows = sh.getLastRowNum();
		Object[][] obj = new Object[rows][1];
		int i=0;
		while(it.hasNext()){
			Row row = it.next();
			obj[i][0]=row.getCell(0).toString();
			i++;
		}
		return obj;
	}

	@AfterMethod
	public void afterTestMethod(ITestResult result) throws IOException{
		if(!result.isSuccess()){
			String dir = System.getProperty("user.dir");
			DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
			Date date = new Date();
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+code+dateFormat.format(date)+".png";
			FileUtils.copyFile(scrFile, new File(file));
		}
		driver.get("http://www.iata.org/publications/Pages/code-search.aspx");
	}

	public void waitUntilElementClickable(WebElement e){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(e));
	}

}
