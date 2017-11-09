package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.FootersPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;
import moolya.embibe.utils.JavaUtils;

public class Login_SearchHomePageTest extends W_BaseTest {

	private static String rearchURL;
	private static String jeeMain_URL;
	private static String neet_URL;
	private static String aiims_URL;
	private static String jeeAdvanced_URL;
	private static String bitsat_URL;
	private W_BasePage basepage;
	private LandingPage lp;
	private FootersPage lfp;
	private SearchHomepage shp;
	static{
		try {
			rearchURL = JavaUtils.getPropValue("testAppUrl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jeeMain_URL=rearchURL+"exams/jee-main/";
		neet_URL=rearchURL+"exams/neet/";
		aiims_URL=rearchURL+"exams/aiims/";
		jeeAdvanced_URL=rearchURL+"exams/iit-jee-advanced/";
		bitsat_URL=rearchURL+"exams/bitsat/";
	}

	@Test(dataProvider="browserData")
	public void LoginSearchHomePage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Login SearchHomePage Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		lfp=shp.loginFooters();
		lfp.header_loginUserIcons();
		lfp.login_searchEngineSection();
		lfp.loginuser_searchFooterLinks(1,"JEE Main",jeeMain_URL);
		lfp.loginuser_searchFooterLinks(2,"JEE Advanced",jeeAdvanced_URL);
		lfp.loginuser_searchFooterLinks(3,"BITSAT",bitsat_URL);
		lfp.loginuser_searchFooterLinks(4,"NEET",neet_URL);
		lfp.clickNextSwiper();
		lfp.loginuser_searchFooterLinks(5,"AIIMS",aiims_URL);
		lfp.clickPrevSwiper();
		lfp.assert_findSomethingCool();
		lfp.assert_preciseLocation();
	}
}
