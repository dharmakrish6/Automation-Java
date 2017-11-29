package Screens;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class StudyScreen extends BasePageMob
{

	public StudyScreen(AppiumDriver<MobileElement> driverMob) 
	{
		super(driverMob);
		PageFactory.initElements(new AppiumFieldDecorator(driverMob), this);
	}

	@AndroidFindBy(name="STUDY")
	MobileElement studyLink;

	@AndroidFindBy(xpath="//android.widget.ImageView/preceding-sibling::android.widget.TextView")
	List<MobileElement> subjectList;

	@AndroidFindBy(xpath="//android.widget.ImageView/preceding-sibling::android.widget.TextView")
	List<MobileElement> chapterList;


	@AndroidFindBy(xpath="//android.widget.ImageView/preceding-sibling::android.widget.TextView")
	List<MobileElement> unitList;

	@AndroidFindBy(id="pdfView")
	MobileElement pdfView;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'textReadPdf')]/following-sibling::android.support.v7.widget.RecyclerView[@index='2']//android.widget.TextView")
	List<MobileElement> titleLists;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'textReadPdf')]/following-sibling::android.support.v7.widget.RecyclerView[@index='2'//android.widget.TextView")
	MobileElement title;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'textWatchVideos')]/following-sibling::android.support.v7.widget.RecyclerView//android.widget.TextView")
	List<MobileElement> videotitle;

	@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'textWatchVideos')]/following-sibling::android.support.v7.widget.RecyclerView//android.widget.ImageView[contains(@resource-id,'thumbnail')]")
	List<MobileElement> videoThumbNail1;

	//@AndroidFindBy(xpath="//android.widget.TextView[contains(@resource-id,'recyclerViewVideos')]/following-sibling::android.support.v7.widget.RecyclerView//android.widget.ImageView[contains(@resource-id,'layoutVideo')]")
	@AndroidFindBy(id="imageIcon")
	List<MobileElement> videoThumbNail2;


	@AndroidFindBy(id="org.videolan.vlc:id/player_ui_container")
	MobileElement videoContainer;


	public HomeScreen studyScreen() throws InterruptedException, IOException
	{
		studyLink.click();
		List<MobileElement> list=subjectList;
		for(MobileElement ele:list){
			String subject = ele.getText();
			ele.click();//Subject
			Reporter.log("Clicked on Subject "+subject, true);
			List<MobileElement> list2=chapterList;
			waitUntilElementclickable(list2.get(0));
			for(MobileElement ele2:list2){
				String unit = ele2.getText();
				ele2.click();//Unit
				Reporter.log("Clicked on Unit "+unit, true);
				List<MobileElement> list3=unitList;
				waitUntilElementclickable(list3.get(0));
				for(MobileElement ele3:list3){
					String chapter = ele3.getText();
					ele3.click();//Chapter
					Reporter.log("Clicked on Chapter "+chapter, true);
					List<MobileElement> list4=chapterList;
					Thread.sleep(2000);
					//waitUntilElementclickable(list4.get(0));
					for(MobileElement ele4:list4){
						String concept = ele4.getText();
						ele4.click();//Concept
						Reporter.log("Clicked on Concept "+concept, true);

						List<MobileElement> list5=titleLists;
						for(MobileElement ele5:list5){
							String title = ele5.getText();
							ele5.click();//Title
							/*//Reporter.log(title.getText(), true);
						String titleText = title.getText();
						title.click();*/
							Reporter.log("Clicked on Pdf "+title,true);
							boolean isPDFview = false;
							try{
								isPDFview = pdfView.isDisplayed();
								Reporter.log(title+" PDF opened successfully",true);
								driverMob.navigate().back();
							}catch(Exception e){
								Reporter.log(title+" Pdf not found",true);
								ele5.isDisplayed();
//								driverMob.navigate().back();
							}
						}
						for(int i=0;i<videotitle.size();i++){
							String videoText = videotitle.get(i).getText();
							Thread.sleep(1000);
							try{
								videoThumbNail1.get(i).click();
								Reporter.log("Clicked on Video "+videoText,true);
							}
							catch(Exception e){
								videoThumbNail2.get(i).click();
								Reporter.log("Clicked on Video "+videoText,true);
							}
							boolean isVideoView = false; 
							try{
								isVideoView = videoContainer.isDisplayed();
								Reporter.log(videoText+ " Video opened successfully",true);
								driverMob.navigate().back();
							}catch(Exception e){
								Reporter.log(videoText+ " Video not found",true);
							}

						}
						driverMob.navigate().back();
					}
					driverMob.navigate().back();
				}
				driverMob.navigate().back();
			}
			driverMob.navigate().back();	
		}
		return new HomeScreen(driverMob);
	}
}