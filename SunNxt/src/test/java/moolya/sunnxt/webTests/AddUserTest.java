package moolya.sunnxt.webTests;

import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.HomePage;

public class AddUserTest extends W_BaseTest{

private HomePage hp;
	
	@Test
	public void Add_user() throws InterruptedException
	{   
		hp = new HomePage(wdriver);
		hp.click_MyProfile();
		hp.switch_profile();
		Thread.sleep(2000);
		hp.add_profile("Sneha", "qwerty1234");
		Thread.sleep(5000);
	}
}
