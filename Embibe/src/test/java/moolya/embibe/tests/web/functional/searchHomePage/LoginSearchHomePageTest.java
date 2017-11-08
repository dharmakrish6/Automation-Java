package moolya.embibe.tests.web.functional.searchHomePage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class LoginSearchHomePageTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	{
		uniqueValue = "Sanity_3";
		uniqueValue2 = "Sanity_12";
	}

	@Test(dataProvider="browserData")
	public void SearchHomePage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : SearchHomePage Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		/*shp.login();
		shp.header_guestIcons();
		shp.searchEngineSection();
		shp.searchFooterLinks(1,"JEE Main",jeeMain_URL);
		shp.searchFooterLinks(2,"JEE Advanced",jeeAdvanced_URL);
		shp.searchFooterLinks(3,"BITSAT",bitsat_URL);
		shp.searchFooterLinks(4,"NEET",neet_URL);
		shp.clickNextSwiper();
		shp.searchFooterLinks(5,"AIIMS",aiims_URL);
		shp.clickPrevSwiper();*/
		shp.assert_findSomethingCool();
		shp.assert_preciseLocation();
	}
}
