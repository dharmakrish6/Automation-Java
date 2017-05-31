package sunxt.testCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import sunxt.pages.BasePage;

public class BaseTest {
	
	BasePage bp;
	protected WebDriver driver;
	String url="https://www.sunnxt.com/welcome"; 
	
	@BeforeClass
	public void setup(){
		bp = new BasePage(driver);
		driver = bp.launchBrowser(url);
		System.out.println("BeforeClass");
	}
	
	@AfterClass
	public void tearDown(){
//		bp.closeBrowser();
		System.out.println("AfterClass");
	}

}
