package moolya.embibe.pages.web;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends W_BasePage {

	public LoginPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".showRP ")
	private WebElement resetPasswordSentLogo;
	
	@FindBy(css=".please-check")
	private WebElement resetPasswordpleaseCheckMessage;
	
	@FindBy(css=".input-bor")
	private WebElement resetPasswordEmail_TB;
	
	@FindBy(css=".close-mail")
	private WebElement resetPasswordClose_Btn;
	
	@FindBy(css=".FPHead")
	private WebElement forgotPasswordHeader_Lbl;
	
	@FindBy(css=".FPMessage")
	private WebElement forgotPasswordMessage;
	
	@FindBy(id="inputvalue")
	private WebElement forgotPasswordEmail_TB;
	
	@FindBy(xpath="//button[text()='Reset Password']")
	private WebElement resetPassword_Btn;
	
	@FindBy(css=".FPAgain")
	private WebElement loginHereDiv;
	
	public void getPixelDataForgotPassword() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(forgotPasswordHeader_Lbl);
		forgotPasswordEmail_TB.sendKeys("yatheendra@moolya.com");
		getPixelData("Data", "001.1.3(D)", forgotPasswordHeader_Lbl, "forgotPasswordHeader_Lbl");
		getPixelData("Data", "001.1.3(D)", forgotPasswordMessage, "forgotPasswordMessage");
		getPixelData("Data", "001.1.3(D)", forgotPasswordEmail_TB, "forgotPasswordEmail_TB");
		getPixelData("Data", "001.1.3(D)", resetPassword_Btn, "resetPassword_Btn");
		getPixelData("Data", "001.1.3(D)", loginHereDiv, "loginHereDiv");
	}
	
	public void resetPasssword(){
		waitUntilElementclickable(forgotPasswordEmail_TB);
		resetPassword_Btn.click();
	}

	public void getPixelDataResetPassword() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(resetPasswordSentLogo);
		getPixelData("Data", "001.1.92(D)", resetPasswordSentLogo, "resetPasswordSentLogo");
		getPixelData("Data", "001.1.92(D)", resetPasswordpleaseCheckMessage, "resetPasswordpleaseCheckMessage");
		getPixelData("Data", "001.1.92(D)", resetPasswordEmail_TB, "resetPasswordEmail_TB");
		getPixelData("Data", "001.1.92(D)", resetPasswordClose_Btn, "resetPasswordClose_Btn");
	}
	
	public SearchHomepage clickResetPasswordClose(){
		waitUntilElementclickable(resetPasswordClose_Btn);
		resetPasswordClose_Btn.click();
		return new SearchHomepage(wdriver);
	}
	
	

}
