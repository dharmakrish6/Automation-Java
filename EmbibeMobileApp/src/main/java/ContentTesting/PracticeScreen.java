package ContentTesting;

import java.util.List;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PracticeScreen extends BasePageMob
{

	public PracticeScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}
	
	@AndroidFindBy(name="PRACTICE")
	MobileElement practiceLink;
	
	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'textAction')]")
	List<MobileElement> downloadFileLists;
	
	
	@Test
	 public void practiceScreen() throws Exception
	{
		practiceLink.click();
		List<MobileElement> downloadLists=downloadFileLists;
		int i=downloadLists.size();
		Reporter.log("No. of download size : "+i,true);
		for(MobileElement ele:downloadLists){
			Reporter.log("download lists : " +ele.getText(),true);
			if(ele.getText()=="Download"){
				Actions act=new Actions(driverMob);
				act.moveToElement(ele).build().perform();
				System.out.println("1. Clicked on  "+ele.getText());
				/*ele.click();
				System.out.println("Clicked on  "+ele.getText());*/
			}
			else if(ele.getText()=="Feedback"){
				Actions act=new Actions(driverMob);
				act.moveToElement(ele).build().perform();
				System.out.println("1. Clicked on  "+ele.getText());
				/*ele.click();
				System.out.println("Clicked on  "+ele.getText());*/
			}
			else if(ele.getText()=="Resume"){
				Actions act=new Actions(driverMob);
				act.moveToElement(ele).build().perform();
				System.out.println("1. Clicked on  "+ele.getText());
				/*ele.click();
				System.out.println("Clicked on  "+ele.getText());*/
			}
			else if(ele.getText()=="Start"){
				Actions act=new Actions(driverMob);
				act.moveToElement(ele).build().perform();
				System.out.println("1. Clicked on  "+ele.getText());
				/*ele.click();
				System.out.println("Clicked on  "+ele.getText());*/
			}
			
		}
	}
}
