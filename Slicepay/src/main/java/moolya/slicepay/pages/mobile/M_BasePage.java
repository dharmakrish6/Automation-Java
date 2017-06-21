package moolya.slicepay.pages.mobile;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import moolya.slicepay.pages.mobile.android.HomePage;
import moolya.slicepay.utils.JavaUtils;

public class M_BasePage extends JavaUtils{

	public AppiumDriver<MobileElement> mdriver;
	public enum mobile {
		ANDROID,
		IOS
	}
	public static mobile platform;

	public M_BasePage(AppiumDriver<MobileElement> mdriver){
		this.mdriver = mdriver;
	}

	@FindBy(id="indwin.c3.shareapp:id/backo")
	protected MobileElement back_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/btn_take_picture")
	protected MobileElement takePhoto_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/selected_photo")
	protected MobileElement selectedPhoto_Img;
	
	@FindBy(id="indwin.c3.shareapp:id/action_done")
	protected MobileElement doneChooseImage_Btn;
	
	@FindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement graduationMonth_Btn;
	
	@FindBy(xpath="//android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement graduationYear_Btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement dobDay_Btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[2]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement dobMonth_Btn;
	
	@FindBy(xpath="//android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.LinearLayout[3]/android.widget.NumberPicker[1]/android.widget.Button[2]")
	protected MobileElement dobYear_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/confirm_end_date")
	protected MobileElement saveDate_Btn;
	
	public void selectMonthAndYear(String month, String year) throws InterruptedException{
		waitUntilElementclickable(graduationMonth_Btn);
		Map<String,Integer> months = ImmutableMap.<String, Integer>builder()
				.put("Jan", 1).put("Feb", 2).put("Mar", 3).put("Apr", 4)
				.put("May", 5).put("Jun", 6).put("Jul", 7).put("Aug", 8)
				.put("Sep", 9).put("Oct", 10).put("Nov", 11).put("Dec", 12).build();
		for(int i=0;i<months.get(month);i++){
			graduationMonth_Btn.click();
		}
		int noOfYearsToScroll = Integer.valueOf(year)-Integer.valueOf(graduationYear_Btn.getAttribute("text"));
		for(int i=0;i<noOfYearsToScroll;i++){
			graduationYear_Btn.click();
		}
		saveDate_Btn.click();
	}
	
	public void selectDate(String day,String month, String year) throws InterruptedException{
		waitUntilElementclickable(dobDay_Btn);
		for(int i=0;i<Integer.valueOf(day);i++)
			dobDay_Btn.click();
		Map<String,Integer> months = ImmutableMap.<String, Integer>builder()
				.put("Jan", 1).put("Feb", 2).put("Mar", 3).put("Apr", 4)
				.put("May", 5).put("Jun", 6).put("Jul", 7).put("Aug", 8)
				.put("Sep", 9).put("Oct", 10).put("Nov", 11).put("Dec", 12).build();
		for(int i=0;i<months.get(month.substring(0, 3));i++){
			dobMonth_Btn.click();
		}
		int noOfYearsToScroll = Integer.valueOf(year)-Integer.valueOf(dobYear_Btn.getAttribute("text"));
		for(int i=0;i<noOfYearsToScroll;i++){
			dobYear_Btn.click();
		}
		
		saveDate_Btn.click();
	}
	
	public void takePhoto() throws InterruptedException{
		waitUntilElementclickable(takePhoto_Btn);
		takePhoto_Btn.click();
		Thread.sleep(5000);
		waitUntilElementAppears(selectedPhoto_Img);
		doneChooseImage_Btn.click();
	}
	
	public void connectToSocialAccount(){
		
	}
	
	public HomePage goBack(){
		waitUntilElementclickable(back_Btn);
		back_Btn.click();
		return new HomePage(mdriver);
		
	}
	
	public void pressBackButton(){
		((AndroidDriver<MobileElement>)mdriver).pressKeyCode(AndroidKeyCode.BACK);
	}

	public void clickDeviceBackButton()
	{
		mdriver.navigate().back(); 
	}
	
	public AppiumDriver<MobileElement> launchmobApp(String c) throws IOException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir ;
		File app ;
		if(c.contains("android")){
			platform = mobile.ANDROID;
		}else{
			platform = mobile.IOS;
		}
		DesiredCapabilities capabilities ;
		switch(platform){
		case ANDROID:
			System.out.println("Launching Platform Android");
			classpathRoot = new File(System.getProperty("user.dir"));
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("deviceName", getPropValue("AdeviceName"));
			capabilities.setCapability("platformName", getPropValue("AplatformName"));
			capabilities.setCapability("platformVersion", getPropValue("AplatformVersion"));
			capabilities.setCapability("appPackage",getPropValue("AappPackage"));
			capabilities.setCapability("appActivity",getPropValue("AappActivity"));
			appDir = new File(classpathRoot, getPropValue("AappDir"));
			app = new File (appDir, getPropValue("AappName"));
			if(!app.getName().equals("NA"))
				capabilities.setCapability("app", app.getAbsolutePath());
			if (getPropValue("AnoReset").equals("true"))
				capabilities.setCapability("noReset", "true");
			else
				capabilities.setCapability("noReset", "false");
			mdriver = new AndroidDriver<MobileElement>(new URL(getPropValue("AppiumUrl")), capabilities);
			break;
		case IOS:
			System.out.println("Launching Platform IOS");
			appDir = new File(classpathRoot, getPropValue("IappDir"));
			app = new File(appDir, getPropValue("IappName"));
			capabilities = new DesiredCapabilities();
			capabilities.setCapability("platformName", "ios");
			capabilities.setCapability("deviceName", getPropValue("IdeviceName"));
//          capabilities.setCapability("udid", "36c1fa65340d70d7727b76aae45724972a145e26");
			capabilities.setCapability("app", app.getAbsolutePath());
			capabilities.setCapability("platformVersion", getPropValue("IplatformVersion"));
			capabilities.setCapability("automationName", getPropValue("IautomationName"));
			if (getPropValue("InoReset").equals("true"))
				capabilities.setCapability("noReset", "true");
			else
				capabilities.setCapability("noReset", "false");
			mdriver = new IOSDriver<MobileElement>(new URL(getPropValue("AppiumUrl")), capabilities);
			break;
		}
		System.out.println("*****Launching the app*****");
		mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return mdriver;
	}

	public void clickElementByText(String text) throws InterruptedException{
		Thread.sleep(2000);
		try{
			mdriver.findElementByName(text).click();
		}catch(Exception e){
			mdriver.scrollToExact(text);
			mdriver.findElementByName(text).click();
		}
	}

	public void waitUntilElementAppears(MobileElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(MobileElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void scrollUntilElementIsVisible(MobileElement element) throws InterruptedException{
		try{
			mdriver.hideKeyboard();
		}
		catch(Exception e){}
		while(element.isDisplayed()!=true)
			Thread.sleep(500);
		mdriver.swipe(0, 700, 0, 600, 1);	
	}



	public  void swipeVertical(int yStart, int yEnd, int x, int totalSwipes) throws IOException, InterruptedException{

		for(int i = 1; i<=totalSwipes; i++)
		{
			Thread.sleep(1000);
			mdriver.swipe(x,yStart,x,yEnd, 1000);
			//1000,750,1040,400
		}
	}

	public  void swipehorizontal(int xStart, int xEnd, int y, int totalSwipes) {
		try {
			for(int i = 1; i<=totalSwipes; i++)
			{
				Thread.sleep(1000);
				mdriver.swipe(xStart,y,xEnd,y, 1000);
				//71,570,180,570
				//700,876,65,920

			}
		} 
		catch (Exception e) 
		{

		}

	}

	public void swipeUntilElementVisible(WebElement element)
	{
		for (int i = 1; i < 10; i++) 
		{
			mdriver.swipe(100, 600, 100, 500, 1);
			try 
			{
				element.isDisplayed();
				break;
			} 
			catch (Exception e) 
			{
				mdriver.swipe(100, 700, 100, 500, 1);
			}
		}
	}

	public void enterMobNumber(MobileElement element,String mobNo){
		waitUntilElementclickable(element);
		element.click();
		mobNo = mobNo.replaceAll("[^0-9]", "");
		mobNo = mobNo.substring(0,10);
		System.out.println("Entering Mobile No. : "+mobNo);
		int[] digits = new int[mobNo.length()];
		for(int i=0;i<mobNo.length();i++){
			String digitAsString=mobNo.substring(i, i+1);
			digits[i] = Integer.parseInt(digitAsString)+7;
			((AndroidDriver<MobileElement>)mdriver).pressKeyCode(digits[i]);
		}
	}

	public void selectDropdown(MobileElement element,String value){
		try{
			waitUntilElementclickable(element);
			element.click();
			MobileElement item = mdriver.findElementByName(value);
			waitUntilElementclickable(item);
			item.click();
		}
		catch(Exception e){
			waitUntilElementclickable(element);
			element.click();
			mdriver.scrollToExact(value);
			MobileElement item = mdriver.findElementByName(value);
			waitUntilElementclickable(item);
			item.click();
		}
	}

	public void typeAndSelect(MobileElement sElement,MobileElement tElement,String value){
		sElement.sendKeys(value);
		tElement.click();
	}

	public AppiumDriver<MobileElement> getDriver(){
		return mdriver;
	}




}
