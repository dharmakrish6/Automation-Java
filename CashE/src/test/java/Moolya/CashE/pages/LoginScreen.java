package Moolya.CashE.pages;

import java.io.IOException;
//import java.util.HashMap;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends BasePage{

	public LoginScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibFacebook")
	private MobileElement facebook;
	
	@AndroidFindBy(name = "Log in to your Facebook account to connect to CASHe")
	private MobileElement login1;
	
	@AndroidFindBy(name="Email address or phone number")
	private MobileElement username;
	
	@AndroidFindBy(id="u_0_1")
	private MobileElement password;
	
	@AndroidFindBy(id="com.android.packageinstaller:id/permission_allow_button")
	private MobileElement allow;
	
	@AndroidFindBy(name="Log In")
	private MobileElement login;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibLinkedIn")
	private MobileElement linkedin;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibGoogle")
	private MobileElement google;
	
	@AndroidFindBy(id = "com.google.android.gms:id/account_display_name")
	private MobileElement account;
	
	@AndroidFindBy(name="Choose account for CASHe")
	private MobileElement choose;
	
	@AndroidFindBy(name="CANCEL")
	private MobileElement cancel;
	
	@AndroidFindBy(name = "WHO I AM")
	private MobileElement whoIam;
	
	@AndroidFindBy(name = "DOCUMENTS REQUIRED")
	private MobileElement document;

	private HashMap<String, String> data;

	//private HashMap<String, String> data;
	
	public  WhoIAmScreen loginMethod(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		//public  CasheYouCanGet loginMethod(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{

		data = readDataMap("Main", uniqueValue);
		String flowSheetName = data.get("Work Flow");
		data = readDataMap(flowSheetName, uniqueValue);
		String type= data.get("Type");
		
//		String type =uniqueValue;
		// try catch for all login to be done ***
		if(type.equalsIgnoreCase("Facebook"))
		{
			facebook.click();
			/*waitUntilElementAppears(login1);
			username.sendKeys("ipaybridge6@gmail.com");
			password.sendKeys("cashe123");
			login.click();*/
		}
		else if(type.equalsIgnoreCase("LinkedIn"))
			linkedin.click();
		else
		{
			try{
				google.click();
			waitUntilElementAppears(choose);
			account.click();
			}
			catch(Exception e){
				//Add Account
			}
		}
		//try{
			waitUntilElementclickable(cancel);
			cancel.click();
			//allow.click();
			//allow.click();
			//whoIam.isDisplayed();
		//}
		//catch(Exception e){
			//need to implement
		//}
		return new WhoIAmScreen(driverMob);
			
			
			//return new CasheYouCanGet(driverMob);
	}
	

}
