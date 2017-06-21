package moolya.slicepay.pages.mobile.android;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.slicepay.pages.mobile.M_BasePage;

public class SignUpPage extends M_BasePage {

	public SignUpPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="indwin.c3.shareapp:id/name")
	private MobileElement name_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/email")
	private MobileElement email_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/phone")
	private MobileElement phone_TB;
	
	@FindBy(name="SIGN UP")
	private MobileElement signUp_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/otp1")
	private MobileElement otp_TB;
	
	@FindBy(name="Resend OTP")
	private MobileElement resendOtp_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/ver")
	private MobileElement verifyOtp_Btn;
	
	public void signUp(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUp", uniqueValue);
		waitUntilElementAppears(name_TB);
		name_TB.sendKeys(data.get("Name"));
		Reporter.log("Entering name : "+data.get("Name"), true);
		email_TB.sendKeys(data.get("Email"));
		Reporter.log("Entering Email : "+data.get("Email"), true);
		phone_TB.sendKeys(data.get("Phone"));
		Reporter.log("Clicking on Sign Up Button", true);
		pressBackButton();
		signUp_Btn.click();
		waitUntilElementAppears(otp_TB);
		//wait
		otp_TB.sendKeys("");
		Reporter.log("Entering OTP : ", true);
		pressBackButton();
		verifyOtp_Btn.click();
		Reporter.log("Clicked on Verify OTP Button", true);
	}

}
