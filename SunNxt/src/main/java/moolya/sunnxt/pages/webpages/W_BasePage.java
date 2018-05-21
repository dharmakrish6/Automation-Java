package moolya.sunnxt.pages.webpages;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import moolya.sunnxt.utils.JavaUtils;

public class W_BasePage extends W_SuperBasePage 
{
	String windowHandle = "";
	public W_BasePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "(//button[@class='btn dropdown-toggle btn-default'and @title='Tamil'])[1]") 
	protected WebElement language_dropdown;
	
	@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[1]") 
	protected WebElement Search;
	
	@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[2]") 
	protected WebElement My_profile;
	
	@FindBy(xpath = "//span[@class='icon-icn_switch-profile']") 
	protected WebElement switch_profile;
	
	@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[3]") 
	protected WebElement Notification;
	
	@FindBy(xpath = "(//div[@class='col-md-6 col-sm-6 top_rgt_link']/ul)[1]/li[4]") 
	protected WebElement Settings;
	
	
	@FindBy(xpath = "(//img[@src='/images/logo.png'])[1]") 
	protected WebElement Sunxt_logo;
	
	@FindBy(xpath = "(//a[text()='movies'])[1]")
	protected WebElement MOVIES;
	
	@FindBy(linkText = "tv shows")
	protected WebElement TV_SHOWS;
	
	@FindBy(linkText = "live tv")
	protected WebElement LIVE_TV;
	
	@FindBy(linkText = "comedy")
	protected WebElement COMEDY;
	
	@FindBy(linkText = "exclusives")
	protected WebElement EXCLUSIVES;
	
	public HomePage select_language(String Language){
		
		WebDriverWait wait = new WebDriverWait(wdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(language_dropdown));
		
		language_dropdown.click();
		List<WebElement> Dropdown_list = wdriver.findElements(By.xpath("(//div[@class='dropdown-menu open']/ul)[1]/li"));
		Iterator<WebElement> iter = Dropdown_list.iterator();

		while(iter.hasNext()) {
		    WebElement we = iter.next();
            if (we.getText().equals(Language)) {
		        we.click();
		    }
		}
		
		return new HomePage(wdriver);
		
		
		
	}
	
	public void do_search(String Search_String){
		WebDriverWait wait = new WebDriverWait(wdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(Search));
		Search.click();
		WebElement Search_box = wdriver.findElement(By.id("mainSearch"));
		Search_box.sendKeys(Search_String);
		//WebElement Search_btn = driver.findElement(By.xpath("(//button[@class='btn-nobg search-btn'])[1]"));
		//Search_btn.click();
		WebElement Search_suggestion = wdriver.findElement(By.xpath("(//a[text()='"+Search_String+"'])[2]"));
		Search_suggestion.click();
		
	}
	
	public MyProfilePage click_MyProfile(){
		waitUntilElementclickable(My_profile);
		My_profile.click();
		return new MyProfilePage(wdriver);
	}
	
	public MoviesPage click_Movies(){
		WebDriverWait wait = new WebDriverWait(wdriver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(MOVIES));
		MOVIES.click();
		return new MoviesPage(wdriver);
	}
	
	
	public void switch_profile(){
		switch_profile.click();
		
	}
	public void add_profile(String username,String password){
		WebElement add_profile_btn = wdriver.findElement(By.xpath("//div[@class='add-icon']"));
		add_profile_btn.click();
		WebDriverWait wait = new WebDriverWait(wdriver, 10);
		WebElement Username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='username'])[1]")));
		Username.sendKeys(username);
		WebElement Password = wdriver.findElement(By.xpath("(//input[@name='password'])[1]"));
		Password.sendKeys(password);
		WebElement Add_btn = wdriver.findElement(By.xpath("(//button[@type='submit'and@class='btn btn-red'])[1]"));
		Add_btn.click();
		
		
	}

}


