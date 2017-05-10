package moolya.insteract.poc.tests;

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
import moolya.insteract.poc.pages.W_BasePage;

public class W_BaseTest 
{

	public WebDriver driver;

	W_BasePage basepage;

	private ATUTestRecorder recorder;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;

	@BeforeClass
	public void setUp() throws IOException, ATUTestRecorderException{

		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		String dir = System.getProperty("user.dir");
		// start reporters
		htmlReporter = new ExtentHtmlReporter(dir+"/extent.html");

		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		recorder = new ATUTestRecorder(dir+"\\script-videos\\", "Verify-Order-Summary-" + dateFormat.format(date), false);

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
			// log(Status, details)
			test.log(Status.INFO, result.getThrowable().getMessage());
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			test.log(Status.INFO, clsName+" Passed");
	}

	@AfterClass
	public void tearDown() throws ATUTestRecorderException{
		recorder.stop();
		driver.close();
		// calling flush writes everything to the log file
		extent.flush();
	}

}
