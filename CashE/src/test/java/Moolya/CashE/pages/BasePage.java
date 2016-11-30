package Moolya.CashE.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;

public class BasePage {

	public AppiumDriver<MobileElement> driverMob;
	public WebDriver driverWeb;
	
	
	public BasePage(AppiumDriver<MobileElement> driver){
		this.driverMob = driver;
	}

	public BasePage(WebDriver driverWeb)
	{
		this.driverWeb= driverWeb;
	}

	public void launchBrowser(String url)
	{
		driverWeb = new FirefoxDriver();
		driverWeb.get(url);
		driverWeb.manage().window().maximize();
		driverWeb.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void navigateToURL() throws IOException{

		String url = getPropValue("URL");
		Reporter.log("****************Navigating to"+url+"*************", true);

		driverWeb.get(url);
		Reporter.log("*******Successfully Navigated to Portal***********", true);
	}

	public void closeBrowser(){

		driverWeb.close();
		Reporter.log("*******Browser closed Successfully********", true);
	}


	public void waitUntilElementAppears(MobileElement element){

		WebDriverWait wait = new WebDriverWait(driverMob, 25);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(MobileElement element){

		WebDriverWait wait = new WebDriverWait(driverMob, 200);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	
	public static String getPropValue(String key,String projectName){

		String propValue = null;
		try {
			FileInputStream input = new FileInputStream("../"+projectName+"/config.properties");
			Properties prop = new Properties();
			prop.load(input);

			propValue = prop.getProperty(key);

		} catch (IOException e) {
			System.out.println("Caught the below exception!");
			e.printStackTrace();
		}
		return propValue;
	}
	
	

	public Row readExcel(String sheetName, String uniqueValue, int columnNo){

		try{
			Row record= null;
			FileInputStream fileIn = new FileInputStream(new File("./test-data/CASHe.xlsx"));
			Workbook workbook = WorkbookFactory.create(fileIn); //Access the workbook

			Sheet worksheet = workbook.getSheet(sheetName);  //Access the worksheet, so that we can update / modify it.

			Iterator<Row> it = worksheet.rowIterator();

			while(it.hasNext()) {

				record = it.next();
				String cellValue = record.getCell(columnNo).toString();
				if(cellValue.equalsIgnoreCase(uniqueValue)) {
					fileIn.close();
					return record;
				}
			}
		}
		catch(IOException ioe){
			ioe.printStackTrace();
		}
		catch(InvalidFormatException ife){
			ife.printStackTrace();
		}
		Reporter.log("The Record with "+uniqueValue+" is not found in the excel..!",true);
		return null;

	}

	
	
	public HashMap<String,String>  readDataMap(String sheetname,String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		try{
			String key, value;
			FileInputStream file = new FileInputStream("./test-data/CASHe.xlsx");
			HashMap<String,String> dataMap = new HashMap<String, String>();
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet(sheetname);
			Iterator<Row> it = sheet.rowIterator();

			Row headers = it.next();
			while(it.hasNext()) {

				Row record = it.next();
				String cellValue = record.getCell(0).toString();
				if(cellValue.equalsIgnoreCase(uniqueValue)) {
					for(int i=0;i<record.getLastCellNum();i++){
						key = headers.getCell(i).toString();
						value = record.getCell(i).toString();
						dataMap.put(key, value);
					}
					break;
				}
			}
			return dataMap;
		}
		catch(NullPointerException e){
			e.printStackTrace();
		}
		return null;
	}
	
	

	public AppiumDriver<MobileElement> LaunchmobApp() throws IOException
	{
		String deviceName = getPropValue("deviceName");
		String platformName = getPropValue("platformName");
		String platformVersion = getPropValue("platformVersion");
		String appPackage = getPropValue("appPackage");
		String appActivity = getPropValue("appActivity");
		System.out.println("*****Launching the app*****");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
//		capabilities.setCapability("udid", "ENU7N15B10001097");
		//capabilities.setCapability("udid", "a147b8cc");
		capabilities.setCapability("appPackage",appPackage);
		capabilities.setCapability("appActivity",appActivity);
		try {
			driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driverMob.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driverMob;

	}

	public static String getPropValue(String key) throws IOException
	{
		File configFile = new File("./config.properties");
		String host = null;
		try {
		    FileReader reader = new FileReader(configFile);
		    Properties props = new Properties();
		    props.load(reader);
		    host = props.getProperty(key);
		    reader.close();
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
		
		return host;
	}
	
	public static void setPropValue(String key,String value){
		File configFile = new File("./config.properties");
		try {
		    Properties props = new Properties();
		    props.setProperty(key, value);
		    FileWriter writer = new FileWriter(configFile);
		    props.store(writer, "host settings");
		    writer.close();
		} catch (FileNotFoundException ex) {
		    // file does not exist
		} catch (IOException ex) {
		    // I/O error
		}
	}


	public  void swipeVertical(int yStart, int yEnd, int totalSwipes) throws IOException{

		for(int i = 0; i<totalSwipes; i++)
		{		
			driverMob.swipe(300,yStart,300,yEnd, 3000);
		}
	}
	
	
	
	
	
	public AppiumDriver<MobileElement> getDriver(){
		return driverMob;
	}
	
	
	
		
	public void scrollUntilElementIsVisible(MobileElement element) throws InterruptedException{
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){}
		while(element.isDisplayed()!=true)
			Thread.sleep(500);
		driverMob.swipe(0, 700, 0, 600, 1);	
	}
	
	
	public void selectDropdown(MobileElement element,String value){
		try{
			waitUntilElementclickable(element);
			element.click();
			MobileElement item = driverMob.findElementByName(value);
			waitUntilElementclickable(item);
			item.click();
		}
		catch(Exception e){
			waitUntilElementclickable(element);
			element.click();
			driverMob.scrollToExact(value);
			MobileElement item = driverMob.findElementByName(value);
			waitUntilElementclickable(item);
			item.click();
		}
	}
	
	public void selectTextBox(MobileElement element,String value) throws InterruptedException{
		waitUntilElementclickable(element);
		Thread.sleep(2000);
		element.sendKeys(value);
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){}
		Thread.sleep(2000);
		waitUntilElementclickable(driverMob.findElementByName(value));
		driverMob.findElementByName(value).click();
	}
	
	public String getTodaysDayNum(){
		String day = "";
		Calendar cal = Calendar.getInstance();
		day = String.valueOf(cal.get(Calendar.DAY_OF_MONTH));
		return day;
	}
	
	public void enterKey(){
		((AndroidDriver<MobileElement>)driverMob).pressKeyCode(AndroidKeyCode.ENTER);
	}
}
