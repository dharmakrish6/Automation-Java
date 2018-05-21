package moolya.insteract.poc.pages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends W_BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="email")
	private WebElement email_TB;
	
	@FindBy(id="password")
	private WebElement password_TB;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement login_Btn;
	
	public void loginToApp(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Login", uniqueValue);
		sendKeysToElement(email_TB, data.get("Email"));
		sendKeysToElement(password_TB, data.get("Password"));
		clickElement(login_Btn);
//		return new DashboardPage(driver);
	}
	
	public void loginAs(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("Users", uniqueValue);
		sendKeysToElement(email_TB, data.get("Email"));
		sendKeysToElement(password_TB, data.get("Password"));
		clickElement(login_Btn);
	}
	
	public void loginAsEmployee() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Users", "Employee");
		sendKeysToElement(email_TB, data.get("Email"));
		sendKeysToElement(password_TB, data.get("Password"));
		clickElement(login_Btn);
	}
	
	public void loginAsApprover() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Users", "Approver");
		sendKeysToElement(email_TB, data.get("Email"));
		sendKeysToElement(password_TB, data.get("Password"));
		clickElement(login_Btn);
	}

}
