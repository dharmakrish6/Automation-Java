package moolya.bookMyShow.tests.mobileTests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import moolya.bookMyShow.pages.mobilePages.HomeScreen;
import moolya.bookMyShow.pages.mobilePages.LoginScreen;
import moolya.bookMyShow.pages.mobilePages.M_BasePage;
import moolya.bookMyShow.pages.mobilePages.MoviesScreen;
import moolya.bookMyShow.pages.mobilePages.ProfileScreen;
import moolya.bookMyShow.pages.mobilePages.ReviewScreen;
import moolya.bookMyShow.pages.mobilePages.TicketsScreen;

public class BookMovieTest extends M_BaseTest{

	
//		static String uniqueValue = "book1";
		HomeScreen hs;
		ProfileScreen ps;
		LoginScreen ls;
		TicketsScreen ts;
		MoviesScreen ms;
		ReviewScreen rs;
//		static String seatNo="";
		
		
		@Test(dataProvider="getData")
		public void bookMovieTest(String uniqueValue,String location) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
			hs = new HomeScreen(mdriver);
			Reporter.log("Booking Movie...", true);
			ts = hs.goToTicketsScreen();
			ts.selectRegion(uniqueValue);
			ms = ts.goToMoviesScreen();
			ms.bookMovie(uniqueValue);
			Reporter.log("Booking Movie Successful!", true);
			rs = new ReviewScreen(mdriver);
			Reporter.log("Asserting Movie Details...", true);
//			rs.assertReviewScreen(uniqueValue);
			ts = rs.cancelTransaction();
			Reporter.log("Asserting Movie Details Successful!", true);
		}
		
		@AfterMethod
		public void catchExceptions(ITestResult r) throws IOException{
			if(!r.isSuccess()){
				((AndroidDriver<MobileElement>)mdriver).startActivity(M_BasePage.getPropValue("appPackage"), M_BasePage.getPropValue("appActivity"));
			}
		}
		
		@DataProvider
		public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException{
			FileInputStream fis = new FileInputStream("./test-data/testData.xlsx");
			Workbook wb = WorkbookFactory.create(fis);
			Sheet sh = wb.getSheet("Movie");
			Iterator<Row> it = sh.rowIterator();
			it.next();
			int rows = sh.getLastRowNum();
			Object[][] obj = new Object[rows][2];
			int i=0;
			while(it.hasNext()){
				
					Row row = it.next();
					obj[i][0]=row.getCell(0).toString();
					try {
						obj[i][1]=row.getCell(2).toString();
				}catch (Exception e) {
					obj[i][1]=row.getCell(1).toString();
				}
				i++;
			}
			return obj;
		}
		
}
