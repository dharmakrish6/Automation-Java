package vox.web.tests;

import org.junit.BeforeClass;

import vox.web.apis.APIResponse;
import vox.web.apis.ListOfAPIs;
import vox.web.apis.UserAPIs;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;

public class BaseTest {
	@BeforeClass
	public static void setUp() {
		RestAssured.baseURI = "https://staging.voxweb.in/api/v1";

	}

	public Response getAccessTokenResposne() {
		Response resposne2 = APIResponse.getResposne(
				UserAPIs.getPhoneNumber("VALID"),
				ListOfAPIs.GET_VERIFICATION_CODE);
		UserAPIs.printOutput(ListOfAPIs.GET_VERIFICATION_CODE, resposne2);
		Response resposne = APIResponse.getResposne(
				UserAPIs.getAccessToken("VALID"), ListOfAPIs.GET_ACCESS_TOKEN);
		UserAPIs.printOutput(ListOfAPIs.GET_ACCESS_TOKEN, resposne);
		return resposne;
	}
}
