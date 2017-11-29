package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Screens.BasePageMob;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BaseTestMob 
{
public AppiumDriver<MobileElement> driverMob;
	
	BasePageMob basepagemob;

	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException{
		
		basepagemob = new BasePageMob(driverMob);
		driverMob = basepagemob.LaunchmobApp();
		driverMob.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
}
	@AfterClass
	public void tearDown() {
		if (driverMob != null) {
			driverMob.quit();
		}
	}
}