package moolya.embibe.tests.web.segmentio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.JavaUtils;
import moolya.embibe.utils.SqliteUtils;

public class SearchResultsHeadersTest{

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
	private SearchResultsPage srp;
	
	@Test
	@Parameters({"browser"})
	public void dummyTest(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.waitForResultTopicHeader();
		srp.clickEmbibeLogo();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.mouseHoverOnAsk();
		srp.clickAsk();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.mouseHoverOnStudy();
		srp.clickStudy();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.mouseHoverOnJump();
		srp.clickJump();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.mouseHoverOnRankUp();
		srp.clickRank();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.mouseHoverOnInstitutes();
		srp.clickInstitutes();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.clickEmbiumStatus();
		srp.clickProfileIcon();
		srp.clickLogin();
		loginPage = srp.clickForgotPassword();
		loginPage.clickLoginHere();
		loginPage.resetPasssword();
		loginPage.closeForgotPassword();
		srp = new SearchResultsPage(wdriver);
		srp.clickLogin();
		srp.clickFbLogin();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.clickLogin();
		srp.clickGoogleLogin();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.clickLogin();
		srp.clickRegisterHere();
		srp.clickFbSignUp();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.clickLogin();
		srp.clickGoogleSignUp();
		srp.navigateBack();
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
		srp.clickLogin();
		srp.clickRegisterHere();
		srp.clickLoginHere();
		srp.clickLogin();
		count = SqliteUtils.updateAndGetCounter();
		email = JavaUtils.getPropValue("emailPrefix")+count+"@mailinator.com";
		srp.signUp(uniqueValue, email);
		sup = srp.logout();
		sup.assertSignUpPage();
		lp = sup.goToLandingPage();
		shp = new SearchHomepage(wdriver);
		shp.enterSearchText("optics");
		srp = new SearchResultsPage(wdriver);
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
