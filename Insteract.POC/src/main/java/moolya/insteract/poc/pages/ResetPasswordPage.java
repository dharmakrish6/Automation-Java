package moolya.insteract.poc.pages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage extends W_BasePage {

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="password")
	private WebElement password_TB;
	
	@FindBy(id="confirm")
	private WebElement confirmPass_TB;
	
	@FindBy(xpath="//button[text()='Reset']")
	private WebElement reset_Btn;
	
	public LoginPage resetPassword(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("ResetPassword", uniqueValue);
		sendKeysToElement(password_TB, data.get("Password"));
		sendKeysToElement(confirmPass_TB, data.get("Password"));
		clickElement(reset_Btn);
		Thread.sleep(5000);
		return new LoginPage(driver);
	}

}
