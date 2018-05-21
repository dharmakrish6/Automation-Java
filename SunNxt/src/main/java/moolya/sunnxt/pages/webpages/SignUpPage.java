package moolya.sunnxt.pages.webpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage extends W_BasePage{

	public SignUpPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "email") 
	private WebElement emailID;
	
	@FindBy(id = "pwd") 
	private WebElement password;
	
	@FindBy(id = "sub") 
	private WebElement Submit_Btn;
	
	@FindBy(id = "term1")
	private WebElement Agree_checkbox;
	
	public  void do_SignUp(){
		emailID.sendKeys("sadhna@moolya.com");
		password.sendKeys("qwerty1234");
		Agree_checkbox.click();
		Submit_Btn.click();			
	
	}
	
	

}
