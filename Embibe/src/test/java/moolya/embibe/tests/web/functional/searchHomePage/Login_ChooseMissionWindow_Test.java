package moolya.embibe.tests.web.functional.searchHomePage;

import java.awt.AWTException;
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

public class Login_ChooseMissionWindow_Test extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private ChooseMissionPage cmp;
	
	@Test(dataProvider="browserData")
	public void login_ChooseMisson_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Login user ChooseMisson Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.login();
		cmp = shp.clickChooseMission();
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		cmp.defaultGoal();//SHP_24
		//cmp.swipeMissions_in_GoalSelectors();
		Reporter.log("====================Mission for Engineering , Exam Links====================",true);
		cmp.selectGoal_and_Exam("Engineering");
		Reporter.log("====================Mission for Medical , Exam Links====================",true);
		cmp.selectGoal_and_Exam("Medical");
		Reporter.log("====================Mission for Foundation-10 , Exam Links====================",true);
		cmp.selectGoal_and_Exam("Foundation-10");
		Reporter.log("====================Mission for Foundation-09 , Exam Links====================",true);
		cmp.selectGoal_and_Exam("Foundation-09");
		Reporter.log("====================Mission for Foundation-08 , Exam Links====================",true);
		cmp.selectGoal_and_Exam("Foundation-08");
		Reporter.log("====================Mission for Bank , Exam Links====================",true);
		cmp.selectGoal_and_Exam("Bank");
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		shp.refreshPage();
		Thread.sleep(5000);
		cmp=shp.clickChooseMission();
		cmp.countryDropdown("China");
		cmp.assertChinaRequestMissionWarning();
		cmp.countryDropdown("India");
		cmp.assertCountryIndia();	
		cmp.clickRequestMission();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
