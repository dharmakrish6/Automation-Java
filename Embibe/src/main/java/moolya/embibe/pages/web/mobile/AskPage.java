package moolya.embibe.pages.web.mobile;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
	
	@FindBy(xpath="(//input[@id='login-email-or-mobile'])[2]")
	private WebElement ask_login_email_field;
	
	@FindBy(xpath="(//*[@id='login-form']/ul/li[2]/input)[2]")
	private WebElement ask_login_password_field;
	
	@FindBy(xpath="(//*[@class='loginBTN'])[3]")
	private WebElement ask_login_submit_Btn;
	
	public void guestAskQuestion(String question) throws InterruptedException{
		JavascriptExecutor jse = (JavascriptExecutor) wdriver;
		jse.executeScript("scroll(250, 0)");
		enterText(askORsearchField, question);
		jse.executeScript("scroll(250, 0)");
		clickElement(searchButton);
		jse.executeScript("scroll(250, 0)");
		Thread.sleep(5000);		
		WebElement frame = wdriver.findElement(By.xpath("//iframe[@id='ui-tinymce-0_ifr']"));
		wdriver.switchTo().frame(frame);
		System.out.println("inside frame");
		WebElement body = wdriver.findElement(By.tagName("body"));
		body.sendKeys("Text in Subject");
		System.out.println("entered text in subject field");
		wdriver.switchTo().defaultContent();
		//enterText(subjectField, question);
		scrollToElementViaJavascript(subjectField);
		Thread.sleep(5000);
		clickElement(askQuestionButton);
		System.out.println("Clicked on ask a question");
		waitUntilElementAppears(loginWndow);
		System.out.println("Login window has appeared");
	}
	
	public void askLoginWindow(String email,String password){
		enterText(ask_login_email_field, email);
		Reporter.log("Enter email : " +email,true);
		enterText(ask_login_password_field, password);
		Reporter.log("Enter password : " +password,true);
		clickElement(ask_login_submit_Btn);
		Reporter.log("Clicked on submit button",true);
	}
	
}
