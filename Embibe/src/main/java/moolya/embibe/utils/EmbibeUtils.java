package moolya.embibe.utils;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class EmbibeUtils {
	
	public static String getResultsFromJson(String jsonString) throws JSONException{
		String widgets = "";
		JSONObject json = new JSONObject(jsonString);
		JSONObject disambiguation = json.getJSONObject("disambiguation");
		boolean isDisambiguated = disambiguation.getBoolean("is_disambiguated");
		if(isDisambiguated){
			JSONArray results = json.getJSONArray("results");
			int length = 0,maxLength = 10;
			if(results.length()>=maxLength)
				length = maxLength;
			else
				length = results.length();
			for(int i =0;i<length;i++){
				JSONObject result = results.getJSONObject(i);
				String index = result.getString("index");
				String widget = result.getString("widget");
				String name = result.getString("name");
				String seo_subject_name = result.getString("seo_subject_name");
				if(!widget.contains("practice-set")){
					widgets = widgets+"Widget: "+(i+1)+"\n";
					widgets = widgets+"Index: "+index+"\n";
					widgets = widgets+"Widget Name: "+widget+"\n";
					widgets = widgets+"Name: "+name+"\n";
					widgets = widgets+"Seo_Subject_Name: "+seo_subject_name+"\n";
				}
				printJsonObject(result);
			}
		}
		return widgets;
	}
	
	public static void printJsonObject(JSONObject json) throws JSONException {
		Iterator<?> keys = json.keys();
		while( keys.hasNext() ) {
		    String key = (String) keys.next();
		    Object value = json.get(key);
		    System.out.println(key+" : "+value);
		    if ( value instanceof JSONObject ) {
		    	printJsonObject(new JSONObject(json.get(key)));
		    }
		}
	}
	
}
