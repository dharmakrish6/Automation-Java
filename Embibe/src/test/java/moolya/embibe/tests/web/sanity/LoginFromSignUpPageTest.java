package moolya.embibe.tests.web.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;
import moolya.embibe.utils.JavaUtils;
import moolya.embibe.utils.MysqlUtils;

public class LoginFromSignUpPageTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	String searchKeyword;
	String searchText;
	String email;
	private SignUpPage sup;
	private String count;

	{
		uniqueValue = "Sanity_9";
	}
	
	@Test(dataProvider="browserData")
	public void loginFromSignUpPageTest(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, ClassNotFoundException{
		count = MysqlUtils.updateAndGetCounter();
		email = JavaUtils.getPropValue("emailPrefix")+count+JavaUtils.getPropValue("mailSuffix");
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: LoginFromSignUpPageTest", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.closeIntercom();
		shp.assertSearchHomepage();
		shp.signUp(uniqueValue,email);
		shp.verifyLogin();
		shp.assertSearchHomepage();
		sup = shp.logout();
//		sup.goToSignUpPage();
		sup.loginSignUpPage(uniqueValue, email);
		shp.verifyLogin();
		shp.assertSearchHomepage();		
	}
}
