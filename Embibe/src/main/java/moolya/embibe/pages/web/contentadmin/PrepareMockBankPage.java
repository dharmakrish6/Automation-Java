package moolya.embibe.pages.web.contentadmin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.JavaUtils;

public class PrepareMockBankPage extends W_BasePage {

	public PrepareMockBankPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[contains(@href,'checkout')]")
	private WebElement buyNowPreRegister_Btn;
	
	@FindBy(id="id_username")
	private WebElement loginUserName_TB;
	
	@FindBy(id="id_password")
	private WebElement loginPassword_TB;
	
	@FindBy(xpath="//form[contains(@action,'/checkout/login/')]/button")
	private WebElement login_Btn;
	
	@FindBy(xpath="//form[@action='/checkout/register/']//input[@id='id_username']")
	private WebElement userName_TB;
	
	@FindBy(xpath="//form[@action='/checkout/register/']//input[@id='id_email']")
	private WebElement email_TB;
	
	@FindBy(xpath="//form[@action='/checkout/register/']//input[@id='id_phone']")
	private WebElement phone_TB;
	
	@FindBy(xpath="//form[@action='/checkout/register/']//input[@id='id_password']")
	private WebElement password_TB;
	
	@FindBy(xpath="//p[@class='required']/following-sibling::button")
	private WebElement register_Btn;
	
	@FindBy(id="buy-now")
	private WebElement buyNowPostRegister_Btn;
	
	@FindBy(xpath="//a[contains(@href,'tab-voucher')]")
	private WebElement voucher_Tab;
	
	@FindBy(name="voucher")
	private WebElement voucherCode_TB;
	
	@FindBy(xpath="//button[text()='Claim']")
	private WebElement claimVoucher_Btn;
	
	@FindBy(css="#tab-voucher .pf-success")
	private WebElement success_Message;
	
	public PrepareMockBankPage clickBuyNowPreRegister(){
		waitUntilElementclickable(buyNowPreRegister_Btn, 30);
		buyNowPreRegister_Btn.click();
		return this;
	}
	
	public PrepareMockBankPage registerUser(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("PrepareMockBankData.xlsx", "Register", uniqueValue);
		waitUntilElementAppears(userName_TB, 30);
		userName_TB.sendKeys(data.get("Username"));
		email_TB.sendKeys(data.get("Email"));
		phone_TB.sendKeys(data.get("Phone"));
		password_TB.sendKeys(data.get("Password"));
		register_Btn.click();
		return this;		
	}
	
	public PrepareMockBankPage loginUser(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("PrepareMockBankData.xlsx", "Register", uniqueValue);
		waitUntilElementAppears(loginUserName_TB, 30);
		loginUserName_TB.sendKeys(data.get("Username"));
		loginPassword_TB.sendKeys(data.get("Password"));
		login_Btn.click();
		return this;		
	}
	
	public PrepareMockBankPage clickBuyNowPostRegister(){
		waitUntilElementclickable(buyNowPostRegister_Btn, 30);
		buyNowPostRegister_Btn.click();
		return this;
	}
	
	public PrepareMockBankPage goToVoucherTab() throws IOException, InterruptedException{
		waitUntilElementclickable(voucher_Tab, 30);
		Thread.sleep(2000);
		voucher_Tab.click();
		return this;
	}
	
	public PrepareMockBankPage enterVoucherCode(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("PrepareMockBankData.xlsx", "Register", uniqueValue);
		waitUntilElementAppears(voucherCode_TB, 30);
		voucherCode_TB.sendKeys(data.get("Voucher"));
		claimVoucher_Btn.click();
		waitUntilElementAppears(success_Message, 20);
		return this;
	}
	
	

}
