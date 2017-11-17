package moolya.embibe.tests.web.functional.searchHomePage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_In_All_Pages extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private SignUpPage sup;

	{
		uniqueValue = "Sanity_9";
	}
	
	@Test(dataProvider="browserData")
	public void guest_SearchHomePage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in all the pages on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		Reporter.log("========================================Login-Logout in Search Home Page====================================",true);
		shp.login();
		shp.logout();
		shp.clickEmbibeLogo();
		Reporter.log("-------------------------Facebook Login----------------------------",true);
		//shp.loginBtn();
		shp.clickFbLogin();
		shp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		shp.assertSearchHomepage();
		shp.logout();
		shp.clickEmbibeLogo();
		shp.clearCookies();
		Reporter.log("========================================Login-Logout in Search Results Page====================================",true);
		srp=shp.validSearchResult(uniqueValue2);//SHP_17
		srp.login();
		sup = srp.logout();
		shp.clickEmbibeLogo();
		srp=shp.validSearchResult(uniqueValue2);//SHP_17
		Reporter.log("-------------------------Facebook Login----------------------------",true);
		//shp.loginBtn();
		shp.clickFbLogin();
		shp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		shp.logout();
		shp.clearCookies();
		shp.refreshPage();
		shp.wdriver.navigate().to("https://rearch.embibe.com/signup");
		Reporter.log("========================================Login-Logout in Sign Up Page====================================",true);
		sup.loginSignUp();
		shp.verifyLogin();
		shp.assertSearchHomepage();
		shp.logout();
		Reporter.log("-------------------------Facebook Login----------------------------",true);
		//shp.loginBtn();
		shp.clickFbLogin();
		shp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		shp.assertSearchHomepage();
		shp.logout();
		shp.clickEmbibeLogo();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
