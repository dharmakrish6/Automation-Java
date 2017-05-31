package sunxt.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
		public WebDriver driver;


		public BasePage(WebDriver driverWeb)
		{
			this.driver= driverWeb;
		}
		
		@FindBy(xpath = "(//div[@class='btn-group bootstrap-select'])[1]") 
		protected WebElement language_dropdown;
		
		@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[1]") 
		protected WebElement Search;
		
		@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[2]") 
		protected WebElement My_profile;
		
		@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[3]") 
		protected WebElement Notification;
		
		@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[4]") 
		protected WebElement Settings;
		
		
		@FindBy(xpath = "(//img[@src='/images/logo.png'])[1]") 
		protected WebElement Sunxt_logo;
		
		@FindBy(linkText = "movies")
		protected WebElement MOVIES;
		
		@FindBy(linkText = "tv shows")
		protected WebElement TV_SHOWS;
		
		@FindBy(linkText = "live tv")
		protected WebElement LIVE_TV;
		
		@FindBy(linkText = "comedy")
		protected WebElement COMEDY;
		
		@FindBy(linkText = "exclusives")
		protected WebElement EXCLUSIVES;
		
		public void select_language(String Language){
			
			language_dropdown.click();
			
			
		}
		
		public void do_search(String Search_String){
			Search.click();
			WebElement Search_box = driver.findElement(By.id("mainSearch"));
			Search_box.sendKeys(Search_String);
			WebElement Search_btn = driver.findElement(By.xpath("(//button[@class='btn-nobg search-btn'])[1]"));
			Search_btn.click();
			
		}
		
		public MyProfilePage click_MyProfile(){
			My_profile.click();
			return new MyProfilePage(driver);
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
		
		public void selectDropdown(WebElement element,String text){
			Select s = new Select(element);
			s.selectByVisibleText(text);
		}
}
	

