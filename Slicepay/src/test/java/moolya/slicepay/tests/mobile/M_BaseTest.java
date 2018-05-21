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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.slicepay.pages.mobile.M_BasePage;
import moolya.slicepay.pages.mobile.android.HomePage;
import moolya.slicepay.pages.mobile.android.SignInPage;
import moolya.slicepay.utils.AppiumServiceUtils;
import moolya.slicepay.utils.JavaUtils;

public class M_BaseTest {

	public AppiumDriver<MobileElement> mdriver;
	AppiumServiceUtils service;

	M_BasePage basepage;
	private ATUTestRecorder recorder;
	private HomePage hp;

	@BeforeClass
	public void setUp() throws Exception{
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		if(!new File(dir+"\\script-videos").exists())
			new File(dir+"\\script-videos").mkdirs();
//		recorder = new ATUTestRecorder(dir+"\\script-videos\\", this.getClass().getSimpleName()+ "-" + dateFormat.format(date), false);
		// To start video recording.
		//		AppiumServerUtils.startAppium();
		service = new AppiumServiceUtils();
		service.service.start();
		basepage = new M_BasePage(mdriver);
		mdriver = basepage.launchmobApp(this.getClass().getPackage().getName());
//		recorder.start();
	}

	@AfterClass
	public void tearDown() throws IOException, InterruptedException, ATUTestRecorderException
	{
//		recorder.stop();
		mdriver.closeApp();
		service.service.stop();
	}

	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException 
	{    
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		if(result.isSuccess()){
			Reporter.log("Test: "+result.getMethod().getMethodName()+" Executed Successfully", true);
		}
		else{
			File scrFile = ((TakesScreenshot)mdriver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+result.getClass().getSimpleName()+"-"+dateFormat.format(date)+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try{
			((AndroidDriver<MobileElement>)mdriver).startActivity(JavaUtils.getPropValue("AappPackage"), JavaUtils.getPropValue("AappActivity"));
		}catch(Exception e){}
	}

}
