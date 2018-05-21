package sunxt.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage extends BasePage{

	public SignInPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(id = "email-in") 
	private WebElement emailID;
	
	@FindBy(id = "password") 
	private WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'login')]") 
	private WebElement Login_Btn;
	
	public HomePage do_login(){
		emailID.sendKeys("sadhna@moolya.com");
		password.sendKeys("qwerty1234");
		Login_Btn.click();			
		return new HomePage(driver);	
	}
	

}
