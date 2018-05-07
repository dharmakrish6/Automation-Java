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
	
	@FindBy(xpath="(//*[contains(text(),'Access from anywhere!')])[1]")
	private WebElement loginWndow_1;
	
	//@FindBy(xpath="//*[contains(text(),'Welcome to your embibe')]")
	@FindBy(css="#emailArea")
	private WebElement loginWndow_2;
	
	@FindBy(xpath="//strong[contains(text(),'login here')]")
	private WebElement askQues_login_here_btn;
	
	@FindBy(xpath="//a[contains(text(),'Login Here')]")
	private WebElement askSignup_login_here_btn;
	
	@FindBy(xpath="(//*[@id='login-email-or-mobile'])[2]")
	private WebElement askQues_login_email_field;
	
	//@FindBy(xpath="(//input[@id='login-email-or-mobile'])[1]")
	@FindBy(css="#emailArea")
	private WebElement askSignUp_login_email_field;
	
	//@FindBy(xpath="(//*[@id='login-form']/ul/li[2]/input)[2]")
	@FindBy(css="#passwordArea")
	private WebElement askQues_login_password_field;
	
	@FindBy(xpath="//input[@class='login-password']")
	private WebElement askSignUp_login_password_field;
	
	@FindBy(xpath="(//*[@class='loginBTN'])[3]")
	private WebElement askQues_login_submit_Btn;
	
	//@FindBy(xpath="(//input[@class='loginBTN'])[1]")
	@FindBy(css="a.login-logout-button")
	private WebElement askSignUp_login_submit_Btn;
	
	
	
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
		body.sendKeys("The variation of acceleration due to gravity g with distance d from centre of the earth is best represented by (R=Earth’s radius) :");
		Reporter.log("Entered text in subject field",true);
		wdriver.switchTo().defaultContent();
		scrollToElementViaJavascript(subjectField);
		Thread.sleep(5000);
		clickElement(askQuestionButton);
		Reporter.log("Clicked on ask button",true);
	}
	
	public void askLogin_viaQues() throws InterruptedException{
			waitUntilElementAppears(loginWndow_1);
			Reporter.log("Login window has appeared",true);
			clickElement(askQues_login_here_btn);
			Reporter.log("Clicked on 'Login Here' Button",true);
			askLoginWindow_via_askQues("rahuljain_2000@gmail.com", "rahuljain");
	}
	
	public void askLogin_viaSignUp() throws InterruptedException{
		waitUntilElementAppears(loginWndow_2);
		Reporter.log("Login window has appeared",true);
		clickElement(askSignup_login_here_btn);
		Reporter.log("Clicked on 'Login Here' Button",true);
		askLoginWindow_via_signup("rahuljain_2000@gmail.com", "rahuljain");
}
	
	public void verifyAskSuccessful() throws InterruptedException{
		Thread.sleep(3000);
		waitUntilElementAppears(Ask_Question_successfullMessage);
		Reporter.log("Question asked successfully",true);
	}
	public void askLoginWindow_via_askQues(String email,String password) throws InterruptedException{
		Thread.sleep(1000);
		enterText(askQues_login_email_field, email);
		Reporter.log("Entered email ",true);
		enterText(askQues_login_password_field, password);
		Reporter.log("Entered password ",true);
		clickElement(askQues_login_submit_Btn);
		Reporter.log("Clicked on submit button",true);
		Assert.assertTrue(verifyAskPageLogin.isDisplayed(), "Login Failed");
		Reporter.log("Login successful..!!",true);
	}
	
	public void askLoginWindow_via_signup(String email,String password){
		enterText(askSignUp_login_email_field, email);
		Reporter.log("Entered email ",true);
		enterText(askSignUp_login_password_field, password);
		Reporter.log("Entered password ",true);
		clickElement(askSignUp_login_submit_Btn);
		Reporter.log("Clicked on submit button",true);
		Assert.assertTrue(verifyAskPageLogin.isDisplayed(), "Login Failed");
		Reporter.log("Login successful..!!",true);
	}
	
	
	
	@FindBy(css="div.Signin-Signup-form")
	private WebElement verifyAskLogout;
	
	public void askLogout_delete() throws InterruptedException{
		waitUntilElementAppears(verifyAskPageLogin);
		mouseHoverOnElement(wdriver, verifyAskPageLogin);
		Reporter.log("Clicked on Profile icon ",true);
		clickElement(ask_logout_btn);
		Reporter.log("Clicked on logout button",true);
		//Assert.assertTrue(verifyAskLogout.isDisplayed(), "Logout Failed");
		Reporter.log("Logout successful..!!",true);
		
	}
	
	@FindBy(css="div.ask_user_popup_message")
	private WebElement Ask_Question_successfullMessage;
	
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
	
	//@FindBy(css="div.fb-login.mixpanel-fb-signup")
	@FindBy(xpath="(//button[@id='btn-facebook'])")
	private WebElement askPageFBbtn;
	
	public void ClickAskPageFBlogin(){
		waitUntilElementAppears(askPageFBbtn);
		clickElement(askPageFBbtn);
		Reporter.log("Clicked on Fb login button",true);
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
	
	//@FindBy(css="div.google-login.mixpanel-google-signup")
	@FindBy(xpath="(//button[@id='btn-google'])")
	private WebElement google_loginBtn;
	
	public void ClickaskPageGooglelogin(){
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

	//=====================================New Elements=================================================
	//@FindBy(xpath="(//a[contains(text(),'Sign Up')])[1]")
	//@FindBy(xpath="(//*[@id='guest-signup'])[2]")
	//@FindBy(xpath="(//*[contains(text(),'Sign Up')])[2]")
	@FindBy(css="a.create-profile")
	private WebElement guestLoginBtn;
	
	public void clickAskPageLoginBtn(){
		waitUntilElementAppears(guestLoginBtn);
		clickElement(guestLoginBtn);
	}
	
	@FindBy(xpath="//input[@id='emailArea']")
	private WebElement L_emailId_signupform;
	
	@FindBy(xpath="//input[@id='passwordArea']")
	private WebElement L_password_signupform;
	
	@FindBy(css="a.login-logout-button")
	private WebElement signInBtn;
	
	public void Login_in_signupForm(){
		enterText(L_emailId_signupform, "rahuljain_2000@gmail.com");
		Reporter.log("Entered Email id",true);
		enterText(L_password_signupform, "rahuljain");
		Reporter.log("Entered Password",true);
		clickElement(signInBtn);
		Reporter.log("Clicked on Login Button",true);
	}
	
	    //@FindBy(xpath="//li[@id='global_nav_right-profilename']")
		@FindBy(css="button.dropdown-toggle.user_button")
		private WebElement verifyAskPageLogin;
		
		//@FindBy(xpath="//*[@id='global_nav_right-logout']/span")
		@FindBy(xpath="(//a[text()='Logout'])[1]")
		private WebElement ask_logout_btn;
		
		public void askPageLogout() throws InterruptedException{
			Thread.sleep(5000);
			waitUntilElementclickable(verifyAskPageLogin);
			//mouseHoverOnElement(wdriver, verifyAskPageLogin);
			clickElement(verifyAskPageLogin);
			Reporter.log("Clicked on Profile icon ",true);
			clickElement(ask_logout_btn);
			Reporter.log("Clicked on logout button",true);
			//Assert.assertTrue(verifyAskLogout.isDisplayed(), "Logout Failed");
			Reporter.log("Logout successful..!!",true);
			
		}
	
}
