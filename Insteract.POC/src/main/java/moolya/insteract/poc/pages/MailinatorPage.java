package moolya.insteract.poc.pages;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MailinatorPage extends W_BasePage {

	public MailinatorPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="inboxfield")
	private WebElement inbox_TB;
	
	@FindBy(xpath="//button[contains(text(),'Go!')]")
	private WebElement go_Btn;
	
	@FindBy(xpath="//div[@id='public_maildirdiv']//div[5]//div")
	private List<WebElement> subjects;
	
	@FindBy(linkText="Reset my password")
	private WebElement resetPassword_Link;
	
	@FindBy(partialLinkText="Json")
	private WebElement showJson;
	
	@FindBy(tagName="pre")
	private WebElement jsonContent;
	
	public void goToInbox(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Mailinator", uniqueValue);
		sendKeysToElement(inbox_TB, data.get("Email"));
		clickElement(go_Btn);
	}
	
	public void selectMailWithSubject(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("Mailinator", uniqueValue);
		for(WebElement e:subjects)
			if(e.getText().contains(data.get("Subject"))){
				clickElement(e);
				break;
			}
	}
	
	public ResetPasswordPage clickResetPassword() throws InterruptedException{
		Thread.sleep(4000);
		driver.switchTo().frame("publicshowmaildivcontent");
		clickElement(resetPassword_Link);
		return new ResetPasswordPage(driver);
	}
	
	public void clickOnShowJson() throws InterruptedException{
		Thread.sleep(3000);
		clickElement(showJson);
	}
	
	public String getJson() throws InterruptedException{
		Thread.sleep(2000);
		driver.switchTo().frame("publicshowmaildivcontent");
		String text = jsonContent.getText();
		return text;
	}

	public void selectMailWithTR(String trNum) throws InterruptedException {
		// TODO Auto-generated method stub
		for(WebElement e:subjects)
			if(e.getText().contains(trNum)){
				clickElement(e);
				break;
			}
	}

}
