package vox.web.apis;

import org.json.JSONArray;
import org.json.JSONObject;

public class SocialAPIs {
	static JSONObject jsonObject = new JSONObject();

	public static JSONObject updateContats() {
		JSONObject jo = new JSONObject();
		jo.put("phone", "+919876543210");
		JSONArray ja = new JSONArray();
		ja.put(jo);
		JSONObject mainObj = new JSONObject();
		mainObj.put("contacts", ja);
		return mainObj;
	}

	public static JSONObject searchUser() {
		return jsonObject.put("displayName", "Gaurabh");

	}

}
