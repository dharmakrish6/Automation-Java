package moolya.embibe.tests.web.dsl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.DslPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.JavaUtils;

public class DslActualWidgetsTest {

	private LandingPage lp;
	private DslPage dslp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private String stream = "NA";
	private WebDriver wdriver;
	private W_BasePage basepage;
	LinkedHashMap<String, String> dslData;
	LinkedHashMap<String, String> actualData;
	LinkedHashMap<String, String> resultData;
	private String goalCode = "gl8";	// Enrg=gl8,Medical=gl9
	private String examCode = "na";	// Bitsat=ex6,Jipmer=ex58
	String sheetName = "top1000SearchTerms";

	@BeforeTest
	public void setup() throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchDsl("chrome");
	}

	@Test(dataProvider="getDslActualData")//String row,String uniqueValue,String browser
	public void dslWidgetsTest(String row,String uniqueValue) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException, JSONException {
		String text = uniqueValue;
		dslp = new DslPage(wdriver);
		dslData = dslp.getSearchQueryJson(text,goalCode,examCode,20);
		resultData = dslData;
//		lp = basepage.goToLandingPage();
//		lp.waitForLandingPageToLoad();
//		shp = lp.clickStartNow();
//		if(!stream.equalsIgnoreCase("na"))
//			shp.login();
//		boolean disambiguated = Boolean.parseBoolean(String.valueOf(dslData.get("Disambiguated"))); 
//		try {
//			actualData = shp.searchForDsl(disambiguated, text);
//			if(disambiguated){
//				srp = new SearchResultsPage(wdriver);
//				String resultText = "";
//				resultText = srp.getSearchResultTopicHeader();
//				String actualWidgets = srp.getWidgetsOrder(10);
//				actualData.put("Target Page", "Search Results Page");
//				actualData.put("Actual Result", resultText);
//				actualData.put("Actual Widgets", actualWidgets);
//			}
//		} catch (Exception e) {}
//		String status;
//		if(actualData!=null 
//				&& dslData.get("Dsl Result").toString().equalsIgnoreCase(actualData.get("Actual Result").toString()))
//			status = "Pass";
//		else
//			status = "Fail";
//		try {
//			resultData.put("Actual Result", actualData.get("Actual Result"));
//			resultData.put("Actual Widgets", actualData.get("Actual Widgets"));
//		} catch (Exception e) {}
//		resultData.put("Status", status);
//		String[] dslWidgets = dslData.get("Dsl Widgets").split(",");
//		for(int i=0;i<dslWidgets.length;i++){
//			String[] widget = dslWidgets[i].split("=");
//			try {
//				resultData.put("Dsl Widget Type "+(i+1), widget[0]);
//			} catch (Exception e) {}
//			try {
//				resultData.put("Dsl Widget Name "+(i+1), widget[1]);
//			} catch (Exception e) {}
//			try {
//				resultData.put("Dsl Widget Value "+(i+1), widget[2]);
//			} catch (Exception e) {}
//		}
//		String[] actualWidgets = actualData.get("Actual Widgets").split(",");
//		for(int i=0;i<actualWidgets.length;i++){
//			String[] widget = actualWidgets[i].split("=");
//			try {
//				resultData.put("Actual Widget Type "+(i+1), widget[0]);
//			} catch (Exception e) {}
//			try {
//				resultData.put("Actual Widget Name "+(i+1), widget[1]);
//			} catch (Exception e) {}
//			try {
//				resultData.put("Actual Widget Value "+(i+1), widget[2]);
//			} catch (Exception e) {}
//		}
		EmbibeUtils.writeDslActualData(sheetName, resultData, Integer.parseInt(row)+1);
	}

	@DataProvider
	public Object[][] getDslActualData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		obj = EmbibeUtils.readDslUniqueValues(sheetName);
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
			} catch (IOException e) {}
		}
		else
			Reporter.log("Test: "+result.getName()+" Passed!", true);
		
		try {
			File file = new File(System.getProperty("java.io.tmpdir"));
			FileUtils.cleanDirectory(file);
		}catch (IOException e) {}
//		wdriver.navigate().to(JavaUtils.getPropValue("dslUrl"));
	}
	
	@AfterTest
	public void tearDown(){
		try{
			wdriver.quit();
		}catch(Exception e){
			wdriver.close();
		}

	}
	
}
