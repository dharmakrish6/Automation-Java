package moolya.embibe.tests.web.segmentio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.testautomationguru.ocular.comparator.OcularResult;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.embibe.pages.web.ChooseMissionPage;
import moolya.embibe.pages.web.LandingPage;
import moolya.embibe.pages.web.LoginPage;
import moolya.embibe.pages.web.LogoutPage;
import moolya.embibe.pages.web.LogoutSignInPage;
import moolya.embibe.pages.web.SearchHomepage;
import moolya.embibe.pages.web.SearchResultsPage;
import moolya.embibe.pages.web.SignUpPage;
import moolya.embibe.pages.web.W_BasePage;
import moolya.embibe.utils.SqliteUtils;

public class HeadersTest{

	String os;
	private LandingPage lp;
	private SearchHomepage shp;
	private W_BasePage basepage;
	private WebDriver wdriver;
	private OcularResult or;
	private LoginPage lop;
	private SearchResultsPage srp;
	private ChooseMissionPage cmp;
	private LogoutSignInPage lsp;
	private LogoutPage loutp;
	private LoginPage loginPage;
	private String uniqueValue = "HeadersTest";
	private String count;
	private String email;
	private SignUpPage sup;
	
	@Test
	@Parameters({"browser"})
	public void dummyTest(@Optional("chrome")String browser) throws IOException, NoSuchFieldException, SecurityException, ATUTestRecorderException, InterruptedException, EncryptedDocumentException, InvalidFormatException, ClassNotFoundException {
		
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp(browser);
		lp = new LandingPage(wdriver);
		lp.waitForLandingPageToLoad();
		shp = lp.clickStartNow();
		shp.assertSearchHomepage();
		shp.clickEmbibeLogo();
		shp.mouseHoverOnAsk();
		shp.clickAsk();
		shp.navigateBack();
		shp.mouseHoverOnStudy();
		shp.clickStudy();
		shp.mouseHoverOnJump();
		shp.clickJump();
		shp.navigateBack();
		shp.mouseHoverOnRankUp();
		shp.clickRank();
		shp.navigateBack();
		shp.mouseHoverOnInstitutes();
		shp.clickInstitutes();
		shp.navigateBack();
		shp.clickEmbiumStatus();
		shp.clickProfileIcon();
		shp.clickLogin();
		loginPage = shp.clickForgotPassword();
		shp = loginPage.closeForgotPassword();
		shp.clickLogin();
		shp.clickFbLogin();
		shp.navigateBack();
		shp.clickLogin();
		shp.clickRegisterHere();
		shp.clickFbSignUp();
		shp.navigateBack();
		shp.clickLogin();
		shp.clickRegisterHere();
		shp.clickLoginHere();
		shp.clickLogin();
		count = SqliteUtils.updateAndGetCounter();
		email = "embibe.auto"+count+"@mailinator.com";
		shp.signUp(uniqueValue, email);
		sup = shp.logout();
		sup.assertSignUpPage();
		lp = sup.goToLandingPage();
		wdriver.manage().window().setSize(new Dimension(1024, 768));
		lp.clickHamburger();
		lp.closeHamburger();
		wdriver.manage().window().maximize();
		lp.clickLogin();
		lp.clickLogin();
		lp.login(uniqueValue, email);
		
	}
	
	@AfterMethod
	public void tearDown() throws EncryptedDocumentException, InvalidFormatException, IOException{
		lp = new LandingPage(wdriver);
		
		ArrayList<LinkedHashMap<String, String>> a_events = lp.getEventLogs();

		ArrayList<LinkedHashMap<String, String>> e_events = lp.getEventData("headerResults");
		
		ArrayList<LinkedHashMap<String, String>> eventsResults = new ArrayList<LinkedHashMap<String, String>>();
		for(LinkedHashMap<String, String> map1:e_events){
			LinkedHashMap<String, String> mapResults = null;
			String eEventCode = map1.get("event_code");
			for(HashMap<String, String> map2:a_events){
				String aEventCode = map2.get("event_code");
				if(eEventCode.equals(aEventCode)){
					mapResults = new LinkedHashMap<String, String>();
					mapResults.put("e_event_code", map1.get("event_code"));
					mapResults.put("a_event_code", map2.get("event_code"));
					mapResults.put("e_log_type", map1.get("log_type"));
					mapResults.put("a_log_type", map2.get("log_type"));
					mapResults.put("e_event_name", map1.get("event_name"));
					mapResults.put("a_event_name", map2.get("event_name"));
					mapResults.put("e_nav_element", map1.get("nav_element"));
					mapResults.put("a_nav_element", map2.get("nav_element"));
					mapResults.put("e_event_type", map1.get("event_type"));
					mapResults.put("a_event_type", map2.get("event_type"));
					mapResults.put("e_intent_to_pay", map1.get("intent_to_pay"));
					mapResults.put("a_intent_to_pay", map2.get("intent_to_pay"));
					mapResults.put("e_extra_Params", map1.get("extra_Params"));
					mapResults.put("a_extra_Params", map2.get("extra_Params"));
					break;
				}
				
			}
			if(mapResults!=null)
				eventsResults.add(mapResults);
		}
		
		int i=0;
		for(LinkedHashMap<String, String> map:eventsResults){
			System.out.print("Event "+(++i)+" >---> ");
			for(Map.Entry<String, String> m:map.entrySet()){
				System.out.print(m.getKey()+": "+m.getValue());
				System.out.print(" ");
			}
			System.out.println();
		}
		
		wdriver.close();
	}

}
