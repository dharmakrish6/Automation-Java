package moolya.sunnxt.webTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.HomePage;



public class FilterContentLanguageTest extends W_BaseTest {
	
	
	private HomePage hp;
	
	@Test
	public void Filter_language() throws InterruptedException
	{   
		hp = new HomePage(wdriver);
		hp.select_language("Kannada");
		Thread.sleep(1000);
	}
	
	
}
