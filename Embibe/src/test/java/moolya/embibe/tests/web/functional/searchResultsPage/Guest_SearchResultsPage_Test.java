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
import moolya.embibe.utils.JavaUtils;

public class Guest_SearchResultsPage_Test extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	{
		uniqueValue = "Sanity_3";
		uniqueValue2 = "Sanity_12";
	}

	private static String rearchURL;
	private static String jeeMain_URL;
	private static String neet_URL;
	private static String aiims_URL;
	private static String cbse_URL;
	private static String jeeAdvanced_URL;
	private static String bitsat_URL;
	private static String eamcet_URL;
	private static String class_8_URL;
	private static String class_9_URL;
	private static String class_10_URL;
	private static String exam_jeeMain_URL;
	private static String exam_jeeAdvanced_URL;
	private static String exam_bitsat_URL;
	private static String exam_gujaratCet_URL;
	private static String exam_AP_Eamcet_URL;
	private static String exam_TS_Eamcet_URL;
	private static String exam_neet_URL;
	private static String exam_aiims_URL;
	private static String exam_bank_clerk_prelims_URL;
	private static String exam_bank_po_prelims_URL;
	private static String rankUp_URL;
	private static String blog_URL;
	private static String articles_URL;
	private static String collegePredictor_URL;



	static{
		try {
			rearchURL = JavaUtils.getPropValue("testAppUrl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		jeeMain_URL=rearchURL+"exams/jee-main/";
		neet_URL=rearchURL+"exams/neet/";
		aiims_URL=rearchURL+"exams/aiims/";
		cbse_URL=rearchURL+"exams/cbse/";
		jeeAdvanced_URL=rearchURL+"exams/iit-jee-advanced/";
		bitsat_URL=rearchURL+"exams/bitsat/";
		eamcet_URL=rearchURL+"exams/ap-eamcet/";

		class_8_URL=rearchURL+"foundation-08/test";
		class_9_URL=rearchURL+"foundation-09/test";
		class_10_URL=rearchURL+"foundation-10/test";

		exam_jeeMain_URL=rearchURL+"engineering/test/jee-main";
		exam_jeeAdvanced_URL=rearchURL+"engineering/test/jee-advanced";
		exam_bitsat_URL=rearchURL+"engineering/test/bitsat";
		exam_gujaratCet_URL=rearchURL+"engineering/test/gujarat-cet";
		exam_AP_Eamcet_URL=rearchURL+"engineering/test/ap-eamcet";
		exam_TS_Eamcet_URL=rearchURL+"engineering/test/ts-eamcet";
		exam_neet_URL=rearchURL+"medical/test/aipmt";
		exam_aiims_URL=rearchURL+"medical/test/aiims";
		exam_bank_clerk_prelims_URL=rearchURL+"bank/test/bank-clerk-prelims";
		exam_bank_po_prelims_URL=rearchURL+"bank/test/bank-po-prelims";

		rankUp_URL=rearchURL+"rankup/signup";
		blog_URL="https://blog.embibe.com/";
		articles_URL=rearchURL+"exams/";
		collegePredictor_URL=rearchURL+"rank-college-predictor/home";
	}

	@Test(dataProvider="browserData")
	public void guest_SearchResultsPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Guest Search Result Page Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
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
