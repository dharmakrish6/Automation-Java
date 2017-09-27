package moolya.embibe.tests.web;

import java.io.IOException;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testautomationguru.ocular.comparator.OcularResult;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.W_BasePage;

public class SearchResultsTest extends W_BaseTest {

	private LandingPage lp;
	private SearchHomepage shp;
	private SearchResultsPage srp;
	private OcularResult or;

	@Test
	@Parameters({"browser"})
	public void searchResultsTest(@Optional("chrome")String browser) throws IOException {
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		shp = lp.clickStartNow();
//		shp.assertSearchHomepage();
//		srp = shp.clickOnSearchResultsPage();
//		or = srp.checkShowResultsForEngineeringButton();
//		System.out.println("Engineering Button...");
//		System.out.println("Is Images Equal? "+or.isEqualsImages());
//		System.out.println("Comparison Status: "+or.getComparisonStatus());
//		System.out.println("Similarity: "+or.getSimilarity());
//		System.out.println("Medical Button...");
//		or = srp.checkShowResultsForMedicalButton();
//		System.out.println("Is Images Equal? "+or.isEqualsImages());
//		System.out.println("Comparison Status: "+or.getComparisonStatus());
//		System.out.println("Similarity: "+or.getSimilarity());
	}

}
