package Screens;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.JavaUtils;

public class BasePageMob
{

	@AndroidFindBy(xpath="//android.widget.NumberPicker[@index='0']/android.widget.Button[@index='0']")
	public MobileElement day_Btn;
	
	@AndroidFindBy(xpath="//android.widget.NumberPicker[@index='1']/android.widget.Button[@index='0']")
	public MobileElement month_Btn;
	
	@AndroidFindBy(xpath="//android.widget.NumberPicker[@index='2']/android.widget.Button[@index='0']")
	public MobileElement year_Btn;
	
	@AndroidFindBy(id="android:id/numberpicker_input")
	public List<MobileElement> date_List;
	
	@AndroidFindBy(name="Set")
	public MobileElement setBtn;
	
	public static AppiumDriver<MobileElement> driverMob;
	public BasePageMob(AppiumDriver<MobileElement> driverMob)
	{
		this.driverMob = driverMob;
	}  

	//	@Test
	public AppiumDriver<MobileElement> LaunchmobApp(String goal) throws IOException
	{
		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", JavaUtils.getPropValue("platformName"));
		capabilities.setCapability("platformVersion", JavaUtils.getPropValue("platformVersion"));
		capabilities.setCapability("deviceName", JavaUtils.getPropValue("deviceName"));

		if(goal.equalsIgnoreCase("medical")){
			capabilities.setCapability("appPackage", JavaUtils.getPropValue("deeperMediApp"));
			capabilities.setCapability("appActivity", JavaUtils.getPropValue("deeperMediAppActivity"));
			
		}else if(goal.equalsIgnoreCase("engineering")){
			capabilities.setCapability("appPackage", JavaUtils.getPropValue("deeperEnggApp"));
			capabilities.setCapability("appActivity", JavaUtils.getPropValue("deeperEnggAppActivity"));
			
		}
		
		
		try {
			driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driverMob.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
		return driverMob;

	}

	public void waitUntilElementAppears(MobileElement element){

		WebDriverWait wait = new WebDriverWait(driverMob, 100);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementAppears(MobileElement element,int seconds){

		WebDriverWait wait = new WebDriverWait(driverMob, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(MobileElement element){

		WebDriverWait wait = new WebDriverWait(driverMob, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementclickable(MobileElement element,int seconds){

		WebDriverWait wait = new WebDriverWait(driverMob, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void closeKeyboard(){
		try{
			driverMob.hideKeyboard();
		}catch(Exception e){}
	}

	public void selectDate(String day,String month, String year) throws InterruptedException{
		waitUntilElementclickable(day_Btn);
		while(!date_List.get(2).getAttribute("text").equalsIgnoreCase(year)){
			driverMob.tap(1, year_Btn, 1);
		}
		Thread.sleep(500);
		while(!date_List.get(1).getAttribute("text").equalsIgnoreCase(month)){
			driverMob.tap(1, month_Btn, 1);
		}
		Thread.sleep(500);
		while(!date_List.get(0).getAttribute("text").equalsIgnoreCase(day)){
			driverMob.tap(1, day_Btn, 1);
		}

		setBtn.click();
	}

}
