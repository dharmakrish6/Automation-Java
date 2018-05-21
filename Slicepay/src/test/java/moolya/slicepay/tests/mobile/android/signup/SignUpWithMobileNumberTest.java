package moolya.slicepay.tests.mobile.android.signup;

import org.testng.annotations.Test;

import moolya.slicepay.pages.mobile.android.SignInPage;
import moolya.slicepay.tests.mobile.M_BaseTest;

public class SignUpWithMobileNumberTest extends M_BaseTest {

	private SignInPage sip;

	@Test
	public void signUpTest(){
		sip = new SignInPage(mdriver);
		sip.clickSignUp();
	}

}
