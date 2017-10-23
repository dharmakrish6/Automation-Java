package moolya.embibe.tests.web.functional.landingPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class LandingPageTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;

	@Test(dataProvider="browserData")
	public void LandingPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : LandingPage Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		lp.landingPageEmbibeLogo();	
		lp.scoreHigher_StartNow_Text();
		lp.startLearning_SearchNow_Text();
		lp.scrollLeft();
		lp.scrollRight();
		lp.clickStartNow();
		lp.refreshPage();
		lp.assertSearchHomepage();
		lp.clearCookies();
		lp.goToLandingPage();
		lp.assertLandingPage();
		lp.mouseHoverOnKt();
		lp.clickSearchNow();
		lp.assertSearchHomepage();
	}
}