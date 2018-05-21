package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSFindBy;

public class BankDetails extends BasePage{

	public BankDetails(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	@iOSFindBy(xpath="")	// this is used for IOSDriver
	@AndroidFindBy(id = "")	// this is used for AndroidDriver
	private MobileElement element;
	
	@AndroidFindBy(name = "Account Number")
	private MobileElement AccLabel;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etAccNum")
	private MobileElement accountnumber;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etConfirmAccNum")
	private MobileElement confirmaccount;
	
	@AndroidFindBy(name="Find")
	private MobileElement findbutton;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;
	
	@AndroidFindBy(name="State")
	private MobileElement statelabel;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/actvState")
	private MobileElement state;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/actvCity")
	private MobileElement city;
	
	@AndroidFindBy(name="Bank")
	private MobileElement banklabel;
	
	@AndroidFindBy(name="City")
	private MobileElement citylabel;
	
	@AndroidFindBy(id="android:id/text1")
	private MobileElement branch;
	
	//@AndroidFindBy(name="BANGALORE - AIRPORT ROAD")
	@AndroidFindBy(xpath="//android.widget.CheckedTextView[@index='4']")
	private MobileElement branchname;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibDone")
	private MobileElement done;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibAtt4")
	private MobileElement attachment;
	
	@AndroidFindBy(name ="BANK DETAILS")
	private MobileElement bankdetails;
	
	@AndroidFindBy(name = "Got it")
	private MobileElement gotit;
	
	
	
	
	
	/*@AndroidFindBy(id = "com.android.documentsui:id/date")
	private MobileElement doc;*/
	
	public CasheYouCanGet bankDetailsScreen() throws InterruptedException{
		waitUntilElementAppears(bankdetails);
		try{
			bankname.click();
		}
		catch(Exception e) {
			driverMob.hideKeyboard();
			next.click();
			
		}
		bankname.sendKeys("HDFC BANK");
		AccLabel.click();
		driverMob.navigate().back();
		accountnumber.sendKeys("1234567890123456");
		try{
		driverMob.hideKeyboard();
		}
		catch(Exception e){}
		confirmaccount.sendKeys("1234567890123456");
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){}
		findbutton.click();
		ifsc();
		waitUntilElementAppears(bankdetails);
		//driverMob.swipe(350, 1050, 350, 800, 1);
		driverMob.scrollTo("Please upload your latest");
		attachment.click();
		gotit.click();
		CommonPage cp = new CommonPage(driverMob);
		//cp.document.click();
		cp.doc.click();
		next.click();
		
		return new CasheYouCanGet(driverMob);
	}
	
	public void ifsc() throws InterruptedException{
		statelabel.click();
		state.sendKeys("KARNATAKA");
		done.click();
		
		waitUntilElementAppears(citylabel);
		Thread.sleep(2000);
		city.sendKeys("BANGALORE");
		banklabel.click();
		Thread.sleep(6000);
		try{
			branch.click();
		}
		catch(Exception e){
			driverMob.navigate().back();
			branch.click();
		}
		
		branchname.click();
		try{
		done.click();
		}
		catch(Exception e){
			driverMob.navigate().back();
			Thread.sleep(6000);		
			done.click();		

		}
	}
}
