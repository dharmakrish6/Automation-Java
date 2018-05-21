package moolya.embibe.tests.web.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class LandingPageReturningUserTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;

	{
		uniqueValue = "Sanity_2";
	}
	
	@Test(dataProvider="browserData")
	public void landingPageReturningUserTest(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: LandingPageReturningUserTest", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.closeIntercom();
		shp.assertSearchHomepage();
		shp.clearCookies();
		lp = shp.goToLandingPage();
		lp.mouseHoverOnKt();
		shp.closeIntercom();
		shp = lp.clickSearchNow();
		shp.assertSearchHomepage();
	}
}
