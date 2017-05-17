package moolya.sunnxt.pages.mobilepages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.sunnxt.utils.JavaUtils;

public class M_BasePage extends JavaUtils {

	public static AppiumDriver<MobileElement> mdriver;
	public WebDriver driverWeb;

	public M_BasePage(AppiumDriver<MobileElement> mdriver){
		this.mdriver = mdriver;
	}


	public static void clickDeviceBackButton()
	{
		mdriver.navigate().back(); 
	}


	public AppiumDriver<MobileElement> launchmobApp() throws IOException
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
		capabilities.setCapability("appPackage",appPackage);
		capabilities.setCapability("appActivity",appActivity);
		try {
			mdriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		mdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return mdriver;
	}
	
	public void clickElementByText(String text) throws InterruptedException{
		Thread.sleep(2000);
		try{
			mdriver.findElementByName(text).click();
		}catch(Exception e){
			mdriver.scrollToExact(text);
			mdriver.findElementByName(text).click();
		}
	}

	public void waitUntilElementAppears(MobileElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(MobileElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void scrollUntilElementIsVisible(MobileElement element) throws InterruptedException{
		try{
			mdriver.hideKeyboard();
		}
		catch(Exception e){}
		while(element.isDisplayed()!=true)
			Thread.sleep(500);
		mdriver.swipe(0, 700, 0, 600, 1);	
	}



	public  void swipeVertical(int yStart, int yEnd, int x, int totalSwipes) throws IOException, InterruptedException{

		for(int i = 1; i<=totalSwipes; i++)
		{
			Thread.sleep(1000);
			mdriver.swipe(x,yStart,x,yEnd, 1000);
			//1000,750,1040,400
		}
	}

	public  void swipehorizontal(int xStart, int xEnd, int y, int totalSwipes) {
		try {
			for(int i = 1; i<=totalSwipes; i++)
			{
				Thread.sleep(1000);
				mdriver.swipe(xStart,y,xEnd,y, 1000);
				//71,570,180,570
				//700,876,65,920

			}
		} 
		catch (Exception e) 
		{

		}

	}

	public void swipeUntilElementVisible(WebElement element)
	{
		for (int i = 1; i < 10; i++) 
		{
			mdriver.swipe(100, 600, 100, 500, 1);
			try 
			{
				element.isDisplayed();
				break;
			} 
			catch (Exception e) 
			{
				mdriver.swipe(100, 700, 100, 500, 1);
			}
		}
	}
	
	public void enterMobNumber(MobileElement element,String mobNo){
		waitUntilElementclickable(element);
		element.click();
		mobNo = mobNo.replaceAll("[^0-9]", "");
		mobNo = mobNo.substring(0,10);
		System.out.println("Entering Mobile No. : "+mobNo);
		int[] digits = new int[mobNo.length()];
		for(int i=0;i<mobNo.length();i++){
			String digitAsString=mobNo.substring(i, i+1);
			digits[i] = Integer.parseInt(digitAsString)+7;
			((AndroidDriver<MobileElement>)mdriver).pressKeyCode(digits[i]);
		}
	}
	
	public void selectDropdown(MobileElement element,String value){
		try{
			waitUntilElementclickable(element);
			element.click();
			MobileElement item = mdriver.findElementByName(value);
			waitUntilElementclickable(item);
			item.click();
		}
		catch(Exception e){
			waitUntilElementclickable(element);
			element.click();
			mdriver.scrollToExact(value);
			MobileElement item = mdriver.findElementByName(value);
			waitUntilElementclickable(item);
			item.click();
		}
	}
	
	public void typeAndSelect(MobileElement sElement,MobileElement tElement,String value){
		sElement.sendKeys(value);
		tElement.click();
	}
	
	public AppiumDriver<MobileElement> getDriver(){
		return mdriver;
	}


	

}
