package moolya.embibe.tests.web.dummy;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;

public class Dummy2 {

	private static WebDriver wdriver;
	private static W_BasePage basepage;
	private static LandingPage lp;
	private static SearchHomepage shp;

	public static void main(String[] args) throws IOException {
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp("ff");
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		//shp.assert_preciseLoction();
	}

}
