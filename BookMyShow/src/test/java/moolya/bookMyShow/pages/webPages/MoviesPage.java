package moolya.bookMyShow.pages.webPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MoviesPage extends W_BasePage {

	public MoviesPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	
	@FindBy(id="btmcntbook")
	public WebElement proceedSeatSelection_Btn;
	
	@FindBy(id="shmticket")
	public WebElement mTicket_RB;
	
	@FindBy(id="shbox")
	public WebElement boxOffice_RB;
	
	@FindBy(id="btnAduPopupAccept")
	public WebElement acceptTerms_Btn;
	
	@FindBy(id="btnPopupCancel")
	public WebElement cancelTerms_Btn;
	
	@FindBy(id="prePay")
	public WebElement proceedBookingSummary_Btn;
	
	@FindBy(xpath="//*[@id='dOrderSummary']//h3")
	public WebElement movieName_Label;
	
	@FindBy(xpath=".//*[@id='dOrderSummary']//h3/following-sibling::address[1]")
	public WebElement language_Label;
	
	@FindBy(xpath=".//*[@id='dOrderSummary']//h3/following-sibling::address[2]")
	public WebElement theatre_Label;
	
	@FindBy(xpath="//span[@class='__no-of-tickets']/b")
	public WebElement tickets_Label;
	
	@FindBy(xpath="//span[@class='__date']/text()[2]")
	public WebElement showtime_Label;
	
	static String language = "ENGLISH";
	static String movieName = "Masterminds (A)";
	static String theatreName = "INOX Lido: Off MG Road, Ulsoor";
	static String showtime = "07:35 PM";
	static String noOfTickets = "6";
	static String ticketType = "boxoffice";	// mticket	boxoffice
	
	public MoviesPage selectMovie() throws InterruptedException{
		Thread.sleep(5000);
		WebElement movie = wdriver.findElement(By.xpath("//*[@id='quickbook-movies']//div[text()='"+language+"']/../../../..//a[text()='"+movieName+"']"));
		movie.click();
		return this;
	}
	
	public MoviesPage selectShowtimeInTheatre() throws InterruptedException{
		Thread.sleep(5000);
		WebElement showTime = wdriver.findElement(By.xpath("//section[@class='phpShowtimes showtimes']//strong[text()='"+theatreName+"']/../../../../..//a[contains(text(),'"+showtime+"')]"));
		showTime.click();
		Thread.sleep(5000);
		WebElement tickets = wdriver.findElement(By.xpath(".//*[@id='popQty']/*[text()='"+noOfTickets+"']"));
		tickets.click();
		return this;
	}
	
	public MoviesPage selectSeats() throws InterruptedException{
		Thread.sleep(5000);
		List<WebElement> aseats;
		List<WebElement> sseats;
		int i=0;
		int selected = 0;
		List<WebElement> rows = wdriver.findElements(By.xpath("//td/div[@class='seatR Setrow1']"));
		while(selected<Integer.parseInt(noOfTickets)){
			WebElement row = rows.get(i);
			aseats = row.findElements(By.xpath("../following-sibling::td//a[@class='_available']"));
			while(selected<Integer.parseInt(noOfTickets)){
				if(aseats.size()>0){
					aseats.get(0).click();
					sseats = row.findElements(By.xpath("../following-sibling::td//a[@class='_available _selected']"));
					aseats = row.findElements(By.xpath("../following-sibling::td//a[@class='_available']"));
					selected+=sseats.size();
				}
			}
			i++;
			if(i==rows.size())
				break;
		}
		Thread.sleep(3000);
		proceedSeatSelection_Btn.click();
		try {
			if(ticketType.equals("mticket")){
				waitUntilElementclickable(mTicket_RB);
				mTicket_RB.click();
			}
			else if(ticketType.equals("boxoffice")){
				waitUntilElementclickable(boxOffice_RB);
				boxOffice_RB.click();
			}
		} catch (Exception e1) {}
		waitUntilElementclickable(proceedBookingSummary_Btn);
		proceedBookingSummary_Btn.click();
		try{
			acceptTerms_Btn.click();
		}catch(Exception e){}
		return this;
	}
	
	public void assertOrderSummary() throws InterruptedException{
		waitUntilElementAppears(movieName_Label);
		Assert.assertTrue(movieName_Label.getText().toLowerCase().contains(movieName.toLowerCase()), "Movie Name does not match");
		Assert.assertTrue(language_Label.getText().toLowerCase().contains(language.toLowerCase()), "Language does not match");
		Assert.assertTrue(theatre_Label.getText().toLowerCase().contains(theatreName.toLowerCase()), "Theatre Name does not match");
		Assert.assertTrue(tickets_Label.getText().toLowerCase().contains(noOfTickets.toLowerCase()), "No of Tickets does not match");
//		Assert.assertTrue(showtime_Label.getText().toLowerCase().contains(showtime.toLowerCase()), "Showtime does not match");
	}

}
