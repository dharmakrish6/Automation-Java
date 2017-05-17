package moolya.sunnxt.webTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.SignInPage;
import moolya.sunnxt.pages.webpages.WelcomePage;

public class LoginTest extends W_BaseTest {
	
	private WelcomePage wcp;
	private SignInPage sip;
	private String uniqueValue = "Login001";

	@Test
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException{
		wcp = new WelcomePage(wdriver);
		sip = wcp.Click_SignIn();
		sip.do_login(uniqueValue );
	}

}
