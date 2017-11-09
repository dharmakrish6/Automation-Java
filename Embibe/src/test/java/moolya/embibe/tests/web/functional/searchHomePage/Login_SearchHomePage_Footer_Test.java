	package moolya.embibe.tests.web.functional.searchHomePage;

import java.awt.AWTException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.FootersPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;
import moolya.embibe.utils.JavaUtils;

public class Login_SearchHomePage_Footer_Test extends W_BaseTest {

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
	private FootersPage lfp;
	
	static{
		try {
			rearchURL = JavaUtils.getPropValue("testAppUrl");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		jeeMain_URL=rearchURL+"/exams/jee-main/";
		neet_URL=rearchURL+"/exams/neet/";
		aiims_URL=rearchURL+"/exams/aiims/";
		cbse_URL=rearchURL+"/exams/cbse/";
		jeeAdvanced_URL=rearchURL+"/exams/iit-jee-advanced/";
		bitsat_URL=rearchURL+"/exams/bitsat/";
		eamcet_URL=rearchURL+"/exams/ap-eamcet/";

		class_8_URL=rearchURL+"/foundation-08/test";
		class_9_URL=rearchURL+"/foundation-09/test";
		class_10_URL=rearchURL+"/foundation-10/test";
		
		exam_jeeMain_URL=rearchURL+"/engineering/test/jee-main";
		exam_jeeAdvanced_URL=rearchURL+"/engineering/test/jee-advanced";
		exam_bitsat_URL=rearchURL+"/engineering/test/bitsat";
		exam_gujaratCet_URL=rearchURL+"/engineering/test/gujarat-cet";
		exam_AP_Eamcet_URL=rearchURL+"/engineering/test/ap-eamcet";
		exam_TS_Eamcet_URL=rearchURL+"/engineering/test/ts-eamcet";
		exam_neet_URL=rearchURL+"/medical/test/aipmt";
		exam_aiims_URL=rearchURL+"/medical/test/aiims";
		exam_bank_clerk_prelims_URL=rearchURL+"/bank/test/bank-clerk-prelims";
		exam_bank_po_prelims_URL=rearchURL+"/bank/test/bank-po-prelims";
		
		rankUp_URL=rearchURL+"/rankup/signup";
		blog_URL="https://blog.embibe.com/";
		articles_URL=rearchURL+"/exams/";
		collegePredictor_URL=rearchURL+"/rank-college-predictor/home";
	}
	
	@Test(dataProvider="browserData")
	public void loginSearchHomePage_Footer_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Login usre searchHomePage Footers :"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		shp.login();
		lfp=shp.loginFooters();
		Reporter.log("========================================Exam Links====================================",true);
		lfp.loginUser_examLinks(1,"JEE Main",jeeMain_URL);
		lfp.loginUser_examLinks(2,"NEET",neet_URL);
		lfp.loginUser_examLinks(3,"AIIMS",aiims_URL);
		lfp.loginUser_examLinks(4,"CBSE",cbse_URL);
		lfp.loginUser_examLinks(5,"JEE Advanced",jeeAdvanced_URL);
		lfp.loginUser_examLinks(6,"BITSAT",bitsat_URL);
		lfp.loginUser_examLinks(7,"EAMCET",eamcet_URL);
		Reporter.log("========================================Classes Links====================================",true);
		lfp.loginUser_classesLinks(1,"Class 8","8th Foundation/NTSE/Olympiad",class_8_URL);
		lfp.loginUser_classesLinks(2,"Class 9","9th Foundation/NTSE/Olympiad",class_9_URL);
		lfp.loginUser_classesLinks(3,"Class 10","10th Foundation/NTSE/Olympiad",class_10_URL);
		Reporter.log("========================================Mock tests Links====================================",true);
		lfp.loginUser_mockTestsLinks(1,"JEE Main",exam_jeeMain_URL);
		lfp.loginUser_mockTestsLinks(2,"JEE Advanced",exam_jeeAdvanced_URL);
		lfp.loginUser_mockTestsLinks(3,"BITSAT",exam_bitsat_URL);
		lfp.loginUser_mockTestsLinks(4,"Gujarat-CET",exam_gujaratCet_URL);
		lfp.loginUser_mockTestsLinks(5,"AP-EAMCET",exam_AP_Eamcet_URL);
		lfp.loginUser_mockTestsLinks(6,"TS-EAMCET",exam_TS_Eamcet_URL);
		lfp.loginUser_mockTestsLinks(7,"NEET",exam_neet_URL);
		lfp.loginUser_mockTestsLinks(8,"AIIMS",exam_aiims_URL);
		lfp.loginUser_mockTestsLinks(9,"Bank Clerk Prelims",exam_bank_clerk_prelims_URL);
		lfp.loginUser_mockTestsLinks(10,"Bank PO Prelims",exam_bank_po_prelims_URL);
		Reporter.log("========================================Crack tests Links====================================",true);
		lfp.loginUser_crackTestsLinks(1,"JEE Main",rankUp_URL);
		lfp.loginUser_crackTestsLinks(2,"JEE Advanced",rankUp_URL);
		lfp.loginUser_crackTestsLinks(3,"BITSAT",rankUp_URL);
		lfp.loginUser_crackTestsLinks(4,"Gujarat-CET",rankUp_URL);
		lfp.loginUser_crackTestsLinks(5,"AP-EAMCET",rankUp_URL);
		lfp.loginUser_crackTestsLinks(6,"TS-EAMCET",rankUp_URL);
		lfp.loginUser_crackTestsLinks(7,"NEET",rankUp_URL);
		lfp.loginUser_crackTestsLinks(8,"AIIMS",rankUp_URL);
		lfp.loginUser_crackTestsLinks(9,"Bank Clerk Prelims",rankUp_URL);
		lfp.loginUser_crackTestsLinks(10,"Bank PO Prelims",rankUp_URL);
		Reporter.log("========================================Resources tests Links====================================",true);
		lfp.loginUser_resourcesTestsLinks(1,"CEO blog",blog_URL);
		lfp.loginUser_resourcesTestsLinks(2,"Articles",articles_URL);
		lfp.loginUser_resourcesTestsLinks(3,"College Predictor",collegePredictor_URL);
		Reporter.log("========================================Social Media Links====================================",true);
		String mainWindow = lfp.getMainWindowHandle();
		lfp.clickFacebookIcon();
		lfp.switchToNextWindow(mainWindow);
		lfp.assertFacebookEmbibePage();
		lfp.closeChildAndSwitchToMainWindow(mainWindow);
		lfp.clickTwitterIcon();
		lfp.switchToNextWindow(mainWindow);
		lfp.assertTwitterEmbibePage();
		lfp.closeChildAndSwitchToMainWindow(mainWindow);
		lfp.clickInstagramIcon();
		lfp.switchToNextWindow(mainWindow);
		lfp.assertInstagramEmbibePage();
		lfp.closeChildAndSwitchToMainWindow(mainWindow);
		lfp.clickYoutubeIcon();
		lfp.switchToNextWindow(mainWindow);
		lfp.assertYoutubeEmbibePage();
		lfp.closeChildAndSwitchToMainWindow(mainWindow);	
	}
}
