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

public class RequestMissionWindowTest extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private ChooseMissionPage cmp;
	
	@Test(dataProvider="browserData")
	public void RequestMisson_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : Request a Mission Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		cmp = shp.clickChooseMission();
		cmp.selectChina();//SHP_28
		cmp.countryDropdown("China");
		cmp.assertChinaRequestMissionWarning();
		cmp.chinaRequestMission();//SHP_29
		cmp.submitExam("JEE");
		cmp.countryDropdown("China");//SHP_30
		shp=cmp.chinaStudy();
		cmp=shp.clickChooseMission();//SHP_31
		cmp.countryDropdown("India");
		cmp.indiaRequestMission();
		cmp.enterExam("J");//SHP_32
		cmp.addNewExam("Comed-K");//SHP_33
		cmp.gotoChooseMissionInThankYouPage();
		cmp.countryDropdown("India");//SHP_34
		cmp.indiaRequestMission();
		cmp.submitExam("JEE");
		cmp.countryDropdown("India");//SHP_35
		cmp.indiaRequestMission();
		cmp.verifyAutosuggestionList("J");
		cmp.maxExamSelection("E");//SHP_36
		cmp.requestBackToChooseMissionPage("J");//SHP_37
		cmp.indiaRequestMission();//SHP_38
		cmp.assertClearSearchExamSelection("J");
		cmp.addExam("main");//SHP_39
		cmp.removeExam();
		cmp.countryDropdown("India");//SHP_40
		cmp.clearDropdown("main");
		cmp.clearDropdown("comed-k");
		cmp.submitSpecifiedExam("main");//SHP_41
		cmp.clickGoToChooseMission();
		cmp.indiaRequestMission();
		cmp.submitSpecifiedExam("main");//SHP_42
		cmp.gotoChooseMissionInThankYouPage();
		
	}
}
