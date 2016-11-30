package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MoreAboutYou extends BasePage{

	public MoreAboutYou(AppiumDriver<MobileElement> driver)  {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name = "MORE ABOUT YOU")
	private MobileElement moreaboutyou;
	
	@AndroidFindBy(name = "Same as current address")
	private MobileElement checkbox;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etLandline")
	private MobileElement landline;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;
	
	public MoreAboutYou2 moreAboutYouScreen() throws InterruptedException{
		waitUntilElementAppears(moreaboutyou);
		checkbox.click();
		landline.sendKeys("26548795");
		try{
		driverMob.hideKeyboard();
		Thread.sleep(6000);
		}
		catch(Exception e){}
		try{
			next.click();
			
		}
		catch(Exception e){
			Thread.sleep(6000);
			driverMob.hideKeyboard();
			next.click();
		}
		return new MoreAboutYou2(driverMob);
	}
}
