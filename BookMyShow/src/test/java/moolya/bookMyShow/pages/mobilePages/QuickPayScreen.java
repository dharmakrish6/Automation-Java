package moolya.bookMyShow.pages.mobilePages;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class QuickPayScreen extends M_BasePage {

	public QuickPayScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}
	
	
	@AndroidFindBy(id="com.bt.bms:id/addnew_bt")
	public MobileElement addNew_Btn;
	
	@AndroidFindBy(name="ADD")
	public MobileElement add_Btn;
	
	@AndroidFindBy(name="Credit/Debit Card")
	public MobileElement creditDebit_Btn;
	
	@AndroidFindBy(name="Internet Banking")
	public MobileElement netBanking_Btn;
	
	@AndroidFindBy(name="Gift Voucher")
	public MobileElement giftVoucher_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/card_name_et")
	public MobileElement cardName_TB;
	
	@AndroidFindBy(id="com.bt.bms:id/card_no_et")
	public MobileElement cardNumber_TB;
	
	@AndroidFindBy(id="com.bt.bms:id/expiry_date_et")
	public MobileElement expiryDate_Date;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='0']")
	public MobileElement month_Picker;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='0']/android.widget.Button[@index='0']")
	public MobileElement monthPrev;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='0']/android.widget.EditText")
	public MobileElement month;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='0']/android.widget.Button[@index='2']")
	public MobileElement monthNext;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='1']")
	public MobileElement year_Picker;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='1']/android.widget.Button[@index='0']")
	public MobileElement yearPrev;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='1']/android.widget.EditText")
	public MobileElement year;
	
	@AndroidFindBy(xpath="//*[@class='android.widget.NumberPicker' and @index='1']/android.widget.Button[@index='2']")
	public MobileElement yearNext;
	
	@AndroidFindBy(id="com.bt.bms:id/set_bt")
	public MobileElement set_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/cancel_bt")
	public MobileElement cancel_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/user_name_et")
	public MobileElement nameOnCard_TB;
	
	@AndroidFindBy(name="SAVE")
	public MobileElement save_Btn;
	
	static String cardName = "Yathi CC";
	static String cardNumber = "5337440610848674";
	static String expiryMonth = "Jul";
	static String expiryYear = "2018";
	static String nameOnCard = "YATHEENDRA BC";
	
	public QuickPayScreen addCard() throws InterruptedException, IOException{
		try {
			waitUntilElementclickable(addNew_Btn);
			addNew_Btn.click();
		} catch (Exception e) {
			waitUntilElementclickable(add_Btn);
			add_Btn.click();
		}
		waitUntilElementclickable(creditDebit_Btn);
		creditDebit_Btn.click();
		cardName_TB.sendKeys(cardName);
		cardNumber_TB.sendKeys(cardNumber);
		selectExpiryDate(expiryMonth, expiryYear);
		nameOnCard_TB.sendKeys(nameOnCard);
		save_Btn.click();
		waitUntilElementclickable(add_Btn);
		return this;
	}
	
	public String getCardName(){
		return cardName;
	}
	
	public void selectExpiryDate(String month,String year) throws InterruptedException, IOException{
		int m = getMonth(month);
		int yr = Integer.parseInt(year);
		
		waitUntilElementclickable(expiryDate_Date);
		expiryDate_Date.click();
		
		int currMonth = getMonth(this.month.getText());
		System.out.println(currMonth+"\n"+m);
		int monthX = this.month.getCenter().x;
		int monthY = this.month.getCenter().y;
		int monthPrevY = monthPrev.getCenter().y;
		int monthNextY = monthNext.getCenter().y;
		if(currMonth<m){
			swipeVertical(monthY, monthPrevY, monthX, m-currMonth);
//			for(int i=1;i<=m-currMonth;i++)
//				monthPrev.click();
		}
		else if(currMonth>m){
			swipeVertical(monthY, monthNextY, monthX, currMonth-m);
//			for(int i=1;i<=currMonth-m;i++)
//				monthNext.click();
		}
		Thread.sleep(2000);
		int yearX = this.year.getCenter().x;
		int yearY = this.year.getCenter().y;
		int yearPrevY = yearPrev.getCenter().y;
		int yearNextY = yearNext.getCenter().y;
		
		int currYear = Integer.parseInt(this.year.getText());
		System.err.println(currYear+"\n"+yr);
		if(currYear<yr){
			swipeVertical(yearY, yearPrevY, yearX, yr-currYear);
//			for(int i=1;i<=yr-currYear;i++)
//				yearPrev.click();
		}
		if(currYear>yr){
			swipeVertical(yearY, yearNextY, yearX, currYear-yr);
//			for(int i=1;i<currYear-yr;i++)
//				yearNext.click();
		}
		
		Thread.sleep(2000);
		set_Btn.click();
	}
	
	public int getMonth(String month){
		int m = 0;
		switch(month){
			case	"Jan"	:	m=1;
								break;
			case	"Feb"	:	m=2;
			break;
			case	"Mar"	:	m=3;
			break;
			case	"Apr"	:	m=4;
			break;
			case	"May"	:	m=5;
			break;
			case	"Jun"	:	m=6;
			break;
			case	"Jul"	:	m=7;
			break;
			case	"Aug"	:	m=8;
			break;
			case	"Sep"	:	m=9;
			break;
			case	"Oct"	:	m=10;
			break;
			case	"Nov"	:	m=11;
			break;
			case	"Dec"	:	m=12;
			break;
			default			:	break;
		}
		return m;
	}
	
	

}
