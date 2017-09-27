package moolya.embibe.pages.mobile.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MW_BasePage extends MW_SuperBasePage{

	public MW_BasePage(AppiumDriver<WebElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(mdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="span.glyphicon-menu-hamburger")
	private WebElement navigationDrawerOpen_Btn;
	
	@FindBy(css="close-side-options")
	private WebElement navigationDrawerClose_Btn;
	
	@FindBy(xpath="//ul[@class='responsive-nav-options']//a[text()='SEARCH']")
	private WebElement searchOption;
	
	@FindBy(xpath="//ul[@class='responsive-nav-options']//a[text()='SEARCH-RESULTS']")
	private WebElement searchResultsOption;
	
	@FindBy(xpath="//ul[@class='responsive-nav-options']//a[text()='LEARN']")
	private WebElement learnOption;
	
	@FindBy(xpath="//ul[@class='responsive-nav-options']//a[text()='AI']")
	private WebElement aiOption;
	
	@FindBy(xpath="//ul[@class='responsive-nav-options']//a[text()='ASK']")
	private WebElement askOption;
	
}
