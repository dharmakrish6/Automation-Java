package moolya.embibe.tests.web.functional.staticpages;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.RankupPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class RankupPageNavigationsTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private RankupPage rup;
	
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
		rup=shp.clickRank();
		rup.applyToRankup1();
		rup.applyToRankup2();
		rup.applyToRankup3();
		Reporter.log("------------------------------------------Apply Rankup Navigation------------------------------------------",true);
		rup.alreadyappliedLogin1();
		rup.alreadyappliedLogin2();
		rup.alreadyappliedLogin3();
		rup.tab1Navigation();
		rup.tab2Navigation();
		rup.tab3Navigation();
		rup.tab4Navigation();
		rup.playRankupImprovesVideo();
		rup.playRankupToJumpPersonalizationVideo();
		rup.successStories();
		rup.gotoJumpPage();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
