package moolya.hungama.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VideosPage extends M_BasePage {

	public VideosPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(id="com.hungama.myplay.activity:id/home_videos_tile_image")
	private MobileElement video;
	
	@AndroidFindBy(name="Advertisement")
	private MobileElement ad_Label;
	
	@AndroidFindBy(name="DOWNLOAD")
	private MobileElement download_Btn;
	
	public void checkForAdPresent(){
		waitUntilElementAppears(ad_Label);
		try{
			ad_Label.isDisplayed();
			Reporter.log("Ad is Displayed", true);
		}catch(Exception e){
			Reporter.log("Ad is not displayed", true);
		}
	}
	
	public void downloadVideo(){
		waitUntilElementclickable(download_Btn);
		download_Btn.click();
	}

}
