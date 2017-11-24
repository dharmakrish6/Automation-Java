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
	
	@FindBy(xpath="(//*[@class='login_signup'])[1]")
	private WebElement jump_Login_Btn;
	
	public void ClickSignupBtn(){
		waitUntilElementAppears(jump_Login_Btn);
		clickElement(jump_Login_Btn);
		Reporter.log("Clicked on Signup btn",true);
	}
		
	@FindBy(css="a.loginBtn.ng-binding")
	private WebElement loginHereBtn;

	public void ClickJumpPageLoginHereBtn(){
		waitUntilElementAppears(loginHereBtn);
		clickElement(loginHereBtn);
		Reporter.log("Clicked on Login Here Button",true);
	}
	
	@FindBy(xpath="(//input[@id='login-email-or-mobile'])[1]")
	private WebElement learnPage_login_email_field;
	
	@FindBy(xpath="(//*[@id='login-form']/ul/li[2]/input)[1]")
	private WebElement learnPage_login_password_field;
	
	@FindBy(xpath="(//*[@class='loginBTN'])[1]")
	private WebElement learnPage_login_submit_Btn;
	
	@FindBy(css="div.pull-right.header-icons div.dropmenu")
	private WebElement verifyJumpPageLoginUser;
	
	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;
	
	public void jumpPageLoginWindow(String email,String password){
		ClickJumpPageLoginHereBtn();
		enterText(learnPage_login_email_field, email);
		Reporter.log("Entered email ",true);
		enterText(learnPage_login_password_field, password);
		Reporter.log("Entered password ",true);
		clickElement(learnPage_login_submit_Btn);
		Reporter.log("Clicked on submit button",true);
		waitUntilElementclickable(verifyJumpPageLoginUser);
		Assert.assertTrue(verifyJumpPageLoginUser.isDisplayed(), "Login Failed");
		Reporter.log("Login successful..!!",true);
	}
	
	@FindBy(xpath="(//*[text()='Logout'])[1]")
	private WebElement jumpPage_logout_btn;
	
	@FindBy(css="div.Signin-Signup-form")
	private WebElement verifyLearnPageLogout;
	
	public void jumpPageLogout() throws InterruptedException{
		waitUntilElementAppears(verifyJumpPageLoginUser);
		clickElement(verifyJumpPageLoginUser);
		Reporter.log("Clicked on Profile icon ",true);
		clickElement(jumpPage_logout_btn);
		Reporter.log("Clicked on logout button",true);
		assertSearchHomepage();
		Reporter.log("Logout successful..!!",true);
		
	}
	
	@FindBy(css="div.fb-login.mixpanel-fb-signup")
	private WebElement learnPageFBbtn;
	
	public void ClickLearnPageFBlogin(){
		waitUntilElementAppears(learnPageFBbtn);
		clickElement(learnPageFBbtn);
		Reporter.log("Clicked on Facebook login button",true);
	}
	
	@FindBy(xpath="//input[@id='email']")
	private WebElement enterFbEmail;

	@FindBy(xpath="//input[@id='pass']")
	private WebElement enterFbPassword;

	@FindBy(xpath="//*[@id='loginbutton']")
	private WebElement fb_loginBtn;
	
	public void enterFbLoginCredentials(String email,String password){
		enterText(enterFbEmail, email);
		Reporter.log("Entered Email id",true);
		enterText(enterFbPassword,password);
		Reporter.log("Entered password",true);
		fb_loginBtn.click();
		Reporter.log("Clicked on facebook login button",true);
	}
	
	@FindBy(css="div.google-login.mixpanel-google-signup")
	private WebElement google_loginBtn;
	
	public void ClickLearnPageGooglelogin(){
		waitUntilElementAppears(google_loginBtn);
		clickElement(google_loginBtn);
		Reporter.log("Clicked on Google login button",true);
	}
	
	@FindBy(xpath="//*[@id='headingText']/following::button[contains(text(),'embibe.com')]")
	private WebElement assertGoogleSignInPage;

	@FindBy(xpath="//*[@id='identifierId']")
	private WebElement enterGoogleMail;

	@FindBy(xpath="//*[@id='identifierNext']")
	private WebElement google_next_btn;
	
	
	@FindBy(xpath="//*[@id='passwordNext']")
	private WebElement google_Final_next_btn;

	@FindBy(xpath="//*[@id='password']/div/div/div/input[@type='password']")
	private WebElement enterGooglePassword;
	
	public void enterGoogleLoginCredentials(String email,String password){
		enterText(enterGoogleMail, email);
		Reporter.log("Entered Email id",true);
		google_next_btn.click();
		Reporter.log("Clicked on Next Button",true);
		enterText(enterGooglePassword, password);
		Reporter.log("Entered Password",true);
		google_Final_next_btn.click();
		Reporter.log("Clicked on Next Button",true);
	}
	
	
}
