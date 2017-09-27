package moolya.sunnxt.webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import moolya.sunnxt.pages.webpages.SignInPage;
import moolya.sunnxt.pages.webpages.W_BasePage;

public class SubscriptionTest extends W_BasePage
{

	public SubscriptionTest(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	public SubscriptionTest Credit_Subscribe(){
		
		Credit_Subscription();
		return new SubscriptionTest(wdriver);
		
//		Clk_Credit.click();
//		Credit_Crd_Num.sendKeys("");
//		Credit_Crd_Name.sendKeys("");
//		Credit_Month.sendKeys("");
//		Credit_Year.sendKeys("");
//		Credit_Cvv.sendKeys("");
//		Credit_PayNow.click();
//		return new SubscriptionTest(wdriver);
	}
	
	public SubscriptionTest Debit_Subscribe(){
		
		Debit_Subscription();
		return new SubscriptionTest(wdriver);
		
//		Clk_Debit.click();
//		Debit_Card_Type.sendKeys("");
//		Debit_Crd_Num.sendKeys("");
//		Debit_Crd_Name.sendKeys("");
//		Debit_Month.sendKeys("");
//		Debit_Year.sendKeys("");
//		Debit_Cvv.sendKeys("");
//		Debit_PayNow.click();
//		return new SubscriptionTest(wdriver);
	}
	
}
