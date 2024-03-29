package moolya.embibe.tests.web.sanity;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class LandingPageTest extends W_BaseTest {
	
	private W_BasePage basepage;
	private LandingPage lp;

	{
		uniqueValue = "Sanity_1";
	}
	
	@Test(dataProvider="browserData")
	public void landingPageTest(String browser) throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: LandingPageTest", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		Reporter.log("User is navigated to Landing Page successfully", true);
	}

}
