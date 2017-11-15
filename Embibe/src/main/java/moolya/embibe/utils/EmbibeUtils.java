package moolya.embibe.utils;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static io.restassured.path.json.JsonPath.from;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;

import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;




public class EmbibeUtils {
	
	public static HashMap<String, String> examsMap = new HashMap<String, String>(){{
		put("ex15", "10th Foundation");put("ex14", "10th NTSE");put("ex16", "9th Foundation");
		put("ex17", "8th Foundation");put("ex27", "IBPS Clerk Mains");put("ex13", "IBPS PO Prelims");
		put("ex26", "SBI Clerk Mains");put("ex53", "IBPS Clerk Prelims");put("ex51", "IBPS PO Mains");
		put("ex52", "SBI Clerk Prelims");put("ex21", "SBI PO Mains");put("ex28", "SBI PO Prelims");
		put("ex4", "JEE Main");put("ex6", "BITSAT");put("ex30", "AP EAMCET");
		put("ex31", "TS EAMCET");put("ex18", "JEE Advanced");put("ex29", "GUJCET");
		put("ex32", "VITEEE");put("ex47", "Assam CEE");put("ex58", "JIPMER");
		put("ex9", "NEET");put("ex19", "AIIMS");
	}};
	
	public static String getDslResponse(String query) throws IOException{
		Response response = null;
		String url = JavaUtils.getPropValue("dslUrl");
		query = query.trim().replaceAll(" ", "+");
		url = url + "?query=" + query + "&consumer=tech";
		System.out.println(url);
		response = ApiUtils.getJSONResponseWithoutParameters(url);
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode==200||statusCode==201,"Response Failure!!! --> Status Code: "+statusCode);
		return response.asString();
	}
	
	public static LinkedHashMap<String,String> getResultsFromJson(String jsonString,int maxLength) throws JSONException{
//		ArrayList<LinkedHashMap<String, String>> widgetList = new ArrayList<LinkedHashMap<String, String>>();
		String widgets = "";
		JSONObject json = new JSONObject(jsonString);
		JSONObject disambiguation = json.getJSONObject("disambiguation");
		boolean isDisambiguated = disambiguation.getBoolean("is_disambiguated");
		LinkedHashMap<String, String> dslData = new LinkedHashMap<String, String>();
		dslData.put("Disambiguated", Boolean.toString(isDisambiguated));
		
		if(isDisambiguated){
			String currentExam = json.getString("current_exam");
			dslData.put("Current Exam", EmbibeUtils.examsMap.get(currentExam));
			JSONArray validExamsArray = json.getJSONArray("valid_exams");
			ArrayList<String> exams = new ArrayList<String>();
			for(int i=0;i<validExamsArray.length();i++){
				exams.add(EmbibeUtils.examsMap.get(validExamsArray.getString(i)));
			}
			String validExams = String.join(",", exams);
			dslData.put("Valid Exams", validExams);
			dslData.put("Target Page", "Search Results Page");
			String autofill = disambiguation.getString("autofill");
			dslData.put("Dsl Result", autofill);
			JSONArray results = json.getJSONArray("results");
			int length = 0;
			if(results.length()>=maxLength)
				length = maxLength;
			else
				length = results.length();
			for(int i =0;i<length;i++){
				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
				JSONObject result = results.getJSONObject(i);
				String widgetType = result.getString("widget");
				String widgetName = result.getString("name");
				String widgetIndex = result.getString("index");
//				String widgetValue = "";
				if(!widgetType.equalsIgnoreCase("pack-reco")){
//					if(widgetType.equalsIgnoreCase("chapter-concepts") || 
//							widgetType.equalsIgnoreCase("curated-videos")
//							|| widgetType.equalsIgnoreCase("unit-chapters")
//							|| widgetType.equalsIgnoreCase("subject-chapters")){
//						JSONArray concepts = result.getJSONArray("actionables");
//						for(int j=0;j<3;j++){
//							try {
//								JSONObject concept = concepts.getJSONObject(j);
//								String conceptName = concept.getString("name");
//								if(widgetValue.length()==0)
//									widgetValue = conceptName;
//								else
//									widgetValue = widgetValue + "+" + conceptName;
//							} catch (Exception e) {}
//						}
//					}
//					else if(widgetType.equalsIgnoreCase("chapter-tests")){
//						JSONArray actionables = result.getJSONArray("actionables");
//						for(int j=0;j<actionables.length();j++){
//							JSONArray tests = actionables.getJSONObject(j).getJSONArray("tests");
//							for(int n=0;n<tests.length();n++){
//								JSONObject test = tests.getJSONObject(n);
//								String xpath = test.getString("xpath");
//								if(widgetValue.length()==0)
//									widgetValue = xpath;
//								else
//									widgetValue = widgetValue + "+" + xpath;
//							}
//						}
//						
//					}
					String widget = widgetType+"="+widgetName+"="+widgetIndex;
//					if(widgetValue.length()!=0)
//						widget = widget+","+widgetValue;
					if(widgets.length()==0)
						widgets = widget;
					else
						widgets = widgets + "\n" + widget;
				}
				
			}
			dslData.put("Dsl Widgets", widgets);
		}else{
			dslData.put("Target Page", "Search Home Page");
			JSONArray suggestions = json.getJSONArray("suggestions");
			int len = 0;
			if(suggestions.length()<12)
				len = suggestions.length();
			else
				len = 12;
			String searchResultText = "";
			for(int i=0;i<len;i++){
				String name = suggestions.getJSONObject(i).getString("name");
				if(searchResultText.length()==0)
					searchResultText = name;
				else
					searchResultText = searchResultText + "\n" + name;
			}
			dslData.put("Dsl Result", searchResultText);
		}
//		widgetList.add(dslData);
		return dslData;
	}
	
	public static void printJsonObject(JSONObject json) throws JSONException {
		Iterator<?> keys = json.keys();
		while( keys.hasNext() ) {
		    String key = (String) keys.next();
		    Object value = json.get(key);
		    System.out.println(key+" : "+value);
		    if ( value instanceof JSONObject ) {
		    	printJsonObject(new JSONObject(json.get(key)));
		    }
		}
	}
	
	public static void writeDslActualData(String sheetName, LinkedHashMap<String, String> resultData, int row) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream fis = new FileInputStream("./test-data/GlobalSearchTestCases.xlsx");
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
		FileOutputStream fos = new FileOutputStream("./test-data/GlobalSearchTestCases.xlsx");
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	
	public static String[][] readDslUniqueValues(String sheetName) throws EncryptedDocumentException, InvalidFormatException, IOException{
		FileInputStream file = new FileInputStream("./test-data/GlobalSearchTestCases.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		int noOfRows = sheet.getLastRowNum(); 
		String[][] values = new String[noOfRows][2];
		for(int i=1;i<=noOfRows;i++) {
			Row record = sheet.getRow(i);
			try {
				values[i-1][0] = Integer.toString(i-1);
				values[i-1][1] = record.getCell(0).toString().trim();
			} catch (Exception e) {
				values[i-1][0] = Integer.toString(i-1);
				values[i-1][1] = record.getCell(0).getStringCellValue();
			}
		}
		wb.close();
		file.close();
		return values;
	}
	
}
