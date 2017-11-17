package moolya.embibe.tests.web.functional.searchResultsPage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Login_SearchResultsPage_Test extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	{
		uniqueValue = "Sanity_3";
		uniqueValue2 = "Sanity_12";
	}
	

	String jeeMain_URL="https://rearch.embibe.com/exams/jee-main/";
	String neet_URL="https://rearch.embibe.com/exams/neet/";
	String aiims_URL="https://rearch.embibe.com/exams/aiims/";
	String cbse_URL="https://rearch.embibe.com/exams/cbse/";
	String jeeAdvanced_URL="https://rearch.embibe.com/exams/iit-jee-advanced/";
	String bitsat_URL="https://rearch.embibe.com/exams/bitsat/";
	String eamcet_URL="https://rearch.embibe.com/exams/ap-eamcet/";

	String class_8_URL="https://rearch.embibe.com/foundation-08/test";
	String class_9_URL="https://rearch.embibe.com/foundation-09/test";
	String class_10_URL="https://rearch.embibe.com/foundation-10/test";
	
	String exam_jeeMain_URL="https://rearch.embibe.com/engineering/test/jee-main";
	String exam_jeeAdvanced_URL="https://rearch.embibe.com/engineering/test/jee-advanced";
	String exam_bitsat_URL="https://rearch.embibe.com/engineering/test/bitsat";
	String exam_gujaratCet_URL="https://rearch.embibe.com/engineering/test/gujarat-cet";
	String exam_AP_Eamcet_URL="https://rearch.embibe.com/engineering/test/ap-eamcet";
	String exam_TS_Eamcet_URL="https://rearch.embibe.com/engineering/test/ts-eamcet";
	String exam_neet_URL="https://rearch.embibe.com/medical/test/aipmt";
	String exam_aiims_URL="https://rearch.embibe.com/medical/test/aiims";
	String exam_bank_clerk_prelims_URL="https://rearch.embibe.com/bank/test/bank-clerk-prelims";
	String exam_bank_po_prelims_URL="https://rearch.embibe.com/bank/test/bank-po-prelims";
	
	String rankUp_URL="https://rearch.embibe.com/rankup/signup";
	String blog_URL="https://blog.embibe.com/";
	String articles_URL="https://rearch.embibe.com/exams/";
	String collegePredictor_URL="https://rearch.embibe.com/rank-college-predictor/home";
	
	@Test(dataProvider="browserData")
	public void login_SearchResultsPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional :Login User Search Result Page Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.login();
		Reporter.log("===================================No floating keywords after clearing search field============================",true);
		shp.disappearFloatingKeywords(uniqueValue);//SHP_5
		Reporter.log("===================================Disambiguated keyword search===============================",true);
		shp.autoFillSearchResults();//SHP_9
		shp.clickEmbibeLogo();
		shp.assertSearchHomepage();
		Reporter.log("===================================Misspell keyword search====================================",true);
		shp.wrongKeywordInSearchField();//SHP_11
		Reporter.log("===================================Floating keyword search in new tab=============================",true);
		shp.searchInNewTab(uniqueValue);//SHP_8
		Reporter.log("===================================Valid keywords search========================================",true);
		shp.correctKeywordInSearchField();//SHP_12
		shp.clickEmbibeLogo();
		shp.assertSearchHomepage();
		/*Reporter.log("===================================Invalid keyword search========================================",true);
		shp.noResultsFound();//SHP_14,No results page
		shp.clickEmbibeLogo();
		shp.assertSearchHomepage();*/
		//Reporter.log("===================================Valid keyword search========================================",true);
		srp=shp.validSearchResult(uniqueValue2);//SHP_17
		Reporter.log("===================================Exam Links====================================",true);
		srp.examLinks(1,"JEE Main",jeeMain_URL);
		srp.examLinks(2,"NEET",neet_URL);
		srp.examLinks(3,"AIIMS",aiims_URL);
		srp.examLinks(4,"CBSE",cbse_URL);
		srp.examLinks(5,"JEE Advanced",jeeAdvanced_URL);
		srp.examLinks(6,"BITSAT",bitsat_URL);
		srp.examLinks(7,"EAMCET",eamcet_URL);
		Reporter.log("========================================Classes Links====================================",true);
		srp.classesLinks(1,"Class 8","8th Foundation/NTSE/Olympiad",class_8_URL);
		srp.classesLinks(2,"Class 9","9th Foundation/NTSE/Olympiad",class_9_URL);
		srp.classesLinks(3,"Class 10","10th Foundation/NTSE/Olympiad",class_10_URL);
		Reporter.log("========================================Mock tests Links====================================",true);
		srp.mockTestsLinks(1,"JEE Main",exam_jeeMain_URL);
		srp.mockTestsLinks(2,"JEE Advanced",exam_jeeAdvanced_URL);
		srp.mockTestsLinks(3,"BITSAT",exam_bitsat_URL);
		srp.mockTestsLinks(4,"Gujarat-CET",exam_gujaratCet_URL);
		srp.mockTestsLinks(5,"AP-EAMCET",exam_AP_Eamcet_URL);
		srp.mockTestsLinks(6,"TS-EAMCET",exam_TS_Eamcet_URL);
		srp.mockTestsLinks(7,"NEET",exam_neet_URL);
		srp.mockTestsLinks(8,"AIIMS",exam_aiims_URL);
		srp.mockTestsLinks(9,"Bank Clerk Prelims",exam_bank_clerk_prelims_URL);
		srp.mockTestsLinks(10,"Bank PO Prelims",exam_bank_po_prelims_URL);
		Reporter.log("========================================Crack tests Links====================================",true);
		srp.crackTestsLinks(1,"JEE Main",rankUp_URL);
		srp.crackTestsLinks(2,"JEE Advanced",rankUp_URL);
		srp.crackTestsLinks(3,"BITSAT",rankUp_URL);
		srp.crackTestsLinks(4,"Gujarat-CET",rankUp_URL);
		srp.crackTestsLinks(5,"AP-EAMCET",rankUp_URL);
		srp.crackTestsLinks(6,"TS-EAMCET",rankUp_URL);
		srp.crackTestsLinks(7,"NEET",rankUp_URL);
		srp.crackTestsLinks(8,"AIIMS",rankUp_URL);
		srp.crackTestsLinks(9,"Bank Clerk Prelims",rankUp_URL);
		srp.crackTestsLinks(10,"Bank PO Prelims",rankUp_URL);
		Reporter.log("========================================Resources tests Links====================================",true);
		srp.resourcesTestsLinks(1,"CEO blog",blog_URL);
		srp.resourcesTestsLinks(2,"Articles",articles_URL);
		srp.resourcesTestsLinks(3,"College Predictor",collegePredictor_URL);
		Reporter.log("========================================Social Media Links====================================",true);
		String mainWindow = shp.getMainWindowHandle();
		/*shp.clickFacebookIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertFacebookEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Facebook signup window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);*/
		shp.clickTwitterIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertTwitterEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Twitter signup window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.clickInstagramIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertInstagramEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Instagram signup window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.clickYoutubeIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertYoutubeEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Youtube signup window closed",true);
		Reporter.log("========================================Bottom footer Links====================================",true);
		shp.click_aboutUs();
		shp.switchToNextWindow(mainWindow);
		shp.assertAboutUs_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("AboutUs window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.click_press();
		shp.switchToNextWindow(mainWindow);
		shp.assertPress_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Press window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.click_contactUs();
		shp.switchToNextWindow(mainWindow);
		shp.assertContactUs_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("ContactUs window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.click_termsConditions();
		shp.switchToNextWindow(mainWindow);
		shp.assertTOS_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Terms & Conditions window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.click_takeDownPolicy();
		shp.switchToNextWindow(mainWindow);
		shp.assertTakeDownPolicy_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Take Down Policy signup window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
		shp.click_privacyPolicy();
		shp.switchToNextWindow(mainWindow);
		shp.assertPrivacyPolicy_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Privacy Policy window closed",true);
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
