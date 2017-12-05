package TestCases;

import org.testng.annotations.Test;

import ContentTesting.BasePageMob;
import ContentTesting.LoginScreen;
import ContentTesting.PracticeScreen;
import ContentTesting.Splashscreen;

public class PracticeTest extends BaseTestMob 
{
	
	BasePageMob basepagemob;
	
	
	@Test
	public void loginTest() throws Exception
	{	
		/*Splashscreen ss=new Splashscreen(driverMob);	
		LoginScreen ls=ss.splashScreen();
		PracticeScreen ps=ls.loginScreen();
		ps.practiceScreen();*/
		
		PracticeScreen ps=new PracticeScreen(driverMob);	
		ps.practiceScreen();
		Thread.sleep(500000);
		
	
	}
}