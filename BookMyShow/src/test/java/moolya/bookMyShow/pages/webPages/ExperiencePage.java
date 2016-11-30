package moolya.bookMyShow.pages.webPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExperiencePage extends W_BasePage {

	public ExperiencePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(xpath="//p[text()='Mid-Week Madness']")
	public WebElement midWeekMadness_Link;
	
	@FindBy(id="like-collection")
	public WebElement like_Btn;

}
