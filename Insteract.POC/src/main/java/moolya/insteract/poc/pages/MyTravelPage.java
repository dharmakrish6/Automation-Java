package moolya.insteract.poc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class MyTravelPage extends W_BasePage {

	public MyTravelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath="//span[text()='My Travel']")
	public WebElement myTravelButton;
	
	@FindBy(xpath="//*[@placeholder='All Requests']")
	public WebElement requestCategory;
	
	@FindBy(xpath="//*[@value='Approved']")
			public WebElement approvedCategory;
	
	@FindBy(xpath="//*[@value='Pending']")
	public WebElement pendingCategory;
	@FindBy(xpath="//label[text()='Search Requests']/following-sibling::input")
	public WebElement searchTR;
	
	@FindBy(xpath="(//*[@class='i-tr-tab-trnumber ng-binding'])[1]")
	public WebElement trNumber_Label;
	
	@FindBy(xpath="//md-content[@ng-show='vm.showTrList']//button")
	private List<WebElement> trList;
	
	
	
	public void selectRequestWithTR(String trNum) throws InterruptedException{
		
		Thread.sleep(5000);
		for(WebElement e:trList){
			String text = e.getAttribute("aria-label");
			if(text.contains(trNum)){
				clickElement(e);
				break;
			}
		}
	}
	
	
	public void verifyApprovedTravelRequest(String trNum) throws InterruptedException{
	Thread.sleep(7000);
		clickElement(requestCategory);
		Thread.sleep(3000);
		clickElement(approvedCategory);
		Thread.sleep(3000);
		sendKeysToElement(searchTR, trNum);
		Thread.sleep(4000);
		String num = trNumber_Label.getText().trim();
		Assert.assertTrue(num.contains(trNum), "TR Number not matching");
		Reporter.log("TR Number is Matching successfully", true);
	
	}
	
	public void verifyPendingTravelRequest(String trNum) throws InterruptedException{
		Thread.sleep(7000);
			clickElement(requestCategory);
			Thread.sleep(3000);
			clickElement(pendingCategory);
			Thread.sleep(3000);
			sendKeysToElement(searchTR, trNum);
			Thread.sleep(4000);
			selectRequestWithTR(trNum);
			Thread.sleep(3000);
			String num = trNumber_Label.getText().trim();
			Assert.assertTrue(num.contains(trNum), "TR Number not matching");
			Reporter.log("TR Number is Matching successfully", true);
		
		}

}
