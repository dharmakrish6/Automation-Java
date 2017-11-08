package moolya.embibe.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;




public class EmbibeUtils {
	
	public static LinkedHashMap<String,String> getResultsFromJson(String jsonString,int maxLength) throws JSONException{
//		ArrayList<LinkedHashMap<String, String>> widgetList = new ArrayList<LinkedHashMap<String, String>>();
		String widgets = "";
		JSONObject json = new JSONObject(jsonString);
		JSONObject disambiguation = json.getJSONObject("disambiguation");
		boolean isDisambiguated = disambiguation.getBoolean("is_disambiguated");
		LinkedHashMap<String, String> dslData = new LinkedHashMap<String, String>();
		dslData.put("Disambiguated", Boolean.toString(isDisambiguated));
		if(isDisambiguated){
			dslData.put("Target Page", "Search Results Page");
			String autofill = disambiguation.getString("autofill");
			dslData.put("Dsl Result", autofill);
			JSONArray results = json.getJSONArray("results");
			int length = 0;
			if(results.length()>=maxLength)
				length = maxLength;
			else
				length = results.length();
			for(int i =0;i<length;i++){
				LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
				JSONObject result = results.getJSONObject(i);
				String widgetType = result.getString("widget");
				String widgetName = result.getString("name");
				String widgetValue = "";
				if(!widgetType.equalsIgnoreCase("pack-reco")){
					if(widgetType.equalsIgnoreCase("chapter-concepts") || 
							widgetType.equalsIgnoreCase("curated-videos")
							|| widgetType.equalsIgnoreCase("unit-chapters")){
						JSONArray concepts = result.getJSONArray("actionables");
						for(int j=0;j<3;j++){
							try {
								JSONObject concept = concepts.getJSONObject(j);
								String conceptName = concept.getString("name");
								if(widgetValue.length()==0)
									widgetValue = conceptName;
								else
									widgetValue = widgetValue + ":" + conceptName;
							} catch (Exception e) {}
						}
					}
					else if(widgetType.equalsIgnoreCase("chapter-tests")){
						JSONArray actionables = result.getJSONArray("actionables");
						for(int j=0;j<actionables.length();j++){
							JSONArray tests = actionables.getJSONObject(j).getJSONArray("tests");
							for(int n=0;n<tests.length();n++){
								JSONObject test = tests.getJSONObject(n);
								String xpath = test.getString("xpath");
								if(widgetValue.length()==0)
									widgetValue = xpath;
								else
									widgetValue = widgetValue + ":" + xpath;
							}
						}
						
					}else if(widgetType.equalsIgnoreCase("curated-videos")){
						JSONArray concepts = result.getJSONArray("actionables");
						for(int j=0;j<3;j++){
							try {
								JSONObject concept = concepts.getJSONObject(j);
								String conceptName = concept.getString("name");
								if(widgetValue.length()==0)
									widgetValue = conceptName;
								else
									widgetValue = widgetValue + ":" + conceptName;
							} catch (Exception e) {}
						}
					}
					String widget = widgetType+"::"+widgetName;
					if(widgetValue.length()!=0)
						widget = widget+"::"+widgetValue;
					if(widgets.length()==0)
						widgets = widget;
					else
						widgets = widgets + "," + widget;
				}
				dslData.put("Dsl Widgets", widgets);
			}
		}else{
			dslData.put("Target Page", "Search Home Page");
			JSONArray suggestions = json.getJSONArray("suggestions");
			int len = 0;
			if(suggestions.length()<12)
				len = suggestions.length();
			else
				len = 12;
			String searchResultText = "";
			for(int i=0;i<len;i++){
				String name = suggestions.getJSONObject(i).getString("name");
				if(searchResultText.length()==0)
					searchResultText = name;
				else
					searchResultText = searchResultText + "," + name;
			}
			dslData.put("Dsl Result", searchResultText);
		}
//		widgetList.add(dslData);
		return dslData;
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
