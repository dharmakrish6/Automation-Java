package moolya.insteract.poc.pages;

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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

public class FlightSearchPage extends W_BasePage {

	public FlightSearchPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(id="iPlanYourTrip")
	public WebElement planYourTrip_SB;
	
	@FindBy(id="input_11")
	public WebElement place_FROM;
	
	@FindBy(id="input_12")
	public WebElement place_TO;

	@FindBy(xpath=".//*[@id='exTab1']/div")
	public WebElement select_BLR;
	
	@FindBy(xpath="//*[@id='exTab1']/div/div[1]")
	public WebElement select_CHENNAI;
	
	@FindBy(id="input_14")
	public WebElement depart_ON;
	
	@FindBy(xpath="//span[@class='md-calendar-date-selection-indicator' and text()='12']")
	public WebElement departDate;
	
	@FindBy(xpath="//span[@class='md-calendar-date-selection-indicator' and text()='14']")
	public WebElement arrivalDate;
	
	@FindBy(xpath="//label[text()='Return']/following-sibling::md-datepicker/div/input")
	public WebElement returnDate;
	
	@FindBy(id="input_16")
	public WebElement return_ON;
	
	@FindBy(xpath=".//*[text()='Search Flights']")
	public WebElement search_Flights;
	
	public FlightSearchPage searchFlights(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SearchFlights", uniqueValue);
		Thread.sleep(5000);
		waitUntilElementAppears(planYourTrip_SB);
		clickElement(planYourTrip_SB);
		sendKeysToElement(place_FROM, data.get("Source"));
		clickElement(select_BLR);
		sendKeysToElement(place_TO, data.get("Destination"));
		Thread.sleep(1000);
		clickElement(select_CHENNAI);
		Thread.sleep(6000);
		clickElement(departDate);
		Thread.sleep(6000);
		clickElement(arrivalDate);
		Thread.sleep(2000);
		returnDate.clear();
		Thread.sleep(6000);
		search_Flights.click();
		return this;
	}

	@FindBy(id="searchResultContent")
	public WebElement searchResultContent;
	
	@FindBy(xpath=".//h1/span[text()='Bangalore']")
	public WebElement searchResultBNG;
	
	@FindBy(xpath=".//h1/span[text()='Chennai']")
	public WebElement searchResultCHN;
	
	@FindBy(xpath=".//*[text()='Travel request details']")
	public WebElement travelRequestButton;
	
	@FindBy(xpath=".//*[text()='Travel Request No.']/following-sibling::span")
	public WebElement travelRequestNo;
	
	@FindBy(xpath=".//*[text()='Maximum fare']/following-sibling::h1/span")
	public WebElement maximumFare;
	
	@FindBy(xpath=".//span[text()='Hide Details']")
	public WebElement hideDetailsButton;
	
	@FindBy(xpath=".//*[@id='searchResultContent']/div/div[1]/div[1]/div[3]/div[1]/h1")
	public List<WebElement> priceList;
	
	@FindBy(xpath="//*[@id='searchResultContent']/div/div[1]/div[3]/div[3]/div/div/div[2]/div[3]/span/a")
	public List<WebElement> bookButtons;
	
	@FindBy(xpath="//*[@id='searchResultContent']//button/span[text()='Submit Request']")
	public WebElement submitRequest_Btn;
	
	public String getTRNumber() throws InterruptedException{
		Thread.sleep(10000);
		waitUntilElementAppears(searchResultContent);
		waitUntilElementAppears(searchResultBNG);
		waitUntilElementAppears(searchResultCHN);
		Thread.sleep(5000);
		clickElement(travelRequestButton);
		Thread.sleep(4000);
		String trNum = travelRequestNo.getText().trim();
		System.out.println("Request No"+trNum);
		System.out.println("Maximum Fare"+maximumFare.getText());
		String fareClapAmt = maximumFare.getText().replaceAll("[^0-9]", "");
		int maximumFareText= Integer.parseInt(fareClapAmt);
		
		hideDetailsButton.click();
		boolean flag = false;
		for (WebElement firstGreaterPrice : priceList) {
				String amt = firstGreaterPrice.getText().replaceAll("[^0-9]", "");
				int fareAmount= Integer.parseInt(amt);
				if(fareAmount>maximumFareText){
					flag = true;
					Thread.sleep(3000);
					firstGreaterPrice.findElement(By.xpath("../../../following-sibling::div//a[text()='Add to request']")).click();
					break;
				}
			}
		if(!flag)
			priceList.get(0).findElement(By.xpath("../../../following-sibling::div//a[text()='Add to request']")).click();
		Thread.sleep(5000);
		scrollup("1000");
		Thread.sleep(2000);
		clickElement(submitRequest_Btn);
		return trNum;
	
	}
	

}
