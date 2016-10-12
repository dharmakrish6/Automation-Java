package moolya.apiTesting.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.SkipException;

public class CommonUtils {

	public static Map<String,String> createParamsMap(String[] paramKeys,String[] paramValues){
		Map<String,String> params=new HashMap<String,String>();
		for(int i=0;i<paramKeys.length;i++){
			if(paramValues.length<paramKeys.length&&i==paramKeys.length-1)
				params.put(paramKeys[i], null);
			else
				params.put(paramKeys[i], paramValues[i]);
		}
		return params;
	}
	
	public static void printMap(Map<String, String> m){
		for(Map.Entry<String, String> entry:m.entrySet())
			System.out.println("Key: "+entry.getKey()+" Value: "+entry.getValue());
	}
	
	public String getPropertyOf(String key) {

		String propValue = null;
		try {
			FileInputStream input = new FileInputStream("./config.properties");
			Properties prop = new Properties();
			prop.load(input);

			propValue = prop.getProperty(key);

		} catch (IOException e) {
			System.out.println("Caught the below exception!");
			e.printStackTrace();
		}
		return propValue;
	}

	public String checkExecutionStatus(String sheetName, String testCaseID) throws EncryptedDocumentException, InvalidFormatException, IOException {

		HashMap<String, String> testRow = readExcelData(sheetName, testCaseID);
		String testDesc = testRow.get("Test Description");

		/*
		 * Checks the execution status of the current testCaseID which is set in
		 * the Excel - TestData sheet if marked 'Yes' testCase would execute ,
		 * else testCase would skip
		 */
		if (testRow.get("Execution Status").toLowerCase().equalsIgnoreCase("no")) {
			throw new SkipException(
					"Skipping the test flow with ID " + testCaseID + " as it marked 'NO' in the Execution Excel Sheet");
		}

		Reporter.log("\nExecuting the " + testRow.get("Test Description") + " : " + testCaseID, true);
		return testCaseID;
	}
	
	public static HashMap<String, String> readExcelData(String sheetname, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException {
		try{
			String key, value = null;
			FileInputStream file = new FileInputStream("./test-data/testData.xlsx");
			HashMap<String,String> dataMap = new HashMap<String, String>();
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet(sheetname);
			Iterator<Row> it = sheet.rowIterator();

			Row headers = it.next();
			while(it.hasNext()) {

				Row record = it.next();
				String cellValue = record.getCell(0).toString();
				if(cellValue.equalsIgnoreCase(uniqueValue)) {
					
						for(int i=0;i<headers.getLastCellNum();i++){
							key = headers.getCell(i).toString();
							try{
								value = record.getCell(i).toString();
							
							}catch(Exception e){}
							dataMap.put(key, value);
						}
					
					break;
				}
			}
			return dataMap;
		}
		catch(Exception e){}
		return null;
	}
	
	public static void writeValueToExcel(String sheetname,String uniqueValue, String columnName, String value) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream file = new FileInputStream("./test-data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetname);
		Iterator<Row> it = sheet.rowIterator();
		
		Row headers = it.next();
		while (it.hasNext()) {

			Row record = it.next();
			String cellValue = record.getCell(0).toString().trim();
			if (cellValue.equalsIgnoreCase(uniqueValue)) {
				for(int i=0;i<headers.getLastCellNum();i++){
					if(headers.getCell(i).getStringCellValue().equals(columnName)){
						try{
							record.getCell(i).setCellValue(value);
						}
						catch(Exception e){
							record.createCell(i).setCellValue(columnName);
						}
						break;
					}
				}
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/testData.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	public static void appendValueToExcel(String sheetname,String uniqueValue, String columnName, String value) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream file = new FileInputStream("./test-data/testData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetname);
		Iterator<Row> it = sheet.rowIterator();
		
		Row headers = it.next();
		while (it.hasNext()) {

			Row record = it.next();
			String cellValue = record.getCell(0).toString().trim();
			if (cellValue.equalsIgnoreCase(uniqueValue)) {
				for(int i=0;i<headers.getLastCellNum();i++){
					if(headers.getCell(i).getStringCellValue().equals(columnName)){
						record.getCell(i).setCellValue(record.getCell(i).getStringCellValue()+value);
						break;
					}
				}
				break;
			}
		}
		FileOutputStream fos = new FileOutputStream("./test-data/testData.xlsx");
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	public String generateRandomNumber(int number) {

		Random ran = new Random();
		int x = ran.nextInt(number);
		String randomNo = "1528900" + String.valueOf(x);
		return randomNo;
	}

	public String getTodaysDateAndTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
		Date tdy = cal.getTime();
		String today = df.format(tdy);

		return today;
	}

	public String getRequiredDateandTime(int daysToAdd) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar cal1 = Calendar.getInstance();
		cal1.add(Calendar.DATE, daysToAdd);
		Date day = cal1.getTime();
		String reqDate = df.format(day);

		return reqDate;
	}
}
