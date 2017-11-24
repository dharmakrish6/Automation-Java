package moolya.embibe.tests.web.functional.searchHomePage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_in_Search_Home_Page extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;

	{
		uniqueValue = "Sanity_9";
	}
	
	@Test(dataProvider="browserData")
	public void login_SearchHomePage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in SEARCH HOME PAGE on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		Reporter.log("=====================Login-Logout in Search Home Page====================",true);
		Reporter.log("------------------------------------------Main Login------------------------------------------",true);
		shp.login();
		shp.logout();
		shp.clickEmbibeLogo();
		Reporter.log("------------------------------------------Facebook Login------------------------------------------",true);
		shp.clickFbLogin();
		shp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		shp.assertSearchHomepage();
		shp.logout();
		shp.clickEmbibeLogo();
		shp.loginBtn();
		Reporter.log("------------------------------------------Google Login------------------------------------------",true);
		shp.clickGoogleLogin();
		shp.enterGoogleLoginCredentials("testonetest444@gmail.com", "qwerty@1234");
		shp.assertSearchHomepage();
		shp.logout();
		shp.clickEmbibeLogo();
		shp.assertSearchHomepage();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
