package moolya.embibe.pages.web.mobile;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MailinatorPage extends W_BasePage {

	public MailinatorPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="inboxfield")
	private WebElement email_TB;
	
	@FindBy(css=".input-group-btn>button")
	private WebElement goToInbox_Btn;
	
	@FindBy(css=".all_message-min .all_message-min_text")
	private List<WebElement> mailSubject_List;
	
	@FindBy(css=".mcnButton ")
	private WebElement resetPassword_Btn;
	
	String subject = "Reset your password for Embibe here";
	
	public void goToInbox(String email){
		waitUntilElementclickable(email_TB);
		email_TB.sendKeys(email);
		Reporter.log("Entered Email: "+email, true);
		goToInbox_Btn.click();
		Reporter.log("Clicked On Go", true);
	}
	
	public void openEmailSubject(){
		waitUntilElementclickable(mailSubject_List.get(0));
		for(WebElement e:mailSubject_List)
			if(e.getText().equalsIgnoreCase(subject)){
				e.click();
				Reporter.log("Clicked Subject"+subject, true);
				break;
			}
	}
	
	public SignUpPage clickResetPassword(){
		wdriver.switchTo().frame("msg_body");
		waitUntilElementclickable(resetPassword_Btn);
		clickElement(resetPassword_Btn, "Clicked Reset Password");
		return new SignUpPage(wdriver);
	}
	

}
