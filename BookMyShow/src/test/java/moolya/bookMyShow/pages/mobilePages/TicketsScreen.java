package moolya.bookMyShow.pages.mobilePages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TicketsScreen extends M_BasePage {

	public TicketsScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}
	
	@AndroidFindBy(id="com.bt.bms:id/venues_nearby")
	public MobileElement searchVenues_Btn;
	
	@AndroidFindBy(name="MOVIES")
	public MobileElement movies_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/txvLocation")
	public MobileElement location_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/action_icon")
	public MobileElement search_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/edtSearchBox")
	public MobileElement search_TB;
	
	@AndroidFindBy(id="com.bt.bms:id/dismiss")
	public MobileElement dismiss_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/ctxv_region_name")
	public MobileElement regionName_Btn;
	
	static String region = "";
	
	public VenuesScreen goToSearchVenuesScreen(){
		waitUntilElementclickable(searchVenues_Btn);
		searchVenues_Btn.click();
		return new VenuesScreen(mdriver);
	}
	
	public MoviesScreen goToMoviesScreen(){
		waitUntilElementclickable(movies_Btn);
		movies_Btn.click();
		return new MoviesScreen(mdriver);
	}
	
	public TicketsScreen selectRegion(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Movie", uniqueValue);
		waitUntilElementclickable(location_Btn);
		location_Btn.click();
		try{
			dismiss_Btn.click();
		}catch(Exception e){}
		waitUntilElementclickable(search_Btn);
		search_Btn.click();
		waitUntilElementAppears(search_TB);
		search_TB.sendKeys(data.get("Region"));
		Thread.sleep(2000);
		regionName_Btn.click();
//		if(!data.get("City").equals(null))
//			mdriver.findElementByName(data.get("City")).click();
		try{
			mdriver.findElementByName(data.get("City")).click();
		}catch(Exception e){}
		return this;
	}

}
