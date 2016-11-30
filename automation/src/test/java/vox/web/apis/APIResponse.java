package vox.web.apis;

import static com.jayway.restassured.RestAssured.given;

import org.json.JSONObject;
import org.junit.Assert;

import com.jayway.restassured.response.Response;

public class APIResponse {

	public static Response getResposne(JSONObject jsonObject, String apiName) {
		Response response = given()
				.contentType("application/json;charset=utf-8")
				.body(jsonObject.toString()).when().post(apiName);
		Assert.assertEquals(200, response.statusCode());
		return response;
	}

	public static Response getResponseWithAuthentication(JSONObject inputData,
			String apiName, String userId, String password) {
		Response response = given().auth().preemptive().basic(userId, password)
				.contentType("application/json;charset=utf-8")
				.body(inputData.toString()).when().post(apiName);
		Assert.assertEquals(200, response.statusCode());
		return response;


	}

}
