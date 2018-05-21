package TestCases;

import org.testng.annotations.Test;

import Screens.BasePageMob;
import Screens.HomeScreen;
import Screens.StudyScreen;

public class StudyTest extends BaseTestMob 
{
	
	BasePageMob basepagemob;
	
	
	@Test
	public void loginTest() throws Exception
	{	
		HomeScreen hs=new HomeScreen(driverMob);
		StudyScreen study=hs.homescreen();
		study.studyScreen();
	}
}