package moolya.embibe.tests.web.functional.jumpPage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.FootersPage;
import moolya.embibe.pages.web.JumpPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LearnPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_in_Jump_Page extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private FootersPage lpf;
	private LearnPage learnPg;
	private JumpPage jp;
	
	@Test(dataProvider="browserData")
	public void login_JumpPage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in JUMP PAGE on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		Reporter.log("==========================Login-Logout in Jump Page========================",true);
		jp=shp.clickJump();
		Reporter.log("------------------------------------------Main Login------------------------------------------",true);
		jp.ClickSignupBtn();
		jp.jumpPageLoginWindow("jimmy@gmail.com","qwertyuiop");
		jp.jumpPageLogout();
		jp=shp.clickJump();
		Reporter.log("------------------------------------------Facebook Login------------------------------------------",true);
		jp.ClickSignupBtn();
		jp.ClickLearnPageFBlogin();
		jp.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		jp.jumpPageLogout();
		jp=shp.clickJump();
		Reporter.log("------------------------------------------Google Login------------------------------------------",true);
		jp.ClickSignupBtn();
		jp.ClickLearnPageGooglelogin();
		jp.enterGoogleLoginCredentials("testonetest444@gmail.com", "qwerty@1234");
		jp.jumpPageLogout();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
