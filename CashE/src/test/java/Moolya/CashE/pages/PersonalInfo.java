package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PersonalInfo extends BasePage {

	public PersonalInfo(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etEmpLandline")
	private MobileElement emplandline;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etEmailOffice")
	private MobileElement offmailid;
	
	@AndroidFindBy(name = "Month")
	private MobileElement month;
	
	@AndroidFindBy(name = "May")
	private MobileElement month_may;
	
	@AndroidFindBy(name = "Year")
	private MobileElement year;
	
	@AndroidFindBy(name = "1963")
	private MobileElement year1963;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etEmailOffice")
	private MobileElement next;
	
	public BankDetails personalInforScreen() throws InterruptedException{
		emplandline.sendKeys("32");
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){}
		offmailid.sendKeys("a@b.c");
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){}
		month.click();
		month_may.click();
		year.click();
		year1963.click();
		try{
			next.click();
		}
		catch(Exception e){
			driverMob.hideKeyboard();
			Thread.sleep(6000);
			next.click();
		}
		
		return new BankDetails(driverMob);
	}
	
}
