package moolya.embibe.pages.web;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.HashMap;
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

	public void search(){
		enterText(search_TB, "Rotational");
	}

	public LoginPage clickLoginBtn(){
		clickLogin();
		return new LoginPage(wdriver);

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
		waitUntilElementclickable(floatingKeywords.get(0));
		Thread.sleep(5000);
		Reporter.log("The number of floating keywords are: "+ floatingKeywords.size(),true);
		Assert.assertFalse(floatingKeywords.size()==0, "No suggestions are available");
	}

	public void correctKeywordInSearchField() throws InterruptedException{
		waitUntilElementAppears(search_TB);
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

	@FindBy(xpath="//div[text()='Engineering']/..")
	private WebElement engGuestIcon;

	public void engineeringGuest(){
		engGuestIcon.equals("E");
		Reporter.log("Guest user is in Engineering domain",true);
	}

	@FindBy(xpath="//*[@class='search-container']/div/ul/li[@role='option']")
	private WebElement autoSearchList;

	public void autoFillSearchResults() throws InterruptedException, AWTException{
		waitUntilElementAppears(search_TB);
		enterText(search_TB, "proper");
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_DOWN);
		robot.keyRelease(KeyEvent.VK_DOWN);
		Thread.sleep(3000);
		Assert.assertTrue(autoSearchList.isDisplayed(), "Auto search results is not displayed.");

	}

	@FindBy(xpath="//*[@title='Acceleration time graph']")
	private WebElement acclTimeGraph;

	public void validSearchResult(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(search_TB);
		String searchKeyword = data.get("Search Keyword"); 
		enterText(search_TB, searchKeyword, "Searching for: "+searchKeyword);

		Thread.sleep(5000);
		Actions action = new Actions(wdriver);
		action.moveToElement(acclTimeGraph).click(acclTimeGraph).build().perform();	
		Thread.sleep(5000);
	}

	@FindBy(xpath="//*[@class='entry-title']")
	private WebElement examTitle;

	@FindBy(css="div.swiper-slide:nth-child(2)")
	private WebElement scrolltoExams;

	@FindBy(xpath="(//*[@id='root']/div/div[2]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li/a)[1]")
	private WebElement jeelink;

	@FindBy(xpath="//*[@class='site-title']/a")
	private WebElement examPageEmbibeLogo;

	public void examLinks(int i,String examType) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		refreshPage();
		Thread.sleep(5000);
		scrollToElementViaJavascript(scrolltoExams);
		Thread.sleep(5000);
		clickElement(wdriver.findElement(By.xpath("(//*[@id='root']/div/div[2]/div/div[4]/div[1]/div/div[1]/div[1]/ul/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		Reporter.log("Navigated to " + wdriver.getCurrentUrl() +"\n '" + examTitle.getText() + "' is displayed", true);
		clickElement(examPageEmbibeLogo);
		Reporter.log("Clicked on Embibe Logo", true);
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		Thread.sleep(10000);
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

	public HashMap<String,Object> searchForDsl(boolean disambiguated, String keyword) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, Object> actualData = new HashMap<String, Object>();
		waitUntilElementAppears(search_TB);
		search_TB.sendKeys(keyword);
		Reporter.log("Searching for: "+keyword, true);
		String text = "";
		if(!disambiguated){
			actualData.put("Disambiguated", false);
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
			actualData.put("Disambiguated", true);
		return actualData;
	}




	/*public void choosemission() throws InterruptedException{
		waitUntilElementAppears(search_TB);
		assertSearchHomepage();
		Assert.assertTrue(chooseMission_Btn.isDisplayed(), "'Choose a Mission' option is not present");
		Reporter.log("'Choose a Mission' is present", true);
		clickElement(chooseMission_Btn);
		Assert.assertTrue(selectGoalText.isDisplayed(), "'Choose a Misson' window is not opened.");
	}*/	

}