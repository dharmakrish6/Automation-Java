package moolya.embibe.tests.mobile;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import moolya.embibe.pages.mobile.android.MW_BasePage;
import moolya.embibe.pages.mobile.android.MW_SuperBasePage;
import moolya.embibe.utils.AppiumServiceUtils;

public class M_BaseTest {

	public AppiumDriver<WebElement> mdriver;
	AppiumServiceUtils service;

	MW_BasePage basepage;
	private MW_SuperBasePage superbasepage;
	public String uniqueValue;
	

	@BeforeMethod
	public void setUp() throws Exception{
		service = new AppiumServiceUtils();
		service.service.start();
		superbasepage = new MW_SuperBasePage(mdriver);
		mdriver = superbasepage.launchmobApp(this.getClass().getPackage().getName());
	}
	
	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException 
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
		mdriver.quit();
		service.service.stop();
	}

}
