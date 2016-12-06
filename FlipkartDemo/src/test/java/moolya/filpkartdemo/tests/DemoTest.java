package moolya.filpkartdemo.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import moolya.filpkartdemo.pages.HomePage;
import moolya.filpkartdemo.utils.DbUtils;

public class DemoTest extends W_BaseTest {

	private HomePage hp;

	@Test
	public void demoTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, ClassNotFoundException{
		hp = new HomePage(wdriver);
		hp.signUp();
	}

}
