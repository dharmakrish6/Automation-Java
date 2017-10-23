package moolya.embibe.tests.web.functional.searchHomePage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.ChooseMissionPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SHP_Func_23 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private ChooseMissionPage cmp;
	private SearchHomepage shp;
	
	@Test(dataProvider="browserData")
	public void SHP_Func_23_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Search Home Page : SHP_Func_23 "+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		cmp = shp.clickChooseMission();
		cmp.selectGoal_and_Exam("Bank");
		cmp.selectGoal_and_Exam("Engineering");
		cmp.selectGoal_and_Exam("Medical");
		cmp.selectGoal_and_Exam("Foundation-10");
		cmp.selectGoal_and_Exam("Foundation-09");
		cmp.selectGoal_and_Exam("Foundation-08");
	}
}
