package moolya.slicepay.pages.mobile.android;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.slicepay.pages.mobile.M_BasePage;

public class OrdersPage extends M_BasePage {

	public OrdersPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="Orders")
	private MobileElement orders_Lbl;
	
	@FindBy(name="My existence currently has no meaning..")
	private MobileElement noOrders1_Lbl;
	
	@FindBy(name="Help me out by placing an order")
	private MobileElement noOrders2_Lbl;
	
	@FindBy(name="Grabbing an online shopping product")
	private MobileElement grabOnlineProduct_Btn;
	
	@FindBy(name="Recharging your Paytm Wallet")
	private MobileElement rechargePaytmWallet_Btn;
	
	@FindBy(name="Taking an online learning course")
	private MobileElement takeOnlineCourse_Btn;
	
	public void verifyForNoOrders(){
		waitUntilElementAppears(orders_Lbl);
		Assert.assertTrue(grabOnlineProduct_Btn.isDisplayed(), "Grabbing a Product Online is not present!");
		Reporter.log("Grabbing a product online is present", true);
		Assert.assertTrue(rechargePaytmWallet_Btn.isDisplayed(), "Recharging your paytm wallet is not present!");
		Reporter.log("Recharging your paytm wallet is present", true);
		Assert.assertTrue(takeOnlineCourse_Btn.isDisplayed(), "Taking a course online is not present!");
		Reporter.log("Taking a course online is present", true);
		Reporter.log("Verifying for No Orders Screen Successful!", true);
	}

}
