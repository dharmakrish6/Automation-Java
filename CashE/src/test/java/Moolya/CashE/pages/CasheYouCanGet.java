package Moolya.CashE.pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CasheYouCanGet extends BasePage{

	public CasheYouCanGet(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(name = "CASHe YOU CAN GET")
	private MobileElement cashe;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ivDialMinus")
	private MobileElement minus;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ivDialPlus")
	private MobileElement plus;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibGetYourCashe")
	private MobileElement getyourcashe;
	
	@AndroidFindBy(name = "WHY CASHe?")
	private MobileElement whycashe;
	
	@AndroidFindBy(id ="co.tslc.cashe.android:id/ivClose")
	private MobileElement close;
	
	@AndroidFindBy(id ="co.tslc.cashe.android:id/btnYes")
	private MobileElement yes;
	
	@AndroidFindBy(id ="co.tslc.cashe.android:id/ibDeposit")
	private MobileElement proceed;
	
	@AndroidFindBy(name = "CASHe SUMMARY")
	private MobileElement summary;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/tvRandom")
	private MobileElement iou;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etCode")
	private MobileElement code1;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibDone")
	private MobileElement done;
	
	public void casheScreen() throws InterruptedException{
		waitUntilElementAppears(cashe);
		plus.click();
		minus.click();
		driverMob.scrollTo("WHY CASHe?");
		whycashe.click();
		close.click();
		getyourcashe.click();
		driverMob.scrollTo("YES");
		yes.click();
		proceed.click();
		waitUntilElementAppears(summary);
		proceed.click();
		String code = iou.getText();
		code1.sendKeys(code);
		try{
			driverMob.hideKeyboard();
		}
		catch(Exception e){
			
		}
		done.click();
		
		
	}

}
