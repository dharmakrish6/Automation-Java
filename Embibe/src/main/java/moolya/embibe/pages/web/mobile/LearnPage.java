package moolya.embibe.pages.web.mobile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomationguru.ocular.snapshot.Snap;


@Snap(value="LearnPage.png")
public class LearnPage extends W_BasePage {

	public LearnPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(css="div.desp-content")
	private WebElement desciption_Lbl;

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
	
	
	@FindBy(css="div.concept>div.heading")
	private WebElement conceptsHeading_Lbl;

	@FindBy(css="div.concept li div.conceptItem")
	private List<WebElement> conceptName_List;

	@FindBy(css="div.concept li div.important")
	private List<WebElement> importantFor_List;

	@FindBy(css="div.concept-more")
	private WebElement seeMore_Link;
	
	@FindBy(css="div.cheatSheetWrap li.cheatItem")
	private List<WebElement> cheatSheetPoints_List;

	@FindBy(css="div.cheatSheetWrap div.cheatMore")
	private WebElement cheatSeeMore_Link;
	
	@FindBy(css="li.raqItem")
	private List<WebElement> recentlyAskedQuestions_List;

	@FindBy(css="div.askWrapper input.inputQuestion")
	private WebElement askQuestion_TB;

	@FindBy(css="div.askWrapper div.askButton")
	private WebElement askQuestion_Btn;
	
	@FindBy(css="div.wikiLinks li>div.index")
	private List<WebElement> contentIndex_List;
	
	@FindBy(css="div.wikiLinks li>div.indexElement>a")
	private List<WebElement> contentLinks_List;
	
	@FindBy(css="button.ytp-large-play-button")
	private WebElement importantVideoPlay_Btn;
	
	@FindBy(css="div.playlist div.videos-list li.video-list-item")
	private List<WebElement> importantVideos_List;
	
	@FindBy(css="div.playlist div.videos-list li.video-list-item div.videoDetail div.videoTitle")
	private List<WebElement> importantVideoTitle_List;
	
	@FindBy(css="div.playlist div.videos-list li.video-list-item div.videoDetail div.videoTime")
	private List<WebElement> importantVideoTime_List;
	
	@FindBy(css="div.DidYouKnowWrapper div.dykHead")
	private WebElement didYouKnowHead_Lbl;
	
	@FindBy(css="div.DidYouKnowWrapper div.dykContent")
	private WebElement didYouKnowContent_Lbl;
	
	@FindBy(css="div.DidYouKnowWrapper div.dykEmbiums")
	private WebElement didYouKnowEmbiums_Lbl;
	
	
	

}
