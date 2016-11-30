package moolya.hungama.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends M_BasePage {

	public HomePage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(name="Interstitial close button")
	private MobileElement closeAd_Btn;
	
	@AndroidFindBy(name="Music")
	private MobileElement music_Tab;
	
	@AndroidFindBy(name="Videos")
	private MobileElement videos_Tab;
	
	@AndroidFindBy(name="Open navigation drawer")
	private MobileElement navDrawer;
	
	@AndroidFindBy(name="My Downloads")
	private MobileElement myDownloads_Btn;
	
	@AndroidFindBy(name="OK")
	private MobileElement noDownloadsOK_Btn;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[@index='1']")
	private MobileElement settings_Btn;
	
	public MusicPage selectMusicTab(){
		waitUntilElementclickable(music_Tab);
		music_Tab.click();
		Reporter.log("Navigate to Music Tab", true);
		return new MusicPage(mdriver);
	}
	
	public HomePage openNavDrawer(){
		waitUntilElementclickable(navDrawer);
		navDrawer.click();
		Reporter.log("Clicked on Navigation Drawer", true);
		return this;
	}
	
	public HomePage clickOK(){
		waitUntilElementclickable(noDownloadsOK_Btn);
		noDownloadsOK_Btn.click();
		return this;
	}
	
	public DownloadsPage selectMyDownloads(){
		waitUntilElementclickable(myDownloads_Btn);
		myDownloads_Btn.click();
		Reporter.log("Clicked on My Downloads", true);
		return new DownloadsPage(mdriver);
	}
	
	public SettingsPage clickOnSettings(){
		waitUntilElementclickable(settings_Btn);
		settings_Btn.click();
		Reporter.log("Clicked on Settings", true);
		return new SettingsPage(mdriver);
	}

}
