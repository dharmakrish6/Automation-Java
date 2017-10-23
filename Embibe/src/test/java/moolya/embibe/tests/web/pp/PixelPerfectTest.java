package moolya.embibe.tests.web.pp;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.ChooseMissionPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.LogoutPage;
import moolya.embibe.pages.web.LogoutSignInPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;

public class PixelPerfectTest{

	String os;
	private LandingPage lp;
	private SearchHomepage shp;
	private W_BasePage basepage;
	private WebDriver wdriver;
	private LoginPage lop;
	private SearchResultsPage srp;
	private ChooseMissionPage cmp;
	private LogoutSignInPage lsp;
	private LogoutPage loutp;
	
	@Test
	@Parameters({"browser"})
	public void dummyTest(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException {
		
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.getPixelDataLandingPage();
		shp = lp.clickSearchNow();
//		shp = lp.clickStartNow();
		shp.getPixelDataGlobalNavElements();
		shp.getPixelDataSearchHomeElements();
		shp.clickLogin();
		shp.getPixelDataLogin();
		lop = shp.clickForgotPassword();
		lop.getPixelDataForgotPassword();
		lop.resetPasssword();
		lop.getPixelDataResetPassword();
		shp = lop.clickResetPasswordClose();
		shp.clickLogin();
		shp.clickRegister();
		shp.getPixelDataSignUp();
		shp.clickGoalDropdown();
		shp.getPixelDataSignUpGoals();
		shp.refreshPage();
		cmp = shp.clickChooseMission();
		cmp.getPixelDataChooseMission();
		cmp.clickRequestMission();
		cmp.getPixelDataRequestMission();
		cmp.clickGoToChooseMission();
		cmp.selectChina();
		cmp.getPixelDataCountryChina();
		shp = cmp.clickMissionClose();
		srp = shp.searchForNonDisambiguitedKeyword("Ray Optics");
		srp.getPixelDataSearchResults();
		shp.login();
		shp.clickUserDropdown();
		shp.getPixelDataUserDropdown();
		shp.refreshPage();
		lsp = shp.logoutPP();
		lsp.getPixelDataLogoutSignIn();
		loutp = lsp.clickSignUp();
		loutp.getPixelDataLogoutSignUp();		
	}
	
	@AfterMethod
	public void tearDown(){
		wdriver.close();
	}

}
