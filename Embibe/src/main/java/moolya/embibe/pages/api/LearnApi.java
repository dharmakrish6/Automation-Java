package moolya.embibe.pages.api;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.Reporter;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LearnApi {
	
	private static HashMap<String, String> headers = new HashMap<String, String>(){{
		put("Accept", "application/json, text/plain, */*");put("Origin","https://rearch.embibe.com");
		put("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.84 Safari/537.36");
		put("embibe-token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzUxMiJ9.eyJpZCI6NjM3NTE5NywiZW1haWwiOiJndWVzdF8xNTE0Mzg4OTE4MTMxMTc5QGVtYmliZS5jb20iLCJpc19ndWVzdCI6dHJ1ZSwicm9sZSI6InN0dWRlbnQifQ._QhQYh_L5Bzcg0hT-ZEVRhM6GlmfISKCaOHFV4EPgMDnKp1pEfd60vKKOy0n0NHeb9fbO8Vzrt95aLRqp8UFWg");
		put("Accept-Encoding","gzip, deflate, br");put("Accept-Language","en-US,en;q=0.9");
	}};
	
	private static HashMap<String, String> params = new HashMap<String, String>();
	
	private static final String base_url = "https://staging1ms.embibe.com/content_ms/v1/embibe/en/learn";
	
	public static String getLearnApiResponse(String learn_path, String entity_code){
		RequestSpecification rs = given().relaxedHTTPSValidation();
		params.put("learn_path", learn_path);
		params.put("entity_code", entity_code);
		rs=rs.queryParams(params);
		String referer = "https://rearch.embibe.com/study/"+learn_path+"?entity_code="+entity_code;
		headers.put("Referer", referer);
		rs = rs.headers(headers);
		Response response = rs.when().get(base_url);
		int statusCode = response.getStatusCode();
		Assert.assertTrue(statusCode==200||statusCode==201,"Response Failure!!! --> Status Code: "+statusCode);
		Reporter.log("Response Sucess!!! --> Status Code: "+statusCode, true);
		return response.asString();
	}
	
	public static String getVideosCount(String response) throws JSONException{
		String videoCount = null;
		JSONObject json = new JSONObject(response);
		JSONArray videos = json.getJSONObject("data").getJSONArray("video_data");
		videoCount = String.valueOf(videos.length());
		return videoCount;
	}

}
