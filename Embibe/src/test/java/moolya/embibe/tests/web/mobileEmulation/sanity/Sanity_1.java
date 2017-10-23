package moolya.embibe.tests.web.mobileEmulation.sanity;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.mobile.LandingPage;
import moolya.embibe.pages.web.mobile.W_BasePage;
import moolya.embibe.tests.web.mobileEmulation.W_BaseTest;



public class Sanity_1 extends W_BaseTest {
	
	private W_BasePage basepage;
	private LandingPage lp;

	{
		uniqueValue = "Sanity_1";
	}
	
	@Test(dataProvider="browserData")
	public void Sanity_1test(String browser) throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchChromeMobileEmulator();
		Reporter.log("Starting Test: Sanity_1test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		Reporter.log("User is navigated to Landing Page successfully", true);
	}

}
