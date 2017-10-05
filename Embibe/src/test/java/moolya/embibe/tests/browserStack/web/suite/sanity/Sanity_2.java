package moolya.embibe.tests.browserStack.web.suite.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.tests.browserStack.BrowserStackTestNGTest;

public class Sanity_2 extends BrowserStackTestNGTest {

	private LandingPage lp;
	private SearchHomepage shp;

	{
		uniqueValue = "Sanity_2";
	}
	
	@Test
	public void Sanity_2test() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		Reporter.log("Starting Test: Sanity_2test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.clearCookies();
		lp = shp.goToLandingPage();
		lp.mouseHoverOnKt();
		shp = lp.clickSearchNow();
		shp.assertSearchHomepage();
	}
}
