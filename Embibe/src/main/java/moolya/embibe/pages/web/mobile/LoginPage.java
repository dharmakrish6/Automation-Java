package moolya.embibe.pages.web.mobile;

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
	
	public SearchHomepage closeForgotPassword(){
		waitUntilElementclickable(forgotPasswordClose_Btn);
		forgotPasswordClose_Btn.click();
		Reporter.log("Clicked on Close Forgot Password", true);
		return new SearchHomepage(wdriver);
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
	
	public void unRegisterUser(String email,String password) throws InterruptedException{
		invalidLogin(email,password);
		waitUntilElementAppears(unregErrWarning_Email);
		Assert.assertTrue(unregErrWarning_Email.isDisplayed(), "Failed to display the error warning for unregistered user");
		String warning=unregErrWarning_Email.getText();
		Thread.sleep(3000);
		Reporter.log("'"+warning+"' is displayed",true);
	}
	
	@FindBy(css="#showInDesktoppasswordError")
	private WebElement errWarning_password;
	
	public void invalidLoginCredentials(String email,String password) throws InterruptedException{
		unRegisterUser(email,password);
		waitUntilElementAppears(unregErrWarning_Email);
		Assert.assertTrue(errWarning_password.isDisplayed(), "Failed to display the error warning for invalid password");
		String passwordWarning=errWarning_password.getText();
		Thread.sleep(3000);
		Reporter.log("'"+passwordWarning+"' is displayed",true);	
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
	
}
