package moolya.insteract.poc.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;

import moolya.insteract.poc.pages.LoginPage;
import moolya.insteract.poc.pages.MailinatorPage;
import moolya.insteract.poc.pages.ManageUserPage;
import moolya.insteract.poc.pages.ResetPasswordPage;

public class RunA extends W_BaseTest {

	private LoginPage lp;
	private String uniqueValue = "Demo001";
	private ManageUserPage mup;
	private MailinatorPage mp;
	private ResetPasswordPage rpp;

	@Test
	public void runAtest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Run A Test", "Sample Run A Test");
		lp = new LoginPage(driver);
		lp.loginToApp(uniqueValue);
		// info(details)
		test.info("Login to App Successfully");
		mup = lp.clickOnManageUser();
		mup.createUser(uniqueValue);
		// info(details)
		test.info("Created User Successfully");
		mup.logout();
		// info(details)
		test.info("Logged out successfully");
		mp = mup.goToMailinatorpage();
		mp.goToInbox(uniqueValue);
		mp.selectMailWithSubject(uniqueValue);
		rpp = mp.clickResetPassword();
		rpp.switchToNewTab();
		rpp.resetPassword(uniqueValue);
		rpp.switchToMainTaB();
		// info(details)
		test.info("Password reset successfully");
		driver = rpp.launchWebApp();
		lp = new LoginPage(driver);
		lp.loginAs(uniqueValue);
		lp.verifyUserMenuButton();
		// info(details)
		test.info("Verified Login successfully");
		lp.logout();
		// info(details)
		test.info("Logged out successfully");
	}

}
