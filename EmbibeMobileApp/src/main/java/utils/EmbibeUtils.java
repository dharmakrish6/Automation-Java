package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmbibeUtils {
	
	public static void writePdfVideoResults(ArrayList<LinkedHashMap<String, String>> results) throws EncryptedDocumentException, InvalidFormatException, IOException{
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-HH-mm-ss");
		Date date = new Date();
		String fileName = "\\test-data\\PdfVideoResults-"+dateFormat.format(date)+".xlsx";
		String dir = System.getProperty("user.dir");
		fileName = dir+ fileName;
		if (new File(fileName).exists()){
			new File(fileName).delete();
		}
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("Sheet1");
		Row headers = sheet.createRow(0);
		int h=0;
		for(String header:results.get(0).keySet()){
			headers.createCell(h++).setCellValue(header);
		}
		int r = 1;
		for(LinkedHashMap<String, String> resultData:results){
			Row record = sheet.createRow(r++);
			for(Map.Entry<String, String> m:resultData.entrySet()){
				for(int i=0;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(m.getKey())){
							Cell cell = null;
							try{
								cell = record.createCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								cell.setCellValue(m.getValue().toString());
							}catch(Exception e){}
							break;
						}
					}catch(Exception e){
						continue;
					}
				}
			}
		}
	
		FileOutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	public static String[][] readDeeperUniqueValues(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		
		String fileName = System.getProperty("user.dir")+"\\test-data\\DeeperLogins.xlsx";
		FileInputStream file = new FileInputStream(fileName);
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		int noOfRows = sheet.getLastRowNum(); 
		String[][] values = new String[noOfRows][4];
		for(int i=1;i<=noOfRows;i++) {
			Row record = sheet.getRow(i);
			try {
				values[i-1][0] = Integer.toString(i-1);
				values[i-1][1] = record.getCell(0).toString().trim();
				values[i-1][2] = record.getCell(1).toString().trim();
				values[i-1][3] = record.getCell(2).toString().trim();
				
			} catch (Exception e) {
				values[i-1][0] = Integer.toString(i-1);
				values[i-1][1] = record.getCell(0).getStringCellValue();
				values[i-1][2] = record.getCell(1).getStringCellValue();
				values[i-1][3] = record.getCell(2).getStringCellValue();
			}
		}
		wb.close();
		file.close();
		return values;
	}
	
	public static void writeDeeperActualData(String sheetName, LinkedHashMap<String, String> resultData, int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String fileName = System.getProperty("user.dir")+"\\test-data\\DeeperLogins.xlsx";
		FileInputStream fis = new FileInputStream(fileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row headers = sheet.getRow(0);
		Row record = sheet.getRow(row);
		try {
			for(Map.Entry<String, String> m:resultData.entrySet()){
				for(int i=1;i<headers.getLastCellNum();i++){
					try{
						if (headers.getCell(i).toString().trim().equalsIgnoreCase(m.getKey())){
							Cell cell = null;
							try{
								cell = record.getCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								cell.setCellValue(m.getValue().toString());
							}catch(Exception e){
								cell = record.createCell(i);
								cell.setCellType(Cell.CELL_TYPE_STRING);
								cell.setCellValue(m.getValue().toString());
							}

							break;
						}
					}catch(Exception e){
						continue;
					}
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		FileOutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

}
