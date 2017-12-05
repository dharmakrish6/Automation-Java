package DeeperApp;

import org.openqa.selenium.support.PageFactory;

import Screens.BasePageMob;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class InstituteLoginScreen extends BasePageMob
{

	public InstituteLoginScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(id="com.msipl.deeper:id/AppEdit")
	MobileElement InstLoginId;
	
	@AndroidFindBy(id="com.msipl.deeper:id/DOBEdit")
	MobileElement InstLoginPassword;
	
	@AndroidFindBy(id="com.msipl.deeper:id/LoginBut")
	MobileElement InstLoginButton;

	
	
	public HomeScreen instituteLoginScreen() throws Exception
	{
		waitUntilElementAppears(InstLoginId);
		InstLoginId.sendKeys("REG71491");
		closeKeyboard();
		InstLoginPassword.sendKeys("18/08/2000");
		closeKeyboard();
		Thread.sleep(2000);
		InstLoginButton.click();
		return new HomeScreen(driverMob);
	}
}
