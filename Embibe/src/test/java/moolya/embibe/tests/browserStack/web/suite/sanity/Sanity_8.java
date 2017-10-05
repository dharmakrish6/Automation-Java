package moolya.embibe.tests.browserStack.web.suite.sanity;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.ChooseMissionPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.tests.browserStack.BrowserStackTestNGTest;
import moolya.embibe.utils.SqliteUtils;

public class Sanity_8 extends BrowserStackTestNGTest {

	private LandingPage lp;
	private SearchHomepage shp;
	String searchKeyword;
	String searchText;
	String email;
	private ChooseMissionPage cmp;
	private String count;

	{
		uniqueValue = "Sanity_8";
	}
	
	@Test
	public void Sanity_8test() throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException, ClassNotFoundException{
		count = SqliteUtils.updateAndGetCounter();
		email = "embibe.auto"+count+"@mailinator.com";
		Reporter.log("Starting Test: Sanity_8test", true);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		cmp = shp.clickChooseMission();
		cmp.clickRequestMission();
		cmp.requestMission(uniqueValue);
		
	}
}
