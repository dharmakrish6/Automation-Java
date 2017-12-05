package DeeperApp;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import Screens.BasePageMob;
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
	
	@AndroidFindBy(name="Open")
	MobileElement hamburger;
	
	@AndroidFindBy(name="Practice Exams")
	MobileElement practiceExams;
	
	@AndroidFindBy(id="com.msipl.deeper:id/buttonVerify")
	MobileElement sendVerification_Btn;
	
	@AndroidFindBy(id="com.msipl.deeper:id/toptitle")
	MobileElement topTitle;
	
	
	public EnggLoginScreen homescreen() throws InterruptedException, IOException
	{
		Reporter.log("Navigated to Home Screen",true);
		waitUntilElementclickable(sendVerification_Btn);
		driverMob.navigate().back();
		waitUntilElementclickable(hamburger);
		hamburger.click();
		waitUntilElementclickable(topTitle);
		driverMob.scrollTo("Practice Exams");
		waitUntilElementclickable(practiceExams);
		practiceExams.click();
		waitUntilElementclickable(sendVerification_Btn);
		driverMob.navigate().back();
		return new EnggLoginScreen(driverMob);
	}
}