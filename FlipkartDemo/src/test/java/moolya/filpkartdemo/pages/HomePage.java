package moolya.filpkartdemo.pages;

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
	
	@FindBy(xpath="//span[text()='Electronics']")
	private WebElement electronics;
	
	@FindBy(linkText="Mobiles")
	private WebElement mobiles;
	
	@FindBy(linkText="Signup")
	private WebElement signUp_Btn;
	
	@FindBy(xpath="//span[text()='Enter Mobile number']/../../../input")
	private WebElement mobileNumber_TB;
	
	@FindBy(linkText="TV")
	private WebElement tv;
	
	public MobilesPage goToMobiles(){
		waitUntilElementclickable(mobiles);
		mobiles.click();
		return new MobilesPage(wdriver);
	}
	
	public HomePage signUp(){
		waitUntilElementclickable(signUp_Btn);
		signUp_Btn.click();
		waitUntilElementAppears(mobileNumber_TB);
		mobileNumber_TB.sendKeys("7899179393");
		return this;
	}

}
