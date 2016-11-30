package moolya.bookMyShow.pages.mobilePages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VenuesScreen extends M_BasePage {

	public VenuesScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}

	@AndroidFindBy(id="com.bt.bms:id/edtSearchBox")
	public MobileElement searchVenues_TB;
	
	@AndroidFindBy(id="com.bt.bms:id/lyFavorites")
	public MobileElement favorite_CB;
	
	@AndroidFindBy(id="com.bt.bms:id/lytHome")
	public MobileElement back_Btn;
	
	public VenuesScreen searchVenue(){
		waitUntilElementAppears(searchVenues_TB);
		searchVenues_TB.sendKeys("chandrodaya");
		return this;
	}
	
	public VenuesScreen addFavorite(){
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
