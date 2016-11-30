package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhereILive extends BasePage {

	public WhereILive(AppiumDriver<MobileElement> driver)  {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name = "Current Address")
	private MobileElement curadd;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etAddress")
	private MobileElement currentAddress;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etPinCode")
	private MobileElement pincode;
	
	@AndroidFindBy(name = "Address proof")
	private MobileElement label;
	
	@AndroidFindBy(name = "Select address proof")
	private MobileElement addressProof;
	
	@AndroidFindBy(name = "Passport")
	private MobileElement passport;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibAtt1")
	private MobileElement attach1;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibAtt2")
	private MobileElement attach2;
	
	@AndroidFindBy(name = "Got it")
	private MobileElement gotit;
	
	/*@AndroidFindBy(id = "com.android.documentsui:id/date")
	private MobileElement doc;*/
	
	@AndroidFindBy(name = "My Net Monthly Salary")
	private MobileElement netsalary;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;
	
	public MoreAboutYou whereILiveScreen() throws InterruptedException{
		waitUntilElementAppears(curadd);
		currentAddress.sendKeys("Bangalore");
		try{
		driverMob.hideKeyboard();
		}
		catch(Exception e){}
		driverMob.scrollToExact("Address Proof");
		pincode.sendKeys("666666");
		try{
		driverMob.hideKeyboard();
		}
		catch(Exception e){}
		addressProof.click();
		passport.click();
		attach1.click();
		gotit.click();
		CommonPage cp = new CommonPage(driverMob);
		//cp.document.click();
		cp.doc.click();
		next.click();
		try{
			waitUntilElementAppears(netsalary);
		}
		catch(Exception e){
			next.click();
			
		}
		attach2.click();
		gotit.click();
		//cp.document.click();
		cp.doc.click();
		next.click();
		return new MoreAboutYou(driverMob);
	}

}
