package moolya.bookMyShow.pages.mobilePages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends M_BasePage {

	public HomeScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
//		waitUntilElementAppears(bms_Logo);
//		Assert.assertTrue(bms_Logo.isDisplayed(), "Not in Home Screen");
	}
	
	@AndroidFindBy(id="com.bt.bms:id/logo")
	public MobileElement bms_Logo;
	
	@AndroidFindBy(id="com.bt.bms:id/tab_tickets")
	public MobileElement tickets_Tab;
	
	@AndroidFindBy(name="YOU")
	public MobileElement user_Tab;
	
	@AndroidFindBy(id="com.bt.bms:id/txvLocation")
	public MobileElement location_Btn;
	
	public ProfileScreen goToProfileScreen(){
		waitUntilElementclickable(user_Tab);
		user_Tab.click();
		return new ProfileScreen(mdriver);
	}
	
	public TicketsScreen goToTicketsScreen(){
		waitUntilElementclickable(tickets_Tab);
		tickets_Tab.click();
		return new TicketsScreen(mdriver);
	}
	
	
	

}
