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
import utils.GoogleSheetUpdateUtils;
import utils.JavaUtils;

public class IndividualDeeperAppLoginsTest extends BaseTestMob 
{
	BasePageMob ss;
	String sheetName = "Sheet1";
	LinkedHashMap<String, String> resultData;
	
	@Test(dataProvider="getDeeperActualData")
	public void loginTest(String row,String goal,String appId,String dob) throws Exception
	{	
		String status = "";
		try {
			basepagemob = new BasePageMob(driverMob);
			driverMob = basepagemob.LaunchmobApp(goal);
			EnggLoginScreen engglog=new EnggLoginScreen(driverMob);
			engglog.enggLoginScreen(goal,appId,dob);
			status = "Pass";
		} catch (Exception e) {
				status = "Fail";
		}
		resultData = new LinkedHashMap<String, String>();
		resultData.put("status", status);
		EmbibeUtils.writeDeeperActualData(sheetName, resultData, Integer.parseInt(row)+1);
		//GoogleSheetUpdateUtils.updateDeeperStudentLoginStatus(appId, status);
	}
	
	@DataProvider
	public Object[][] getDeeperActualData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		obj = EmbibeUtils.readDeeperUniqueValues(sheetName);
		return obj;
	}
}