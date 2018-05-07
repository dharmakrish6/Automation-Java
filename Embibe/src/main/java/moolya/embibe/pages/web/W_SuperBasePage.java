package moolya.embibe.pages.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.browserstack.local.Local;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;

import moolya.embibe.utils.JavaUtils;

public class W_SuperBasePage extends JavaUtils{

	public WebDriver wdriver;
	private Local l;
	
	String rearchURL="https://rearch.embibe.com";

	public W_SuperBasePage(WebDriver wdriver) {
		this.wdriver = wdriver;
	}

	public OcularResult getElementPixelPerfectness(Object obj,WebElement element,String elementName){
		return Ocular
				.snapshot()
				.from(obj.getClass())
				.replaceAttribute("Element", elementName)
				.sample()
				.using(wdriver)
				.element(element)
				.compare();
	}
	
	public String getCurrentUrl(){
		return wdriver.getCurrentUrl();
	}

	@SuppressWarnings({ "unused", "static-access"})
	public WebDriver launchWebApp(String browser) throws IOException
	{
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");

		if (browser.equalsIgnoreCase("ff")) 
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			FirefoxProfile ffProfile = new FirefoxProfile();
			ffProfile.setPreference("geo.enabled", false);
			ffProfile.setPreference("geo.provider.use_corelocation", false);
			ffProfile.setPreference("geo.prompt.testing", false);
			ffProfile.setPreference("geo.prompt.testing.allow", false);
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setProfile(ffProfile);
			wdriver = new FirefoxDriver(ffOptions);
		}

		//	Only for windows
		else if(browser.equalsIgnoreCase("grid")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			wdriver = new RemoteWebDriver(new URL("http://172.16.100.114:4444/wd/hub"),caps);
		}

		else if(browser.contains("ie")){
			InternetExplorerDriverService ieService = null;
			if(browser.equalsIgnoreCase("ieWinx32"))
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe"); // setting path of the IEDriver
			}
			//	Only for windows
			else if(browser.equalsIgnoreCase("ieWinx64"))
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe"); // setting path of the IEDriver
			}
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.destructivelyEnsureCleanSession();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			wdriver = new InternetExplorerDriver(ieOptions);
		}
		//	Only for mac
		else if(browser.equalsIgnoreCase("safari")){
			wdriver = new SafariDriver();
		}else if (browser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			if(System.getProperty("os.name").toLowerCase().contains("windows"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			else if(System.getProperty("os.name").toLowerCase().contains("mac"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			else if(System.getProperty("os.name").toLowerCase().contains("linux")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_linux");
				chromeOptions.addArguments("--headless");
			}
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("enable-strict-powerful-feature-restrictions");
			chromeOptions.addArguments("disable-geolocation");
			chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			chromeOptions.addArguments("window-size=1920,1080");
			wdriver = new ChromeDriver(chromeOptions);
		}
		else if(browser.contains("opera")){
			OperaOptions operaOptions = new OperaOptions();
			if(browser.equalsIgnoreCase("opera32")){
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver32.exe");
				operaOptions.setBinary("C:/Program Files (x86)/Opera/launcher.exe");
				wdriver = new OperaDriver(operaOptions);
			}else if(browser.equalsIgnoreCase("opera64")){
				if(System.getProperty("os.name").toLowerCase().contains("windows")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver64.exe");
					operaOptions.setBinary("C:/Program Files/Opera/launcher.exe");
					wdriver = new OperaDriver(operaOptions);
				}
				else if(System.getProperty("os.name").toLowerCase().contains("mac")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
					wdriver = new OperaDriver();
				}
			}
		}
		else if (browser.equalsIgnoreCase("phantomjs")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
					"--web-security=false",
					"--ssl-protocol=any",
					"--ignore-ssl-errors=true",
					"--webdriver-loglevel=INFO"
			});
			System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./drivers/phantomjs.exe");
			wdriver = new PhantomJSDriver(caps);
		}

		wdriver.get(url);
		wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(!browser.equalsIgnoreCase("ff"))
			wdriver.manage().window().maximize();
		if(System.getProperty("os.name").toLowerCase().contains("linux"))
			//wdriver.manage().window().setSize(new Dimension(1366, 768));
			wdriver.manage().window().setSize(new Dimension(1920, 1080));
		
		Reporter.log("Launched Url: "+wdriver.getCurrentUrl(), true);
		return wdriver;
	}
	
	@SuppressWarnings({ "unused"})
	public WebDriver launchWebApp(String browser,String url) throws IOException
	{
		url = getPropValue(url);

		if (browser.equalsIgnoreCase("ff")) 
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			FirefoxProfile ffProfile = new FirefoxProfile();
			ffProfile.setPreference("geo.enabled", false);
			ffProfile.setPreference("geo.provider.use_corelocation", false);
			ffProfile.setPreference("geo.prompt.testing", false);
			ffProfile.setPreference("geo.prompt.testing.allow", false);
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setProfile(ffProfile);
			wdriver = new FirefoxDriver(ffOptions);
		}

		//	Only for windows
		else if(browser.equalsIgnoreCase("grid")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			wdriver = new RemoteWebDriver(new URL("http://172.16.100.114:4444/wd/hub"),caps);
		}

		else if(browser.contains("ie")){
			InternetExplorerDriverService ieService = null;
			if(browser.equalsIgnoreCase("ieWinx32"))
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe"); // setting path of the IEDriver
			}
			//	Only for windows
			else if(browser.equalsIgnoreCase("ieWinx64"))
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe"); // setting path of the IEDriver
			}
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.destructivelyEnsureCleanSession();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			wdriver = new InternetExplorerDriver(ieOptions);
		}
		//	Only for mac
		else if(browser.equalsIgnoreCase("safari")){
			wdriver = new SafariDriver();
		}else if (browser.equalsIgnoreCase("chrome")) 
		{
			ChromeOptions chromeOptions = new ChromeOptions();
			if(System.getProperty("os.name").toLowerCase().contains("windows"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			else if(System.getProperty("os.name").toLowerCase().contains("mac"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			else if(System.getProperty("os.name").toLowerCase().contains("linux")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver_linux");
				chromeOptions.addArguments("--headless");
			}
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("enable-strict-powerful-feature-restrictions");
			chromeOptions.addArguments("disable-geolocation");
			chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			wdriver = new ChromeDriver(chromeOptions);
		}
		else if(browser.contains("opera")){
			OperaOptions operaOptions = new OperaOptions();
			if(browser.equalsIgnoreCase("opera32")){
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver32.exe");
				operaOptions.setBinary("C:/Program Files (x86)/Opera/launcher.exe");
				wdriver = new OperaDriver(operaOptions);
			}else if(browser.equalsIgnoreCase("opera64")){
				if(System.getProperty("os.name").toLowerCase().contains("windows")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver64.exe");
					operaOptions.setBinary("C:/Program Files/Opera/launcher.exe");
					wdriver = new OperaDriver(operaOptions);
				}
				else if(System.getProperty("os.name").toLowerCase().contains("mac")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
					wdriver = new OperaDriver();
				}
			}
		}
		else if (browser.equalsIgnoreCase("phantomjs")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
					"--web-security=false",
					"--ssl-protocol=any",
					"--ignore-ssl-errors=true",
					"--webdriver-loglevel=INFO"
			});
			System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./drivers/phantomjs.exe");
			wdriver = new PhantomJSDriver(caps);
		}

		wdriver.get(url);
		wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		if(!browser.equalsIgnoreCase("ff"))
			wdriver.manage().window().maximize();
		if(System.getProperty("os.name").toLowerCase().contains("linux"))
			wdriver.manage().window().setSize(new Dimension(1366, 768));
		Reporter.log("Launched Url: "+wdriver.getCurrentUrl(), true);
		return wdriver;
	}
	
	

	@SuppressWarnings({ "static-access", "unchecked" })
	public WebDriver launchApp(String config_file, String environment,String className) throws IOException, ParseException{

		String dir = System.getProperty("user.dir");
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");

		if(config_file.equals("NA")){
			if (environment.equalsIgnoreCase("ff")) 
			{
				System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
				FirefoxProfile ffProfile = new FirefoxProfile();
				ffProfile.setPreference("geo.enabled", false);
				ffProfile.setPreference("geo.provider.use_corelocation", false);
				ffProfile.setPreference("geo.prompt.testing", false);
				ffProfile.setPreference("geo.prompt.testing.allow", false);
				FirefoxOptions ffOptions = new FirefoxOptions();
				ffOptions.setProfile(ffProfile);
				wdriver = new FirefoxDriver(ffOptions);
			}

			//	Only for windows
			else if(environment.equalsIgnoreCase("grid")){
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
				DesiredCapabilities caps = DesiredCapabilities.chrome();
				wdriver = new RemoteWebDriver(new URL("http://172.16.100.114:4444/wd/hub"),caps);
			}

			else if(environment.contains("ie")){
				InternetExplorerDriverService ieService = null;
				if(environment.equalsIgnoreCase("ieWinx32"))
				{
					System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe"); // setting path of the IEDriver
				}
				//	Only for windows
				else if(environment.equalsIgnoreCase("ieWinx64"))
				{
					System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe"); // setting path of the IEDriver
				}
				InternetExplorerOptions ieOptions = new InternetExplorerOptions();
				ieOptions.destructivelyEnsureCleanSession();
				ieOptions.introduceFlakinessByIgnoringSecurityDomains();
				wdriver = new InternetExplorerDriver(ieOptions);
			}
			//	Only for mac
			else if(environment.equalsIgnoreCase("safari")){
				wdriver = new SafariDriver();
			}else if (environment.equalsIgnoreCase("chrome")) 
			{
				if(System.getProperty("os.name").toLowerCase().contains("windows"))
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
				else if(System.getProperty("os.name").toLowerCase().contains("mac"))
					System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
				ChromeOptions chromeOptions = new ChromeOptions();
				LoggingPreferences logPrefs = new LoggingPreferences();
				logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
				chromeOptions.addArguments("test-type");
				chromeOptions.addArguments("enable-strict-powerful-feature-restrictions");
				chromeOptions.addArguments("disable-geolocation");
				chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
				chromeOptions.addArguments("window-size=1920,1080");
				wdriver = new ChromeDriver(chromeOptions);
			}
			else if(environment.contains("opera")){
				OperaOptions operaOptions = new OperaOptions();
				if(environment.equalsIgnoreCase("opera32")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver32.exe");
					operaOptions.setBinary("C:/Program Files (x86)/Opera/launcher.exe");
					wdriver = new OperaDriver(operaOptions);
				}else if(environment.equalsIgnoreCase("opera64")){
					if(System.getProperty("os.name").toLowerCase().contains("windows")){
						System.setProperty("webdriver.opera.driver", "./drivers/operadriver64.exe");
						operaOptions.setBinary("C:/Program Files/Opera/launcher.exe");
						wdriver = new OperaDriver(operaOptions);
					}
					else if(System.getProperty("os.name").toLowerCase().contains("mac")){
						System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
						wdriver = new OperaDriver();
					}
				}
			}
			else if (environment.equalsIgnoreCase("phantomjs")){
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setJavascriptEnabled(true);
				caps.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
				caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
				caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
						"--web-security=false",
						"--ssl-protocol=any",
						"--ignore-ssl-errors=true",
						"--webdriver-loglevel=INFO"
				});
				System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./drivers/phantomjs.exe");
				wdriver = new PhantomJSDriver(caps);
			}
		}else{
			org.json.simple.parser.JSONParser parser = new JSONParser();
			org.json.simple.JSONObject config = (org.json.simple.JSONObject) parser.parse(new FileReader("src/test/resources/conf/" + config_file));
			org.json.simple.JSONObject envs = (org.json.simple.JSONObject) config.get("environments");

			DesiredCapabilities capabilities = new DesiredCapabilities();

			Map<String, String> envCapabilities = (Map<String, String>) envs.get(environment);
			Iterator<Entry<String, String>> it = envCapabilities.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String,String> pair = (Map.Entry<String,String>)it.next();
				capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
			}

			Map<String, String> commonCapabilities = (Map<String, String>) config.get("capabilities");
			it = commonCapabilities.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry<String,String> pair = (Map.Entry<String,String>)it.next();
				if(capabilities.getCapability(pair.getKey().toString()) == null){
					capabilities.setCapability(pair.getKey().toString(), pair.getValue().toString());
				}
			}

			String username = System.getenv("BROWSERSTACK_USERNAME");
			if(username == null) {
				username = (String) config.get("user");
			}

			String accessKey = System.getenv("BROWSERSTACK_ACCESS_KEY");
			if(accessKey == null) {
				accessKey = (String) config.get("key");
			}

			if(capabilities.getCapability("browserstack.local") != null && capabilities.getCapability("browserstack.local") == "true"){
				l = new Local();
				Map<String, String> options = new HashMap<String, String>();
				options.put("key", accessKey);
				try {
					l.start(options);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			capabilities.setCapability("name", className);
			wdriver = new RemoteWebDriver(new URL("http://"+username+":"+accessKey+"@"+config.get("server")+"/wd/hub"), capabilities);
		}

		wdriver.get(url);
		wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wdriver.manage().window().maximize();
		Reporter.log("Launched Url: "+wdriver.getCurrentUrl(), true);
		return wdriver;
	}
	
	public LogEntries getLogs(){
		LogEntries logEntries = wdriver.manage().logs().get(LogType.PERFORMANCE);
		return logEntries;
	}
	
	

	public String analyzeLog() {
		String text = "";
		LogEntries logEntries = wdriver.manage().logs().get(LogType.PERFORMANCE);
		for (LogEntry entry : logEntries) {
			text = text + new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage()+"\n";
			//			System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
			//do something useful with the data
		}
		return text;
	}

	public File takeElementScreenshot(WebElement element,String elementName) throws IOException{
		// Get entire page screenshot
		File screenshot = ((TakesScreenshot)wdriver).getScreenshotAs(OutputType.FILE);
		BufferedImage  fullImg = ImageIO.read(screenshot);

		// Get the location of element on the page
		Point point = element.getLocation();

		// Get width and height of the element
		int eleWidth = element.getSize().getWidth();
		int eleHeight = element.getSize().getHeight();
		// Crop the entire page screenshot to get only element screenshot
		BufferedImage eleScreenshot= fullImg.getSubimage(point.getX(), point.getY(),
				eleWidth, eleHeight);
		ImageIO.write(eleScreenshot, "png", screenshot);

		return screenshot;

		/*// Copy the element screenshot to disk
		File screenshotLocation = new File("./elements/"+elementName+".png");
		FileUtils.copyFile(screenshot, screenshotLocation);*/
	}


	public void writePagesourceToFile(String text) throws IOException{
		if(!new File("./pagesource.html").exists())
			new File("./pagesource.html").delete();
		FileOutputStream fos = new FileOutputStream(new File("./pageSource.html"));
		fos.write(text.getBytes());
		fos.close();
	}

	public void waitForAngularRequestToFinish(){
		WebDriverWait wait = new WebDriverWait(wdriver, 60);
		wait.until(angularHasFinishedProcessing());
	}

	public ExpectedCondition<Boolean> angularHasFinishedProcessing() {
		return new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return Boolean.valueOf(((JavascriptExecutor) driver).executeScript("return (window.angular !== undefined) && (angular.element(document).injector() !== undefined) && (angular.element(document).injector().get('$http').pendingRequests.length === 0)").toString());
			}
		};
	}

	public void takeScreenShot(String name){
		String dir = System.getProperty("user.dir");
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		File scrFile = ((TakesScreenshot)wdriver).getScreenshotAs(OutputType.FILE);
		String file =dir+"/screenshots/"+name+"-"+dateFormat.format(date)+".png";
		try {
			FileUtils.copyFile(scrFile, new File(file));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void mouseHoverOnElement(WebDriver driver,WebElement element) throws InterruptedException{
		Thread.sleep(2000);
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
		} catch (Exception e) {
			scrollToElementViaJavascript(element);
			scrollVertically("-100");
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
		}
		Thread.sleep(1000);
	}

	public void mouseHoverOnElement(WebDriver driver,WebElement element,String message) throws InterruptedException{
		Thread.sleep(2000);
		try {
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
		} catch (Exception e) {
			scrollToElementViaJavascript(element);
			scrollVertically("-100");
			Actions act = new Actions(driver);
			act.moveToElement(element).build().perform();
		}
		Thread.sleep(1000);
		Reporter.log(message, true);
	}

	public void mouseHover(WebDriver driver,int x,int y){
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).build().perform();
	}
	
	public void mouseHover(WebDriver driver, WebElement element,int x,int y, String message) throws InterruptedException{
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.moveToElement(element, x, y).build().perform();
		Reporter.log(message, true);
	}
	

	public void waitandAcceptAlert(){
		WebDriverWait wait = new WebDriverWait(wdriver, 30);
		wait.until(ExpectedConditions.alertIsPresent());
		try{
			wdriver.switchTo().alert().accept();
			Reporter.log("Accepted Alert", true);
		}catch(Exception e){
			Reporter.log("Alert not present", true);
		}
	}


	public void closeBrowser(){

		wdriver.close();
		Reporter.log("*******Browser closed Successfully********", true);
	}


	public void waitUntilElementAppears(WebElement element){

		WebDriverWait wait = new WebDriverWait(wdriver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementclickable(WebElement element){

		WebDriverWait wait = new WebDriverWait(wdriver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementclickable(WebElement element,int seconds){

		WebDriverWait wait = new WebDriverWait(wdriver, seconds);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitUntilElementAppears(WebElement element,int seconds){

		WebDriverWait wait = new WebDriverWait(wdriver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void clickElement(WebElement element,String message){
		waitUntilElementclickable(element);
		try{
			element.click();
		}catch(Exception e){
			scrollToElementViaJavascript(element);
			element.click();
		}
		Reporter.log(message, true);
	}

	public void clickElement(WebElement element){
		waitUntilElementclickable(element);
		try{
			element.click();
		}catch(Exception e){
			scrollVertically("-1000");
			scrollToElementViaJavascript(element);
			try {
				element.click();
			} catch (Exception e1) {
				while(true){
					try {
						scrollVertically("-20");
						element.click();
						break;
					} catch (Exception e2) {}
				}
			}
		}
	}

	public void enterText(WebElement element, String text,String message){
		waitUntilElementclickable(element);
		try{
			element.click();
		}catch(Exception e){
			scrollToElementViaJavascript(element);
			element.click();
		}
		element.clear();
		element.sendKeys(text);
		Reporter.log(message, true);
	}

	public void enterText(WebElement element, String text){
		waitUntilElementclickable(element);
		try{
			element.click();
		}catch(Exception e){
			scrollToElementViaJavascript(element);
			element.click();
		}
		element.clear();
		element.sendKeys(text);
	}


	public void selectDropdownText(WebElement element, String value)
	{
		waitUntilElementclickable(element);
		Select dropdown = new Select(element);
		dropdown.selectByVisibleText(value);
	}

	public void selectCustomDropdown(WebElement dropdown, List<WebElement> items, String text,String message){
		waitUntilElementclickable(dropdown);
		dropdown.click();
		for(WebElement e:items)
			if(e.getText().equalsIgnoreCase(text)){
				try{
					e.click();
				}catch(Exception e1){
					scrollToElementViaJavascript(e);
					e.click();
				}
				break;
			}
		Reporter.log(message, true);
	}

	public void selectDropdownValue(WebElement element, String value)
	{
		waitUntilElementclickable(element);
		Select dropdown = new Select(element);
		dropdown.selectByValue(value);
	}


	public  void scrollToElementViaJavascript(WebElement element) 
	{      
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {}
		((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView();", element);     
	}
	

	public String getElementWidthViaJavascript(WebElement e){
		long width = Long.parseLong(String.valueOf(((JavascriptExecutor) wdriver).executeScript("return arguments[0].offsetWidth;", e)));
 		return Long.toString(width);
 	}

	public String getElementHeightViaJavascript(WebElement e){
		long height = Long.parseLong(String.valueOf(((JavascriptExecutor) wdriver).executeScript("return arguments[0].offsetHeight;", e)));
 		return Long.toString(height);
 	}

	public  void scrollVertically(String xValue) 
	{    
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String parameter="window.scrollBy(0," +xValue+ ")"; 
		JavascriptExecutor jse = (JavascriptExecutor)wdriver;
		jse.executeScript(parameter,""); //x value '500' can be altered
	}

	public void navigateBack(){
		wdriver.navigate().back();
	}

	public void writeOutputToFile(String fileName,String text) throws IOException{
		String dir = System.getProperty("user.dir");
		File file = new File(dir,fileName);

		// creates the file
		if(file.exists())
			file.delete();
		else
			file.createNewFile();

		// creates a FileWriter Object
		FileWriter writer = new FileWriter(file); 

		// Writes the content to the file
		writer.write(text); 
		writer.flush();
		writer.close();
	}

	

	public void clickElementViaJavaScript(WebElement element){
		waitUntilElementclickable(element);
		JavascriptExecutor executor = (JavascriptExecutor)wdriver;
		executor.executeScript("arguments[0].click();", element);
	}

	public String getMainWindowHandle(){
		return wdriver.getWindowHandle();
	}

	public String switchToNextWindow(String maindow){
		Set<String> windows = wdriver.getWindowHandles();
		String childWindow = null;
		for(String s:windows){
			if(!s.equals(maindow)){
				childWindow = s;
				wdriver.switchTo().window(s);
			}
		}
		return childWindow;
	}

	public void closeChildAndSwitchToMainWindow(String mainWindow){
		wdriver.close();
		wdriver.switchTo().window(mainWindow);
	}

	public void refreshPage()
	{
		wdriver.navigate().refresh();
		//Reporter.log("Refreshing Page", true);
	}
	
	

}
