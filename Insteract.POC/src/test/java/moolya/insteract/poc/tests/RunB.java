package moolya.insteract.poc.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import moolya.insteract.poc.pages.FlightSearchPage;
import moolya.insteract.poc.pages.LoginPage;
import moolya.insteract.poc.pages.MailinatorPage;
import moolya.insteract.poc.pages.MyTeamTravelPage;
import moolya.insteract.poc.pages.MyTravelPage;
import static io.restassured.path.json.JsonPath.from;


public class RunB extends W_BaseTest {


	LoginPage lp;
	FlightSearchPage fsp;
	private String uniqueValue = "Demo002";
	private String source = "INS101-1";
	private String destination = "INS101-2";
	private String trNum = "TR1311130773";
	private MyTravelPage mtp;
	private MailinatorPage mp;
	private String text;
	private MyTeamTravelPage mttp;

	@Test(priority=1)
	public void runBtest() throws InterruptedException, EncryptedDocumentException, InvalidFormatException, IOException{
		lp = new LoginPage(driver);
		lp.loginAsEmployee();
		fsp =new FlightSearchPage(driver);
		Thread.sleep(3000);
		fsp.searchFlights(uniqueValue);
		fsp =new FlightSearchPage(driver);
		trNum = fsp.getTRNumber();
		mtp = fsp.clickOnMyTravel();
		mtp.verifyPendingTravelRequest(trNum);
		mtp.logout();
		mp = mtp.goToMailinatorpage();
		mp.goToInbox(destination);
		mp.selectMailWithTR(trNum);
		lp = mp.openAppUrl(driver);
		lp.loginAsApprover();
		mttp = lp.clickOnMyTeamTravel();
		mttp.selectRequestWithTR(trNum);
		mttp.approveRequest();
		mttp.logout();
		
	}
}