package moolya.apiTesting.methods;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.path.json.JsonPath.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;

import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

import moolya.apiTesting.utils.CommonUtils;
import moolya.apiTesting.utils.VelocityUtils;

public class ApiMethods {
	
	public static RequestSpecification createRequestSpecification(String sheetName,String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Map<String, String> apiData=CommonUtils.readExcelData(sheetName, uniqueValue);
		String baseURL=apiData.get("Base URL")+apiData.get("API path");
		String[] paramKeys;
		String[] paramValues;
		Map<String, String> params;
		Map<String, String> headers;
		RequestSpecification rs = given();
		if(apiData.get("Params?").equalsIgnoreCase("yes")){
			paramKeys=apiData.get("Param keys").split(" ");
			paramValues=apiData.get("Param Values").split(" ");
			params=CommonUtils.createParamsMap(paramKeys, paramValues);
			rs=rs.queryParams(params);
		}
		if(apiData.get("Authorization?").equalsIgnoreCase("yes")){
			String authType = apiData.get("Authorization Type");
			// to be implemented
		}
		
		if(apiData.get("Headers?").equalsIgnoreCase("yes")){
			String[] headerKeys = apiData.get("Header Keys").split(",");
			String[] headerValues = apiData.get("Header Values").split(",");
			headers = CommonUtils.createParamsMap(headerKeys, headerValues);
			rs = rs.headers(headers);
		}
		
		if(apiData.get("Body?").equalsIgnoreCase("yes")){
			if(apiData.get("Body Type").equalsIgnoreCase("json")){
				rs = rs.contentType("application/json");
				String jsonFilePath = "./test-data/jsons"+apiData.get("JSON Body File Name");
				String[] jsonKeys = apiData.get("JSON Keys").split(",");
				String[] jsonValues = apiData.get("JSON Values").split(",");
				Map<String, String> jsonMap = CommonUtils.createParamsMap(jsonKeys, jsonValues);
				String jsonBody = VelocityUtils.getJsonFromVelocity(jsonFilePath, jsonMap);
				rs=rs.body(jsonBody);
			}
			else if(apiData.get("Body Type").equalsIgnoreCase("x-www-form-urlencoded")){
				//to be implemented
				rs = rs.contentType("application/x-www-form-urlencoded");
				String[] urlEncodedBodyKeys = apiData.get("Body Keys").split(",");
				String[] urlEncodedBodyValues = apiData.get("Body Values").split(",");
				Map<String, String> urlEncodedBodyMap = CommonUtils.createParamsMap(urlEncodedBodyKeys, urlEncodedBodyValues);
				rs = rs.formParameters(urlEncodedBodyMap);
			}
		}
		return rs;
	}
	
	
	public static RequestSpecification addParametersToRequest(RequestSpecification rs,Map<String,String> params){
		rs=rs.queryParams(params);
		return rs;
	}
	
	public static RequestSpecification addHeadersToRequest(RequestSpecification rs,Map<String,String> headers){
		rs = rs.headers(headers);
		return rs;
	}
	
	
	
	public static String sendApiRequest(String sheetName,String uniqueValue,RequestSpecification rs) throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Response response = null;
		Map<String, String> apiData=CommonUtils.readExcelData(sheetName, uniqueValue);
		String baseURL=apiData.get("Base URL")+apiData.get("API path");
		String methodType = apiData.get("Http Method Type");
		switch(methodType){
			case "POST"		:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().post(baseURL);
								
								break;
			case "GET"		:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().get(baseURL);
								break;
			case "DELETE"	:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().delete(baseURL);
								break;
			case "PUT"		:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().put(baseURL);
								break;
			default			:	System.out.println(baseURL);
								System.out.println("Invalid HTTP Method Type: "+methodType);
								break;
		}
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode==200||statusCode==201,"Response Failure!!! --> Status Code: "+statusCode);
			System.out.println("Response Sucess!!! --> Status Code: "+statusCode);
		String stringResponse=response.asString();
		System.out.println("Response --> "+stringResponse);
		return stringResponse;
	}
	
public static String sendApiRequest(String sheetName,String uniqueValue,RequestSpecification rs,String taskId) throws IOException, EncryptedDocumentException, InvalidFormatException{
		
		Response response = null;
		Map<String, String> apiData=CommonUtils.readExcelData(sheetName, uniqueValue);
		String baseURL=apiData.get("Base URL")+apiData.get("API path")+taskId;
		String methodType = apiData.get("Http Method Type");
		switch(methodType){
			case "POST"		:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().post(baseURL);
								break;
			case "GET"		:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().get(baseURL);
								break;
			case "DELETE"	:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().delete(baseURL);
								break;
			case "PUT"		:	System.out.println(methodType+" --> "+baseURL);
								response = rs.when().put(baseURL);
								break;
			default			:	System.out.println(baseURL);
								System.out.println("Invalid HTTP Method Type: "+methodType);
								break;
		}
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode==200||statusCode==201,"Response Failure!!! --> Status Code: "+statusCode);
			System.out.println("Response Sucess!!! --> Status Code: "+statusCode);
		String stringResponse=response.asString();
		System.out.println("Response --> "+stringResponse);
		return stringResponse;
	}
	
	public static String convertResponseToString(Response response){
		String stringResponse=response.asString();
		return stringResponse;
	}
	
	public static Response getJSONResponseWithParameters(Map<String,String> params,String apiUri){
		Response response=given().queryParams(params).when().get(apiUri);
		return response;
	}
	
	public static Response getJSONResponseWithoutParameters(String apiUri){
		Response response=get(apiUri);
		return response;
	}
	
	public static String getJSONObjectValue(String stringResponse, String objectPath){
		String string;
		try{
			string=from(stringResponse).get(objectPath);
		}catch(Exception e){
			string=String.valueOf(from(stringResponse).get(objectPath));
		}
		return string;
	}
	
	public static void assertJSONResponseObjects(String stringResponse, String sheetName, String uniqueValue) throws EncryptedDocumentException, InvalidFormatException, IOException{
		Map<String, String> apiData=CommonUtils.readExcelData(sheetName, uniqueValue);
		String[] object = apiData.get("JSON Object Name").split(",");
		String[] objectPath = apiData.get("JSON Object Paths").split(",");
		String[] objectValue = apiData.get("JSON Object Values").split(",");
		for(int i=0;i<objectPath.length;i++){
			String value=getJSONObjectValue(stringResponse, objectPath[i]);
			Assert.assertEquals(value, objectValue[i]);
			System.out.println("Asserted "+object[i]+": "+value);
		}
	}

}
