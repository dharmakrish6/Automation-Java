package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MoreAboutYou2 extends BasePage{

	public MoreAboutYou2(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name = "Select education")
	private MobileElement education;
	
	@AndroidFindBy(name = "Graduate")
	private MobileElement edutype;
	
	@AndroidFindBy(name = "Select Accommodation")
	private MobileElement accommodation;
	
	@AndroidFindBy(name = "Own")
	private MobileElement acctype;
	
	@AndroidFindBy(name = "Select purpose")
	private MobileElement purpose;
	
	@AndroidFindBy(name = "Travel")
	private MobileElement purtype;
	
	@AndroidFindBy(id= "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;
	
	public PersonalInfo moreAboutYou2(){
		try{
			education.click();
		}
		catch(Exception e) {
			driverMob.hideKeyboard();
			next.click();
			education.click();
		}
		
		edutype.click();
		accommodation.click();
		acctype.click();
		driverMob.scrollToExact("Purpose of CASHe");
		purpose.click();
		purtype.click();
		next.click();
		
		return new PersonalInfo(driverMob);
	}

}
