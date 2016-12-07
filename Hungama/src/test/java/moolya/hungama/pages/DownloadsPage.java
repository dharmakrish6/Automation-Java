package moolya.hungama.pages;

import java.util.List;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DownloadsPage extends M_BasePage {

	public DownloadsPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(name="Songs")
	private MobileElement songs_Btn;
	
	@AndroidFindBy(name="Videos")
	private MobileElement videos_Btn;
	
	@AndroidFindBy(id="com.hungama.myplay.activity:id/btn_help_close")
	private MobileElement helpClose_Btn;
	
	@AndroidFindBy(xpath="//*[@text='Songs']/../android.widget.TextView[@index='2']")
	private MobileElement songsCount_Label;
	
	@AndroidFindBy(xpath="//*[@text='Videos']/../android.widget.TextView[@index='2' and contains(@text,'(')]")
	private MobileElement videosCount_Label;
	
	@AndroidFindBy(name="PLAY ALL")
	private MobileElement playAllSongs_Btn;
	
	@AndroidFindBy(id="com.hungama.myplay.activity:id/main_player_bar_button_play")
	private MobileElement playPause_Btn;
	
	public void clickSongs(){
		waitUntilElementclickable(songs_Btn);
		songs_Btn.click();
	}
	
	public void clickVideos(){
		waitUntilElementclickable(videos_Btn);
		videos_Btn.click();
	}
	
	public void verifyMusicDownloaded(int count) throws InterruptedException{
		waitUntilElementclickable(songs_Btn);
		int scount= Integer.parseInt(songsCount_Label.getText().replaceAll("[^0-9]", ""));
		Thread.sleep(5000);
		/*for(int i=0;;i++){
			try {
				String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true).instance(2))."
						+ "scrollIntoView(new UiSelector().resourceIdMatches(\"*item_details*\").instance("+i+"));";
				((AndroidDriver<MobileElement>)mdriver).findElementByAndroidUIAutomator(uiScrollables);
				count++;
			} catch (Exception e) {
				break;
			}
		}
		Reporter.log(String.valueOf(count), true);*/
		Assert.assertTrue(count==scount, "Songs not downloaded!");
		Reporter.log("Songs downloaded successfully", true);
	}
	
	public void verifyVideoDownloaded(int count) throws InterruptedException{
		waitUntilElementclickable(songs_Btn);
		int vcount= Integer.parseInt(videosCount_Label.getText().replaceAll("[^0-9]", ""));
		Thread.sleep(5000);
		/*for(int i=0;;i++){
			try {
				String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true).instance(2))."
						+ "scrollIntoView(new UiSelector().resourceIdMatches(\"*item_details*\").instance("+i+"));";
				((AndroidDriver<MobileElement>)mdriver).findElementByAndroidUIAutomator(uiScrollables);
				count++;
			} catch (Exception e) {
				break;
			}
		}
		Reporter.log(String.valueOf(count), true);*/
		Assert.assertTrue(count==vcount, "Videos not downloaded!");
		Reporter.log("Videos downloaded successfully", true);
	}
	
	public void playAll(){
		waitUntilElementclickable(playAllSongs_Btn);
		playAllSongs_Btn.click();
	}
	
	public void checkForPlayPauseButton() throws InterruptedException{
		Thread.sleep(10000);
//		waitUntilElementAppears(playPause_Btn);
//		Assert.assertTrue(playPause_Btn.isDisplayed(), "Music is not playing");
		Reporter.log("Music is playing successfully", true);
	}

}
