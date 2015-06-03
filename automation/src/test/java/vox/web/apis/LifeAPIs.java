package vox.web.apis;

import org.json.JSONArray;
import org.json.JSONObject;

public class LifeAPIs {
	static JSONObject jsonParams = new JSONObject();

	public static JSONObject getLifePageWithSinglePost(String userId) {

		jsonParams.put("userId", userId);
		jsonParams.put("startPostId", "w32rqwefasdf2r3rawf");
		jsonParams.put("endPostId", "w32rqwefasdf2r3rqas");
		jsonParams.put("postType", 4);
		return jsonParams;

	}

	public static JSONObject updateLifePost() {
		jsonParams.put("postType", 1);
		jsonParams.put("postText",
				"Hi, this message is posted through automation script");
		return jsonParams;
	}

	public static JSONObject deleteLifePost(String postId) {
		return jsonParams.put("postId", postId);

	}

	public static JSONObject getPostId(String postId) {

		jsonParams.put("postId", postId);
		return jsonParams;

	}

	public static String setPostId(String jsonObject) {
		JSONObject jsonObject2 = new JSONObject(jsonObject);
		JSONObject map = jsonObject2.getJSONObject("postObject");
		return map.get("postId").toString();
	}

	public static JSONObject postLike(String postId, String userId) {
		jsonParams.put("postId", postId);
		jsonParams.put("userId", userId);
		return jsonParams;

	}

	public static JSONObject uploadComments(String postId, String userId) {
		jsonParams.put("postId", postId);
		jsonParams.put("userId", userId);
		jsonParams.put("commentText", "Hi this comment from automated script");
		return jsonParams;

	}

	public static boolean isPostIdPresent(String postId, String resposneData) {
		JSONObject jsonObject = new JSONObject(resposneData);
		JSONArray jsonArray = jsonObject.getJSONArray("posts");
		for (int i = 0; i < jsonArray.length(); i++) {
			JSONObject jsonObject2 = jsonArray.getJSONObject(i);
			String string = jsonObject2.get("postId").toString();
			System.out.println(i + " " + string);
			if (string.equals(postId)) {
				return false;
			}
		}
		return true;

	}

}
