package moolya.embibe.tests.web.dummy;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Dummy4 extends W_BaseTest {

	private W_BasePage basepage;
	private LandingPage lp;
	private SearchHomepage shp;
	
	String rearchURL="https://rearch.embibe.com";
	
	String jeeMain_URL=rearchURL+"/exams/jee-main/";
	String neet_URL=rearchURL+"/exams/neet/";
	String aiims_URL=rearchURL+"/exams/aiims/";
	String jeeAdvanced_URL=rearchURL+"/exams/iit-jee-advanced/";
	String bitsat_URL=rearchURL+"/exams/bitsat/";
	
	@Test(dataProvider="browserData")
	public void SearchHomePage_Test(String browser) throws Exception{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Functional : SearchHomePage Test"+ ", Browser is :" + browser, true);
		lp = new LandingPage(wdriver);
		Thread.sleep(5000);
		shp=lp.clickStartNow();
		Thread.sleep(5000);
		shp.searchFooterLinks(1,"JEE Main",jeeMain_URL);
		shp.searchFooterLinks(2,"JEE Advanced",jeeAdvanced_URL);
	}
}
