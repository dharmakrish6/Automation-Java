package moolya.embibe.tests.web.functional.landingPage;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.SinhalTestPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;

public class SinhalAITS_moc1 extends W_BaseTest {

	private W_BasePage basepage;
	private SinhalTestPage stp;

	@Test(dataProvider="browserData")
	public void landingPage_Test(String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, InterruptedException{
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		Reporter.log("Sinhal Jee main test on  "+ "'" + browser + "'",  true);
		stp = new SinhalTestPage(wdriver);
		stp.goToLink();
		stp.beginTest();
		Thread.sleep(5000);
		stp.moc_tift_18_advance_paper_1_Physics();
		stp.moc_tift_18_advance_paper_1_Chemistry();
		stp.moc_tift_18_advance_paper_1_Maths();
		stp.finishTest();
	}
}