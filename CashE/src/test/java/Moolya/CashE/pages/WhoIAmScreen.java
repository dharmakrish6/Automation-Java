package Moolya.CashE.pages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class WhoIAmScreen extends BasePage {
	public WhoIAmScreen(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/selfie")
	private MobileElement selfie;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etFullName")
	private MobileElement iam;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etCellNumber")
	private MobileElement phone;
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/etEmail")
	private MobileElement email;
	
	
	@AndroidFindBy(id = "co.tslc.cashe.android:id/ibNext")
	private MobileElement next;

	private HashMap<String, String> data;
	
	public WhoIAm1 whoIAmScreen(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		data = readDataMap("Main", uniqueValue);
		String flowSheetName = data.get("Work Flow");
		data = readDataMap(flowSheetName, uniqueValue);
		Thread.sleep(10000);
		selfie.click();
		CommonPage cp = new CommonPage(driverMob);
		cp.camera.click();
		try{
			
			cp.yes.click();
		}
		catch(Exception e){
			Thread.sleep(2000);
			cp.yes.click();
		}
		iam.clear();
		iam.sendKeys(data.get("Name"));
		driverMob.hideKeyboard();
		phone.clear();
		phone.sendKeys(data.get("Mobile Number"));
		driverMob.hideKeyboard();
		email.clear();
		email.sendKeys(data.get("Email"));
		driverMob.hideKeyboard();
		next.click();
		
		return new WhoIAm1(driverMob);
		
	}
}
