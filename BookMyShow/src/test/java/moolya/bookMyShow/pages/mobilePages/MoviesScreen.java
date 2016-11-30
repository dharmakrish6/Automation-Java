package moolya.bookMyShow.pages.mobilePages;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class MoviesScreen extends M_BasePage {

	public MoviesScreen(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
	}
	
	
	@AndroidFindBy(id="com.bt.bms:id/book_bt")
	public MobileElement book_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/robotoCondensedBoldTextView1")
	public MobileElement selected_Label;
	
	@AndroidFindBy(name="Pay Now")
	public MobileElement payNow_Btn;
	
	@AndroidFindBy(name="SELECT TICKET TYPE")
	public MobileElement selectTicketType_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/btnBoxOffice")
	public MobileElement boxOffice_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/btnMTicket")
	public MobileElement mTicket_Btn;
	
	@AndroidFindBy(name="NEXT")
	public MobileElement next_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/txvTitle")
	public MobileElement title_Label;
	
	@AndroidFindBy(id="com.bt.bms:id/txvDone")
	public MobileElement proceed_Btn;
	
	@AndroidFindBy(id="com.bt.bms:id/dismiss")
	public MobileElement dismiss_Btn;
	
	@AndroidFindBy(name="PICK A VENUE")
	public MobileElement pickVenue_Label;
	
	
	public String bookMovie(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Movie", uniqueValue);
		waitUntilElementclickable(book_Btn);
		String movieName = data.get("Movie Name");
		System.out.println(movieName);
		clickElementByText(movieName);
		boolean flag = isMticketAvailable(movieName);
		waitUntilElementclickable(book_Btn);
		String rating = title_Label.getText();
		book_Btn.click();
		waitUntilElementAppears(pickVenue_Label);
		Thread.sleep(2000);
		clickElementByText(data.get("Day"));
		clickElementByText(data.get("Theatre Name"));
		Thread.sleep(5000);
		clickElementByText(data.get("Time"));
		System.out.println(data.get("Category"));
		clickElementByText(data.get("Category"));
		String noOfTickets = data.get("No Of Tickets");
		clickElementByText("1");
		proceed_Btn.click();
		waitUntilElementAppears(selected_Label);
		String seatno = selectSeats(noOfTickets);
		Thread.sleep(2000);
		payNow_Btn.click();
		try{
			mdriver.findElementByName("SKIP").click();
		}catch(Exception e){}
		Thread.sleep(10000);
		/*if(flag){
			if(data.get("Ticket Type").equalsIgnoreCase("m")){
				mTicket_Btn.click();
			waitUntilElementclickable(next_Btn);
			
			next_Btn.click();
			}else if(data.get("Ticket Type").equalsIgnoreCase("b")){
				boxOffice_Btn.click();
				waitUntilElementclickable(next_Btn);
				next_Btn.click();
			}
			
		}*/		
		try{
			dismiss_Btn.click();
		}catch(Exception e){}
		return seatno;
	}
	
	
	
	public String selectSeats(String noOfTickets){
		String seatno="";
		MobileElement waitElement = mdriver.findElementByXPath("//android.widget.TableRow");
		waitUntilElementAppears(waitElement);
		int noOfRows = mdriver.findElementsByXPath("//android.widget.TableRow").size();
//		outerLoop :
		for(int i=1;i<=noOfRows;i++){
			
			List<MobileElement> seats = mdriver.findElementsByXPath("//android.widget.TableRow[@index='"+i+"']/android.widget.ImageView[@clickable='true']");
			System.out.println("Row Seats: "+seats.size());
			int aSeats = seats.size();
			if(aSeats>=Integer.parseInt(noOfTickets)){
				seats.get(0).click();
				return null;
				/*int[] seatNos = new int[aSeats];
				for(int j =0;j<aSeats;j++){
					seatNos[i] = Integer.parseInt(seats.get(j).getAttribute("index"));
					System.out.println(seatNos[i]);
				}
				boolean flag = checkConsecutive(seatNos, Integer.parseInt(noOfTickets));
				if(flag){
					int conNo = getConsecutiveNos(seatNos, Integer.parseInt(noOfTickets));
					mdriver.findElementByXPath("//android.widget.TableRow/android.widget.ImageView[@inex='"+(conNo+1)+"']").click();
					String row = mdriver.findElementByXPath("//android.widget.TableRow/android.widget.ImageView[@inex='"+(conNo+1)+"']/preceding-sibling::android.widget.TextView").getAttribute("text");
					for(int l=0;l<Integer.parseInt(noOfTickets);l++){
						seatno = seatno+row+conNo+", ";
						conNo++;
					}
//					break outerLoop;
					return seatno;
				}*/
			}
		}
		return null;
	}
	
	public boolean isMticketAvailable(String text){
		boolean flag = false;
		try{
			flag = !mdriver.findElementByName(text).findElementsByXPath("../../android.widget.LinearLayout/android.widget.ImageView").isEmpty();
		}catch(Exception e){}
		return flag; 
	}
	
	public boolean checkConsecutive(int[] nos, int num){
		boolean flag=false;
		Arrays.sort(nos);
		int count=0;
		out:
		for(int i=0;i<nos.length;i++){
			if(count<num){
				if(nos[i]+1==nos[i+1])
					count++;
				else
					break out;
			}
				
		}
		return flag;
	}
	
	public int getConsecutiveNos(int[] nos, int num){
		int n = 0;
		Arrays.sort(nos);
		int count=0;
		out:
		for(int i=0;i<nos.length&&count<num;i++){
				if(nos[i]+1==nos[i+1]){
					n=i;
					count++;
				}
				else
					break out;
		}
		n = n-(num-1);
		return n;
	}
}
