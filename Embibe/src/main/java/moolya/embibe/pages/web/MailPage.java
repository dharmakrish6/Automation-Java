package moolya.embibe.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MailPage extends W_BasePage {

	public MailPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="login")
	private WebElement email_TB;
	
	@FindBy(css=".sbut")
	private WebElement goToInbox_Btn;
	
	@FindBy(css=".lms")
	private List<WebElement> mailSubject_List;
	
	@FindBy(css=".mcnButton")
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
		try{
			wdriver.switchTo().frame("ifinbox");
		}catch(Exception e){}
		waitUntilElementclickable(mailSubject_List.get(0));
		for(WebElement e:mailSubject_List)
			if(e.getText().equalsIgnoreCase(subject)){
				e.click();
				Reporter.log("Clicked Subject"+subject, true);
				break;
			}
		wdriver.switchTo().defaultContent();
	}
	
	public SignUpPage clickResetPassword(){
		// mailinator iframe id=msg_body
		// yopmail iframe id=ifmail
		wdriver.switchTo().frame("ifmail");
		waitUntilElementclickable(resetPassword_Btn);
		resetPassword_Btn.click();
		wdriver.switchTo().defaultContent();
		return new SignUpPage(wdriver);
	}
	

}
