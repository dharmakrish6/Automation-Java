package moolya.embibe.pages.mobile.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;

public class LandingPage extends MW_BasePage {

	public LandingPage(AppiumDriver<WebElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(mdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='get-started' and text()='START NOW']")
	private WebElement startNow_Btn;

	@FindBy(xpath="//a[@class='get-started' and text()='SEARCH NOW']")
	private WebElement searchNow_Btn;

	public SearchHomepage clickStartNow() {
		clickElement(startNow_Btn);
		return new SearchHomepage(mdriver);
	}
	
	public SearchHomepage clickSearchNow() {
		clickElement(searchNow_Btn);
		return new SearchHomepage(mdriver);
	}
	
	

}
