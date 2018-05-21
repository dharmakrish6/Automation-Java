package vox.web.apis;

import org.json.JSONObject;

import com.jayway.restassured.response.Response;

public class UserAPIs {

	static JSONObject jsonParams = new JSONObject();

	public static JSONObject getPhoneNumber(String inputs) {

		switch (inputs) {
		case "VALID":
			jsonParams.put("phone", "+919035653629");

			break;
		case "INVALID":
			jsonParams.put("phone", "w@$%sdfg2345");
			break;
		default:
			break;
		}

		return jsonParams;

	}

	public static JSONObject getAccessToken(String verficationCode) {

		switch (verficationCode) {
		case "VALID":
			jsonParams.put("phone", "+919035653629");
			jsonParams.put("verificationCode", "111111");
			break;
		case "INVALID":
			jsonParams.put("phone", "+919035653629");
			jsonParams.put("verificationCode", "123456");
			break;

		default:
			break;
		}
		return jsonParams;

	}

	public static JSONObject updateUserProfile() {
		jsonParams.put("displayName", "Kushal Kumar");
		jsonParams.put("blurb", "I m a VoxWeb User");
		jsonParams.put("status", "Loving VoxWeb");
		jsonParams
				.put("image",
						"http://d30gooj6oi9wav.cloudfront.net/Images/78bac1446e1a3f093f19d9d3702156d7-PRI-20150518-1356797.jpg");
		jsonParams
				.put("thumbnail",
						"http://d30gooj6oi9wav.cloudfront.net/Images/78bac1446e1a3f093f19d9d3702156d7-thumb_PRI-20150518-1356855.jpg");
		return jsonParams;
	}

	public static JSONObject getUserId(String userId) {

		jsonParams.put("userId", userId);
		return jsonParams;

	}

	public static String getValues(String jsonRespone, String key) {
		JSONObject jsonObject = new JSONObject(jsonRespone);
		return jsonObject.get(key).toString();

	}

	public static void printOutput(String apiName, Response resposne) {
		System.out.println(apiName.replaceAll("/", " ") + " :");
		
		resposne.prettyPrint();
	}

}
