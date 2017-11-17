package moolya.embibe.tests.web.segmentio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.JavaUtils;
import moolya.embibe.utils.SqliteUtils;

public class HeadersTest{

	String os;
	private LandingPage lp;
	private SearchHomepage shp;
	private W_BasePage basepage;
	private WebDriver wdriver;
	private LoginPage loginPage;
	private String uniqueValue = "HeadersTest";
	private String count;
	private String email;
	private SignUpPage sup;
	
	@Test
	@Parameters({"browser"})
	public void dummyTest(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.clickEmbibeLogo();
		shp.mouseHoverOnAsk();
		shp.clickAsk();
		shp.navigateBack();
		shp.mouseHoverOnStudy();
		shp.clickStudy();
		shp.mouseHoverOnJump();
		shp.clickJump();
		shp.navigateBack();
		shp.mouseHoverOnRankUp();
		shp.clickRank();
		shp.navigateBack();
		shp.mouseHoverOnInstitutes();
		shp.clickInstitutes();
		shp.navigateBack();
		shp.clickEmbiumStatus();
		shp.clickProfileIcon();
		shp.clickLogin();
		loginPage = shp.clickForgotPassword();
		loginPage.clickLoginHere();
		loginPage.resetPasssword();
		loginPage.closeForgotPassword();
		shp = new SearchHomepage(wdriver);
		shp.clickLogin();
		shp.clickFbLogin();
		shp.navigateBack();
		shp.clickGoogleLogin();
		shp.navigateBack();
		shp.clickLogin();
		shp.clickRegisterHere();
		shp.clickFbSignUp();
		shp.navigateBack();
		shp.clickGoogleSignUp();
		shp.navigateBack();
		shp.clickLogin();
		shp.clickRegisterHere();
		shp.clickLoginHere();
		shp.clickLogin();
		count = SqliteUtils.updateAndGetCounter();
		email = JavaUtils.getPropValue("emailPrefix")+count+"@mailinator.com";
		shp.signUp(uniqueValue, email);
		sup = shp.logout();
		sup.assertSignUpPage();
		lp = sup.goToLandingPage();
		wdriver.manage().window().setSize(new Dimension(1024, 768));
		lp.clickHamburger();
		lp.closeHamburger();
		wdriver.manage().window().maximize();
		lp.clickLogin();
		lp.clickLogin();
		lp.login(uniqueValue, email);
	}
	
	@AfterMethod
	public void tearDown() throws EncryptedDocumentException, InvalidFormatException, IOException, ClassNotFoundException{
		lp = new LandingPage(wdriver);
		
		ArrayList<LinkedHashMap<String, String>> results = EmbibeUtils.getEventLogs(wdriver, this.getClass().getSimpleName());

		ArrayList<String> msgIds = SqliteUtils.storeSegmentIoResultsToDb(results);
		for(String id:msgIds)
			System.out.println("Message Id: "+id);
		
		wdriver.close();
	}

}
