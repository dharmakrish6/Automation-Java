package TestCases;

import org.testng.annotations.Test;

import WebAppContentTesting.BasePageMob;
import WebAppContentTesting.LoginScreen;
import WebAppContentTesting.PracticeScreen;
import WebAppContentTesting.Splashscreen;

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