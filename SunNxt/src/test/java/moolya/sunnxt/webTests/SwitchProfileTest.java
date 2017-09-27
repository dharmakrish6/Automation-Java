package moolya.sunnxt.webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import moolya.sunnxt.pages.webpages.W_BasePage;

public class SwitchProfileTest extends W_BasePage
{

	public SwitchProfileTest(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public SubscriptionTest Credit_Subscribe() throws InterruptedException
	{
		Switch_To_New_Profile();
		return new SubscriptionTest(wdriver);
	}
}