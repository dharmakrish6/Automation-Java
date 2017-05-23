package moolya.slicepay.pages.mobile.android.signup;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import moolya.slicepay.pages.mobile.M_BasePage;

public class SignUp extends M_BasePage {

	public SignUp(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(mdriver, this);
		// TODO Auto-generated constructor stub
	}

}
