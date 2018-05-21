package moolya.embibe.tests.web.sanity;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_in_Signup_Page extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SignUpPage sup;

	{
		uniqueValue = "Sanity_9";
	}
	
	@Test(dataProvider="browserData")
	public void login_In_SignupPage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in SignUp Page on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.closeIntercom();
		shp.assertSearchHomepage();
		Reporter.log("=======================Login-Logout in Sign Up Page===================",true);
		sup=shp.goToSignUpPage();
		Reporter.log("------------------------------------------Main Login------------------------------------------",true);
		sup.loginSignUp();
		shp.verifyLogin();
		shp.assertSearchHomepage();
		shp.logout();
		Reporter.log("------------------------------------------Facebook Login------------------------------------------",true);
		//shp.loginBtn();
		sup.click_SignUp_fb_Login();
		shp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		shp.assertSearchHomepage();
		shp.logout();
		//shp.clickEmbibeLogo();
		Reporter.log("------------------------------------------Google Login------------------------------------------",true);
		//shp.loginBtn();
		sup.click_SignUp_Google_Login();
		shp.enterGoogleLoginCredentials("testonetest444@gmail.com", "qwerty@1234");
		shp.assertSearchHomepage();
		shp.logout();
		shp.refreshPage();
		shp.clickEmbibeLogo();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
