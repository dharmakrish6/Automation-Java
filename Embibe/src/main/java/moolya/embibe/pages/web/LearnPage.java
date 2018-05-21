package moolya.embibe.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.testautomationguru.ocular.snapshot.Snap;


@Snap(value="LearnPage.png")
public class LearnPage extends W_BasePage {

	public LearnPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="div.desp-content")
	private WebElement desciption_Lbl;
	
	@FindBy(css="Woops")
	private WebElement woopsMessage;

	//	Social Strength Objects

	@FindBy(xpath="//div[text()='JEEMains']/preceding-sibling::div/span[@class='blue-circle']")
	private List<WebElement> jeeMainsBlue_List;

	@FindBy(xpath="//div[text()='Bitsat']/preceding-sibling::span[@class='blue-circle']")
	private List<WebElement> bitsatBlue_List;

	@FindBy(xpath="//div[text()='JEEAdvanced']/preceding-sibling::span[@class='blue-circle']")
	private List<WebElement> jeeAdvancedBlue_List;

	@FindBy(xpath="//*[text()='JEE MAINS']/../following-sibling::*/*")
	private WebElement jeeMainsPercentage;

	@FindBy(css="div.BehavioralMeterWrapper div.footText")
	private WebElement behavioralMeterStatus_Lbl;
	
	// Embibe Guide Objects
	
	@FindBy(css="div.embibe-guide + div.content>div.subHead")
	private WebElement embibeGuideHead_Lbl;
	
	@FindBy(css="div.embibe-guide + div.content>div.head")
	private WebElement embibeGuideText_Lbl;
	
	@FindBy(css="div.embibe-guide+div.content+div.embium")
	private WebElement embibeGuideEmbium_Lbl;
	
	
	@FindBy(css="div.concept>div.heading")
	private WebElement conceptsHeading_Lbl;

	@FindBy(css="div.concept li div.conceptItem")
	private List<WebElement> conceptName_List;

	@FindBy(css="div.concept li div.important")
	private List<WebElement> importantFor_List;

	@FindBy(css="div.concept-more")
	private WebElement seeMore_Link;
	
	@FindBy(css="div.cheatSheetWrap li.cheatItem")
	private List<WebElement> cheatSheetPoints_List;

	@FindBy(css="div.cheatSheetWrap div.cheatMore")
	private WebElement cheatSeeMore_Link;
	
	@FindBy(css="li.raqItem")
	private List<WebElement> recentlyAskedQuestions_List;

	@FindBy(css="div.askWrapper input.inputQuestion")
	private WebElement askQuestion_TB;

	@FindBy(css="div.askWrapper div.askButton")
	private WebElement askQuestion_Btn;
	
	@FindBy(css="div.wikiLinks li>div.index")
	private List<WebElement> contentIndex_List;
	
	@FindBy(css="div.wikiLinks li>div.indexElement>a")
	private List<WebElement> contentLinks_List;
	
	@FindBy(css="button.ytp-large-play-button")
	private WebElement importantVideoPlay_Btn;
	
	@FindBy(css="div.playlist div.videos-list li.video-list-item")
	private List<WebElement> importantVideos_List;
	
	@FindBy(css="div.playlist div.videos-list li.video-list-item div.videoDetail div.videoTitle")
	private List<WebElement> importantVideoTitle_List;
	
	@FindBy(css="div.playlist div.videos-list li.video-list-item div.videoDetail div.videoTime")
	private List<WebElement> importantVideoTime_List;
	
	@FindBy(css="div.DidYouKnowWrapper div.dykHead")
	private WebElement didYouKnowHead_Lbl;
	
	@FindBy(css="div.DidYouKnowWrapper div.dykContent")
	private WebElement didYouKnowContent_Lbl;
	
	@FindBy(css="div.DidYouKnowWrapper div.dykEmbiums")
	private WebElement didYouKnowEmbiums_Lbl;
	
	@FindBy(xpath="//button[text()='Login']")
	private WebElement learn_Login_Btn;
	
	public void ClickSignupBtn(){
		waitUntilElementAppears(learn_Login_Btn);
		clickElement(learn_Login_Btn);
		Reporter.log("Clicked on Login btn",true);
	}
		
	@FindBy(xpath="(//*[contains(text(),'  Login Here')])[1]")
	private WebElement loginHereBtn;

	public void ClickLearnPageLoginHereBtn(){
		waitUntilElementAppears(loginHereBtn);
		clickElement(loginHereBtn);
		Reporter.log("Clicked on Login Here Button",true);
	}
	
	@FindBy(xpath="(//input[@id='emailArea'])[2]")
	private WebElement learnPage_login_email_field;
	
	@FindBy(xpath="(//input[@id='passwordArea'])[2]")
	private WebElement learnPage_login_password_field;
	
	@FindBy(xpath="(//button[text()='Login'])[3]")
	private WebElement learnPage_login_submit_Btn;
	
	@FindBy(css="img.guestImage")
	private WebElement verifyLearnPageLoginUser;
	
	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;
	
	public void learnPageLoginWindow(String email,String password){
		enterText(learnPage_login_email_field, email);
		Reporter.log("Entered email ",true);
		enterText(learnPage_login_password_field, password);
		Reporter.log("Entered password ",true);
		clickElement(learnPage_login_submit_Btn);
		Reporter.log("Clicked on submit button",true);
		Assert.assertTrue(verifyLearnPageLoginUser.isDisplayed(), "Login Failed");
		Reporter.log("Login successful..!!",true);
	}
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement learnPage_logout_btn;
	
	@FindBy(css="div.Signin-Signup-form")
	private WebElement verifyLearnPageLogout;
	
	public void learnPageLogout() throws InterruptedException{
		waitUntilElementAppears(verifyLearnPageLoginUser);
		//mouseHoverOnElement(wdriver, verifyLearnPageLoginUser);
		clickElement(verifyLearnPageLoginUser);
		Reporter.log("Clicked on Profile icon ",true);
		clickElement(learnPage_logout_btn);
		Reporter.log("Clicked on logout button",true);
		Assert.assertTrue(verifyLearnPageLogout.isDisplayed(), "Logout Failed");
		Reporter.log("Logout successful..!!",true);
	}
	
	@FindBy(xpath="(//button[@id='btn-facebook'])[2]")
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
	
	@FindBy(xpath="(//button[@id='btn-google'])[2]")
	private WebElement google_loginBtn;
	
	public void ClickLearnPageGooglelogin(){
		waitUntilElementAppears(google_loginBtn);
		clickElement(google_loginBtn);
		Reporter.log("Clicked on Google login button",true);
	}
	
	@FindBy(xpath="//*[@id='headingText']")
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
	
	public boolean checkForWoopsPage(){
		try{
			waitUntilElementAppears(woopsMessage);
			return false;
		}catch(Exception e){
			return true;
		}
	}
		
}
