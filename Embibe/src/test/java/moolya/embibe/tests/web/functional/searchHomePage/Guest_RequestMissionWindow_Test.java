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

public class Guest_RequestMissionWindow_Test extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	private ChooseMissionPage cmp;
	
	@Test(dataProvider="browserData")
	public void guest_RequestMisson_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, AWTException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional flow : Guest 'Request a Mission Test' on browser :-  "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		Thread.sleep(5000);
		cmp = shp.clickChooseMission();
		Reporter.log("======================================China Request a Misson=================================",true);
		cmp.countryDropdown("China");
		cmp.assertChinaRequestMissionWarning();
		cmp.chinaRequestMission();//SHP_29
		cmp.addNewExam("Comed-K");//For china
		cmp.gotoChooseMissionInThankYouPage();
		shp=cmp.chinaStudy();
		Reporter.log("======================================India Request Misson=================================",true);
		cmp=shp.clickChooseMission();
		cmp.countryDropdown("India");
		cmp.clickRequestMission();
		cmp.submitExam("JEE");
		cmp.clickRequestMission();
		cmp.clickBackButton_RequestMission();
		//cmp.closeMissonPage();
		Reporter.log("======================================Add New Exam=================================",true);
		//cmp.click_CM();
		cmp.clickRequestMission();
		cmp.addNewExam("Comed-K");//SHP_33 //For india
		Reporter.log("======================================Maximum Exam Selection=================================",true);
		cmp.gotoChooseMissionInThankYouPage();
		cmp.indiaRequestMission();
		cmp.maxExamSelection("E");//SHP_36
		Reporter.log("======================================Clearing exam text field > Select Exam > Submit =================================",true);
		cmp.requestBackToChooseMissionPage("J");//SHP_37
		/*shp.assertSearchHomepage();
		cmp=shp.clickChooseMission();*/
		cmp.countryDropdown("India");
		cmp.indiaRequestMission();
		cmp.verifyAutosuggestionList("J");
		cmp.verifyAutosuggestionList("J");
		cmp.removeExam();
		Reporter.log("------------------------------------------TEST COMPLETED------------------------------------------",true);
	}
}
