package moolya.sunnxt.webTests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.HomePage;
import moolya.sunnxt.pages.webpages.SignInPage;
import moolya.sunnxt.pages.webpages.WelcomePage;

public class LoginTest extends W_BaseTest {
	
	private WelcomePage wcp;
	private SignInPage sip;
	private HomePage hp;
	private String uniqueValue = "Login001";

	@Test
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		wcp = new WelcomePage(wdriver);
		sip = wcp.Click_SignIn();
		hp = sip.do_login(uniqueValue );
		
	
		
		
	}

}
