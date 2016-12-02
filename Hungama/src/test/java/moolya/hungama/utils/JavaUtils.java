package moolya.hungama.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class JavaUtils {
	
	public void apnModeON() throws IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 1");
		p = Runtime.getRuntime().exec("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");
		Thread.sleep(5000);
	}
	
	public void apnModeOFF() throws IOException, InterruptedException{
		Process p = Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 0");
		p = Runtime.getRuntime().exec("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE");
		Thread.sleep(5000);
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


}
