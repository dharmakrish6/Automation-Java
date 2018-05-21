package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import com.testautomationguru.ocular.snapshot.Snap;

import moolya.embibe.utils.JavaUtils;

@Snap(value="LandingPage-#{Element}.png")
public class SinhalTestsPage extends W_BasePage {

	public SinhalTestsPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".header-container .login")
	private WebElement login_Btn;
	
	@FindBy(id="emailArea")
	private WebElement email_TB;
	
	@FindBy(id="passwordArea")
	private WebElement password_TB;
	
	@FindBy(css=".loginBtn")
	private WebElement loginSubmit_Btn;
	
	@FindBy(css="button.instructions__nav-btn")
	private WebElement beginBtn;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;
	
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
	
	public void loginToSinhal(String email, String password){
		waitUntilElementclickable(login_Btn);
		login_Btn.click();
		waitUntilElementAppears(email_TB);
		email_TB.sendKeys(email);
		password_TB.sendKeys(password);
		waitUntilElementclickable(loginSubmit_Btn);
		loginSubmit_Btn.click();
	}
	
	public void beginTest(){
		clickElement(beginBtn);
		Reporter.log("Started Test", true);
	}
	
	public void takeTest(HashMap<String, String> examData, String fileName) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		String optionXpath = "//test-question[not(contains(@class,'ng-hide'))]//li//span[text()='inputOption']";
		String integerCss = "test-question:not(.ng-hide) .integer-option-block-each label";
		int noOfQuestions = Integer.parseInt(examData.get("question_count"));
		int sub1Count = 0,sub2Count = 0, sub3Count = 0;
		String subject1 = "", subject2 = "", subject3 = "";
		waitUntilElementclickable(saveBtn);
		if(examData.get("Goal").equals("engineering")){
			subject1 = "Physics";
			subject2 = "Chemistry";
			subject3 = "Mathematics";
		}else if(examData.get("Goal").equals("medical")){
			subject1 = "Physics";
			subject2 = "Chemistry";
			subject3 = "Biology";
		}
		long waitTime = 0;
		ArrayList<Integer> sub1Nos = new ArrayList<Integer>();
		ArrayList<Integer> sub2Nos = new ArrayList<Integer>();
		ArrayList<Integer> sub3Nos = new ArrayList<Integer>();
		if(noOfQuestions == 60){
			sub1Count = 20;
			sub2Count = 20;
			sub3Count = 20;
			sub1Nos = JavaUtils.generateNrandomNumbers(3, 20);
			sub2Nos = JavaUtils.generateNrandomNumbers(3, 20);
			sub3Nos = JavaUtils.generateNrandomNumbers(3, 20);
			waitTime = 140000;
		}else if(noOfQuestions == 90){
			sub1Count = 30;
			sub2Count = 30;
			sub3Count = 30;
			sub1Nos = JavaUtils.generateNrandomNumbers(5, 30);
			sub2Nos = JavaUtils.generateNrandomNumbers(5, 30);
			sub3Nos = JavaUtils.generateNrandomNumbers(5, 30);
			waitTime = 90000;
		}else if(noOfQuestions == 180){
			sub1Count = 45;
			sub2Count = 45;
			sub3Count = 90;
			sub1Nos = JavaUtils.generateNrandomNumbers(8, 45);
			sub2Nos = JavaUtils.generateNrandomNumbers(7, 45);
			sub3Nos = JavaUtils.generateNrandomNumbers(15, 90);
			waitTime = 45000;
		}
//		waitTime = 500;
		for(int i=1;i<=sub1Count;i++){
			HashMap<String, String> optionData = JavaUtils.readExcelData(fileName, examData.get("Sheet Name"), String.valueOf(i), subject1);
			String option = optionData.get("correct_answer");
			String qType = optionData.get("question_type");
			if(sub1Nos.contains(i)){
				if(qType.equals("single")){
					Thread.sleep(waitTime);
					option = optionXpath.replaceAll("inputOption",JavaUtils.getAnswerOption(Integer.parseInt(JavaUtils.generateRandomNumber(4))));
					clickElement(wdriver.findElement(By.xpath(option)));
				}else if(qType.equals("multiple")){
					Thread.sleep(waitTime);
					String [] options = option.split(",");
					ArrayList<Integer> ns = JavaUtils.generateNrandomNumbers(options.length, 4);
					int x = 0;
					for(String s: options){
						Thread.sleep(500);
						s = optionXpath.replaceAll("inputOption", JavaUtils.getAnswerOption(ns.get(x)));
						clickElement(wdriver.findElement(By.xpath(s)));
						x++;
					}
				}else if(qType.equals("integer")){
					Thread.sleep(waitTime);
					List<WebElement> integerOpt = wdriver.findElements(By.cssSelector(integerCss));
					clickElement(integerOpt.get(Integer.parseInt(JavaUtils.generateRandomNumber(10))-1));
				}else if(qType.equals("matrix")){
//					Thread.sleep(500);
//					saveBtn.click();
				}
			}else{
				if(qType.equals("single")){
					Thread.sleep(waitTime);
					option = optionXpath.replaceAll("inputOption", option.toUpperCase());
					clickElement(wdriver.findElement(By.xpath(option)));
				}else if(qType.equals("multiple")){
					Thread.sleep(waitTime);
					String [] options = option.split(",");
					for(String s: options){
						Thread.sleep(500);
						s = optionXpath.replaceAll("inputOption", s.toUpperCase());
						clickElement(wdriver.findElement(By.xpath(s)));
					}
				}else if(qType.equals("integer")){
					Thread.sleep(waitTime);
					List<WebElement> integerOpt = wdriver.findElements(By.cssSelector(integerCss));
					clickElement(integerOpt.get(Integer.parseInt(option)));
				}else if(qType.equals("matrix")){
//					Thread.sleep(500);
//					saveBtn.click();
				}
			}
			Thread.sleep(500);
			try {
				waitUntilElementclickable(saveBtn);
				saveBtn.click();
			} catch (Exception e) {
				waitUntilElementclickable(saveBtn);
				Thread.sleep(5000);
				saveBtn.click();
			}
		}
		
		for(int i=1;i<=sub2Count;i++){
			HashMap<String, String> optionData = JavaUtils.readExcelData(fileName, examData.get("Sheet Name"), String.valueOf(i), subject2);
			String option = optionData.get("correct_answer");
			String qType = optionData.get("question_type");
			if(sub1Nos.contains(i)){
				if(qType.equals("single")){
					Thread.sleep(waitTime);
					option = optionXpath.replaceAll("inputOption",JavaUtils.getAnswerOption(Integer.parseInt(JavaUtils.generateRandomNumber(4))));
					clickElement(wdriver.findElement(By.xpath(option)));
				}else if(qType.equals("multiple")){
					Thread.sleep(waitTime);
					String [] options = option.split(",");
					ArrayList<Integer> ns = JavaUtils.generateNrandomNumbers(options.length, 4);
					int x = 0;
					for(String s: options){
						Thread.sleep(500);
						s = optionXpath.replaceAll("inputOption", JavaUtils.getAnswerOption(ns.get(x)));
						clickElement(wdriver.findElement(By.xpath(s)));
						x++;
					}
				}else if(qType.equals("integer")){
					Thread.sleep(waitTime);
					List<WebElement> integerOpt = wdriver.findElements(By.cssSelector(integerCss));
					clickElement(integerOpt.get(Integer.parseInt(JavaUtils.generateRandomNumber(10))-1));
				}else if(qType.equals("matrix")){
//					Thread.sleep(500);
//					saveBtn.click();
				}
			}else{
				if(qType.equals("single")){
					Thread.sleep(waitTime);
					option = optionXpath.replaceAll("inputOption", option.toUpperCase());
					clickElement(wdriver.findElement(By.xpath(option)));
				}else if(qType.equals("multiple")){
					Thread.sleep(waitTime);
					String [] options = option.split(",");
					for(String s: options){
						Thread.sleep(500);
						s = optionXpath.replaceAll("inputOption", s.toUpperCase());
						clickElement(wdriver.findElement(By.xpath(s)));
					}
				}else if(qType.equals("integer")){
					Thread.sleep(waitTime);
					List<WebElement> integerOpt = wdriver.findElements(By.cssSelector(integerCss));
					clickElement(integerOpt.get(Integer.parseInt(option)));
				}else if(qType.equals("matrix")){
//					Thread.sleep(500);
//					saveBtn.click();
				}
			}
			Thread.sleep(500);
			try {
				waitUntilElementclickable(saveBtn);
				saveBtn.click();
			} catch (Exception e) {
				waitUntilElementclickable(saveBtn);
				Thread.sleep(5000);
				saveBtn.click();
			}
		}
		
		for(int i=1;i<=sub3Count;i++){
			HashMap<String, String> optionData = JavaUtils.readExcelData(fileName, examData.get("Sheet Name"), String.valueOf(i), subject3);
			String option = optionData.get("correct_answer");
			String qType = optionData.get("question_type");
			if(sub1Nos.contains(i)){
				if(qType.equals("single")){
					Thread.sleep(waitTime);
					option = optionXpath.replaceAll("inputOption",JavaUtils.getAnswerOption(Integer.parseInt(JavaUtils.generateRandomNumber(4))));
					clickElement(wdriver.findElement(By.xpath(option)));
				}else if(qType.equals("multiple")){
					Thread.sleep(waitTime);
					String [] options = option.split(",");
					ArrayList<Integer> ns = JavaUtils.generateNrandomNumbers(options.length, 4);
					int x = 0;
					for(String s: options){
						Thread.sleep(500);
						s = optionXpath.replaceAll("inputOption", JavaUtils.getAnswerOption(ns.get(x)));
						clickElement(wdriver.findElement(By.xpath(s)));
						x++;
					}
				}else if(qType.equals("integer")){
					Thread.sleep(waitTime);
					List<WebElement> integerOpt = wdriver.findElements(By.cssSelector(integerCss));
					clickElement(integerOpt.get(Integer.parseInt(JavaUtils.generateRandomNumber(10))-1));
				}else if(qType.equals("matrix")){
//					Thread.sleep(500);
//					saveBtn.click();
				}
			}else{
				if(qType.equals("single")){
					Thread.sleep(waitTime);
					option = optionXpath.replaceAll("inputOption", option.toUpperCase());
					clickElement(wdriver.findElement(By.xpath(option)));
				}else if(qType.equals("multiple")){
					Thread.sleep(waitTime);
					String [] options = option.split(",");
					for(String s: options){
						Thread.sleep(500);
						s = optionXpath.replaceAll("inputOption", s.toUpperCase());
						clickElement(wdriver.findElement(By.xpath(s)));
					}
				}else if(qType.equals("integer")){
					Thread.sleep(waitTime);
					List<WebElement> integerOpt = wdriver.findElements(By.cssSelector(integerCss));
					clickElement(integerOpt.get(Integer.parseInt(option)));
				}else if(qType.equals("matrix")){
//					Thread.sleep(500);
//					saveBtn.click();
				}
			}
			Thread.sleep(500);
			try {
				waitUntilElementclickable(saveBtn);
				saveBtn.click();
			} catch (Exception e) {
				waitUntilElementclickable(saveBtn);
				Thread.sleep(5000);
				saveBtn.click();
			}
		}
	}
	
	public void finishTest() throws InterruptedException{
		waitUntilElementclickable(finishTest_Btn);
		finishTest_Btn.click();
		waitUntilElementclickable(confirmFinish_Btn);
		confirmFinish_Btn.click();
		waitUntilElementclickable(next_Btn);
		next_Btn.click();
		while(true){
			Thread.sleep(500);
			if(wdriver.getCurrentUrl().contains("analyze?tab=score"))
				break;
		}
		Reporter.log("Finished Test Succesfully", true);
	}
	
	public void closeLoginPopUp(){
		try{
			waitUntilElementclickable(closeLoginPopup_Btn, 30);
			closeLoginPopup_Btn.click();
		}catch(Exception e){}
	}
	
	public void getTestScore(){
		try {
			waitUntilElementAppears(testScore_Lbl);
			String score = testScore_Lbl.getText().trim();
			Reporter.log("Score: "+score, true);
		} catch (Exception e) {}
	}
		
}
