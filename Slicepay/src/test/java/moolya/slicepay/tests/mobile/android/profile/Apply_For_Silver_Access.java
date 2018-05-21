package moolya.slicepay.tests.mobile.android.profile;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.slicepay.pages.mobile.android.HomePage;
import moolya.slicepay.pages.mobile.android.ProfilePage;
import moolya.slicepay.pages.mobile.android.SignInPage;
import moolya.slicepay.pages.mobile.android.SilverAccessPage;
import moolya.slicepay.tests.mobile.M_BaseTest;

public class Apply_For_Silver_Access extends M_BaseTest {

	String uniqueValue = "Orders001";
	private SignInPage sip;
	private HomePage hp;
	private ProfilePage pp;
	private SilverAccessPage sap;
	@Test
	public void apply_For_Silver_Access_Test() throws IOException, InterruptedException, EncryptedDocumentException, InvalidFormatException{
		Reporter.log("Starting Test: Apply_For_Silver_Access_Test", true);
		sip = new SignInPage(mdriver);
		hp = sip.login(uniqueValue);
		pp = hp.goToProfilePage();
		sap = pp.clickUnlockNowSilver();
		sap.clickStartNow();
		sap.fillUpTab1(uniqueValue);
		sap.saveAndProceed();
		sap.fillUpTab2(uniqueValue);
		sap.saveAndProceed();
		sap.fillUpTab3(uniqueValue);
		sap.saveAndProceed();
		sap.fillUpTab4(uniqueValue);
		sap.unlock();
		Thread.sleep(5000);
	}

}
