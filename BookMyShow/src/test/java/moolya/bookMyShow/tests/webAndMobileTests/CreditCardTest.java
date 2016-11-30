package moolya.bookMyShow.tests.webAndMobileTests;

import java.io.IOException;

import org.testng.annotations.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;
import moolya.bookMyShow.pages.mobilePages.HomeScreen;
import moolya.bookMyShow.pages.mobilePages.LoginScreen;
import moolya.bookMyShow.pages.mobilePages.ProfileScreen;
import moolya.bookMyShow.pages.mobilePages.QuickPayScreen;
import moolya.bookMyShow.pages.webPages.HomePage;
import moolya.bookMyShow.pages.webPages.LoginPage;
import moolya.bookMyShow.pages.webPages.ProfilePage;
import moolya.bookMyShow.pages.webPages.QuickPayPage;

public class CreditCardTest extends BaseTest {

	HomeScreen hs;
	ProfileScreen ps;
	QuickPayScreen qps;
	LoginScreen ls;
	HomePage hp;
	LoginPage lp;
	ProfilePage pp;
	String cardName = "";
	QuickPayPage qp;

	@Test
	public void addcreditCardInMobileTest() throws IOException, InterruptedException{
		launchMobileApp();
		hs = new HomeScreen(mdriver);
		ps = hs.goToProfileScreen();
		ls = ps.goToLoginPage();
		hs = ls.login();
		ps = hs.goToProfileScreen();
		qps = ps.goToQuickPay();
		qps.addCard();
		cardName = qps.getCardName();
		closeMobileApp();
		Thread.sleep(15000);
	}
	
	@Test(dependsOnMethods="addcreditCardInMobileTest")
	public void removeCreditCardFromWebTest() throws IOException, InterruptedException, ATUTestRecorderException{
		launchWebApp();
		hp = new HomePage(wdriver);
		hp.selectCity();
		lp = hp.goToLoginPage();
		hp = lp.login();
		pp = hp.goToProfilePage();
		qp = pp.selectQuickPay();
		qp.removeCard(cardName);
		closeWebApp();
	}

}
