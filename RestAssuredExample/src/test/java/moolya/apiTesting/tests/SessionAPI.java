package moolya.apiTesting.tests;

import static com.jayway.restassured.path.json.JsonPath.from;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import com.jayway.restassured.specification.RequestSpecification;

import moolya.apiTesting.methods.ApiMethods;

public class SessionAPI {
	
	static private RequestSpecification rs;
	static private String r;
	static String uniqueValue = "SessionAPI";
	static String auth_token;

	
	public static void main(String args[]) throws EncryptedDocumentException, InvalidFormatException, IOException{
		rs = ApiMethods.createRequestSpecification("API", uniqueValue);
		r = ApiMethods.sendApiRequest("API", uniqueValue, rs);
		ApiMethods.assertJSONResponseObjects(r, "API", uniqueValue);
		auth_token = from(r).get("auth_token");
		System.out.println(auth_token);
		//System.out.println(r.getCookies());
	}

}
