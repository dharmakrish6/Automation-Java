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
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testautomationguru.ocular.Ocular;

import moolya.embibe.pages.web.W_BasePage;

public class W_BaseTest 
{

public WebDriver wdriver;
	
	protected W_BasePage basepage;
	protected String uniqueValue;
	protected String uniqueValue2;
	
	/*@BeforeTest
	public void setUp() throws IOException, ATUTestRecorderException{
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		if(!new File(dir+"\\script-videos").exists())
			new File(dir+"\\script-videos").mkdirs();
		Ocular.config()
			.snapshotPath(Paths.get(".", "src/test/resources", "ocularExpected"))
			.resultPath(Paths.get(".", "src/test/resources", "ocularResults"))
			.globalSimilarity(95)
			.saveSnapshot(true);
		recorder = new ATUTestRecorder(dir+"\\script-videos\\", this.getClass().getSimpleName()+ "-" + dateFormat.format(date), false);
		// To start video recording.
	}*/
	
	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException 
	{    
		String dir = System.getProperty("user.dir");
		if(!new File(dir+"\\screenshots").exists())
			new File(dir+"\\screenshots").mkdirs();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		if(!result.isSuccess()){
			Reporter.log("Test: "+result.getName()+" Failed!", true);
			File scrFile = ((TakesScreenshot)wdriver).getScreenshotAs(OutputType.FILE);
			String file =dir+"/screenshots/"+this.getClass().getSimpleName()+"-"+dateFormat.format(date)+".png";
			try {
				FileUtils.copyFile(scrFile, new File(file));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			Reporter.log("Test: "+result.getName()+" Passed!", true);
		try{
			wdriver.quit();
		}catch(Exception e){
			wdriver.close();
		}
	}
	
	/*@AfterTest
	public void tearDown(){
		
	}*/
	
	@DataProvider
	public Object[][] browserData(){
		//	"chrome","ff","ieWinx32","ieWinx64","opera32","opera64"
		String[] browsers = {"chrome","ff","opera32","ieWinx32"}; 
		Object[][] obj = new Object[browsers.length][1];
		for(int i=0;i<browsers.length;i++)
			obj[i][0]=browsers[i];
		return obj;
	}
	
	
	
}
