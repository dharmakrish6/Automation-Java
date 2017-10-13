package moolya.embibe.pages.web;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class MyProfilePage extends W_BasePage {

	public MyProfilePage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".user-dropdown .user-name[href='/profile']")
	private WebElement myProfile_Btn;
	
	@FindBy(css=".profile_btn.btn_edit")
	private WebElement editProfile_Btn;
	
	@FindBy(xpath="//*[@class='profile_label' AND contains(text(),'NAME')]/../input[@placeholder='Add Your Name']")
	private WebElement profileNameField;
	
	@FindBy(xpath="//*[@class='profile_label' AND contains(text(),'EMAIL')]/../input")
	private WebElement profileEmailField;
	
	@FindBy(xpath="//*[@class='profile_label' AND contains(text(),'PREPARING FOR')]/../select")
	private WebElement preparingFor_DD;
	
	@FindBy(xpath="//*[@class='profile_label' AND contains(text(),'PREPARING FOR')]/../select")
	private List<WebElement> preparingForList;
	
	public void clickMyProfile(){
		waitUntilElementclickable(myProfile_Btn);
		myProfile_Btn.click();
		Reporter.log("Clicked on My Profile Button", true);
	}
	
	public void clickEditProfile(){
		waitUntilElementclickable(editProfile_Btn);
		editProfile_Btn.click();
		Reporter.log("Clicked on Edit Profile Button", true);
	}
	
	public void enterProfileName(String name) throws InterruptedException{
		Thread.sleep(2000);
		enterText(profileNameField,name);
		Reporter.log("Entered :"+name,true);
	}
	
	public void selectPreparingForOption(String domain) throws InterruptedException{
		Thread.sleep(2000);
		clickElement(preparingFor_DD);
		Reporter.log("Clicked on 'Preparing For' dropdown list",true);
		List<WebElement> list=preparingForList;
		int listSize=preparingForList.size();
		Reporter.log("List Size is : "+listSize,true);
		for(WebElement ele:list){
			Reporter.log(ele.getText(),true);
		}
		selectDropdownText(preparingFor_DD, domain);
		Reporter.log("Selected " +domain,true);
	}
	
}
