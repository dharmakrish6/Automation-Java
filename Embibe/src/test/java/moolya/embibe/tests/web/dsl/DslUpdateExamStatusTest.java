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

import moolya.embibe.pages.web.DslPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.JavaUtils;

public class DslUpdateExamStatusTest {

	private LandingPage lp;
	private DslPage dslp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private String stream = "NA";
	private WebDriver wdriver;
	private W_BasePage basepage;
	LinkedHashMap<String, String> data;
	LinkedHashMap<String, String> resultData;
	private String sheetName = "Sheet3";

	@Test(dataProvider="getDslActualData")//String row,String uniqueValue,String browser
	public void dslWidgetsTest(String row,String uniqueValue) throws IOException, NoSuchFieldException, SecurityException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException, JSONException {
		data = EmbibeUtils.readDslExcelData(sheetName, Integer.parseInt(row)+1);
		String goal = data.get("Goal");
		String exam = data.get("Exam");
		String currentExam = data.get("Current Exam");
		String examStatus = "";
		if(goal.equals("Engineering") && exam.equals("BITSAT") 
				&& (currentExam.equals("BITSAT") || currentExam.equals(null) || currentExam.equals("")))
			examStatus = "Pass";
		else if(goal.equals("Medical") && exam.equals("JIPMER") 
				&& (currentExam.equals("JIPMER") || currentExam.equals(null) || currentExam.equals("")))
			examStatus = "Pass";
		else if(goal.equals("Engineering") && exam.equals("NEET") 
				&& (currentExam.equals(null) || currentExam.equals("")))
			examStatus = "Pass";
		else if(goal.equals("Medical") && exam.equals("JEE Main") 
				&& (currentExam.equals(null) || currentExam.equals("")))
			examStatus = "Pass";
		else if(goal.equals("Engineering") && exam.equals("na") 
				&& (currentExam.equals("JEE Main") || currentExam.equals(null) || currentExam.equals("")))
			examStatus = "Pass";
		else if(goal.equals("Medical") && exam.equals("na") 
				&& (currentExam.equals("NEET") || currentExam.equals(null) || currentExam.equals("")))
			examStatus = "Pass";
		else
			examStatus = "Fail";
		resultData = new LinkedHashMap<String, String>();
		resultData.put("Exam Status", examStatus);	
		EmbibeUtils.writeDslActualData(sheetName, resultData, Integer.parseInt(row)+1);
		System.out.println((Integer.parseInt(row)+1)+" completed");
	}

	@DataProvider
	public Object[][] getDslActualData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		obj = EmbibeUtils.readDslUniqueValues(sheetName);
		return obj;
	}
	
}
