package moolya.embibe.tests.web.test;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.SinhalTestsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.JavaUtils;

public class SinhalTests19{
	
	private String fileName = "SinhalAitsCorrectAnswersSheet.xlsx";
	private WebDriver wdriver;
	private W_BasePage basepage;
	private SinhalTestsPage stp;
	private String userSheetName = "Users19";
	
	@Test(dataProvider="getData")
	public void sinhalTests(String email) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchSinhalAitsApp("chrome");
		stp = new SinhalTestsPage(wdriver);
		Reporter.log("Starting Test: SinhalAitsTests", true);
		HashMap<String, String> userData = JavaUtils.readExcelData(fileName, userSheetName, email);
		stp.loginToSinhal(userData.get("Email"), userData.get("Password"));
		HashMap<String, String> examData = JavaUtils.readExcelData(fileName, "Tests", userData.get("Exam"));
		stp.navigateToSinhalTestXpath(examData.get("Goal"),userData.get("Exam"));
		stp.beginTest();
		stp.takeTest(examData, fileName);
		stp.finishTest();
//		stp.closeLoginPopUp();
		stp.getTestScore();
	}
	
	@DataProvider(parallel=true)
	public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = EmbibeUtils.readSinhalTestUniqueValues(userSheetName);
		return obj;
	}
	
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
			} catch (IOException e) {}
		}
		else
			Reporter.log("Test: "+result.getName()+" Passed!", true);
		
		try {
			File file = new File(System.getProperty("java.io.tmpdir"));
			FileUtils.cleanDirectory(file);
		}catch (IOException e) {}
		wdriver.close();
	}
}
