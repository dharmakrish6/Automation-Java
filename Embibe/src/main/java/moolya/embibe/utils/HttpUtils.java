package moolya.embibe.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedHashMap;

public class HttpUtils {
	
	private static final String USER_AGENT = "Mozilla/5.0";

	public static LinkedHashMap<String, String> getRedirectStatusCode(String url) throws MalformedURLException, IOException{
		LinkedHashMap<String, String> urlData = new LinkedHashMap<String, String>();
		HttpURLConnection con = (HttpURLConnection)(new URL( url ).openConnection());
		con.setInstanceFollowRedirects( false );
		con.connect();
		int responseCode = con.getResponseCode();
		String location = con.getHeaderField( "Location" );
		urlData.put("code", String.valueOf(responseCode));
		urlData.put("url", location);
		return urlData;
	}
	
	public static String getHttpResponse(String url) throws IOException{
		HttpURLConnection con = (HttpURLConnection)(new URL( url ).openConnection());
		con.setInstanceFollowRedirects( false );
		con.connect();
		int responseCode = con.getResponseCode();
		if(responseCode==201){
			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
			StringBuilder sb = new StringBuilder();
			String output;
			while ((output = br.readLine()) != null)
			sb.append(output);
			return sb.toString();
		}
		else{
			return "";
		}
	}
	
	public static void sendGET(String url) throws IOException {
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// print result
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

}
