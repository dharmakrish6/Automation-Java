package moolya.embibe.pages.web.contentadmin;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import moolya.embibe.pages.web.W_BasePage;

public class HomePage extends W_BasePage {

	public HomePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="signin_button_blue")
	private WebElement login_Btn;
	
	@FindBy(id="new_session_email")
	private WebElement email_TB;
	
	@FindBy(id="new_session_password")
	private WebElement password_TB;
	
	@FindBy(id="signin_with_email")
	private WebElement signIn_Btn;
	
	@FindBy(className="alert-success")
	private WebElement loginSuccess_Message;
	
	public HomePage loginToContentAdmin(){
		waitUntilElementclickable(login_Btn);
		login_Btn.click();
		Reporter.log("Clicked on Login Button", true);
		waitUntilElementAppears(email_TB);
		email_TB.sendKeys("asad@embibe.com");
		Reporter.log("Entered Email: asad@embibe.com", true);
		password_TB.sendKeys("embibe123");
		Reporter.log("Entered Password: embibe123", true);
		signIn_Btn.click();
		Reporter.log("Clicked on SignIn Button", true);
		waitUntilElementAppears(loginSuccess_Message,15);
		Reporter.log("LoggedIn Successfully", true);
		return this;
	}

}
