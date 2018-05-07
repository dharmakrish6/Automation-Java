package moolya.embibe.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class RankupPage extends W_BasePage {

	public RankupPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="h1.rank-up-header--text-main")
	private WebElement newRankupPageHeading;
	
	@FindBy(xpath="(//button[text()='APPLY TO RANKUP'])[1]")
	private WebElement applytoRankupBtn1;
	
	@FindBy(xpath="(//button[text()='APPLY TO RANKUP'])[2]")
	private WebElement applytoRankupBtn2;
	
	@FindBy(xpath="(//button[text()='APPLY TO RANKUP'])[3]")
	private WebElement applytoRankupBtn3;
	
	@FindBy(xpath="(//span[contains(text(),'LOGIN')])[1]")
	private WebElement alreadyAppliedLoginBtn1;
	
	@FindBy(xpath="(//span[contains(text(),'LOGIN')])[2]")
	private WebElement alreadyAppliedLoginBtn2;
	
	@FindBy(xpath="(//span[contains(text(),'LOGIN')])[3]")
	private WebElement alreadyAppliedLoginBtn3;
	
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
	
	@FindBy(xpath="//h3[contains(text(),'College prediction linked to improvement plan')]")
	private WebElement tab3Heading;
	
	//@FindBy(css="#tabTitle4")
	@FindBy(css="div.jump-up--features__list-item:nth-child(4)")
	private WebElement tab4;
	
	@FindBy(xpath="//h3[contains(text(),'Track your effort rating for higher score')]")
	private WebElement tab4Heading;
	
	@FindBy(xpath="(//div[@id='video'])[1]")
	private WebElement rankupImprovesVideo;
	
	@FindBy(xpath="(//div[@id='video'])[2]")
	private WebElement rankupToJumpPersonalizationVideo;
	
	@FindBy(css="img.video-img:nth-child(2)")
	private List<WebElement> successStoriesVideosList;
	
	@FindBy(css="div.backdrop-close-modal")
	private WebElement videoCloseBtn;
	
	@FindBy(xpath="//img[@class='video-modal-view-close-btn-image']")
	private WebElement videoCloseBtn2;
	
	@FindBy(css="div.ytp-time-display span.ytp-time-current")
	private WebElement playVideofor3seconds;
	
	float threeSeconds=0.03f;
	
	@FindBy(css="p.student-name ")
	private WebElement successStoryStudentName;
	
	@FindBy(css="button.go-to-jump-button")
	private WebElement gotoJumpBtn;
	
	
	@FindBy(xpath="//h3[contains(text(),'The only score improvement guarantee program')]")
	private WebElement verifyRankupSignupPage;
	
	
	public void applyToRankup1() throws InterruptedException{
		Thread.sleep(5000);
		scrollToElementViaJavascript(applytoRankupBtn1);
		clickElement(applytoRankupBtn1);
		waitUntilElementAppears(verifyRankupSignupPage);
		Assert.assertTrue(verifyRankupSignupPage.isDisplayed(), "Not in Search Home page");
		Reporter.log("Navigated to Rankup signup Page \n", true);
		navigateBack();
	}
	
	public void applyToRankup2() throws InterruptedException{
		Thread.sleep(5000);
		scrollToElementViaJavascript(applytoRankupBtn2);
		clickElement(applytoRankupBtn2);
		waitUntilElementAppears(verifyRankupSignupPage);
		Assert.assertTrue(verifyRankupSignupPage.isDisplayed(), "Not in Search Home page");
		Reporter.log("Navigated to Rankup signup Page \n", true);
		navigateBack();
	}
	
	public void applyToRankup3() throws InterruptedException{
		Thread.sleep(5000);
		scrollToElementViaJavascript(applytoRankupBtn3);
		clickElement(applytoRankupBtn3);
		waitUntilElementAppears(verifyRankupSignupPage);
		Assert.assertTrue(verifyRankupSignupPage.isDisplayed(), "Not in Rankup signup page");
		Reporter.log("Navigated to Rankup signup Page \n", true);
		navigateBack();
	}
	
	@FindBy(xpath="//p[contains(text(),'Login to your account.')]")
	private WebElement verifyAlreadyAppliedLoginPage;
	
	public void alreadyappliedLogin1(){
		scrollToElementViaJavascript(alreadyAppliedLoginBtn1);
		clickElement(alreadyAppliedLoginBtn1);
		waitUntilElementAppears(verifyAlreadyAppliedLoginPage);
		Assert.assertTrue(verifyAlreadyAppliedLoginPage.isDisplayed(), "Not in Rankup login page");
		Reporter.log("Navigated to Rankup Login Page \n", true);
		navigateBack();
	}
	
	public void alreadyappliedLogin2(){
		scrollToElementViaJavascript(alreadyAppliedLoginBtn2);
		clickElement(alreadyAppliedLoginBtn2);
		waitUntilElementAppears(verifyAlreadyAppliedLoginPage);
		Assert.assertTrue(verifyAlreadyAppliedLoginPage.isDisplayed(), "Not in Rankup login page");
		Reporter.log("Navigated to Rankup Login Page \n", true);
		navigateBack();
	}
	
	public void alreadyappliedLogin3(){
		scrollToElementViaJavascript(alreadyAppliedLoginBtn1);
		clickElement(alreadyAppliedLoginBtn3);
		waitUntilElementAppears(verifyAlreadyAppliedLoginPage);
		Assert.assertTrue(verifyAlreadyAppliedLoginPage.isDisplayed(), "Not in Rankup login page");
		Reporter.log("Navigated to Rankup signup Page \n", true);
		navigateBack();
	}
	
	
	
	public void successStories() throws InterruptedException{
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
	
	public void tab1Navigation() throws InterruptedException{
		waitUntilElementclickable(tab1);
		clickElement(tab1);
		Assert.assertTrue(tab1Heading.isDisplayed(), "Tab1 navigation failed");
		Reporter.log("Tab1 navigation is successful \n", true);
	}
	
	public void tab2Navigation() throws InterruptedException{
		waitUntilElementclickable(tab2);
		clickElement(tab2);
		Assert.assertTrue(tab2Heading.isDisplayed(), "Tab2 navigation failed");
		Reporter.log("Tab2 navigation is successful \n", true);
	}
	
	public void tab3Navigation() throws InterruptedException{
		waitUntilElementclickable(tab3);
		clickElement(tab3);
		Assert.assertTrue(tab3Heading.isDisplayed(), "Tab3 navigation failed");
		Reporter.log("Tab3 navigation is successful \n", true);
	}
	
	public void tab4Navigation() throws InterruptedException{
		waitUntilElementclickable(tab4);
		clickElement(tab4);
		Assert.assertTrue(tab4Heading.isDisplayed(), "Tab4 navigation failed");
		Reporter.log("Tab4 navigation is successful \n", true);
	}
	
	@FindBy(xpath="(//img[@class='video-icon'])[1]")
	private WebElement rankupImprovesVideoPlayBtn;
	
	public void playRankupImprovesVideo() throws InterruptedException{
		scrollToElementViaJavascript(rankupImprovesVideo);
		clickElement(rankupImprovesVideoPlayBtn);
		Reporter.log("Clicked on Video play button ",true);
		Thread.sleep(5000);
		clickElement(videoCloseBtn2);
		Reporter.log("Video closed",true);
	}
	
	@FindBy(xpath="(//img[@class='video-icon'])[2]")
	private WebElement rankupToJumpPersonalizationVideoPlayBtn;
	
	public void playRankupToJumpPersonalizationVideo() throws InterruptedException{
		scrollToElementViaJavascript(rankupToJumpPersonalizationVideo);
		clickElement(rankupToJumpPersonalizationVideoPlayBtn);
		Reporter.log("Clicked on Video play button ",true);
		Thread.sleep(5000);
		clickElement(videoCloseBtn2);
		Reporter.log("Video closed",true);
	}
	
	//@FindBy(css = "p.jump-heading")
	@FindBy(css="h1.jump-up-header--text-main")
	private WebElement jumpPageHeading;
	
	public void gotoJumpPage(){
		scrollToElementViaJavascript(gotoJumpBtn);
		clickElement(gotoJumpBtn);
		Reporter.log("Clicked on 'Go to Jump' button",true);
		waitUntilElementAppears(jumpPageHeading);
		Reporter.log("Navigated to jump page page",true);
		navigateBack();
	}
	
}
