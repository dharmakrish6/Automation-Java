package moolya.hungama.pages;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.FindsByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.hungama.utils.JavaUtils;

public class M_BasePage extends JavaUtils implements FindsByAndroidUIAutomator<MobileElement>{

	public static AppiumDriver<MobileElement> mdriver;
	public WebDriver driverWeb;

	public M_BasePage(AppiumDriver<MobileElement> mdriver){
		this.mdriver = mdriver;
	}

	@AndroidFindBy(name="Got It!")
	private MobileElement gotIt_Btn;

	@AndroidFindBy(name="UPGRADE NOW !")
	private MobileElement upgradeNow_Label;
	

	@AndroidFindBy(name="Navigate up")
	private MobileElement back_Btn;
	
	public void gotIt() throws InterruptedException{
		Thread.sleep(5000);
		try{
			gotIt_Btn.click();
		}catch(Exception e){}
	}
	
	public static void clickDeviceBackButton()
	{
		mdriver.navigate().back(); 
	}


	public AppiumDriver<MobileElement> launchmobApp() throws IOException
	{
		String deviceName = getPropValue("deviceName");
		String platformName = getPropValue("platformName");
		String platformVersion = getPropValue("platformVersion");
		String appPackage = getPropValue("appPackage");
		String appActivity = getPropValue("appActivity");
		String apkName = getPropValue("apk");
		String apkPath = System.getProperty("user.dir")+"/apks/"+apkName;
		System.out.println("*****Launching the app*****");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("platformVersion", platformVersion);
		capabilities.setCapability("appPackage",appPackage);
		capabilities.setCapability("appActivity",appActivity);
		capabilities.setCapability("app", apkPath);
		try {
			mdriver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		mdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return mdriver;
	}
	
	public void clickElementByText(String text) throws InterruptedException{
		Thread.sleep(2000);
		try{
			mdriver.findElementByName(text).click();
			Reporter.log("Clicked on "+text, true);
		}catch(Exception e){
			mdriver.scrollToExact(text);
			mdriver.findElementByName(text).click();
			Reporter.log("Scrolled and Clicked on "+text, true);
		}
	}

	public void waitUntilElementAppears(MobileElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 15);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(MobileElement element){

		WebDriverWait wait = new WebDriverWait(mdriver, 30);
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

	public void swipeVerticalUntilElementVisible(String text)
	{
		for (int i = 1; i < 50; i++){
			mdriver.swipe(100, 600, 100, 500, 1);
			try{
				mdriver.findElementByName(text).isDisplayed();
				break;
			} 
			catch (Exception e){}
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
	
	public void scrollToTextByScrollableInstance(String text){
		String uiScrollables = "new UiScrollable(new UiSelector().scrollable(true).instance(1))."
				+ "scrollIntoView(new UiSelector().description(\"" + text + "\").instance(0));" +
				"new UiScrollable(new UiSelector().scrollable(true).instance(1))."
				+ "scrollIntoView(new UiSelector().text(\"" + text + "\")).instance(0));";
		((AndroidDriver<MobileElement>)mdriver).findElementByAndroidUIAutomator(uiScrollables);
	}
	
	public void checkForUpgradePage() throws InterruptedException{
		MobileElement e = mdriver.findElementByXPath("//*");
		waitUntilElementAppears(e);
		Thread.sleep(10000);
		Assert.assertTrue(upgradeNow_Label.isDisplayed(), "Not in Upgrade Screen!");
		Reporter.log("Navigated to Upgrade Screen.", true);
	}

	public void navigateBack(){
		waitUntilElementclickable(back_Btn);
		back_Btn.click();
	}


	public MobileElement findElementByAndroidUIAutomator(String using) {
		// TODO Auto-generated method stub
		return null;
	}


	public List<MobileElement> findElementsByAndroidUIAutomator(String using) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
