package moolya.slicepay.pages.mobile.android;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.slicepay.pages.mobile.M_BasePage;

public class ProfilePage extends M_BasePage {

	public ProfilePage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="indwin.c3.shareapp:id/user_name")
	private MobileElement name_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/user_phone")
	private MobileElement phone_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/account_settings")
	private MobileElement accountSettings_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/credit_limit")
	private MobileElement creditLimit_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/credit_balance")
	private MobileElement creditBalance_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/cash_back")
	private MobileElement cashback_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/paytm_limit")
	private MobileElement paytmLimit_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/paytm_balance")
	private MobileElement paytmBalance_Lbl;
	
	@FindBy(name="Have a Campus Manager code?")
	private MobileElement campuseManagerCode_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/unlock_silver_tv")
	private MobileElement silverUnlockNow_Btn;
	
	private String silverAccess_Lbl = "SILVER ACCESS!";
	
	@FindBy(id="indwin.c3.shareapp:id/unlock_booster_tv")
	private MobileElement limitBoosterBoostNow_Btn;
	
	private String limitBooster_Lbl = "LIMIT BOOSTER!";
	
	@FindBy(id="indwin.c3.shareapp:id/unlock_gold_tv")
	private MobileElement goldUnlockNow_Btn;
	
	private String goldAccess_Lbl = "GOLD PRIVILEGE!";
	
	@FindBy(id="indwin.c3.shareapp:id/unlock_platinum_tv")
	private MobileElement platinumUnlockNow_Btn;
	
	private String platinumAccess_Lbl = "PLATINUM CLUB!";
	
	public SilverAccessPage clickUnlockNowSilver(){
		waitUntilElementclickable(silverUnlockNow_Btn);
		silverUnlockNow_Btn.click();
		Reporter.log("Clicked on Silver Access Unlock Now", true);
		return new SilverAccessPage(mdriver);
	}
	
	

}
