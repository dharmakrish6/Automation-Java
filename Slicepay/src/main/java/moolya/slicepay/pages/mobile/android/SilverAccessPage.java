package moolya.slicepay.pages.mobile.android;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import moolya.slicepay.pages.mobile.M_BasePage;

public class SilverAccessPage extends M_BasePage {

	public SilverAccessPage(AppiumDriver<MobileElement> mdriver) {
		super(mdriver);
		PageFactory.initElements(new AppiumFieldDecorator(mdriver), this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id="indwin.c3.shareapp:id/start_now")
	private MobileElement startNow_Btn;
	
	@FindBy(name="SILVER ACCESS")
	private MobileElement silverAccess_Lbl;
	
	@FindBy(id="indwin.c3.shareapp:id/goto_fragment1")
	private MobileElement tab1_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/goto_fragment2")
	private MobileElement tab2_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/goto_fragment3")
	private MobileElement tab3_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/goto_fragment4")
	private MobileElement tab4_Btn;
	
	//	Tab1 Objects
	
	@FindBy(id="indwin.c3.shareapp:id/name")
	private MobileElement name_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/email")
	private MobileElement email_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/user_dob_edittext")
	private MobileElement dob_DF;
	
	@FindBy(id="indwin.c3.shareapp:id/connect_social_account_fb")
	private MobileElement connectSocialProfile_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/save_and_proceed")
	private MobileElement saveAndProceed_Btn;
	
	//	Tab2 Objects
	
	@FindBy(id="indwin.c3.shareapp:id/addImage")
	private List<MobileElement> frontAndBackImages_Upload;
	
	@FindBy(id="indwin.c3.shareapp:id/edit_college_name")
	private MobileElement collegeName_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/edit_course_name")
	private MobileElement courseName_DD;
	
	@FindBy(id="indwin.c3.shareapp:id/college_name")
	private MobileElement courseName_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/cant_find_college_button")
	private MobileElement selectCourseName_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/edit_college_end_date")
	private MobileElement graduationDate_DF;
	
	//	Tab3 Objects
	
	@FindBy(id="indwin.c3.shareapp:id/aadhar_or_pan_spinner")
	private MobileElement aadharPan_DD;
	
	@FindBy(id="indwin.c3.shareapp:id/edit_aadhar_number")
	private MobileElement aadharPanNumber_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/save_user_aadhar")
	private MobileElement saveAadharPan_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/addPanImage")
	private MobileElement panImage_Upload;
	
	@FindBy(id="indwin.c3.shareapp:id/address_proof_type_spinner")
	private MobileElement addressProof_DD;
	
	//	Tab4 Objects
	
	@FindBy(id="indwin.c3.shareapp:id/classmate_phone")
	private MobileElement classmatePhoneNumber_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/pick_contact")
	private MobileElement addClassmateContact_Picker;
	
	@FindBy(id="indwin.c3.shareapp:id/classmate_name")
	private MobileElement classmateName_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/place_of_stay")
	private MobileElement placeOfStay_DD;
	
	@FindBy(id="indwin.c3.shareapp:id/edit_current_address")
	private MobileElement addCurrentAddress_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/house_no_et")
	private MobileElement houseNumber_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/street_et")
	private MobileElement street_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/city_et")
	private MobileElement city_Picker;
	
	@FindBy(id="indwin.c3.shareapp:id/city_name")
	private MobileElement cityName_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/close_city_name_layout")
	private MobileElement closeCityPicker_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/pincode_et")
	private MobileElement pincode_TB;
	
	@FindBy(id="indwin.c3.shareapp:id/submit_address")
	private MobileElement  submitAddress_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/agreement_btn")
	private MobileElement acceptAgreement_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/take_a_selfie_button")
	private MobileElement takeSelfie_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/add_signature_button")
	private MobileElement addSignature_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/accept_terms")
	private MobileElement iAccept_Btn;
	
	@FindBy(id="indwin.c3.shareapp:id/ink")
	private MobileElement signatureField;
	
	@FindBy(id="indwin.c3.shareapp:id/save_signature")
	private MobileElement saveSignature_Btn;
	
	public void clickStartNow(){
		Reporter.log("Trying to click on Start Now...", true);
		try{
			startNow_Btn.click();
			Reporter.log("Clicked on Start Now", true);
		}catch(Exception e){
			Reporter.log("Start Now is not present, Proceeded", true);
		}
	}
	
	public void fillUpTab1(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("SilverAccess", uniqueValue);
		waitUntilElementAppears(name_TB);
		String aName = name_TB.getText();
		String eName = data.get("Name");
		Assert.assertTrue(aName.equalsIgnoreCase(eName), "Names not matching!... Actual Name: "+aName+" ---> Expected Name: "+eName);
		String aEmail = email_TB.getText();
		String eEmail = data.get("Email");
		Assert.assertTrue(aEmail.equalsIgnoreCase(eEmail), "Emails not matching!... Actual Email: "+aEmail+" ---> Expected Email: "+eEmail);
		dob_DF.click();
		Reporter.log("Selecting Date of birth...", true);
		selectDate(data.get("Day"), data.get("Month"), data.get("Year"));
		Reporter.log("Selected Date Of Birth: "+data.get("Day")+"-"+data.get("Month")+"-"+data.get("Graduation Year"), true);
//		connectSocialProfile_Btn.click();
//		connectToSocialAccount();
	}
	
	public void saveAndProceed(){
		waitUntilElementclickable(saveAndProceed_Btn);
		saveAndProceed_Btn.click();
		Reporter.log("Clicked on Save and Proceed", true);
	}
	
	public void goToTab2(){
		waitUntilElementclickable(tab2_Btn);
		tab2_Btn.click();
		Reporter.log("Clicked on Tab 2", true);
	}
	
	public void goToTab3(){
		waitUntilElementclickable(tab3_Btn);
		tab3_Btn.click();
		Reporter.log("Clicked on Tab 3", true);
	}
	
	public void goToTab4(){
		waitUntilElementclickable(tab4_Btn);
		tab4_Btn.click();
		Reporter.log("Clicked on Tab 4", true);
	}
	
	public void fillUpTab2(String uniqueValue) throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		HashMap<String, String> data = readExcelData("SilverAccess", uniqueValue);
		waitUntilElementclickable(frontAndBackImages_Upload.get(0));
		Reporter.log("Uploading College ID Front and Back...", true);
		frontAndBackImages_Upload.get(0).click();
		takePhoto();
		Reporter.log("Uploaded College ID Front", true);
		frontAndBackImages_Upload.get(1).click();
		takePhoto();
		Reporter.log("Uploaded College ID Back", true);
		waitUntilElementclickable(collegeName_TB);
		collegeName_TB.click();
		waitUntilElementAppears(courseName_TB);
		courseName_TB.sendKeys(data.get("College Name"));
		Thread.sleep(1000);
		selectCourseName_Btn.click();
		Reporter.log("Selected College Name: "+data.get("College Name"), true);
		waitUntilElementclickable(courseName_DD);
		courseName_DD.click();
		waitUntilElementAppears(courseName_TB);
		courseName_TB.sendKeys(data.get("Course Name"));
		Thread.sleep(1000);
		selectCourseName_Btn.click();
		Reporter.log("Selected Course Name: "+data.get("Course Name"), true);
		waitUntilElementclickable(graduationDate_DF);
		graduationDate_DF.click();
		Reporter.log("Selecting Graduation Date...", true);
		selectMonthAndYear(data.get("Graduation Month"), data.get("Graduation Year"));
		Reporter.log("Selected Graduation Month: "+data.get("Graduation Month")+" and Graduation Year: "+data.get("Graduation Year"), true);
	}
	
	public void fillUpTab3(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		HashMap<String, String> data = readExcelData("SilverAccess", uniqueValue);
		waitUntilElementclickable(aadharPan_DD);
		aadharPan_DD.click();
		selectDropdown(aadharPan_DD, data.get("Pan Aadhar?"));
		Reporter.log("Selected "+data.get("Pan Aadhar?"), true);
		aadharPanNumber_TB.sendKeys(data.get("Pan Aadhar Number"));
		Reporter.log("Entered "+data.get("Pan Aadhar?")+": "+data.get("Pan Aadhar Number"), true);
		saveAadharPan_Btn.click();
		Reporter.log("Saved "+data.get("Pan Aadhar?")+": "+data.get("Pan Aadhar Number"), true);
		if(data.get("Pan Aadhar?").equalsIgnoreCase("PAN")){
			Reporter.log("Uploading PAN...", true);
			waitUntilElementclickable(panImage_Upload);
			panImage_Upload.click();
			takePhoto();
			Reporter.log("Uploaded PAN", true);
			selectDropdown(addressProof_DD	, data.get("Proof Document"));
			Reporter.log("Selected Address Proof: "+data.get("Proof Document"), true);
		}
			
		Reporter.log("Uploading Aadhar/Address Proof Front and Back", true);
		waitUntilElementclickable(frontAndBackImages_Upload.get(0));
		frontAndBackImages_Upload.get(0).click();
		takePhoto();
		Reporter.log("Uploaded Aadhar/Address Proof Front", true);
		frontAndBackImages_Upload.get(1).click();
		takePhoto();
		Reporter.log("Uploaded Aadhar/Address Proof Back", true);
	}
	
	public void fillUpTab4(String uniqueValue) throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		HashMap<String, String> data = readExcelData("SilverAccess", uniqueValue);
		waitUntilElementAppears(classmatePhoneNumber_TB);
		classmatePhoneNumber_TB.sendKeys(data.get("Classmate Phone"));
		Reporter.log("Entered Classmate's Phone Number: "+data.get("Classmate Phone"), true);
		classmateName_TB.sendKeys(data.get("Classmate Name"));
		Reporter.log("Entered Classmate's Name: "+data.get("Classmate Name"), true);
		selectDropdown(placeOfStay_DD, data.get("Where You Stay"));
		Reporter.log("Selected where you stay: "+data.get("Where You Stay"), true);
		waitUntilElementclickable(addCurrentAddress_Btn);
		addCurrentAddress_Btn.click();
		Reporter.log("Clicked on Add Current Address Locality", true);
		houseNumber_TB.sendKeys(data.get("House Number"));
		Reporter.log("Entered House Number: "+data.get("House Number"), true);
		street_TB.sendKeys(data.get("Street"));
		Reporter.log("Entered Street: "+data.get("Street"), true);
		city_Picker.click();
		Reporter.log("Clicked on Add City", true);
		cityName_TB.sendKeys(data.get("City"));
		Reporter.log("Entering City Name : "+data.get("City"), true);
		Thread.sleep(2000);
		mdriver.tap(1, cityName_TB.getCenter().x, cityName_TB.getCenter().y+100, 1);
		Reporter.log("Selected City: "+data.get("City"), true);
		pincode_TB.sendKeys(data.get("Pincode"));
		Reporter.log("Entered Pincode: "+data.get("Pincode"), true);
		submitAddress_Btn.click();
		Reporter.log("Submitted Current Address", true);
		acceptAgreement_Btn.click();
		Reporter.log("Clicked on Accept Agreement", true);
		takeSelfie_Btn.click();
		mdriver.tap(1, 540,1780, 1);
		Reporter.log("Taken Selfie", true);
		addSignature_Btn.click();
		mdriver.tap(1, signatureField.getCenter().x,signatureField.getCenter().y, 1);
		Reporter.log("Signed in Signature Field", true);
		saveSignature_Btn.click();
		Reporter.log("Saved Signature", true);
		iAccept_Btn.click();
		Reporter.log("Clicked on I Accept", true);
	}
	
	public void unlock(){
		waitUntilElementclickable(saveAndProceed_Btn);
		saveAndProceed_Btn.click();
		Reporter.log("Clicked on Unlock", true);	
	}

}
