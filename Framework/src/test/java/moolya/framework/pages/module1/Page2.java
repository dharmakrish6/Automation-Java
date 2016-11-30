package moolya.framework.pages.module1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moolya.framework.pages.BasePage;

public class Page2 extends BasePage {

	public Page2(WebDriver driverWeb) {
		super(driverWeb);
		PageFactory.initElements(driverWeb, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//*")
	private WebElement sbd;
	
	public void wait11(){
		waitUntilElementAppears(sbd);
	}

}
