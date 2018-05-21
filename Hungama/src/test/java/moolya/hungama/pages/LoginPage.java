package moolya.hungama.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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

	@AndroidFindBy(name="Open navigation drawer")
	private MobileElement Hamburger;
	
	@AndroidFindBy(name="Log In")
	private MobileElement Login_TB;
	
	@AndroidFindBy(name="SIGN IN WITH HUNGAMA")
	private MobileElement Sign_in;

	@AndroidFindBy(name="Email / Mobile")
	private MobileElement Email;

	//@AndroidFindBy(id="com.hungama.myplay.activity:id/edit_field")
	@AndroidFindBy(xpath="//android.widget.LinearLayout[@index='0']//android.widget.LinearLayout[@index='1']//android.widget.EditText[@index='1']")
	private MobileElement Password;

	@AndroidFindBy(name="SIGN IN")
	private MobileElement Log_in;

	@AndroidFindBy(name="PRO USER")
	private MobileElement proUser_Btn;
	
	@AndroidFindBy(name="SUBSCRIBE")
	private MobileElement subscribe;
	
	@AndroidFindBy(name="Open navigation drawer")
	private MobileElement navDrawer;
	
	@AndroidFindBy(name="Navigate up")
	private MobileElement navBack;
	
	//Listen Offline with   /Unlimited Downloads!  

	public HomePage Login_Screen() throws InterruptedException{

	/*	Thread.sleep(5000);
		Hamburger.click();
		Thread.sleep(2000);*/
		waitUntilElementclickable(Sign_in);
		Sign_in.click();
		Thread.sleep(2000);
		Email.clear();
		Email.sendKeys("andm12903@mailinator.com");
		Thread.sleep(1000);
		mdriver.hideKeyboard();
		Password.sendKeys("N47Z");
		Thread.sleep(1000);
		mdriver.hideKeyboard();
		Thread.sleep(2000);
		Log_in.click();
		Reporter.log("login successful",true);
		return new HomePage(mdriver);
	}
	
}


