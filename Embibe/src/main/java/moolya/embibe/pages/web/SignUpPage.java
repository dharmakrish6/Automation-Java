package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SignUpPage extends W_BasePage {

	public SignUpPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="emailArea")
	private WebElement email_TB;
	
	@FindBy(id="passwordArea")
	private WebElement password_TB;
	
	@FindBy(id="passwordConfirmArea")
	private WebElement confirmPassword_TB;
	
	@FindBy(name="passwordConfirm")
	private WebElement confirmResetPassword_TB;
	
	@FindBy(css=".forgotpassword")
	private WebElement forgotPassword_Btn;
	
	@FindBy(xpath="//a[@class='login-logout-button' and text()='Sign In']")
	private WebElement login_Btn;
	
	@FindBy(css=".account-signup")
	private WebElement expandSignUp_Btn;
	
	@FindBy(css=".Dropdown-control ")
	private WebElement goalSignUp_DD;
	
	@FindBy(css=".Dropdown-menu .Dropdown-option")
	private List<WebElement> goalItems_List;
	
	@FindBy(xpath="//a[@class='login-logout-button' and text()='Sign Up']")
	private WebElement signUp_Btn;
	
	@FindBy(id="inputvalue")
	private WebElement forgotPasswordEmail_TB;
	
	@FindBy(css=".close-mail")
	private WebElement closeForgotPassword_Btn;
	
	@FindBy(xpath="//button[text()='Reset Password']")
	private WebElement resetPassword_Btn;
	
	@FindBy(css=".resetSubmit")
	private WebElement resetSubmit_Btn;
	
	@FindBy(css=".responsebox a[href='/signup']")
	private WebElement resetOk_Btn;
	
	
	public SearchHomepage loginSignUpPage(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		email_TB.sendKeys(email);
		Reporter.log("Entered Email/Phone: "+email, true);
		password_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		login_Btn.click();
		Reporter.log("Clicked Login", true);
		return new SearchHomepage(wdriver);
	}
	
	public void assertSignUpPage(){
		waitUntilElementAppears(email_TB);
		Assert.assertTrue(email_TB.isDisplayed(), "Not in SignUp Page");
		Reporter.log("In SignUp Page", true);
	}
	
	public void expandSignIn(){
		waitUntilElementclickable(login_Btn);
		clickElement(login_Btn, "Clicked Login");
	}
	
	public void expandSignUp(){
		waitUntilElementclickable(expandSignUp_Btn);
		expandSignUp_Btn.click();
		Reporter.log("Clicked on SignUp", true);
	}
	
	public SearchHomepage signUpSignUpPage(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		email_TB.sendKeys(email);
		Reporter.log("Entered Email/Phone: "+email, true);
		selectCustomDropdown(goalSignUp_DD, goalItems_List, data.get("Goal"), "Selected Goal: "+data.get("Goal"));
		password_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		confirmPassword_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Confirm Password: "+data.get("Password"), true);
		signUp_Btn.click();
		Reporter.log("Clicked SignUp", true);
		waitUntilElementclickable(closeForgotPassword_Btn);
		closeForgotPassword_Btn.click();
		Reporter.log("Clicked on Close", true);
		return new SearchHomepage(wdriver);
	}
	
	public void clickForgotPasswordSignUpPage(String email){
		waitUntilElementclickable(forgotPassword_Btn);
		forgotPassword_Btn.click();
		Reporter.log("Clicked on Forgot Password", true);
		waitUntilElementclickable(forgotPasswordEmail_TB);
		forgotPasswordEmail_TB.sendKeys(email);
		Reporter.log("Entered Email: "+email, true);
		resetPassword_Btn.click();
		Reporter.log("Clicked on Reset Password", true);
		waitUntilElementclickable(closeForgotPassword_Btn);
		closeForgotPassword_Btn.click();
	}
	
	public void resetPassword(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(password_TB);
		password_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		confirmResetPassword_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Confirm Password: "+data.get("Password"), true);
		resetSubmit_Btn.click();
		Reporter.log("Clicked on Submit", true);
		waitUntilElementclickable(resetOk_Btn);
		resetOk_Btn.click();
		Reporter.log("Clicked on Submit", true);
	}

	@FindBy(xpath="//*[@class='entry-title']")
	private WebElement examTitle;
	
	public void examLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(forgotPassword_Btn);
		clickElement(wdriver.findElement(By.xpath("(//div[@class='global-footer']/div/div/div[2]/div[1]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\n Page Title : '" + examTitle.getText() + "' is displayed", true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	@FindBy(linkText="Use precise location")
 	private WebElement precise_location;
	
	public void classesLinks(int i,String examType,String className,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(precise_location);
		clickElement(wdriver.findElement(By.xpath("(//div[@class='global-footer']/div/div/div[2]/div[2]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]")).isDisplayed(), "Navigation failed");
		WebElement classNum=wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]"));
		
		Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\n '" + classNum.getText() + "' is displayed", true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		embibeLogo_Ask.click();
		Reporter.log("Clicked on Embibe Logo", true);
		assertSearchHomepage();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
	}
	
	@FindBy(css="img.global-nav__logo:nth-child(1)")
	private WebElement examPageEmbibeLogo;
	
	@FindBy(xpath="//*[@class='site-title']/a")
	private WebElement title_examPageEmbibeLogo;
	
	public void clickExamPageEmbibeLogo(){
		try{
			waitUntilElementAppears(examPageEmbibeLogo);
			clickElement(examPageEmbibeLogo);
			Reporter.log("Clicked on Embibe Logo", true);
			assertSearchHomepage();
		}
		catch(Exception e){
			waitUntilElementAppears(title_examPageEmbibeLogo);
			clickElement(title_examPageEmbibeLogo);
			Reporter.log("Clicked on Embibe Logo", true);
			assertSearchHomepage();
		}
		
	}
	
	@FindBy(xpath="//option[@value=0 AND @selected='selected']")
	private WebElement examPage_Default_DropdownName;
	
	public void mockTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(forgotPassword_Btn);
		clickElement(wdriver.findElement(By.xpath("(//div[@class='global-footer']/div/div/div[2]/div[3]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		Thread.sleep(2000);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		//Assert.assertTrue(examPage_Default_DropdownName.isDisplayed(), "Navigation failed");
		//Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\n Default Exam on Dropdown list is : '" + examPage_Default_DropdownName.getText() + "' is displayed", true);
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		clickExamPageEmbibeLogo();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	public void crackTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(forgotPassword_Btn);
		clickElement(wdriver.findElement(By.xpath("(//div[@class='global-footer']/div/div/div[2]/div[4]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	public void resourcesTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(forgotPassword_Btn);
		clickElement(wdriver.findElement(By.xpath("(//div[@class='global-footer']/div/div/div[2]/div[5]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}

	public boolean getSearchHomepage(){
		try {
			waitUntilElementclickable(search_TB);
			return search_TB.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}
	
	@FindBy(xpath="//*[@class='shift-right no-margin']/a")
	private WebElement facebook_icon;
	
	@FindBy(xpath="//*[@id='js_83']")
	private WebElement fbmbibePageHeader;
	
	@FindBy(xpath="(//*[@class='shift-right ']/a)[1]")
	private WebElement twitter_icon;
	
	@FindBy(xpath="//*[@class='ProfileHeaderCard-name']/a[text()='embibe']")
	private WebElement twitterPageHeader;
	
	@FindBy(xpath="(//*[@class='shift-right ']/a)[2]")
	private WebElement instagram_icon;
	
	@FindBy(xpath="//*[@title='embibe.me']")
	private WebElement instagramPageHeader;
	
	@FindBy(xpath="(//*[@class='shift-right ']/a)[3]")
	private WebElement youtube_icon;
	
	@FindBy(xpath="(//*[contains(text(),'embibe.com')])[3]")
	private WebElement youtubePageHeader;
	
	public void clickFacebookIcon() throws InterruptedException{
		scrollToElementViaJavascript(facebook_icon);
		waitUntilElementAppears(facebook_icon);
		Thread.sleep(2000);
		facebook_icon.click();
		Reporter.log("Clicked on 'facebook' icon",true);
	}
	
	public void assertFacebookEmbibePage() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(wdriver.getCurrentUrl(), "https://www.facebook.com/embibe.me/");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to facebook Page", true);
		Reporter.log("-------------------------------------------------------------------------------",true);
	}
	
	public void clickTwitterIcon() throws InterruptedException{
		scrollToElementViaJavascript(twitter_icon);
		waitUntilElementAppears(twitter_icon);
		Thread.sleep(2000);
		twitter_icon.click();
		Reporter.log("Clicked on 'twitter' icon",true);
	}
	
	public void assertTwitterEmbibePage() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(wdriver.getCurrentUrl(), "https://twitter.com/embibe");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to twitter Page", true);
		Reporter.log("-------------------------------------------------------------------------------",true);
	}
	
	public void clickInstagramIcon() throws InterruptedException{
		scrollToElementViaJavascript(instagram_icon);
		waitUntilElementAppears(instagram_icon);
		Thread.sleep(2000);
		instagram_icon.click();
		Reporter.log("Clicked on 'instagram' icon",true);
	}
	
	public void assertInstagramEmbibePage() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(wdriver.getCurrentUrl(), "https://www.instagram.com/embibe.me/");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to instagram Page", true);
		Reporter.log("-------------------------------------------------------------------------------",true);
	}
	
	public void clickYoutubeIcon() throws InterruptedException{
		scrollToElementViaJavascript(youtube_icon);
		waitUntilElementAppears(youtube_icon);
		Thread.sleep(2000);
		youtube_icon.click();
		Reporter.log("Clicked on 'youtube' icon",true);
	}
	
	public void assertYoutubeEmbibePage(){
		waitUntilElementclickable(youtubePageHeader);
		Assert.assertTrue(youtubePageHeader.isDisplayed(), "Not navigated to youtube");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to Youtube Page", true);
		Reporter.log("-------------------------------------------------------------------------------",true);
	}	
	
}
