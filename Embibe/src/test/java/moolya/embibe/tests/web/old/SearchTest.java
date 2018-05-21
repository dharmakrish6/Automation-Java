package moolya.embibe.tests.web.old;

import java.io.IOException;
import java.text.DecimalFormat;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.tests.web.W_BaseTest;
import moolya.embibe.utils.SqliteUtils;

public class SearchTest extends W_BaseTest {

	private LandingPage lp;
	private SearchHomepage sp;

	@Test
	@Parameters({"browser"})
	public void searchTest(@Optional("chrome")String browser) throws IOException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
//		basepage = new W_BasePage(wdriver);
//		wdriver = basepage.launchWebApp(browser);
//		int width = wdriver.manage().window().getSize().width;
//		int height = wdriver.manage().window().getSize().height;
//		System.out.println(width);
//		System.out.println(height);
//		basepage.writePixelData("", "searchSlogan", "D_Guest 1st time user", "a_"+"width", "657px");
//		System.out.println("auto".replaceAll("px", "").matches("[a-zA-Z]+"));
		SqliteUtils.getEmails();
	}

}
