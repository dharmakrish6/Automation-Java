package moolya.bookMyShow.pages.mobilePages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FavoriteVenuesScreen extends M_BasePage {

	public FavoriteVenuesScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}
	
	@AndroidFindBy(id="com.bt.bms:id/lyFavorites")
	public MobileElement favorite_CB;
	
	@AndroidFindBy(id="com.bt.bms:id/lytHome")
	public MobileElement back_Btn;
	
	public FavoriteVenuesScreen removeFavorite(){
		waitUntilElementclickable(favorite_CB);
		favorite_CB.click();
		return this;
	}
	
	public HomeScreen goBack(){
		waitUntilElementclickable(back_Btn);
		back_Btn.click();
		return new HomeScreen(mdriver);
	}

}
