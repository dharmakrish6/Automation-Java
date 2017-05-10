package moolya.insteract.poc.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyTeamTravelPage extends W_BasePage {

	public MyTeamTravelPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//md-content[@ng-show='vm.showTrList']//button")
	private List<WebElement> trList;
	
	@FindBy(xpath="//button[text()='Approve']")
	private WebElement approve_Btn;
	
	@FindBy(xpath="//label[text()='Search Requests']/following-sibling::input")
	public WebElement searchTR;
	
	public void selectRequestWithTR(String trNum) throws InterruptedException{
		Thread.sleep(3000);
		sendKeysToElement(searchTR, trNum);
		Thread.sleep(3000);
		for(WebElement e:trList){
			String text = e.getAttribute("aria-label");
			if(text.contains(trNum)){
				clickElement(e);
				break;
			}
		}
	}
	
	public void approveRequest() throws InterruptedException{
		clickElement(approve_Btn);
	}

}
