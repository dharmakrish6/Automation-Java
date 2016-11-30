package moolya.strikingly.webTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import atu.testrecorder.ATUTestRecorder;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class WebLoginTest {
	
	WebDriver driver;
	By email_TB = By.id("user_email");
	By password_TB = By.id("user_password");
	By login_Btn = By.name("commit");
	By loginWithFB_Btn = By.xpath("//a[text()='Facebook']");
	By loginWithLn_Btn = By.xpath("//a[text()='LinkedIn']");
	By user_Icon = By.xpath("(//*[@class='entypo-user'])[1]");
	By loggedInAs_Label = By.className("logged-in-as");
	By logout_Btn = By.xpath("//span[text()='Logout']");
	By fbEmail_TB = By.id("email");
	By fbPass_TB = By.id("pass");
	By fbLogin_Btn = By.id("u_0_2");
	By fbContinueAs_Btn = By.xpath("//button[text()='Continue as Moo']");
	By lnEmail_TB = By.id("session_key-oauth2SAuthorizeForm");
	By lnPass_TB = By.id("session_password-oauth2SAuthorizeForm");
	By lnAllow_Btn = By.name("authorize");
	By imNotRobot_CB = By.className("recaptcha-checkbox-checkmark");
	
	ATUTestRecorder recorder;
	
	@BeforeClass
	public void setup() throws ATUTestRecorderException{
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		recorder = new ATUTestRecorder(dir+"\\script-videos\\", "Web-Login-" + dateFormat.format(date), false);
		System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("chrome.switches","--disable-extensions");
		options.addArguments("chrome.switches","--disable-geolocation");
		driver = new ChromeDriver(options);
		driver.get("https://www.strikingly.com/s/login?locale=en");
		recorder.start();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void webGmailLoginTest(){
		driver.findElement(email_TB).sendKeys("moolya.web@gmail.com");
		driver.findElement(password_TB).sendKeys("moolya123");
		driver.findElement(login_Btn).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(user_Icon)).build().perform();
		String userName = driver.findElement(loggedInAs_Label).getText();
		Assert.assertTrue(userName.contains("moolya.web@gmail.com"), "Login not successful!");
		driver.findElement(logout_Btn).click();
	}
	
	@Test(priority=2,dependsOnMethods="webGmailLoginTest")
	public void webFbLoginTest(){
		String mainWindow = driver.getWindowHandle();
		driver.findElement(loginWithFB_Btn).click();
		Set<String> windows = driver.getWindowHandles();
		for(String window:windows){
			if(!window.equals(mainWindow)){
				driver.switchTo().window(window);
				break;
			}
		}
		driver.findElement(fbEmail_TB).sendKeys("moolya.webfb@gmail.com");
		driver.findElement(fbPass_TB).sendKeys("moolya123");
		driver.findElement(fbLogin_Btn).click();
//		driver.findElement(fbContinueAs_Btn).click();
		driver.switchTo().window(mainWindow);
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(user_Icon)).build().perform();
		String userName = driver.findElement(loggedInAs_Label).getText();
		Assert.assertTrue(userName.contains("moolya.webfb@gmail.com"), "Login not successful!");
		driver.findElement(logout_Btn).click();
	}
	
	@Test(priority=3,dependsOnMethods="webFbLoginTest")
	public void webLnLoginTest(){
		driver.findElement(loginWithLn_Btn).click();
		driver.findElement(lnEmail_TB).sendKeys("moolya.webln@gmail.com");
		driver.findElement(lnPass_TB).sendKeys("moolya123");
		driver.findElement(lnAllow_Btn).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(user_Icon)).build().perform();
		String userName = driver.findElement(loggedInAs_Label).getText();
		Assert.assertTrue(userName.contains("moolya.webln@gmail.com"), "Login not successful!");
		driver.findElement(logout_Btn).click();
	}
	
	@AfterMethod
	public void afterTestMethod(){
		driver.navigate().to("https://www.strikingly.com/s/login?locale=en");
	}
	
	@AfterClass
	public void teardown() throws ATUTestRecorderException{
		recorder.stop();
		driver.close();
	}

}
