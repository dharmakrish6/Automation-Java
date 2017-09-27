package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	@FindBy(css=".text-center.mission>a")
	private WebElement chooseMission_Btn;
	
	public void search(){
		enterText(search_TB, "Rotational");
		
	}
	
	public void assertSearchHomepage(){
		waitUntilElementclickable(search_TB);
		Assert.assertTrue(search_TB.isDisplayed(), "Not in Search Homepage");
		Reporter.log("Naviagted to Search HomePage", true);
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
	
}
