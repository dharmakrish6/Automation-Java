package moolya.sunnxt.pages.webpages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends W_BasePage{

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email-in") 
	private WebElement emailID;
	
	@FindBy(id = "password") 
	private WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'login')]") 
	private WebElement Login_Btn;
	
	public HomePage do_login(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("Login", uniqueValue);
		emailID.sendKeys(data.get("User Name"));
		password.sendKeys(data.get("Password"));
		Login_Btn.click();			
		return new HomePage(driver);	
	}
	

}
