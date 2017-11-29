package Screens;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.JavaUtils;

public class BasePageMob
{

	public static AppiumDriver<MobileElement> driverMob;
	public BasePageMob(AppiumDriver<MobileElement> driverMob)
	{
		this.driverMob = driverMob;
	}  
	
//	@Test
	public AppiumDriver<MobileElement> LaunchmobApp() throws IOException
        {
			DesiredCapabilities capabilities = new DesiredCapabilities();
        	
        	capabilities.setCapability("platformName", JavaUtils.getPropValue("platformName"));
        	capabilities.setCapability("platformVersion", JavaUtils.getPropValue("platformVersion"));
        	capabilities.setCapability("deviceName", JavaUtils.getPropValue("deviceName"));
        	
        	//For engineering
        	/*capabilities.setCapability("appPackage", "com.embibe.institute.sinhal.engineering");
        	capabilities.setCapability("appActivity", "com.embibe.institute.sinhal.engineering.activities.SplashActivity");
        	*/
        	capabilities.setCapability("appPackage", JavaUtils.getPropValue("appPackage"));
        	capabilities.setCapability("appActivity", JavaUtils.getPropValue("appActivity"));
        	try {
    			driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

    		} catch (MalformedURLException e) {
    			e.printStackTrace();
    		}
    		driverMob.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    		
    		return driverMob;
        	
        }
	
	public void waitUntilElementAppears(MobileElement element){

		WebDriverWait wait = new WebDriverWait(driverMob, 300);
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

}
