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

public class SignupPage_Footer_Test extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	
	String rearchURL="https://rearch-staging3.embibe.com";
	
	String jeeMain_URL=rearchURL+"/exams/jee-main/";
	String neet_URL=rearchURL+"/exams/neet/";
	String aiims_URL=rearchURL+"/exams/aiims/";
	String cbse_URL=rearchURL+"/exams/cbse/";
	String jeeAdvanced_URL=rearchURL+"/exams/iit-jee-advanced/";
	String bitsat_URL=rearchURL+"/exams/bitsat/";
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
	}
}
