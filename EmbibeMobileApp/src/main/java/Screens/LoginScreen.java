package Screens;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends BasePageMob
{

	public LoginScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(id="com.embibe.institute.sinhal.engineering:id/editLoginId")
	MobileElement loginEmailId;
	
	@AndroidFindBy(id="com.embibe.institute.sinhal.engineering:id/editPassword")
	MobileElement loginPassword;
	
	@AndroidFindBy(id="com.embibe.institute.sinhal.engineering:id/buttonLogin")
	MobileElement loginButton;

	
	
	public HomeScreen loginScreen() throws Exception
	{
		Thread.sleep(3000);
		loginEmailId.sendKeys("test01@embibe.com");
		loginPassword.sendKeys("embibe1234");
		loginButton.click();
		return new HomeScreen(driverMob);
	}
}
