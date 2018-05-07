package moolya.embibe.pages.web.contentadmin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.EmbibeUtils;

public class BhashyamLogins extends W_BasePage {

	public BhashyamLogins(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="div.login-btn-conatainer span.login-btn")
	private WebElement select_login_Btn;
	
	@FindBy(xpath="//input[@name='email']")
	private WebElement loginUserName_TB;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement loginPassword_TB;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	private WebElement login_Btn;
	
	@FindBy(xpath="//*[@id='global_nav_right-profilename']")
	private WebElement profileDropdown;
	
	
	@FindBy(xpath="//*[@id='global_nav_right-logout']/span")
	private WebElement logoutBtn;
	
	private String sheetName = "Logins";
	
	@FindBy(css="span.form-error")
	private WebElement errorMessage;
	
	public BhashyamLogins clickLogin_Velociity(){
		waitUntilElementclickable(select_login_Btn, 30);
		select_login_Btn.click();
		return this;
	}
	
	public BhashyamLogins loginUser(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("BhashyamLogins.xlsx", sheetName, uniqueValue);
		waitUntilElementAppears(loginUserName_TB, 30);
		loginUserName_TB.sendKeys(data.get("Email"));
		loginPassword_TB.sendKeys(data.get("Password"));
		login_Btn.click();
		return this;		
	}
	
	LinkedHashMap<String, String> statusData;
	String status ="";
	
	public BhashyamLogins verifyBhashyamLogins(int row) throws InterruptedException, EncryptedDocumentException, NumberFormatException, InvalidFormatException, IOException{
		statusData = new LinkedHashMap<String, String>();
		try{
			waitUntilElementAppears(profileDropdown);
			mouseHoverOnElement(wdriver, profileDropdown);
			waitUntilElementclickable(logoutBtn);
			//logoutBtn.click();
			status="PASS";
			Reporter.log("PASSED",true);
			}
		catch(Exception e){
					status="FAIL";
					String err=errorMessage.getText();
					Reporter.log("Reason : "+err,true);
					Reporter.log("FAILED",true);
						}
		statusData.put("Status", status);
		return this;
	}
	
	
}
