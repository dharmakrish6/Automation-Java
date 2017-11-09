	package moolya.embibe.tests.web.functional.searchHomePage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;
import moolya.embibe.utils.JavaUtils;

public class SignupPage_Footer_Test extends W_BaseTest {

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
	
	
	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	
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
	public void signupPage_Footer_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : SignupPage Footers :"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		shp.login();
		SignUpPage sup = shp.logout();
		shp.clickAsk();
		shp.clickAskEmbibeLogo();
		shp.goToSignUpPage();
		shp.clickJump();
		shp.clickJumpEmbibeLogo();
		shp.goToSignUpPage();
		shp.clickRank();
		shp.clickRankupEmbibeLogo();
		shp.goToSignUpPage();
		shp.clickInstitutes();
		shp.verifyInstitutePage();
		shp.navigateBack();
		shp.goToSignUpPage();
		Reporter.log("========================================Exam Links====================================",true);
		sup.examLinks(1,"JEE Main",jeeMain_URL);
		sup.examLinks(2,"NEET",neet_URL);
		sup.examLinks(3,"AIIMS",aiims_URL);
		sup.examLinks(4,"CBSE",cbse_URL);
		sup.examLinks(5,"JEE Advanced",jeeAdvanced_URL);
		sup.examLinks(6,"BITSAT",bitsat_URL);
		sup.examLinks(7,"EAMCET",eamcet_URL);
		Reporter.log("========================================Classes Links====================================",true);
		sup.classesLinks(1,"Class 8","8th Foundation/NTSE/Olympiad",class_8_URL);
		sup.classesLinks(2,"Class 9","9th Foundation/NTSE/Olympiad",class_9_URL);
		sup.classesLinks(3,"Class 10","10th Foundation/NTSE/Olympiad",class_10_URL);
		Reporter.log("========================================Mock tests Links====================================",true);
		sup.mockTestsLinks(1,"JEE Main",exam_jeeMain_URL);
		sup.mockTestsLinks(2,"JEE Advanced",exam_jeeAdvanced_URL);
		sup.mockTestsLinks(3,"BITSAT",exam_bitsat_URL);
		sup.mockTestsLinks(4,"Gujarat-CET",exam_gujaratCet_URL);
		sup.mockTestsLinks(5,"AP-EAMCET",exam_AP_Eamcet_URL);
		sup.mockTestsLinks(6,"TS-EAMCET",exam_TS_Eamcet_URL);
		sup.mockTestsLinks(7,"NEET",exam_neet_URL);
		sup.mockTestsLinks(8,"AIIMS",exam_aiims_URL);
		sup.mockTestsLinks(9,"Bank Clerk Prelims",exam_bank_clerk_prelims_URL);
		sup.mockTestsLinks(10,"Bank PO Prelims",exam_bank_po_prelims_URL);
		Reporter.log("========================================Crack tests Links====================================",true);
		sup.crackTestsLinks(1,"JEE Main",rankUp_URL);
		sup.crackTestsLinks(2,"JEE Advanced",rankUp_URL);
		sup.crackTestsLinks(3,"BITSAT",rankUp_URL);
		sup.crackTestsLinks(4,"Gujarat-CET",rankUp_URL);
		sup.crackTestsLinks(5,"AP-EAMCET",rankUp_URL);
		sup.crackTestsLinks(6,"TS-EAMCET",rankUp_URL);
		sup.crackTestsLinks(7,"NEET",rankUp_URL);
		sup.crackTestsLinks(8,"AIIMS",rankUp_URL);
		sup.crackTestsLinks(9,"Bank Clerk Prelims",rankUp_URL);
		sup.crackTestsLinks(10,"Bank PO Prelims",rankUp_URL);
		Reporter.log("========================================Resources tests Links====================================",true);
		sup.resourcesTestsLinks(1,"CEO blog",blog_URL);
		sup.resourcesTestsLinks(2,"Articles",articles_URL);
		sup.resourcesTestsLinks(3,"College Predictor",collegePredictor_URL);
		Reporter.log("========================================Social Media Links====================================",true);
		String mainWindow = sup.getMainWindowHandle();
		sup.clickFacebookIcon();
		sup.switchToNextWindow(mainWindow);
		sup.assertFacebookEmbibePage();
		sup.closeChildAndSwitchToMainWindow(mainWindow);
		sup.clickTwitterIcon();
		sup.switchToNextWindow(mainWindow);
		sup.assertTwitterEmbibePage();
		sup.closeChildAndSwitchToMainWindow(mainWindow);
		sup.clickInstagramIcon();
		sup.switchToNextWindow(mainWindow);
		sup.assertInstagramEmbibePage();
		sup.closeChildAndSwitchToMainWindow(mainWindow);
		sup.clickYoutubeIcon();
		sup.switchToNextWindow(mainWindow);
		sup.assertYoutubeEmbibePage();
		sup.closeChildAndSwitchToMainWindow(mainWindow);
		Reporter.log("========================================Bottom footer Links====================================",true);
		shp.click_aboutUs();
		shp.switchToNextWindow(mainWindow);
		shp.assertAboutUs_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.click_press();
		shp.switchToNextWindow(mainWindow);
		shp.assertPress_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.click_contactUs();
		shp.switchToNextWindow(mainWindow);
		shp.assertContactUs_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.click_termsConditions();
		shp.switchToNextWindow(mainWindow);
		shp.assertTOS_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.click_takeDownPolicy();
		shp.switchToNextWindow(mainWindow);
		shp.assertTakeDownPolicy_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
		shp.click_privacyPolicy();
		shp.switchToNextWindow(mainWindow);
		shp.assertPrivacyPolicy_Page();
		shp.closeChildAndSwitchToMainWindow(mainWindow);
	}
}
