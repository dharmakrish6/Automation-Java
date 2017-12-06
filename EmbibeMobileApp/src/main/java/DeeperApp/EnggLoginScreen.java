package DeeperApp;

import org.openqa.selenium.support.PageFactory;

import Screens.BasePageMob;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class EnggLoginScreen extends BasePageMob
{

	public EnggLoginScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(id="com.msipl.deeper:id/buttonEngineering")
	MobileElement enggSignIn;
	
	@AndroidFindBy(id="com.msipl.deeper:id/buttonMedical")
	MobileElement medicalSignIn;
						
	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/editLoginId")
	MobileElement enggLoginEmailId;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/editLoginId")
	MobileElement medicalLoginEmailId;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/editPassword")
	MobileElement enggLoginPassword;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/editPassword")
	MobileElement medicalLoginPassword;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/buttonLogin")
	MobileElement enggLoginButton;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/buttonLogin")
	MobileElement medicalLoginButton;

	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/buttonNext")
	MobileElement engNextBtn;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/buttonNext")
	MobileElement medNextBtn;
	
	@AndroidFindBy(xpath="//*[contains(@resource-id,'imageHome')]")
	MobileElement homeImage;
	
	
	public void enggLoginScreen(String goal,String appId,String dob) throws Exception
	{
		if(goal.equalsIgnoreCase("medical")){
			//medicalSignIn.click();
			waitUntilElementAppears(medicalLoginEmailId);
			medicalLoginEmailId.sendKeys(appId);
			Thread.sleep(2000);
			closeKeyboard();
			medNextBtn.click();
			waitUntilElementAppears(medicalLoginPassword);
			medicalLoginPassword.sendKeys(dob.replaceAll("-", "/"));
			/*medicalLoginPassword.click();
			waitUntilElementclickable(date_List.get(0));
			String[] dobs = dob.split("-"); 
			selectDate(dobs[0], dobs[1], dobs[2]);*/
			waitUntilElementAppears(medicalLoginButton);
			medicalLoginButton.click();
		}
		else if(goal.equalsIgnoreCase("engineering")){
			//enggSignIn.click();
			waitUntilElementAppears(enggLoginEmailId);
			enggLoginEmailId.sendKeys(appId);
			Thread.sleep(2000);
			closeKeyboard();
			engNextBtn.click();
			waitUntilElementAppears(enggLoginPassword);
			enggLoginPassword.sendKeys(dob.replaceAll("-", "/"));
			closeKeyboard();
			/*enggLoginPassword.click();
			waitUntilElementclickable(date_List.get(0));
			String[] dobs = dob.split("-"); 
			selectDate(dobs[0], dobs[1], dobs[2]);*/
			waitUntilElementAppears(enggLoginButton);
			enggLoginButton.click();
			waitUntilElementclickable(homeImage);
		}
		
		//Reporter.log("Successfully Logged In",true);
	}
}
