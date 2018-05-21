package moolya.insteract.poc.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageUserPage extends W_BasePage {

	public ManageUserPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h4[2]")
	List<WebElement> emails;
	
	@FindBy(xpath="//button[@ng-click='vm.createUser()']")
	private WebElement createUser_Btn;
	
	@FindBy(id="firstName")
	private WebElement firstName_TB;
	
	@FindBy(id="lastName")
	private WebElement lastName_TB;
	
	@FindBy(name="email")
	private WebElement email_TB;
	
	@FindBy(id="employeeID")
	private WebElement empId_TB;
	
	@FindBy(xpath="//md-switch[@aria-label='Toggle Need Approval for travel']")
	private WebElement needApprovalSwitch;
	
	@FindBy(xpath="//span[text()='Create']/..")
	private WebElement create_Btn;
	
	public void selectUserWithEmail(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Users", uniqueValue);
		for(WebElement e:emails)
			if(e.getText().contains(data.get("Email"))){
				clickElement(e);
				break;
			}
	}
	
	public void createUser(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Create User", uniqueValue);
		Thread.sleep(5000);
		clickElement(createUser_Btn);
		Thread.sleep(5000);
		sendKeysToElement(firstName_TB, data.get("First Name"));
		sendKeysToElement(lastName_TB, data.get("Last Name"));
		sendKeysToElement(email_TB, data.get("Email"));
		sendKeysToElement(empId_TB, data.get("Employee ID"));
		clickElement(needApprovalSwitch);
		clickElement(create_Btn);
	}

}
