package TestCases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Screens.BasePageMob;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import utils.JavaUtils;

public class BaseTestMob 
{
public AppiumDriver<MobileElement> driverMob;
	
	BasePageMob basepagemob;

	
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException{
		JavaUtils.resetApp(JavaUtils.getPropValue("appPackage"));
		JavaUtils.resetApp(JavaUtils.getPropValue("deeperEnggApp"));
		JavaUtils.resetApp(JavaUtils.getPropValue("deeperMediApp"));
		basepagemob = new BasePageMob(driverMob);
		driverMob = basepagemob.LaunchmobApp();
		
}
	
	
	
	@AfterMethod
	public void tearDown() {
		if (driverMob != null) {
			driverMob.quit();
		}
	}
}