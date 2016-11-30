package moolya.bookMyShow.pages.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EventsPage extends W_BasePage {

	public EventsPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(xpath="//button[text()='VENUES']")
	public WebElement venues_Btn;
	
	@FindBy(id="ajax-typeahead")
	public WebElement searchVenues_TB;
	
	 

}
