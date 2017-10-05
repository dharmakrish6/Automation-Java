package moolya.embibe.tests.browserStack.web.suite.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.MailinatorPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.tests.browserStack.BrowserStackTestNGTest;
import moolya.embibe.utils.SqliteUtils;

public class Sanity_11 extends BrowserStackTestNGTest {

	private LandingPage lp;
	private SearchHomepage shp;
	String searchKeyword;
	String searchText;
	String email;
	private SignUpPage sup;
	private MailinatorPage mp;
	private String count;

	{
		uniqueValue = "Sanity_11";
	}
	
	@Test
	public void Sanity_11test() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, ClassNotFoundException{
		count = SqliteUtils.updateAndGetCounter();
		email = "embibe.auto"+count+"@mailinator.com";
		Reporter.log("Starting Test: Sanity_11test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.signUp(uniqueValue,email);
		shp.verifyLogin();
		shp.assertSearchHomepage();
		sup = shp.logout();
		sup.clickForgotPasswordSignUpPage(email);
		mp = sup.goToMalinatorPage();
		mp.goToInbox(email);
		mp.openEmailSubject();
		String window = mp.getMainWindowHandle();
		sup = mp.clickResetPassword();
		sup.switchToNextWindow(window);
		sup.resetPassword(uniqueValue, email);
		sup.loginSignUpPage(uniqueValue, email);
		shp.verifyLogin();
		shp.assertSearchHomepage();		
	}
}
