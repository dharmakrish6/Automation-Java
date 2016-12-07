package moolya.hungama.pages;

import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
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
	
	@AndroidFindBy(name="Video")
	private MobileElement videos_Tab;
	
	@AndroidFindBy(name="Open navigation drawer")
	private MobileElement navDrawer;
	
	@AndroidFindBy(name="My Downloads")
	private MobileElement myDownloads_Btn;
	
	@AndroidFindBy(name="OK")
	private MobileElement noDownloadsOK_Btn;
	
	@AndroidFindBy(name="Search")
	private MobileElement search_Btn;
	
	@AndroidFindBy(name="Search Music")
	private MobileElement search_TB;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[@index='1']")
	private MobileElement settings_Btn;
	

	@AndroidFindBy(xpath="//android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.ImageView[@index='0']")
	private MobileElement login_Btn;
	
	@AndroidFindBy(name="Navigate up")
	private MobileElement goBack;
	
	@AndroidFindBy(name="PRO USER")
	private MobileElement proUser_Btn;
	
	@AndroidFindBy(name="Later")
	private MobileElement later_Btn;
	
	public MusicPage selectMusicTab(){
		waitUntilElementclickable(music_Tab);
		music_Tab.click();
		Reporter.log("Navigate to Music Tab", true);
		return new MusicPage(mdriver);
	}
	
	public VideosPage selectVideosTab(){
		waitUntilElementclickable(videos_Tab);
		videos_Tab.click();
		Reporter.log("Navigated to Videos Tab", true);
		return new VideosPage(mdriver);
	}
	
	public MusicPage searchMusic(String musicName) throws InterruptedException{
		waitUntilElementclickable(search_Btn);
		search_Btn.click();
		search_TB.sendKeys(musicName);
		((AndroidDriver<MobileElement>)mdriver).pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
//		List<MobileElement> searchlist = mdriver.findElementsByName(musicName);
//		searchlist.get(1).click();
		MobileElement album = mdriver.findElementByName(musicName);
		waitUntilElementclickable(album);
		album.click();
		return new MusicPage(mdriver);
	}
	
	public VideosPage searchVideo(String videoName) throws InterruptedException{
		waitUntilElementclickable(search_Btn);
		search_Btn.click();
		search_TB.sendKeys(videoName);
		((AndroidDriver<MobileElement>)mdriver).pressKeyCode(AndroidKeyCode.ENTER);
		Thread.sleep(3000);
//		List<MobileElement> searchlist = mdriver.findElementsByName(videoName);
//		searchlist.get(searchlist.size()-1).click();
//		clickElementByText("Video");
		selectVideosTab();
		mdriver.findElementByName(videoName).click();
		return new VideosPage(mdriver);
	}
	
	public HomePage openNavDrawer(){
		waitUntilElementclickable(navDrawer);
		navDrawer.click();
		Reporter.log("Clicked on Navigation Drawer", true);
		return this;
	}
	
	public HomePage clickOK(){
		
		try {
			Thread.sleep(5000);
			noDownloadsOK_Btn.click();
		} catch (Exception e) {}
		return this;
	}
	
	public LoginPage Subscriber_Login() throws InterruptedException{
		waitUntilElementclickable(login_Btn);
		login_Btn.click();
		Reporter.log("Clicked on User Login", true);
		return new LoginPage(mdriver);
	}
	
	public HomePage checkProUser(){
		waitUntilElementAppears(proUser_Btn);
		Assert.assertTrue(proUser_Btn.isDisplayed(), "User is not PRO User");
		Reporter.log("User is PRO User", true);
		return this;
	}
	
	public DownloadsPage selectMyDownloads() throws InterruptedException{
		waitUntilElementclickable(myDownloads_Btn);
		myDownloads_Btn.click();
		Reporter.log("Clicked on My Downloads", true);
		return new DownloadsPage(mdriver);
	}
	
	public DownloadsPage scrollToMyDownloads() throws InterruptedException{
		clickElementByText("Downloads");
		return new DownloadsPage(mdriver);
	}
	
	public SettingsPage clickOnSettings(){
		waitUntilElementclickable(settings_Btn);
		settings_Btn.click();
		Reporter.log("Clicked on Settings", true);
		return new SettingsPage(mdriver);
	}
	
	public HomePage clickLater(){
		try{
			Thread.sleep(5000);
			later_Btn.click();
		}catch(Exception e){}
		return this;
	}

}
