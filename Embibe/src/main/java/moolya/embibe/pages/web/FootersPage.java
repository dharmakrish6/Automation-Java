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
import org.testng.asserts.SoftAssert;

import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;

@Snap(value="SearchHomepage-#{Element}.png")
public class FootersPage extends W_BasePage {

	public FootersPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css=".react-typeahead-input.react-typeahead-usertext")
	private WebElement search_TB;

	@FindBy(css=".text-center.search-slogen")
	private WebElement searchSlogan;

	@FindBy(css=".search_results>div>a")
	private List<WebElement> floatingKeywords;

	@FindBy(css=".search_results>div>a>h3")
	private List<WebElement> floatingKeyText;

	@FindBy(css = "div.text-center.mission>a")
	private WebElement chooseMission_Btn;

	@FindBy(css="div.no-result-found:nth-child(1)")
	private WebElement noResultsView;

	@FindBy(css=".create-profile.button-common")
	private WebElement login_Btn;
	
	@FindBy(css=".col-sm-2:nth-child(5) li>a[href='/exams/']")
	private WebElement articles_Link;
	
	@FindBy(css="input.ask-input:nth-child(1)")
	private WebElement askORsearchField;

	@FindBy(css=".find-cool")
	private WebElement findSomethingCool;
	
	public void search(){
		enterText(search_TB, "Rotational");
	}
	
	public void waitforSearchHomePage() {
		waitUntilElementclickable(chooseMission_Btn);
	}

	public LoginPage clickLoginBtn(){
		clickLogin();
		return new LoginPage(wdriver);

	}
	
	public void enterSearchText(String text){
		waitUntilElementclickable(search_TB);
		search_TB.sendKeys(text);
	}

	public void assertSearchHomepage(){
		waitUntilElementclickable(search_TB);
		Assert.assertTrue(search_TB.isDisplayed(), "Not in Search Homepage");
		Reporter.log("Navigated to Search HomePage", true);
	}

	public OcularResult checkWhatWouldYouLikeToStudy(){
		waitUntilElementAppears(searchSlogan);
		return getElementPixelPerfectness(this, searchSlogan, "searchSlogan");
	}

	public SearchResultsPage search(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);
		if(data.get("Disambiguited?").equalsIgnoreCase("yes")){
			String text = data.get("Search Text");
			waitUntilElementclickable(floatingKeywords.get(0));
			Thread.sleep(5000);
			for(int i=0;i<floatingKeywords.size();i++){
				if(floatingKeyText.get(i).getText().equalsIgnoreCase(text)){
					clickElement(floatingKeyText.get(i), "Clicked on: "+text);
					Reporter.log("Clicked Floating Keyword: "+text, true);
					break;
				}
			}
		}
		return new SearchResultsPage(wdriver);
	}

	public SearchResultsPage searchForNonDisambiguitedKeyword(String keyword){
		waitUntilElementAppears(search_TB);
		enterText(search_TB, keyword, "Searching for keyword: "+keyword);
		return new SearchResultsPage(wdriver);
	}

	public ChooseMissionPage clickChooseMission(){
		waitUntilElementclickable(chooseMission_Btn);
		chooseMission_Btn.click();
		Reporter.log("Clicked on 'Choose a mission'",true);
		return new ChooseMissionPage(wdriver);
	}
	
	//@FindBy(xpath="//*[@class='exam_goal_logo']")
	@FindBy(css="div.exam_goal_logo")
	private WebElement guestGoalIcon;
	
	@FindBy(css="span.embibumcoins ")
	private WebElement loginEmbibeCoinIcon;
	
	@FindBy(css="div.exam_goal_tooltip")
	private WebElement goalToolTip;
	
	public void header_loginUserIcons() throws InterruptedException{
		Assert.assertTrue(loginEmbibeCoinIcon.isDisplayed(), "'Embibe Coin Icon' is not found");
		Reporter.log("'Embibe Coin Icon' is present in the Search Home Page Header",true);
		waitUntilElementAppears(guestGoalIcon);
		mouseHoverOnElement(wdriver, guestGoalIcon, "Mouse Hovered on Goal Icon");
		Reporter.log("Login user goal icon is '"+goalToolTip.getText()+"'",true);
		Assert.assertTrue(guestImage.isDisplayed(), "'Profile icon' is not found");
		Reporter.log("'Profile icon' is found",true);
	}

	public void login_searchEngineSection(){
		Assert.assertTrue(searchSlogan.isDisplayed(), "'Search Engine label' is not found");
		Reporter.log("'Search Engine label' is present in the Search Home Page",true);
		Assert.assertTrue(search_TB.isDisplayed(), "'Search Engine' is not found");
		Reporter.log("Search Engine' is present in the Search Home Page",true);
		Assert.assertTrue(chooseMission_Btn.isDisplayed(), "'Choose a Misson' Button is not found");
		Reporter.log("'Choose a Misson' button is present in the Search Home Page",true);
		Assert.assertTrue(findSomethingCool.isDisplayed(), "'Find Something Cool' is not found");
		Reporter.log("'Find Something Cool' is present in the Search Home Page",true);
	}


	@FindBy(xpath="//*[@class='entry-title']")
	private WebElement examTitle;

	@FindBy(css="div.swiper-slide:nth-child(2)")
	private WebElement scrolltoExams;

	@FindBy(xpath="(//*[@id='root']/div/div[2]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li/a)[1]")
	private WebElement jeelink;

	@FindBy(xpath="//*[@class='site-title']/a")
	private WebElement title_examPageEmbibeLogo;


	/*@FindBy(xpath="//a[@title='Embibe Exams']")
	private WebElement embibeExamLogo;*/
	
	@FindBy(css="img.global-nav__logo:nth-child(1)")
	private WebElement examPageEmbibeLogo;
	

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
	
	@FindBy(xpath="(//span[contains(text(),'Log In')])[1]")
	private WebElement ExamPage_logInButton;
	
	@FindBy(xpath="(//span[contains(text(),'Log Out')])[1]")
	private WebElement ExamPage_logoutButton;
	
	public void loginUser_examLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[1]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Reporter.log("Page Title : " + examTitle.getText(), true);
		boolean isExamLogOutBtn = false;
		try{
			isExamLogOutBtn = ExamPage_logoutButton.isDisplayed();
		}catch(Exception e){}
		softAssert.assertTrue(isExamLogOutBtn, "Page should not be in Logged out state.");
		Reporter.log("In logged-in state",true);
		title_examPageEmbibeLogo.click();
		Reporter.log("Clicked on Embibe logo",true);
		assertSearchHomepage();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;
	
	public void loginUser_classesLinks(int i,String examType,String className,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[2]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]")).isDisplayed(), "Navigation failed");
		WebElement classNum=wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]"));
		
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(), true);
		Reporter.log("Class Name : '" + classNum.getText(), true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		boolean isExamLogOutBtn = false;
		try{
			isExamLogOutBtn = ExamPage_logoutButton.isDisplayed();
		}catch(Exception e){}
		softAssert.assertTrue(isExamLogOutBtn, "Page should not be in Logged out state.");
		Reporter.log("In logged-in state",true);
		embibeLogo_Ask.click();
		Reporter.log("Clicked on Embibe Logo", true);
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
	}
	
	
	@FindBy(xpath="//option[@value=0 AND @selected='selected']")
	private WebElement examPage_Default_DropdownName;
	
	public void loginUser_mockTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[3]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		Thread.sleep(2000);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		boolean isExamLogOutBtn = false;
		try{
			isExamLogOutBtn = ExamPage_logoutButton.isDisplayed();
		}catch(Exception e){}
		softAssert.assertTrue(isExamLogOutBtn, "Page should not be in Logged out state.");
		Reporter.log("In logged-in state",true);
		clickExamPageEmbibeLogo();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	public void loginUser_crackTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[4]/ul/li/a)["+i+"]")));
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
	
	public void loginUser_resourcesTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[5]/ul/li/a)["+i+"]")));
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

	
	
//	@FindBy(css="div.footer-div div.row.device-location ul li a")
	@FindBy(linkText="Use precise location")
 	private WebElement precise_location;
	
	@FindBy(css="div.footer-div div.row.device-location ul li")
	private WebElement locationName;
	
	
	public void assert_preciseLocation() throws Exception{
		scrollToElementViaJavascript(precise_location);
		Thread.sleep(20000);
		waitUntilElementAppears(precise_location);
		precise_location.click();
		Thread.sleep(10000);
		Reporter.log("Clicked on 'Use Precise Location' option",true);
		Thread.sleep(5000);
		Reporter.log("Obtained Location : "+locationName.getText(),true);
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
	
	public void hoverOnFloatingKeywords(int count) throws InterruptedException{
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(5000);
		for(int i=0;i<count;i++){
			mouseHoverOnElement(wdriver, floatingKeyText.get(i));
		}
	}
	
	public SearchResultsPage clickOnFloatingKeywords(int position) throws InterruptedException{
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(5000);
		floatingKeyText.get(position-1).click();
		return new SearchResultsPage(wdriver);
	}
	
	public void scrollToArticles() throws InterruptedException{
		scrollToElementViaJavascript(articles_Link);
		scrollVertically("-100");
		mouseHoverOnElement(wdriver, articles_Link);
	}
	
	SoftAssert softAssert = new SoftAssert();
	
	public void loginuser_searchFooterLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		clickElement(wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		softAssert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		//Assert.assertTrue( examTitle.isDisplayed(),"Navigation failed");
		Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\n Page Title : '" + examTitle.getText() + "' is displayed", true);
		Thread.sleep(2000);
		boolean isExamLogOutBtn = false;
		try{
			isExamLogOutBtn = ExamPage_logoutButton.isDisplayed();
		}catch(Exception e){}
		softAssert.assertTrue(isExamLogOutBtn, "Page should not be in Logged out state.");
		//Assert.assertTrue(isExamLogOutBtn,"Page should not be in Logged out state.");
		Reporter.log("In logged-in state",true);
		//Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		title_examPageEmbibeLogo.click();
		Reporter.log("Clicked on Embibe logo",true);
		assertSearchHomepage();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	@FindBy(css="div.swiper-button-next")
	private WebElement clickNext;
	
	@FindBy(css="div.swiper-button-prev")
	private WebElement clickPrev;

	public void clickNextSwiper() throws InterruptedException{
		waitUntilElementAppears(clickNext);
		Thread.sleep(2000);
		clickNext.click();
		Reporter.log("Clicked on swiper 'Next' button",true);
	}
	
	public void clickPrevSwiper() throws InterruptedException{
		waitUntilElementAppears(clickPrev);
		Thread.sleep(2000);
		clickPrev.click();
		Reporter.log("Clicked on swiper 'Prev' button",true);
	}
	
	public void assert_findSomethingCool() throws InterruptedException{
		waitUntilElementAppears(findSomethingCool);
		findSomethingCool.click();
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Clicked on 'Find Something Cool' option",true);
		Reporter.log("Navigated to 'Blog Page'",true);
		//Thread.sleep(5000);
		//wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		//assertSearchHomepage();
	}

}