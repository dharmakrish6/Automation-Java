package moolya.embibe.tests.web.dsl;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.DslPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class DslTest extends W_BaseTest {
	
	private LandingPage lp;
	private DslPage dslp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	

	@Test(dataProvider="getDslActualData")
	public void dslTest(String row,String uniqueValue,String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		HashMap<String, Object> dslData;
		HashMap<String, Object> actualData;
		HashMap<String, Object> resultData;
		String text = uniqueValue;
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchDsl(browser);
		dslp = new DslPage(wdriver);
		dslData = dslp.searchQuery(text);
		lp = basepage.goToLandingPage();
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.login();
		boolean disambiguated = Boolean.parseBoolean(String.valueOf(dslData.get("Disambiguated"))); 
		actualData = shp.searchForDsl(disambiguated, text);
		if(disambiguated){
			srp = new SearchResultsPage(wdriver);
			String topicHeader = srp.getSearchResultTopicHeader();
			System.out.println(topicHeader);
			actualData.put("Actual Result", topicHeader);
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
	
	
}
