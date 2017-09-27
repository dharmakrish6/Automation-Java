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
	
	@FindBy(css=".missionselector+h4")
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
	
	
	
	
	
	
	
	
	

}
