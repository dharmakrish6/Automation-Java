package moolya.embibe.tests.browserStack.web.suite.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.tests.browserStack.BrowserStackTestNGTest;

public class Sanity_6 extends BrowserStackTestNGTest {

	private LandingPage lp;
	private SearchHomepage shp;
	String searchKeyword;
	String searchText;

	{
		uniqueValue = "Sanity_6";
	}
	
	@Test
	public void Sanity_6test() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		Reporter.log("Starting Test: Sanity_6test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.login(uniqueValue);
		shp.verifyLogin();
		shp.assertSearchHomepage();
	}
}
