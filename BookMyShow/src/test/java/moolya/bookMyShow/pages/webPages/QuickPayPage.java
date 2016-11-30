package moolya.bookMyShow.pages.webPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuickPayPage extends W_BasePage {

	public QuickPayPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
	}
	
	@FindBy(id="iUserProfileImage")
	public WebElement userProfile_Image;
	
	@FindBy(id="aRemovePay")
	public WebElement confirmRemove_Btn;
	
	public QuickPayPage removeCard(String cardName) throws InterruptedException{
		WebElement cardName_Label = wdriver.findElement(By.xpath("//*[@id='uCD']//span[text()='"+cardName+"']"));
		mouseHoverOnElement(wdriver, cardName_Label);
		WebElement cardRemove_Btn = wdriver.findElement(By.xpath("//*[@id='uCD']//span[text()='"+cardName+"']/../following-sibling::span"));
		cardRemove_Btn.click();
		waitUntilElementclickable(confirmRemove_Btn);
		confirmRemove_Btn.click();
		Thread.sleep(5000);
		return this;
	}

}
