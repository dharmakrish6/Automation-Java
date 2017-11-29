package moolya.embibe.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.support.Color;

public class JavaUtils {

	public static HashMap<String, String> readExcelData(String sheetname, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException {
		HashMap<String,String> dataMap = null;
		String key, value = null;
		FileInputStream file = new FileInputStream("./test-data/TestData.xlsx");
		dataMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetname);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellValue = record.getCell(0).toString();
			if(cellValue.equals(uniqueValue)) {

				for(int i=0;i<headers.getLastCellNum();i++){
					try{
						if (record.getCell(i).getCellType() == record.getCell(i).CELL_TYPE_NUMERIC) {
							try{
								record.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
								value = record.getCell(i).toString().trim();
							}catch(Exception e){}
							key = headers.getCell(i).toString().trim();

						} else {

							key = headers.getCell(i).toString().trim();
							try {
								value = record.getCell(i).toString().trim();
							} catch (Exception e) {}
						}
					}catch(Exception e){
						continue;
					}

					dataMap.put(key, value);
				}

				break;
			}
		}
		return dataMap;
	}
	
	public static void writeResultsToFile(String fileName, String results) throws IOException{
		FileWriter writer = null;
		if (new File(fileName).exists())
					new File(fileName).delete();
		try {
			File file = new File( fileName );
			writer = new FileWriter( file,true );
//			results = results+",\n";	// screenDetails is the text used to write in file
//			writer.append( results );
			writer.write(results);
			file = null;
		} catch(IOException e) {}
		finally {
			if ( writer != null ) {
				writer.flush();
				writer.close();
			}
		}
	}
	
	public static HashMap<String, String> readGlobalSearchData(String sheetname, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException {
		HashMap<String,String> dataMap = null;
		String key, value = null;
		FileInputStream file = new FileInputStream("./test-data/GlobalSearchTestCases.xlsx");
		dataMap = new HashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetname);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {

			Row record = it.next();
			String cellValue = record.getCell(0).toString();
			if(cellValue.equals(uniqueValue)) {

				for(int i=0;i<headers.getLastCellNum();i++){
					try{
						if (record.getCell(i).getCellType() == record.getCell(i).CELL_TYPE_NUMERIC) {
							try{
								record.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
								value = record.getCell(i).toString().trim();
							}catch(Exception e){}
							key = headers.getCell(i).toString().trim();

						} else {

							key = headers.getCell(i).toString().trim();
							try {
								value = record.getCell(i).toString().trim();
							} catch (Exception e) {}
						}
					}catch(Exception e){
						continue;
					}

					dataMap.put(key, value);
				}

				break;
			}
		}
		return dataMap;
	}
	
	public static String[] getMinorDate(){
		String[] date = new String[3];
		Calendar c = Calendar.getInstance();
		c.add(Calendar.YEAR,-17);
		date[0] = Integer.toString(c.get(Calendar.DATE));
		date[1] = new DateFormatSymbols().getMonths()[c.get(Calendar.MONTH)];
		date[2] = Integer.toString(c.get(Calendar.YEAR));
		System.out.println("Selected Minor Date: "+date[0]+"-"+date[1]+"-"+date[2]);
		return date;
	}
	
	public static String rgbaToHex(String rgba){
		String hex = Color.fromString(rgba).asHex();
		return hex;
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
						}catch(Exception e){
								record.createCell(i).setCellValue(value);
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

	public static String generateRandomNumber(int number) {

		Random ran = new Random();
		int x = ran.nextInt(number)+1;
		String randomNo = String.valueOf(x);
		return randomNo;
	}

	public static String[] generateNrandomNumbers(int no, int number){
		Random ran = new Random();
		String[] randomNos = new String[no];
		HashSet<String> randomSet = new HashSet<String>();
		while(randomSet.size()<no){
			int x = ran.nextInt(number)+1;
			randomSet.add(String.valueOf(x));
		}
		int i=0;
		for(String s:randomSet){
			randomNos[i] = s;
			i++;
		}
		return randomNos;
	}

	public static String getTodaysDDxxMMMYYYY(){
		String[] suffixes =
				//    0     1     2     3     4     5     6     7     8     9
			{ "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
					//    10    11    12    13    14    15    16    17    18    19
					"th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
					//    20    21    22    23    24    25    26    27    28    29
					"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
					//    30    31
					"th", "st" };

		Date date = new Date();
		SimpleDateFormat formatDayOfMonth  = new SimpleDateFormat("d");
		int day = Integer.parseInt(formatDayOfMonth.format(date));
		String dayStr = day + suffixes[day];
		
		SimpleDateFormat formatMonthAndYear = new SimpleDateFormat("MMM yyyy");
		String mmyy = formatMonthAndYear.format(date);
		
		return dayStr +" "+ mmyy;
		
	}

	public String getTodaysDateAndTime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
		Date tdy = cal.getTime();
		String today = df.format(tdy);

		return today;
	}
	
	public static String getTodaysDateDDMMYYYY(){
		DateFormat df = new SimpleDateFormat("dd MMMM yyyy");

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


	public static String getPropValue(String key) throws IOException
	{
		File configFile = new File("./config.properties");
		String host = null;
		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			host = props.getProperty(key);
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}

		return host;
	}

	public static void setPropValue(String key,String value){
		File configFile = new File("./config.properties");
		try {
			Properties props = new Properties();
			props.setProperty(key, value);
			FileWriter writer = new FileWriter(configFile);
			props.store(writer, "host settings");
			writer.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}
	}
	
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
	

	public static void killDriver(String type) throws IOException, InterruptedException { 
		// Add different arguments In command line which requires to stop appium server. 
		Thread.sleep(2000);
		CommandLine command = new CommandLine("cmd"); 
		command.addArgument("/c"); 
		command.addArgument("taskkill"); 
		command.addArgument("/F"); 
		command.addArgument("/IM"); 
		switch(type){
		
		case "chrome": command.addArgument("chromedriver.exe");
		break;
		case "ff": command.addArgument("geckodriver.exe");
		break;
		
		}
		// Execute command line arguments to stop appium server. 
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler(); 
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.setExitValue(1); 
		executor.execute(command, resultHandler);
	}
	
	public static LinkedHashMap<String, String> addDataToResult(String key, String value, LinkedHashMap<String, String> resultData){
		try{
			resultData.put(key, value);
		}catch(Exception e){}
		return resultData;
	}
	
	public static String checkIfListContainAnother(String s1,String s2){
		boolean flag = true;
		String status = "Pass";
		try {
			flag = !Collections.disjoint(Arrays.asList(s1.split("\n")), Arrays.asList(s2.split("\n")));
			if(!flag){
				status = "Fail";
				return status;
			}
		} catch (Exception e) {}
		return status;
	}
	
	public static String getResultStatus(LinkedHashMap<String, String> resultData){
		String status = "Pass";
		try{
			if(!resultData.get("Dsl Result").equalsIgnoreCase(resultData.get("Actual Result"))){
				status = "Fail=Result";
				return status;
			}
		}catch(Exception e){}
		try{
			if(!resultData.get("Dsl Dym Terms").equalsIgnoreCase(resultData.get("Actual Dym Terms"))){
				status = "Fail=Dym Terms";
				return status;
			}
		}catch(Exception e){}
		try{
			if(!resultData.get("Dsl Current Goal").equalsIgnoreCase(resultData.get("Actual Current Goal"))){
				status = "Fail=Current Goal";
				return status;
			}
		}catch(Exception e){}
		try{
			if(!resultData.get("Dsl Current Exam").equalsIgnoreCase(resultData.get("Actual Current Exam"))){
				status = "Fail=Current Exam";
				return status;
			}
		}catch(Exception e){}
		status = checkIfListContainAnother(resultData.get("Dsl Valid Goals"), resultData.get("Actual Valid Goals"));
		if(status.equals("Fail")){
			status = "Fail=Valid Goals";
			return status;
		}
		status = checkIfListContainAnother(resultData.get("Dsl Valid Exams"), resultData.get("Actual Valid Exams"));
		if(status.equals("Fail")){
			status = "Fail=Valid Exams";
			return status;
		}
		/*try{
			if(!resultData.get("Dsl Dym Terms").equals(resultData.get("Actual Dym Terms"))){
				status = "Fail";
				return status;
			}
		}catch(Exception e){}*/
		
		return status;
	}

}
