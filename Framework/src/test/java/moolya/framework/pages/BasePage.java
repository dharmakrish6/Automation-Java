package moolya.framework.pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.MobileElement;

public class BasePage {
	public WebDriver driver;


	public BasePage(WebDriver driverWeb)
	{
		this.driver= driverWeb;
	}

	public WebDriver launchBrowser(String url)
	{
		driver = new FirefoxDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
	}

	public void closeBrowser(){
		driver.close();
	}

	public void waitUntilElementAppears(WebElement element){

		WebDriverWait wait = new WebDriverWait(driver, 25);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static String getPropValue(String key,String projectName){

		String propValue = null;
		try {
			FileInputStream input = new FileInputStream("../"+projectName+"/config.properties");
			Properties prop = new Properties();
			prop.load(input);

			propValue = prop.getProperty(key);

		} catch (IOException e) {
			System.out.println("Caught the below exception!");
			e.printStackTrace();
		}
		return propValue;
	}

	public static String getPropValue(String key) throws IOException
	{
		File configFile = new File("./config.properties");
		String host = null;
		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			host = props.getProperty(key);
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}

		return host;
	}
	
	public void selectDropdown(WebElement element,String text){
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void setPropValue(String key,String value){
		File configFile = new File("./config.properties");
		try {
			Properties props = new Properties();
			props.setProperty(key, value);
			FileWriter writer = new FileWriter(configFile);
			props.store(writer, "host settings");
			writer.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}
	}

}
