package moolya.partnersgroup.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class SearchPage extends W_BasePage {

	public SearchPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//div[@class='tx-indexedsearch-res']/ul/li//a")
	List<WebElement> results;

	public void readResults() throws InterruptedException{
		Thread.sleep(3000);
		try{
			for(WebElement e:results){
				String text = e.getText();
				e.click();
				Reporter.log("Clicking on Result : "+text, true);
				Thread.sleep(2000);
				driver.navigate().back();
			}
		}catch(Exception e){
			Assert.fail("Reading Search Results Failed: Document Expired! Unable to read other results", e.getCause());
		}

	}
}
