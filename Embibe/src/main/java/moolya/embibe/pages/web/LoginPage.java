package moolya.embibe.pages.web;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage extends W_BasePage {

	public LoginPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="#inputvalue")
	private WebElement emailPhone_TB;
	
	@FindBy(css=".resp-but")
	private WebElement resetPassword_Btn;
	
	@FindBy(css=".resend")
	private WebElement loginHere_Btn;
	
	@FindBy(css=".showRP ")
	private WebElement resetPasswordSentLogo;
	
	@FindBy(css=".please-check")
	private WebElement resetPasswordpleaseCheckMessage;
	
	@FindBy(css=".input-bor")
	private WebElement resetPasswordEmail_TB;
	
	@FindBy(css=".close-mail")
	private WebElement resetPasswordClose_Btn;
	
	@FindBy(css=".forgotpasswordclose")
	private WebElement forgotPasswordClose_Btn;
	
	@FindBy(css=".FPHead")
	private WebElement forgotPasswordHeader_Lbl;
	
	@FindBy(css=".FPMessage")
	private WebElement forgotPasswordMessage;
	
	@FindBy(css=".FPAgain")
	private WebElement loginHereDiv;
	
	public void getPixelDataForgotPassword() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(forgotPasswordHeader_Lbl);
		resetPasswordEmail_TB.sendKeys("yatheendra@moolya.com");
		getPixelData("Data", "001.1.3(D)", forgotPasswordHeader_Lbl, "forgotPasswordHeader_Lbl");
		getPixelData("Data", "001.1.3(D)", forgotPasswordMessage, "forgotPasswordMessage");
		getPixelData("Data", "001.1.3(D)", resetPasswordEmail_TB, "forgotPasswordEmail_TB");
		getPixelData("Data", "001.1.3(D)", resetPassword_Btn, "resetPassword_Btn");
		getPixelData("Data", "001.1.3(D)", loginHereDiv, "loginHereDiv");
	}
	
	public void clickLoginHere(){
		waitUntilElementclickable(loginHere_Btn);
		loginHere_Btn.click();
	}
	
	public void resetPasssword(){
		waitUntilElementclickable(emailPhone_TB);
		emailPhone_TB.sendKeys("yatheendra@moolya.com");
		resetPassword_Btn.click();
	}
	
	public void closeForgotPassword(){
		waitUntilElementclickable(forgotPasswordClose_Btn);
		forgotPasswordClose_Btn.click();
		Reporter.log("Clicked on Close Forgot Password", true);
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
	
	@FindBy(css="#showInDesktopemailError")
	private WebElement unregErrWarning_Email;
	
	public SearchHomepage unRegisterUser(String email,String password) throws InterruptedException{
		Thread.sleep(3000);
		invalidLogin(email,password);
		waitUntilElementAppears(unregErrWarning_Email);
		Assert.assertTrue(unregErrWarning_Email.isDisplayed(), "Failed to display the error warning for unregistered user");
		String warning=unregErrWarning_Email.getText();
		Thread.sleep(3000);
		Reporter.log("'"+warning+"' is displayed",true);
		return new SearchHomepage(wdriver);
	}
	
	@FindBy(css="#showInDesktoppasswordError")
	private WebElement errWarning_password;
	
	public SearchHomepage invalidLoginCredentials(String email,String password) throws InterruptedException{
		unRegisterUser(email,password);
		waitUntilElementAppears(unregErrWarning_Email);
		Assert.assertTrue(errWarning_password.isDisplayed(), "Failed to display the error warning for invalid password");
		String passwordWarning=errWarning_password.getText();
		Thread.sleep(3000);
		Reporter.log("'"+passwordWarning+"' is displayed",true);	
		return new SearchHomepage(wdriver);
	}
	
	@FindBy(xpath="//input[@id='inputvalue']")
	private WebElement FP_emailField;
	
	@FindBy(xpath="//button[contains(text(),'Reset Password')]")
	private WebElement resetPasswordBtn;
	
	@FindBy(xpath="//*[@id='inputvalueError']")
	private WebElement errWarning_FP_emailField;
	
	public void invalidEmail_ForgotPassword(String email) throws InterruptedException{
		enterText(FP_emailField, email);
		Reporter.log("Entered '"+email+"'",true);
		clickElement(resetPasswordBtn);
		Reporter.log("Clicked on 'Reset Password' Button",true);
		waitUntilElementAppears(errWarning_FP_emailField);
		Assert.assertTrue(errWarning_FP_emailField.isDisplayed(), "Failed to display the error warning for unregistered user");
		String warning=errWarning_FP_emailField.getText();
		Thread.sleep(3000);
		Reporter.log("'"+warning+"' is displayed",true);
	}
	
	public boolean statusOfResetPasswordBtn(String email){
		enterText(FP_emailField, email);
		Reporter.log("Entered '"+email+"'",true);
		String class1=resetPasswordBtn.getAttribute("class");
		String[] c= class1.split(" ");
		//Reporter.log("Before entering the valid email id :" + c[c.length-1] ,true);
		return c[c.length-1].equals("disabled");
	}
	
	@FindBy(xpath="(//span[@class='register-user']/a)[2]")
	private WebElement register_Btn;
	
	public SignUpPage clickRegisterHere_lp(){
		waitUntilElementclickable(register_Btn);
		register_Btn.click();
		Reporter.log("Clicked on Register Here", true);
		return new SignUpPage(wdriver);
	}
	
	public LearnPage goToLearnPage(){
		
		return new LearnPage(wdriver);
		
	}
	
}
