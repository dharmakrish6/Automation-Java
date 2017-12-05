package ContentTesting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import utils.EmbibeUtils;
import utils.JavaUtils;

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


	public void studyScreen() throws InterruptedException, IOException, EncryptedDocumentException, InvalidFormatException
	{
		ArrayList<LinkedHashMap<String, String>> results = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> resultData;
		studyLink.click();
		int subjectCount = Integer.parseInt(JavaUtils.getPropValue("subject"));
		int unitCount = Integer.parseInt(JavaUtils.getPropValue("unit"));
		int chapterCount = Integer.parseInt(JavaUtils.getPropValue("chapter"));
		int conceptCount = Integer.parseInt(JavaUtils.getPropValue("concept"));
		int a = subjectCount,b = unitCount,c = chapterCount,d = conceptCount;
		try {
			List<MobileElement> list=subjectList;
			for(;a<list.size();a++){
				MobileElement ele = list.get(a);
				String subject = ele.getText();
				ele.click();//Subject
				Reporter.log("Clicked on Subject "+subject, true);
				List<MobileElement> list2=chapterList;
				waitUntilElementclickable(list2.get(0));
				for(;b<list2.size();b++){
					MobileElement ele2 = list2.get(b);
					String unit = ele2.getText();
					ele2.click();//Unit
					Reporter.log("Clicked on Unit "+unit, true);
					List<MobileElement> list3=unitList;
					waitUntilElementclickable(list3.get(0));
					for(;c<list3.size();c++){
						MobileElement ele3 = list3.get(c);
						String chapter = ele3.getText();
						ele3.click();//Chapter
						Reporter.log("Clicked on Chapter "+chapter, true);
						List<MobileElement> list4=chapterList;
						Thread.sleep(2000);
						for(;d<list4.size();d++){
							MobileElement ele4 = list4.get(d);
							String concept = ele4.getText();
							ele4.click();//Concept
							Reporter.log("Clicked on Concept "+concept, true);
							List<MobileElement> list5=titleLists;
							for(MobileElement ele5:list5){
								String title = ele5.getText();
								String path = subject + " > " + unit + " > "  + chapter + " > "  + concept;
								String name = title;
								String type = "PDF";
								String status = "";
								ele5.click();//Title
								Reporter.log("Clicked on Pdf "+title,true);
								boolean isPDFview = false;
								try{
									isPDFview = pdfView.isDisplayed();
									Reporter.log(title+" PDF opened successfully",true);
									status = "Found";
									driverMob.navigate().back();
								}catch(Exception e){
									Reporter.log(title+" Pdf not found",true);
									status = "Not Found";
								}
								resultData = new LinkedHashMap<String, String>();
								resultData.put("Path", path);
								resultData.put("Name", name);
								resultData.put("Type", type);
								resultData.put("Status", status);
								results.add(resultData);
							}
							for(int i=0;i<videotitle.size();i++){
								String videoText = videotitle.get(i).getText();
								String path = subject + " > " + unit + " > "  + chapter + " > "  + concept;
								String name = videoText;
								String type = "Video";
								String status = "";
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
									status = "Found";
									driverMob.navigate().back();
								}catch(Exception e){
									Reporter.log(videoText+ " Video not found",true);
									status = "Not Found";
								}
								resultData = new LinkedHashMap<String, String>();
								resultData.put("Path", path);
								resultData.put("Name", name);
								resultData.put("Type", type);
								resultData.put("Status", status);
								results.add(resultData);
							}
							driverMob.navigate().back();
						}
						d=0;
						driverMob.navigate().back();
					}
					c=0;
					driverMob.navigate().back();
				}
				b=0;
				driverMob.navigate().back();	
			}
		} catch (Exception e) {
			JavaUtils.setPropValue("subject", String.valueOf(a));
			JavaUtils.setPropValue("unit", String.valueOf(b));
			JavaUtils.setPropValue("chapter", String.valueOf(c));
			JavaUtils.setPropValue("concept", String.valueOf(d));
			EmbibeUtils.writePdfVideoResults(results);
			//return new HomeScreen(driverMob);
		}
		JavaUtils.setPropValue("subject", String.valueOf(0));
		JavaUtils.setPropValue("unit", String.valueOf(0));
		JavaUtils.setPropValue("chapter", String.valueOf(0));
		JavaUtils.setPropValue("concept", String.valueOf(0));
		EmbibeUtils.writePdfVideoResults(results);
		//return new HomeScreen(driverMob);
	}
}