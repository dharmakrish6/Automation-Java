package moolya.filpkartdemo.tests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import moolya.filpkartdemo.pages.HomePage;
import moolya.filpkartdemo.pages.MobilesPage;
import moolya.filpkartdemo.utils.DbUtils;
import moolya.filpkartdemo.utils.JavaUtils;

public class FlipkartTest extends W_BaseTest {

	HomePage hp;
	MobilesPage mp;
//	String uniqueValue = "fk002";
	String[] details;
	DbUtils dbu;

	@Test(dataProvider="getData")
	public void demoTest(String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException, ClassNotFoundException{
		hp = new HomePage(wdriver);
		mp = hp.goToMobiles();
		mp.filterPrice(uniqueValue);
		mp.filterBrand(uniqueValue);
		mp.filterOS(uniqueValue);
		details = mp.getMobileDetails(uniqueValue);
		dbu = new DbUtils();
		dbu.storeMobileDetailsToDb(details);
	}
	
	@AfterMethod
	public void afterMethod() throws IOException{
		wdriver.get(JavaUtils.getPropValue("appUrl"));
	}

	@DataProvider
	public Object[][] getData() throws EncryptedDocumentException, InvalidFormatException, IOException{
		Object[][] obj = null;
		String dir = System.getProperty("user.dir");
		FileInputStream fis = new FileInputStream(dir+"/test-data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Mobiles");
		obj = new Object[sh.getLastRowNum()][1];
		Iterator<Row> it = sh.rowIterator();
		it.next();
		int i=0;
		while(it.hasNext()){
			Row r = it.next();
			obj[i][0] = r.getCell(0).toString();
			i++;
		}
		return obj;
	}
	
}
