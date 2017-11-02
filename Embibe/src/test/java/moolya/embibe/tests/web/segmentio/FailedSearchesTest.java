package moolya.embibe.tests.web.segmentio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.JavaUtils;
import moolya.embibe.utils.SqliteUtils;

public class FailedSearchesTest {
	
	private LandingPage lp;
	private W_BasePage basepage;
	private WebDriver wdriver;
	private SearchHomepage shp;
	private String SearchText = "Motion of satellite";
	private String SearchText2 = "Ray Optics";
	private String uniqueValue = "MeasurabilityFlow3";
	private SearchResultsPage srp;
	private String count;
	private String email;
	
	@Test(invocationCount=1)
	@Parameters({"browser"})
	public void failedSearchesTest(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.enterSearchText(SearchText);
		srp = new SearchResultsPage(wdriver);
		srp.waitForSearchResultsPage();
		srp.goToRearchPage();
//		shp.waitforSearchHomePage();
		shp.enterSearchText(SearchText2);
		srp.waitForSearchResultsPage();
	}
	
	@AfterMethod
	public void tearDown() throws EncryptedDocumentException, InvalidFormatException, IOException, ClassNotFoundException{
		lp = new LandingPage(wdriver);
		
		ArrayList<LinkedHashMap<String, String>> results = lp.getEventLogs(this.getClass().getSimpleName());

		ArrayList<String> msgIds = SqliteUtils.storeSegmentIoResultsToDb(results);
		for(String id:msgIds)
			System.out.println("Message Id: "+id);
		
		wdriver.close();
	}

}
