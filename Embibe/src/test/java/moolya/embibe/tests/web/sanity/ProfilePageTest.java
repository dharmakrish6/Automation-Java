package moolya.embibe.tests.web.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.MyProfilePage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class ProfilePageTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	String searchKeyword;
	String searchText;
	private MyProfilePage mpp;

	{
		uniqueValue = "ProfilePageSanity";
	}
	
	@Test(dataProvider="browserData")
	public void profilePageTest(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: ProfilePageTest", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.closeIntercom();
		shp.assertSearchHomepage();
		shp.login(uniqueValue);
		shp.assertSearchHomepage();
		mpp = shp.goToMyProfile();
		mpp.waitForMyProfilePageToLoad();
		mpp.assertProfilePage();
	}
}
