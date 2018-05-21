package moolya.bookMyShow.pages.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends W_BasePage {

	public LoginPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(id="iUserName")
	public WebElement userName_TB;
	
	@FindBy(id="iPwd")
	public WebElement password_TB;
	
	@FindBy(xpath=".//*[@id='iUserNameParent']//div[text()='SIGN IN']")
	public WebElement signIn_Btn;
	
	@FindBy(id="wzrk-cancel")
	public WebElement notNow_Btn;
	
	public HomePage login() throws InterruptedException{
		waitUntilElementAppears(userName_TB);
		userName_TB.sendKeys("yathibc@gmail.com");
		password_TB.sendKeys("yathi1390");
		Thread.sleep(2000);
		signIn_Btn.click();
		return new HomePage(wdriver);
	}

}
