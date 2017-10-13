package moolya.embibe.tests.web.functional.searchResultsPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SRP_Func_3 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	{
	uniqueValue2 = "Sanity_12";
	}
	@Test(dataProvider="browserData")
	public void SHP_Func_100_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_100 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
//		srp=shp.validSearchResult(uniqueValue2);
		
		srp.showingResults_Goals();
		srp.clickGoalExpandButton();
		srp.showingResults_Goals();
		srp.clickGoalCollapseButton();
		srp.showingResults_Goals();
		
		srp.select_showingResults_Goal(1);
		srp.getspecificExamsList();
		srp.clickExamExpandButton();
		srp.getspecificExamsList();
		srp.clickExamCollapseButton();
		
		srp.select_showingResults_Goal(2);
		srp.getspecificExamsList();
		srp.clickExamExpandButton();
		srp.getspecificExamsList();
		srp.clickExamCollapseButton();
		
		srp.select_showingResults_Goal(3);
		srp.getspecificExamsList();
		srp.clickExamExpandButton();
		srp.getspecificExamsList();
		srp.clickExamCollapseButton();
		
		srp.select_showingResults_Goal(4);
		srp.getspecificExamsList();
		srp.clickExamExpandButton();
		srp.getspecificExamsList();
		srp.clickExamCollapseButton();
	}
}
