package moolya.embibe.tests.web.functional.askPage;

import java.awt.AWTException;
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

public class AskPageTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private AskPage ap;
	
	@Test(dataProvider="browserData")
	public void AskPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Ask Page Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.closeIntercom();
		shp.assertSearchHomepage();
		ap = shp.verifyAskLink();//SHP_Func_85
		shp = ap.clickAskEmbibeLogo();//SHP_Func_87
		ap = shp.verifyAskLink();
		Reporter.log("--------------------------Guest user asking question---------------------",true);
		ap.guestAskQuestion("Physics Topic");//SHP_Func_86
		Thread.sleep(2000);
		Reporter.log("--------------------------Login user asking question---------------------",true);
		ap.askLogin_viaQues();
		Reporter.log("------------------------------------------------------------------",true);
		Thread.sleep(2000);
		ap.guestAskQuestion("Physics Topic");//SHP_Func_86
		ap.verifyAskSuccessful();
	}
}
