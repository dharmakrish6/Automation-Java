package moolya.sunnxt.pages.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyProfilePage extends W_BasePage{
	public MyProfilePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[@class='icon-icn_edit-2']") 
	private WebElement Edit_btn;
	
	@FindBy(xpath = "//span[@class='icon-icn_switch-profile']") 
	private WebElement switch_profile_btn;
	
	@FindBy(linkText = "Subscription") 
	private WebElement Subscription;
	
	@FindBy(linkText = "Billing History") 
	private WebElement Billing_history;
	
	@FindBy(linkText = "BROWSE") 
	private WebElement Browse;
	
	
	
	

}
