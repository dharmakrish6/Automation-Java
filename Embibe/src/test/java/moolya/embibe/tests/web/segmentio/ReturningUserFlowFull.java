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

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.SqliteUtils;

public class ReturningUserFlowFull{

	String os;
	private LandingPage lp;
	private W_BasePage basepage;
	private WebDriver wdriver;
	private SearchHomepage shp;
	private String SearchText = "adiabatic";
	private SearchResultsPage srp;
	
	@Test(invocationCount=20)
	@Parameters({"browser"})
	public void flow2Test(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.refreshPage();
		shp = new SearchHomepage(wdriver);
		shp.enterSearchText(SearchText);
		shp.hoverOnFloatingKeywords(1);
		srp = shp.clickOnFloatingKeywords(2);
		srp.waitForResultTopicHeader();
	}
	
	@AfterMethod
	public void tearDown() throws EncryptedDocumentException, InvalidFormatException, IOException, ClassNotFoundException{
		lp = new LandingPage(wdriver);
		
		ArrayList<LinkedHashMap<String, String>> results = EmbibeUtils.getEventLogs(wdriver, this.getClass().getSimpleName());
		
		ArrayList<String> msgIds = SqliteUtils.storeSegmentIoResultsToDb(results);
		for(String id:msgIds)
			System.out.println("Message Id: "+id);
		
		wdriver.close();
	}

}
