package moolya.filpkartdemo.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MobilesPage extends W_BasePage {

	public MobilesPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//span[text()='Price']/../../../../div[4]/div[1]/select")
	private WebElement priceStart_DD;
	
	@FindBy(xpath="//span[text()='Price']/../../../../div[4]/div[3]/select")
	private WebElement priceEnd_DD;
	
	@FindBy(xpath="//input[@placeholder='Search Brand']")
	private WebElement searchBrand_TB;
	
	@FindBy(xpath="//div[text()='Operating System']")
	private WebElement os;

	HashMap<String, String> data;
	String mobileName;

	String[] details;

	List<WebElement> mobileDetails;

	String amount;
	
	public void filterPrice(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		data = readExcelData("Mobiles", uniqueValue);
		selectDropdownValue(priceStart_DD, data.get("Start Price"));
		selectDropdownValue(priceEnd_DD, data.get("End Price"));
		Thread.sleep(3000);
	}
	
	public void filterBrand(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		data = readExcelData("Mobiles", uniqueValue);
		searchBrand_TB.sendKeys(data.get("Brand"));
		Thread.sleep(3000);
		List<WebElement> brands = wdriver.findElements(By.xpath("//div[text()='Brand']/../../div/div/div"));
		for(WebElement e:brands)
			if(e.getAttribute("title").equalsIgnoreCase(data.get("Brand"))){
				e.click();
				break;
		}
		Thread.sleep(3000);
	}
	
	public void filterOS(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		data = readExcelData("Mobiles", uniqueValue);
		scrollDown("500");
		os.click();
		Thread.sleep(3000);
		List<WebElement> os_CB = wdriver.findElements(By.xpath("//div[text()='Operating System']/../../div[2]/div/div"));
		for(WebElement e:os_CB)
			if(e.getAttribute("title").equalsIgnoreCase(data.get("Operating System"))){
				e.click();
				break;
		}
		Thread.sleep(3000);
	}
	
	public String[] getMobileDetails(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		data = readExcelData("Mobiles", uniqueValue);
		Thread.sleep(3000);
		List<WebElement> mobiles = wdriver.findElements(By.xpath("//h1/../../../../div[3]/div/div"));
		for(WebElement e:mobiles){
			mobileName = e.findElement(By.xpath("a/div[2]/div[1]/div[1]")).getText();
			if(mobileName.equalsIgnoreCase(data.get("Mobile"))){
				mobileDetails = e.findElements(By.xpath("a/div[2]/div[1]/div[3]/ul/li"));
				details = new String[mobileDetails.size()+2];
				details[0] = mobileName;
				int i=2;
				for(WebElement e1:mobileDetails){
					details[i] = e1.getText();
					i++;
				}
				amount = e.findElement(By.xpath("a/div[2]/div[2]/div/div/div")).getText();
				amount = amount.replaceAll("[^0-9]", "");
				details[1] = amount;
				break;
			}
		}
		Thread.sleep(3000);
		return details;
	}

}
