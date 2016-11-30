package moolya.bookMyShow.pages.mobilePages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProfileScreen extends M_BasePage {

	public ProfileScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="com.bt.bms:id/login_bt")
	public MobileElement login_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/fav_venue_tv")
	public MobileElement favoriteVenues_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/quik_pay_tv")
	public MobileElement quickPay_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/rightMenu")
	public MobileElement settings_Btn;
	
	@AndroidFindBy(name="LOGOUT")
	public MobileElement logout_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/yes_bt")
	public MobileElement yes_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/no_bt")
	public MobileElement no_Btn;
	
	public LoginScreen goToLoginPage(){
		waitUntilElementclickable(login_Btn);
		login_Btn.click();
		return new LoginScreen(mdriver);
	}
	
	public FavoriteVenuesScreen goToFavoriteVenues(){
		waitUntilElementclickable(favoriteVenues_Btn);
		favoriteVenues_Btn.click();
		return new FavoriteVenuesScreen(mdriver);
	}
	
	public QuickPayScreen goToQuickPay(){
		waitUntilElementclickable(quickPay_Btn);
		quickPay_Btn.click();
		return new QuickPayScreen(mdriver);
	}
	
	public ProfileScreen goToSettings(){
		waitUntilElementclickable(settings_Btn);
		settings_Btn.click();
		return this;
	}
	
	public HomeScreen logout(){
		waitUntilElementclickable(logout_Btn);
		logout_Btn.click();
		yes_Btn.click();
		return new HomeScreen(mdriver);
	}

}
