package moolya.embibe.tests.web.mobileEmulation.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.mobile.LandingPage;
import moolya.embibe.pages.web.mobile.SearchHomepage;
import moolya.embibe.pages.web.mobile.W_BasePage;
import moolya.embibe.tests.web.mobileEmulation.W_BaseTest;


public class Sanity_2 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;

	{
		uniqueValue = "Sanity_2";
	}
	
	@Test(dataProvider="browserData")
	public void Sanity_2test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchChromeMobileEmulator();
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
