package Screens;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomeScreen extends BasePageMob
{

	public HomeScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(name="STUDY")
	MobileElement studyLink;
	
	@AndroidFindBy(xpath="//android.widget.ImageView/preceding-sibling::android.widget.TextView")
	List<MobileElement> subjectList;
	
	
	public StudyScreen homescreen() throws InterruptedException, IOException
	{
		Thread.sleep(5000);
		Reporter.log("Navigated to Home Screen",true);
		return new StudyScreen(driverMob);
	}
}