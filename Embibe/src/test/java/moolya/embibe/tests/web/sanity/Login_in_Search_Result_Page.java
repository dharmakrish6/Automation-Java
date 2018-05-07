package moolya.embibe.tests.web.sanity;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_in_Search_Result_Page extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;

	@Test(dataProvider="browserData")
	public void loginIn_SearchResultsPage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in SEARCH RESULTS PAGE on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.closeIntercom();
		shp.assertSearchHomepage();
		Reporter.log("==========================Login-Logout in Search Results Page========================",true);
		srp=shp.validSearchResult(uniqueValue2);//SHP_17
		Reporter.log("------------------------------------------Main Login------------------------------------------",true);
		srp.login();
		srp.logout();
		shp.clickEmbibeLogo();
		srp=shp.validSearchResult(uniqueValue2);//SHP_17
		Reporter.log("------------------------------------------Facebook Login------------------------------------------",true);
		shp.loginBtn();
		shp.clickFbLogin();
		shp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		shp.logout();
		shp.clickEmbibeLogo();
		srp=shp.validSearchResult(uniqueValue2);//SHP_17
		Reporter.log("------------------------------------------Google Login------------------------------------------",true);
		shp.loginBtn();
		shp.clickGoogleLogin();
		shp.enterGoogleLoginCredentials("testonetest444@gmail.com", "qwerty@1234");
		shp.assertSearchHomepage();
		shp.logout();
		shp.refreshPage();
		shp.clickEmbibeLogo();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
