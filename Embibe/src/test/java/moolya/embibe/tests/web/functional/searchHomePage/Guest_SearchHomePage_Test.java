package moolya.embibe.tests.web.functional.searchHomePage;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Guest_SearchHomePage_Test extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private LoginPage log_p;
	{
		uniqueValue = "Sanity_3";
		uniqueValue2 = "Sanity_12";
	}
	
	String rearchURL="https://rearch.embibe.com";
	
	String jeeMain_URL=rearchURL+"/exams/jee-main/";
	String neet_URL=rearchURL+"/exams/neet/";
	String aiims_URL=rearchURL+"/exams/aiims/";
	String jeeAdvanced_URL=rearchURL+"/exams/iit-jee-advanced/";
	String bitsat_URL=rearchURL+"/exams/bitsat/";
	
	//String rearchURL="https://rearch.embibe.com";
	
	String cbse_URL=rearchURL+"/exams/cbse/";
	/*String jeeMain_URL=rearchURL+"/exams/jee-main/";
	String neet_URL=rearchURL+"/exams/neet/";
	String aiims_URL=rearchURL+"/exams/aiims/";
	String jeeAdvanced_URL=rearchURL+"/exams/iit-jee-advanced/";
	String bitsat_URL=rearchURL+"/exams/bitsat/";*/
	String eamcet_URL=rearchURL+"/exams/ap-eamcet/";

	String class_8_URL=rearchURL+"/foundation-08/test";
	String class_9_URL=rearchURL+"/foundation-09/test";
	String class_10_URL=rearchURL+"/foundation-10/test";
	
	String exam_jeeMain_URL=rearchURL+"/engineering/test/jee-main";
	String exam_jeeAdvanced_URL=rearchURL+"/engineering/test/jee-advanced";
	String exam_bitsat_URL=rearchURL+"/engineering/test/bitsat";
	String exam_gujaratCet_URL=rearchURL+"/engineering/test/gujarat-cet";
	String exam_AP_Eamcet_URL=rearchURL+"/engineering/test/ap-eamcet";
	String exam_TS_Eamcet_URL=rearchURL+"/engineering/test/ts-eamcet";
	String exam_neet_URL=rearchURL+"/medical/test/aipmt";
	String exam_aiims_URL=rearchURL+"/medical/test/aiims";
	String exam_bank_clerk_prelims_URL=rearchURL+"/bank/test/bank-clerk-prelims";
	String exam_bank_po_prelims_URL=rearchURL+"/bank/test/bank-po-prelims";
	
	String rankUp_URL=rearchURL+"/rankup/signup";
	String blog_URL="https://blog.embibe.com/";
	String articles_URL=rearchURL+"/exams/";
	String collegePredictor_URL=rearchURL+"/rank-college-predictor/home";
	
	@Test(dataProvider="browserData")
	public void guest_SearchHomePage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Guest Search Home Page Test on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		Reporter.log("========================================Search Home Page Header====================================",true);
		shp.clickAsk();
		shp.clickAskEmbibeLogo();
		shp.clickJump();
		shp.clickJumpEmbibeLogo();
		shp.clickRank();
		shp.clickRankupEmbibeLogo();
		/*shp.clickInstitutes();
		shp.verifyInstitutePage();
		shp.navigateBack();
		shp.header_guestIcons();
		shp.searchEngineSection();*/
		Reporter.log("========================================Unregistered User====================================",true);
		log_p=shp.clickLoginBtn();
		shp=log_p.unRegisterUser("unregistered@moolya.com","moolya123456");
		shp.clickLoginBtn();
		Reporter.log("=====================================Invalid Login Credentials================================",true);
		log_p=shp.clickLoginBtn();
		shp=log_p.invalidLoginCredentials("invalidLogin@gmailcom", "");
		shp.clickLoginBtn();
		Reporter.log("===================================Search Footer Exam Links======================================",true);
		shp.searchFooterLinks(1,"JEE Main",jeeMain_URL);
		shp.searchFooterLinks(2,"JEE Advanced",jeeAdvanced_URL);
		shp.searchFooterLinks(3,"BITSAT",bitsat_URL);
		shp.searchFooterLinks(4,"NEET",neet_URL);
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		shp.clickNextSwiper();
		shp.searchFooterLinks(5,"AIIMS",aiims_URL);
		shp.clickPrevSwiper();
		shp.assert_findSomethingCool();
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		shp.assert_preciseLocation();
		Reporter.log("========================================Global Footer,Exam Links====================================",true);
		shp.examLinks(1,"JEE Main",jeeMain_URL);
		shp.examLinks(2,"NEET",neet_URL);
		shp.examLinks(3,"AIIMS",aiims_URL);
		shp.examLinks(4,"CBSE",cbse_URL);
		shp.examLinks(5,"JEE Advanced",jeeAdvanced_URL);
		shp.examLinks(6,"BITSAT",bitsat_URL);
		shp.examLinks(7,"EAMCET",eamcet_URL);
		Reporter.log("========================================Classes Links====================================",true);
		shp.classesLinks(1,"Class 8","8th Foundation/NTSE/Olympiad",class_8_URL);
		shp.classesLinks(2,"Class 9","9th Foundation/NTSE/Olympiad",class_9_URL);
		shp.classesLinks(3,"Class 10","10th Foundation/NTSE/Olympiad",class_10_URL);
		Reporter.log("========================================Mock tests Links====================================",true);
		shp.mockTestsLinks(1,"JEE Main",exam_jeeMain_URL);
		shp.mockTestsLinks(2,"JEE Advanced",exam_jeeAdvanced_URL);
		shp.mockTestsLinks(3,"BITSAT",exam_bitsat_URL);
		shp.mockTestsLinks(4,"Gujarat-CET",exam_gujaratCet_URL);
		shp.mockTestsLinks(5,"AP-EAMCET",exam_AP_Eamcet_URL);
		shp.mockTestsLinks(6,"TS-EAMCET",exam_TS_Eamcet_URL);
		shp.mockTestsLinks(7,"NEET",exam_neet_URL);
		shp.mockTestsLinks(8,"AIIMS",exam_aiims_URL);
		shp.mockTestsLinks(9,"Bank Clerk Prelims",exam_bank_clerk_prelims_URL);
		shp.mockTestsLinks(10,"Bank PO Prelims",exam_bank_po_prelims_URL);
		Reporter.log("========================================Crack tests Links====================================",true);
		shp.crackTestsLinks(1,"JEE Main",rankUp_URL);
		shp.crackTestsLinks(2,"JEE Advanced",rankUp_URL);
		shp.crackTestsLinks(3,"BITSAT",rankUp_URL);
		shp.crackTestsLinks(4,"Gujarat-CET",rankUp_URL);
		shp.crackTestsLinks(5,"AP-EAMCET",rankUp_URL);
		shp.crackTestsLinks(6,"TS-EAMCET",rankUp_URL);
		shp.crackTestsLinks(7,"NEET",rankUp_URL);
		shp.crackTestsLinks(8,"AIIMS",rankUp_URL);
		shp.crackTestsLinks(9,"Bank Clerk Prelims",rankUp_URL);
		shp.crackTestsLinks(10,"Bank PO Prelims",rankUp_URL);
		Reporter.log("========================================Resources tests Links====================================",true);
		shp.resourcesTestsLinks(1,"CEO blog",blog_URL);
		shp.resourcesTestsLinks(2,"Articles",articles_URL);
		shp.resourcesTestsLinks(3,"College Predictor",collegePredictor_URL);
		Reporter.log("========================================Social Media Links====================================",true);
		String mainWindow = shp.getMainWindowHandle();
		shp.clickFacebookIcon();
		shp.switchToNextWindow(mainWindow);
		shp.assertFacebookEmbibePage();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("Facebook signup window closed",true);
		Reporter.log("-------------------------------------------------------------------------------",true);
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
