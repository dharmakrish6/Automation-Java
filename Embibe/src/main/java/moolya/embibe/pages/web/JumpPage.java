package moolya.embibe.pages.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class JumpPage extends W_BasePage {

	public JumpPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	//*[@class='header-link' AND contains(text(),'RankUp')]
	@FindBy(xpath="(//a[@href='/rankup'])[2]")
	private WebElement rankup_in_JumpPage;
	
	@FindBy(css = "p.jump-heading")
	private WebElement jumpPageHeading;
	
	@FindBy(xpath="//button[contains(text(),'APPLY TO RANKUP')]")
	private WebElement applyRankup;
	
	public void clickRankupInJumpPage(){
		waitUntilElementclickable(rankup_in_JumpPage);
		rankup_in_JumpPage.click();
		Reporter.log("Clicked on Rank Up", true);
		waitUntilElementAppears(applyRankup,30000);
		Assert.assertTrue(applyRankup.isDisplayed(), "Navigation failed to RankUp Page");
	}
	
	@FindBy(xpath="//a[@href='https://blog.embibe.com/']")
	private WebElement blog_in_JumpPage;
	
	public void clickBlogInJumpPage(){
		waitUntilElementclickable(blog_in_JumpPage);
		blog_in_JumpPage.click();
		Reporter.log("Clicked on Blog", true);
	}
	
}
