package moolya.sunnxt.webTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.W_BasePage;

public class Select_Content_Language extends W_BasePage
{
	public Select_Content_Language(WebDriver driver) 
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public Select_Content_Language Language_Sel(){
		
		Do_SignIn();
		Select_Language();
//		Clk_Lang_Btn.click();
//		Sel_Tamil_Lang.click();
//		Sel_Telugu_Lang.click();
//		Sel_Kannada_Lang.click();
//		Sel_Malayalam_Lang.click();
		return new Select_Content_Language(wdriver);
	}
}
