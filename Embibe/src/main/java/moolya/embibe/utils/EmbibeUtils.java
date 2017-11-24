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
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
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
		put("gl1","10th Foundation");put("gl2","9th Foundation");put("gl9","Medical");
		put("gl3","8th Foundation");put("gl6","Banking & Clerical");put("gl8","Engineering");
	}};

	public static ArrayList<LinkedHashMap<String,String>> getEventLogs(WebDriver wdriver, String className){
		String text = "";
		ArrayList<LinkedHashMap<String, String>> events = new ArrayList<LinkedHashMap<String,String>>();
		LogEntries logEntries = wdriver.manage().logs().get(LogType.PERFORMANCE);
		String[] mandatoryParams = {"log_type","event_name","event_type","intent_to_pay","nav_element"};
		String[] extraParams = {"embium_count","email_id","type","capture_goal_name","credentials",
				"content-id","content-type","content_id","content_name","query","content_type",
				"content_position","search_query","exam_selected","goal","country_code",
				"exam_name","widget_position","widget_cta","widget_type","xpath","pack_id",
				"pack_name","scroll_location","capture_element_type","position_x","position_y","mouse_over_element","mouse_over_text"};
		for (Iterator<LogEntry> it = logEntries.iterator(); it.hasNext();)
		{
			//			boolean flag = false;
			LogEntry entry = it.next();
			try {
				//				JSONObject json = new JSONObject(entry.getMessage());
				//				JSONObject message = json.getJSONObject("message");
				//				JSONObject params = message.getJSONObject("params");
				JSONObject request = new JSONObject(entry.getMessage())
						.getJSONObject("message")
						.getJSONObject("params")
						.getJSONObject("request");
				if(request.getString("url").equals("https://api.segment.io/v1/t")){
					//					flag = false;
					LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
					String postData = request.getString("postData");
					JSONObject postDataJson = new JSONObject(postData);
					JSONObject properties = postDataJson.getJSONObject("properties");
					String messageId = postDataJson.getString("messageId");
					String userId = postDataJson.getString("userId");
					try {
						/*for(LinkedHashMap<String, String> m:events){
							if(m.get("event_code").equals(properties.getString("event_code"))){
								flag = true;
								break;
							}

						}
						if(flag)
							continue;*/
						map.put("userId", userId);
						map.put("messageId", messageId);
						map.put("className", className);
						map.put("event_code", properties.getString("event_code"));
					} catch (Exception e1) {}
					for(String s:mandatoryParams){
						try {
							map.put(s, properties.getString(s));
						} catch (Exception e1) {
							continue;
						}
					}
					for(String s:extraParams){
						try {
							JSONObject obj = properties.getJSONObject("extra_params");
							map.put(s, obj.getString(s));
						} catch (Exception e) {
							continue;
						}

					}	
					//					if(flag)
					//						continue;
					events.add(map);
				}
			} catch (Exception e1) {}
		}
		return events;
	}

	public ArrayList<LinkedHashMap<String,String>> getEventData(String sheetName) throws IOException, EncryptedDocumentException, InvalidFormatException{
		ArrayList<LinkedHashMap<String, String>> e_events = new ArrayList<LinkedHashMap<String, String>>();
		LinkedHashMap<String, String> map = null;
		FileInputStream file = new FileInputStream("./test-data/SegmentIoData.xlsx");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetName);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		while(it.hasNext()) {
			map = new LinkedHashMap<String, String>();
			Row record = it.next();
			String cellPageValue = record.getCell(0).toString();
			String cellValue = record.getCell(1).toString();
			for(int i=0;i<headers.getLastCellNum();i++){
				String value = null;
				String key = null;
				if(headers.getCell(i).toString().trim().equals("event_code")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "event_code";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "event_code";
						}
					}catch(Exception e){
						continue;
					}
				}
				else if(headers.getCell(i).toString().trim().equals("e_log_type")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "log_type";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "log_type";
						}
					}catch(Exception e){
						continue;
					}
				}
				else if(headers.getCell(i).toString().trim().equals("e_event_name")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "event_name";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "event_name";
						}
					}catch(Exception e){
						continue;
					}
				}
				else if(headers.getCell(i).toString().trim().equals("e_nav_element")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "nav_element";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "nav_element";
						}
					}catch(Exception e){
						continue;
					}
				}
				else if(headers.getCell(i).toString().trim().equals("e_event_type")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "event_type";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "event_type";
						}
					}catch(Exception e){
						continue;
					}
				}
				else if(headers.getCell(i).toString().trim().equals("e_intent_to_pay")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "intent_to_pay";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "intent_to_pay";
						}
					}catch(Exception e){
						continue;
					}
				}
				else if(headers.getCell(i).toString().trim().equals("e_extra_params")){
					try{
						try {
							value = record.getCell(i).toString().trim();
							key = "extra_params";
						} catch (Exception e) {
							value = record.getCell(i).getStringCellValue();
							key = "extra_params";
						}
					}catch(Exception e){
						continue;
					}
				}
				if(key!=null)
					map.put(key, value);
			}
			e_events.add(map);
		}
		wb.close();
		file.close();
		return e_events;
	}

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
		JSONObject dym = json.getJSONObject("dym");
		boolean isDymValid = dym.getBoolean("valid");
		dslData.put("Dym", Boolean.toString(isDymValid));
		if(isDymValid)
			dslData.put("Dym Type", dym.getString("type"));
		if(isDisambiguated && !isDymValid){
			String currentExam = json.getString("current_exam");
			dslData.put("Dsl Current Exam", EmbibeUtils.examsMap.get(currentExam));
			String currentGoal = json.getString("current_goal");
			dslData.put("Dsl Current Goal", EmbibeUtils.examsMap.get(currentGoal));
			JSONArray validGoalsArray = json.getJSONArray("valid_goals");
			ArrayList<String> goals = new ArrayList<String>();
			for(int i=0;i<validGoalsArray.length();i++){
				goals.add(EmbibeUtils.examsMap.get(validGoalsArray.getString(i)));
			}
			String validGoals = String.join("\n", goals);
			dslData.put("Dsl Valid Goals", validGoals);
			JSONArray validExamsArray = json.getJSONArray("valid_exams");
			ArrayList<String> exams = new ArrayList<String>();
			for(int i=0;i<validExamsArray.length();i++){
				exams.add(EmbibeUtils.examsMap.get(validExamsArray.getString(i)));
			}
			String validExams = String.join("\n", exams);
			dslData.put("Dsl Valid Exams", validExams);
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
				String widgetType = result.getString("widget").replaceAll("&amp;amp;", "&").replaceAll("&amp;#39;", "'");
				String widgetName = result.getString("name").replaceAll("&amp;amp;", "&").replaceAll("&amp;#39;", "'");
				String widgetIndex = result.getString("index").replaceAll("&amp;amp;", "&").replaceAll("&amp;#39;", "'");
				if(!widgetType.equalsIgnoreCase("pack-reco") && !widgetType.equalsIgnoreCase("ask-box")){
					String widget = widgetType+"="+widgetName+"="+widgetIndex;
					if(widgets.length()==0)
						widgets = widget;
					else
						widgets = widgets + "\n" + widget;
				}

			}
			dslData.put("Dsl Widgets", widgets);
		}else{ 
			if(!isDisambiguated && isDymValid){
				JSONArray dymTerms = dym.getJSONArray("terms");
				ArrayList<String> termsArr = new ArrayList<String>();
				for(int i=0;i<dymTerms.length();i++){
					termsArr.add(dymTerms.getString(i).replaceAll("&amp;amp;", "&").replaceAll("&amp;#39;", "'"));
				}
				String terms = String.join("\n", termsArr);
				dslData.put("Dsl Dym Terms", terms);
				dslData.put("Target Page", "Search Results Page");
			}else{
				dslData.put("Target Page", "Search Home Page");
			}
			JSONArray suggestions = json.getJSONArray("suggestions");
			int len = 0;
			if(suggestions.length()<12)
				len = suggestions.length();
			else
				len = 12;
			String searchResultText = "";
			for(int i=0;i<len;i++){
				String name = suggestions.getJSONObject(i).getString("name").replaceAll("&amp;amp;", "&").replaceAll("&amp;#39;", "'");
				if(searchResultText.length()==0)
					searchResultText = name;
				else
					searchResultText = searchResultText + "\n" + name;
			}
			dslData.put("Dsl Result", searchResultText);
		}
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

	public static LinkedHashMap<String, String> readDslExcelData(String sheetname,int row) throws EncryptedDocumentException, InvalidFormatException, IOException {
		LinkedHashMap<String,String> dataMap = null;
		String key, value = null;
		FileInputStream file = new FileInputStream("./test-data/GlobalSearchTestCases.xlsx");
		dataMap = new LinkedHashMap<String, String>();
		Workbook wb = WorkbookFactory.create(file);
		Sheet sheet = wb.getSheet(sheetname);
		Iterator<Row> it = sheet.rowIterator();

		Row headers = it.next();
		Row record  = sheet.getRow(row);
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

		return dataMap;
	}

}
