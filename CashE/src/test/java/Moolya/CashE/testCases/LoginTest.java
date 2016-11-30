package Moolya.CashE.testCases;

//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Moolya.CashE.pages.BankDetails;
import Moolya.CashE.pages.CasheYouCanGet;
import Moolya.CashE.pages.LoginScreen;
import Moolya.CashE.pages.MoreAboutYou;
import Moolya.CashE.pages.MoreAboutYou2;
import Moolya.CashE.pages.PersonalInfo;
import Moolya.CashE.pages.RealPerson;
import Moolya.CashE.pages.Splashscreen;
import Moolya.CashE.pages.WhereILive;
import Moolya.CashE.pages.WhoIAm1;
import Moolya.CashE.pages.WhoIAmScreen;

public class LoginTest extends BaseTest{
	
	String uniqueValue = "SAN_001";
	
	@Test
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		Splashscreen ss= new Splashscreen(driverMob);
		LoginScreen ls = null ;
		try{
			ls = ss.skipButton();
		}catch(Exception e){}
		//to be written in another class
		WhoIAmScreen ws1 = ls.loginMethod(uniqueValue);
		WhoIAm1 ws2 = ws1.whoIAmScreen(uniqueValue);
		RealPerson rp = ws2.whoIAmScreen2();
		WhereILive wl = rp.realPersonScreen();
		MoreAboutYou my = wl.whereILiveScreen();
		MoreAboutYou2 my2 = my.moreAboutYouScreen();
		PersonalInfo pi=my2.moreAboutYou2();
		BankDetails bd = pi.personalInforScreen();
		CasheYouCanGet cg = bd.bankDetailsScreen();
		cg.casheScreen();
	}
	
	/*@Test
	public void loginTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		Splashscreen ss= new Splashscreen(driverMob);
		LoginScreen ls = ss.skipButton();
		//BankDetails bd = 
		CasheYouCanGet cg = ls.loginMethod("Facebook");
		cg.casheScreen();
	}*/
	
	
	@DataProvider
	public Object[][] getUniqueValues(){
		String filename = "./test-data/CASHe.xlsx";
		Object[][] obj;
		try{
			FileInputStream file = new FileInputStream(filename);
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet("Login");
			int noOfRows = sheet.getLastRowNum();
			Iterator<Row> it = sheet.rowIterator();
			obj = new Object[noOfRows][1];
			it.next();
			int i = 0;
			while(it.hasNext()){
				obj[i][0] = it.next().getCell(0).toString();
				i++;
			}
		}
		catch(Exception e){
			e.printStackTrace();
			return null;
		}
		return obj;
	}
}
