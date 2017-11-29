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

public class EmbibeUtils {
	
	public static void writePdfVideoResults(String sheetName, ArrayList<LinkedHashMap<String, String>> results) throws EncryptedDocumentException, InvalidFormatException, IOException{
		String fileName = "./test-data/PdfVideoResults.xlsx";
		if (new File(fileName).exists())
			new File(fileName).delete();
		FileInputStream fis = new FileInputStream(fileName);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row headers = sheet.getRow(0);
		Iterator<Row> it = sheet.rowIterator();
		while(it.hasNext()){
			Row record = it.next();
			try {
				for(LinkedHashMap<String, String> resultData:results){
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
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		FileOutputStream fos = new FileOutputStream(fileName);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}

}
