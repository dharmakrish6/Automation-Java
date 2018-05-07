package moolya.embibe.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class InstitutePage extends W_BasePage {

	public InstitutePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="button.institute-header-view-others-button")
	private WebElement contactusBtn1;
	
	@FindBy(css="button.institute-header-view-login-button")
	private WebElement loginBtn1;
	
	@FindBy(css="button.signup-button-btn ")
	private WebElement signupBtn1;
	
	@FindBy(css="span.requestDemo")
	private WebElement requestDemoBtn1;
	
	@FindBy(css="div.static-tab--features__list-item:nth-child(1)")
	private WebElement Inst_tab1;
	
	@FindBy(xpath="//div[contains(text(),'Offline Assessments')]")
	private WebElement verifyTab1;
	
	@FindBy(css="div.static-tab--features__list-item:nth-child(2)")
	private WebElement Inst_tab2;
	
	@FindBy(xpath="//div[contains(text(),'Schedule Live Tests')]")
	private WebElement verifyTab2;
	
	@FindBy(css="div.static-tab--features__list-item:nth-child(3)")
	private WebElement Inst_tab3;
	
	@FindBy(xpath="//div[contains(text(),'Meaningful Parent Collaboration')]")
	private WebElement verifyTab3;
	
	@FindBy(css="div.static-tab--features__list-item:nth-child(4)")
	private WebElement Inst_tab4;
	
	@FindBy(xpath="//div[contains(text(),'Multiple Format Compatibility')]")
	private WebElement verifyTab4;
	
	@FindBy(css="div.professors-banner div.professors-banner-image-view")
	private List<WebElement> professorsVideoLists;
	
	@FindBy(css="img.logo-image.logo-image-style1")
	private List<WebElement> professorsLogoLists;
	
	@FindBy(css="div.professors-play-button")
	private WebElement professorsVideoPlayBtn;
	
	@FindBy(css="img.video-modal-view-close-btn-image")
	private WebElement professorsVideoCloseBtn;
	
	@FindBy(xpath="//*[contains(text(),'What are you waiting for?')]")
	private WebElement whatAreYouWaitingForText;
	
	@FindBy(xpath="//button[contains(text(),'REQUEST A DEMO')]")
	private WebElement requestDemo2;
	
	@FindBy(css="img.modal-close")
	private WebElement closeRequestDemoWindow;
	
	@FindBy(xpath="//button[contains(text(),'SIGN UP NOW')]")
	private WebElement signupBtn2;
	
	@FindBy(css="div.contact-us-content")
	private WebElement contactUsContent;
	
	@FindBy(xpath="//input[@value='LOGIN']")
	private WebElement verifyInstLoginPage;
	
	public void contactus(){
		waitUntilElementclickable(contactusBtn1);
		clickElement(contactusBtn1);
		waitUntilElementAppears(contactUsContent);
		Reporter.log("Navigated to contact us content",true);
	}
	
	public void login(){
		waitUntilElementclickable(loginBtn1);
		clickElement(loginBtn1);
		waitUntilElementclickable(verifyInstLoginPage);
		Reporter.log("Navigated to Institute Login Page",true);
		navigateBack();
	}
	
	@FindBy(xpath="//div[contains(text(),'Sign Up Details')]")
	private WebElement verifyInstSignupPage;
	
	public void signupForFree(){
		waitUntilElementclickable(signupBtn1);
		clickElement(signupBtn1);
		waitUntilElementclickable(verifyInstSignupPage);
		Reporter.log("Navigated to Institute Signup Page",true);
		navigateBack();
	}
	
	@FindBy(css="p.required-demo-title")
	private WebElement verifyRequestDemoWindow;
	
	public void requestDemo1(){
		waitUntilElementclickable(requestDemoBtn1);
		clickElement(requestDemoBtn1);
		waitUntilElementclickable(verifyRequestDemoWindow);
		Reporter.log("Navigated to Request demo window",true);
		waitUntilElementclickable(closeRequestDemoWindow);
		clickElement(closeRequestDemoWindow);
		Reporter.log("Closed Request demo window",true);
	}
	
	public void tab1Navigation(){
		scrollToElementViaJavascript(Inst_tab1);
		clickElement(Inst_tab1);
		waitUntilElementclickable(verifyTab1);
		Reporter.log("Navigated to tab1",true);
	}
	
	public void tab2Navigation(){
		scrollToElementViaJavascript(Inst_tab2);
		clickElement(Inst_tab2);
		waitUntilElementclickable(verifyTab2);
		Reporter.log("Navigated to tab2",true);
	}
	
	public void tab3Navigation(){
		scrollToElementViaJavascript(Inst_tab3);
		clickElement(Inst_tab3);
		waitUntilElementclickable(verifyTab3);
		Reporter.log("Navigated to tab3",true);
	}
	
	public void tab4Navigation(){
		scrollToElementViaJavascript(Inst_tab4);
		clickElement(Inst_tab4);
		waitUntilElementclickable(verifyTab4);
		Reporter.log("Navigated to tab4",true);
	}
	
	@FindBy(css="p.professors-name-info")
	private WebElement professorName;
	
	String pn="";
	public void professorsIntroVideo() throws InterruptedException{
		for(WebElement ele:professorsLogoLists){
			clickElement(ele);
			clickElement(professorsVideoPlayBtn);
			pn=professorName.getText();
			Reporter.log("Clicked on Play button",true);
			Thread.sleep(5000);
			Reporter.log(pn+" : video played",true);
			clickElement(professorsVideoCloseBtn);
			Reporter.log("Video closed successfully",true);
		}
	}
	
	
	
}
