package moolya.embibe.tests.web.old;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.ChooseMissionPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.LogoutPage;
import moolya.embibe.pages.web.LogoutSignInPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;

public class GetPixelDataOnMac {

	private static LandingPage lp;
	private static SearchHomepage shp;
	private static W_BasePage basepage;
	private static WebDriver wdriver;
	private static LoginPage lop;
	private static SearchResultsPage srp;
	private static ChooseMissionPage cmp;
	private static LogoutSignInPage lsp;
	private static LogoutPage loutp;
	
	@Test
	@Parameters({"browser"})
	public void dummyTest(@Optional("chrome")String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException {
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp("grid");
		wdriver.manage().window().setSize(new Dimension(1440, 900));
		lp = new LandingPage(wdriver);
		lp.getPixelDataLandingPage();
		shp = lp.clickSearchNow();
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
		srp = shp.searchForNonDisambiguitedKeyword("Motion of Satellite");
		srp.getPixelDataSearchResults();
		shp.login();
		shp.clickUserDropdown();
		shp.getPixelDataUserDropdown();
		shp.refreshPage();
		lsp = shp.signOut();
		lsp.getPixelDataLogoutSignIn();
		loutp = lsp.clickSignUp();
		loutp.getPixelDataLogoutSignUp();
	}
	
	@AfterMethod
	public void tearDown(){
		wdriver.close();
	}

}
