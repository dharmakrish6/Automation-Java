package moolya.bookMyShow.pages.mobilePages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginScreen extends M_BasePage {

	public LoginScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		waitUntilElementAppears(login_Title);
		Assert.assertTrue(login_Title.isDisplayed(), "Not in Login Screen");
	}
	
	@AndroidFindBy(id="com.bt.bms:id/txvTitle")
	public MobileElement login_Title;
	
	@AndroidFindBy(id="com.bt.bms:id/edtemail")
	public MobileElement email_TB;
	
	@AndroidFindBy(id="com.bt.bms:id/edtpass")
	public MobileElement password_TB;
	
	@AndroidFindBy(id="com.bt.bms:id/signin")
	public MobileElement signIn_Btn;
	
	public HomeScreen login(){
		email_TB.sendKeys("yathibc@gmail.com");
		password_TB.sendKeys("yathi1390");
		signIn_Btn.click();
		return new HomeScreen(mdriver);
	}
	
	

}
