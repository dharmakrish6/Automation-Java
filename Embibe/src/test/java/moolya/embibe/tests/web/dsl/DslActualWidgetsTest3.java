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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

public class DslActualWidgetsTest3 {

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
	private String goalCode = "gl9";	// Enrg=gl8,Medical=gl9
	private String examCode = "na";	// Bitsat=ex6,Jipmer=ex58
	HashMap<String, String> goalExamMap = new HashMap<String, String>(){{
		put("gl8", "Engineering");put("gl9","Medical");
		put("ex6","BITSAT");put("ex58","JIPMER");
		put("ex9","NEET");put("ex4","JEE Main");
	}};
	String goal;
	String exam;
	String sheetName = "Sheet3";

	@Test(dataProvider="getDslActualData")//String row,String uniqueValue,String browser
	public void dslWidgetsTest(String row,String uniqueValue) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException, JSONException {
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
		System.out.println((Integer.parseInt(row)+1)+" Started");
		String text = uniqueValue;
		dslp = new DslPage(wdriver);
		dslData = dslp.getSearchQueryJson(text,goalCode,examCode,10);
		resultData = dslData;
		resultData.put("Goal", goal);
		resultData.put("Exam", exam);
		lp = basepage.goToLandingPage();
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
//		shp.loginWithGoal(goal);
		boolean disambiguated = Boolean.parseBoolean(String.valueOf(dslData.get("Disambiguated")));
		boolean dymValid = Boolean.parseBoolean(String.valueOf(dslData.get("Dym")));
		try {
			actualData = shp.searchForDsl(disambiguated,dymValid, text);
			if(disambiguated && !dymValid){
				srp = new SearchResultsPage(wdriver);
				String resultText = "";
				resultText = srp.getSearchResultTopicHeader();
				srp.selectGoal(goal, exam);
				actualData.put("Actual Current Goal", srp.getCurrentGoal());
				actualData.put("Actual Current Exam", srp.getCurrentExam());
				actualData.put("Actual Valid Goals", srp.getValidGoals());
				actualData.put("Actual Valid Exams", srp.getValidExams());
				String actualWidgets = srp.getWidgetsOrder(10);
				actualData.put("Target Page", "Search Results Page");
				actualData.put("Actual Result", resultText);
				actualData.put("Actual Widgets", actualWidgets);
			}
			else if(!disambiguated && dymValid){
				srp = new SearchResultsPage(wdriver);
				String terms = srp.getDymAlaTerms(dslData.get("Dym Type"));
				actualData.put("Target Page", "Search Results Page");
				actualData.put("Actual Dym Terms", terms);
				String results = srp.getSuggestions();
				actualData.put("Actual Result", results);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			resultData = JavaUtils.addDataToResult("Actual Result", actualData.get("Actual Result"), resultData);
			resultData = JavaUtils.addDataToResult("Actual Widgets", actualData.get("Actual Widgets"), resultData);
			resultData = JavaUtils.addDataToResult("Actual Dym Terms", actualData.get("Actual Dym Terms"), resultData);
			resultData = JavaUtils.addDataToResult("Actual Current Goal", actualData.get("Actual Current Goal"), resultData);
			resultData = JavaUtils.addDataToResult("Actual Current Exam", actualData.get("Actual Current Exam"), resultData);
			resultData = JavaUtils.addDataToResult("Actual Valid Goals", actualData.get("Actual Valid Goals"), resultData);
			resultData = JavaUtils.addDataToResult("Actual Valid Exams", actualData.get("Actual Valid Exams"), resultData);
		} catch (Exception e) {}
		String result = JavaUtils.getResultStatus(resultData);
		String[] status = result.split("=");
		resultData.put("Status", status[0]);
		if(status.length>1)
			resultData.put("Comments", status[1]);
		resultData.put("Ip", EmbibeUtils.getPublicIp());
		EmbibeUtils.writeDslActualData(sheetName, resultData, Integer.parseInt(row)+1);
		System.out.println(getClass().getSimpleName()+": "+(Integer.parseInt(row)+1)+" "+status[0]);
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
		try{
			wdriver.quit();
		}catch(Exception e){
			wdriver.close();
		}
	}
	
}
