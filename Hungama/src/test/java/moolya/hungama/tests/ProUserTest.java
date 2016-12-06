package moolya.hungama.tests;

import org.testng.annotations.Test;

import moolya.hungama.pages.HomePage;
import moolya.hungama.pages.LoginPage;

public class ProUserTest extends M_BaseTest {

	private HomePage hp;
	private LoginPage lp;

	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		hp=new HomePage(mdriver);
		hp.openNavDrawer();
		lp=hp.Subscriber_Login();
		lp.Login_Screen();
		
	}
	
}
