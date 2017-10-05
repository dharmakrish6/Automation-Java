package moolya.embibe.tests.browserStack.web.suite.sanity;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.tests.browserStack.BrowserStackTestNGTest;

public class Sanity_1 extends BrowserStackTestNGTest {
	
	private LandingPage lp;

	{
		uniqueValue = "Sanity_1";
	}
	
	@Test
	public void Sanity_1test() throws IOException{
		Reporter.log("Starting Test: Sanity_1test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		lp.assertLandingPage();
		Reporter.log("User is navigated to Landing Page successfully", true);
	}

}
