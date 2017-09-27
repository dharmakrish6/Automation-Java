package moolya.embibe.tests.web.sanity;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.sanity.W_BaseTest;

public class Sanity_1 extends W_BaseTest {
	
	private W_BasePage basepage;
	private LandingPage lp;

	{
		uniqueValue = "Sanity_1";
	}
	
	@Test(dataProvider="browserData")
	public void Sanity_1test(String browser) throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Starting Test: Sanity_1test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		Reporter.log("User is navigated to Landing Page successfully", true);
	}

}
