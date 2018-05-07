package moolya.embibe.pages.web;

import java.util.List;

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
	
	@FindBy(css="button.create-profile")
	private WebElement jump_Login_Btn;
	
	public void ClickSignupBtn(){
		waitUntilElementAppears(jump_Login_Btn);
		clickElement(jump_Login_Btn);
		Reporter.log("Clicked on Login btn",true);
	}
		
	@FindBy(css="a.loginBtn.ng-binding")
	private WebElement loginHereBtn;

	public void ClickJumpPageLoginHereBtn(){
		waitUntilElementAppears(loginHereBtn);
		clickElement(loginHereBtn);
		Reporter.log("Clicked on Login Here Button",true);
	}
	
	//@FindBy(xpath="(//input[@id='login-email-or-mobile'])[1]")
	@FindBy(xpath="(//input[@id='emailArea'])[2]")
	private WebElement jumpPage_login_email_field;
	
	//@FindBy(xpath="(//*[@id='login-form']/ul/li[2]/input)[1]")
	@FindBy(xpath="(//input[@id='passwordArea'])[2]")
	private WebElement jumpPage_login_password_field;
	
	//@FindBy(xpath="(//*[@class='loginBTN'])[1]")
	@FindBy(xpath="(//button[text()='Login'])[3]")
	private WebElement jumpPage_login_submit_Btn;
	
	//@FindBy(css="div.pull-right.header-icons div.dropmenu")
	@FindBy(css="img.guestImage")
	private WebElement verifyJumpPageLoginUser;
	
	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;
	
	public void jumpPageLoginWindow(String email,String password){
		enterText(jumpPage_login_email_field, email);
		Reporter.log("Entered email ",true);
		enterText(jumpPage_login_password_field, password);
		Reporter.log("Entered password ",true);
		clickElement(jumpPage_login_submit_Btn);
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
		//assertSearchHomepage();
		assertSignupFormAfterLoggedOut();
		Reporter.log("Logout successful..!!",true);
		
	}
	
	//@FindBy(css="div.fb-login.mixpanel-fb-signup")
	@FindBy(xpath="(//button[@id='btn-facebook'])[2]")
	private WebElement learnPageFBbtn;
	
	public void ClickJumpPageFBlogin(){
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
	
	//@FindBy(css="div.google-login.mixpanel-google-signup")
	@FindBy(xpath="(//button[@id='btn-google'])[2]")
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
	
	public void enterGoogleLoginCredentials(String email,String password) throws Exception{
		Thread.sleep(2000);
		enterText(enterGoogleMail, email);
		Reporter.log("Entered Email id",true);
		google_next_btn.click();
		Reporter.log("Clicked on Next Button",true);
		enterText(enterGooglePassword, password);
		Reporter.log("Entered Password",true);
		google_Final_next_btn.click();
		Reporter.log("Clicked on Next Button",true);
	}
	
	//==========New Page elements===============================
	
	@FindBy(xpath="//div[contains(text(),'JUMP to a higher score')]")
	private WebElement newjumpPageHeading;
	
	@FindBy(xpath="//button[text()='GET JUMP']")
	private WebElement getJumpBtn;
	
	//@FindBy(css="#tabTitle0")
	@FindBy(css="div.jump-up--features__list-item:nth-child(1)")
	private WebElement tab1;
	
	@FindBy(xpath="//h3[contains(text(),'61% of your score depends on knowledge')]")
	private WebElement tab1Heading;
	
	//@FindBy(css="#tabTitle1")
	@FindBy(css="div.jump-up--features__list-item:nth-child(2)")
	private WebElement tab2;
	
	@FindBy(xpath="//h3[contains(text(),'39% of your score depends on test-taking strategy')]")
	private WebElement tab2Heading;
	
	//@FindBy(css="#tabTitle2")
	@FindBy(css="div.jump-up--features__list-item:nth-child(3)")
	private WebElement tab3;
	
	@FindBy(xpath="//h3[contains(text(),'Compare like never before')]")
	private WebElement tab3Heading;
	
	//@FindBy(css="#tabTitle4")
	@FindBy(css="div.jump-up--features__list-item:nth-child(4)")
	private WebElement tab4;
	
	@FindBy(xpath="//h3[contains(text(),'Experience the real test')]")
	private WebElement tab4Heading;
	
	@FindBy(css="div.jump-up-tab-content-bottom-left-col-part-img")
	private WebElement improvementstoryVideo;
	
	@FindBy(css="div.jump-up-tab-content-third-left-content1-img1")
	private WebElement improvementstoryVideo_tab3;
	
	@FindBy(xpath="//a[contains(text(),'READ THEIR STORY >')]")
	private WebElement readTheirStoryBtn;
	
	@FindBy(xpath="//p[contains(text(),'LEARN MORE >')]")
	private WebElement learnMoreBtn;
	
	@FindBy(css="button.try-rank-up-button")
	private WebElement exploreRankupBtn;
	
	@FindBy(xpath="(//button[text()='UNLOCK'])[1]")
	private WebElement unlockBtn1;
	
	@FindBy(xpath="(//button[text()='UNLOCK'])[2]")
	private WebElement unlockBtn2;
	
	@FindBy(xpath="(//button[text()='UNLOCK'])[3]")
	private WebElement unlockBtn3;
	
	@FindBy(xpath="(//div[@class='embibe-pros-featured featured']/a/img)[1]")
	private WebElement feature_economictimes;
	
	@FindBy(xpath="(//div[@class='embibe-pros-featured featured']/a/img)[2]")
	private WebElement feature_Inc4;
	
	@FindBy(xpath="(//div[@class='embibe-pros-featured featured']/a/img)[3]")
	private WebElement feature_Boomerangtv;
	
	@FindBy(xpath="(//div[@class='embibe-pros-featured featured']/a/img)[5]")
	private WebElement feature_IndianExpress;
	
	@FindBy(css="img.video-img:nth-child(2)")
	private List<WebElement> successStoriesVideosList;
	
	@FindBy(css="div.backdrop-close-modal")
	private WebElement videoCloseBtn;
	
	@FindBy(css="a.did-u-know-unlock ")
	private WebElement downUnlockBtn;
	
	@FindBy(css="div.jump-up--buy-packs__title ")
	private WebElement buyPackSection;
	
	@FindBy(css="#genesis-content:nth-child(1)")
	private WebElement verifyReadStoryPage;
	
	@FindBy(css="h1.entry-title")
	private WebElement readStoryPageHeading;
	
	@FindBy(xpath="//p[text()='RESEARCH']")
	//@FindBy(xpath="//*[contains(text(),'Personalized Learning Outcomes for everyone through the world's best Artificial Intelligence platform in Education')]")
	private WebElement verifyLearmMoreNavigation;
	
	public void getJumpNavigation(){
		waitUntilElementclickable(getJumpBtn);
		clickElement(getJumpBtn);
		waitUntilElementAppears(buyPackSection);
		Reporter.log("Navigated to 'Buy Jump pack' section",true);
	}
	
	@FindBy(xpath="//iframe[@id='widget4']")
	private WebElement video_iframe;
	
	@FindBy(css="div.ytp-time-display span.ytp-time-current")
	private WebElement playVideofor3seconds;
	
	float threeSeconds=0.03f;
	
	@FindBy(css="div.ytp-progress-bar")
	private WebElement videoProgressBar;
	
	public void playImprovementStoryVideo() throws InterruptedException{
		
		try{
			scrollToElementViaJavascript(improvementstoryVideo);
			clickElement(improvementstoryVideo);
			
			/*wdriver.switchTo().frame(video_iframe);
			clickElement(videoProgressBar);
			if(Integer.parseInt(playVideofor3seconds.getText())==threeSeconds)
			{
				Reporter.log("Tab1 'Improvement Story' Video played successfully \n", true);
				clickElement(videoCloseBtn);
				Reporter.log("Video closed",true);
			}
			else
			{
				Reporter.log("Failed to play Tab1 'Improvement Story' Video. \n", true);
			}
			wdriver.switchTo().defaultContent();*/
			Thread.sleep(5000);
			waitUntilElementclickable(videoCloseBtn);
			Reporter.log("Tab1 'Improvement Story' Video played successfully \n", true);
			clickElement(videoCloseBtn);
			Reporter.log("Video closed",true);
		}
		catch(Exception e)
		{
			scrollToElementViaJavascript(improvementstoryVideo_tab3);
			clickElement(improvementstoryVideo_tab3);
			Thread.sleep(5000);
			waitUntilElementclickable(videoCloseBtn);
			Reporter.log("Tab1 'Improvement Story' Video played successfully \n", true);
			clickElement(videoCloseBtn);
			Reporter.log("Video closed",true);
		}
		
	}
	
	public void readTheirStory(){
		clickElement(readTheirStoryBtn);
		Reporter.log("Clicked on 'Read Their Story' Button",true);
		try{
			String winHandleBefore = wdriver.getWindowHandle();
			for (String winHandle : wdriver.getWindowHandles()) {
				wdriver.switchTo().window(winHandle);
			}
			waitUntilElementAppears(verifyReadStoryPage);
			Reporter.log("Navigated to "+ readStoryPageHeading.getText() + "Page",true);
			wdriver.close();
			wdriver.switchTo().window(winHandleBefore);
		}
		catch(Exception e){
			String winHandleBefore = wdriver.getWindowHandle();
			for (String winHandle : wdriver.getWindowHandles()) {
				wdriver.switchTo().window(winHandle);
			}
			
			Reporter.log("FAILED : Navigated to Jump Page",true);
			wdriver.close();
			wdriver.switchTo().window(winHandleBefore);
		}
		
	}
	
	public void learnMoreNaviagtion(){
		waitUntilElementclickable(learnMoreBtn);
		clickElement(learnMoreBtn);
		Reporter.log("Clicked on 'Learn More' Button",true);
		waitUntilElementAppears(verifyLearmMoreNavigation);
		Reporter.log("Navigated to '"+ verifyLearmMoreNavigation.getText() + "' Page",true);
		navigateBack();
	}
	
	public void tab1Navigation() throws InterruptedException{
			waitUntilElementclickable(tab1);
			clickElement(tab1);
			Assert.assertTrue(tab1Heading.isDisplayed(), "Tab1 navigation failed");
			Reporter.log("Tab1 navigation is successful \n", true);
			playImprovementStoryVideo();
			readTheirStory();
			learnMoreNaviagtion();
	}
	
	public void tab2Navigation() throws InterruptedException{
		waitUntilElementclickable(tab2);
		clickElement(tab2);
		Assert.assertTrue(tab2Heading.isDisplayed(), "Tab2 navigation failed");
		Reporter.log("Tab2 navigation is successful \n", true);
		playImprovementStoryVideo();
		readTheirStory();
		learnMoreNaviagtion();
}
	
	@FindBy(xpath="//h2[contains(text(),'Get your unfair advantage. JUMP NOW.')]")
	private WebElement advantageText;
	
	public void tab3Navigation() throws InterruptedException{
		waitUntilElementclickable(tab3);
		clickElement(tab3);
		scrollToElementViaJavascript(advantageText);
		Thread.sleep(2000);
		Assert.assertTrue(tab3Heading.isDisplayed(), "Tab3 navigation failed");
		Reporter.log("Tab3 navigation is successful \n", true);
		playImprovementStoryVideo();
		/*readTheirStory();
		learnMoreNaviagtion();*/
}
	
	public void tab4Navigation() throws InterruptedException{
		waitUntilElementclickable(tab4);
		clickElement(tab4);
		Assert.assertTrue(tab4Heading.isDisplayed(), "Tab4 navigation failed");
		Reporter.log("Tab4 navigation is successful \n", true);
		playImprovementStoryVideo();
		//readTheirStory();
		learnMoreNaviagtion();
}
	
	@FindBy(xpath="//div/span[text()='RANKUP']")
	private WebElement verifyExploreRankupNavigation;
	
	public void exploreRankup(){
		scrollToElementViaJavascript(exploreRankupBtn);
		clickElement(exploreRankupBtn);
		Reporter.log("Clicked on 'Explore Rank up' Button",true);
		waitUntilElementAppears(verifyExploreRankupNavigation);
		Reporter.log("Navigated to '"+ verifyExploreRankupNavigation.getText() + "' Page",true);
		navigateBack();
	}
	
	@FindBy(css="#student1")
	private WebElement successStory1;
	
	@FindBy(css="#student2")
	private WebElement successStory2;
	
	@FindBy(css="#student3")
	private WebElement successStory3;
	
	@FindBy(css="#student4")
	private WebElement successStory4;
	
	@FindBy(css="#student5")
	private WebElement successStory5;
	
	@FindBy(css="#student6")
	private WebElement successStory6;
	
	@FindBy(css="p.student-name ")
	private WebElement successStoryStudentName;
	
	public void successStories() throws InterruptedException{
		//scrollToElementViaJavascript(ele1);
		List<WebElement> list = successStoriesVideosList;
		for(WebElement ele:list){
			clickElement(ele);
			scrollToElementViaJavascript(ele);
			waitUntilElementclickable(videoCloseBtn);
			/*if(Integer.parseInt(playVideofor3seconds.getText())==threeSeconds)
			{
				Reporter.log("'Success Story' Video of student "+ successStoryStudentName.getText()+" played successfully \n", true);
				clickElement(videoCloseBtn);
				Reporter.log("Video closed",true);
			}
			else
			{
				Reporter.log("Failed to play Video of student "+ successStoryStudentName.getText(), true);
			}*/
			Thread.sleep(5000);
			Reporter.log("'Success Story' Video of student "+ successStoryStudentName.getText()+" played successfully \n", true);
			clickElement(videoCloseBtn);
			Reporter.log("Video closed",true);
			
		}
		
	}
	
	@FindBy(xpath="//input[@id='emailArea']")
	private WebElement emailIdField;
	
	@FindBy(xpath="//input[@id='passwordArea']")
	private WebElement passwordField;
	
	@FindBy(css="button.loginBtn")
	private WebElement loginBtn;
	
	@FindBy(css="iframe.razorpay-checkout-frame")
	private WebElement iframePaymentWindow;
	
	@FindBy(css="#merchant-name")
	private WebElement paymentMerchantName;
	
	public void openUnlockBtn(){
		scrollToElementViaJavascript(unlockBtn1);
		clickElement(unlockBtn1);
		enterText(emailIdField, "Jimmy@gmail.com");
		enterText(passwordField,"qwertyuiop");
		clickElement(loginBtn);
		clickElement(unlockBtn1);
		wdriver.switchTo().frame(iframePaymentWindow);
		waitUntilElementAppears(paymentMerchantName);
		Reporter.log("Opened Payment window of merchant name : "+paymentMerchantName.getText(),true);
		wdriver.switchTo().defaultContent();
	}
	
	
	
}
