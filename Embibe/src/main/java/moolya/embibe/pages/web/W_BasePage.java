package moolya.embibe.pages.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.ClientAnchor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Drawing;
import org.apache.poi.ss.usermodel.Picture;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import moolya.embibe.utils.JavaUtils;

@SuppressWarnings("unused")
public class W_BasePage extends W_SuperBasePage 
{
	public W_BasePage(WebDriver wdriver)
	{
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}

	//	Global Navigation Elements

	//@FindBy(css=".embibeLogo>a:nth-child(1)>img")
	@FindBy(xpath=".//*[@id='root']/div/div[1]/div[2]/div[1]/a[1]/img")
	private WebElement embibeLogo;

	@FindBy(xpath="//li[@class='nav-item']/a[text()='Ask']")
	private WebElement ask_Btn;

	@FindBy(xpath="//li[@class='nav-item ']/a[text()='STUDY']")
	private WebElement study_Btn;

	@FindBy(xpath="//li[@class='nav-item ']/a[text()='JUMP']")
	private WebElement jump_Btn;

	@FindBy(xpath="//li[@class='nav-item ']/a[text()='RANKUP']")
	private WebElement rankup_Btn;

	@FindBy(xpath="//li[@class='nav-item ']/a[text()='INSTITUTES']")
	private WebElement institutes_Btn;

	@FindBy(css=".embibumImage")
	private WebElement embiumImage;

	@FindBy(css=".exam_goal_logo")
	private WebElement goalImage;

	@FindBy(css=".guestImage")
	protected WebElement guestImage;

	@FindBy(css=".create-profile.button-common")
	private WebElement login_Btn;

	@FindBy(xpath="//div[@id='showInDesktopemailError']/preceding-sibling::input")
	private WebElement emailPhone_TB;

	@FindBy(xpath="//div[@id='showInDesktopemailError']/preceding-sibling::input")
	private WebElement emailPhoneSignUp_TB;

	@FindBy(xpath="//div[@id='showInDesktoppasswordError']/preceding-sibling::input")
	private WebElement password_TB;

	@FindBy(xpath="//div[@id='showInDesktoppasswordError']/preceding-sibling::input")
	private WebElement passwordSignUp_TB;

	@FindBy(xpath="//div[@id='showInDesktoppasswordConfirmError']/preceding-sibling::input")
	private WebElement confirmPasswordSignUp_Btn;

	@FindBy(css=".Dropdown-control ")
	private WebElement goalSignUp_DD;

	@FindBy(css=".Dropdown-menu .Dropdown-option")
	private List<WebElement> goalSignUpItems_List;

	@FindBy(xpath="//div[@id='showInDesktoppasswordError']/../following-sibling::button")
	private WebElement login_login_Btn;

	@FindBy(xpath="//div[@id='showInDesktoppasswordError']/../following-sibling::button")
	private WebElement signUp_Btn;

	@FindBy(xpath="(//div[@class='forget-pass']/a)[2]")
	private WebElement forgotPassword_Btn;

	@FindBy(css=".forgotpasswordclose")
	private WebElement forgotPasswordClose_Btn;

	@FindBy(xpath="(//button[@id='btn-facebook'])[2]")
	private WebElement fbLogin_Btn;
	
	@FindBy(xpath=".//*[@id='btn-facebook']")
	protected WebElement signupPage_fb_loginBtn;
	
	@FindBy(xpath=".//*[@id='btn-google']")
	protected WebElement signupPage_google_loginBtn;
	
	@FindBy(xpath="(//button[@id='btn-facebook'])[2]")
	private WebElement fbSignUp_Btn;

	@FindBy(xpath="(//button[@id='btn-google'])[2]")
	private WebElement googleLogin_Btn;

	@FindBy(xpath="(//button[@id='btn-google'])[2]")
	private WebElement googleSignUp_Btn;

	@FindBy(xpath="(//span[@class='register-user']/a)[2]")
	private WebElement register_Btn;

	@FindBy(xpath="(//div[@class='registerlink'])[2]")
	private WebElement registerHere;

	@FindBy(xpath="(//span[@class='register-user']/a)[2]")
	private WebElement SignUpLogin_Btn;

	@FindBy(xpath="//div[@id='showInDesktoppasswordError']/../../following-sibling::div[@class='registerlink']//p")
	private WebElement newUser_Btn;

	@FindBy(css=".close-mail")
	private WebElement closeSignUp_Btn;

	@FindBy(css=".user-dropdown>.user-name>img")
	private WebElement userDropdown;

	@FindBy(css=".tooltip-modal>div")
	private List<WebElement> userDropdownList;

	@FindBy(css=".user-dropdown .user-name[href='/profile']")
	private WebElement myProfile_Btn;

	@FindBy(css=".user-dropdown>div>div>div:nth-child(2)>a")
	private WebElement logout_Btn;

	@FindBy(css=".swiper-slide:nth-child(1) span")
	private WebElement jeeMainSwiperFooter;

	@FindBy(css=".swiper-slide:nth-child(2) span")
	private WebElement jeeAdvancedSwiperFooter;

	@FindBy(css=".swiper-slide:nth-child(3) span")
	private WebElement bitsatSwiperFooter;

	@FindBy(css=".swiper-slide:nth-child(4) span")
	private WebElement neetSwiperFooter;

	@FindBy(css=".Dropdown-option:nth-child(1)")
	private WebElement goalDropdownOptionBank;

	@FindBy(css=".Dropdown-option:nth-child(2)")
	private WebElement goalDropdownOptionEngineering;

	@FindBy(css=".Dropdown-option:nth-child(3)")
	private WebElement goalDropdownOptionMedical;

	@FindBy(css=".Dropdown-option:nth-child(4)")
	private WebElement goalDropdownOptionFoundation10;

	@FindBy(css=".Dropdown-option:nth-child(5)")
	private WebElement goalDropdownOptionFoundation9;

	@FindBy(css=".Dropdown-option:nth-child(6)")
	private WebElement goalDropdownOptionFoundation8;

	@FindBy(css=".hamburger")
	private WebElement hamburger_Btn;

	@FindBy(css=".close-side-options")
	private WebElement closeHamburger_Btn;
	
	@FindBy(xpath="((//*[@class='no-underline-link']/../../../ul)[5]/li/a)[3]")
	protected WebElement collegePredictor;

	String jeeMain_URL="https://www.embibe.com/exams/jee-main/";
	String neet_URL="https://preprod.embibe.com/exams/neet/";
	String aiims_URL="https://preprod.embibe.com/exams/aiims/";
	String cbse_URL="https://preprod.embibe.com/exams/cbse/";
	String jeeAdvanced_URL="https://preprod.embibe.com/exams/iit-jee-advanced/";
	String bitsat_URL="https://preprod.embibe.com/exams/bitsat/";
	String eamcet_URL="https://preprod.embibe.com/exams/ap-eamcet/";

	String class_8_URL="https://preprod.embibe.com/foundation-08/test";
	String class_9_URL="https://preprod.embibe.com/foundation-09/test";
	String class_10_URL="https://preprod.embibe.com/foundation-10/test";

	String exam_jeeMain_URL="https://preprod.embibe.com/engineering/test/jee-main";
	String exam_jeeAdvanced_URL="https://preprod.embibe.com/engineering/test/jee-advanced";
	String exam_bitsat_URL="https://preprod.embibe.com/engineering/test/bitsat";
	String exam_gujaratCet_URL="https://preprod.embibe.com/engineering/test/gujarat-cet";
	String exam_AP_Eamcet_URL="https://preprod.embibe.com/engineering/test/ap-eamcet";
	String exam_TS_Eamcet_URL="https://preprod.embibe.com/engineering/test/ts-eamcet";
	String exam_neet_URL="https://preprod.embibe.com/medical/test/aipmt";
	String exam_aiims_URL="https://preprod.embibe.com/medical/test/aiims";
	String exam_bank_clerk_prelims_URL="https://preprod.embibe.com/bank/test/bank-clerk-prelims";
	String exam_bank_po_prelims_URL="https://preprod.embibe.com/bank/test/bank-po-prelims";



	public void getPixelDataSignUpGoals() throws EncryptedDocumentException, InvalidFormatException, IOException{
		getPixelData("Data", "002.1.3(D)", goalDropdownOptionBank, "goalDropdownOptionBank");
		getPixelData("Data", "002.1.3(D)", goalDropdownOptionEngineering, "goalDropdownOptionEngineering");
		getPixelData("Data", "002.1.3(D)", goalDropdownOptionMedical, "goalDropdownOptionMedical");
		getPixelData("Data", "002.1.3(D)", goalDropdownOptionFoundation10, "goalDropdownOptionFoundation10");
	}

	public void getPixelDataGlobalNavElements() throws EncryptedDocumentException, InvalidFormatException, IOException{
		getPixelData("Data", "D_Guest 1st time user", embibeLogo, "embibeLogo");
		getPixelData("Data", "D_Guest 1st time user", study_Btn, "study_Btn");
		getPixelData("Data", "D_Guest 1st time user", ask_Btn, "ask_Btn");
		getPixelData("Data", "D_Guest 1st time user", jump_Btn, "jump_Btn");
		getPixelData("Data", "D_Regitered user 001", embiumImage, "embiumImage");
		getPixelData("Data", "D_Guest 1st time user", goalImage, "goalImage");
		getPixelData("Data", "D_Guest 1st time user", guestImage, "guestImage");
		getPixelData("Data", "D_Guest 1st time user", login_Btn, "login_Btn");
		getPixelData("Data", "D_Guest 1st time user", jeeMainSwiperFooter, "jeeMainSwiperFooter");
		getPixelData("Data", "D_Guest 1st time user", jeeAdvancedSwiperFooter, "jeeAdvancedSwiperFooter");
		getPixelData("Data", "D_Guest 1st time user", bitsatSwiperFooter, "bitsatSwiperFooter");
		getPixelData("Data", "D_Guest 1st time user", neetSwiperFooter, "neetSwiperFooter");
	}

	@FindBy(css=".react-typeahead-input.react-typeahead-usertext")
	protected WebElement search_TB;

	public void assertSearchHomepage(){
		waitUntilElementclickable(search_TB);
		Assert.assertTrue(search_TB.isDisplayed(), "Not in Search Home page");
		Reporter.log("Navigated to Search Home Page \n", true);
	}

	public void clickHamburger(){
		waitUntilElementclickable(hamburger_Btn);
		hamburger_Btn.click();
		Reporter.log("Clicked on Hamburger", true);
	}

	public void closeHamburger() throws InterruptedException{
		waitUntilElementclickable(closeHamburger_Btn);
		//		Thread.sleep(3000);
		clickElementViaJavaScript(closeHamburger_Btn);
		//		closeHamburger_Btn.click();
		Reporter.log("Closed Hamburger", true);
	}

	public void clickLogin(){
		waitUntilElementclickable(login_Btn);
		try{
			login_Btn.click();
			Reporter.log("Clicked on 'Login' button",true);
		}catch(Exception e){
			clickElementViaJavaScript(login_Btn);
		}
	}

	public void clickRegisterHere(){
		waitUntilElementclickable(register_Btn);
		register_Btn.click();
		Reporter.log("Clicked on Register Here", true);
	}

	public void clickLoginHere(){
		waitUntilElementclickable(SignUpLogin_Btn);
		SignUpLogin_Btn.click();
		Reporter.log("Clicked on Login Here", true);
	}

	@FindBy(xpath="//*[@id='header_block']/span[contains(text(),'Log in to Facebook')]")
	private WebElement assertFbLoginPage;

	@FindBy(xpath="//input[@id='email']")
	private WebElement enterFbEmail;

	@FindBy(xpath="//input[@id='pass']")
	private WebElement enterFbPassword;

	@FindBy(xpath="//*[@id='loginbutton']")
	private WebElement fb_loginBtn;

	public void clickFbLogin() throws InterruptedException{
		waitUntilElementclickable(fbLogin_Btn);
		fbLogin_Btn.click();
		Reporter.log("Clicked on FB Login", true);
		waitUntilElementAppears(assertFbLoginPage);
		Assert.assertTrue(assertFbLoginPage.isDisplayed(), "Failed to open the Facebook login page");
		Reporter.log("Facebook Login Page is opened successfully", true);
	}

	public void enterFbLoginCredentials(String email,String password){
		enterText(enterFbEmail, email);
		Reporter.log("Entered Email id",true);
		enterText(enterFbPassword,password);
		Reporter.log("Entered password",true);
		fb_loginBtn.click();
		Reporter.log("Clicked on facebook login button",true);
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

	public void clickGoogleLogin(){
		waitUntilElementclickable(googleLogin_Btn);
		googleLogin_Btn.click();
		Reporter.log("Clicked on Google Login", true);
		waitUntilElementAppears(assertGoogleSignInPage);
		Assert.assertTrue(assertGoogleSignInPage.isDisplayed(), "Failed to open the Google login page");
		Reporter.log("Google login page is opened successfully", true);
	}

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

	public void clickFbSignUp(){
		waitUntilElementclickable(fbSignUp_Btn);
		fbSignUp_Btn.click();
		Reporter.log("Clicked on FB SignUp", true);
	}

	public void clickGoogleSignUp(){
		waitUntilElementclickable(googleSignUp_Btn);
		googleSignUp_Btn.click();
		Reporter.log("Clicked on Google SignUp", true);
	}

	public void clickEmbibeLogo(){
		waitUntilElementclickable(embibeLogo);
		embibeLogo.click();
		Reporter.log("Clicked on Embibe Logo", true);
	}

	public void clickAsk(){
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		waitUntilElementclickable(ask_Btn);
		ask_Btn.click();
		Reporter.log("Clicked on Ask", true);
		waitUntilElementAppears(embibeLogo_Ask);
		Reporter.log("Navigated to ASK page", true);
	}

	public void clickStudy(){
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		waitUntilElementclickable(study_Btn);
		study_Btn.click();
		Reporter.log("Clicked on Study", true);
	}
	
	
	@FindBy(xpath="//a[@href='/home']/img")
	private WebElement embibeLogo_Jump;
	
	public void clickJumpEmbibeLogo(){
		waitUntilElementclickable(embibeLogo_Jump);
		embibeLogo_Jump.click();
		Reporter.log("Clicked on Embibe Logo", true);
		assertSearchHomepage();
	}
	
	@FindBy(css="a.navbarbrand.logo")
	private WebElement embibeLogo_RankUp;
	
	public void clickRankupEmbibeLogo(){
		waitUntilElementclickable(embibeLogo_RankUp);
		embibeLogo_RankUp.click();
		Reporter.log("Clicked on Embibe Logo", true);
		assertSearchHomepage();
	}

	public JumpPage clickJump(){
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		waitUntilElementclickable(jump_Btn);
		jump_Btn.click();
		Reporter.log("Clicked on Jump", true);
		waitUntilElementclickable(embibeLogo_Jump);
		Reporter.log("Navigated to Jump page", true);
		return new JumpPage(wdriver);
	}
	
	public MyProfilePage goToMyProfile(){
		clickUserDropdown();
		waitUntilElementclickable(myProfile_Btn);
		myProfile_Btn.click();
		return new MyProfilePage(wdriver);
	}

	public void clickRank(){
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		waitUntilElementclickable(rankup_Btn);
		rankup_Btn.click();
		Reporter.log("Clicked on Rankup", true);
		waitUntilElementclickable(embibeLogo_RankUp);
		Reporter.log("Navigated to Rankup page", true);
	}

	@FindBy(css="span.hd-institute")
	private WebElement insitituePageHeader;
	
	public void clickInstitutes(){
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		waitUntilElementclickable(institutes_Btn);
		institutes_Btn.click();
		Reporter.log("Clicked on Institutes", true);
		waitUntilElementAppears(insitituePageHeader);
		Reporter.log("Navigated to Institute page", true);
	}

	
	@FindBy(css="span>img.logo")
	private WebElement embibeLogo_Institute;

	public void clickInstituteEmbibeLogo(){
		waitUntilElementclickable(embibeLogo_Institute);
		embibeLogo_Institute.click();
		Reporter.log("Clicked on Embibe Logo", true);
	}
	
	public void verifyInstitutePage(){
		waitUntilElementclickable(embibeLogo_Institute);
		Assert.assertTrue(insitituePageHeader.isDisplayed(), "Institute Page is not loaded");
		Reporter.log("Institute Page opened successfully", true);
	}
	
	public void mouseHoverOnAsk() throws InterruptedException{
		waitUntilElementAppears(ask_Btn);
		mouseHoverOnElement(wdriver, ask_Btn, "Mouse Hovered on Ask");
	}

	public void mouseHoverOnStudy() throws InterruptedException{
		waitUntilElementAppears(study_Btn);
		mouseHoverOnElement(wdriver, study_Btn, "Mouse Hovered on Study");
	}

	public void mouseHoverOnJump() throws InterruptedException{
		waitUntilElementAppears(jump_Btn);
		mouseHoverOnElement(wdriver, jump_Btn, "Mouse Hovered on Jump");
	}

	public void mouseHoverOnRankUp() throws InterruptedException{
		waitUntilElementAppears(rankup_Btn);
		mouseHoverOnElement(wdriver, rankup_Btn, "Mouse Hovered on Rankup");
	}

	public void mouseHoverOnInstitutes() throws InterruptedException{
		waitUntilElementAppears(institutes_Btn);
		mouseHoverOnElement(wdriver, institutes_Btn, "Mouse Hovered on Institutes");
	}

	public void clickEmbiumStatus(){
		waitUntilElementAppears(embiumImage);
		embiumImage.click();
		Reporter.log("Embium Image is present in the Header", true);
	}
	
	public void loginBtn(){
		waitUntilElementclickable(login_Btn);
		clickElement(login_Btn);
		Reporter.log("Clicked on Login button",true);
	}

	public void clickProfileIcon() throws InterruptedException{
		waitUntilElementAppears(guestImage);
		guestImage.click();
		Reporter.log("Guest Profile Icon is present in the Header", true);
	}

	public void verifyProfileDropdownList(){
		List<WebElement> list=userDropdownList;
		int actualListCount=userDropdownList.size();
		Reporter.log("Profile Dropdown list are : ",true);
		for(WebElement ele:list){
			Reporter.log(ele.getText(),true);
		}
		Assert.assertEquals(actualListCount, 2);
	}


	public void getPixelDataLogin() throws EncryptedDocumentException, InvalidFormatException, IOException{
		getPixelData("Data", "login", emailPhone_TB, "emailPhone_TB");
		getPixelData("Data", "login", password_TB, "password_TB");
		getPixelData("Data", "login", login_login_Btn, "login_login_Btn");
		getPixelData("Data", "login", forgotPassword_Btn, "forgotPassword_Btn");
		getPixelData("Data", "login", fbLogin_Btn, "fbLogin_Btn");
		getPixelData("Data", "login", googleLogin_Btn, "googleLogin_Btn");
		getPixelData("Data", "login", registerHere, "registerHere");
	}

	@FindBy(xpath="//*[@class='FPHead']")
	private WebElement assertForgotPasswordWindow;

	public LoginPage clickForgotPassword(){
		waitUntilElementclickable(forgotPassword_Btn);
		forgotPassword_Btn.click();
		Reporter.log("Clicked on Forgot Password", true);
		Assert.assertTrue(assertForgotPasswordWindow.isDisplayed(), "Failed to open Forgot password window");
		Reporter.log("Forgot password window opened successfully",true);
		return new LoginPage(wdriver);
	}

	public void clickRegister(){
		waitUntilElementclickable(register_Btn);
		register_Btn.click();
	}

	public void clickGoalDropdown(){
		waitUntilElementclickable(goalSignUp_DD);
		goalSignUp_DD.click();
	}

	public void getPixelDataSignUp() throws EncryptedDocumentException, InvalidFormatException, IOException{
		getPixelData("Data", "Signup", emailPhoneSignUp_TB, "emailPhoneSignUp_TB");
		getPixelData("Data", "Signup", goalSignUp_DD, "goalSignUp_DD");
		getPixelData("Data", "Signup", passwordSignUp_TB, "passwordSignUp_TB");
		getPixelData("Data", "Signup", confirmPasswordSignUp_Btn, "confirmPasswordSignUp_Btn");
		getPixelData("Data", "Signup", signUp_Btn, "signUp_Btn");
		getPixelData("Data", "Signup", fbSignUp_Btn, "fbSignUp_Btn");
		getPixelData("Data", "Signup", googleSignUp_Btn, "googleSignUp_Btn");
		getPixelData("Data", "Signup", SignUpLogin_Btn, "SignUpLogin_Btn");
	}

	public void login(){
		waitUntilElementclickable(login_Btn);
		login_Btn.click();
		emailPhone_TB.sendKeys("yashuu@gmail.com");
		Reporter.log("Entered student mail id ",true);
		password_TB.sendKeys("qwertyuiop");
		Reporter.log("Entered password ",true);
		login_login_Btn.click();
		Reporter.log("Clicked on Login button",true);
		waitUntilElementAppears(guestImage);
		Reporter.log("Logged in Successfully",true);
	}
	
	public void loginWithGoal(String goal){
		String email = "";
		switch(goal){
		case "Engineering": email="engineering@moolya.com";
		break;
		case "Medical": email="medical@moolya.com";
		break;
		default: break;
		}
		if(!goal.equalsIgnoreCase("na")){
			waitUntilElementclickable(login_Btn);
			login_Btn.click();
			emailPhone_TB.sendKeys(email);
			Reporter.log("Entered student mail id ",true);
			password_TB.sendKeys("moolya123");
			Reporter.log("Entered password ",true);
			login_login_Btn.click();
			Reporter.log("Clicked on Login button",true);
			waitUntilElementAppears(guestImage);
			Reporter.log("Logged in Successfully",true);
		}
	}

	public void invalidLogin(String email,String password){
		waitUntilElementclickable(login_Btn);
		//login_Btn.click();
		//Reporter.log("Clicked on Login Button",true);
		emailPhone_TB.sendKeys(email);
		Reporter.log("Entered '"+email+"'",true);
		password_TB.sendKeys(password);
		Reporter.log("Entered Password",true);
		login_login_Btn.click();
		Reporter.log("Clicked on login button",true);

	}

	public void login(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		clickElement(login_Btn, "Clicked Login");
		enterText(emailPhone_TB, data.get("Email/Phone"), "Entered Email/Phone: "+data.get("Email/Phone"));
		enterText(password_TB, data.get("Password"), "Entered Password: "+data.get("Password"));
		clickElement(login_login_Btn, "Clicked Login");
	}

	public void login(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		clickElement(login_Btn, "Clicked Login");
		enterText(emailPhone_TB, email, "Entered Email/Phone: "+email);
		enterText(password_TB, data.get("Password"), "Entered Password: "+data.get("Password"));
		clickElement(login_login_Btn, "Clicked Login");
	}

	public void signUp(String uniqueValue,String email) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SignUpPage", uniqueValue);
		waitUntilElementclickable(login_Btn);
		clickElement(login_Btn, "Clicked Login");
		clickElement(register_Btn, "Clicked Register Here");
		emailPhoneSignUp_TB.sendKeys(email);
		Reporter.log("Entered Email/Phone: "+email, true);
		selectCustomDropdown(goalSignUp_DD, goalSignUpItems_List, data.get("Goal"), "Selected Goal: "+data.get("Goal"));
		passwordSignUp_TB.sendKeys(data.get("Password"));
		Reporter.log("Entered Password: "+data.get("Password"), true);
		confirmPasswordSignUp_Btn.sendKeys(data.get("Password"));
		Reporter.log("Entered Confirm Password: "+data.get("Password"), true);
		clickElement(signUp_Btn, "Clicked SignUp");
		clickElement(closeSignUp_Btn, "Clicked on Close");
	}

	public void goToRearchPage(){
		wdriver.navigate().to("https://rearch.embibe.com");
	}

	public void verifyLogin(){
		waitUntilElementAppears(userDropdown);
		Assert.assertTrue(userDropdown.isDisplayed(), "Login Failure");
		Reporter.log("Login Success", true);
	}

	public void verifyFailureLogin(){
		Assert.assertTrue(login_Btn.isDisplayed(), "Login successful");
		Reporter.log("Login Failed", true);
	}

	public void clickUserDropdown(){
		waitUntilElementclickable(userDropdown);
		//		clickElementViaJavaScript(userDropdown);
		userDropdown.click();
	}
	
	public void printAllCookies(){
		Set<Cookie> cookies = wdriver.manage().getCookies();
		for(Cookie c:cookies){
			System.out.println("Name: "+c.getName()+"\nDomain: "+c.getDomain()+"\nPath: "+c.getPath()+"\nValue: "+c.getValue()
			+"\nClass: "+c.getClass()+"\nExpiry: "+c.getExpiry());
		}
	}

	public void clearCookies(){
		wdriver.manage().deleteAllCookies();
		Reporter.log("Cleared Cookies",true);
	}

	public LogoutSignInPage logoutPP() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementclickable(userDropdown);
		//		clickElementViaJavaScript(userDropdown);
		Thread.sleep(1000);
		userDropdown.click();
		waitUntilElementclickable(logout_Btn);
		logout_Btn.click();
		return new LogoutSignInPage(wdriver);
	}

	public LandingPage goToLandingPage() throws IOException{
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");
		wdriver.navigate().to(url);
		return new LandingPage(wdriver);
	}

	public SignUpPage goToSignUpPage() throws IOException{
		String domain = getPropValue("domain");
		String url = null;
		if(domain.equalsIgnoreCase("test"))
			url = getPropValue("testAppUrl");
		else if(domain.equalsIgnoreCase("dev"))
			url = getPropValue("devAppUrl");
		wdriver.navigate().to(url+"signup");
		return new SignUpPage(wdriver);
	}

	public MailinatorPage goToMailinatorPage(){
		wdriver.navigate().to("http://www.mailinator.com/");
		return new MailinatorPage(wdriver);
	}

	public DslPage goToDslPage(){
		wdriver.navigate().to("http://10.140.10.116:9090/");
		return new DslPage(wdriver);
	}

	public void getPixelDataUserDropdown() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(myProfile_Btn);
		getPixelData("Data", "D_Regitered user 002", myProfile_Btn, "myProfile_Btn");
		getPixelData("Data", "D_Regitered user 002", logout_Btn, "logout_Btn");
	}

	public SignUpPage logout() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementclickable(userDropdown);
		//		clickElementViaJavaScript(userDropdown);
		Thread.sleep(1000);
		userDropdown.click();
		Reporter.log("Clicked on Profile icon",true);
		waitUntilElementclickable(logout_Btn);
		logout_Btn.click();
		Reporter.log("Clicked on logout button",true);
		Reporter.log("Logged out succesfully",true);
		return new SignUpPage(wdriver);
	}

	public LogoutSignInPage signOut() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementclickable(userDropdown);
		clickElementViaJavaScript(userDropdown);
		userDropdown.click();
		waitUntilElementclickable(logout_Btn);
		logout_Btn.click();
		Reporter.log("Logged Out Successfully", true);
		return new LogoutSignInPage(wdriver);
	}

	public void getPixelData(String sheetName, String pageName, WebElement e, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		try {
			HashMap<String, String> data = readPixelData(sheetName, pageName, uniqueValue);
			waitUntilElementAppears(e);
			for(Map.Entry<String, String> m:data.entrySet()){
				if(!m.getValue().equals("")&&!m.getValue().equals(null)){
					String cssKey = m.getKey().substring(2);
					String cssValue = e.getCssValue(cssKey);
					String eCssValue = m.getValue();
					if(cssKey.contains("width"))
						eCssValue = getScreenWidthPixels(wdriver.manage().window().getSize().width, m.getValue());
					else if(cssKey.contains("height"))
						eCssValue = getScreenheightPixels(wdriver.manage().window().getSize().height, m.getValue());
					writeExpectedPixelData(uniqueValue, pageName, "e_"+cssKey, eCssValue);
					if(cssValue.contains("rgba"))
						cssValue = rgbaToHex(cssValue);
					if(cssValue.contains("auto")){
						String height = getElementHeightViaJavascript(e);
						String width = getElementWidthViaJavascript(e);
						if(cssKey.contains("width"))
							cssValue = width+"px";
						else if(cssKey.contains("height"))
							cssValue = height+"px";
					}

					writePixelData(sheetName, uniqueValue, pageName, "a_"+cssKey, cssValue);
				}
			}
		} catch (Exception e1) {}
		/*try {
			File file = takeElementScreenshot(e, uniqueValue);
			HashMap<String, Integer> dim = getMaxWidthHeight(sheetName, pageName, uniqueValue);
			writeElementImageToData(uniqueValue, pageName, "Image", file, dim.get("width"), dim.get("height"));
		} catch (Exception e1) {}*/
	}

	public static String getScreenWidthPixels(int width, String value) {
		return Double.toString(Double.parseDouble(value.replaceAll("px", ""))*width/1280)+"px";
	}

	public static String getScreenheightPixels(int width, String value) {
		return Double.toString(Double.parseDouble(value.replaceAll("px", ""))*width/720)+"px";
	}

	public HashMap<String, Integer> getMaxWidthHeight(String sheetName, String pageName, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readAllPixelData(sheetName, pageName, uniqueValue);
		int a_width = (int)Double.parseDouble(data.get("z_width").replaceAll("px", ""))+1;
		int a_height = (int)Double.parseDouble(data.get("z_height").replaceAll("px", ""))+1;
		int b_width = (int)Double.parseDouble(data.get("e_width").replaceAll("px", ""))+1;
		int b_height = (int)Double.parseDouble(data.get("e_height").replaceAll("px", ""))+1;
		int c_width ,c_height;
		if(data.get("a_width").replaceAll("px", "").matches("[a-zA-Z]+"))
			c_width = a_width;
		else
			c_width = (int)Double.parseDouble(data.get("a_width").replaceAll("px", ""))+1;
		if(data.get("a_height").replaceAll("px", "").matches("[a-zA-Z]+"))
			c_height = a_height;
		else
			c_height = (int)Double.parseDouble(data.get("a_height").replaceAll("px", ""))+1;
		int width,height;
		if(a_width>=b_width&&a_width>=c_width)
			width = a_width;
		else if(b_width>=a_width&&b_width>=c_width)
			width = b_width;
		else
			width = c_width;
		if(a_height>=b_height&&a_height>=c_height)
			height = a_height;
		else if(b_height>=a_height&&b_height>=c_height)
			height = b_height;
		else
			height = c_height;
		HashMap<String, Integer> dim = new HashMap<String, Integer>();
		dim.put("width", width);
		dim.put("height", height);
		return dim;
	}

	public void selectItemFromList(List<WebElement> list, String text) throws InterruptedException {
		for (WebElement e : list) {
			if (e.getText().equals(text)) {
				e.click();
				Thread.sleep(5000);
				break;
			}
		}	
	}

	@FindBy(xpath="//*[@id='showInDesktopemailError']")
	private WebElement signupEmailFieldError;

	public void verifySignupEmailField(String email){
		emailPhoneSignUp_TB.clear();
		enterText(emailPhoneSignUp_TB, email);
		Assert.assertTrue(!signupEmailFieldError.isDisplayed(), "Email format is acceptable");
		Reporter.log("Entered '"+email+"' is acceptable",true);
	}

	@FindBy(css=".Dropdown-placeholder")
	private WebElement defaultSignUpGoal;

	@FindBy(css=".Dropdown-menu ")
	private List<WebElement> goalSignUp_DDList;

	@FindBy(css=".Dropdown-menu .Dropdown-option")
	private List<WebElement> goalItems_List;

	public void verifyAndSelectGoal_DD() throws InterruptedException{
		enterText(emailPhoneSignUp_TB, "testonetest444@gmail.com");
		clickElement(goalSignUp_DD);
		Thread.sleep(5000);
		List<WebElement> list=goalSignUp_DDList;
		Reporter.log("Default Goal is  : " + defaultSignUpGoal.getText(),true);
		Reporter.log("Goal lists are : ",true);
		for(WebElement ele:list){
			Reporter.log(ele.getText(),true);
		}
		clickElement(goalSignUp_DD);
		selectCustomDropdown(goalSignUp_DD, goalItems_List, "Bank", "");
		Thread.sleep(2000);
		Reporter.log("Selected Goal is  : " + defaultSignUpGoal.getText(),true);
	}

	@FindBy(xpath="//*[@id='showInDesktoppasswordError']")
	private WebElement passwordFieldError;

	public void verifySignupPasswordField(String password) throws InterruptedException{
		Thread.sleep(2000);
		enterText(password_TB, password);
		Reporter.log("Enter password : "+password,true);
		if(passwordFieldError.isDisplayed()){
			Reporter.log("Password length is : '"+ password.length() + "'.So warning '"+passwordFieldError.getText()+"' is displayed " ,true);
		}
		else

			Reporter.log("Password length is : '" +password.length() + "' and Password is accepted",true);

	}

	@FindBy(xpath="//*[@id='showInDesktoppasswordConfirmError']")
	private WebElement cofirmPasswordFieldError;

	public void verifyConfirmPasswordField(String password,String confirmPassword) throws InterruptedException{
		enterText(password_TB, password);
		enterText(confirmPasswordSignUp_Btn, confirmPassword);
		Thread.sleep(2000);
		if(cofirmPasswordFieldError.isDisplayed()){
			Reporter.log("Enter 'Password': "+password +"\nEnter 'Confirm Password': "+ confirmPassword,true);
			Reporter.log("Warning '"+cofirmPasswordFieldError.getText()+"' is displayed " ,true);
		}
		else
		{
			Reporter.log("Enter 'Password': "+password +"\nEnter 'Confirm Password': "+ confirmPassword,true);
			Reporter.log("Password Matched ",true);		
		}
	}

	public void clickLoginSignUpBtn(){
		waitUntilElementclickable(signUp_Btn);
		signUp_Btn.click();
		Reporter.log("Clicked on SignUp Button", true);
	}

	@FindBy(xpath="//*[@id='showInDesktoppasswordConfirmError']")
	private WebElement confirmPasswordError;

	public void verifyEmptySignUpFileds() throws InterruptedException{
		clickLoginSignUpBtn();
		Assert.assertTrue(signupEmailFieldError.isDisplayed(), "Failed to display warning for empty email field ");
		Reporter.log("Warning '"+signupEmailFieldError.getText()+"' is displayed for empty email field",true);
		Assert.assertTrue(passwordFieldError.isDisplayed(), "Failed to display warning for password field ");
		Reporter.log("Warning '"+passwordFieldError.getText()+"' is displayed for empty password field",true);
		Assert.assertTrue(confirmPasswordError.isDisplayed(), "Failed to display warning for empty Confirm password field ");
		Reporter.log("Warning '"+confirmPasswordError.getText()+"' is displayed for empty Confirm password field",true);
	}

	public void alreadyRegisterUserSignUp(){
		enterText(emailPhoneSignUp_TB, "yatheendra@moolya.com");
		Reporter.log("Entered already registered email id",true);
		enterText(passwordSignUp_TB, "embibe123");
		Reporter.log("Entered passsword",true);
		enterText(confirmPasswordSignUp_Btn, "embibe123");
		Reporter.log("Entered confirm password",true);
		clickLoginSignUpBtn();
		waitUntilElementAppears(signupEmailFieldError);
		Assert.assertTrue(signupEmailFieldError.isDisplayed(), "Failed to display warning for email field ");
		Reporter.log("Warning '"+signupEmailFieldError.getText()+"' is displayed for already registered email id",true);
	}

	public void justEnterLoginCredentials(String email){
		enterText(emailPhone_TB, email);	
		enterText(password_TB, "moolya123");
	}

	@SuppressWarnings({ "unused", "static-access"})
	public WebDriver launchDsl(String browser) throws IOException
	{
		String url = null;
		url = JavaUtils.getPropValue("dslUrl");
		if (browser.equalsIgnoreCase("ff")) 
		{
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
			FirefoxProfile ffProfile = new FirefoxProfile();
			ffProfile.setPreference("geo.enabled", false);
			ffProfile.setPreference("geo.provider.use_corelocation", false);
			ffProfile.setPreference("geo.prompt.testing", false);
			ffProfile.setPreference("geo.prompt.testing.allow", false);
			FirefoxOptions ffOptions = new FirefoxOptions();
			ffOptions.setProfile(ffProfile);
			wdriver = new FirefoxDriver(ffOptions);
		}

		//	Only for windows
		else if(browser.equalsIgnoreCase("grid")){
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			DesiredCapabilities caps = DesiredCapabilities.chrome();
			wdriver = new RemoteWebDriver(new URL("http://172.16.100.114:4444/wd/hub"),caps);
		}

		else if(browser.contains("ie")){
			InternetExplorerDriverService ieService = null;
			if(browser.equalsIgnoreCase("ieWinx32"))
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer32.exe"); // setting path of the IEDriver
			}
			//	Only for windows
			else if(browser.equalsIgnoreCase("ieWinx64"))
			{
				System.setProperty("webdriver.ie.driver", "./drivers/IEDriverServer64.exe"); // setting path of the IEDriver
			}
			InternetExplorerOptions ieOptions = new InternetExplorerOptions();
			ieOptions.destructivelyEnsureCleanSession();
			ieOptions.introduceFlakinessByIgnoringSecurityDomains();
			wdriver = new InternetExplorerDriver(ieOptions);
		}
		//	Only for mac
		else if(browser.equalsIgnoreCase("safari")){
			wdriver = new SafariDriver();
		}else if (browser.equalsIgnoreCase("chrome")) 
		{
			if(System.getProperty("os.name").toLowerCase().contains("windows"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			else if(System.getProperty("os.name").toLowerCase().contains("mac"))
				System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			ChromeOptions chromeOptions = new ChromeOptions();
			LoggingPreferences logPrefs = new LoggingPreferences();
			logPrefs.enable(LogType.PERFORMANCE, Level.ALL);
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("enable-strict-powerful-feature-restrictions");
			chromeOptions.addArguments("disable-geolocation");
			chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
			wdriver = new ChromeDriver(chromeOptions);
		}
		else if(browser.contains("opera")){
			OperaOptions operaOptions = new OperaOptions();
			if(browser.equalsIgnoreCase("opera32")){
				System.setProperty("webdriver.opera.driver", "./drivers/operadriver32.exe");
				operaOptions.setBinary("C:/Program Files (x86)/Opera/launcher.exe");
				wdriver = new OperaDriver(operaOptions);
			}else if(browser.equalsIgnoreCase("opera64")){
				if(System.getProperty("os.name").toLowerCase().contains("windows")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver64.exe");
					operaOptions.setBinary("C:/Program Files/Opera/launcher.exe");
					wdriver = new OperaDriver(operaOptions);
				}
				else if(System.getProperty("os.name").toLowerCase().contains("mac")){
					System.setProperty("webdriver.opera.driver", "./drivers/operadriver");
					wdriver = new OperaDriver();
				}
			}
		}
		else if (browser.equalsIgnoreCase("phantomjs")){
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setJavascriptEnabled(true);
			caps.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
			caps.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
			caps.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, new String[] {
					"--web-security=false",
					"--ssl-protocol=any",
					"--ignore-ssl-errors=true",
					"--webdriver-loglevel=INFO"
			});
			System.setProperty(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "./drivers/phantomjs.exe");
			wdriver = new PhantomJSDriver(caps);
		}

		//		http://10.140.10.116:7766/search
		//		http://10.140.10.116:9090/
		wdriver.get(url);
		wdriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		wdriver.manage().window().maximize();
		Reporter.log("Launched Url: "+wdriver.getCurrentUrl(), true);
		return wdriver;
	}
	
	public HashMap<String, String> readPixelData(String sheetName,String pageName,String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		sheetName = width+"X"+height;
		HashMap<String,String> dataMap = null;
		String key = null, value = null;
		FileInputStream file = new FileInputStream("./test-data/PixelData.xlsx");
		dataMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=3;i<headers.getLastCellNum();i++){
					if(headers.getCell(i).toString().trim().startsWith("z_")){
						try{
							try {
								value = record.getCell(i).toString().trim();
								key = headers.getCell(i).toString().trim();
							} catch (Exception e) {
								value = record.getCell(i).getStringCellValue();
								key = headers.getCell(i).toString().trim();
							}
						}catch(Exception e){
							continue;
						}
					}

					dataMap.put(key, value);
				}

				break;
			}
		}
		wb.close();
		file.close();
		return dataMap;
	}

	public HashMap<String, String> readAllPixelData(String sheetName,String pageName,String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		sheetName = width+"X"+height;
		HashMap<String,String> dataMap = null;
		String key = null, value = null;
		FileInputStream file = new FileInputStream("./test-data/PixelData.xlsx");
		dataMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=3;i<headers.getLastCellNum();i++){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = headers.getCell(i).toString().trim();
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = headers.getCell(i).toString().trim();
						}
					}catch(Exception e){
						continue;
					}
					dataMap.put(key, value);
				}

				break;
			}
		}
		wb.close();
		file.close();
		return dataMap;
	}

	public void writePixelData(String sheetName, String uniqueValue, String pageName, String columnName, String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		sheetName = width+"X"+height;
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(columnName)){
							Cell cell = null;
							try{
								cell = record.getCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}catch(Exception e){
								cell = record.createCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}

							break;
						}
					}catch(Exception e){}
				}
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public void writeElementImageToData(String uniqueValue,String pageName,String columnName,File image, int width, int height) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Images");
		Iterator<Row> it = sheet.rowIterator();
		InputStream inputStream = new FileInputStream(image);
		//Get the contents of an InputStream as a byte[].

		byte[] bytes = IOUtils.toByteArray(inputStream);
		//Adds a picture to the workbook
		int pictureIdx = wb.addPicture(bytes, Workbook.PICTURE_TYPE_PNG);
		//close the input stream

		inputStream.close();
		//Returns an object that handles instantiating concrete classes
		CreationHelper helper = wb.getCreationHelper();
		//Creates the top-level drawing patriarch.
		Drawing drawing = sheet.createDrawingPatriarch();

		//Create an anchor that is attached to the worksheet
		ClientAnchor anchor = helper.createClientAnchor();
		//		anchor.setAnchorType(ClientAnchor.DONT_MOVE_AND_RESIZE);

		Row headers = it.next();
		int c=0;
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(columnName)){
							if(sheet.getColumnWidth(i)<=width)
								sheet.setColumnWidth(i, width);
							record.setHeight((short)(height*20));
							anchor.setCol1(i);
							anchor.setRow1(c+1);
							break;
						}
					}catch(Exception e){}
				}
				break;
			}
			c++;
		}

		//Creates a picture
		Picture pict = drawing.createPicture(anchor, pictureIdx);
		pict.resize();
		//Reset the image to the original size

		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public void writeExpectedPixelData(String uniqueValue, String pageName, String columnName, String data) throws EncryptedDocumentException, InvalidFormatException, IOException{
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		String sheetName = width+"X"+height;
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			if(cellPageValue.equals(pageName)&&cellValue.equals(uniqueValue)) {
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(columnName)){
							Cell cell = null;
							try{
								cell = record.getCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}catch(Exception e){
								cell = record.createCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								if(data.contains("px")&&data.contains(".")){
									String tmp = data.replaceAll("px", "");
									double d = Double.parseDouble(tmp);
									String result = String.format("%.1f", d);
									cell.setCellValue(result+"px");
								}
								else
									cell.setCellValue(data);
							}

							break;
						}
					}catch(Exception e){}
				}
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	public void updatePixelResults(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("./test-data/PixelData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			Cell cell;
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			for(int i=3;i<headers.getLastCellNum();i++){
				try{
					if (headers.getCell(i).toString().trim().startsWith("z_")){
						String z_result = record.getCell(i).toString();
						String a_result = record.getCell(i+1).toString();
						boolean flag = z_result.equals(a_result);
						try{
							cell = record.getCell(i+2);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if(flag){
								cell.setCellValue("True");
							}else{
								cell.setCellValue("False");
							}
						}catch(Exception e){
							cell = record.createCell(i+2);
							cell.setCellType(Cell.CELL_TYPE_STRING);
							if(flag){
								cell.setCellValue("True");
							}else{
								cell.setCellValue("False");
							}
						}
					}
				}catch(Exception e){}
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/PixelData.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

	@FindBy(css=".global-nav__left>a>img")
	protected WebElement embibeLogo_Ask;

	public SearchHomepage clickAskEmbibeLogo(){
		waitUntilElementclickable(embibeLogo_Ask);
		embibeLogo_Ask.click();
		Reporter.log("Clicked on Embibe Logo", true);
		assertSearchHomepage();
		return new SearchHomepage(wdriver);
	}

	@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[1]")
	private WebElement aboutUs_footer;

	public void click_aboutUs(){
		scrollToElementViaJavascript(aboutUs_footer);
		waitUntilElementAppears(aboutUs_footer);
		aboutUs_footer.click();
		Reporter.log("Clicked on 'aboutUs' icon",true);
	}
	
	@FindBy(css="div.about-page-top")
	private WebElement assertAboutUs;
	
	public void assertAboutUs_Page(){
		waitUntilElementclickable(assertAboutUs);
		Assert.assertTrue(assertAboutUs.isDisplayed(), "Not navigated to About Us Page");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'About Us' Page", true);
	}

	@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[2]")
	private WebElement press_footer;

	public void click_press(){
		scrollToElementViaJavascript(press_footer);
		waitUntilElementAppears(press_footer);
		press_footer.click();
		Reporter.log("Clicked on 'press' icon",true);
	}
	
	@FindBy(css="div.u-alignBlock div.buttonSet button.button--primary")
	private WebElement assertPress;

	public void assertPress_Page(){
		waitUntilElementclickable(assertPress);
		Assert.assertTrue(assertPress.isDisplayed(), "Not navigated to Press Page");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'Press' Page", true);
	}
	
	@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[3]")
	private WebElement contactUs_footer;

	public void click_contactUs(){
		scrollToElementViaJavascript(contactUs_footer);
		waitUntilElementAppears(contactUs_footer);
		contactUs_footer.click();
		Reporter.log("Clicked on 'Contact Us' icon",true);
	}

	@FindBy(css="body.contact-us-page")
	private WebElement assertContactUs;
	
	public void assertContactUs_Page(){
		waitUntilElementclickable(assertContactUs);
		Assert.assertTrue(assertContactUs.isDisplayed(), "Not navigated to Contact us Page");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'Contact Us' Page", true);
	}
	
	
	@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[4]")
	private WebElement termsConditions_footer;

	public void click_termsConditions(){
		scrollToElementViaJavascript(termsConditions_footer);
		waitUntilElementAppears(termsConditions_footer);
		termsConditions_footer.click();
		Reporter.log("Clicked on 'Terms  & Conditions' icon",true);
	}
	
	@FindBy(css="div.tos-section")
	private WebElement assertTOS;
	
	public void assertTOS_Page(){
		waitUntilElementclickable(assertTOS);
		Assert.assertTrue(assertTOS.isDisplayed(), "Not navigated to 'Terms of Service' Page");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'Terms of Service' Page", true);
	}
	
	@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[5]")
	private WebElement takeDownPolicy;

	public void click_takeDownPolicy(){
		scrollToElementViaJavascript(takeDownPolicy);
		waitUntilElementAppears(takeDownPolicy);
		takeDownPolicy.click();
		Reporter.log("Clicked on 'TakeDown Policy' icon",true);
	}
	
	@FindBy(css="div.takedown-section")
	private WebElement assertTDP;
	
	public void assertTakeDownPolicy_Page(){
		waitUntilElementclickable(assertTDP);
		Assert.assertTrue(assertTDP.isDisplayed(), "Not navigated to 'Take Down Policy' Page");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'Take Down Policy' Page", true);
	}
	
	@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[6]")
	private WebElement privacyPolicy;

	public void click_privacyPolicy(){
		scrollToElementViaJavascript(privacyPolicy);
		waitUntilElementAppears(privacyPolicy);
		privacyPolicy.click();
		Reporter.log("Clicked on 'Privacy Policy' icon",true);
	}
	
	@FindBy(css="div.tos-section")
	private WebElement assertPrivacyPolicy;
	
	public void assertPrivacyPolicy_Page(){
		waitUntilElementclickable(assertPrivacyPolicy);
		Assert.assertTrue(assertPrivacyPolicy.isDisplayed(), "Not navigated to 'Privacy Policy' Page");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'Privacy Policy' Page", true);
	}

}


