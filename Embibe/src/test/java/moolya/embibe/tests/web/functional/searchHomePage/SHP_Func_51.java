package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SHP_Func_51 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private LoginPage log_p;

	@Test(dataProvider="browserData")
	public void SHP_Func_51_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_51 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		log_p=shp.clickLoginBtn();
		log_p.clickForgotPassword();
		boolean flag = log_p.statusOfResetPasswordBtn("jimmy@gmailcom");
		Assert.assertTrue(flag, "Enabled");
		Reporter.log("Disabled", true);
		flag = log_p.statusOfResetPasswordBtn("jimmy@gmail.com");
		Assert.assertTrue(!flag, "Disabled");
		Reporter.log("Enabled", true);
		Thread.sleep(5000);
	}
}
