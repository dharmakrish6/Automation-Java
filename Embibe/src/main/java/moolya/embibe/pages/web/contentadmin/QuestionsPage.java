package moolya.embibe.pages.web.contentadmin;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.JavaUtils;

public class QuestionsPage extends W_BasePage {

	public QuestionsPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//h1[contains(text(),'ActiveRecord::RecordNotFound')]")
	private WebElement recordNotFound_Label;
	
	@FindBy(xpath="//b[contains(text(),'Question Code')]")
	private WebElement questionCode_Label;
	
	@FindBy(css="#answer_tab>a")
	private WebElement answers_Tab;
	
	@FindBy(className="merror")
	private WebElement mathError_Tag;
	
	@FindBy(id="answerList")
	private WebElement answers_Table;
	
	public boolean checkIfQuestionExists(String questionId){
		try {
			waitUntilElementAppears(questionCode_Label, 20);
			Reporter.log("Question : "+questionId+" Exists", true);
			return true;
		} catch (Exception e) {
			Reporter.log("Question : "+questionId+" does not Exist", true);
			return false;
		}
	}
	
	public QuestionsPage clickAnswersTab(){
		waitUntilElementclickable(answers_Tab);
		answers_Tab.click();
		Reporter.log("Clicked on Answers Tab", true);
		return this;
	}
	
	public boolean checkForMathError(){
		waitUntilElementAppears(answers_Table);
		try {
			waitUntilElementAppears(mathError_Tag,5);
			Reporter.log("Question contains math error", true);
			return true;
		} catch (Exception e) {
			Reporter.log("Question has no errors", true);
			return false;
		}
	}
	
	

}
