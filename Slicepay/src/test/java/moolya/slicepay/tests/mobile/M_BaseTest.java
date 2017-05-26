package moolya.slicepay.tests.mobile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import moolya.slicepay.pages.mobile.M_BasePage;
import moolya.slicepay.utils.AppiumServiceUtils;

public class M_BaseTest {
	
	public AppiumDriver<MobileElement> mdriver;
	AppiumServiceUtils service;
	
	M_BasePage basepage;
	
	@BeforeSuite
	public void setUp() throws Exception{
//		AppiumServerUtils.startAppium();
		service = new AppiumServiceUtils();
		service.service.start();
		basepage = new M_BasePage(mdriver);
		mdriver = basepage.launchmobApp(this.getClass().getPackage().getName());
	}
	
	@AfterSuite
	public void tearDown() throws IOException, InterruptedException
	{
//		AppiumServerUtils.stopAppium();
		mdriver.closeApp();
		service.service.stop();
	}
	
	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException 
	{    
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)mdriver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+result.getMethod().getMethodName()+"-"+dateFormat.format(date)+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
