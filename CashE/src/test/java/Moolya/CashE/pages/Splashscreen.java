package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class Splashscreen extends BasePage {

	public Splashscreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ivSkip")
	private MobileElement skip;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/cbAgree")
	private MobileElement tick;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibProceed")
	private MobileElement proceed;
	
	public LoginScreen skipButton(){
		try{
			waitUntilElementclickable(skip);
			skip.click();
			tick.click();
			proceed.click();
		}
		catch(Exception e){
			
		}
		return new LoginScreen(driverMob);
		
	}
}
