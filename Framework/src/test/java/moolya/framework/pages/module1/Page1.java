package moolya.framework.pages.module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moolya.framework.pages.BasePage;
import moolya.framework.pages.module2.Page3;

public class Page1 extends BasePage {

	public Page1(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//@FindBy is page factory concept of selenium to store webpage objects
	@FindBy(id = "asdf") //locators vary depending on application
	private WebElement userName_TB;
	
	@FindBy(id = "zdfgd")
	private WebElement password_TB;
	
	@FindBy(id = "login")
	private WebElement login_Btn;
	
	//method for login functionality in this page 
	public Page3 login(){
		userName_TB.sendKeys("hahsvd");
		password_TB.sendKeys("asdasf");
		login_Btn.click();			// if there is transition from one page to another then 
		return new Page3(driver);	// method will return new object another page
	}

}
