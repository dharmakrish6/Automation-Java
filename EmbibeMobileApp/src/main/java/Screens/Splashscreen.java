package Screens;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Splashscreen extends BasePageMob
{

	public Splashscreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	
	@Test
	 public LoginScreen splashScreen()
	{
		System.out.println("Launched the App successfully");
		return new LoginScreen(driverMob);
	}
}
