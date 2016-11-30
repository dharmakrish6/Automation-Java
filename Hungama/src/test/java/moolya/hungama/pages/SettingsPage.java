package moolya.hungama.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingsPage extends M_BasePage {

	public SettingsPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@AndroidFindBy(name="My Accounts")
	private MobileElement myaccounts;
	
	@AndroidFindBy(name="HD")
	private MobileElement qualityHD;
	
	public SettingsPage selectAudioQuality() throws InterruptedException{
		waitUntilElementAppears(myaccounts);
		clickElementByText("Audio Quality");
		waitUntilElementclickable(qualityHD);
		Reporter.log("Selected quality: HD", true);
		qualityHD.click();
		return this;
	}

}
