package Moolya.CashE.testCases;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Moolya.CashE.utilities.AppiumServerUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.uiOverlap.UI;

public class Dummy {
	
	AppiumDriver<MobileElement> driverMob = null;
	UI u = null;
	
	@BeforeTest
	public void demoTest() throws IOException, InterruptedException{
		AppiumServerUtils.startAppium();
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "5.1");
//		capabilities.setCapability("udid", "ENU7N15B10001097");
		//capabilities.setCapability("udid", "a147b8cc");
		capabilities.setCapability("appPackage","com.dharma.uitesting");
		capabilities.setCapability("appActivity","MainActivity");
		try {
			driverMob = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		driverMob.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		u = new UI();
	}
	
	@Test
	public void helloSignupTest(){
		MobileElement e1 = driverMob.findElementByName("Hello world!");
		MobileElement e2 = driverMob.findElementById("com.dharma.uitesting:id/btn1");
		u.isVerticalOverlapping(e1, e2);
	}
	
	@Test
	public void signUpLoginTest(){
		MobileElement e2 = driverMob.findElementById("com.dharma.uitesting:id/btn1");
		MobileElement e3 = driverMob.findElementById("com.dharma.uitesting:id/btn2");
		u.isVerticalOverlapping(e2, e3);
	}
	
	@Test
	public void helloLoginTest(){
		MobileElement e1 = driverMob.findElementByName("Hello world!");
		MobileElement e3 = driverMob.findElementById("com.dharma.uitesting:id/btn2");
		u.isVerticalOverlapping(e1, e3);
	}
	
	@Test
	public void loginLogin2Test(){
		MobileElement e3 = driverMob.findElementById("com.dharma.uitesting:id/btn2");
		MobileElement e4 = driverMob.findElementById("com.dharma.uitesting:id/btn3");
		u.isVerticalOverlapping(e3, e4);
	}
	
	
}
