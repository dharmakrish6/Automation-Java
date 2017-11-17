package moolya.embibe.tests.web.dsl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
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

public class DymTest {
	
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
	private String examCode = "ex6";	// Bitsat=ex6,Jipmer=ex58,NEET=ex9,JEE Main=ex4
	HashMap<String, String> goalExamMap = new HashMap<String, String>(){{
		put("gl8", "Engineering");put("gl9","Medical");
		put("ex6","BITSAT");put("ex58","JIPMER");
		put("ex9","NEET");put("ex4","JEE Main");
	}};
	String goal;
	String exam;
	String sheetName = "top1000SearchTerms";
	
	@BeforeTest
	public void setup() throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchDsl("chrome");
		if(goalCode.equalsIgnoreCase("na"))
			goal=goalCode;
		else
			goal = goalExamMap.get(goalCode);
		if(examCode.equalsIgnoreCase("na"))
			exam=examCode;
		else
			exam = goalExamMap.get(examCode);
	}

	@Test(dataProvider="getDslActualData")//String row,String uniqueValue,String browser
	public void dymTest(String row,String uniqueValue) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException, JSONException {
		String text = uniqueValue;
		dslp = new DslPage(wdriver);
		dslData = dslp.getSearchQueryJson(text,goalCode,examCode,20);
		resultData = dslData;
		resultData.put("Goal", goal);
		resultData.put("Exam", exam);
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
