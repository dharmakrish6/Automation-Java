package moolya.sunnxt.pages.mobilepages;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.MobileCapabilityType;
import moolya.slicepay.pages.mobile.android.HomePage;
import moolya.slicepay.utils.JavaUtils;

public class M_BasePage extends M_SuperBasePage{

	public M_BasePage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}

	@AndroidFindBy(id="indwin.c3.shareapp:id/backo")
	protected MobileElement back_Btn;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/removeOverLay")
	protected MobileElement gotIt_Btn;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/removeOverLayProfile")
	protected MobileElement okay_Btn;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/delete")
	protected MobileElement deletePhoto_Btn;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/btn_take_picture")
	protected MobileElement takePhoto_Btn;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/selected_photo")
	protected MobileElement selectedPhoto_Img;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/action_done")
	protected MobileElement doneChooseImage_Btn;
	
	@AndroidFindBy(id="android:id/numberpicker_input")
	protected List<MobileElement> date_List;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement graduationMonth_Btn;
	
	@AndroidFindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement graduationYear_Btn;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement day_Btn;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement month_Btn;
	
	@AndroidFindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement year_Btn;
	
	@AndroidFindBy(id="indwin.c3.shareapp:id/confirm_end_date")
	protected MobileElement saveDate_Btn;
	
	@AndroidFindBy(name="English (UK)")
	protected MobileElement englishLang_Btn;
	
	@AndroidFindBy(name="Email address or phone number")
	protected MobileElement fbEmail_TB;
	
	@AndroidFindBy(xpath="//*[@resource-id='u_0_2']")
	protected MobileElement fbPassword_TB;
	
	@AndroidFindBy(name="Log In ")
	protected MobileElement fbLogin_Btn;
	
	@AndroidFindBy(name="OK ")
	protected MobileElement fbConfirmLogin_Btn;
	
	@AndroidFindBy(name="Continue ")
	protected MobileElement fbContinueLogin_Btn;

	public void selectMonthAndYear(String month, String year) throws InterruptedException{
		waitUntilElementclickable(graduationMonth_Btn);
		while(!date_List.get(0).getAttribute("text").equals(month.substring(0, 3))){
			mdriver.tap(1, graduationMonth_Btn, 1);
		}
		Thread.sleep(500);
		while(!date_List.get(1).getAttribute("text").equals(year)){
			mdriver.tap(1, graduationYear_Btn, 1);
		}
		saveDate_Btn.click();
	}
	
	public void selectDate(String day,String month, String year) throws InterruptedException{
		waitUntilElementclickable(day_Btn);
		while(!date_List.get(0).getAttribute("text").equals(day)){
			mdriver.tap(1, day_Btn, 1);
		}
		Thread.sleep(500);
		while(!date_List.get(1).getAttribute("text").equals(month.substring(0, 3))){
			mdriver.tap(1, month_Btn, 1);
		}
		Thread.sleep(500);
		while(!date_List.get(2).getAttribute("text").equals(year)){
			mdriver.tap(1, year_Btn, 1);
		}
		
		saveDate_Btn.click();
	}
	
	public void selectVerificationDate() throws InterruptedException{
		Calendar c = Calendar.getInstance();
		c.add(Calendar.DATE,2);
		if(c.get(Calendar.DAY_OF_WEEK)==1)
			c.add(Calendar.DATE,1);
		String day = Integer.toString(c.get(Calendar.DATE));
		String month = new DateFormatSymbols().getMonths()[c.get(Calendar.MONTH)];
		String year = Integer.toString(c.get(Calendar.YEAR));
		selectDate(day, month, year);
		Reporter.log("Selected Verification Date: "+day+"-"+month+"-"+year, true);
	}
	
	public void takePhoto(MobileElement element) throws InterruptedException{
		waitUntilElementclickable(element);
		element.click();
		try{
			Thread.sleep(2000);
			deletePhoto_Btn.click();
			waitUntilElementclickable(element);
			element.click();
		}catch(Exception e){}
		waitUntilElementclickable(takePhoto_Btn);
		takePhoto_Btn.click();
		Thread.sleep(5000);
		waitUntilElementAppears(selectedPhoto_Img);
		doneChooseImage_Btn.click();
	}
	
	public void takeMorePhotos(MobileElement element,int n) throws InterruptedException{
		waitUntilElementclickable(element);
		element.click();
		try{
			Thread.sleep(2000);
			deletePhoto_Btn.click();
			waitUntilElementclickable(element);
			element.click();
		}catch(Exception e){}
		for (int i = 0; i < n; i++) {
			waitUntilElementclickable(takePhoto_Btn);
			takePhoto_Btn.click();
			Thread.sleep(5000);
			waitUntilElementAppears(selectedPhoto_Img);
		}
		doneChooseImage_Btn.click();
	}
	
	public void connectToSocialAccount() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("FB", "FB001");
		Thread.sleep(8000);
		try{
			mdriver.scrollTo("English (UK)");
			englishLang_Btn.click();
			Reporter.log("Changed Language to English", true);
		}catch(Exception e){
			Reporter.log("Error changing language to english", true);
		}
		Thread.sleep(8000);
		fbEmail_TB.click();
		sendText(fbEmail_TB, data.get("Email"));
		fbPassword_TB.click();
		sendText(fbPassword_TB, data.get("Password"));
		fbLogin_Btn.click();
		Thread.sleep(8000);
		try{
			fbContinueLogin_Btn.click();
			Reporter.log("Clicked on Continue Button", true);
		}catch(Exception e){
			fbConfirmLogin_Btn.click();
			Reporter.log("Clicked on Confirm Button", true);
		}
	}
	
	public HomePage goBack() throws InterruptedException{
		waitUntilElementclickable(back_Btn);
		back_Btn.click();
		return new HomePage(mdriver);
		
	}
	
	public void selectFeeRangeDropdown(MobileElement element, String value) throws InterruptedException{
		waitUntilElementclickable(element);
		element.click();
		Thread.sleep(500);
			List<MobileElement> fees = mdriver.findElementsByXPath("//android.widget.CheckedTextView");
			for(MobileElement e:fees){
				String planAmt = e.getAttribute("text");
				if(planAmt.replaceAll("[^A-Za-z0-9-]", "").equals(value)){
					e.click();
					break;
				}
			}
		
	}
	
}
