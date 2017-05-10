package moolya.partnersgroup;

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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.partnersgroup.pages.W_BasePage;

public class W_BaseTest 
{

	public WebDriver driver;

	W_BasePage basepage;

	private ATUTestRecorder recorder;

	@BeforeClass
	public void setUp() throws IOException, ATUTestRecorderException{

		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		String dir = System.getProperty("user.dir");
		recorder = new ATUTestRecorder(dir+"\\script-videos\\", "PartnersGroup-Summary-" + dateFormat.format(date), false);

		basepage = new W_BasePage(driver);
		recorder.start();
		driver = basepage.launchWebApp();
	}

	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException, ATUTestRecorderException 
	{   
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		String dir = System.getProperty("user.dir");
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+clsName+dateFormat.format(date)+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@AfterClass
	public void tearDown() throws ATUTestRecorderException{
		recorder.stop();
		driver.close();
	}

}
