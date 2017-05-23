package moolya.slicepay.pages.mobile;

import java.io.File;
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
import io.appium.java_client.ios.IOSDriver;
import moolya.slicepay.utils.JavaUtils;

public class M_BasePage extends JavaUtils {

	public AppiumDriver<MobileElement> mdriver;
	public WebDriver driverWeb;
	public enum mobile {
		ANDROID,
		IOS
	}
	public static mobile platform;

	public M_BasePage(AppiumDriver<MobileElement> mdriver){
		this.mdriver = mdriver;
	}


	public void clickDeviceBackButton()
	{
		mdriver.navigate().back(); 
	}



	public AppiumDriver<MobileElement> launchmobApp(String c) throws IOException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir ;
		File app ;
		if(c.contains("android")){
			platform = mobile.ANDROID;
		}else{
			platform = mobile.IOS;
		}
		DesiredCapabilities capabilities ;
		switch(platform){
		case ANDROID:
			System.out.println("Launching Platform Android");
			classpathRoot = new File(System.getProperty("user.dir"));
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", getPropValue("AdeviceName"));
			capabilities.setCapability("platformName", getPropValue("AplatformName"));
			capabilities.setCapability("platformVersion", getPropValue("AplatformVersion"));
			capabilities.setCapability("appPackage",getPropValue("AappPackage"));
			capabilities.setCapability("appActivity",getPropValue("AappActivity"));
			appDir = new File(classpathRoot, getPropValue("AappDir"));
			app = new File (appDir, getPropValue("AappName"));
			if(!app.getName().equals("NA"))
				capabilities.setCapability("app", app.getAbsolutePath());
			mdriver = new AndroidDriver<MobileElement>(new URL(getPropValue("AppiumUrl")), capabilities);
			break;
		case IOS:
			System.out.println("Launching Platform IOS");
			appDir = new File(classpathRoot, getPropValue("IappDir"));
			app = new File(appDir, getPropValue("IappName"));
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "ios");
			capabilities.setCapability("deviceName", getPropValue("IdeviceName"));
//          capabilities.setCapability("udid", "36c1fa65340d70d7727b76aae45724972a145e26");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("platformVersion", getPropValue("IplatformVersion"));
			capabilities.setCapability("automationName", getPropValue("IautomationName"));
			if (getPropValue("InoReset").equals("true"))
				capabilities.setCapability("noReset", "true");
			else
				capabilities.setCapability("noReset", "false");
			mdriver = new IOSDriver<MobileElement>(new URL(getPropValue("AppiumUrl")), capabilities);
			break;
		}
		System.out.println("*****Launching the app*****");
		mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
