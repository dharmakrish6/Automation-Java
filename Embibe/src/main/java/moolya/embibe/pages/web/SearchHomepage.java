package moolya.embibe.pages.web;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;

import moolya.embibe.utils.EmbibeUtils;

@Snap(value="SearchHomepage-#{Element}.png")
public class SearchHomepage extends W_BasePage {

	public SearchHomepage(WebDriver wdriver) {
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
	
	@FindBy(css=".Dropdown-root")
	private WebElement chooseCountry_DD;

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
		Reporter.log("Navigated to Search Home Page", true);
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

	@FindBy(xpath="(//*[@class='goals']/following-sibling::p)[1]")
	private WebElement defaultGoalText;
	
	public ChooseMissionPage clickChooseMission(){
		try{
			waitUntilElementclickable(chooseMission_Btn);
			chooseMission_Btn.click();
			Reporter.log("Clicked on 'Choose a mission'",true);
			waitUntilElementclickable(chooseCountry_DD,5);
		}catch(Exception e){
			refreshPage();
			waitUntilElementclickable(chooseMission_Btn);
			chooseMission_Btn.click();
			Reporter.log("Clicked on 'Choose a mission'",true);
			waitUntilElementclickable(chooseCountry_DD);
		}
		return new ChooseMissionPage(wdriver);
	}

	public void getPixelDataSearchHomeElements() throws EncryptedDocumentException, InvalidFormatException, IOException{
		getPixelData("Data", "D_Guest 1st time user", searchSlogan, "searchSlogan");
		getPixelData("Data", "D_Guest 1st time user", search_TB, "search_TB");
		getPixelData("Data", "D_Guest 1st time user", chooseMission_Btn, "chooseMission_Btn");
	}

	public void FloatingKeywordsCount(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(5000);
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertEquals(floatingKeywords.size(),12 );
	}

	public void disappearFloatingKeywords(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword,searchKeyword);
		Reporter.log("Entered keyword : "+searchKeyword,true);
		//search_TB.clear();
		for(int i=0;i<=10;i++){
			search_TB.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}

		Thread.sleep(1000);
		Reporter.log("Cleared the search field",true);
		//Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		//Assert.assertEquals(floatingKeywords.size(),0 );
		Reporter.log("Floating keywords dissappered successfully.",true);
	}

	@FindBy(xpath="//*[@title='Properties of Triangle']")
	WebElement pot;

	@FindBy(xpath="//*[@title='Properties of Triangle']")
	private List<WebElement> pot1;

	@FindBy(xpath="(//*[@title='Rotational Motion'])[1]")
	private WebElement rotMotionFirst;

	public void duplicateKeywords(String keyword){
		waitUntilElementAppears(search_TB);
		enterText(search_TB, keyword,"Searching for: "+keyword);
		List<WebElement> list = floatingKeywords;
		Reporter.log("Floating keywords are :",true);
		for(WebElement ele:list){
			Reporter.log(ele.getText(),true);	
		}
		Reporter.log("\nThe keyword '" +pot.getText()+ "' appeared '" + pot1.size() + "' times \n",true);
	}

	public void clearSearchField(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);
		Thread.sleep(3000);
		//search_TB.clear();
		for(int i=0;i<=10;i++){
			search_TB.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(500);
		}
		Reporter.log("Cleared the search field",true);
	}

	public void searchInNewTab(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, AWTException, InterruptedException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword);
		Reporter.log("Entered keyword : "+searchKeyword,true);
		Thread.sleep(5000);
		Actions action = new Actions(wdriver);
		//action.moveToElement(rotMotionFirst).click(rotMotionFirst).build().perform();
		action.moveToElement(rotMotionFirst).contextClick(rotMotionFirst).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		Reporter.log("Right clicked on "+searchKeyword ,true);
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		Reporter.log("Opened 'Rotational motion' floating keyword in new tab",true);
		Thread.sleep(2000);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
			Reporter.log("Navigated to Search Results Page",true);
		}
		Reporter.log("Switched to New Tab", true);
		Thread.sleep(1000);
		wdriver.switchTo().window(winHandleBefore);
		assertSearchHomepage();

	}

	public void wrongKeywordInSearchField() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "al");
		Reporter.log("Entered keyword : 'alk'" ,true);
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(2000);
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertFalse(floatingKeywords.size()==0, "No suggestions are available");
		Reporter.log("Auto suggestion floating keywords are available for entered misspell  keyword" ,true);
	}

	@FindBy(css=".search_results>div>a")
	private WebElement floatingKeywordText;
	
	public void correctKeywordInSearchField() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		search_TB.clear();
		Thread.sleep(2000);
		enterText(search_TB, "orga");
		Reporter.log("Entered keyword : 'orga'" ,true);
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(3000);
		String floatingKeyword=floatingKeywordText.getText();
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertFalse(floatingKeywords.size()==0, "No suggestions are available");
		/*Reporter.log("Obtained floating keywords are : "+floatingKeywordText.getText(),true);
		for(int i=0;i<=floatingKeywords.size();i++){
			Reporter.log(floatingKeyword,true);
		}*/
	}

	public void noResultsFound() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "dffffdd");
		Reporter.log("Entered keyword : 'dffffdd'",true);
		waitUntilElementAppears(noResultsView);
		Assert.assertTrue(noResultsView.isDisplayed(), "'No results found' is not found");
		Reporter.log("'No results found' is showed",true);
	}

	@FindBy(css="div.exam_goal_logo")
	private WebElement guestGoalIcon;
	
	@FindBy(css="div.exam_goal_tooltip")
	private WebElement guestGoalToolTip;

	public void header_guestIcons() throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		clickEmbiumStatus();
		clickProfileIcon();
		mouseHoverOnElement(wdriver, guestGoalIcon, "Mouse Hovered on Goal Icon");
		Reporter.log("Guest user goal icon is '"+guestGoalToolTip.getText()+"'",true);
		Assert.assertTrue(login_Btn.isDisplayed(), "'Login Button' is not found");
		Reporter.log("Login button is present in the Search Home Page Header",true);
	}
	
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

	public void searchEngineSection(){
		Assert.assertTrue(searchSlogan.isDisplayed(), "'Search Engine label' is not found");
		Reporter.log("'Search Engine label' is present",true);
		Assert.assertTrue(search_TB.isDisplayed(), "'Search Engine' is not found");
		Reporter.log("'Search Text field' is present",true);
		Assert.assertTrue(chooseMission_Btn.isDisplayed(), "'Choose a Misson' Button is not found");
		Reporter.log("'Choose a Misson' button is present",true);
		Assert.assertTrue(findSomethingCool.isDisplayed(), "'Find Something Cool' is not found");
		Reporter.log("'Find Something Cool' is present",true);
	}
	
	@FindBy(xpath="//*[@class='search-container']/div/ul/li[@role='option']")
	private WebElement autoSearchList;

	public void autoFillSearchResults() throws InterruptedException, AWTException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "properties of tri");
		Thread.sleep(5000);
		Reporter.log("Entered keyword : 'properties of tri' ",true);
		Thread.sleep(2000);
		Reporter.log("Navigated to 'Search Result Page'",true);
		search_TB.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Assert.assertTrue(autoSearchList.isDisplayed(), "Auto search results is not displayed.");
		Reporter.log("Auto search results list is displayed",true);

	}

	@FindBy(xpath="//*[@title='Acceleration time graph']")
	private WebElement acclTimeGraph;

	public SearchResultsPage validSearchResult(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		/*HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword");*/ 
		waitUntilElementAppears(search_TB);
		String searchKeyword = "acc time";
		enterText(search_TB, searchKeyword);
		Reporter.log("Entered keyword : "+searchKeyword,true);
		waitUntilElementclickable(floatingKeywords.get(0));
		Reporter.log("Floating keywords are displayed",true);
		Thread.sleep(5000);
		Actions action = new Actions(wdriver);
		action.moveToElement(acclTimeGraph).click(acclTimeGraph).build().perform();	
		Thread.sleep(5000);
		Reporter.log("Clicked on 'Accleration Time Graph' floating keyword",true);
		return new SearchResultsPage(wdriver);
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
	
	//@FindBy(css="img.global-nav__logo:nth-child(1)")
	@FindBy(css="img.global-nav__logo:nth-child(2)")
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
	
	public void examLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[1]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Reporter.log("Page Title : " + examTitle.getText(), true);
		Assert.assertTrue(examTitle.isDisplayed(), "Exam page not loaded succesfully");
		title_examPageEmbibeLogo.click();
		Reporter.log("Clicked on Embibe logo",true);
		assertSearchHomepage();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	//@FindBy(css=".global-nav__left>a>img")
	@FindBy(css=".global-nav__left>a>img:nth-child(2)")
	private WebElement embibeLogo_Ask;
	
	@FindBy(css=".global-nav__left>a>img:nth-child(1)")
	private WebElement embibeLogo_Ask1;
	
	public void classesLinks(int i,String examType,String className,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[2]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Thread.sleep(3000);
		Assert.assertTrue(wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]")).isDisplayed(), "Navigation failed");
		WebElement classNum=wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]"));
		
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(), true);
		String classNam = classNum.getText();
		Reporter.log("Class Name : " + classNam, true);
		//Assert.assertTrue(classNum.isDisplayed(), "Test page not loaded succesfully");
		try{
			clickElement(embibeLogo_Ask);
		}
		catch(Exception e)
		{
			clickElement(embibeLogo_Ask1);
		}
		
		Reporter.log("Clicked on Embibe Logo", true);
		assertSearchHomepage();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
	}
	
	public void examsPageLogin(int i,String examType){
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div/div/div[5]/div[1]/div/div[2]/div[2]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
	}
	
	@FindBy(xpath="(//*[contains(text(),'Select an exam and test type to get started')])[1]")
	private WebElement testPageTitle;
	
	
	
	public void mockTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[3]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		Thread.sleep(2000);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Thread.sleep(5000);
		//Assert.assertTrue(testPageTitle.isDisplayed(), "Test page not loaded succesfully");
		clickExamPageEmbibeLogo();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	@FindBy(xpath="//*[contains(text(),'The only score improvement guarantee program')]")
	private WebElement rankupSignupPageTitle;
	
	
	public void crackTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[4]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertTrue(rankupSignupPageTitle.isDisplayed(), "Rankup signup not loaded succesfully");
		wdriver.close();
		Reporter.log("Closed the Rankup signup window",true);
		wdriver.switchTo().window(winHandleBefore);
	}
	
	public void resourcesTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(1000);
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div/div/div[4]/div[2]/div[1]/div/div[2]/div[5]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Thread.sleep(5000);
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Thread.sleep(5000);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		wdriver.close();
		Reporter.log("Closed the "+examType+" window",true);
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

	public LinkedHashMap<String, String> searchForDsl(boolean disambiguated, boolean dymValid, String keyword) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		LinkedHashMap<String, String> actualData = new LinkedHashMap<String, String>();
		waitUntilElementAppears(search_TB);
		search_TB.sendKeys(keyword);
		Reporter.log("Searching for: "+keyword, true);
		String text = "";
		if(!disambiguated && !dymValid){
			waitUntilElementclickable(floatingKeywords.get(0));
			if(getSearchHomepage())
				actualData.put("Target Page", "Search Home Page");
			int count = 0;
			for(int i=0;i<floatingKeywords.size();i++){
				String res = floatingKeyText.get(i).getAttribute("title");
				if(count==0)
					text = res;
				else
					text = text + "\n" + res;
				count++;
			}
			actualData.put("Actual Result", text);
		}
		return actualData;
	}
	
	public MyProfilePage referenceToMyProfilePage(){
		return new MyProfilePage(wdriver);
	}

	@FindBy(xpath="//div[@class='ask-heading']")
	private WebElement askPageTitle;
	
	public AskPage verifyAskLink() throws InterruptedException{
		clickAsk();
		waitUntilElementAppears(askPageTitle);
		Assert.assertTrue(askPageTitle.isDisplayed(),"Navigation failed to ask page");
		return new AskPage(wdriver);
	}

	@FindBy(css="div.swiper-button-next")
	private WebElement clickNext;
	
	@FindBy(css="div.swiper-button-prev")
	private WebElement clickPrev;
	
		public void searchFooterLinks(int i,String examType,String expURL) throws InterruptedException{
			Reporter.log("-------------------------------------------------------------------------------------------------",true);
			Thread.sleep(2000);
			clickElement(wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)["+i+"]")));
			Reporter.log("Clicked on "+ examType, true);
			String winHandleBefore = wdriver.getWindowHandle();
			for (String winHandle : wdriver.getWindowHandles()) {
				wdriver.switchTo().window(winHandle);
			}
			Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
			Reporter.log("Navigated to " + wdriver.getCurrentUrl(), true);
			Reporter.log("Page Title : '" + examTitle.getText(), true);
			//Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
			title_examPageEmbibeLogo.click();
			Reporter.log("Clicked on Embibe logo",true);
			assertSearchHomepage();
			wdriver.close();
			wdriver.switchTo().window(winHandleBefore);
		}
	
	public void clickNextSwiper() throws InterruptedException{
		waitUntilElementAppears(clickNext);
		Thread.sleep(2000);
		clickNext.click();
		Reporter.log("Clicked on swiper 'Next' button",true);
		Reporter.log("Swiped to Right side",true);
		
	}
	
	public void clickPrevSwiper() throws InterruptedException{
		waitUntilElementAppears(clickPrev);
		Thread.sleep(2000);
		clickPrev.click();
		Reporter.log("Clicked on swiper 'Prev' button",true);
		Reporter.log("Swiped to Left side",true);
	}
	
	public void assert_findSomethingCool() throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		waitUntilElementAppears(findSomethingCool);
		findSomethingCool.click();
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Clicked on 'Find Something Cool' option",true);
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to 'Blog Page'",true);
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		assertSearchHomepage();
	}
	
//	@FindBy(css="div.footer-div div.row.device-location ul li a")
	@FindBy(linkText="Use precise location")
 	private WebElement precise_location;
	
	@FindBy(css="div.footer-div div.row.device-location ul li")
	private WebElement locationName;
	
	@FindBy(css="div.searchfooter")
	private WebElement getviewpreciseLocation;
	
	
	public void assert_preciseLocation() throws Exception{
		scrollToElementViaJavascript(getviewpreciseLocation);
		Thread.sleep(3000);
		waitUntilElementAppears(precise_location);
		waitUntilElementclickable(precise_location);
		precise_location.click();
		Thread.sleep(3000);
		Reporter.log("Clicked on 'Use Precise Location' option",true);
		Thread.sleep(5000);
		Reporter.log("Obtained Location :"+locationName.getText(),true);
	}
	
	/*@FindBy(xpath="(//*[@class='footer-div']/div[3]/ul/li/a[@class='no-underline-link'])[1]")
	private WebElement aboutUs_footer;
	
	public void clickAboutUs(){
		clickElement();
	}*/
	
	
	
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
	
	//div.draggable img.kt-image
	@FindBy(css="kt-image")
	private WebElement hold_KT_graph_icon;
	
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
	}
	
	public void clickTwitterIcon() throws InterruptedException{
		scrollToElementViaJavascript(twitter_icon);
		waitUntilElementAppears(twitter_icon);
		Thread.sleep(2000);
		twitter_icon.click();
		Reporter.log("Clicked on 'Twitter' icon",true);
	}
	
	public void assertTwitterEmbibePage() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(wdriver.getCurrentUrl(), "https://twitter.com/embibe");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to twitter Page", true);
	}
	
	public void clickInstagramIcon() throws InterruptedException{
		scrollToElementViaJavascript(instagram_icon);
		waitUntilElementAppears(instagram_icon);
		Thread.sleep(2000);
		instagram_icon.click();
		Reporter.log("Clicked on 'Instagram' icon",true);
	}
	
	public void assertInstagramEmbibePage() throws InterruptedException{
		Thread.sleep(2000);
		Assert.assertEquals(wdriver.getCurrentUrl(), "https://www.instagram.com/embibe.me/");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to instagram Page", true);
	}
	
	public void clickYoutubeIcon() throws InterruptedException{
		scrollToElementViaJavascript(youtube_icon);
		waitUntilElementAppears(youtube_icon);
		Thread.sleep(2000);
		youtube_icon.click();
		Reporter.log("Clicked on 'Youtube' icon",true);
	}
	
	public void assertYoutubeEmbibePage(){
		waitUntilElementclickable(youtubePageHeader);
		Assert.assertTrue(youtubePageHeader.isDisplayed(), "Not navigated to youtube");
		Reporter.log("URL : " + wdriver.getCurrentUrl(),true);
		Reporter.log("Navigated to Youtube Page", true);
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

	public FootersPage loginFooters(){
		//login();
		return new FootersPage(wdriver);
		
	}
	
	public FootersPage footerLogins(){
		login();
		return new FootersPage(wdriver);	
	}
	
	@FindBy(xpath="//*[contains(text(),'LOGIN')]")
	private WebElement rankup_loginBtn;
	
	@FindBy(xpath="//*[@id='md-input-2-input']")
	private WebElement rankup_email;
	
	@FindBy(xpath="//*[@id='md-input-3-input']")
	private WebElement rankup_password;
	
	@FindBy(xpath="//*[contains(text(),'LOG IN')]")
	private WebElement rankup_submitBtn;
	
	public void clickRankupLoginBtn(){
		clickElement(rankup_loginBtn);
		enterText(rankup_email, "yashu@gmail.com");
		enterText(rankup_password, "1234567890");
		clickElement(rankup_submitBtn);
	}
	
	public LearnPage gotoLearnPage(){
		return new LearnPage(wdriver);
	}
	

	
	public PracticePage goToPracticePageEngineering() throws InterruptedException{
		Thread.sleep(2000);
		WebElement examName=wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)[1]"));
		waitUntilElementclickable(examName);
		clickElement(examName);
		Reporter.log("Clicked on "+ examName.getText(), true);
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		return new PracticePage(wdriver);
	}
	
	String medURL="https://www.embibe.com/medical/practice/solve";
	String engURL="https://www.embibe.com/engineering/practice/solve";
	
	public PracticePage goToPracticePage(String exam) throws InterruptedException{
		Thread.sleep(2000);
		if(exam.toString()=="Engineering")
		{
			wdriver.get(engURL);
		}
		else
		{
		}
		
		if(exam.toString()=="Medical"){
			wdriver.get(medURL);
		}
		else
		{
		}
		/*WebElement examName=wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)[1]"));
		waitUntilElementclickable(examName);
		clickElement(examName);
		Reporter.log("Clicked on "+ examName.getText(), true);
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}*/
		//Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		return new PracticePage(wdriver);
	}
	
	
}
