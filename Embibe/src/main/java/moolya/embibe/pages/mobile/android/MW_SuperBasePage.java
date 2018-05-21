package moolya.embibe.pages.mobile.android;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.ios.IOSDriver;
import moolya.embibe.utils.JavaUtils;

public class MW_SuperBasePage extends JavaUtils{


	public AppiumDriver<WebElement> mdriver;
	public enum mobile {
		ANDROID,
		IOS
	}
	public static mobile platform;

	public MW_SuperBasePage(AppiumDriver<WebElement> mdriver){
		this.mdriver = mdriver;
	}

	public void hideKeyboard(){
		try{
			mdriver.hideKeyboard();
		}catch(Exception e){}
	}

	public void pressBackeyCode() throws InterruptedException{
		try{
			((AndroidDriver<WebElement>)mdriver).pressKeyCode(AndroidKeyCode.BACK);
			Thread.sleep(500);
		}catch(Exception e){}
	}

	public void clickDeviceBackButton()
	{
		mdriver.navigate().back(); 
	}
	
	public void selectCheckBox(WebElement element){
		waitUntilElementclickable(element);
		if(element.getAttribute("checked").equalsIgnoreCase("false")){
			element.click();
			Reporter.log("Clicked on Checkbox", true);
		}
		else
			Reporter.log("Checkbox is already Clicked", true);
	}

	public AppiumDriver<WebElement> launchmobApp(String c) throws IOException
	{
		File classpathRoot = new File(System.getProperty("user.dir"));
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");
		File appDir ;
		File app ;
		String avd;
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
			capabilities.setCapability("app",getPropValue("Aapp"));
			mdriver = new AndroidDriver<WebElement>(new URL(getPropValue("AppiumUrl")), capabilities);
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
				mdriver = new IOSDriver<WebElement>(new URL(getPropValue("AppiumUrl")), capabilities);
				break;
		}
		System.out.println("*****Launching the app*****");
		mdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		mdriver.get(url);
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

	public void waitUntilElementAppears(WebElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 300);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitUntilElementAppears(WebElement element,int seconds){

		WebDriverWait wait = new WebDriverWait(mdriver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(WebElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 100);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitUntilElementclickable(WebElement element,int seconds){

		WebDriverWait wait = new WebDriverWait(mdriver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void scrollToElementById(String id){
		String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true).instance(0))."
				+ "scrollIntoView(new UiSelector().resourceId(\"" + id + "\").instance(0));";
		((AndroidDriver<WebElement>)mdriver).findElementByAndroidUIAutomator(uiScrollables);
	}
	
	public void scrollUntilElementIsVisible(WebElement element) throws InterruptedException{
		boolean flag=true;
		while(flag==true){
			try{
				Thread.sleep(500);
				mdriver.swipe(0, 700, 0, 600, 1);
				element.isDisplayed();
				flag=false;
			}
			catch(Exception e){}
		}
			
	}
	
	public void scrollDownIos(){
		JavascriptExecutor js = (JavascriptExecutor) mdriver;
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		scrollObject.put("direction", "down");
		js.executeScript("mobile: scroll", scrollObject);
	}
	
	public void scrollToIosWebElement(WebElement element){
		String id = ((RemoteWebElement)element).getId();
		HashMap<String, String> scrollObject = new HashMap<String, String>();
		JavascriptExecutor js = (JavascriptExecutor) mdriver;
		scrollObject.put("element", id);
		js.executeScript("mobile: scrollTo", scrollObject);
	}

	public void copyTextToClipboard(String text) throws IOException{
		String command = getPropValue("setClipboardCommand");
		Process p = Runtime.getRuntime().exec(command+"\""+text+"\"");
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while((line=br.readLine()) != null)
			Reporter.log(line, true);
	}
	
	public void resetApp() throws IOException{
		Process p = Runtime.getRuntime().exec("adb shell pm clear "+getPropValue("AappPackage"));
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		String line;
		while((line=br.readLine()) != null)
					Reporter.log(line, true);
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

	public void enterMobNumber(WebElement element,String mobNo){
		waitUntilElementclickable(element);
		element.click();
		mobNo = mobNo.replaceAll("[^0-9]", "");
		mobNo = mobNo.substring(0,10);
		System.out.println("Entering Mobile No. : "+mobNo);
		int[] digits = new int[mobNo.length()];
		for(int i=0;i<mobNo.length();i++){
			String digitAsString=mobNo.substring(i, i+1);
			digits[i] = Integer.parseInt(digitAsString)+7;
			((AndroidDriver<WebElement>)mdriver).pressKeyCode(digits[i]);
		}
	}

	public void selectDropdown(WebElement element,String value) throws InterruptedException{
		waitUntilElementclickable(element);
		Thread.sleep(1000);
		element.click();
		Thread.sleep(500);
		try{
			WebElement item = mdriver.findElementByName(value);
			item.click();
		}
		catch(Exception e){
			mdriver.scrollToExact(value);
			Thread.sleep(1000);
			WebElement item = mdriver.findElementByName(value);
			item.click();
		}
	}
	

	public  void scrollToElementViaJavascript(WebElement element) 
	{        
		((JavascriptExecutor) mdriver).executeScript("arguments[0].scrollIntoView();", element);     
	}
	
	public void clickElement(WebElement element){
		waitUntilElementclickable(element);
		scrollToElementViaJavascript(element);
		element.click();
	}
	
	public void enterText(WebElement element, String text){
		waitUntilElementclickable(element);
		try{
			scrollToElementViaJavascript(element);
			element.click();
		}catch(Exception e){}
		element.clear();
		element.sendKeys(text);
	}

	public void sendText(WebElement element,String value){
		waitUntilElementclickable(element);
		element.sendKeys(value);
		hideKeyboard();
	}

	public AppiumDriver<WebElement> getDriver(){
		return mdriver;
	}



}
