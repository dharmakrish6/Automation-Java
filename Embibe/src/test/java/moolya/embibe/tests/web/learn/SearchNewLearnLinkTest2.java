package moolya.embibe.tests.web.learn;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.NewLearnPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;

public class SearchNewLearnLinkTest2 {

	LinkedHashMap<String, String> resultData;
	private WebDriver wdriver;
	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private NewLearnPage nlp;
	String sheetName = "Concepts";

	@Test(dataProvider="getNewUrls")
	public void searchNewLearnLinkTest(String row,String uniqueValue) throws IOException, NoSuchFieldException, SecurityException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException, JSONException {
//		String uniqueValue = "heart";
		String text = uniqueValue;
		resultData = new LinkedHashMap<String,String>();
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp("chrome");
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.enterSearchText(text);
		try {
			srp = new SearchResultsPage(wdriver);
			nlp = srp.clickLearnMore();
			boolean flag = nlp.checkForLearnPageLoad();
			String link = nlp.getCurrentUrl();
			if(flag)
				resultData.put("Status", "Pass");
			else
				resultData.put("Status", "Fail");
			resultData.put("Link", link);
		} catch (Exception e) {
			resultData.put("Status", "Error in search");
		}
		EmbibeUtils.writeDslActualData(sheetName, resultData, Integer.parseInt(row)+1);
	}

	@DataProvider
	public Object[][] getNewUrls() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		obj = EmbibeUtils.readDslUniqueValues(sheetName);
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
		try{
			wdriver.quit();
		}catch(Exception e){
			wdriver.close();
		}
	}
	
}
