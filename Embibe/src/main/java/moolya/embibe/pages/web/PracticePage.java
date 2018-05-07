package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
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

import com.testautomationguru.ocular.snapshot.Snap;

@Snap(value="SearchHomepage-#{Element}.png")
public class PracticePage extends W_BasePage {

	public PracticePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath="//span[text()='Practice']")
	private WebElement practiceMenu;
	
	@FindBy(xpath="(//*[@class='practice fresh'])[1]")
	private WebElement StartPracticeBtn;
	
	public void SelectStartPractice(){
		waitUntilElementAppears(StartPracticeBtn);
		clickElement(StartPracticeBtn);
		Reporter.log("Clicked on Start Practice",true);
		String winHandleBefore = wdriver.getWindowHandle();
		for(String winHandle : wdriver.getWindowHandles()){
			wdriver.switchTo().window(winHandle);
		}
		
		clickElement(sel_easy);
		Reporter.log("Selected Easy",true);
	}
	
	/*public void goToExamPageForPractice(int i,String examType,String expURL) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		ArrayList<LinkedHashMap<String, String>> results = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> resultData;
		
		String status ="";
		
		Thread.sleep(2000);
		WebElement optionA=wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)["+i+"]"));
		clickElement(optionA);
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		clickPractice();
		SelectStartPractice();
		for(int j=0;j<=61502;j++){
			selectAnswer();
			Thread.sleep(1000);
			String question=questionText.getText();
			Reporter.log("Question : "+ question);
			SelectViewSolution();
			Thread.sleep(1000);
			
			waitUntilElementAppears(bookmarkText);
			List<WebElement> ltcList=list_learnThisConcept;
			int ltc = ltcList.size();
			try{
				
				if(counts_of_learnThisConcept.isDisplayed()==true){
					status= "Available";
					Reporter.log("KT concept is available & Count is : " + ltc,true);
				}
			}
			catch(Exception e){
				   status= " Not Available";
				Reporter.log("KT concept is not available",true);	
			}
			clickElement(closeViewSolutionBtn);
			Reporter.log("Closed View Solution Window",true);
			
			//getLearnThisCocept();
			
			
			Thread.sleep(1000);
			gotoNextQuestion();
			if(mandatorySignupWindow.isDisplayed()==true){
				mandatorySignUp_Section();
			}
			else{	
				
			}
			selectAnswer();
			Thread.sleep(2000);
			SelectViewSolution();
			Thread.sleep(2000);
			getLearnThisCocept();
			Thread.sleep(2000);
			gotoNextQuestion();
			resultData = new LinkedHashMap<String, String>();
			resultData.put("Question", question);
			resultData.put("Status", status);
			results.add(resultData);
			moolya.embibe.utils.EmbibeUtils.writeQuestionDescription(results);
		}	
		
	}*/
	
	public void clickPractice(){
	waitUntilElementAppears(practiceMenu);
	clickElement(practiceMenu);
	Reporter.log("Clicked on Practice",true);
	}
	
	@FindBy(xpath="(//a[contains(text(),'Start Practice')])[1]")
	private WebElement mainStartPracticeBtn;
	
	@FindBy(xpath="(//a[@class='practice fresh' AND text()='Start Practice'])[2]")
	private WebElement phy_startPractice;
	
	@FindBy(xpath="(//a[@class='practice fresh' AND text()='Start Practice'])[3]")
	private WebElement che_startPractice;

	@FindBy(xpath="(//a[@class='practice fresh' AND text()='Start Practice'])[4]")
	private WebElement mat_startPractice;
	
	public void click_Phy_StartPractice(){
		waitUntilElementAppears(phy_startPractice);
		clickElement(phy_startPractice);
		Reporter.log("Click on Start practice button",true);
	}
	
	@FindBy(css = ".difficulty-block:nth-child(1)")
	private WebElement sel_easy;
	
	@FindBy(xpath = "(//span[text()='FINISH'])[2]")
	private WebElement finishTestBtn;
	
	@FindBy(xpath = "(//*[@class='phoenix-question__choice ng-pristine ng-untouched ng-valid ng-scope'])[1]")
	private WebElement option_1;
	
	//@FindBy(css="button.view-solution-practice-btn.view-solution-practice-btn-condition")
	@FindBy(xpath="//button[contains(text(),'VIEW SOLUTION')]")
	private WebElement viewSolutionBtn;
	
	@FindBy(css="button.learn-this-practice-btn")
	private WebElement learnThisBtn;
	
	@FindBy(css="input.loginBTN")
	private WebElement loginBtn;
	
	public void startPractice() throws InterruptedException{
		clickElement(mainStartPracticeBtn);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		waitUntilElementAppears(sel_easy);
		clickElement(sel_easy);
		waitUntilElementAppears(finishTestBtn);
		chooseAnswer();
		clickSubmit();
		
		for(int j=0;j<=61502;j++){
			selectAnswer();
			SelectViewSolution();
			getLearnThisCocept();
			gotoNextQuestion();
			if(mandatorySignupWindow.isDisplayed()==true){
				mandatorySignUp_Section();
			}
			else if(rewardPopupCloseBtn.isDisplayed()==true){
					closeRewardPopup();
				}
			else {
				
			}
	}
	}
		
		@FindBy(css="button.next-question-practice-btn")
		private WebElement nextQuestionBtn;
		
		public void gotoNextQuestion(){
			waitUntilElementAppears(nextQuestionBtn);
			clickElement(nextQuestionBtn);
			Reporter.log("Clicked on Next Button",true);
		}
		
		@FindBy(xpath="(//span[text()='A'])[1]")
		private WebElement selectFirstOption;
		
		@FindBy(css="span.phoenix-question__choice-icon")
		private List<WebElement> optionsList;
		
		@FindBy(css="p.phoenix-question__text")
		private WebElement questionText;
		
		public void selectAnswer() throws InterruptedException{
			waitUntilElementAppears(option_1);
			waitUntilElementclickable(option_1);
			List<WebElement> li=optionsList;
			for(WebElement e:li){
				waitUntilElementAppears(e);
	        	waitUntilElementclickable(e);
	        	scrollToElementViaJavascript(e);
				String myText = e.getText();
		        if (myText.contains("A")) {
		        	Thread.sleep(3000);
		        	clickElement(e, myText);
		        }
		        else
		        {
		        }
			}
			Reporter.log("Selected an answer",true);
		}
		
		public void SelectViewSolution(){
			//waitUntilElementAppears(viewSolutionBtn);
			waitUntilElementclickable(viewSolutionBtn);
			clickElement(viewSolutionBtn);
			Reporter.log("Clicked on View solution",true);
		}
		
		@FindBy(xpath="//a[contains(text(),'Learn this Concept')]")
		private WebElement counts_of_learnThisConcept;
		
		@FindBy(xpath="(//button[@class='modal__close-btn'])[7]")
		private WebElement closeViewSolutionBtn ;
		
		@FindBy(xpath="//*[text()='Bookmark ']")
		private WebElement bookmarkText;
		
		@FindBy(xpath="//a[contains(text(),'Learn this Concept')]")
		private List<WebElement> list_learnThisConcept;
		
		public String getLearnThisCocept(){
			waitUntilElementAppears(bookmarkText);
			List<WebElement> ltcList=list_learnThisConcept;
			String status ="";
			LinkedHashMap<String, String> resultData;
			resultData = new LinkedHashMap<String, String>();
			int ltc = ltcList.size();
			{
			try{
				
				if(counts_of_learnThisConcept.isDisplayed()==true){
					status= "Available";
				Reporter.log("KT concept is available & Count is : " + ltc,true);
				}
			}
			catch(Exception e){
				status= " Not Available";
			Reporter.log("KT concept is not available",true);	
			}
			
			resultData.put("Status", status);
			clickElement(closeViewSolutionBtn);
			Reporter.log("Closed View Solution Window",true);
			}
			return status;
		}
	
	public void chooseAnswer() throws InterruptedException {
		Thread.sleep(2000);
		waitUntilElementAppears(option_1);
		clickElement(option_1);
		Reporter.log("Choosen answer",true);
	} 
	
	@FindBy(xpath = "//*[@class='btn submit-practice-btn']")
	private WebElement submitBtn;
	
	public void clickSubmit(){
		waitUntilElementAppears(submitBtn);
		clickElement(submitBtn);
		Reporter.log("Clicked on Submit button",true);
	}
	
	@FindBy(xpath = "(//*[contains(text(),'Access from anywhere')])[1]")
	private WebElement mandatorySignupWindow;

	@FindBy(xpath = "(//input[@type='text'])[1]")
	private WebElement emailField;

	@FindBy(xpath = "(//input[@type='password'])[2]")
	private WebElement passwordField;


	@FindBy(xpath = "//input[@value='SIGN UP']")
	private WebElement signUpButton;
	
	@FindBy(xpath = "(//*[contains(text(),'Time spent in this question')])[1]")
	private WebElement timeSpent;

	@FindBy(css=".loginBtn")
	private WebElement loginHereBtn;
	
	public void mandatorySignUp_Section() throws InterruptedException {
		Thread.sleep(2000);
		mandatorySignupWindow.isDisplayed();
		{
			clickElement(loginHereBtn);
			emailField.sendKeys("jimmy@gmail.com");
			passwordField.sendKeys("qwertyuiop");
			clickElement(loginBtn);
			Thread.sleep(5000);
		}
		waitUntilElementAppears(timeSpent);
		System.out.println("Login has done successfully");

	}

	public StringBuffer generateString(int length) {
		StringBuffer output = new StringBuffer();
		String characterSet = "";
		characterSet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		for (int i=0; i<length; i++) 
 		{
			double index = Math.random()*characterSet.length();
			output.append(characterSet.charAt((int)index));
		}
		return(output);
	}
	
	@FindBy(css="div.embium-rewards-popup")
	private WebElement rewardPopUp;
	
	
	@FindBy(css="div.close-btn")
	private WebElement rewardPopupCloseBtn;
	
	public void closeRewardPopup(){
		waitUntilElementAppears(rewardPopUp);
		waitUntilElementclickable(rewardPopupCloseBtn);
		clickElement(rewardPopupCloseBtn);
		//rewardPopupCloseBtn.click();
		Reporter.log("Closed reward popup window",true);
	}
	
	@FindBy(xpath="(//input[@type='text'])[3]")
	private WebElement integerTypeTextField;
	
	
	public void goToExamPageForPractice(int i) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		ArrayList<LinkedHashMap<String, String>> results = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> resultData;
		String status ="";
		Thread.sleep(2000);
		WebElement examName=wdriver.findElement(By.xpath("(//*[@class='swiper-wrapper']/div)["+i+"]"));
		clickElement(examName);
		Reporter.log("Clicked on "+ examName.getText(), true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		clickPractice();
		SelectStartPractice();
		for(int j=0;j<=61502;j++){
			
			try{
				if(integerTypeTextField.isDisplayed())
				{
					integerTypeTextField.sendKeys("1");
				}
			}
			catch(Exception e)
			{
				Reporter.log("Not an integer type question",true);
			}
			
			selectAnswer();
			clickPracticeSubmitBtn();
			Thread.sleep(1000);
			checkRewardPopup();
			String question=questionText.getText();
			Reporter.log("Question : "+ question,true);
			resultData = new LinkedHashMap<String, String>();
			resultData.put("Question", question);
			SelectViewSolution();
			Thread.sleep(1000);
			
			waitUntilElementAppears(bookmarkText);
			List<WebElement> ltcList=list_learnThisConcept;
			int ltc = ltcList.size();
			try{
				
				if(counts_of_learnThisConcept.isDisplayed()==true){
					status= "Available";
					Reporter.log("KT concept is available & Count is : " + ltc,true);
				}
			}
			catch(Exception e){
				status= "Not Available";
				Reporter.log("KT concept is not available",true);	
			}
			resultData.put("Status", status);
			clickElement(closeViewSolutionBtn);
			Reporter.log("Closed View Solution Window",true);	
			Thread.sleep(1000);
			gotoNextQuestion();
			
			if(mandatorySignupWindow.isDisplayed()==true){
				mandatorySignUp_Section();
				String question2=questionText.getText();
				Reporter.log("Question : "+ question,true);
				resultData.put("Question", question2);
				selectAnswer();
				Thread.sleep(2000);
				clickPracticeSubmitBtn();
				Thread.sleep(1000);
				checkRewardPopup();
				SelectViewSolution();
				Thread.sleep(2000);
				getLearnThisCocept();
				Thread.sleep(2000);
				gotoNextQuestion();
			}
			else{	}
			
			resultData.put("Question", question);
			resultData.put("Status", status);
			results.add(resultData);
			moolya.embibe.utils.EmbibeUtils.writeQuestionDescriptionEngineering(results);
		}	
	}

	public void clickPracticeSubmitBtn(){
		waitUntilElementAppears(submitBtn);
		clickElement(submitBtn);
		Reporter.log("Clicked on Submit button",true);
	}
	
	public void checkRewardPopup(){
		try
		{
			if(rewardPopUp.isDisplayed()==false){
				closeRewardPopup();
			}
		else {
			}
		}
		catch(Exception e){
			
		}
	}
	

	@FindBy(xpath="//*[@class='entry-title']")
	private WebElement examTitle;
	
	public void practiceEng() throws InterruptedException{
		Thread.sleep(2000);
		//clickPractice();
		SelectStartPractice();
	}
	
	
	@FindBy(css="a.practice.fresh:nth-child(1)")
	private WebElement medStartPractice;
	
	public void practiceMed() throws InterruptedException{
		Thread.sleep(2000);
		clickElement(medStartPractice);
		SelectStartPractice();
	}
	
	public void getLearnthisConceptCount(){
		
	}
	
	@FindBy(css="span.phoenix-question__category")
	private WebElement questionType;
	
	public void getLearnConceptCount(){
		waitUntilElementAppears(bookmarkText);
		List<WebElement> ltcList=list_learnThisConcept;
		int ltc = ltcList.size();
		try{
			
			if(counts_of_learnThisConcept.isDisplayed()==true){
				Reporter.log("KT concept is available & Count is : " + ltc,true);
			}
		}
		catch(Exception e){
			Reporter.log("KT concept is not available",true);	
		}
	}
	
	@FindBy(xpath="(//*[contains(text(),'Explanation')])[1]")
	private WebElement explanationHeader;
	

	@FindBy(css="p.question-modal__explanation")
	private WebElement questExplanation;
	
	@FindBy(xpath="//button[contains(text(),'Key Concept')]")
	private WebElement keyConcepts;
	
	@FindBy(css="button.view-hint-practice-btn")
	private WebElement viewHintBtn;
	
	@FindBy(css="i.practice-session__hint-close")
	private WebElement closeHint;
	
	@FindBy(xpath="//box/div[2]/li/p")
	private WebElement hintText;
	
	@FindBy(css="button.modal__close-btn.practice-responsive")
	private WebElement smallWinCloseBtn;
	
	public void EnggPractice() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		ArrayList<LinkedHashMap<String, String>> results = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> resultData;
		String status ="", explanation ="",keyConcept="",hint="";
		int No_of_KTConcepts=0;
		Thread.sleep(10000);
		for(int j=1;j<=5;j++){
			Reporter.log("Question Number is : "+j,true);
			resultData = new LinkedHashMap<String, String>();
			String questNum=Integer.toString(j);
			resultData.put("Question No.",questNum);
			
			Thread.sleep(3000);
			String questionTypeText =questionType.getText();
			waitUntilElementAppears(questionType);
			
			if(questionTypeText.equalsIgnoreCase("Integer Question"))
			{
				Reporter.log("In Integer question",true);
				Reporter.log("Question type is : "+questionTypeText,true);
				String question=questionText.getText();
				resultData.put("Question Type", questionTypeText);
				resultData.put("Question", question);
				clickElement(viewHintBtn);
				Reporter.log("opened hint",true);
				try{
					if(hintText.getText().length()>0)
						hint= "Available";
					clickElement(closeHint);
					Reporter.log("closed hint",true);
					}
				catch(Exception e){
					hint= " Not Available";
				}
				resultData.put("Hints", hint);
				
				integerTypeTextField.sendKeys("1");
				clickPracticeSubmitBtn();
				checkRewardPopup();
				SelectViewSolution();
				//getLearnThisCocept();
				//waitUntilElementAppears(bookmarkText);
				//waitUntilElementAppears(closeViewSolutionBtn);
				try{
					waitUntilElementAppears(bookmarkText);
				}
				catch(Exception e){
					waitUntilElementAppears(smallWinCloseBtn);
				}
				List<WebElement> ltcList=list_learnThisConcept;
				int ltc = ltcList.size();
				{
				try{
					
					if(counts_of_learnThisConcept.isDisplayed()==true){
						No_of_KTConcepts=ltc;
						status= "Available";
						Reporter.log("KT concept is available & Count is : " + ltc,true);		
					}
				}
				catch(Exception e){
					No_of_KTConcepts=ltc;
					status= " Not Available";
				Reporter.log("KT concept is not available",true);	
				}
				String ktcount=Integer.toString(No_of_KTConcepts);
				resultData.put("KT concepts",ktcount);
				//resultData.put("Status", status);
				try{
					scrollToElementViaJavascript(explanationHeader);
					if(questExplanation.isDisplayed()==true){
						explanation= "Available";
						Reporter.log("Explanation is available",true);	
					}
				}
				catch(Exception e){
					explanation= "Not Available";
					Reporter.log("Explanation is not available",true);	
				}
				resultData.put("Explanation", explanation);
				try{
					scrollToElementViaJavascript(keyConcepts);
					if(keyConcepts.isDisplayed()==true){
						keyConcept= "Available";
						Reporter.log("KeyConcept is available",true);	
					}
				}
				catch(Exception e){
					keyConcept= "Not Available";
					Reporter.log("KeyConcept is not available",true);	
				}
				resultData.put("Key Concepts", keyConcept);
				Thread.sleep(2000);
				try{
					clickElement(closeViewSolutionBtn);
				}
				catch(Exception e){
					clickElement(smallWinCloseBtn);
				}
				Reporter.log("Closed View Solution Window",true);
				
				}
			}
			else if(questionTypeText.equalsIgnoreCase("Single Choice Question"))
			{
				Reporter.log("In Single choice question",true);
				Reporter.log("Question type is : "+questionTypeText,true);
				resultData.put("Question Type", questionTypeText);
				String question=questionText.getText();
				resultData.put("Question", question);

				clickElement(viewHintBtn);
				Reporter.log("opened hint",true);
				try{
					
					if(hintText.getText().length()>0)
						hint= "Available";
						clickElement(closeHint);
						Reporter.log("closed hint",true);
					}
				catch(Exception e){
					hint= " Not Available";
					
				}
				resultData.put("Hints", hint);
			
				
				selectAnswer();
				clickPracticeSubmitBtn();
				checkRewardPopup();
				
				SelectViewSolution();
				//getLearnThisCocept();
				//waitUntilElementAppears(bookmarkText);
				//waitUntilElementAppears(closeViewSolutionBtn);
				try{
					waitUntilElementAppears(bookmarkText);
				}
				catch(Exception e){
					waitUntilElementAppears(smallWinCloseBtn);
				}
				List<WebElement> ltcList=list_learnThisConcept;
				int ltc = ltcList.size();
				{
				try{
					
					if(counts_of_learnThisConcept.isDisplayed()==true){
						No_of_KTConcepts=ltc;
						status= "Available";
					Reporter.log("KT concept is available & Count is : " + ltc,true);
					}
				}
				catch(Exception e){
					No_of_KTConcepts=ltc;
					status= " Not Available";
				Reporter.log("KT concept is not available",true);	
				}
				String ktcount=Integer.toString(No_of_KTConcepts);
				resultData.put("KT concepts",ktcount);
				//resultData.put("Status", status);
				try{
					scrollToElementViaJavascript(explanationHeader);
					if(questExplanation.isDisplayed()==true){
						explanation= "Available";
						Reporter.log("Explanation is available",true);	
					}
				}
				catch(Exception e){
					explanation= "Not Available";
					Reporter.log("Explanation is not available",true);	
				}
				resultData.put("Explanation", explanation);
				try{
					scrollToElementViaJavascript(keyConcepts);
					if(keyConcepts.isDisplayed()==true){
						keyConcept= "Available";
						Reporter.log("KeyConcept is available",true);	
					}
				}
				catch(Exception e){
					keyConcept= "Not Available";
					Reporter.log("KeyConcept is not available",true);	
				}
				resultData.put("Key Concepts", keyConcept);
				Thread.sleep(2000);
				try{
					clickElement(closeViewSolutionBtn);
				}
				catch(Exception e){
					clickElement(smallWinCloseBtn);
				}
				Reporter.log("Closed View Solution Window",true);
				}
				}
				
			else {

				Reporter.log("In Others",true);
				String question=questionText.getText();
				resultData.put("Question Type", questionTypeText);
				resultData.put("Question", question);
				Reporter.log("Question type is : "+questionTypeText,true);
				
				clickElement(viewHintBtn);
				Reporter.log("opened hint",true);
				try{
					if(hintText.getText().length()>0)
						hint= "Available";
					clickElement(closeHint);
					Reporter.log("closed hint",true);
					}
				catch(Exception e){
					hint= " Not Available";
				}
				resultData.put("Hints", hint);
			
				
				selectAnswer();
				clickPracticeSubmitBtn();
				checkRewardPopup();
				SelectViewSolution();
				//getLearnThisCocept();
				//waitUntilElementAppears(bookmarkText);
				//waitUntilElementAppears(closeViewSolutionBtn);
				try{
					waitUntilElementAppears(bookmarkText);
				}
				catch(Exception e){
					waitUntilElementAppears(smallWinCloseBtn);
				}
				List<WebElement> ltcList=list_learnThisConcept;
				int ltc = ltcList.size();
				{
				try{
					
					if(counts_of_learnThisConcept.isDisplayed()==true){
						No_of_KTConcepts=ltc;
						status= "Available";
					Reporter.log("KT concept is available & Count is : " + ltc,true);
					}
				}
				catch(Exception e){
					No_of_KTConcepts=ltc;
					status= " Not Available";
				Reporter.log("KT concept is not available",true);	
				}
				String ktcount=Integer.toString(No_of_KTConcepts);
				resultData.put("KT concepts",ktcount);
				//resultData.put("Status", status);
				try{
					scrollToElementViaJavascript(explanationHeader);
					if(questExplanation.isDisplayed()==true){
						explanation= "Available";
						Reporter.log("Explanation available",true);	
					}
				}
				catch(Exception e){
					explanation= " Not Available";
					Reporter.log("Explanation is not available",true);	
				}
				resultData.put("Explanation", explanation);
				try{
					scrollToElementViaJavascript(keyConcepts);
					if(keyConcepts.isDisplayed()==true){
						keyConcept= "Available";
						Reporter.log("KeyConcept is available",true);	
					}
				}
				catch(Exception e){
					keyConcept= " Not Available";
					Reporter.log("KeyConcept is not available",true);	
				}
				resultData.put("Key Concepts", keyConcept);
				Thread.sleep(1000);
				try{
					clickElement(closeViewSolutionBtn);
				}
				catch(Exception e){
					clickElement(smallWinCloseBtn);
				}
				
				Reporter.log("Closed View Solution Window",true);
				}
			}
		clickElement(nextQuestionBtn);
		results.add(resultData);
		moolya.embibe.utils.EmbibeUtils.writeQuestionDescriptionEngineering(results);
		}
	}
	
	public void MedPractice() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		Reporter.log("-------------------------------------------------------------------------------------------------",true);
		ArrayList<LinkedHashMap<String, String>> results = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> resultData;
		String status ="", explanation ="",keyConcept="",hint="";
		int No_of_KTConcepts=0;
		Thread.sleep(10000);
		for(int j=1;j<=10;j++){
			resultData = new LinkedHashMap<String, String>();
			String questNum=Integer.toString(j);
			resultData.put("Question No.",questNum);
			
			Thread.sleep(3000);
			String questionTypeText =questionType.getText();
			waitUntilElementAppears(questionType);
			
			if(questionTypeText.equalsIgnoreCase("Integer Question"))
			{
				Reporter.log("In Integer question",true);
				Reporter.log("Question type is : "+questionTypeText,true);
				String question=questionText.getText();
				resultData.put("Question Type", questionTypeText);
				resultData.put("Question", question);
				clickElement(viewHintBtn);
				Reporter.log("opened hint",true);
				try{
					if(hintText.getText().length()>0)
						hint= "Available";
					clickElement(closeHint);
					Reporter.log("closed hint",true);
					}
				catch(Exception e){
					hint= " Not Available";
				}
				resultData.put("Hints", hint);
				
				integerTypeTextField.sendKeys("1");
				clickPracticeSubmitBtn();
				checkRewardPopup();
				SelectViewSolution();
				//getLearnThisCocept();
				//waitUntilElementAppears(bookmarkText);
				try{
					waitUntilElementAppears(bookmarkText);
				}
				catch(Exception e){
					waitUntilElementAppears(smallWinCloseBtn);
				}
				List<WebElement> ltcList=list_learnThisConcept;
				int ltc = ltcList.size();
				{
				try{
					
					if(counts_of_learnThisConcept.isDisplayed()==true){
						No_of_KTConcepts=ltc;
						status= "Available";
						Reporter.log("KT concept is available & Count is : " + ltc,true);		
					}
				}
				catch(Exception e){
					No_of_KTConcepts=ltc;
					status= " Not Available";
				Reporter.log("KT concept is not available",true);	
				}
				String ktcount=Integer.toString(No_of_KTConcepts);
				resultData.put("KT concepts",ktcount);
				//resultData.put("Status", status);
				try{
					scrollToElementViaJavascript(explanationHeader);
					if(questExplanation.isDisplayed()==true){
						explanation= "Available";
						Reporter.log("Explanation is available",true);	
					}
				}
				catch(Exception e){
					explanation= "Not Available";
					Reporter.log("Explanation is not available",true);	
				}
				resultData.put("Explanation", explanation);
				try{
					scrollToElementViaJavascript(keyConcepts);
					if(keyConcepts.isDisplayed()==true){
						keyConcept= "Available";
						Reporter.log("KeyConcept is available",true);	
					}
				}
				catch(Exception e){
					keyConcept= "Not Available";
					Reporter.log("KeyConcept is not available",true);	
				}
				resultData.put("Key Concepts", keyConcept);
				Thread.sleep(2000);
				try{
					clickElement(closeViewSolutionBtn);
				}
				catch(Exception e){
					clickElement(smallWinCloseBtn);
				}
				
				Reporter.log("Closed View Solution Window",true);
				
				}
			}
			else if(questionTypeText.equalsIgnoreCase("Single Choice Question"))
			{
				Reporter.log("In Single choice question",true);
				Reporter.log("Question type is : "+questionTypeText,true);
				resultData.put("Question Type", questionTypeText);
				String question=questionText.getText();
				resultData.put("Question", question);

				clickElement(viewHintBtn);
				Reporter.log("opened hint",true);
				try{
					
					if(hintText.getText().length()>0)
						hint= "Available";
						clickElement(closeHint);
						Reporter.log("closed hint",true);
					}
				catch(Exception e){
					hint= " Not Available";
					
				}
				resultData.put("Hints", hint);
			
				
				selectAnswer();
				clickPracticeSubmitBtn();
				checkRewardPopup();
				
				SelectViewSolution();
				//getLearnThisCocept();
				//waitUntilElementAppears(bookmarkText);
				try{
					waitUntilElementAppears(bookmarkText);
				}
				catch(Exception e){
					waitUntilElementAppears(smallWinCloseBtn);
				}
				List<WebElement> ltcList=list_learnThisConcept;
				int ltc = ltcList.size();
				{
				try{
					
					if(counts_of_learnThisConcept.isDisplayed()==true){
						No_of_KTConcepts=ltc;
						status= "Available";
					Reporter.log("KT concept is available & Count is : " + ltc,true);
					}
				}
				catch(Exception e){
					No_of_KTConcepts=ltc;
					status= " Not Available";
				Reporter.log("KT concept is not available",true);	
				}
				String ktcount=Integer.toString(No_of_KTConcepts);
				resultData.put("KT concepts",ktcount);
				//resultData.put("Status", status);
				try{
					scrollToElementViaJavascript(explanationHeader);
					if(questExplanation.isDisplayed()==true){
						explanation= "Available";
						Reporter.log("Explanation is available",true);	
					}
				}
				catch(Exception e){
					explanation= "Not Available";
					Reporter.log("Explanation is not available",true);	
				}
				resultData.put("Explanation", explanation);
				try{
					scrollToElementViaJavascript(keyConcepts);
					if(keyConcepts.isDisplayed()==true){
						keyConcept= "Available";
						Reporter.log("KeyConcept is available",true);	
					}
				}
				catch(Exception e){
					keyConcept= "Not Available";
					Reporter.log("KeyConcept is not available",true);	
				}
				resultData.put("Key Concepts", keyConcept);
				Thread.sleep(2000);
				try{
					clickElement(closeViewSolutionBtn);
				}
				catch(Exception e){
					clickElement(smallWinCloseBtn);
				}
				
				Reporter.log("Closed View Solution Window",true);
				}
				}
				
			else {

				Reporter.log("In Others",true);
				String question=questionText.getText();
				resultData.put("Question Type", questionTypeText);
				resultData.put("Question", question);
				Reporter.log("Question type is : "+questionTypeText,true);
				
				clickElement(viewHintBtn);
				Reporter.log("opened hint",true);
				try{
					if(hintText.getText().length()>0)
						hint= "Available";
					clickElement(closeHint);
					Reporter.log("closed hint",true);
					}
				catch(Exception e){
					hint= " Not Available";
				}
				resultData.put("Hints", hint);
			
				
				selectAnswer();
				clickPracticeSubmitBtn();
				checkRewardPopup();
				SelectViewSolution();
				//getLearnThisCocept();
				//waitUntilElementAppears(bookmarkText);
				try{
					waitUntilElementAppears(bookmarkText);
				}
				catch(Exception e){
					waitUntilElementAppears(smallWinCloseBtn);
				}
				List<WebElement> ltcList=list_learnThisConcept;
				int ltc = ltcList.size();
				{
				try{
					
					if(counts_of_learnThisConcept.isDisplayed()==true){
						No_of_KTConcepts=ltc;
						status= "Available";
					Reporter.log("KT concept is available & Count is : " + ltc,true);
					}
				}
				catch(Exception e){
					No_of_KTConcepts=ltc;
					status= " Not Available";
				Reporter.log("KT concept is not available",true);	
				}
				String ktcount=Integer.toString(No_of_KTConcepts);
				resultData.put("KT concepts",ktcount);
				//resultData.put("Status", status);
				try{
					scrollToElementViaJavascript(explanationHeader);
					if(questExplanation.isDisplayed()==true){
						explanation= "Available";
						Reporter.log("Explanation is available",true);	
					}
				}
				catch(Exception e){
					explanation= "Explanation is not Available";
				}
				resultData.put("Explanation", explanation);
				try{
					scrollToElementViaJavascript(keyConcepts);
					if(keyConcepts.isDisplayed()==true){
						keyConcept= "Available";
						Reporter.log("KeyConcept is available",true);	
					}
				}
				catch(Exception e){
					keyConcept= " Not Available";
					Reporter.log("KeyConcept is not available",true);	
				}
				resultData.put("Key Concepts", keyConcept);
				Thread.sleep(1000);
				try{
					clickElement(closeViewSolutionBtn);
				}
				catch(Exception e){
					clickElement(smallWinCloseBtn);
				}
				
				Reporter.log("Closed View Solution Window",true);
				}
			}
		clickElement(nextQuestionBtn);
		results.add(resultData);
		moolya.embibe.utils.EmbibeUtils.writeQuestionDescriptionMedical(results);
		}
	}
}
