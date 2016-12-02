package moolya.hungama.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends M_BasePage {

	public LoginPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	@AndroidFindBy(name="SIGN IN WITH HUNGAMA")
	private MobileElement Sign_in;

	@AndroidFindBy(name="Email / Mobile")
	private MobileElement Email;

	@AndroidFindBy(id="com.hungama.myplay.activity:id/edit_field")
	private MobileElement Password;

	@AndroidFindBy(name="SIGN IN")
	private MobileElement Log_in;


	public HomePage Subscriber_Login(){

		Email.sendKeys(" andm12903@mailinator.com");
		Password.sendKeys("N47Z");
		Log_in.click();
		Reporter.log("login successful",true);
		return new HomePage(mdriver);
	}
}


