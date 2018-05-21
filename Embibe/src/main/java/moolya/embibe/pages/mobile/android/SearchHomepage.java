package moolya.embibe.pages.mobile.android;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;

public class SearchHomepage extends MW_BasePage {

	public SearchHomepage(AppiumDriver<WebElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(mdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".react-typeahead-input.react-typeahead-usertext")
	private WebElement search_TB;
	
	public void assertSearchHomepage(){
		waitUntilElementclickable(search_TB, 20);
		Assert.assertTrue(search_TB.isDisplayed(), "Not in SearchHomepage");
		
	}

}
