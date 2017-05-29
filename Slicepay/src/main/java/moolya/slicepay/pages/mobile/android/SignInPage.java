package moolya.slicepay.pages.mobile.android;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.slicepay.pages.mobile.M_BasePage;

public class SignInPage extends M_BasePage {

	public SignInPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="indwin.c3.shareapp:id/phone_number")
	private MobileElement phoneNumber_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/password")
	private MobileElement password_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/Login")
	private MobileElement login_Btn;
	
	public HomePage login(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("Login", uniqueValue);
		waitUntilElementclickable(phoneNumber_TB);
		phoneNumber_TB.sendKeys(data.get("Phone Number"));
		password_TB.sendKeys(data.get("Password"));
		((AndroidDriver<MobileElement>)mdriver).pressKeyCode(AndroidKeyCode.BACK);
		login_Btn.click();
		return new HomePage(mdriver);
		
	}
	
	
	

}
