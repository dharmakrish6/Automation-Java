package moolya.embibe.tests.web.functional.landingPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class E_Questions_without_KT extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;

	String rearchURL="https://www.embibe.com";
	
	String jeeMain_URL=rearchURL+"/exams/jee-main/";
	
	@Test(dataProvider="browserData")
	public void landingPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Engineering - Questions without KT concepts "+ "'" + browser + "'",  true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		lp.landingPageEmbibeLogo();	
		shp=lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.goToExamPageForPractice(1,"JEE Main",jeeMain_URL);
	}
}