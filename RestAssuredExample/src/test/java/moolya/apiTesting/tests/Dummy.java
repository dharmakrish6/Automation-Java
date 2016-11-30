package moolya.apiTesting.tests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.specification.RequestSpecification;

import moolya.apiTesting.methods.ApiMethods;

public class Dummy {

	static RequestSpecification rs;
	static String r;

	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
	
		rs = ApiMethods.createRequestSpecification("API", "getRegions");
		r = ApiMethods.sendApiRequest("API", "getRegions", rs);
		r = r.substring(r.indexOf("=")+1,r.indexOf(";"));
		Map<String, Object> retMap = new Gson().fromJson(r, new TypeToken<HashMap<String, Object>>() {}.getType());
		for(Map.Entry<String, Object> m:retMap.entrySet()){
			System.out.println("Key: "+m.getKey()+" Value: "+m.getValue());
		}
	}

}
