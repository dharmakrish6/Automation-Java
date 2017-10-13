package moolya.embibe.pages.web;

import java.io.IOException;
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

@Snap(value="LandingPage-#{Element}.png")
public class LandingPage extends W_BasePage {

	public LandingPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//a[@class='get-started' and text()='START NOW']")
	private WebElement startNow_Btn;
	
	@FindBy(xpath="(//*[@class='logo-layer-1'])[1]")
	private WebElement LP_embibe_logo;
	
	@FindBy(css="#about .logo-layer-1>img")
	private WebElement embibeLogoStartNow;
	
	@FindBy(css="#about h2")
	private WebElement scoreHigher_Lbl;
	
	@FindBy(css="#landing .page-inner")
	private WebElement videoLayout;
	
	@FindBy(css="#landing .page-inner .lava-link.passage")
	private WebElement videoEmotionLayout;
	
	@FindBy(css="#work .lava-link.passage")
	private WebElement ktEmotionLayout;
	
	
	
	@FindBy(css="div.video-wrapper div.video.cover video")
	private WebElement videoLoop_Video;
	
	@FindBy(css="div.inner")
	private WebElement video;
	
	@FindBy(css="div.page-inner div#title-zone div.tagline-wrap>span")
	private WebElement videoText1_Lbl;
	
	@FindBy(css="div.page-inner div#title-zone div.rw-words>span")
	private List<WebElement> videoText2_List;
	
	@FindBy(css="div.page-inner div#title-zone h2.tagline-light")
	private WebElement videoText3_Lbl;
	
	@FindBy(css="div.page-inner div#title-zone h2.tagline-bold")
	private WebElement videoText4_Lbl;
	
	@FindBy(css="div.vis-network>canvas")
	private WebElement kt_Canvas;
	
	@FindBy(css="#search .logo-layer-1>img")
	private WebElement embibeLogoSearchNow;
	
	@FindBy(css="#search h2")
	private WebElement startLearning_Lbl;
	
	@FindBy(xpath="//a[@class='get-started' and text()='SEARCH NOW']")
	private WebElement searchNow_Btn;
	
	@FindBy(css="div#work div.lava-link.passage h2:nth-child(1)>span:nth-child(1)")
	private WebElement ktText1_Lbl;
	
	@FindBy(css="div#work div.lava-link.passage h2:nth-child(1)>span:nth-child(2)")
	private WebElement ktText2_Lbl;
	
	@FindBy(css="div#work div.lava-link.passage div.tagline-wrap")
	private WebElement ktText3_Lbl;
	
	@FindBy(css="div#work div.lava-link.passage div.tagline-wrap>div.rw-words>span")
	private List<WebElement> ktText4_List;
	
	@FindBy(css="div#work div.lava-link.passage h2:nth-child(2)")
	private WebElement ktText5_Lbl;
	
	public void landingPageEmbibeLogo(){
		waitUntilElementAppears(LP_embibe_logo);
		Assert.assertTrue(LP_embibe_logo.isDisplayed(), "Embibe logo is not present in the landing page");
		Reporter.log("Embibe logo is present in the landing page",true);
	}
	
	public void scoreHigher_StartNow_Text(){
		waitUntilElementAppears(scoreHigher_Lbl);
		Assert.assertTrue(scoreHigher_Lbl.isDisplayed(), "ScoreHigher Label is not present in the landing page");
		Reporter.log("ScoreHigher Label is present in the landing page",true);
		waitUntilElementAppears(startNow_Btn);
		Assert.assertTrue(startNow_Btn.isDisplayed(), "StartNow text is not present in the landing page");
		Reporter.log("StartNow text is present in the landing page",true);
		
	}
	
	public void landingPageScrollingScreens() throws InterruptedException{
		mouseHoverOnKt();
		mouseHoverOnVideo();//
		
		
		mouseHoverOnKt();
		mouseHoverOnVideo();//
		
		scrollToElementViaJavascript(startLearning_Lbl);
		Reporter.log("Able to scroll from 'start now' to 'search now' segments successfuly",true);
		
	}
	
	public void startLearning_SearchNow_Text() throws InterruptedException{
		mouseHoverOnKt();
		waitUntilElementAppears(startLearning_Lbl);
		Assert.assertTrue(startLearning_Lbl.isDisplayed(), "StartLearning Label is not present in the landing page");
		Reporter.log("StartLearning Label is present in the landing page",true);
		waitUntilElementAppears(searchNow_Btn);
		Assert.assertTrue(searchNow_Btn.isDisplayed(), "SearchNow text is not present in the landing page");
		Reporter.log("SearchNow text is present in the landing page",true);
	}
	
	public void waitForLandingPageToLoad(){
		try{
			waitUntilElementclickable(startNow_Btn);
			Reporter.log("Landing Page is Loaded", true);
		}catch(Exception e){
			Assert.fail("Landing Page is not Loaded");
		}
	}
	
	public void assertLandingPage(){
		Assert.assertTrue(startNow_Btn.isDisplayed(), "Not in Landing Page!");
		Reporter.log("Navigated to Landing Page", true);
	}
	
	public SearchHomepage clickStartNow(){
		clickElement(startNow_Btn,"Clicked on Start Now Button");
		return new SearchHomepage(wdriver);
	}
	
	public void mouseHoverOnKt() throws InterruptedException{
		mouseHoverOnElement(wdriver, kt_Canvas, "Mouse Hovered on Knowledge Tree");
	}
	
	public void mouseHoverOnVideo() throws InterruptedException{
		Thread.sleep(1000);
//		wdriver.switchTo().frame(0);
//		double x = wdriver.manage().window().getSize().width * 0.80;
//		double y = wdriver.manage().window().getSize().height * 0.5;
//		mouseHover(wdriver,(int) x,(int) y);
		mouseHoverOnElement(wdriver, video);
//		wdriver.switchTo().defaultContent();
	}
	
	public void scrollRight() throws InterruptedException{
		mouseHover(wdriver, kt_Canvas, -50, 0, "Scrolled Page Right");
	}
	
	public void scrollLeft() throws InterruptedException{
		mouseHoverOnElement(wdriver, kt_Canvas, "Scrolled Page Left");
	}
	
	public SearchHomepage clickSearchNow(){
		clickElement(searchNow_Btn);
		return new SearchHomepage(wdriver);
	}
	
	public OcularResult getPixelPerfectnessStartNowBtn(){
		waitUntilElementAppears(startNow_Btn);
		return getElementPixelPerfectness(this, startNow_Btn, "startNow_Btn");
	}
	
	public void getPixelDataLandingPage() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		waitUntilElementclickable(startNow_Btn);
		getPixelData("Data", "Landing_Web1", embibeLogoStartNow, "embibeLogoStartNow");
		getPixelData("Data", "Landing_Web1", scoreHigher_Lbl, "scoreHigher_Lbl");
		getPixelData("Data", "Landing_Web1", startNow_Btn, "startNow_Btn");
		getPixelData("Data", "Landing_Web1", videoLayout, "videoLayout");
		getPixelData("Data", "Landing_Web1", videoEmotionLayout, "videoEmotionLayout");
		mouseHoverOnKt();
		waitUntilElementAppears(searchNow_Btn);
		getPixelData("Data", "Landing_Web3", ktEmotionLayout, "ktEmotionLayout");
		getPixelData("Data", "Landing_Web3", kt_Canvas, "kt_Canvas");
		getPixelData("Data", "Landing_Web3", embibeLogoSearchNow, "embibeLogoSearchNow");
		getPixelData("Data", "Landing_Web3", startLearning_Lbl, "startLearning_Lbl");
		getPixelData("Data", "Landing_Web3", searchNow_Btn, "searchNow_Btn");
	}
	
	

}
