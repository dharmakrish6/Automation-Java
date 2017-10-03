package moolya.embibe.tests.web;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.DslPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.W_BasePage;

public class DslTest extends W_BaseTest {
	
	private LandingPage lp;
	private DslPage dslp;

	@Test
	@Parameters({"browser"})
	public void dummyTest(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchDsl(browser);
		dslp = new DslPage(wdriver);
		dslp.searchQuery("p");
		dslp.searchQuery("chemical bonding");
	}
}
