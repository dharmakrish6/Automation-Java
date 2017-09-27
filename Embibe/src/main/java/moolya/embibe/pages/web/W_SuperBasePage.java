package moolya.embibe.pages.web;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.opera.OperaDriver;
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

import com.google.common.collect.ImmutableMap;
import com.testautomationguru.ocular.Ocular;
import com.testautomationguru.ocular.comparator.OcularResult;

import moolya.embibe.utils.JavaUtils;

public class W_SuperBasePage extends JavaUtils{

	public WebDriver wdriver;

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


	public WebDriver launchWebApp() throws IOException
	{
		String dir = System.getProperty("user.dir");
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");

		String browser = getPropValue("browser");
		if (browser.equalsIgnoreCase("ff")) 
		{
			wdriver = new FirefoxDriver();
		}

		//	Only for windows
		else if(browser.equalsIgnoreCase("ieWinx32"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe"); // setting path of the IEDriver
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			wdriver = new InternetExplorerDriver(ieCapabilities);
		}
		//	Only for windows
		else if(browser.equalsIgnoreCase("ieWinx64"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe"); // setting path of the IEDriver
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			wdriver = new InternetExplorerDriver(ieCapabilities);
		}
		//	Only for mac
		else if(browser.equalsIgnoreCase("safari")){
			wdriver = new SafariDriver();
		}else if (browser.equalsIgnoreCase("chrome")) 
		{
			if(System.getProperty("os.name").toLowerCase().contains("windows"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			else if(System.getProperty("os.name").toLowerCase().contains("mac"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			options.addArguments("chrome.switches","--disable-geolocation");
			wdriver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("opera32")){
			System.setProperty("webdriver.opera.driver", "./drivers/operadriver32.exe");
			wdriver = new OperaDriver();
		}else if(browser.equalsIgnoreCase("opera64")){
			if(System.getProperty("os.name").toLowerCase().contains("windows"))
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver64.exe");
			else if(System.getProperty("os.name").toLowerCase().contains("mac"))
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
			wdriver = new OperaDriver();
		}else if (browser.equalsIgnoreCase("phantomjs")){
			//			String userAgent = "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1";
			//			System.setProperty("phantomjs.page.settings.userAgent", userAgent);
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
		wdriver.manage().window().maximize();
		Reporter.log("Launched Url: "+wdriver.getCurrentUrl(), true);
		return wdriver;
	}

	public WebDriver launchWebApp(String browser) throws IOException
	{
		String dir = System.getProperty("user.dir");
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");

		if (browser.equalsIgnoreCase("ff")) 
		{
			wdriver = new FirefoxDriver();
		}

		//	Only for windows
		else if(browser.equalsIgnoreCase("grid")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			wdriver = new RemoteWebDriver(new URL("http://172.16.100.114:4444/wd/hub"),caps);
		}
		
		else if(browser.equalsIgnoreCase("ieWinx32"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe"); // setting path of the IEDriver
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			wdriver = new InternetExplorerDriver(ieCapabilities);
		}
		//	Only for windows
		else if(browser.equalsIgnoreCase("ieWinx64"))
		{
			System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe"); // setting path of the IEDriver
			DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
			ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			wdriver = new InternetExplorerDriver(ieCapabilities);
		}
		//	Only for mac
		else if(browser.equalsIgnoreCase("safari")){
			wdriver = new SafariDriver();
		}else if (browser.equalsIgnoreCase("chrome")) 
		{
			if(System.getProperty("os.name").toLowerCase().contains("windows"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			else if(System.getProperty("os.name").toLowerCase().contains("mac"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("chrome.switches","--disable-extensions");
			options.addArguments("chrome.switches","--disable-geolocation");
			wdriver = new ChromeDriver(options);
		}else if(browser.equalsIgnoreCase("opera32")){
			System.setProperty("webdriver.opera.driver", "./drivers/operadriver32.exe");
			ChromeOptions options = new ChromeOptions();
			options.setBinary("C:/Program Files (x86)/Opera/launcher.exe");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			wdriver = new OperaDriver(capabilities);
		}else if(browser.equalsIgnoreCase("opera64")){
			if(System.getProperty("os.name").toLowerCase().contains("windows")){
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver64.exe");
				ChromeOptions options = new ChromeOptions();
				options.setBinary("C:/Program Files/Opera/launcher.exe");
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability(ChromeOptions.CAPABILITY, options);
				wdriver = new OperaDriver(capabilities);
			}
			else if(System.getProperty("os.name").toLowerCase().contains("mac")){
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
				wdriver = new OperaDriver();
			}
		}else if (browser.equalsIgnoreCase("phantomjs")){
			//			String userAgent = "Mozilla/5.0 (Windows NT 6.0) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/13.0.782.41 Safari/535.1";
			//			System.setProperty("phantomjs.page.settings.userAgent", userAgent);
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
		wdriver.manage().window().maximize();
		Reporter.log("Launched Url: "+wdriver.getCurrentUrl(), true);
		return wdriver;
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


	public void mouseHoverOnElement(WebDriver driver,WebElement element){
		waitUntilElementAppears(element);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
	}
	
	public void mouseHoverOnElement(WebDriver driver,WebElement element,String message){
		waitUntilElementAppears(element);
		Actions act = new Actions(driver);
		act.moveToElement(element).build().perform();
		Reporter.log(message, true);
	}

	public void mouseHover(WebDriver driver,int x,int y){
		Actions act = new Actions(driver);
		act.moveByOffset(x, y).build().perform();
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

		WebDriverWait wait = new WebDriverWait(wdriver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitUntilElementclickable(WebElement element){

		WebDriverWait wait = new WebDriverWait(wdriver, 20);
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
		scrollToElementViaJavascript(element);
		element.click();
		Reporter.log(message, true);
	}
	
	public void clickElement(WebElement element){
		waitUntilElementclickable(element);
		scrollToElementViaJavascript(element);
		element.click();
	}

	public void enterText(WebElement element, String text,String message){
		waitUntilElementclickable(element);
		try{
			scrollToElementViaJavascript(element);
			element.click();
		}catch(Exception e){}
		element.clear();
		element.sendKeys(text);
		Reporter.log(message, true);
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
		((JavascriptExecutor) wdriver).executeScript("arguments[0].scrollIntoView();", element);     
	}
	public  void scrollup(String xValue) 
	{    
		String parameter="scroll(" +xValue+ ",0)"; 
		JavascriptExecutor jse = (JavascriptExecutor)wdriver;
		jse.executeScript(parameter); //x value '500' can be altered
	}

	public void navigateBack(){
		wdriver.navigate().back();
	}

	public HashMap<String, String> readPixelData(String sheetName,String pageName,String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		sheetName = width+"X"+height;
		HashMap<String,String> dataMap = null;
		String key = null, value = null;
		FileInputStream file = new FileInputStream("./test-data/PixelData.xlsx");
		dataMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=3;i<headers.getLastCellNum();i++){
					if(headers.getCell(i).toString().trim().startsWith("z_")){
						try{
							try {
								value = record.getCell(i).toString().trim();
								key = headers.getCell(i).toString().trim();
							} catch (Exception e) {
								value = record.getCell(i).getStringCellValue();
								key = headers.getCell(i).toString().trim();
							}
						}catch(Exception e){
							continue;
						}
					}

					dataMap.put(key, value);
				}

				break;
			}
		}
		wb.close();
		file.close();
		return dataMap;
	}

	public HashMap<String, String> readAllPixelData(String sheetName,String pageName,String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		sheetName = width+"X"+height;
		HashMap<String,String> dataMap = null;
		String key = null, value = null;
		FileInputStream file = new FileInputStream("./test-data/PixelData.xlsx");
		dataMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=3;i<headers.getLastCellNum();i++){
						try{
							try {
								value = record.getCell(i).toString().trim();
								key = headers.getCell(i).toString().trim();
							} catch (Exception e) {
								value = record.getCell(i).getStringCellValue();
								key = headers.getCell(i).toString().trim();
							}
						}catch(Exception e){
							continue;
						}
					dataMap.put(key, value);
				}

				break;
			}
		}
		wb.close();
		file.close();
		return dataMap;
	}
	
	public void writePixelData(String sheetName, String uniqueValue, String pageName, String columnName, String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		sheetName = width+"X"+height;
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(columnName)){
							Cell cell = null;
							try{
								cell = record.getCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}catch(Exception e){
								cell = record.createCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}

							break;
						}
					}catch(Exception e){}
				}
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public void writeElementImageToData(String uniqueValue,String pageName,String columnName,File image, int width, int height) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Images");
		Iterator<Row> it = sheet.rowIterator();
		InputStream inputStream = new FileInputStream(image);
		//Get the contents of an InputStream as a byte[].

		byte[] bytes = IOUtils.toByteArray(inputStream);
		//Adds a picture to the workbook
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		//close the input stream

		inputStream.close();
		//Returns an object that handles instantiating concrete classes
		CreationHelper helper = wb.getCreationHelper();
		//Creates the top-level drawing patriarch.
		Drawing drawing = sheet.createDrawingPatriarch();

		//Create an anchor that is attached to the worksheet
		ClientAnchor anchor = helper.createClientAnchor();
//		anchor.setAnchorType(ClientAnchor.DONT_MOVE_AND_RESIZE);

		Row headers = it.next();
		int c=0;
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(columnName)){
							if(sheet.getColumnWidth(i)<=width)
								sheet.setColumnWidth(i, width);
							record.setHeight((short)(height*20));
							anchor.setCol1(i);
							anchor.setRow1(c+1);
							break;
						}
					}catch(Exception e){}
				}
				break;
			}
			c++;
		}

		//Creates a picture
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize();
		//Reset the image to the original size

		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public void writeExpectedPixelData(String uniqueValue, String pageName, String columnName, String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		String sheetName = width+"X"+height;
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(columnName)){
							Cell cell = null;
							try{
								cell = record.getCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}catch(Exception e){
								cell = record.createCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}

							break;
						}
					}catch(Exception e){}
				}
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public void updatePixelResults(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			Cell cell;
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			for(int i=3;i<headers.getLastCellNum();i++){
				try{
					if (headers.getCell(i).toString().trim().startsWith("z_")){
						String z_result = record.getCell(i).toString();
						String a_result = record.getCell(i+1).toString();
						boolean flag = z_result.equals(a_result);
						try{
							cell = record.getCell(i+2);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if(flag){
								cell.setCellValue("True");
							}else{
								cell.setCellValue("False");
							}
						}catch(Exception e){
							cell = record.createCell(i+2);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if(flag){
								cell.setCellValue("True");
							}else{
								cell.setCellValue("False");
							}
						}
					}
				}catch(Exception e){}
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
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
		Reporter.log("Refresing Page", true);
	}

}
