package moolya.strikingly.mobileTest;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.strikingly.AppiumServerUtils;

public class MobileLoginTest {
	
	String launchPackage;
	String launchActivity;
	AppiumDriver<MobileElement> driver;
	
	By email_TB = By.id("user_email");
	By password_TB = By.id("user_password");
	By login_Btn = By.name("commit");
	By loginWithFB_Btn = By.xpath("//a[text()='Facebook']");
	By loginWithLn_Btn = By.xpath("//a[text()='LinkedIn']");
	By user_DD = By.xpath("//*[@class='fa fa-chevron-down']");
	By logout_Btn = By.xpath("//span[text()='Logout']");
	By fbEmail_TB = By.name("email");
	By fbPass_TB = By.name("pass");
	By fbLogin_Btn = By.id("u_0_6");
	By lnEmail_TB = By.name("session_key");
	By lnPass_TB = By.name("session_password");
	By lnAllow_Btn = By.name("authorize");
	By imNotRobot_CB = By.className("recaptcha-checkbox-checkmark");
	

	@BeforeClass
	public void setup() throws IOException, InterruptedException{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setPlatform(Platform.ANDROID);
		capabilities.setCapability("deviceName", "android");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("app", "chrome");
		AppiumServerUtils.startAppium();
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.get("https://www.strikingly.com/s/login?locale=en");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		System.out.println("Android Title is: " + driver.getTitle());
	}
	
	@Test(priority=1)
	public void webGmailLoginTest(){
		driver.findElement(email_TB).sendKeys("moolya.mob@gmail.com");
		driver.findElement(password_TB).sendKeys("moolya123");
		driver.findElement(login_Btn).click();
		driver.findElement(user_DD).click();
		driver.findElement(logout_Btn).click();
		
	}
	
	@Test(priority=2,dependsOnMethods="webGmailLoginTest")
	public void webFbLoginTest() throws InterruptedException{
		String mainWindow = driver.getWindowHandle();
		driver.findElement(loginWithFB_Btn).click();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows){
			if(!window.equals(mainWindow)){
				driver.switchTo().window(window);
				break;
			}
		}
		Thread.sleep(3000);
		driver.findElement(fbEmail_TB).sendKeys("moolya.mobfb@gmail.com");
		driver.findElement(fbPass_TB).sendKeys("moolya123");
		Thread.sleep(2000);
		driver.findElement(fbLogin_Btn).click();
		driver.switchTo().window(mainWindow);
		driver.findElement(user_DD).click();
		driver.findElement(logout_Btn).click();
		
	}
	
	@Test(priority=3,dependsOnMethods="webFbLoginTest")
	public void webLnLoginTest() throws InterruptedException{
		driver.findElement(loginWithLn_Btn).click();
		Thread.sleep(3000);
		driver.findElement(lnEmail_TB).sendKeys("moolya.mobln@gmail.com");
		driver.findElement(lnPass_TB).sendKeys("moolya123");
		driver.findElement(lnAllow_Btn).click();
		driver.findElement(user_DD).click();
		driver.findElement(logout_Btn).click();
	}
	
	@AfterMethod
	public void afterTestMethod(ITestResult r){
		driver.navigate().to("https://www.strikingly.com/s/login?locale=en");
	}
	
	@AfterClass
	public void teardown() throws ATUTestRecorderException, IOException, InterruptedException{
		driver.quit();
		AppiumServerUtils.stopAppium();
	}

}
