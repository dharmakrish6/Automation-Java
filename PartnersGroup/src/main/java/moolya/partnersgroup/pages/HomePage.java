package moolya.partnersgroup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class HomePage extends W_BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText = "Subscribe")
	private WebElement subscribe;
	
	@FindBy(linkText = "Contact")
	private WebElement contact;
	
	@FindBy(className = "searchField")
	private WebElement searchField;
	
	public SubscriptionPage clickSubscribe() throws InterruptedException{
		waitUntilElementclickable(subscribe);
		Thread.sleep(1000);
		subscribe.click();
		Reporter.log("Clicked on Subscribe", true);
		return new SubscriptionPage(driver);
	}
	
	public ContactPage clickContact() throws InterruptedException{
		waitUntilElementclickable(contact);
		Thread.sleep(1000);
		contact.click();
		Reporter.log("Clicked on Contact", true);
		return new ContactPage(driver);
	}
	
	public SearchPage search(String itemName){
		waitUntilElementAppears(searchField);
		searchField.sendKeys(itemName);
		searchField.submit();
		Reporter.log("Searching for "+itemName, true);
		return new SearchPage(driver);
	}
	
}
