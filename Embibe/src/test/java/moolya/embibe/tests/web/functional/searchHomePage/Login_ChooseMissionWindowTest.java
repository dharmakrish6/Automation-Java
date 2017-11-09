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

public class Login_ChooseMissionWindowTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private ChooseMissionPage cmp;
	{
		uniqueValue = "Sanity_3";
		uniqueValue2 = "Sanity_12";
	}
	
	@Test(dataProvider="browserData")
	public void ChooseMisson_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : ChooseMisson Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.login();
		cmp = shp.clickChooseMission();
		//cmp.swipeMissions_in_GoalSelectors();
		cmp.selectGoal_and_Exam("Engineering");
		cmp.selectGoal_and_Exam("Medical");
		cmp.selectGoal_and_Exam("Foundation-10");
		cmp.selectGoal_and_Exam("Foundation-09");
		cmp.selectGoal_and_Exam("Foundation-08");
		cmp.selectGoal_and_Exam("Bank");
		shp=cmp.clickMissionClose();
		cmp=shp.clickChooseMission();
		cmp.countryDropdown("China");
		cmp.assertChinaRequestMissionWarning();
		cmp.countryDropdown("India");
		cmp.assertCountryIndia();	
		cmp.clickRequestMission();
	}
}
