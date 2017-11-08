package moolya.embibe.pages.web;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
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
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);
		Reporter.log("Entered : "+searchKeyword,true);
		//search_TB.clear();
		for(int i=0;i<=10;i++){
			search_TB.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(3000);
		}

		Thread.sleep(5000);
		Reporter.log("Cleared the search field",true);
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertEquals(floatingKeywords.size(),0 );
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
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);

		Thread.sleep(5000);
		Actions action = new Actions(wdriver);
		//action.moveToElement(rotMotionFirst).click(rotMotionFirst).build().perform();
		action.moveToElement(rotMotionFirst).contextClick(rotMotionFirst).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		Thread.sleep(1000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		System.out.println("opened  'rotational motion' in new tab");
		Thread.sleep(2000);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
			Reporter.log("Switched to New Tab", true);
		}
		Thread.sleep(2000);
		/*wdriver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);*/

	}

	public void wrongKeywordInSearchField() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "rtati");
		Reporter.log("Entered wrong Spelling : 'rtati'" ,true);
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(5000);
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertFalse(floatingKeywords.size()==0, "No suggestions are available");
	}

	public void correctKeywordInSearchField() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		search_TB.clear();
		Thread.sleep(2000);
		enterText(search_TB, "orga");
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(5000);
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertFalse(floatingKeywords.size()==0, "No suggestions are available");
	}


	public void noResultsFound() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "dffffdd");
		waitUntilElementAppears(noResultsView);
		Assert.assertTrue(noResultsView.isDisplayed(), "'No results found' is not found");
	}

	@FindBy(xpath="//*[@class='exam_goal_logo']")
	private WebElement guestGoalIcon;

	public void header_guestIcons() throws InterruptedException{
		clickEmbiumStatus();
		clickProfileIcon();
		guestGoalIcon.equals("?");
		Reporter.log("Guest user goal icon is '"+guestGoalIcon.getText()+"'",true);
		Assert.assertTrue(login_Btn.isDisplayed(), "'Login Button' is not found");
		Reporter.log("Login button is present in the Search Home Page Header",true);
	}

	public void searchEngineSection(){
		Assert.assertTrue(searchSlogan.isDisplayed(), "'Search Engine label' is not found");
		Reporter.log("'Search Engine label' is present in the Search Home Page",true);
		Assert.assertTrue(search_TB.isDisplayed(), "'Search Engine' is not found");
		Reporter.log("Search Engine' is present in the Search Home Page",true);
		Assert.assertTrue(chooseMission_Btn.isDisplayed(), "'Choose a Misson' Button is not found");
		Reporter.log("'Choose a Misson' button is present in the Search Home Page",true);
		Assert.assertTrue(findSomethingCool.isDisplayed(), "'Find Something Cool' is not found");
		Reporter.log("'Find Something Cool' is present in the Search Home Page",true);
	}
	
	@FindBy(xpath="//*[@class='search-container']/div/ul/li[@role='option']")
	private WebElement autoSearchList;

	public void autoFillSearchResults() throws InterruptedException, AWTException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "proper");
		Reporter.log("Entered : 'proper' ",true);
		Thread.sleep(2000);
		search_TB.sendKeys(Keys.BACK_SPACE);
		Thread.sleep(2000);
		Assert.assertTrue(autoSearchList.isDisplayed(), "Auto search results is not displayed.");
		Reporter.log("Auto search results is displayed",true);

	}

	@FindBy(xpath="//*[@title='Acceleration time graph']")
	private WebElement acclTimeGraph;

	public SearchResultsPage validSearchResult(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);

		Thread.sleep(5000);
		Actions action = new Actions(wdriver);
		action.moveToElement(acclTimeGraph).click(acclTimeGraph).build().perform();	
		Thread.sleep(5000);
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
	
	public void examLinks(int i,String examType,String expURL) throws InterruptedException{
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
		Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\n Page Title : '" + examTitle.getText() + "' is displayed", true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}
	
	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;
	
	public void classesLinks(int i,String examType,String className,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(precise_location);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[2]/ul/li/a)["+i+"]")));
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
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		Thread.sleep(2000);
	}
	
	public void examsPageLogin(int i,String examType){
		scrollToElementViaJavascript(scrolltoExams);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[5]/div[1]/div/div[2]/div[2]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
	}
	
	@FindBy(xpath="//option[@value=0 AND @selected='selected']")
	private WebElement examPage_Default_DropdownName;
	
	public void mockTestsLinks(int i,String examType,String expURL) throws InterruptedException{
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
	
	public void resourcesTestsLinks(int i,String examType,String expURL) throws InterruptedException{
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

	public boolean getSearchHomepage(){
		try {
			waitUntilElementclickable(search_TB);
			return search_TB.isDisplayed();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return false;
		}
	}

	public LinkedHashMap<String, String> searchForDsl(boolean disambiguated, String keyword) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		LinkedHashMap<String, String> actualData = new LinkedHashMap<String, String>();
		waitUntilElementAppears(search_TB);
		search_TB.sendKeys(keyword);
		Reporter.log("Searching for: "+keyword, true);
		String text = "";
		if(!disambiguated){
			actualData.put("Disambiguated", "false");
			waitUntilElementclickable(floatingKeywords.get(0));
			if(getSearchHomepage())
				actualData.put("Target Page", "Search Home Page");
			int count = 0;
			for(int i=0;i<floatingKeywords.size();i++){
				String res = floatingKeyText.get(i).getAttribute("title");
				if(count==0)
					text = res;
				else
					text = text + "," + res;
				count++;
			}
			actualData.put("Actual Result", text);
		}
		else
			actualData.put("Disambiguated", "true");
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
		Reporter.log("Navigated to 'Ask' page",true);
		return new AskPage(wdriver);
	}
	
	
	
	@FindBy(xpath="//a[@href='/home']/img")
	private WebElement embibeLogo_Jump;
	
	public void clickJumpEmbibeLogo(){
		waitUntilElementclickable(embibeLogo_Jump);
		embibeLogo_Jump.click();
		Reporter.log("Clicked on Embibe Logo", true);
	}
	
	@FindBy(css="a.navbarbrand.logo")
	private WebElement embibeLogo_RankUp;
	
	public void clickRankupEmbibeLogo(){
		waitUntilElementclickable(embibeLogo_RankUp);
		embibeLogo_RankUp.click();
		Reporter.log("Clicked on Embibe Logo", true);
	}
	
	@FindBy(css="span>img.logo")
	private WebElement embibeLogo_Institute;

	@FindBy(css="span.hd-institute")
	private WebElement insitituePageHeader;
	
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
	
	@FindBy(css="div.swiper-button-next")
	private WebElement clickNext;
	
	@FindBy(css="div.swiper-button-prev")
	private WebElement clickPrev;
	
		public void searchFooterLinks(int i,String examType,String expURL) throws InterruptedException{
			Reporter.log("----------------------------------------------------------------------------------------------",true);
			Thread.sleep(2000);
			clickElement(wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)["+i+"]")));
			Reporter.log("Clicked on "+ examType, true);
			String winHandleBefore = wdriver.getWindowHandle();
			for (String winHandle : wdriver.getWindowHandles()) {
				wdriver.switchTo().window(winHandle);
			}
			Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
			Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\nPage Title : '" + examTitle.getText() + "' is displayed", true);
			Thread.sleep(2000);
			//Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
			clickExamPageEmbibeLogo();
			wdriver.close();
			wdriver.switchTo().window(winHandleBefore);
		}
	
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
	
//	@FindBy(css="div.footer-div div.row.device-location ul li a")
	@FindBy(linkText="Use precise location")
 	private WebElement precise_location;
	
	@FindBy(css="div.footer-div div.row.device-location ul li")
	private WebElement locationName;
	
	
	public void assert_preciseLocation() throws Exception{
		waitUntilElementAppears(precise_location);
		precise_location.click();
		Thread.sleep(1000);
		Reporter.log("Clicked on 'Use Precise Location' option",true);
		Thread.sleep(1000);
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

	


}