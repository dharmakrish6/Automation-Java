package moolya.slicepay.pages.mobile.android;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.slicepay.pages.mobile.M_BasePage;

public class HomePage extends M_BasePage {

	public HomePage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}

	@FindBy(name="Navigation View Closed")
	private MobileElement navigationDrawer_Btn;

	@FindBy(id="indwin.c3.shareapp:id/link")
	private MobileElement pasteProductUrl_TB;

	@FindBy(id="indwin.c3.shareapp:id/choose_option")
	private MobileElement slicepayChashless_Btn;

	@FindBy(id="indwin.c3.shareapp:id/choose_optionpaytm")
	private MobileElement rechargeWithPaytm_Btn;

	@FindBy(name="Home")
	private MobileElement home_Btn;
	
	@FindBy(name="Profile")
	private MobileElement profile_Btn;
	
	@FindBy(name="Help Center")
	private MobileElement helpCenter_Btn;
	
	@FindBy(name="Recharge Paytm Wallet")
	private MobileElement rechargePaytmWallet_Btn;
	
	@FindBy(name="Learn Online")
	private MobileElement learnOnline_Btn;
	
	@FindBy(name="Invite and Earn")
	private MobileElement inviteAndEarn_Btn;
	
	@FindBy(name="Orders")
	private MobileElement orders_Btn;
	
	@FindBy(name="Repayments")
	private MobileElement repayments_Btn;
	
	@FindBy(name="How it works?")
	private MobileElement howItWorks_Btn;
	
	@FindBy(name="Safety and Security")
	private MobileElement safetyAndSecurity_Btn;
	
	@FindBy(name="About Us")
	private MobileElement aboutUs_Btn;
	
	@FindBy(name="Log Out")
	private MobileElement logout_Btn;

	private String trendingProducts_Lbl = "TRENDING PRODUCTS";

	private String smartPhones_Lbl = "SMARTPHONES";

	private String electronics_Lbl = "ELECTRONICS";

	private String laptops_Lbl = "LAPTOPS";

	private String apparelsAndAccessories_Lbl = "APPARELS AND ACCESSORIES";

	private String homeAndBeauty_Lbl = "HOME AND BEAUTY";

	private String footwear_Lbl = "FOOTWEAR";


	public void pasteProductUrl(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("ProductUrls", uniqueValue);
		waitUntilElementclickable(pasteProductUrl_TB);
		pasteProductUrl_TB.click();
		Reporter.log("Clicked on Paste Product Url Textbox", true);
		String productUrl = data.get("Url");
		pasteProductUrl_TB.sendKeys(productUrl);
		Reporter.log("Pasting product Url: "+productUrl, true);
		Thread.sleep(5000);
	}
	
	public OrdersPage goToOrdersPage(){
		waitUntilElementclickable(navigationDrawer_Btn);
		navigationDrawer_Btn.click();
		Reporter.log("Clicked on Navigation Drawer", true);
		orders_Btn.click();
		Reporter.log("Clicked on Orders", true);
		return new OrdersPage(mdriver);
	}
	
	public ProfilePage goToProfilePage() throws InterruptedException{
		waitUntilElementclickable(navigationDrawer_Btn);
		navigationDrawer_Btn.click();
		Reporter.log("Clicked on Navigation Drawer", true);
		profile_Btn.click();
		Reporter.log("Clicked on Profile", true);
		return new ProfilePage(mdriver);
	}

	public SignInPage logout() {
		waitUntilElementclickable(navigationDrawer_Btn);
		navigationDrawer_Btn.click();
		Reporter.log("Clicked on Navigation Drawer", true);
		logout_Btn.click();
		Reporter.log("Clicked on Logout", true);
		return new SignInPage(mdriver);
	}

}
