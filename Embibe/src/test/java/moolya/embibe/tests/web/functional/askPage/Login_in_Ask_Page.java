package moolya.embibe.tests.web.functional.askPage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.AskPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_in_Ask_Page extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	//private AskPage ap;
	private AskPage ap;
	
	@Test(dataProvider="browserData")
	public void login_AskPage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in ASK PAGE on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		//shp.closeIntercom();
		shp.assertSearchHomepage();
		Reporter.log("==========================Login-Logout in Ask Page========================",true);
		ap=shp.clickAsk();
		Reporter.log("------------------------------------------Main Login------------------------------------------",true);
		ap.clickAskPageLoginBtn();
		ap.Login_in_signupForm();
		ap.askPageLogout();
		ap.clickAskEmbibeLogo();
		ap.clickAsk();
		Reporter.log("------------------------------------------Facebook Login------------------------------------------",true);
		ap.clickAskPageLoginBtn();
		ap.ClickAskPageFBlogin();
		ap.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		ap.logout_SHM();
		ap.clickAskEmbibeLogo();
		ap.clickAsk();
		Reporter.log("------------------------------------------Google Login------------------------------------------",true);
		ap.clickAskPageLoginBtn();
		ap.ClickaskPageGooglelogin();
		ap.enterGoogleLoginCredentials("testonetest444@gmail.com", "qwerty@1234");
		ap.logout_SHM();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
