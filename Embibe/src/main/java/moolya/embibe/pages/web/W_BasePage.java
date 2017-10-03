package moolya.embibe.pages.web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

@SuppressWarnings("unused")
public class W_BasePage extends W_SuperBasePage 
{
	public W_BasePage(WebDriver wdriver)
	{
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}

	//	Global Navigation Elements

	@FindBy(css=".embibeLogo>a:nth-child(1)>img")
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

	@FindBy(css=".goalImage")
	private WebElement goalImage;

	@FindBy(css=".guestImage")
	private WebElement guestImage;

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

	@FindBy(css=".user-dropdown>.user-name")
	private WebElement userDropdown;

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
	
	public void clickHamburger(){
		waitUntilElementclickable(hamburger_Btn);
		hamburger_Btn.click();
		Reporter.log("Clicked on Hamburger", true);
	}
	
	public void closeHamburger(){
		waitUntilElementclickable(closeHamburger_Btn);
		clickElementViaJavaScript(closeHamburger_Btn);
		Reporter.log("Closed Hamburger", true);
	}

	public void clickLogin(){
		waitUntilElementclickable(login_Btn);
		try{
			login_Btn.click();
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
	
	public void clickFbLogin(){
		waitUntilElementclickable(fbLogin_Btn);
		fbLogin_Btn.click();
		Reporter.log("Clicked on FB Login", true);
	}
	
	public void clickGoogleLogin(){
		waitUntilElementclickable(googleLogin_Btn);
		googleLogin_Btn.click();
		Reporter.log("Clicked on Google Login", true);
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
		waitUntilElementclickable(ask_Btn);
		ask_Btn.click();
		Reporter.log("Clicked on Ask", true);
	}
	
	public void clickStudy(){
		waitUntilElementclickable(study_Btn);
		study_Btn.click();
		Reporter.log("Clicked on Study", true);
	}
	
	public void clickJump(){
		waitUntilElementclickable(jump_Btn);
		jump_Btn.click();
		Reporter.log("Clicked on Jump", true);
	}
	
	public void clickRank(){
		waitUntilElementclickable(rankup_Btn);
		rankup_Btn.click();
		Reporter.log("Clicked on Rankup", true);
	}
	
	public void clickInstitutes(){
		waitUntilElementclickable(institutes_Btn);
		institutes_Btn.click();
		Reporter.log("Clicked on Institutes", true);
	}
	
	public void mouseHoverOnAsk(){
		waitUntilElementAppears(ask_Btn);
		mouseHoverOnElement(wdriver, ask_Btn, "Mouse Hovered on Ask");
	}
	
	public void mouseHoverOnStudy(){
		waitUntilElementAppears(study_Btn);
		mouseHoverOnElement(wdriver, study_Btn, "Mouse Hovered on Study");
	}
	
	public void mouseHoverOnJump(){
		waitUntilElementAppears(jump_Btn);
		mouseHoverOnElement(wdriver, jump_Btn, "Mouse Hovered on Jump");
	}
	
	public void mouseHoverOnRankUp(){
		waitUntilElementAppears(rankup_Btn);
		mouseHoverOnElement(wdriver, rankup_Btn, "Mouse Hovered on Rankup");
	}
	
	public void mouseHoverOnInstitutes(){
		waitUntilElementAppears(institutes_Btn);
		mouseHoverOnElement(wdriver, institutes_Btn, "Mouse Hovered on Institutes");
	}
	
	public void clickEmbiumStatus(){
		waitUntilElementAppears(embiumImage);
		embiumImage.click();
		Reporter.log("Clicked On Embium Status", true);
	}
	
	public void clickProfileIcon(){
		waitUntilElementAppears(guestImage);
		guestImage.click();
		Reporter.log("Clicked On Profile Icon", true);
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

	public LoginPage clickForgotPassword(){
		waitUntilElementclickable(forgotPassword_Btn);
		forgotPassword_Btn.click();
		Reporter.log("Clicked on Forgot Password", true);
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
		emailPhone_TB.sendKeys("yatheendra@moolya.com");
		password_TB.sendKeys("moolya123");
		login_login_Btn.click();
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
		enterText(emailPhoneSignUp_TB, email, "Entered Email/Phone: "+email);
		selectCustomDropdown(goalSignUp_DD, goalSignUpItems_List, data.get("Goal"), "Selected Goal: "+data.get("Goal"));
		enterText(passwordSignUp_TB, data.get("Password"), "Entered Password: "+data.get("Password"));
		enterText(confirmPasswordSignUp_Btn, data.get("Password"), "Entered Confirm Password: "+data.get("Password"));
		clickElement(signUp_Btn, "Clicked SignUp");
	}

	public void verifyLogin(){
		waitUntilElementAppears(userDropdown);
		Assert.assertTrue(userDropdown.isDisplayed(), "Login Failure");
		Reporter.log("Login Success", true);
	}

	public void clickUserDropdown(){
		waitUntilElementclickable(userDropdown);
		clickElementViaJavaScript(userDropdown);
		userDropdown.click();
	}

	public void clearCookies(){
		wdriver.manage().deleteAllCookies();
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

	public MailinatorPage goToMalinatorPage(){
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
		clickElementViaJavaScript(userDropdown);
		userDropdown.click();
		waitUntilElementclickable(logout_Btn);
		logout_Btn.click();
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

}


