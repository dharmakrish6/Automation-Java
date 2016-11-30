package moolya.bookMyShow.pages.mobilePages;

import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;
import org.springframework.test.AssertThrows;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ReviewScreen extends M_BasePage {

	public ReviewScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}
	
	@AndroidFindBy(id="com.bt.bms:id/showName")
	public MobileElement showName_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/venueName")
	public MobileElement venueName_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/date")
	public MobileElement date_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/time")
	public MobileElement time_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/screen")
	public MobileElement seats_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/back")
	public MobileElement back_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/yes_bt")
	public MobileElement yes_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/no_bt")
	public MobileElement no_Btn;
	
	
	public TicketsScreen cancelTransaction(){
		waitUntilElementclickable(back_Btn);
		back_Btn.click();
		waitUntilElementclickable(yes_Btn);
		yes_Btn.click();
		return new TicketsScreen(mdriver);
	}
	
	public void assertReviewScreen(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("Movie", uniqueValue);
		waitUntilElementAppears(showName_Label);
		Assert.assertTrue(showName_Label.getText().contains(data.get("Movie Name")), "Movie Name not matching ---> Actual: "+showName_Label.getText()+" Expected: "+data.get("Movie Name"));
		Assert.assertTrue(venueName_Label.getText().contains(data.get("Theatre Name")), "Screen Name not matching ---> Actual: "+venueName_Label.getText()+" Expected: "+data.get("Theatre Name"));
		Assert.assertTrue(date_Label.getText().contains(data.get("Day")), "Date not matching ---> Actual: "+date_Label.getText()+" Expected: "+data.get("Day"));
		String time = data.get("Time");
		if(time.startsWith("0"))
			time = time.substring(1);
		Assert.assertTrue(time_Label.getText().contains(time), "Showtime not matching ---> Actual: "+time_Label.getText()+" Expected: "+data.get("Time"));
//		Assert.assertTrue(seats_Label.getText().contains(seats), "Seat numbers not matching");
	}

}
