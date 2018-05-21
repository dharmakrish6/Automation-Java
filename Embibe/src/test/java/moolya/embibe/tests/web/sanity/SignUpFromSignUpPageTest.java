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

public class SignUpFromSignUpPageTest extends W_BaseTest {

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
		uniqueValue = "Sanity_10";
	}
	
	@Test(dataProvider="browserData")
	public void signUpFromSignUpPageTest(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException{
		count = MysqlUtils.updateAndGetCounter();
		email = JavaUtils.getPropValue("emailPrefix")+count+JavaUtils.getPropValue("mailSuffix");
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: SignUpFromSignUpPageTest", true);
		lp = new LandingPage(wdriver);
		sup = lp.goToSignUpPage();
		sup.expandSignUp();
		shp = sup.signUpSignUpPage(uniqueValue, email);
		shp.verifyLogin();
		shp.assertSearchHomepage();		
	}
}
