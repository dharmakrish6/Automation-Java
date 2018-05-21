package moolya.partnersgroup.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SubscriptionPage extends W_BasePage{
	public SubscriptionPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = ".//*[@id='powermail_field_marker_07']")
	private WebElement title;
	
	@FindBy(xpath = ".//*[@id='powermail_field_marker_07']/option[2]")
	private WebElement selectTitle;
	
	@FindBy(xpath = ".//*[@id='powermail_field_firstname']")
	private WebElement fname;
	
	
	
	@FindBy(xpath = ".//*[@id='powermail_field_lastname']")
	private WebElement lname;
	
	@FindBy(xpath = ".//*[@id='powermail_field_address']")
	private WebElement streetAddress;
	
	@FindBy(xpath = ".//*[@id='powermail_field_postalcode']")
	private WebElement zipCode;
	
	@FindBy(xpath = ".//*[@id='powermail_field_city']")
	private WebElement city;
	
	@FindBy(xpath = ".//*[@id='powermail_field_country']")
	private WebElement country;
	
	@FindBy(xpath = ".//*[@id='powermail_field_phone']")
	private WebElement phone;
	
	@FindBy(xpath = ".//*[@id='powermail_field_emailaddress']")
	private WebElement emailID;
	
	@FindBy(xpath = ".//*[@id='powermail_fieldwrap_9']/input")
	private WebElement submit;
	
	@FindBy(xpath = "//span[text()='Thank you. Your request was successful.']")
	private WebElement successMessage;
	
	public void subscribeNegative() throws InterruptedException{
		waitUntilElementclickable(title);
		Thread.sleep(1000);
		title.click();
		Thread.sleep(1000);
		selectTitle.click();
		Thread.sleep(1000);
		fname.sendKeys("Test Fname");
		Thread.sleep(1000);
		lname.sendKeys("Test Lname");
		Thread.sleep(1000);
		streetAddress.sendKeys("Address");
		Thread.sleep(1000);
		zipCode.sendKeys("567123");
		Thread.sleep(1000);
		city.sendKeys("Bangalore");
		Thread.sleep(1000);
		country.sendKeys("India");
		Thread.sleep(1000);
		Reporter.log("Entering Phone Number without CountryCode", true);
		phone.sendKeys("9874563210");
		Thread.sleep(1000);
		emailID.sendKeys("test@moolya.com");
		Thread.sleep(1000);
		submit.click();
	}
	
	public void subscribe() throws InterruptedException{
		waitUntilElementclickable(title);
		Thread.sleep(1000);
		title.click();
		Thread.sleep(1000);
		selectTitle.click();
		Thread.sleep(1000);
		fname.sendKeys("Test Fname");
		Thread.sleep(1000);
		lname.sendKeys("Test Lname");
		Thread.sleep(1000);
		streetAddress.sendKeys("Address");
		Thread.sleep(1000);
		zipCode.sendKeys("567123");
		Thread.sleep(1000);
		city.sendKeys("Bangalore");
		Thread.sleep(1000);
		country.sendKeys("India");
		Thread.sleep(1000);
		phone.sendKeys("+918049208888");
		Thread.sleep(1000);
		emailID.sendKeys("test@moolya.com");
		Thread.sleep(1000);
		submit.click();
	}
	
	public boolean assertSuccessMessage() throws InterruptedException{
		try{
			Thread.sleep(1000);
			successMessage.isDisplayed();
			Reporter.log("Subscription Successful", true);
			return true;
		}catch(Exception e){
			Thread.sleep(1000);
			Reporter.log("Subscription Unsuccessful", true);
			return false;
		}
	}
}


