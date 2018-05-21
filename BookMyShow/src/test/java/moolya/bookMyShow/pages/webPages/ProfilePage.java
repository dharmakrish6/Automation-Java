package moolya.bookMyShow.pages.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends W_BasePage {

	public ProfilePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(xpath="//*[@href='/myprofile/quikpay']")
	public WebElement quickpay_Btn;
	
	public QuickPayPage selectQuickPay(){
		waitUntilElementclickable(quickpay_Btn);
		quickpay_Btn.click();
		return new QuickPayPage(wdriver);
	}
	
	
	
	

}
