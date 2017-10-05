package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SignUpPage extends W_BasePage {

	public SignUpPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="emailArea")
	private WebElement email_TB;
	
	@FindBy(id="passwordArea")
	private WebElement password_TB;
	
	@FindBy(id="passwordConfirmArea")
	private WebElement confirmPassword_TB;
	
	@FindBy(name="passwordConfirm")
	private WebElement confirmResetPassword_TB;
	
	@FindBy(css=".forgotpassword")
	private WebElement forgotPassword_Btn;
	
	@FindBy(xpath="//a[@class='login-logout-button' and text()='Sign In']")
	private WebElement login_Btn;
	
	@FindBy(css=".account-signup")
	private WebElement expandSignUp_Btn;
	
	@FindBy(css=".Dropdown-control ")
	private WebElement goalSignUp_DD;
	
	@FindBy(css=".Dropdown-menu .Dropdown-option")
	private List<WebElement> goalItems_List;
	
	@FindBy(xpath="//a[@class='login-logout-button' and text()='Sign Up']")
	private WebElement signUp_Btn;
	
	@FindBy(id="inputvalue")
	private WebElement forgotPasswordEmail_TB;
	
	@FindBy(css=".close-mail")
	private WebElement closeForgotPassword_Btn;
	
	@FindBy(xpath="//button[text()='Reset Password']")
	private WebElement resetPassword_Btn;
	
	@FindBy(css=".resetSubmit")
	private WebElement resetSubmit_Btn;
	
	@FindBy(css=".responsebox a[href='/signup']")
	private WebElement resetOk_Btn;
	
	
	public SearchHomepage loginSignUpPage(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		email_TB.sendKeys(email);
		Reporter.log("Entered Email/Phone: "+email, true);
		password_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		login_Btn.click();
		Reporter.log("Clicked Login", true);
		return new SearchHomepage(wdriver);
	}
	
	public void assertSignUpPage(){
		waitUntilElementAppears(email_TB);
		Assert.assertTrue(email_TB.isDisplayed(), "Not in SignUp Page");
		Reporter.log("In SignUp Page", true);
	}
	
	public void expandSignIn(){
		waitUntilElementclickable(login_Btn);
		clickElement(login_Btn, "Clicked Login");
	}
	
	public void expandSignUp(){
		waitUntilElementclickable(expandSignUp_Btn);
		expandSignUp_Btn.click();
		Reporter.log("Clicked on SignUp", true);
	}
	
	public SearchHomepage signUpSignUpPage(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		email_TB.sendKeys(email);
		Reporter.log("Entered Email/Phone: "+email, true);
		selectCustomDropdown(goalSignUp_DD, goalItems_List, data.get("Goal"), "Selected Goal: "+data.get("Goal"));
		password_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		confirmPassword_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Confirm Password: "+data.get("Password"), true);
		signUp_Btn.click();
		Reporter.log("Clicked SignUp", true);
		return new SearchHomepage(wdriver);
	}
	
	public void clickForgotPasswordSignUpPage(String email){
		waitUntilElementclickable(forgotPassword_Btn);
		forgotPassword_Btn.click();
		Reporter.log("Clicked on Forgot Password", true);
		waitUntilElementclickable(forgotPasswordEmail_TB);
		forgotPasswordEmail_TB.sendKeys(email);
		Reporter.log("Entered Email: "+email, true);
		resetPassword_Btn.click();
		Reporter.log("Clicked on Reset Password", true);
		waitUntilElementclickable(closeForgotPassword_Btn);
		closeForgotPassword_Btn.click();
	}
	
	public void resetPassword(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(password_TB);
		password_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		confirmResetPassword_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Confirm Password: "+data.get("Password"), true);
		resetSubmit_Btn.click();
		Reporter.log("Clicked on Submit", true);
		waitUntilElementclickable(resetOk_Btn);
		resetOk_Btn.click();
		Reporter.log("Clicked on Submit", true);
	}

}
