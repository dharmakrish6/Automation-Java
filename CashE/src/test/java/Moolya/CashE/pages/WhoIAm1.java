package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhoIAm1 extends BasePage {

	public WhoIAm1(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name = "Day")
	private MobileElement day;
	
	@AndroidFindBy(name = "05")
	private MobileElement day2;
	
	@AndroidFindBy(name = "Month")
	private MobileElement month;
	
	@AndroidFindBy(name = "Apr")
	private MobileElement month2;
	
	@AndroidFindBy(name = "Year")
	private MobileElement year;
	
	@AndroidFindBy(name = "1963")
	private MobileElement year2;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/actvEmpNameStep2")
	private MobileElement work;
	
	@AndroidFindBy(name = "I work at")
	private MobileElement empname;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etNetSalStep2")
	private MobileElement salary;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/congrats_anim")
	private MobileElement congrats;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/proceed")
	private MobileElement proceed;
	
	
	public RealPerson whoIAmScreen2() throws InterruptedException{
		day.click();
		day2.click();
		month.click();
		month2.click();
		year.click();
		year2.click();
		work.sendKeys("Moolya Software");
		Thread.sleep(6000);
		empname.click();
		try{
			driverMob.navigate().back();
			}
			catch(Exception e){}
		driverMob.scrollToExact("My net monthly salary is");
		salary.sendKeys("35000");
		try{
		driverMob.hideKeyboard();}
		catch(Exception e){}
		Thread.sleep(6000);
		try{
		next.click();
		}
		catch(Exception e){
		driverMob.hideKeyboard();
		next.click();
		}
		waitUntilElementAppears(congrats);
		next.click();
		proceed.click();
		
		return new RealPerson(driverMob);
				
	}

}
