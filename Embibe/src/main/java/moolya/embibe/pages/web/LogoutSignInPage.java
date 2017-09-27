package moolya.embibe.pages.web;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutSignInPage extends W_BasePage {

	public LogoutSignInPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	//
	
	@FindBy(css="div.score-higher.header-form")
	private WebElement embibeScoreHigher;
	
	@FindBy(css=".form-control.emailField")
	private WebElement formEmailField;
	
	@FindBy(css=".form-control.passwordField")
	private WebElement formPasswordField;
	
	@FindBy(css=".login-logout-button")
	private WebElement signIn_Btn;
	
	@FindBy(css=".forgotpassword")
	private WebElement forgotPassword;
	
	@FindBy(css=".signup.clearfix h3")
	private WebElement dontHaveAccount;
	
	@FindBy(css=".signup.clearfix p")
	private WebElement embibeGuide;
	
	@FindBy(css=".account-signup")
	private WebElement signUp_Btn;

	
	public void getPixelDataLogoutSignIn() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(embibeScoreHigher);
		getPixelData("Data", "logout signin D", embibeScoreHigher, "embibeScoreHigher");
		getPixelData("Data", "logout signin D", signIn_Btn, "signIn_Btn");
		getPixelData("Data", "logout signin D", formEmailField, "formEmailField");
		getPixelData("Data", "logout signin D", formPasswordField, "formPasswordField");
		getPixelData("Data", "logout signin D", signUp_Btn, "signUp_Btn");
		getPixelData("Data", "logout signin D", forgotPassword, "forgotPassword");
		getPixelData("Data", "logout signin D", dontHaveAccount, "dontHaveAccount");
		getPixelData("Data", "logout signin D", embibeGuide, "embibeGuide");
	}
	
	public LogoutPage clickSignUp(){
		waitUntilElementclickable(signUp_Btn);
		signUp_Btn.click();
		return new LogoutPage(wdriver);
	}

}
