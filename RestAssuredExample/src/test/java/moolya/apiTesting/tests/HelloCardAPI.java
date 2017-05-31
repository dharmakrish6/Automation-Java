package moolya.apiTesting.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.jayway.restassured.specification.RequestSpecification;

import moolya.apiTesting.methods.ApiMethods;

public class HelloCardAPI {
	static private RequestSpecification rs;
	static private String r;
	static String uniqueValue = "HelloCardAPI";

	
	public static void main(String args[]) throws EncryptedDocumentException, InvalidFormatException, IOException{
		rs = ApiMethods.createRequestSpecification("API", uniqueValue);
		r = ApiMethods.sendApiRequest("API", uniqueValue, rs);
		ApiMethods.assertJSONResponseObjects(r, "API", uniqueValue);
	}

}
