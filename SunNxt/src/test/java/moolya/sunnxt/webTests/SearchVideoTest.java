package moolya.sunnxt.webTests;

import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.HomePage;

public class SearchVideoTest extends W_BaseTest{
	
private HomePage hp;
	
	@Test
	public void Filter_language() throws InterruptedException
	{   
		hp = new HomePage(wdriver);
		hp.do_search("Kodi");
		Thread.sleep(5000);
	}

}
