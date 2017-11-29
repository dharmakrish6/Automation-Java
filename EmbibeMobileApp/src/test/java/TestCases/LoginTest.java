package TestCases;

import org.testng.annotations.Test;

import Screens.BasePageMob;
import Screens.HomeScreen;
import Screens.LoginScreen;
import Screens.Splashscreen;
import Screens.StudyScreen;

public class LoginTest extends BaseTestMob 
{
	
	BasePageMob basepagemob;
	
	
	@Test
	public void loginTest() throws Exception
	{	
		Splashscreen ss=new Splashscreen(driverMob);	
		LoginScreen ls=ss.splashScreen();
		HomeScreen hs=ls.loginScreen();
		StudyScreen study=hs.homescreen();
		study.studyScreen();
		
	}
}