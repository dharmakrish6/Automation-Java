package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class RealPerson extends BasePage {

	public RealPerson(AppiumDriver<MobileElement> driver) {
			super(driver);
			PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
		
	@AndroidFindBy(id = "co.tslc.cashe.android:id/proceed")
	private MobileElement proceed;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etPAN")
	private MobileElement pancard;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibAtt3")
	private MobileElement attachment;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;
	
	@AndroidFindBy(name = "Got it")
	private MobileElement gotit;
	
	
	
	public WhereILive realPersonScreen(){
		
		pancard.sendKeys("CEIOU3579B");
		try{
		driverMob.hideKeyboard();
		}
		catch(Exception e){}
		attachment.click();
		gotit.click();
		CommonPage cp = new CommonPage(driverMob);
		cp.doc.click();
		//cp.document.click();
		next.click();
		return new WhereILive(driverMob);
	}

}
