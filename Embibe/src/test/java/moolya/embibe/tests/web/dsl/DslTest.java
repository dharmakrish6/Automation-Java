package moolya.embibe.tests.web.dsl;

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

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.DslPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;

public class DslTest{

	private LandingPage lp;
	private DslPage dslp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private String stream = "NA";
	private WebDriver wdriver;
	private W_BasePage basepage;


	@Test(dataProvider="getDslActualData")
	public void dslTest(String row,String uniqueValue,String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		HashMap<String, Object> dslData;
		HashMap<String, Object> actualData;
		HashMap<String, Object> resultData;
		String text = uniqueValue;
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchDsl(browser);
		dslp = new DslPage(wdriver);
		dslData = dslp.searchQuery(text,stream);
		lp = basepage.goToLandingPage();
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		if(!stream.equalsIgnoreCase("na"))
			shp.login();
		boolean disambiguated = Boolean.parseBoolean(String.valueOf(dslData.get("Disambiguated"))); 
		actualData = shp.searchForDsl(disambiguated, text);
		if(disambiguated){
			srp = new SearchResultsPage(wdriver);
			String resultText = srp.getSearchResultText();
			System.out.println(resultText);
			actualData.put("Actual Result", resultText);
			actualData.put("Target Page", "Search Results Page");
		}
		resultData = dslData;
		String status;
		if(dslData.get("Dsl Result").toString().equalsIgnoreCase(actualData.get("Actual Result").toString()))
			status = "Pass";
		else
			status = "Fail";
		resultData.put("Actual Result", actualData.get("Actual Result"));
		resultData.put("Status", status);
		shp.writeDslActualData("top1000SearchTerms", resultData, Integer.parseInt(row)+1);
	}

	@DataProvider
	public Object[][] getDslActualData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		obj = W_BasePage.readDslUniqueValues("top1000SearchTerms");
		for(int i=0;i<obj.length;i++)
			obj[i][2] = "chrome";
		return obj;
	}

	@AfterMethod
	public void catchExceptions(ITestResult result) throws IOException, InterruptedException, ATUTestRecorderException 
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

		try {
			File file = new File(System.getProperty("java.io.tmpdir"));
			FileUtils.cleanDirectory(file);
		}catch (IOException e) {
			// Do nothing since we do not worry about the files that cannot be deleted
			// Include exception handler logic if you want to
		}
	}


}
