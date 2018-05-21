package moolya.embibe.pages.web.contentadmin;

import java.io.IOException;
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

public class DeekshaRankupLogins extends W_BasePage {

	public DeekshaRankupLogins(WebDriver wdriver) {
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
	
	private String sheetName = "RankupLogins";
	
	@FindBy(css="span.form-error")
	private WebElement errorMessage;
	
	public DeekshaRankupLogins clickLogin_deeksha(){
		waitUntilElementclickable(select_login_Btn, 30);
		select_login_Btn.click();
		return this;
	}
	
	@FindBy(xpath="//button[text()='LOGIN']")
	private WebElement rankup_login;
	
	@FindBy(css="#md-input-0-input")
	private WebElement rankup_email;
	
	@FindBy(css="#md-input-1-input")
	private WebElement rankup_password;
	
	@FindBy(css="a.btn.login-btn")
	private WebElement rankup_loginBtn;
	
	@FindBy(css="img.profile-icon")
	private WebElement rankup_profileIcon;
	
	@FindBy(xpath="//*[text()='Log Out']")
	private WebElement rankup_logoutBtn;
	
	
	public DeekshaRankupLogins rankupLogins(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("DeekshaRankupLogins.xlsx", sheetName, uniqueValue);
		waitUntilElementAppears(rankup_login, 30);
		clickElement(rankup_login);
		rankup_email.sendKeys(data.get("Email"));
		rankup_password.sendKeys(data.get("Password"));
		rankup_loginBtn.click();
		try{
			waitUntilElementAppears(rankup_profileIcon);
			mouseHoverOnElement(wdriver, rankup_profileIcon);
			waitUntilElementclickable(rankup_logoutBtn);
			Reporter.log("PASSED",true);
			}
		catch(Exception e){
					Reporter.log("FAILED",true);
						}
		return this;		
	}
	
	LinkedHashMap<String, String> statusData;
	String status ="";
	
	public DeekshaRankupLogins verifyDeekshaLogins(int row) throws InterruptedException, EncryptedDocumentException, NumberFormatException, InvalidFormatException, IOException{
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
		//EmbibeUtils.writeDeekshaLoginStatus(sheetName, statusData,Integer.parseInt(row)+1);
		//System.out.println((Integer.parseInt(row)+1)+" completed");
		return this;
	}
	
	
}
