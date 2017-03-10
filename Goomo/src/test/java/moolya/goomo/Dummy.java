package moolya.goomo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dummy {

	static String str = null;
	static WebDriver driver;
	

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
//		driver = new FirefoxDriver();
		driver.get("http://demo.actitime.com/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		driver.findElement(By.id("loginButton")).click();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("topnav")));
		driver.get("http://demo.actitime.com/tasks/otasklist.do");
		Thread.sleep(5000);
		HashMap<String, String> data = JavaUtils.readExcelData("Sheet1", "1");
		String projectName = data.get("Project Name");
		System.out.println(projectName);
		List<WebElement> cbs = driver.findElements(By.xpath("//td[3]//a"));
		for(WebElement e:cbs){
			System.out.println(e.getText());
			if(e.getText().equals("Page design")){
				Thread.sleep(2000);
				String s = e.findElement(By.xpath("/../../../../../preceding-sibling::td[1]")).getText().trim();
				System.out.println(s);
				break;
			}
		}
		
	}
}
