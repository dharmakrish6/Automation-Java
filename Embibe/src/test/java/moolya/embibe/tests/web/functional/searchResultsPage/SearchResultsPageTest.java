package moolya.embibe.tests.web.functional.searchResultsPage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SearchResultsPageTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	{
		uniqueValue = "Sanity_3";
		uniqueValue2 = "Sanity_12";
	}
	
	@Test(dataProvider="browserData")
	public void SearchRequestPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Request Page Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.disappearFloatingKeywords(uniqueValue);//SHP_5
		shp.autoFillSearchResults();//SHP_9
		shp.clickEmbibeLogo();
		shp.assertSearchHomepage();
		shp.wrongKeywordInSearchField();//SHP_11
		shp.searchInNewTab(uniqueValue);//SHP_8
		shp.correctKeywordInSearchField();//SHP_12
		//shp.noResultsFound();//SHP_14,No results page
		shp.clickEmbibeLogo();
		shp.assertSearchHomepage();
		shp.guestGoalIcon();//SHP_15
		shp.validSearchResult(uniqueValue2);//SHP_17
		
	}
}
