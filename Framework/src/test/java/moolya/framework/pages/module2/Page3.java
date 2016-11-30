package moolya.framework.pages.module2;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import moolya.framework.pages.BasePage;

public class Page3 extends BasePage {

	public Page3(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "sdfb")
	public WebElement pageTitle_LBL;
	
	public Page3 verifyPageTitle(){
		Assert.assertEquals(pageTitle_LBL.getText(), "Welcome", "PageTitle does not match");
		return this;// if there is not transition between pages then
					// method should return the object of current page "this"
	}

}
