package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SHP_Func_102 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	
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
	public void SHP_Func_102_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_102 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		shp.login();
		Reporter.log("========================================Exam Links====================================",true);
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
	}
}
