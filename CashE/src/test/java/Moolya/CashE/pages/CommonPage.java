package Moolya.CashE.pages;


import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class CommonPage extends BasePage{
	
	public CommonPage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	

	//=Micromax Canvas 2
	@AndroidFindBy(id = "com.android.gallery3d:id/shutter_button_photo")
	public MobileElement camera;
	
	@AndroidFindBy(id = "com.android.gallery3d:id/btn_done")
	public MobileElement yes;
	
	@AndroidFindBy(id = "com.android.documentsui:id/date")
	public  MobileElement doc;

	
	/*//Nexus 5
	@AndroidFindBy(id = "com.android.camera2:id/photo_video_button")
	public MobileElement camera;
	
	@AndroidFindBy(id = "com.android.camera2:id/done_button")
	public MobileElement yes;
	
	@AndroidFindBy(name = "Documents")
	public  MobileElement document;
	
	@AndroidFindBy(id = "com.android.documentsui:id/line2")
	public  MobileElement doc;*/
	
	/*
	//Asus
	@AndroidFindBy(id = "com.asus.camera:id/button_capture")
	public MobileElement camera;
	
	@AndroidFindBy(id = "com.asus.camera:id/button_used")
	public MobileElement yes;
	
	@AndroidFindBy(id = "com.android.documentsui:id/date")//need to change
	public  MobileElement doc;*/
	
	//Nexus 6P
	
	/*@AndroidFindBy(id = "com.android.camera2:id/photo_video_button")
	public  MobileElement camera;
	
	@AndroidFindBy(id = "com.android.camera2:id/done_button")
	public  MobileElement yes;
	
	@AndroidFindBy(name = "Documents")
	public  MobileElement document;
	
	@AndroidFindBy(id = "com.asus.filemanager:id/file_list_item_name")
	public  MobileElement doc;
	
	//Moto G 3
	/*
	@AndroidFindBy(id = "com.motorola.camera:id/fragment")
	public static MobileElement camera;
	
	@AndroidFindBy(id = "com.motorola.camera:id/review_approve")
	public static MobileElement yes;
	
	@AndroidFindBy(id = "com.android.documentsui:id/icon_mime")
	public static MobileElement doc;*/
	
	
	
	
	
	

}
