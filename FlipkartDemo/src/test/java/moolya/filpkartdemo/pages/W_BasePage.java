package moolya.filpkartdemo.pages;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import moolya.filpkartdemo.utils.JavaUtils;

@SuppressWarnings("unused")
public class W_BasePage extends JavaUtils 
{

	public WebDriver wdriver;

	public W_BasePage(WebDriver wdriver)
	{
		this.wdriver= wdriver;
	}

	public WebDriver launchWebApp() throws IOException
	{
		String appUrl = getPropValue("appUrl");
		String browser = getPropValue("browser");
		if (browser.equalsIgnoreCase("ff")) 
		{
			wdriver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			options.addArguments("chrome.switches","--disable-geolocation");
			wdriver = new ChromeDriver(options);
		}
		
		wdriver.get(appUrl);
		wdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wdriver.manage().window().maximize();
		return wdriver;
	}
	
	public void mouseHoverOnElement(WebDriver driver,WebElement element){
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}


	public void closeBrowser(){

		wdriver.close();
		Reporter.log("*******Browser closed Successfully********", true);
	}


	public void waitUntilElementAppears(WebElement element){

		WebDriverWait wait = new WebDriverWait(wdriver, 200);
		wait.until(ExpectedConditions.visibilityOf(element));
	}


	public void waitUntilElementclickable(WebElement element){

		WebDriverWait wait = new WebDriverWait(wdriver, 200);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}


	
	public void selectDropdown(WebElement element, String value)
	{

		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}
	
	public void selectDropdownValue(WebElement element, String value){
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}


	public  void scrollToElementViaJavascript(WebElement element) 
	{        
		((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView();", element);     
	}
	public  void scrollup(String xValue) 
	{    
		String parameter="scroll(" +xValue+ ",0)"; 
		JavascriptExecutor jse = (JavascriptExecutor)wdriver;
		jse.executeScript(parameter); //x value '500' can be altered
	}
	
	public void scrollDown(String yValue) 
	{       
		String parameter="scroll(0," +yValue+ ")"; 
		JavascriptExecutor jse = (JavascriptExecutor)wdriver;
		jse.executeScript(parameter); //y value '500' can be altered
	}



	public void refreshPage()
	{
		wdriver.navigate().refresh();
		Reporter.log("Refresing Page", true);
	}


	

}


