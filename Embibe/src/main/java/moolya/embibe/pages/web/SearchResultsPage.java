package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.testautomationguru.ocular.comparator.OcularResult;
import com.testautomationguru.ocular.snapshot.Snap;

@Snap(value="SearchResultsPage-#{Element}.png")
public class SearchResultsPage extends W_BasePage {

	public SearchResultsPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}

	//	Showing Results for Objects
	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine1']//li[text()='Engineering']")
	private WebElement showForEngineering_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine1']//li[text()='Medical']")
	private WebElement showForMedical_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine1']//li[text()='Banking']")
	private WebElement showForBanking_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine1']//li[text()='Foundation']")
	private WebElement showForFoundation_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine2']//li[text()='All']")
	private WebElement showForAllExams_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine2']//li[text()='IIT JEE']")
	private WebElement showForIitJee_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine2']//li[text()='BIT SAT']")
	private WebElement showForBitSat_Btn;

	@FindBy(xpath="//div[@class='srWrapper']/div[@class='srLine2']//li[text()='JEE mains']")
	private WebElement showForJeeMains_Btn;
	
	@FindBy(css=".srWrapper .srLine1 .srOptionItem")
	private List<WebElement> showingResultsFor_List;
	
	@FindBy(css=".srWrapper .srLine1 .srOptionItem.glyphicon-menu-right")
	private WebElement showingResultsForExpand_Btn;
	
	@FindBy(css=".srWrapper .srLine1 .srOptionItem.glyphicon-menu-left")
	private WebElement showingResultsForCollapse_Btn;
	
	@FindBy(css=".srWrapper .srLine2 .srOptionItem")
	private List<WebElement> specificExam_List;
	
	@FindBy(css=".srWrapper .srLine2 .srOptionItem.glyphicon-menu-right")
	private WebElement specificExamExpand_Btn;
	
	@FindBy(css=".srWrapper .srLine2 .srOptionItem.glyphicon-menu-left")
	private WebElement specificExamCollapse_Btn;
	
	@FindBy(css=".wikiMore")
	private WebElement goToWikipedia_Btn;
	
	@FindBy(css=".unlock-pack")
	private WebElement unlockJumpPack_Btn;

	@FindBy(css=".button-tour")
	private WebElement takeAtour_Btn;

	@FindBy(css="div.topic-wrapper div.topic-head")
	private WebElement topicHeader_Lbl;
	
	@FindBy(css="div.topic-wrapper div.topic-head .toolTip")
	private WebElement topicHeaderToolTip;

	@FindBy(css="div.topic-wrapper div.topic-description")
	private WebElement topicDescription_Lbl;

	@FindBy(css="div.topic-wrapper div.linkMore")
	private WebElement learMore_Link;

	@FindBy(css="div.concept>div.heading")
	private WebElement conceptsHeading_Lbl;

	@FindBy(css="div.concept li div.conceptItem")
	private List<WebElement> conceptName_List;

	@FindBy(css="div.concept li div.important")
	private List<WebElement> importantFor_List;

	@FindBy(css="div.concept-more")
	private WebElement seeMore_Link;

	//	Social Strength Objects

	@FindBy(xpath="//div[text()='JEEMains']/preceding-sibling::div/span[@class='blue-circle']")
	private List<WebElement> jeeMainsBlue_List;

	@FindBy(xpath="//div[text()='Bitsat']/preceding-sibling::span[@class='blue-circle']")
	private List<WebElement> bitsatBlue_List;

	@FindBy(xpath="//div[text()='JEEAdvanced']/preceding-sibling::span[@class='blue-circle']")
	private List<WebElement> jeeAdvancedBlue_List;

	@FindBy(xpath="//*[text()='JEE MAINS']/../following-sibling::*/*")
	private WebElement jeeMainsPercentage;

	@FindBy(css="div.BehavioralMeterWrapper div.footText")
	private WebElement behavioralMeterStatus_Lbl;

	// Embibe Guide Objects

	@FindBy(css="div.embibe-guide + div.content>div.subHead")
	private WebElement embibeGuideHead_Lbl;

	@FindBy(css="div.embibe-guide + div.content>div.head")
	private WebElement embibeGuideText_Lbl;

	@FindBy(css="div.embibe-guide+div.content+div.embium")
	private WebElement embibeGuideEmbium_Lbl;

	@FindBy(css="div.topic-video-container div.footer p")
	private List<WebElement> videoName_List;

	@FindBy(css="div.cheatSheetWrap li.cheatItem")
	private List<WebElement> cheatSheetPoints_List;

	@FindBy(css="div.cheatSheetWrap div.cheatMore")
	private WebElement cheatSeeMore_Link;

	@FindBy(css="div.unlockJumpWrapper div.packHeading")
	private List<WebElement> unlockJumpPackHeading_List;

	@FindBy(css="div.unlockJumpWrapper div.packName")
	private List<WebElement> unlockJumpPackName_List;

	@FindBy(css="div.unlockJumpWrapper button.unlock-button")
	private List<WebElement> unlockJumpBtn_List;

	@FindBy(css="div.unlockJumpWrapper button.unlock-button div.unlock-text")
	private List<WebElement> unlockText_List;

	@FindBy(css="div.progress-wrapper div.inProg")
	private WebElement practiceProgressStatus_Lbl;

	@FindBy(css="div.progress-wrapper div.progressHeading")
	private WebElement practiceProgressHeading_Lbl;

	@FindBy(css="div.progress-wrapper div.progressIndicator")
	private WebElement practiceProgressCount_Lbl;

	@FindBy(css="div.progress-wrapper div.progress-bar span")
	private WebElement practiceProgressPercentage_Lbl;

	@FindBy(css="div.progress-wrapper button.button-common")
	private WebElement practiceProgressResume_Btn;

	@FindBy(css="div.practice-question-wrapper div.header p")
	private List<WebElement> practiceQuestionName_List;

	@FindBy(css="div.practice-question-wrapper div.body p")
	private List<WebElement> practiceQuestionDescription_List;

	@FindBy(css="div.practice-question-wrapper div.footer button")
	private List<WebElement> practiceQuestionBtn_List;

	@FindBy(css="div.practice-question-wrapper div.footer span")
	private List<WebElement> practiceQuestionSummaryLink_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[@class='heading']")
	private WebElement revisionTestHeader_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[@class='heading']//span")
	private WebElement revisionTestHeaderSubject_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[@class='itemHeading']")
	private List<WebElement> revisionTestName_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[@class='itemDescription']")
	private List<WebElement> revisionTestDescription_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[contains(@class,'tablet-responsive-pad')]//div[contains(@class,'text-center')]//span[@class='circle']")
	private List<WebElement> revisionTestQuestionCount_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[contains(@class,'tablet-responsive-pad')]//div[@class='right-details']//span[@class='circle']")
	private List<WebElement> revisionTestMinutesCount_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[contains(@class,'tablet-responsive-pad')]//button")
	private List<WebElement> revisionTestStartBtn_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][1]//div[contains(@class,'testMore')]")
	private WebElement revisionTestSeeMore_Btn;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/span")
	private WebElement chapterTestSubjectName_Lbl;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/following-sibling::div//div[@class='header']/p[1]")
	private List<WebElement> chapterTestName_List;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/following-sibling::div//div[@class='main-body']/p[1]//span[@class='circle']")
	private List<WebElement> chapterTestQuestionsCount_List;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/following-sibling::div//div[@class='main-body']/p[2]//span[@class='circle']")
	private List<WebElement> chapterTestMinutesCount_List;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/following-sibling::div//div/button[text()='Start Test']")
	private List<WebElement> chapterTestStartBtn_List;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/following-sibling::div//img[1]")
	private WebElement chapterTestNext_Btn;

	@FindBy(xpath="//div[contains(text(),'Chapter Test')]/following-sibling::div//img[2]")
	private WebElement chapterTestPrevious_Btn;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[@class='heading']")
	private WebElement partTestHeader_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[@class='heading']//span")
	private WebElement partTestHeaderSubject_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[@class='itemHeading']")
	private List<WebElement> partTestName_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[@class='itemDescription']")
	private List<WebElement> partTestDescription_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[contains(@class,'tablet-responsive-pad')]//div[contains(@class,'text-center')]//span[@class='circle']")
	private List<WebElement> partTestQuestionCount_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[contains(@class,'tablet-responsive-pad')]//div[@class='right-details']//span[@class='circle']")
	private List<WebElement> partTestMinutesCount_Lbl;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[contains(@class,'tablet-responsive-pad')]//button")
	private List<WebElement> partTestStartBtn_List;

	@FindBy(xpath="//div[contains(@class,'testListWrapper')][2]//div[contains(@class,'testMore')]")
	private WebElement partTestSeeMore_Btn;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/span")
	private WebElement fullTestSubjectName_Lbl;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/following-sibling::div//div[@class='header']/p[1]")
	private List<WebElement> fullTestName_List;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/following-sibling::div//div[@class='main-body']/p[1]//span[@class='circle']")
	private List<WebElement> fullTestQuestionsCount_List;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/following-sibling::div//div[@class='main-body']/p[2]//span[@class='circle']")
	private List<WebElement> fullTestMinutesCount_List;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/following-sibling::div//div/button[text()='Start Test']")
	private List<WebElement> fullTestStartBtn_List;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/following-sibling::div//img[1]")
	private WebElement fullTestNext_Btn;

	@FindBy(xpath="//div[contains(text(),'Full Test')]/following-sibling::div//img[2]")
	private WebElement fullTestPrevious_Btn;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/span")
	private WebElement miniTestSubjectName_Lbl;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/following-sibling::div//div[@class='header']/p[1]")
	private List<WebElement> miniTestName_List;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/following-sibling::div//div[@class='main-body']/p[1]//span[@class='circle']")
	private List<WebElement> miniTestQuestionsCount_List;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/following-sibling::div//div[@class='main-body']/p[2]//span[@class='circle']")
	private List<WebElement> miniTestMinutesCount_List;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/following-sibling::div//div/button[text()='Start Test']")
	private List<WebElement> miniTestStartBtn_List;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/following-sibling::div//img[1]")
	private WebElement miniTestNext_Btn;

	@FindBy(xpath="//div[contains(text(),'Mini Test')]/following-sibling::div//img[2]")
	private WebElement miniTestPrevious_Btn;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/span")
	private WebElement liveFullTestSubjectName_Lbl;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/following-sibling::div//div[@class='header']/p[1]")
	private List<WebElement> liveFullTestName_List;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/following-sibling::div//div[@class='main-body']/p[1]//span[@class='circle']")
	private List<WebElement> liveFullTestQuestionsCount_List;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/following-sibling::div//div[@class='main-body']/p[2]//span[@class='circle']")
	private List<WebElement> liveFullTestMinutesCount_List;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/following-sibling::div//div/button[text()='Start Test']")
	private List<WebElement> liveFullTestStartBtn_List;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/following-sibling::div//img[1]")
	private WebElement liveFullTestNext_Btn;

	@FindBy(xpath="//div[contains(text(),'Live Full Test')]/following-sibling::div//img[2]")
	private WebElement liveFullTestPrevious_Btn;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/span")
	private WebElement previousYearPaperSubjectName_Lbl;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/following-sibling::div//div[@class='header']/p[1]")
	private List<WebElement> previousYearPaperName_List;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/following-sibling::div//div[@class='main-body']/p[1]//span[@class='circle']")
	private List<WebElement> previousYearPaperQuestionsCount_List;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/following-sibling::div//div[@class='main-body']/p[2]//span[@class='circle']")
	private List<WebElement> previousYearPaperMinutesCount_List;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/following-sibling::div//div/button[text()='Start Test']")
	private List<WebElement> previousYearPaperStartBtn_List;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/following-sibling::div//img[1]")
	private WebElement previousYearPaperNext_Btn;

	@FindBy(xpath="//div[contains(text(),'Previous Year Paper')]/following-sibling::div//img[2]")
	private WebElement previousYearPaperPrevious_Btn;

	@FindBy(css="li.raqItem")
	private List<WebElement> recentlyAskedQuestions_List;

	@FindBy(css="div.askWrapper input.inputQuestion")
	private WebElement askQuestion_TB;

	@FindBy(css="div.askWrapper a.askButton")
	private WebElement askQuestion_Btn;

	@FindBy(css="div.news-container a.news-link")
	private List<WebElement> newsLink_List;

	@FindBy(css="div.news-container div.footer span.pull-left")
	private WebElement newsPlace_List;

	@FindBy(css="div.news-container div.footer span.time")
	private WebElement newsTime_List;

	@FindBy(css="span.ranker-description")
	private WebElement successRankerDescription_Lbl;

	@FindBy(css="a.ranker-about-embibe")
	private WebElement successRankerAboutEmbibe_Lbl;

	@FindBy(xpath="//div[contains(@class,'success-story')]//div[@class='key-value']/span[1]")
	private List<WebElement> rankValues_List;

	@FindBy(xpath="//div[contains(@class,'success-story')]//div[@class='key-value']/span[2]")
	private List<WebElement> rankNames_List;
	
	@FindBy(css=".border.clearfix")
	private WebElement conceptItem;
	
	@FindBy(css=".concept.common-margin+div>div.common-margin")
	private WebElement mostViewedVideos;
	
	@FindBy(css=".overlay.video-overlay")
	private WebElement videosLayout_List;
	
	@FindBy(css=".paginationCont>ul>li.previous>a")
	private WebElement pageCountPrevious_Btn;
	
	@FindBy(css=".paginationCont>ul>li.next>a")
	private WebElement pageCountNext_Btn;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1)>div.footer-header")
	private WebElement exams_Footer_Header;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(2)>div.footer-header")
	private WebElement classes_Footer_Header;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3)>div.footer-header")
	private WebElement mockTests_Footer_Header;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4)>div.footer-header")
	private WebElement crack_Footer_Header;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(5)>div.footer-header")
	private WebElement resources_Footer_Header;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1) ul li:nth-child(1)>a")
	private WebElement exams_FooterJEEMain;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1) ul li:nth-child(2)>a")
	private WebElement exams_FooterNEET;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1) ul li:nth-child(3)>a")
	private WebElement exams_FooterAIIMS;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1) ul li:nth-child(4)>a")
	private WebElement exams_FooterCBSE;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1) ul li:nth-child(5)>a")
	private WebElement exams_FooterJEEAdvanced;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(1) ul li:nth-child(6)>a")
	private WebElement exams_FooterBITSAT;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(2) ul li:nth-child(1)>a")
	private WebElement class8_Footer;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(2) ul li:nth-child(2)>a")
	private WebElement class9_Footer;

	@FindBy(css=".footer-div .col-sm-2:nth-child(2) ul li:nth-child(3)>a")
	private WebElement class10_Footer;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(1)>a")
	private WebElement mockTests_Footer_JEEMain;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(2)>a")
	private WebElement mockTests_Footer_JEEAdvanced;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(3)>a")
	private WebElement mockTests_Footer_BITSAT;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(4)>a")
	private WebElement mockTests_Footer_Gujarat_CET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(5)>a")
	private WebElement mockTests_Footer_AP_EAMCET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(6)>a")
	private WebElement mockTests_Footer_TS_EAMCET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(7)>a")
	private WebElement mockTests_Footer_NEET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(8)>a")
	private WebElement mockTests_Footer_AIIMS;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(9)>a")
	private WebElement mockTests_Footer_BankClerkPrelims;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(3) ul li:nth-child(10)>a")
	private WebElement mockTests_Footer_BankPOPrelims;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(1)>a")
	private WebElement crack_Footer_JEEMain;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(2)>a")
	private WebElement crack_Footer_JEEAdvanced;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(3)>a")
	private WebElement crack_Footer_BITSAT;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(4)>a")
	private WebElement crack_Footer_Gujarat_CET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(5)>a")
	private WebElement crack_Footer_AP_EAMCET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(6)>a")
	private WebElement crack_Footer_TS_EAMCET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(7)>a")
	private WebElement crack_Footer_NEET;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(8)>a")
	private WebElement crack_Footer_AIIMS;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(9)>a")
	private WebElement crack_Footer_BankClerkPrelims;
	
	@FindBy(css=".footer-div .col-sm-3:nth-child(4) ul li:nth-child(10)>a")
	private WebElement crack_Footer_BankPOPrelims;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(5) ul li:nth-child(1)>a")
	private WebElement resources_Footer_CEOblog;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(5) ul li:nth-child(2)>a")
	private WebElement resources_Footer_Articles;
	
	@FindBy(css=".footer-div .col-sm-2:nth-child(5) ul li:nth-child(3)>a")
	private WebElement resources_Footer_CollegePredictor;
	
	@FindBy(css="ul.bottom-content>li:nth-child(1)>a")
	private WebElement footer_AboutUs;
	
	@FindBy(css="ul.bottom-content>li:nth-child(2)>a")
	private WebElement footer_Press;
	
	@FindBy(css="ul.bottom-content>li:nth-child(3)>a")
	private WebElement footer_ContactUs;
	
	@FindBy(css="ul.bottom-content>li:nth-child(4)>a")
	private WebElement footer_TermsConditions;
	
	@FindBy(css="ul.bottom-content>li:nth-child(5)>a")
	private WebElement footer_TakeDownPolicy;
	
	@FindBy(css="ul.bottom-content>li:nth-child(6)>a")
	private WebElement footer_PrivacyPolicy;
	
	@FindBy(css="ul.bottom-content>li:nth-child(7)")
	private WebElement footer_Facebook;
	
	@FindBy(css="ul.bottom-content>li:nth-child(8)")
	private WebElement footer_Twitter;
	
	@FindBy(css="ul.bottom-content>li:nth-child(9)")
	private WebElement footer_Instagram;
	
	@FindBy(css="ul.bottom-content>li:nth-child(10)")
	private WebElement footer_Youtube;
	
	public OcularResult checkShowResultsForEngineeringButton(){
		waitUntilElementclickable(showForEngineering_Btn);
		return getElementPixelPerfectness(this, showForEngineering_Btn, "showForEngineering_Btn");
	}
	
	public OcularResult checkShowResultsForMedicalButton(){
		waitUntilElementclickable(showForMedical_Btn);
		return getElementPixelPerfectness(this, showForMedical_Btn, "showForMedical_Btn");
	}
	
	public void getPixelDataSearchResults() throws EncryptedDocumentException, InvalidFormatException, IOException{
		waitUntilElementAppears(conceptItem);
		getPixelData("Data", "201.3-a non registered user", conceptItem, "conceptItem");
		getPixelData("Data", "201.3-a non registered user", videosLayout_List, "videosLayout_List");
		getPixelData("Data", "201.3-a non registered user", pageCountPrevious_Btn, "pageCountPrevious_Btn");
		getPixelData("Data", "201.3-a non registered user", pageCountNext_Btn, "pageCountNext_Btn");
		getPixelData("Data", "201.3-a non registered user", exams_Footer_Header, "exams_Footer_Header");
		getPixelData("Data", "201.3-a non registered user", classes_Footer_Header, "classes_Footer_Header");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_Header, "mockTests_Footer_Header");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_Header, "crack_Footer_Header");
		getPixelData("Data", "201.3-a non registered user", resources_Footer_Header, "resources_Footer_Header");
		
		getPixelData("Data", "201.3-a non registered user", exams_FooterJEEMain, "exams_FooterJEEMain");
		getPixelData("Data", "201.3-a non registered user", exams_FooterNEET, "exams_FooterNEET");
		getPixelData("Data", "201.3-a non registered user", exams_FooterAIIMS, "exams_FooterAIIMS");
		getPixelData("Data", "201.3-a non registered user", exams_FooterCBSE, "exams_FooterCBSE");
		getPixelData("Data", "201.3-a non registered user", exams_FooterJEEAdvanced, "exams_FooterJEEAdvanced");
		getPixelData("Data", "201.3-a non registered user", exams_FooterBITSAT, "exams_FooterBITSAT");
		getPixelData("Data", "201.3-a non registered user", class8_Footer, "class8_Footer");
		getPixelData("Data", "201.3-a non registered user", class9_Footer, "class9_Footer");
		getPixelData("Data", "201.3-a non registered user", class10_Footer, "class10_Footer");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_JEEMain, "mockTests_Footer_JEEMain");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_JEEAdvanced, "mockTests_Footer_JEEAdvanced");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_BITSAT, "mockTests_Footer_BITSAT");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_Gujarat_CET, "mockTests_Footer_Gujarat_CET");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_AP_EAMCET, "mockTests_Footer_AP_EAMCET");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_TS_EAMCET, "mockTests_Footer_TS_EAMCET");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_NEET, "mockTests_Footer_NEET");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_AIIMS, "mockTests_Footer_AIIMS");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_BankClerkPrelims, "mockTests_Footer_BankClerkPrelims");
		getPixelData("Data", "201.3-a non registered user", mockTests_Footer_BankPOPrelims, "mockTests_Footer_BankPOPrelims");	
		getPixelData("Data", "201.3-a non registered user", crack_Footer_JEEMain, "crack_Footer_JEEMain");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_JEEAdvanced, "crack_Footer_JEEAdvanced");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_BITSAT, "crack_Footer_BITSAT");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_AP_EAMCET, "crack_Footer_AP_EAMCET");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_TS_EAMCET, "crack_Footer_TS_EAMCET");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_NEET, "crack_Footer_NEET");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_AIIMS, "crack_Footer_AIIMS");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_BankClerkPrelims, "crack_Footer_BankClerkPrelims");
		getPixelData("Data", "201.3-a non registered user", crack_Footer_BankPOPrelims, "crack_Footer_BankPOPrelims");
		
		
		getPixelData("Data", "201.3-a non registered user", resources_Footer_CEOblog, "resources_Footer_CEOblog");
		getPixelData("Data", "201.3-a non registered user", resources_Footer_Articles, "resources_Footer_Articles");
		getPixelData("Data", "201.3-a non registered user", resources_Footer_CollegePredictor, "resources_Footer_CollegePredictor");
		getPixelData("Data", "201.3-a non registered user", footer_AboutUs, "footer_AboutUs");	
		getPixelData("Data", "201.3-a non registered user", footer_Press, "footer_Press");
		getPixelData("Data", "201.3-a non registered user", footer_ContactUs, "footer_ContactUs");
		getPixelData("Data", "201.3-a non registered user", footer_TermsConditions, "footer_TermsConditions");
		getPixelData("Data", "201.3-a non registered user", footer_TakeDownPolicy, "footer_TakeDownPolicy");
		getPixelData("Data", "201.3-a non registered user", footer_PrivacyPolicy, "footer_PrivacyPolicy");
		getPixelData("Data", "201.3-a non registered user", footer_Facebook, "footer_Facebook");
		getPixelData("Data", "201.3-a non registered user", footer_Twitter, "footer_Twitter");
		getPixelData("Data", "201.3-a non registered user", footer_Instagram, "footer_Instagram");
		getPixelData("Data", "201.3-a non registered user", footer_Youtube, "footer_Youtube");	
	}
	
	public void assertSearchResultsPage(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SearchHomePage", uniqueValue);
		waitUntilElementAppears(topicHeader_Lbl,30);
		Assert.assertTrue(topicHeader_Lbl.isDisplayed(), "Not in Search Results Page");
		String text;
		if(data.get("Disambiguited?").equalsIgnoreCase("yes")){
			text = data.get("Search Text");
		}
		else
			text = data.get("Search Keyword");
		Assert.assertTrue(topicHeader_Lbl.getText().contains(text), "Not Showing Search Results for: "+text);
		Reporter.log("Navigated to Search Results Page", true);
		Reporter.log("Showing Search Results for: "+text, true);
	}
	
	public String getSearchResultTopicHeader(){
		String text = "";
		try {
			waitUntilElementAppears(topicHeader_Lbl,30);
			Thread.sleep(5000);
			mouseHoverOnElement(wdriver, topicHeader_Lbl);
			text = topicHeaderToolTip.getText();
			if(text.length()==0){
				waitUntilElementAppears(topicHeader_Lbl,30);
				Thread.sleep(5000);	
				mouseHoverOnElement(wdriver, topicHeader_Lbl);
				text = topicHeaderToolTip.getText();
			}
		} catch (Exception e) {}
		return text;
	}
	
	public void selectGoal(String goal,String exam) throws InterruptedException{
		waitUntilElementclickable(showingResultsFor_List.get(0));
		Thread.sleep(1000);
		clickElement(showingResultsForExpand_Btn, "Clicked on Show More Goals");
		Thread.sleep(1000);
	for(WebElement e:showingResultsFor_List)
			if(e.getText().equals(goal)){
				clickElement(e, "Clicked on "+e.getText());
				break;
			}
		waitUntilElementclickable(specificExam_List.get(0));
		Thread.sleep(1000);
		clickElement(specificExamExpand_Btn, "Clicked on Show more exams");
		Thread.sleep(1000);
		for(WebElement e:specificExam_List)
			if(e.getText().equals(exam)){
				clickElement(e, "Clicked on "+e.getText());
				break;
			}
			
	}

	public void waitForResultTopicHeader(){
		waitUntilElementAppears(topicHeader_Lbl,30);
	}
	
	public void mouseOverOnResultTopicHeader() throws InterruptedException{
		mouseHoverOnElement(wdriver, topicHeader_Lbl, "Mouse Overed on Result Topic Header");
	}
	
	public void mouseOverOnTakeTour() throws InterruptedException{
		mouseHoverOnElement(wdriver, takeAtour_Btn, "Mouse Overed on Take a Tour");
	}
	
	public void mouseOverOnUnlockJumpPack() throws InterruptedException{
		scrollToElementViaJavascript(unlockJumpPack_Btn);
		scrollVertically("-100");
		mouseHoverOnElement(wdriver, unlockJumpPack_Btn, "Mouser Overed on Unlock Jump Pack");
	}
	
	public void mouseOverOnGoToWikipedia() throws InterruptedException{
		scrollToElementViaJavascript(goToWikipedia_Btn);
		scrollVertically("-100");
		mouseHoverOnElement(wdriver, goToWikipedia_Btn, "Mouse Overed On Go To Wikipedia");
	}
	
	public void mouseOverOnAskButton() throws InterruptedException{
		scrollToElementViaJavascript(askQuestion_Btn);
		scrollVertically("-100");
		mouseHoverOnElement(wdriver, askQuestion_Btn, "Mouse Overed on Ask Button");
	}
	
	public void mouseOverOnBeharivioralMeterStatusText() throws InterruptedException{
		scrollToElementViaJavascript(behavioralMeterStatus_Lbl);
		scrollVertically("-100");
		mouseHoverOnElement(wdriver, behavioralMeterStatus_Lbl, "Mouse Overed on Behavioral Meter Status");
	}
	
	@FindBy(css=".react-typeahead-input.react-typeahead-usertext")
	private WebElement search_TB;
	
	public void editSearchField() throws InterruptedException{
		Thread.sleep(2000);
		for(int i=0;i<=5;i++){
			search_TB.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(1000);
		}
		wdriver.findElement(By.cssSelector(".react-typeahead-input.react-typeahead-usertext")).sendKeys(" fine ");
		Thread.sleep(3000);
	}
	
	@FindBy(css="div.unlock-button")
	private WebElement unlockJumpBtn;
	
	@FindBy(css="div.repeatables-container>div.heading")
	private WebElement popularSearches_widget;
	
	public void widgets(){
		scrollToElementViaJavascript(topicDescription_Lbl);
		Assert.assertTrue(topicDescription_Lbl.isDisplayed(), "Related 'Topic Description' is not present");
		Reporter.log("'Topic Description' widget is present",true );
		scrollToElementViaJavascript(takeAtour_Btn);
		Assert.assertTrue(takeAtour_Btn.isDisplayed(), "'Take a tour' button is not present");
		Reporter.log("'Take a tour' widget is present",true );
		scrollToElementViaJavascript(unlockJumpBtn);
		Assert.assertTrue(unlockJumpBtn.isDisplayed(), "'Unlock' button is not present");
		Reporter.log("'Unlock' widget is present",true );
		scrollToElementViaJavascript(behavioralMeterStatus_Lbl);
		Assert.assertTrue(behavioralMeterStatus_Lbl.isDisplayed(), "'BEHAVIOUR SOCIAL METER' is not present");
		Reporter.log("'BEHAVIOUR SOCIAL METER' widget is present",true );
		scrollToElementViaJavascript(askQuestion_TB);
		Assert.assertTrue(askQuestion_TB.isDisplayed(), "'Ask a Question' widget is not present");
		Reporter.log("'Ask a Question' widget is present",true );
		scrollToElementViaJavascript(popularSearches_widget);
		Assert.assertTrue(popularSearches_widget.isDisplayed(), "'Popular Searches' widget is not present");
		Reporter.log("'Popular Searches' widget is present",true );
	}
	
	//Showing Results Objects

	@FindBy(xpath="//*[@class='srOptions']/ul/li")
	private List<WebElement> showingResultsGoalList;
	
	@FindBy(css="div.srLine1 div.srOptions>ul>li.srOptionItem.expand")
	private WebElement goalExpand_Btn;
	
	@FindBy(css="div.srLine1 div.srOptions>ul>li.srOptionItem.collapse")
	private WebElement goalCollapse_Btn;
	
	//Specific Exam Objects
	
	@FindBy(xpath="//*[@class='srLine2']/div[2]/ul/li")
	private List<WebElement> specificExamList;
	
	@FindBy(css=".srOptionItem.expand")
	private WebElement examExpand_Btn;
	
	@FindBy(css=".srOptionItem.collapse")
	private WebElement examCollapse_Btn;
	
	public void showingResults_Goals(){
		List<WebElement> list =showingResultsGoalList;
		Reporter.log("Showing Results for : ",true);
		for(WebElement ele:list){
			Reporter.log(ele.getText(),true);
		}
	}
	
	public void clickGoalExpandButton(){
		waitUntilElementAppears(goalExpand_Btn);
		clickElement(goalExpand_Btn);
		Reporter.log("Clicked on Show Results 'Expand' button",true);
	}
	
	public void clickGoalCollapseButton(){
		waitUntilElementAppears(goalCollapse_Btn);
		clickElement(goalCollapse_Btn);
		Reporter.log("Clicked on Show Results 'Collapse' button",true);
	}
	
	public void select_showingResults_Goal(int i){
		String examName=wdriver.findElement(By.xpath("(//*[@class='srOptions']/ul/li)["+i+"]")).getText();
		clickElement(wdriver.findElement(By.xpath("(//*[@class='srOptions']/ul/li)["+i+"]")));
		Reporter.log("Cliked on : '"+examName+"'",true);
	}

	public void getspecificExamsList(){
		List<WebElement> list =specificExamList;
		Reporter.log("Specific Exams are : ",true);
		for(WebElement ele:list){
			Reporter.log(ele.getText(),true);
		}
	}
	
	public void clickExamExpandButton(){
		waitUntilElementAppears(examExpand_Btn);
		clickElement(examExpand_Btn);
		Reporter.log("Clicked on Specific Exam's 'Expand' button",true);
	}
	
	public void clickExamCollapseButton(){
		waitUntilElementAppears(examCollapse_Btn);
		clickElement(examCollapse_Btn);
		Reporter.log("Clicked on Specific Exam's 'Collapse' button",true);
	}


}
