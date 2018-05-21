package moolya.embibe.tests.web.functional.staticpages;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.InstitutePage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.RankupPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class InstitutePageNavigationsTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private InstitutePage ip;
	
	@Test(dataProvider="browserData")
	public void rankupPageNavigation_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Rankup page navigations on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		//shp.closeIntercom();
		shp.assertSearchHomepage();
		Reporter.log("==========================Institute Page Navigations========================",true);
		ip=shp.clickInstitutes();
		ip.contactus();
		ip.login();
		ip.signupForFree();
		ip.requestDemo1();
		ip.tab1Navigation();
		ip.tab2Navigation();
		ip.tab3Navigation();
		ip.tab4Navigation();
		ip.professorsIntroVideo();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
