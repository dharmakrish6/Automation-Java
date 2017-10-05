package moolya.embibe.tests.browserStack.web.suite.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.browserStack.BrowserStackTestNGTest;

public class Sanity_3 extends BrowserStackTestNGTest {

	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;

	{
		uniqueValue = "Sanity_3";
	}
	
	@Test
	public void Sanity_3test() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		Reporter.log("Starting Test: Sanity_3test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		srp = shp.search(uniqueValue);
		srp.assertSearchResultsPage(uniqueValue);
	}
}
