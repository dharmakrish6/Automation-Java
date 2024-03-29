package moolya.embibe.pages.web.mobile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ChooseMissionPage extends W_BasePage {

	public ChooseMissionPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".Dropdown-placeholder")
	private WebElement chooseCountry_DD;
	
	@FindBy(css=".Dropdown-control+div>div:nth-child(1)")
	private WebElement countryIndia;
	
	@FindBy(css=".Dropdown-control+div>div:nth-child(2)")
	private WebElement countryChina;
	
	@FindBy(css=".goals>a:nth-child(1)")
	private WebElement missionGoalBanking;
	
	@FindBy(css=".goals>a:nth-child(2)")
	private WebElement missionGoalEngineering;
	
	@FindBy(css=".goals>a:nth-child(3)")
	private WebElement missionGoalMedical;
	
	@FindBy(css=".missionselector h3")
	private WebElement chooseMissionHeader;
	
	@FindBy(css=".selectgoal")
	private WebElement selectGoal_Lbl;
	
	@FindBy(css=".mission-tag")
	private WebElement missionsAvailable_Lbl;
	
	@FindBy(css=".swiper-slide.select-goal:nth-child(1)")
	private WebElement missionBitsat;
	
	@FindBy(css=".swiper-slide.select-goal:nth-child(2)")
	private WebElement missionJeeAdvanced;
	
	@FindBy(css=".swiper-slide.select-goal:nth-child(3)")
	private WebElement missionJeeMain;
	
	@FindBy(css=".help-url")
	private WebElement requestMission_Btn;
	
	@FindBy(id="missionsearch")
	private WebElement missionSearch_TB;
	
	@FindBy(css=".missionselector h3")
	private WebElement specifyExams_Lbl;
	
	@FindBy(css=".mission-desc")
	private WebElement specifyExamMessage_Lbl;
	
	@FindBy(css=".exam-list.show .exam-data")
	private List<WebElement> examSearch_List;
	
	@FindBy(css=".exam-list.show .exam-data:nth-child(1)")
	private WebElement examSearchList_Item1;
	
	@FindBy(css=".selected-exams")
	private WebElement selectedExam;
	
	@FindBy(css=".selected-exams")
	private List<WebElement> selectExams;
	
	@FindBy(css=".missionSearchClear")
	private WebElement missionSearchBack_Btn;
	
	@FindBy(css=".missionSearchSubmit")
	private WebElement missionSearchSubmit_Btn;
	
	@FindBy(css=".selectmission.missionresponse.show>img")
	private WebElement requestMissionSentImage;
	
	@FindBy(css=".selectmission.missionresponse.show>h3")
	private WebElement thankYouMessage_Lbl;
	
	@FindBy(css=".selectmission.missionresponse.show>h3+p")
	private WebElement requestMissionSentMessage_Lbl;
	
	@FindBy(css=".selectmission.missionresponse.show>h3+p+a")
	private WebElement goToChooseMission_Btn;
	
	@FindBy(css=".mission-modal>button")
	private WebElement missionClose_Btn;
	
	@FindBy(css=".missionselector+div>h4")
	private WebElement youAreInChina_Lbl;
	
	@FindBy(css=".mission-desc")
	private WebElement chinaMessage_Lbl;
	
	@FindBy(css=".requestmission")
	private WebElement chinaRequestMission_Btn;
	
	public void getPixelDataChooseMission() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(chooseMissionHeader);
		getPixelData("Data", "201.2.1(D)", chooseMissionHeader, "chooseMissionHeader");
		getPixelData("Data", "201.2.1(D)", chooseCountry_DD, "chooseCountry_DD");
		getPixelData("Data", "201.2.1(D)", selectGoal_Lbl, "selectGoal_Lbl");
		getPixelData("Data", "201.2.1(D)", missionGoalEngineering, "missionGoalEngineering");
		getPixelData("Data", "201.2.1(D)", missionGoalBanking, "missionGoalBanking");
		getPixelData("Data", "201.2.1(D)", missionGoalMedical, "missionGoalMedical");
		getPixelData("Data", "201.2.1(D)", missionsAvailable_Lbl, "missionsAvailable_Lbl");
		getPixelData("Data", "201.2.1(D)", missionJeeMain, "missionJeeMain");
		getPixelData("Data", "201.2.1(D)", missionJeeAdvanced, "missionJeeAdvanced");
		getPixelData("Data", "201.2.1(D)", missionBitsat, "missionBitsat");
		getPixelData("Data", "201.2.1(D)", requestMission_Btn, "requestMission_Btn");
	}
	
	public void clickRequestMission(){
		waitUntilElementclickable(requestMission_Btn);
		requestMission_Btn.click();
	}
	
	public void requestMission(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("ChooseMissionPage", uniqueValue);
		String missionName = data.get("Request Mission");
		missionSearch_TB.sendKeys(missionName);
		Reporter.log("Enter Mission: "+missionName, true);
		for(WebElement e:examSearch_List)
			if(e.getText().equalsIgnoreCase(missionName)){
				e.click();
				Reporter.log("Clicked Mission: "+missionName, true);
				break;
			}
		waitUntilElementAppears(selectedExam);
		Assert.assertTrue(selectedExam.getText().equalsIgnoreCase(missionName), "Mission Selection not successful!");
		missionSearchSubmit_Btn.click();
		Reporter.log("Clicked on Submit", true);
		waitUntilElementAppears(thankYouMessage_Lbl);
		Assert.assertTrue(thankYouMessage_Lbl.isDisplayed(), "Request Mission not successful!");
	}
	
	public void getPixelDataRequestMission() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(specifyExams_Lbl);
		getPixelData("Data", "201.2.4(D)", specifyExams_Lbl, "specifyExams_Lbl");
		getPixelData("Data", "201.2.4(D)", specifyExamMessage_Lbl, "specifyExamMessage_Lbl");
		missionSearch_TB.sendKeys("cet");
		waitUntilElementclickable(examSearchList_Item1);
		examSearchList_Item1.click();
		waitUntilElementAppears(selectedExam);
		getPixelData("Data", "201.2.4(D)", selectedExam, "selectedExam");
		getPixelData("Data", "201.2.4(D)", missionSearchBack_Btn, "missionSearchBack_Btn");
		getPixelData("Data", "201.2.4(D)", missionSearchSubmit_Btn, "missionSearchSubmit_Btn");
		missionSearchSubmit_Btn.click();
		waitUntilElementAppears(requestMissionSentImage);
		getPixelData("Data", "201.2.5(D)", requestMissionSentImage, "requestMissionSentImage");
		getPixelData("Data", "201.2.5(D)", thankYouMessage_Lbl, "thankYouMessage_Lbl");
		getPixelData("Data", "201.2.5(D)", requestMissionSentMessage_Lbl, "requestMissionSentMessage_Lbl");
		getPixelData("Data", "201.2.5(D)", goToChooseMission_Btn, "goToChooseMission_Btn");
		getPixelData("Data", "201.2.5(D)", missionClose_Btn, "missionClose_Btn");
	}
	
	public void clickGoToChooseMission(){
		waitUntilElementclickable(goToChooseMission_Btn);
		goToChooseMission_Btn.click();
	}
	
	public void selectChina(){
		waitUntilElementclickable(chooseCountry_DD);
		chooseCountry_DD.click();
		countryChina.click();
	}

	@FindBy(css = ".Dropdown-option")
	private List<WebElement> counrtyList;
	
	@FindBy(xpath="//div[@class='selectmission null']/div/div/following::p[1]")
	private WebElement assertChinaMisson;
	
	public void countryDropdown(String country) throws InterruptedException{
		Assert.assertTrue(chooseCountry_DD.isDisplayed(), "'Country' dropdown is not present");
		clickElement(chooseCountry_DD);
		selectItemFromList(counrtyList, country);
		Reporter.log("Country '"+country+"' is selected", true);
	}
	
	@FindBy(xpath="//a[@class='requestmission']")
	private WebElement chinaRequestMission;
	
	public void chinaRequestMission() {
		clickElement(chinaRequestMission);
	}
	
	public void assertChinaRequestMissionWarning(){
		String expectedAssertText="We are working on making missions available for your country. Help us fast track Mission launches for your country by requesting a mission below:";
		String actualAssertText=assertChinaMisson.getText();
		Assert.assertEquals(actualAssertText,expectedAssertText);
	}
	
	public SearchHomepage clickMissionClose(){
		waitUntilElementclickable(missionClose_Btn);
		missionClose_Btn.click();
		return new SearchHomepage(wdriver);
	}
	
	public void getPixelDataCountryChina() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(youAreInChina_Lbl);
		getPixelData("Data", "201.2.6(D)", youAreInChina_Lbl, "youAreInChina_Lbl");
		getPixelData("Data", "201.2.6(D)", chinaMessage_Lbl, "chinaMessage_Lbl");
		getPixelData("Data", "201.2.6(D)", chinaRequestMission_Btn, "chinaRequestMission_Btn");
	}
	
	@FindBy(css = ".goal")
	private List<WebElement> goalList;

	@FindBy(css = ".goal-selectors")
	private List<WebElement> goalselectors;

	@FindBy(xpath = "//div[@class='goal-selectors']/div/div/a[@data-value]")
	private List<WebElement> specificGoalsListsName;
	
	@FindBy(xpath = "//div[@class='goal-selectors']/div/div/a")
	private List<WebElement> specificGoalsListsNumber;
	
	@FindBy(css = "a.swiper-button-next")
	private WebElement goalNextBtn;
	
	@FindBy(css = "div.goals")
	private WebElement selectGoalText;
	
	public void selectGoal(String goal) throws InterruptedException{
		selectItemFromList(goalList, goal);
		Reporter.log("\n"+"Selected '" + goal + "' as a goal", true);
		Reporter.log("Number of Links : " + specificGoalsListsNumber.size(), true);
		List<WebElement> list = specificGoalsListsName;
		for (WebElement element : list) {
			String link = element.getAttribute("href");
			Reporter.log("Mission : " + element.getAttribute("textContent") + "  |  Link : " + link, true);
		}
	}

	@FindBy(xpath="(//*[@class='goals']/following-sibling::p)[1]")
	private WebElement defaultGoalText;
	
	public void defaultGoal(){
		String mission=defaultGoalText.getText();
		Reporter.log("The default goal for guest user is : " + mission,true);
		Assert.assertEquals(mission, "Missions Available for Engineering");
	}
	
	@FindBy(xpath="//*[@class='goal-selectors']/div/div/a[1]")
	private WebElement selectFirstExam;
	
	public void signUpInRankUpPage() throws InterruptedException{
		clickElement(selectFirstExam);
		Reporter.log("Clicked on exam and Navigated to Rankup page",true);
		Thread.sleep(3000);
	}
	
	@FindBy(xpath="//*[@id='missionsearch']")
	private WebElement enterExamField;
	
	@FindBy(xpath="//div[@id='enterExam']")
	private WebElement submitExamButton;
	
	@FindBy(css="ul.exam-list.show li")
	private List<WebElement> examLists;
	
	@FindBy(css="ul.exam-list li:nth-child(1)")
	private WebElement selectFirstListItem;
	
	@FindBy(xpath="//*[text()='Submit']")
	private WebElement submitSpecifyExam;
	
	@FindBy(xpath="//*[contains(text(),'Thank You!')]")
	private WebElement thankYouText;
	
	public void submitExam(String exam)throws InterruptedException{
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam +"' in search engine",true);
		clickElement(selectFirstListItem);
		Reporter.log("Selected the first item in the list",true);
		clickElement(submitSpecifyExam);
		Reporter.log("Clicked on Submit button",true);
		Thread.sleep(5000);
		Assert.assertTrue(thankYouText.isDisplayed(), "Failed to Request a Mission.");
		Reporter.log("'Request Mission' sent successfully",true);
		clickElement(goToChooseMission_Btn);
	}
	
	@FindBy(xpath="//*[@class='study']")
	private WebElement studyLink;
	
	public SearchHomepage chinaStudy(){
		clickElement(studyLink);
		Reporter.log("Clicked on 'STUDY'",true);
		assertSearchHomepage();
		return new SearchHomepage(wdriver);
	}
	
	@FindBy(xpath="//*[@class='goal-selectors']/following::a[contains(text(),'Request a Mission')]")
	private WebElement indiaRequestMission;
	
	public void indiaRequestMission(){
		clickElement(indiaRequestMission);
	}
	
	public void enterExam(String  exam) throws InterruptedException{
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		Thread.sleep(3000);
		List<WebElement> list = examLists;
		Reporter.log("Number of related searched exams :  " + examLists.size(),true);
		Reporter.log("Related Exams : " ,true);
		for (WebElement element : list) {
			JavascriptExecutor jse = (JavascriptExecutor) wdriver;
			jse.executeScript("scroll(250, 0)");
			Reporter.log(element.getText(), true);
		}
		Thread.sleep(2000);
	}
	
	@FindBy(xpath="//*[@id='enterExam']")
	private WebElement addNewExam;
	
	@FindBy(xpath="//*[@class='selected-exams']")
	private WebElement newlyAddedExamList;
	
	public void addNewExam(String newExam) throws InterruptedException{
		enterText(enterExamField, newExam);
		Reporter.log("Entered : "+newExam,true);
		clickElement(addNewExam);
		Assert.assertTrue(newlyAddedExamList.isDisplayed(),"Failed to add the exam into list");
		Reporter.log(newlyAddedExamList.getText()+" is available in the added list",true);
		clickElement(submitSpecifyExam);
		Assert.assertTrue(thankYouText.isDisplayed(), "Failed to Request a Mission.");	
		Thread.sleep(3000);	
	}
	
	public void verifyAutosuggestionList(String exam) throws InterruptedException{
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		Thread.sleep(3000);
		List<WebElement> list1 = examLists;
		int list1Count= examLists.size();
		Reporter.log("Number of related searched exams :  " + list1Count,true);
		Reporter.log("Related Exams : " ,true);
		for (WebElement element : list1) {
			JavascriptExecutor jse = (JavascriptExecutor) wdriver;
			jse.executeScript("scroll(250, 0)");
			Reporter.log(element.getText(), true);
		}
		Thread.sleep(5000);
		
		clickElement(selectFirstListItem);
		Reporter.log("Selected the first item in the list",true);
		List<WebElement> list2 = examLists;
		int list2Count= examLists.size();
		Reporter.log("Number of related searched exams :  " + list2Count,true);
		Reporter.log("Related Exams : " ,true);
		for (WebElement element : list2) {
			JavascriptExecutor jse = (JavascriptExecutor) wdriver;
			jse.executeScript("scroll(250, 0)");
			Reporter.log(element.getText(), true);
		}
		Thread.sleep(5000);
		if (list1Count>list2Count){
			Reporter.log("The selected exam is removed successfully from the autosuggestion list",true);
		}
		else
			Reporter.log("Failed to remove the selected exam from the autosuggestion list",true);
	}
	
	@FindBy(xpath="//*[@id='missionSearchError']")
	private WebElement maxSelectionError;
	
	public void maxExamSelection(String exam) throws InterruptedException{
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		
		for(int i=0;i<=10;i++){
			String maxError=maxSelectionError.getText();
			if(!maxSelectionError.isDisplayed())
			{
				String firstItem=selectFirstListItem.getText();
				clickElement(selectFirstListItem);
				Reporter.log("Selected '"+firstItem+"'",true);
			}
			else
				Reporter.log("'"+maxError+"'",true);	
		}
		Thread.sleep(5000);
	}
	
	@FindBy(xpath="//*[@class='missionSearchClear']")
	private WebElement requestBackButton;
	
	public void requestBackToChooseMissionPage(String exam) throws InterruptedException{	
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		clickElement(selectFirstListItem);
		Reporter.log("Selected the first item in the list",true);
		Thread.sleep(3000);
		clickElement(requestBackButton);
		Reporter.log("Clicked on 'Back'  button",true);
		Assert.assertTrue(defaultGoalText.isDisplayed(), "Failed to navigate for 'Choose a Mission window'");
		Reporter.log("Navigated for 'Choose a Mission window' successfully",true);
		Thread.sleep(3000);
	}
	
	public void assertClearSearchExamSelection(String exam) throws InterruptedException{
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		clickElement(selectFirstListItem);
		Reporter.log("Selected the first item in the list",true);
		Thread.sleep(2000);
		List<WebElement> list1 = examLists;
		int list1Count= list1.size();
		Reporter.log("Number of related searched exams :  " + list1Count,true);
		Thread.sleep(2000);
		clickElement(requestBackButton);
		Reporter.log("Clicked on 'Back' button",true);
		Assert.assertTrue(defaultGoalText.isDisplayed(), "Failed to navigate for 'Choose a Mission window'");
		Thread.sleep(2000);
		clickElement(indiaRequestMission);
		Reporter.log("Cliked on 'Request a Mission'",true);
		List<WebElement> list2 = examLists;
		int list2Count= list2.size();
		Reporter.log("Number of related searched exams :  " + list2Count,true);
		Thread.sleep(2000);
		Assert.assertTrue(list1Count > list2Count, "Failed to clear the exam search field");
		Reporter.log("Exam search field is cleared successfully",true);
	}
	
	public void addExam(String exam) throws InterruptedException{
		enterText(enterExamField, exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		Thread.sleep(2000);
		List<WebElement> list1 = examLists;
		int list1Count= examLists.size();
		Reporter.log("Number of related searched exams :  " + list1Count,true);
		Reporter.log("Related Exams : " ,true);
		for (WebElement element : list1) {
			JavascriptExecutor jse = (JavascriptExecutor) wdriver;
			jse.executeScript("scroll(250, 0)");
			Reporter.log(element.getText(), true);
		}
		String item = selectFirstListItem.getText();
		Reporter.log("Selecting an '"+item+"' exam in the list",true);
		clickElement(selectFirstListItem);
		List<WebElement> list2 = examLists;
		int list2Count= examLists.size();
		Reporter.log("Number of related searched exams :  " + list2Count,true);
		Reporter.log("Related Exams : " ,true);
		for (WebElement element : list2) {
			JavascriptExecutor jse = (JavascriptExecutor) wdriver;
			jse.executeScript("scroll(250, 0)");
			Reporter.log(element.getText(), true);
		}	
	}
	
	@FindBy(css="div.examresult span:nth-child(1)")
	private WebElement removeSelectedExams;
	
	public void removeExam() throws InterruptedException{
		String item = removeSelectedExams.getText();
		Reporter.log("'"+item+"' exam removed successfully",true);
		clickElement(removeSelectedExams);
		List<WebElement> list1 = examLists;
		int list1Count= examLists.size();
		Reporter.log("Number of related searched exams :  " + list1Count,true);
		Reporter.log("Related Exams : " ,true);
		for (WebElement element : list1) {
			JavascriptExecutor jse = (JavascriptExecutor) wdriver;
			jse.executeScript("scroll(250, 0)");
			Reporter.log(element.getText(), true);
		}
		Thread.sleep(2000);
	}
	
	public void clearDropdown(String exam) throws InterruptedException{
		enterText(enterExamField,exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		clickElement(submitExamButton);
		Reporter.log("Clicked on exam submit button",true);
		int list1Count= examLists.size();
		Reporter.log("Number of related searched exams :  " + list1Count+" Drop down is not present",true);
	}	
	
	public void submitSpecifiedExam(String exam) throws InterruptedException{
		enterText(enterExamField,exam);
		Reporter.log("Entered '"+exam+"' in the search field",true);
		String item = selectFirstListItem.getText();
		Reporter.log("Selecting an '"+item+"' exam in the list",true);
		clickElement(selectFirstListItem);
		clickElement(submitSpecifyExam);
		Reporter.log("Clicked on exam submit button",true);
		Assert.assertTrue(thankYouText.isDisplayed(), "Failed to Request a Mission.");	
		Reporter.log("Mission request has been successfully submitted and Thank you message is displayed",true);
		Thread.sleep(3000);	
	}
	
	@FindBy(xpath="//*[contains(text(),'Thank You!')]/following::a[contains(text(),'Go to Choose a mission')]")
	private WebElement gotoChooseMission;
	
	public void gotoChooseMissionInThankYouPage(){
		clickElement(gotoChooseMission);
		Reporter.log("Clicked on 'Go to Choose a mission'",true);
		defaultGoal();
	}
}
