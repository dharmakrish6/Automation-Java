package moolya.embibe.pages.web;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends W_BasePage {

	public LogoutPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="div.score-higher.header-form")
	private WebElement embibeScoreHigher;
	
	@FindBy(css="h1.header-form")
	private WebElement haveAnAccount;
	
	@FindBy(css=".signin-para")
	private WebElement continueScoreImprovement;
	
	@FindBy(css=".signincontinue.clearfix a.login-logout-button")
	private WebElement signIn_Btn;
	
	@FindBy(css=".signup-div.clearfix>p")
	private WebElement signUpToAccessData;
	
	@FindBy(css=".form-control.emailField")
	private WebElement formEmailField;
	
	@FindBy(css=".form-control.passwordField")
	private WebElement formPasswordField;
	
	@FindBy(css=".form-control.passwordConfirmField")
	private WebElement formConfirmPasswordField;
	
	@FindBy(css=".form-wrap.loginsignup-container+a")
	private WebElement signUp_Btn;

	
	public void getPixelDataLogoutSignUp() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(embibeScoreHigher);
		getPixelData("Data", "logout signup D", embibeScoreHigher, "embibeScoreHigher");
		getPixelData("Data", "logout signup D", haveAnAccount, "haveAnAccount");
		getPixelData("Data", "logout signup D", continueScoreImprovement, "continueScoreImprovement");
		getPixelData("Data", "logout signup D", signIn_Btn, "signIn_Btn");
		getPixelData("Data", "logout signup D", signUpToAccessData, "signUpToAccessData");
		getPixelData("Data", "logout signup D", formEmailField, "formEmailField");
		getPixelData("Data", "logout signup D", formPasswordField, "formPasswordField");
		getPixelData("Data", "logout signup D", formConfirmPasswordField, "formConfirmPasswordField");
		getPixelData("Data", "logout signup D", signUp_Btn, "signUp_Btn");
	}

}
