package moolya.embibe.tests.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testautomationguru.ocular.Ocular;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.W_BasePage;

public class W_BaseTest 
{

public WebDriver wdriver;
	
	W_BasePage basepage;
	protected String uniqueValue;
	ATUTestRecorder recorder;
	
	@BeforeMethod
	public void setUp() throws IOException, ATUTestRecorderException{
//		String dir = System.getProperty("user.dir");
//		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
//		Date date = new Date();
//		if(!new File(dir+"\\script-videos").exists())
//			new File(dir+"\\script-videos").mkdirs();
//		Ocular.config()
//			.snapshotPath(Paths.get(".", "src/test/resources", "ocularExpected"))
//			.resultPath(Paths.get(".", "src/test/resources", "ocularResults"))
//			.globalSimilarity(95)
//			.saveSnapshot(true);
//		recorder = new ATUTestRecorder(dir+"\\script-videos\\", this.getClass().getSimpleName()+ "-" + dateFormat.format(date), false);
		// To start video recording.
	}
	
	@AfterMethod
	@Parameters({"browser"})
	public void catchExceptions(ITestResult result,@Optional("chrome") String browser) throws IOException, InterruptedException, ATUTestRecorderException 
	{    
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		if(!result.isSuccess()){            
			File scrFile = ((TakesScreenshot)wdriver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+this.getClass().getSimpleName()+"-"+dateFormat.format(date)+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		wdriver.quit();
//		recorder.stop();
	}
}
