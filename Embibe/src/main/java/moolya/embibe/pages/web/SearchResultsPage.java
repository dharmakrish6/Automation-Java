package moolya.embibe.pages.web;

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

	@FindBy(css=".react-typeahead-input.react-typeahead-hint")
	private WebElement searchHint_TB;


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

	@FindBy(css="a.linkMore")
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

	@FindBy(xpath="//div[text()='Most Viewed Videos']/..//div[@class='customer-swiper-conatiner']")
	private WebElement videosLayout_List;

	@FindBy(xpath="//div[contains(text(),'Concepts in')]/following-sibling::div")
	private WebElement conceptsInWrapper;

	@FindBy(xpath="//*[contains(@class,'practice-question-container')]//div[@class='header']/p[text()='Most important questions']/../../..")
	private WebElement mostImportantQuestionsPracticeContainer;

	@FindBy(xpath="//*[contains(@class,'practice-question-container')]//div[@class='header']/p[text()='Previous year questions']/../../..")
	private WebElement previousYearQuestionsContainer;

	@FindBy(xpath="//*[contains(@class,'practice-question-container')]//div[@class='header']/p[text()='Questions rankers got wrong']/../../..")
	private WebElement questionsRankersGotWrongContainer;

	@FindBy(css=".unlockJumpWrapper")
	private WebElement unlockJumpWrapper;

	@FindBy(css=".cheatSheetWrap .border")
	private WebElement cheatSheetWrapper;

	@FindBy(xpath="//div[contains(@class,'heading') and text()='Chapter Test']/..//div[@class='testWrap']")
	private WebElement chapterTestContainer;

	@FindBy(xpath="//div[contains(@class,'progress-wrapper')]/..")
	private WebElement practiceProgressWrapper;

	@FindBy(css=".askWrapper")
	private WebElement askWrapper;

	@FindBy(css=".repeatables-container .border")
	private WebElement popularSearchesContainer;

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

	@FindBy(css=".didWrap>div>div")
	private WebElement didYouMean_Lbl;

	@FindBy(css=".didWrap .button-hollow")
	private List<WebElement> didYouMeanTermsBtns_List;

	@FindBy(xpath="//div[@class='heading' and text()='Are you looking for']")
	private WebElement areYouLookingFor_Lbl;

	@FindBy(xpath="//div[@class='heading' and text()='Are you looking for']/following-sibling::div//*[contains(@class,'button-hollow')]")
	private List<WebElement> areYouLookingForItems_List;

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

		getPixelData("Data", "201.3-a non registered user", conceptsInWrapper, "conceptsInWrapper");
		getPixelData("Data", "201.3-a non registered user", mostImportantQuestionsPracticeContainer, "mostImportantQuestionsPracticeContainer");
		getPixelData("Data", "201.3-a non registered user", previousYearQuestionsContainer, "previousYearQuestionsContainer");
		getPixelData("Data", "201.3-a non registered user", questionsRankersGotWrongContainer, "questionsRankersGotWrongContainer");
		getPixelData("Data", "201.3-a non registered user", unlockJumpWrapper, "unlockJumpWrapper");
		getPixelData("Data", "201.3-a non registered user", cheatSheetWrapper, "cheatSheetWrapper");
		getPixelData("Data", "201.3-a non registered user", chapterTestContainer, "chapterTestContainer");
		getPixelData("Data", "201.3-a non registered user", practiceProgressWrapper, "practiceProgressWrapper");
		getPixelData("Data", "201.3-a non registered user", askWrapper, "askWrapper");
		getPixelData("Data", "201.3-a non registered user", popularSearchesContainer, "popularSearchesContainer");

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
	
	public String getLearnMoreLink(){
		waitUntilElementclickable(learMore_Link);
		return learMore_Link.getAttribute("href");
	}

	public String getSearchResultTopicHeader(){
		String text = "";
		try {
			Thread.sleep(3000);
			topicHeader_Lbl.isDisplayed();
			waitUntilElementAppears(topicHeader_Lbl);
			Thread.sleep(3000);
			text = topicHeader_Lbl.getText();
			if(text.contains("...")){
				try {
					mouseHoverOnElement(wdriver, topicHeader_Lbl);
					text = topicHeaderToolTip.getText();
				} catch (Exception e) {}
			}
		} catch (Exception e) {
			waitUntilElementAppears(search_TB);
			text  = searchHint_TB.getAttribute("value");
			if(text.length()==0){
				text = search_TB.getAttribute("value");
			}
		}
		return text;
	}
	
	public NewLearnPage clickLearnMore(){
		waitUntilElementclickable(learMore_Link);
		learMore_Link.click();
		return new NewLearnPage(wdriver);
	}

	public String getSearchResultText(){
		String text = "";
		try {
			waitUntilElementAppears(search_TB);
			Thread.sleep(2000);
			text = searchHint_TB.getAttribute("value");
			if(text.length()==0)
				text = search_TB.getAttribute("value");
		} catch (Exception e) {}
		return text;
	}

	@FindBy(css=".goal-approval-button")
	private WebElement goalApproval_Btn;

	@FindBy(css=".srLine1 .srOptionItem.option-selected")
	private WebElement currentGoal_Btn;

	@FindBy(css=".srLine2 .srOptionItem.option-selected")
	private WebElement currentExam_Btn;

	public void selectGoal(String goal,String exam) throws InterruptedException{
		if(!goal.equals("na")){
			try {
				waitUntilElementclickable(showingResultsFor_List.get(0));
				Thread.sleep(500);
				for(WebElement e:showingResultsFor_List)
					if(e.getText().equals(goal)){
						clickElement(e, "Clicked on "+e.getText());
						Thread.sleep(500);
						waitUntilElementclickable(goalApproval_Btn);
						goalApproval_Btn.click();
						break;
					}
			} catch (Exception e) {}
		}
		if(!exam.equals("na")){
			Thread.sleep(500);
			try {
				waitUntilElementclickable(specificExam_List.get(0));
				specificExamExpand_Btn.click();
				Reporter.log("Clicked on Show more exams", true);
				Thread.sleep(500);
			} catch (Exception e1) {}
			try {
				for(WebElement e:specificExam_List)
					if(e.getText().equals(exam)){
						clickElement(e, "Clicked on "+e.getText());
						break;
					}
			} catch (Exception e) {}
		}

	}

	public String getValidGoals() throws InterruptedException{
		String text = "";
		try {
			waitUntilElementclickable(showingResultsFor_List.get(0));
			Thread.sleep(500);
			for(WebElement e:showingResultsFor_List){
				String s = e.getText();
				if(text.length()==0)
					text = s;
				else
					text = text + "\n" + s;
			}
		} catch (Exception e) {}
		return text;
	}
	
	public String getValidExams() throws InterruptedException{
		String text = "";
		
		try {
			waitUntilElementclickable(specificExam_List.get(0));
			Thread.sleep(500);
			specificExamExpand_Btn.click();
			Reporter.log("Clicked on Show more exams", true);
			Thread.sleep(500);
		} catch (Exception e1) {}
		try {
			for(WebElement e:specificExam_List){
				String s = e.getText();
				if(text.length()==0)
						text = s;
					else
						text = text + "\n" + s;
			}
		} catch (Exception e) {}
		return text;
	}

	public String getCurrentGoal(){
		try {
			waitUntilElementAppears(showingResultsFor_List.get(0));
			return currentGoal_Btn.getText();
		} catch (Exception e) {}
		return "";
	}

	public String getCurrentExam(){
		try {
			waitUntilElementAppears(showingResultsFor_List.get(0));
			return currentExam_Btn.getText();
		} catch (Exception e) {}
		return "";
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

	public void waitForSearchResultsPage() throws InterruptedException{
		String urlText = "search?q";
		while(!wdriver.getCurrentUrl().contains(urlText)){
			Thread.sleep(200);
		}
	}

	public SearchHomepage clearSearchText() throws InterruptedException{
		while(search_TB.getAttribute("value").length()>0){
			search_TB.sendKeys(Keys.BACK_SPACE);
		}
		return new SearchHomepage(wdriver);
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

	@FindBy(css="div.swiper-slide:nth-child(2)")
	private WebElement scrolltoExams;

	@FindBy(xpath="//*[@class='entry-title']")
	private WebElement examTitle;

	@FindBy(css="div.title-area>p.site-title")
	private WebElement examPageEmbibeLogo;

	@FindBy(css="img.global-nav__logo:nth-child(1)")
	private WebElement embibeLogo_mockTest;


	public void clickExamPageEmbibeLogo_SRP(){
		try{
			waitUntilElementAppears(examPageEmbibeLogo);
			clickElement(examPageEmbibeLogo);
			Reporter.log("Clicked on Embibe Logo", true);
			assertSearchHomepage();
		}
		catch(Exception e){
			waitUntilElementAppears(embibeLogo_mockTest);
			clickElement(embibeLogo_mockTest);
			Reporter.log("Clicked on Embibe Logo", true);
			assertSearchHomepage();
		}

	}

	@FindBy(xpath="(//*[contains(text(),'Use precise location')])[1]")
	private WebElement examFooter;

	@FindBy(xpath="//*[@class='site-title']/a")
	private WebElement title_examPageEmbibeLogo;

	public void examLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(5000);
		scrollToElementViaJavascript(examFooter);
		Thread.sleep(2000);
		clickElement(wdriver.findElement(By.xpath("((//*[@class='no-underline-link']/../../../ul)[1]/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		Thread.sleep(10000);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		waitUntilElementAppears(examTitle);
		Assert.assertTrue(examTitle.isDisplayed(), "Navigation failed");
		Reporter.log("Navigated to " + wdriver.getCurrentUrl() ,true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		Reporter.log("Page Title : '" + examTitle.getText(), true);
		title_examPageEmbibeLogo.click();
		Reporter.log("Clicked on Embibe logo",true);
		assertSearchHomepage();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
		//System.out.println("switched to parent window");
	}

	@FindBy(css=".global-nav__left>a>img")
	private WebElement embibeLogo_Ask;

	public void classesLinks(int i,String examType,String className,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(examFooter);
		clickElement(wdriver.findElement(By.xpath("((//*[@class='no-underline-link']/../../../ul)[2]/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Assert.assertTrue(wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]")).isDisplayed(), "Navigation failed");
		WebElement classNum=wdriver.findElement(By.xpath("(//*[contains(text(),'"+className+"')])[2]"));

		Reporter.log("Navigated to " + wdriver.getCurrentUrl(), true);
		Reporter.log("Class Name : '" + classNum.getText(), true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		embibeLogo_Ask.click();
		Reporter.log("Clicked on Embibe Logo", true);
		assertSearchHomepage();
		wdriver.close();
		Reporter.log("Closed the Rankup signup window",true);
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
		scrollToElementViaJavascript(examFooter);
		clickElement(wdriver.findElement(By.xpath("((//*[@class='no-underline-link']/../../../ul)[3]/li/a)["+i+"]")));
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
		embibeLogo_mockTest.click();
		Reporter.log("Clicked on Embibe Logo");
		assertSearchHomepage();
		//clickExamPageEmbibeLogo_SRP();
		wdriver.close();
		wdriver.switchTo().window(winHandleBefore);
	}

	public void crackTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(examFooter);
		clickElement(wdriver.findElement(By.xpath("((//*[@class='no-underline-link']/../../../ul)[4]/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		wdriver.close();
		Reporter.log("Closed the Rankup signup window",true);
		wdriver.switchTo().window(winHandleBefore);
	}



	public void resourcesTestsLinks(int i,String examType,String expURL) throws InterruptedException{
		Reporter.log("----------------------------------------------------------------------------------------------",true);
		Thread.sleep(2000);
		scrollToElementViaJavascript(examFooter);
		clickElement(wdriver.findElement(By.xpath("((//*[@class='no-underline-link']/../../../ul)[5]/li/a)["+i+"]")));
		Reporter.log("Clicked on "+ examType, true);
		String winHandleBefore = wdriver.getWindowHandle();
		for (String winHandle : wdriver.getWindowHandles()) {
			wdriver.switchTo().window(winHandle);
		}
		Thread.sleep(10000);
		Reporter.log("Navigated to " + wdriver.getCurrentUrl(),true);
		Assert.assertEquals(wdriver.getCurrentUrl(),expURL);
		wdriver.close();
		Reporter.log("Closed the "+examType+" window",true);
		wdriver.switchTo().window(winHandleBefore);
	}

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

	@FindBy(css=".derivedAndLeadsWrap .heading")
	private WebElement relatedConcepts_Lbl;

	public void scrollToRelatedConcepts(){
		scrollToElementViaJavascript(relatedConcepts_Lbl);
	}

	public void getWidgetsOrder(){
		String[] widgetClassArray = new String[]{"topic-head","askWrapper",
				"concept-more","cheatSheetWrap"};
		String[] widgetStringArray = new String[]{"Practice for","Most Viewed Videos","Chapter Test"};
		HashMap<String, String> widgetMap = new HashMap<String, String>(){{
			put("topic-head", "description");put("askWrapper","ask-box");put("concept-more","chapter-concepts");
			put("cheatSheetWrap","cheat-sheet");put("Practice for","practice-set");
			put("Most Viewed Videos","curated-videos");put("Chapter Test","chapter-tests");}};
			String srDiv = "";
			for(int i=0;i<widgetClassArray.length;i++){
				if(srDiv.length()==0)
					srDiv = "//*[contains(@class,'"+widgetClassArray[i]+"')";
				else
					srDiv = srDiv + " or " + "contains(@class,'"+widgetClassArray[i]+"')";
			}
			for(int i=0;i<widgetStringArray.length;i++){
				srDiv = srDiv + " or " + "contains(text(),'"+widgetStringArray[i]+"')";
			}
			srDiv = srDiv + "]";
			List<WebElement> searchResultsDiv = wdriver.findElements(By.xpath(srDiv));
			int length = searchResultsDiv.size();
			for(int i=0;i<length;i++){
				String className = searchResultsDiv.get(i).getAttribute("class");
				String text = searchResultsDiv.get(i).getText();
				for(int j=0;j<widgetClassArray.length;j++){
					if(className.contains(widgetClassArray[j])){
						String cls = widgetMap.get(widgetClassArray[j]);
						System.out.println("Widget: "+cls);
					}
				}
				for(int j=0;j<widgetStringArray.length;j++){
					if(text.contains(widgetStringArray[j])){
						String txt = widgetMap.get(widgetStringArray[j]);
						System.out.println("Widget: "+txt);
					}
				}

			}
	}

	public String getWidgetsOrder(int maxLength) throws InterruptedException{
		String actualWidgets = "";
		String[] widgetClassArray = new String[]{"topic-head",
				"concept-more","cheatSheetWrap","progressHeading"};	//"askWrapper",
		String[] widgetStringArray = new String[]{"Practice for","Most Viewed Videos","Chapter Test",
				"Wikipedia for","Related Concepts","Full Test","Part Test","Videos on","Previous Year Paper","11th Revision Test"};
		HashMap<String, String> widgetMap = new HashMap<String, String>(){{
			put("topic-head", "description");put("askWrapper","ask-box");
			put("concept-more","chapter-concepts");put("cheatSheetWrap","cheat-sheet");
			put("Practice for","practice-set");put("Most Viewed Videos","curated-videos");
			put("Chapter Test","chapter-tests");put("progressHeading","practice-actionables");
			put("Full Test","full-tests");put("Part Test","unit-tests");
			put("Wikipedia for","wikipedia");put("Videos on","all-videos");
			put("Previous Year Paper","previous-year-test");put("11th Revision Test","11th-revision");
			put("Related Concepts","related-concepts");}};
			String srDiv = "";
			for(int i=0;i<widgetClassArray.length;i++){
				if(srDiv.length()==0)
					srDiv = "//*[contains(@class,'"+widgetClassArray[i]+"')";
				else
					srDiv = srDiv + " or " + "contains(@class,'"+widgetClassArray[i]+"')";
			}
			for(int i=0;i<widgetStringArray.length;i++){
				srDiv = srDiv + " or " + "contains(text(),'"+widgetStringArray[i]+"')";
			}
			srDiv = srDiv + "]";
			List<WebElement> searchResultsDiv = wdriver.findElements(By.xpath(srDiv));
			int length = searchResultsDiv.size();
			if(length>maxLength)
				length=maxLength;
			for(int i=0;i<length;i++){
				String className = searchResultsDiv.get(i).getAttribute("class");
				String text = searchResultsDiv.get(i).getText();
				for(int j=0;j<widgetClassArray.length;j++){
					if(className.contains(widgetClassArray[j])){
						String widgetType = widgetMap.get(widgetClassArray[j]);
						String widgetName = getWidgetName(widgetType, searchResultsDiv.get(i));
						//					String widgetValue = getWidgetValue(widgetType, searchResultsDiv.get(i));
						String widget = widgetType + "=" + widgetName;
						//					if(widgetValue.length()!=0)
						//						widget = widget + "," +widgetValue;
						if(actualWidgets.length()==0)
							actualWidgets = widget;
						else
							actualWidgets = actualWidgets + "\n" + widget;
					}
				}
				for(int j=0;j<widgetStringArray.length;j++){
					if(text.contains(widgetStringArray[j]) && !searchResultsDiv.get(i).getAttribute("class").equals("toolTip")){
						String widgetType = widgetMap.get(widgetStringArray[j]);
						String widgetName = getWidgetName(widgetType, searchResultsDiv.get(i));
						//					String widgetValue = getWidgetValue(widgetType, searchResultsDiv.get(i));
						String widget = widgetType + "=" + widgetName;
						//					if(widgetValue.length()!=0)
						//						widget = widget + "," +widgetValue;
						if(actualWidgets.length()==0)
							actualWidgets = widget;
						else
							actualWidgets = actualWidgets + "\n" + widget;
					}
				}

			}
			return actualWidgets;
	}

	public String getWidgetName(String type,WebElement e) throws InterruptedException{
		String text = "";
		switch(type){
		case "chapter-concepts"	:	text = e.findElement(By.xpath("../preceding-sibling::div")).getText();
		break;
		case "cheat-sheet"	:	text = e.findElement(By.xpath("div[1]")).getText();
		break;
		case "practice-set"	:	text = e.getText();	
		if(text.contains("...")){
			mouseHoverOnElement(wdriver, e);
			text = e.findElement(By.xpath("div[@class='toolTip']")).getText();
		}
		break;
		default	:	text = e.getText();	//description,curated-videos,chapter-tests,practice-actionables,full-tests
		break;
		}

		return text;
	}

	public String getWidgetValue(String type,WebElement e){
		String text = "";
		switch(type){
		case "chapter-concepts"	:	List<WebElement> concepts = e.findElements(By.xpath("./preceding-sibling::ul/a/li/div"));
		for(WebElement concept:concepts){
			String s = concept.getText();
			if(text.length()==0)
				text = s;
			else
				text = text + "+" + s;
		}
		break;
		case "curated-videos"	:	List<WebElement> videos = e.findElements(By.xpath("./following-sibling::div//p"));
		int length = videos.size();
		if(length>10)
			length = 10;
		for(int i=0;i<length;i++){
			String s = videos.get(i).getText();
			if(text.length()==0)
				text = s;
			else
				text = text + "+" + s;
		}
		break;
		case "chapter-tests" : List<WebElement> tests = e.findElements(By.xpath("./following-sibling::div//a"));
		for(WebElement test:tests){
			String s = test.getText();
			if(text.length()==0)
				text = s;
			else
				text = text + "+" + s;
		}
		break;
		default : break;
		}

		return text;
	}

	public String getDymAlaTerms(String type) throws InterruptedException{
		String terms = "";
		Thread.sleep(5000);
		if(type.equals("dym")){
			waitUntilElementAppears(didYouMean_Lbl);
			for(WebElement e:didYouMeanTermsBtns_List){
				String term = e.getText();
				if(terms.length()==0)
					terms = term;
				else
					terms = terms + "\n" + term;
			}
		}else{
			waitUntilElementAppears(areYouLookingFor_Lbl);
			for(WebElement e:areYouLookingForItems_List){
				String term = e.getText();
				if(terms.length()==0)
					terms = term;
				else
					terms = terms + "\n" + term;
			}
		}
		return terms;
	}

	@FindBy(css=".react-typeahead-container li>div")
	private List<WebElement> suggestions_List;

	public String getSuggestions() throws InterruptedException{
		String text = "";
		waitUntilElementAppears(search_TB);
		search_TB.sendKeys(Keys.DOWN);
		Thread.sleep(500);
		for(WebElement e: suggestions_List){
			String suggestion = e.getText();
			if(text.length()==0)
				text = suggestion;
			else
				text = text + "\n" + suggestion;
		}
		return text;
	}


}
