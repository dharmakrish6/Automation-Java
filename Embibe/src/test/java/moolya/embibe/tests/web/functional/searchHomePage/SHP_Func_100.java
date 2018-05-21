package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SHP_Func_100 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;

	@Test(dataProvider="browserData")
	public void SHP_Func_100_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_100 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		String mainWindow = shp.getMainWindowHandle();
		shp.clickFacebookIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertFacebookEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.clickTwitterIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertTwitterEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.clickInstagramIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertInstagramEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.clickYoutubeIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertYoutubeEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		
	}
}
