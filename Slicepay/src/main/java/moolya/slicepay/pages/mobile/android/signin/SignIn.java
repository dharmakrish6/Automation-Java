package moolya.slicepay.pages.mobile.android.signin;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import moolya.slicepay.pages.mobile.M_BasePage;

public class SignIn extends M_BasePage {

	public SignIn(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(mdriver, this);
		// TODO Auto-generated constructor stub
	}

}
