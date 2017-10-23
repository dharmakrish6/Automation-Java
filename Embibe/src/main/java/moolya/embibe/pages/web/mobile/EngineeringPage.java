package moolya.embibe.pages.web.mobile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EngineeringPage extends W_BasePage {

	public EngineeringPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="(//a[text()='Test'])[1]")
	private WebElement test_Btn;

	public TestPage clickTestTab(){
		waitUntilElementclickable(test_Btn);
		test_Btn.click();
		return new TestPage(wdriver);
	}
	
}
