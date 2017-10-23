package moolya.embibe.tests.web.mobileEmulation.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.mobile.LandingPage;
import moolya.embibe.pages.web.mobile.SearchHomepage;
import moolya.embibe.pages.web.mobile.SearchResultsPage;
import moolya.embibe.pages.web.mobile.W_BasePage;
import moolya.embibe.tests.web.mobileEmulation.W_BaseTest;


public class Sanity_3 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;

	{
		uniqueValue = "Sanity_3";
	}
	
	@Test(dataProvider="browserData")
	public void Sanity_3test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchChromeMobileEmulator();
		Reporter.log("Starting Test: Sanity_3test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		srp = shp.search(uniqueValue);
		srp.assertSearchResultsPage(uniqueValue);
	}
}
