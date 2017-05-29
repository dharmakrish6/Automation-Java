package moolya.slicepay.tests.mobile.android;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import moolya.slicepay.pages.mobile.android.SignInPage;
import moolya.slicepay.tests.mobile.M_BaseTest;

public class Dummy extends M_BaseTest {
	
	private SignInPage sip;
	private String uniqueValue = "Login001";

	@Test
	public void launchTest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		sip = new SignInPage(mdriver);
		sip.login(uniqueValue);
	}

}
