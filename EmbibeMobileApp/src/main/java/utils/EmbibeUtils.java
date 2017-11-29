package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
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
		String fileName = "\\test-data\\PdfVideoResults.xlsx";
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
				for(int i=1;i<headers.getLastCellNum();i++){
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

}
