package moolya.embibe.pages.web.mobile;

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

public class TestPage extends W_BasePage {

	public TestPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//div[@class='test__map-left']//option[@selected='selected' and contains(text(),'Select exam')]/..")
	private WebElement selectExam_DD;

	@FindBy(xpath="//div[@class='test__map-left']//option[@selected='selected' and contains(text(),'Select test type')]/..")
	private WebElement selectTestType_DD;

	@FindBy(xpath="//div[@class='test__map-left']//option[@selected='selected' and contains(text(),'Select subject')]/..")
	private WebElement selectSubject_DD;

	@FindBy(xpath="(//div[@class='test__map-left']//option[@selected='selected' and contains(text(),'Select test')]/..)[2]")
	private WebElement selectTest_DD;
	
	@FindBy(xpath="//button[contains(text(),'Start Solving')]")
	private WebElement startSolving_Btn;
	
	@FindBy(xpath="//div[@class='phoenix-tile__front']/h3")
	private List<WebElement> tests_List ;
	
	//div[@class='phoenix-tile__front']/h3[contains(text(),'Motion in Two Dimension and Projectile Motion')]

	@FindBy(xpath="//div[contains(@class,'test_start') and contains(text(),'Start Test')]")
	private WebElement startTest_Btn;

	@FindBy(xpath="//button[text()='I am ready to begin']")
	private WebElement beginTest_Btn;

	@FindBy(xpath="//span[contains(@class,'test-sections__subject-label')]")
	private WebElement testStartSubject_Lbl;
	
	@FindBy(xpath="//button[text()='Save']")
	private WebElement saveAnswerChoice_Btn;
	
	@FindBy(xpath="//div[@class='question-map__attempts']/button")
	private List<WebElement> questionAttemps_List;
	
	@FindBy(xpath="//button[text()='Finish']")
	private WebElement finishTest_Btn;
	
	@FindBy(xpath="//div[@class='confirm_popup_finish confirm_popup_btn' and text()='Finish']")
	private WebElement confirmFinish_Btn;
	
	@FindBy(xpath="//a[text()='Next']")
	private WebElement next_Btn;
	
	@FindBy(xpath="(//a[@ng-click='closePopup()'])[2]")
	private WebElement closeLoginPopup_Btn;
	
	@FindBy(xpath="//div[@class='score-info']/span[2]")
	private WebElement testScore_Lbl;

	public void selectTest(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Test", uniqueValue);
		waitUntilElementclickable(selectExam_DD);
		selectDropdownText(selectExam_DD, data.get("Exam"));
		selectDropdownText(selectTestType_DD, data.get("Test Type"));
		selectDropdownText(selectSubject_DD, data.get("Subject"));
		Thread.sleep(2000);
		for(WebElement e:tests_List)
			if(e.getText().contains(data.get("Test"))){
				e.click();
				break;
			}
	}

	public void startTest(){
		waitUntilElementclickable(startTest_Btn);
		startTest_Btn.click();
		waitUntilElementclickable(beginTest_Btn);
		beginTest_Btn.click();
		waitUntilElementclickable(testStartSubject_Lbl);
	}

	public void chooseAnswers() throws InterruptedException{
		String choice = "A";
		for(int i=1;i<=30;i++){
			Thread.sleep(500);
			WebElement answer = wdriver.findElement(By.xpath("//test-question[@question-num='"+i+"']//span[text()='"+choice+"']"));
			scrollToElementViaJavascript(answer);
			Thread.sleep(500);
			answer.click();
			Thread.sleep(500);
			saveAnswerChoice_Btn.click();
		}
	}
	
	public void finishTest(){
		waitUntilElementclickable(finishTest_Btn);
		finishTest_Btn.click();
		waitUntilElementclickable(confirmFinish_Btn);
		confirmFinish_Btn.click();
	}
	
	public void clickNext(){
		waitUntilElementclickable(next_Btn);
		next_Btn.click();
	}
	
	public void closeLoginPopUp(){
		try{
			waitUntilElementclickable(closeLoginPopup_Btn, 30);
			closeLoginPopup_Btn.click();
		}catch(Exception e){}
	}
	
	public void getTestScore(){
		waitUntilElementAppears(testScore_Lbl);
		System.out.println(testScore_Lbl.getText().trim());
	}
	
}
