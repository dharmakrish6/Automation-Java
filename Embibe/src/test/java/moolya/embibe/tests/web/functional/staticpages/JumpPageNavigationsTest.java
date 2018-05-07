package moolya.embibe.tests.web.functional.staticpages;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.JumpPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class JumpPageNavigationsTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private JumpPage jp;
	
	@Test(dataProvider="browserData")
	public void jumpPageNavigation_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Jump page navigations on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		Thread.sleep(20000);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		//shp.closeIntercom();
		shp.assertSearchHomepage();
		Reporter.log("==========================Login-Logout in Jump Page========================",true);
		jp=shp.clickJump();
		Reporter.log("------------------------------------------Get Jump Navigation------------------------------------------",true);
		jp.getJumpNavigation();
		jp.tab1Navigation();
		jp.tab2Navigation();
		jp.tab3Navigation();
		jp.tab4Navigation();
		jp.exploreRankup();
		jp.successStories();
		jp.openUnlockBtn();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
