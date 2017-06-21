package moolya.sunnxt.webAndMobileTests;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import moolya.sunnxt.pages.mobilepages.M_BasePage;
import moolya.sunnxt.pages.webpages.W_BasePage;
import moolya.sunnxt.utils.AppiumServerUtils;

public class BaseTest {


	public AppiumDriver<MobileElement> mdriver;
	public WebDriver wdriver;

	W_BasePage wbasepage;

	M_BasePage mbasepage;
	ATUTestRecorder recorder;

	public void launchMobileApp() throws Exception{
		AppiumServerUtils.startAppium();
		mbasepage = new M_BasePage(mdriver);
		mdriver = mbasepage.launchmobApp(this.getClass().getPackage().getName());
	}

	public void launchWebApp() throws IOException, ATUTestRecorderException{
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(dir+"\\script-videos\\", "Verify-Order-Summary-" + dateFormat.format(date), false);
		// To start video recording.
		wbasepage = new W_BasePage(wdriver);
		recorder.start();
		wdriver = wbasepage.launchWebApp();
	}

	public void closeMobileApp() throws IOException, InterruptedException
	{
		mdriver.closeApp();
		AppiumServerUtils.stopAppium();
	}
	
	public void closeWebApp() throws ATUTestRecorderException{
		wdriver.close();
		recorder.stop();
	}


	public void catchExceptions(ITestResult result,WebDriver driver){
		String dir = System.getProperty("user.dir");
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+clsName+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void catchExceptions(ITestResult result,AppiumDriver<MobileElement> driver) throws IOException, InterruptedException 
	{    
		String dir = System.getProperty("user.dir");
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
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
