package moolya.embibe.pages.web.mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends W_BasePage {

	public HomePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//*[contains(@class,'embibe_btn start_eng_btn')]")
	private WebElement startForEngineering_Btn;
	
	public EngineeringPage clickStartForEngineering(){
		waitUntilElementclickable(startForEngineering_Btn);
		startForEngineering_Btn.click();
		return new EngineeringPage(wdriver);
	}

}
