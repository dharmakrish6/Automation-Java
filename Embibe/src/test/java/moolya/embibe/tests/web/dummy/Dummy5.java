package moolya.embibe.tests.web.dummy;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.MyProfilePage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Dummy5 extends W_BaseTest {
	
	private LandingPage lp;
	private SearchHomepage shp;
	private MyProfilePage mpp;
	
	@Test(dataProvider="browserData")
	public void dummy3Test(String browser) throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
//		expected.add("https://rearch.embibe.com");
//		actual.add(wdriver.getCurrentUrl());
//		equalMessages.add("Url Not Matching");
		shp = lp.clickStartNow();
	}
	

}
