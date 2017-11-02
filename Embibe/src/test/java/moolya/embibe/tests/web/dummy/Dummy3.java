package moolya.embibe.tests.web.dummy;

import java.io.IOException;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class Dummy3 extends W_BaseTest {
	
	private LandingPage lp;
	private SearchHomepage shp;

	@Test(dataProvider="browserData")
	public void dummy3Test(String browser) throws IOException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		SoftAssert sa = new SoftAssert();
		String url = "https://rearch-staging3.embibe.com/landing";
		String aurl = wdriver.getCurrentUrl();
		sa.assertTrue(url.equals(aurl), "Url Not Matching, Actual: "+aurl+" Expected: "+url);
		String title = "Embibe.com";
		String atitle = wdriver.getTitle();
		sa.assertTrue(atitle.equals(title), "Page Title Not Matching, Actual: "+atitle+" Expected: "+title);
		shp = lp.clickStartNow();
		shp.waitforSearchHomePage();
//		sa.assertAll();
	}
	

}
