package moolya.reflectionSample;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiUtils {

	public static String[] getScenarioSteps(String scenarioName){
		String[] steps = null;
		try{
			String key, value = null;
			FileInputStream file = new FileInputStream("./test-data/testData.xlsx");
			HashMap<String,String> dataMap = new HashMap<String, String>();
			Workbook wb = WorkbookFactory.create(file);
			Sheet sheet = wb.getSheet("Main");
			Iterator<Row> it = sheet.rowIterator();

			Row headers = it.next();
			while(it.hasNext()) {

				Row record = it.next();
				String cellValue = record.getCell(0).toString();
				if(cellValue.equalsIgnoreCase(scenarioName)) {
						steps = new String[record.getLastCellNum()];
						for(int i=0;i<record.getLastCellNum();i++){
							if (record.getCell(i).getCellType() == record.getCell(i).CELL_TYPE_NUMERIC) {
								try{
									record.getCell(i).setCellType(Cell.CELL_TYPE_STRING);
									value = record.getCell(i).toString().trim();
								}catch(Exception e){}

							} else {

								try {
									value = record.getCell(i).toString().trim();
								} catch (Exception e) {}
							}
							steps[i] = value;
						}
					
					break;
				}
			}
			return steps;
		}
		catch(Exception e){}
		return null;
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
}
