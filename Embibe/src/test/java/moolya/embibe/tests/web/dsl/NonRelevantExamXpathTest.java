package moolya.embibe.tests.web.dsl;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.json.JSONException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.DslPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;

public class NonRelevantExamXpathTest {
	String uniqueValue = "physics test";
	String examCode = "ex4";
	private WebDriver wdriver;
	private W_BasePage basepage;
	private String exam;
	private DslPage dslp;
	

//	@BeforeTest
	public void setup() throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchDsl("chrome");
		if(examCode.equalsIgnoreCase("na"))
			exam=examCode;
		else
			exam = EmbibeUtils.examsMap.get(examCode);
	}

	
	@SuppressWarnings("unchecked")
	@Test
	public void nonRelevantExamXpathTest() throws IOException, JSONException{
//		String text = uniqueValue;
//		dslp = new DslPage(wdriver);
//		LinkedHashMap<String, Object> data = dslp.getTestXpaths(text, examCode);
//		System.out.println(data.get("Current Exam"));
		String url = "https://preprod.embibe.com/study/organic-chemistry-unit?entity_code=un51";
		String response = EmbibeUtils.getLearnApiResponse(url);
		LinkedHashMap<String, Object> data = EmbibeUtils.getTestXpaths(response);
		Set<String> xpaths = (Set<String>)data.get("Xpaths");
		for(String xpath:xpaths)
			System.out.println(xpath);
		System.out.println(data.get("Status"));
	}
	
//	@AfterMethod
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
	
//	@AfterTest
	public void tearDown(){
		try{
			wdriver.quit();
		}catch(Exception e){
			wdriver.close();
		}

	}

}
