package moolya.bookMyShow.pages.webPages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends W_BasePage {

	public HomePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(id="inp_RegionSearch_top")
	public WebElement searchRegion_TB;
	
	@FindBy(id="preSignIn")
	public WebElement signIn_Btn;
	
	@FindBy(linkText="EVENTS")
	public WebElement events_Link;
	
	@FindBy(linkText="experiences")
	public WebElement experiences_Link;
	
	@FindBy(id="postSignIn")
	public WebElement profile_Link;
	
	@FindBy(id="btn-dd-search")
	public WebElement search_DD;
	
	@FindBy(xpath="//a[@data-search-placeholder='Search for a Movie or Cinema']")
	public WebElement movies_Option;
	
	@FindBy(id="wzrk-cancel")
	public WebElement notNow_Btn;
	
	
	public HomePage selectCity(){
		waitUntilElementAppears(searchRegion_TB);
		searchRegion_TB.sendKeys("Bengaluru");
		searchRegion_TB.sendKeys(Keys.ENTER);
		return this;
	}
	
	public LoginPage goToLoginPage(){
		try{
			notNow_Btn.click();
		}catch(Exception e){}
		waitUntilElementclickable(signIn_Btn);
		signIn_Btn.click();
		return new LoginPage(wdriver);
	}
	
	public EventsPage goToEventsPage(){
		try{
			notNow_Btn.click();
		}catch(Exception e){}
		waitUntilElementclickable(events_Link);
		events_Link.click();
		return new EventsPage(wdriver);
	}
	
	public ExperiencePage goToExperiencePage(){
		try{
			notNow_Btn.click();
		}catch(Exception e){}
		waitUntilElementclickable(experiences_Link);
		experiences_Link.click();
		return new ExperiencePage(wdriver);
	}
	
	public ProfilePage goToProfilePage(){
		try{
			notNow_Btn.click();
		}catch(Exception e){}
		waitUntilElementclickable(profile_Link);
		profile_Link.click();
		return new ProfilePage(wdriver);
	}
	
	public MoviesPage goToMoviesPage() throws InterruptedException{
		try{
			notNow_Btn.click();
		}catch(Exception e){}
		waitUntilElementclickable(search_DD);
		mouseHoverOnElement(wdriver, search_DD);
		movies_Option.click();
		return new MoviesPage(wdriver);
	}

}
