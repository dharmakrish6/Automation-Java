package moolya.embibe.tests.web.functional.searchHomePage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LearnPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_in_Learn_Page extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private LearnPage learnPg;

	{
		uniqueValue = "Sanity_9";
	}
	
	@Test(dataProvider="browserData")
	public void loginIn_LearnPage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Login-In test in LEARN PAGE on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		Reporter.log("==========================Login-Logout in Learn Page========================",true);
		srp=shp.validSearchResult(uniqueValue2);
		learnPg=srp.gotoLearnPage();
		Reporter.log("------------------------------------------Main Login------------------------------------------",true);
		learnPg.closeIntercom();
		learnPg.ClickSignupBtn();
		learnPg.learnPageLoginWindow("yashuu@gmail.com","qwertyuiop");
		learnPg.learnPageLogout();
		learnPg.clickEmbibeLogo();
		srp=shp.validSearchResult(uniqueValue2);
		learnPg=srp.gotoLearnPage();
		Reporter.log("------------------------------------------Facebook Login------------------------------------------",true);
		//learnPg.closeIntercom();
		learnPg.ClickSignupBtn();
		learnPg.ClickLearnPageFBlogin();
		learnPg.enterFbLoginCredentials("testonetest444@gmail.com", "Testing@ccount");
		learnPg.learnPageLogout();
		/*learnPg.clickEmbibeLogo();
		srp=shp.validSearchResult(uniqueValue2);
		learnPg=srp.gotoLearnPage();
		Reporter.log("------------------------------------------Google Login------------------------------------------",true);
		//learnPg.closeIntercom();
		learnPg.ClickSignupBtn();
		learnPg.ClickLearnPageGooglelogin();
		learnPg.enterGoogleLoginCredentials("testonetest444@gmail.com", "qwerty@1234");
		learnPg.learnPageLogout();*/
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
