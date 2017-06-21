package moolya.sunnxt.mobileTests;

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
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.sunnxt.Driver;
import moolya.sunnxt.pages.mobilepages.M_BasePage;
import moolya.sunnxt.pages.mobilepages.M_SuperBasePage;
import moolya.sunnxt.pages.webpages.HomePage;
import moolya.sunnxt.utils.AppiumServiceUtils;
import moolya.sunnxt.utils.JavaUtils;

public class M_BaseTest {

	public AppiumDriver<MobileElement> mdriver;
	AppiumServiceUtils service;

	M_BasePage basepage;
	private ATUTestRecorder recorder;
	private HomePage hp;
	private M_SuperBasePage superbasepage;

	@BeforeSuite
	public void setUp() throws Exception{
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		if(!new File(dir+"\\script-videos").exists())
			new File(dir+"\\script-videos").mkdirs();
//		recorder = new ATUTestRecorder(dir+"\\script-videos\\", this.getClass().getSimpleName()+ "-" + dateFormat.format(date), false);
		service = new AppiumServiceUtils();
		service.service.start();
		superbasepage = new M_SuperBasePage(mdriver);
		mdriver = superbasepage.launchmobApp(this.getClass().getPackage().getName());
		Driver.setDriver(mdriver);
//		sip = new SignInPage(mdriver);
//		sip.login("Login001");
//		 To start video recording.
//		recorder.start();
		
	}

	@AfterSuite
	public void tearDown() throws IOException, InterruptedException, ATUTestRecorderException
	{
//		hp = new HomePage(mdriver);
//		hp.logout();
		mdriver = Driver.getDriver(); 
		mdriver.closeApp();
		service.service.stop();
//		recorder.stop();
	}
	
	@BeforeMethod
	public void getDriver(){
		mdriver = Driver.getDriver();
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
			String file =dir+"/screenshots/"+this.getClass().getSimpleName()+"-"+dateFormat.format(date)+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		((AndroidDriver<MobileElement>)mdriver).startActivity(JavaUtils.getPropValue("AappPackage"), JavaUtils.getPropValue("AappActivity"));
	}

}
