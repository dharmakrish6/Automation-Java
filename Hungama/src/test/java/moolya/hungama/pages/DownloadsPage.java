package moolya.hungama.pages;

import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class DownloadsPage extends M_BasePage {

	public DownloadsPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	public void verifyMusicDownloaded(int length){
		int count=0;
		for(int i=0;;i++){
			try {
				String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true).instance(1))."
						+ "scrollIntoView(new UiSelector().resourceIdMatches(\"item_details\").instance("+i+"));";
				((AndroidDriver<MobileElement>)mdriver).findElementByAndroidUIAutomator(uiScrollables);
				count++;
			} catch (Exception e) {
				break;
			}
		}
		Reporter.log(String.valueOf(count), true);
		Assert.assertTrue(count==10, "Songs not downloaded!");
		Reporter.log("Songs downloaded successfully", true);
	}

}
