package moolya.hungama.tests;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.hungama.pages.M_BasePage;
import moolya.hungama.utils.AppiumServerUtils;
import moolya.hungama.utils.JavaUtils;

@SuppressWarnings("unused")
public class M_BaseTest extends JavaUtils {
	
	public AppiumDriver<MobileElement> mdriver;
	
	M_BasePage basepage;
	
	@BeforeClass
	public void setUp() throws IOException, InterruptedException{
		AppiumServerUtils.startAppium();
		basepage = new M_BasePage(mdriver);
		basepage.apnModeOFF();
		mdriver = basepage.launchmobApp();
	}
	
	@AfterClass
	public void tearDown() throws IOException, InterruptedException
	{
		basepage = new M_BasePage(mdriver);
		basepage.apnModeOFF();
//		AppiumServerUtils.stopAppium();
//		mdriver.closeApp();
	}
	
	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException 
	{
		((AndroidDriver<MobileElement>)mdriver).startActivity(getPropValue("appPackage"), getPropValue("appActivity"));
		String dir = System.getProperty("user.dir");
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)mdriver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+clsName+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
