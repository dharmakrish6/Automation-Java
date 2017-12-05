package TestCases;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DeeperApp.EnggLoginScreen;
import DeeperApp.HomeScreen;
import DeeperApp.InstituteLoginScreen;
import DeeperApp.Splashscreen;
import Screens.BasePageMob;
import utils.EmbibeUtils;
import utils.JavaUtils;

public class DeeperAppLoginTest extends BaseTestMob 
{
	BasePageMob ss;
	String sheetName = "Sheet1";
	LinkedHashMap<String, String> resultData;
	
	@Test(dataProvider="getDeeperActualData")
	public void loginTest(String row,String goal,String appId,String dob) throws Exception
	{	
		
		boolean flag = false;
		try {
			Splashscreen ss=new Splashscreen(driverMob);
			InstituteLoginScreen insLog=ss.splashScreen();
			HomeScreen hs= insLog.instituteLoginScreen();
			EnggLoginScreen engglog=hs.homescreen();
			engglog.enggLoginScreen(goal,appId,dob);
			flag = true;
		} catch (Exception e) {
			resultData = new LinkedHashMap<String, String>();
			if(flag)
				resultData.put("status", "Pass");
			else{
				resultData.put("status", "Fail");
				resultData.put("Comments", e.getMessage());
			}
			EmbibeUtils.writeDeeperActualData(sheetName, resultData, Integer.parseInt(row)+1);
		}
		
		/*HomeScreen hs=new HomeScreen(driverMob);	
		EnggLoginScreen engglog=hs.homescreen();
		engglog.enggLoginScreen();*/
	}
	
	@DataProvider
	public Object[][] getDeeperActualData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		obj = EmbibeUtils.readDeeperUniqueValues(sheetName);
		return obj;
	}
}