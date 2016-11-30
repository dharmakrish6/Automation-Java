package Moolya.CashE.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import Moolya.CashE.pages.BasePage;
import Moolya.CashE.utilities.AppiumServerUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

@SuppressWarnings("unused")
public class BaseTest {
	
	public AppiumDriver<MobileElement> driverMob;
	public WebDriver driverweb;
	
	BasePage basepage;
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException{
		AppiumServerUtils.startAppium();
		basepage = new BasePage(driverMob);
		driverMob = basepage.LaunchmobApp();
	}
	
	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException 
	{    
		String dir = System.getProperty("user.dir");
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)driverMob).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+clsName+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@AfterClass
	public void tearDown() throws InterruptedException, IOException{
		driverMob.closeApp();
		Thread.sleep(3000);
		AppiumServerUtils.stopAppium();
	}
	
	

}
