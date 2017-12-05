package DeeperApp;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Screens.BasePageMob;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.JavaUtils;

public class EnggLoginScreen extends BasePageMob
{

	public EnggLoginScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(id="com.msipl.deeper:id/buttonEngineering")
	MobileElement enggSignIn;
	
	@AndroidFindBy(id="com.msipl.deeper:id/buttonMedical")
	MobileElement medicalSignIn;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/editLoginId")
	MobileElement enggLoginEmailId;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/editLoginId")
	MobileElement medicalLoginEmailId;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/editPassword")
	MobileElement enggLoginPassword;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/editPassword")
	MobileElement medicalLoginPassword;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.engineering:id/buttonLogin")
	MobileElement enggLoginButton;
	
	@AndroidFindBy(id="com.embibe.institute.deeper.medical:id/buttonLogin")
	MobileElement medicalLoginButton;

	
	
	public void enggLoginScreen(String goal,String appId,String dob) throws Exception
	{
		if(goal.equalsIgnoreCase("medical")){
			medicalSignIn.click();
			waitUntilElementAppears(medicalLoginEmailId);
			medicalLoginEmailId.sendKeys(appId);
			Thread.sleep(2000);
			closeKeyboard();
			medicalLoginPassword.click();
			waitUntilElementclickable(date_List.get(0));
			String[] dobs = dob.split("-"); 
			selectDate(dobs[0], dobs[1], dobs[2]);
			waitUntilElementAppears(medicalLoginButton);
			medicalLoginButton.click();
		}
		else if(goal.equalsIgnoreCase("engineering")){
			enggSignIn.click();
			waitUntilElementAppears(enggLoginEmailId);
			enggLoginEmailId.sendKeys(appId);
			Thread.sleep(2000);
			closeKeyboard();
			enggLoginPassword.click();
			waitUntilElementclickable(date_List.get(0));
			String[] dobs = dob.split("-"); 
			selectDate(dobs[0], dobs[1], dobs[2]);
			waitUntilElementAppears(enggLoginButton);
			enggLoginButton.click();
		}
		
		//Reporter.log("Successfully Logged In",true);
	}
}
