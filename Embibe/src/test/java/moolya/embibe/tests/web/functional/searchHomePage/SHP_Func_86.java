package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.AskPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SHP_Func_86 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private AskPage ap;

	@Test(dataProvider="browserData")
	public void SHP_Func_86_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_86 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		ap=shp.verifyAskLink();
		ap.guestAskQuestion("embibe1234");
		Thread.sleep(2000);
		ap.askLoginWindow_via_askQues("yatheendra@moolya.com", "moolya123");
		Thread.sleep(2000);
		Thread.sleep(2000);
		ap.askPageLogout();
	}
}
