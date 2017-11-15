package moolya.embibe.pages.web;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class AskPage extends W_BasePage {

	public AskPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[text()='Ask']")
	private WebElement askOption;
	
	@FindBy(css="input.ask-input:nth-child(1)")
	private WebElement askORsearchField;
	
	@FindBy(xpath="(//input[@type='submit']/following::i[1])[1]")
	private WebElement searchButton;
	
	@FindBy(css="iframe#ui-tinymce-0_ifr")
	private WebElement subjectField;
	
	@FindBy(css="div.ask-question_button")
	private WebElement askQuestionButton;
	
	@FindBy(xpath="(//*[contains(text(),'login here')])[1]")
	private WebElement loginWndow;
	
	@FindBy(xpath="(//*[contains(text(),'login here')])[1]")
	private WebElement ask_login_here_btn;
	
	@FindBy(xpath="(//input[@id='login-email-or-mobile'])[2]")
	private WebElement ask_login_email_field;
	
	@FindBy(xpath="(//*[@id='login-form']/ul/li[2]/input)[2]")
	private WebElement ask_login_password_field;
	
	@FindBy(xpath="(//*[@class='loginBTN'])[3]")
	private WebElement ask_login_submit_Btn;
	
	@FindBy(xpath="//li[@id='global_nav_right-profilename']")
	private WebElement verifyAskPageLogin;
	
	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;
	
	public void guestAskQuestion(String question) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor) wdriver;
		jse.executeScript("scroll(250, 0)");
		enterText(askORsearchField, question);
		Reporter.log("Entered '"+ question +"'",true);
		jse.executeScript("scroll(250, 0)");
		clickElement(searchButton);
		Reporter.log("Clicked on search button",true);
		jse.executeScript("scroll(250, 0)");
		Thread.sleep(5000);		
		WebElement frame = wdriver.findElement(By.xpath("//iframe[@id='ui-tinymce-0_ifr']"));
		wdriver.switchTo().frame(frame);
		//System.out.println("inside frame");
		WebElement body = wdriver.findElement(By.tagName("body"));
		body.sendKeys("Text in Subject");
		Reporter.log("Entered text in subject field",true);
		wdriver.switchTo().defaultContent();
		scrollToElementViaJavascript(subjectField);
		Thread.sleep(5000);
		clickElement(askQuestionButton);
		Reporter.log("Clicked on ask button",true);
	}
	
	public void askLogin(){
		waitUntilElementAppears(loginWndow);
		Reporter.log("Login window has appeared",true);
		askLoginWindow("yatheendra@moolya.com", "moolya123");
	}
	
	public void verifyAskSuccessful(){
		waitUntilElementAppears(Ask_Question_successfullMessage);
		Reporter.log("Question asked successfully",true);
	}
	public void askLoginWindow(String email,String password){
		clickElement(ask_login_here_btn);
		Reporter.log("Clicked on 'Login Here' Button",true);
		enterText(ask_login_email_field, email);
		Reporter.log("Entered email ",true);
		enterText(ask_login_password_field, password);
		Reporter.log("Entered password ",true);
		clickElement(ask_login_submit_Btn);
		Reporter.log("Clicked on submit button",true);
		Assert.assertTrue(verifyAskPageLogin.isDisplayed(), "Login Failed");
		Reporter.log("Login successful..!!",true);
	}
	
	@FindBy(xpath="//*[@id='global_nav_right-logout']/span")
	private WebElement ask_logout_btn;
	
	@FindBy(css="div.Signin-Signup-form")
	private WebElement verifyAskLogout;
	
	public void askLogout() throws InterruptedException{
		waitUntilElementAppears(verifyAskPageLogin);
		mouseHoverOnElement(wdriver, verifyAskPageLogin);
		Reporter.log("Clicked on Profile icon ",true);
		clickElement(ask_logout_btn);
		Reporter.log("Clicked on logout button",true);
		Assert.assertTrue(verifyAskLogout.isDisplayed(), "Logout Failed");
		Reporter.log("Logout successful..!!",true);
		
	}
	
	@FindBy(css="div.ask_user_popup_message")
	private WebElement Ask_Question_successfullMessage;
	
	
}
