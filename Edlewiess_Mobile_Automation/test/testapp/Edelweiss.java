package testapp;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.GetConfirmation;

import actions.BuyTrade;
import actions.LoginAction;
import actions.TutorialsActions;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HomePage;
import utility.AdbUitls;

public class Edelweiss {

	AndroidDriver driver = null;
	DesiredCapabilities capabilities = null;
	String udid;
	// WebDriver driver = null;

	@BeforeClass
	public void setup() throws MalformedURLException {
		File appDir = new File("E:\\");
		File app = new File(appDir, "EMTAndroid_UAT_3.4.apk");
		capabilities = new DesiredCapabilities();

		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("deviceName", "Moto G");
		capabilities.setCapability("platformVersion", "5.1.1");

		/*
		 * capabilities.setCapability("device","Redmi");
		 * capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		 * capabilities.setCapability(CapabilityType.VERSION, "4.4.4");
		 * capabilities.setCapability(CapabilityType.PLATFORM, "Android");
		 */
		// Here we mention the app's package name, to find the package name we
		// have to convert .apk file into java class files
		capabilities.setCapability("app-package", "com.msf.emt.mobile");
		// Here we mention the activity name, which is invoked initially as
		// app's first page.
		capabilities.setCapability("app-activity", "SplashScreen");
		capabilities.setCapability("app-wait-activity", "MainActivity");
		capabilities.setCapability("app", app.getAbsolutePath());

	}

	/*@Test(priority = 1)
	public void homeScreen() throws Exception {

		TutorialsActions.gotohome(driver);
		WebElement nifty = driver.findElement(HomePage.niftyprice);
		WebElement sensex = driver.findElement(HomePage.sensex);
		if (nifty.isDisplayed() && sensex.isDisplayed()) {

			System.out.println("nifty and Sensex Element is present  present");
			String actualproce1 = driver.findElement(HomePage.niftyprice).getText();
			String actualproce2 = driver.findElement(HomePage.sensex).getText();
			System.out.println("Nifty  Price is " + actualproce1);
			System.out.println("Sensex Price is " + actualproce2);

		} else {
			System.out.println("nifty and Sensex Element is not present");
		}
		Assert.assertTrue(nifty.isDisplayed(), "Element is not present in the screen");

	}

	@Test(priority = 2)
	
	public void marketScreen() throws Exception {
		//TutorialsActions.gotohome(driver);
		driver.findElement(HomePage.market).click();
		driver.findElement(HomePage.nextbtn).click();
		driver.findElement(HomePage.donebtn).click();
		WebElement graph1=driver.findElement(MarketPage.graph1);
		WebElement graph2=driver.findElement(MarketPage.graph1);
		WebElement graph3=driver.findElement(MarketPage.graph1);
		Assert.assertTrue(graph1.isEnabled(), "Graph_1 Element is not present in the screen");
		Assert.assertTrue(graph2.isEnabled(), "Graph_2 Element is not present in the screen");
		Assert.assertTrue(graph3.isEnabled(), "Graph_3 Element is not present in the screen");
		System.out.println("Height"+graph1.getSize().height);
		System.out.println("Width"+graph1.getSize().width);

	}*/

	@Test(priority = 3,dataProvider="getDevices")
	public void buyTrade(String deviceId) throws Exception {
		udid = deviceId;
		capabilities.setCapability("udid", deviceId);

		driver = new AndroidDriver(new URL("http://127.0.0.1:5000/wd/hub"), capabilities);
		EventFiringWebDriver eventDriver = new EventFiringWebDriver(driver);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//		TutorialsActions.gotohome(driver);
//		driver.findElement(HomePage.right_menu).click();
//		driver.findElement(HomePage.login_lock).click();
//		LoginAction.signin(driver);
//		BuyTrade.buy(driver);

	}
	
	@AfterMethod
	public void displayDeviceName() throws IOException{
		String line = AdbUitls.getDeviceName(udid);
	    Reporter.log("Test Executed on : "+line,true);
	}
	
	@DataProvider
	public Object[][] getDevices(){
		ArrayList<String> al;
		String line = "";
		int lines = 0;
		Object[][] obj = null;
		try {
		    al = AdbUitls.getConnetedDevices();
		    obj = new Object[al.size()][1];
		    int i=0;
		    for(String str:al){
		    	obj[i][0]=str;
		    	i++;
		    }
		        
		} catch (Exception e) {
		    System.err.println("Error");
		}
		return obj;
	}
	
	

	@AfterClass
	public void tearDown() {
		//driver.quit();

	}

}
