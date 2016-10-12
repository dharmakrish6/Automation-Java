package moolya.apiTesting.tests;

import static com.jayway.restassured.path.json.JsonPath.from;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jayway.restassured.specification.RequestSpecification;

import moolya.apiTesting.methods.ApiMethods;

public class Sample {

	//@Test
	static RequestSpecification rs;
	static Map<String, String> m = new HashMap<String,String>();
	static String taskId;
	static String r;
	static String apiKey;

	public static void main(String[] args) throws IOException, EncryptedDocumentException, InvalidFormatException{
		//Register User - POST Request Register1
		rs = ApiMethods.createRequestSpecification("API", "Register1");
		r = ApiMethods.sendApiRequest("API", "Register1", rs);
//		ApiMethods.assertJSONResponseObjects(r, "API", "Register1");
		
		//Login - POST request
		rs = ApiMethods.createRequestSpecification("API", "Login1");
		r = ApiMethods.sendApiRequest("API", "Login1", rs);
		ApiMethods.assertJSONResponseObjects(r, "API", "Login1");
		apiKey=from(r).get("apiKey");
		
		m.put("Authorization", apiKey);
		
		//Create Task - POST Request
		rs = ApiMethods.createRequestSpecification("API", "CreateTask1");
		rs = ApiMethods.addHeadersToRequest(rs, m);
		r = ApiMethods.sendApiRequest("API", "CreateTask1", rs);
		ApiMethods.assertJSONResponseObjects(r, "API", "CreateTask1");
		
		//Get Particular Task - GET Request
		taskId = String.valueOf(from(r).get("task_id"));
		rs = ApiMethods.createRequestSpecification("API", "GetTask1");
		rs = ApiMethods.addHeadersToRequest(rs, m);
		r= ApiMethods.sendApiRequest("API", "GetTask1", rs, taskId);
		ApiMethods.assertJSONResponseObjects(r, "API", "GetTask1");
		
		////Get All Tasks - GET Request
		rs = ApiMethods.createRequestSpecification("API", "GetAllTasks1");
		rs = ApiMethods.addHeadersToRequest(rs, m);
		r = ApiMethods.sendApiRequest("API", "GetAllTasks1", rs);
		ApiMethods.assertJSONResponseObjects(r, "API", "GetAllTasks1");
		
		//Update Particular Task - PUT Request
		rs = ApiMethods.createRequestSpecification("API", "UpdateTask1");
		rs = ApiMethods.addHeadersToRequest(rs, m);
		r= ApiMethods.sendApiRequest("API", "UpdateTask1", rs, taskId);
		ApiMethods.assertJSONResponseObjects(r, "API", "UpdateTask1");
		
		//Delete Particular Task - DELETE Request
		rs = ApiMethods.createRequestSpecification("API", "DeleteTask1");
		rs = ApiMethods.addHeadersToRequest(rs, m);
		r= ApiMethods.sendApiRequest("API", "DeleteTask1", rs, taskId);
		ApiMethods.assertJSONResponseObjects(r, "API", "DeleteTask1");
		
	}

}
