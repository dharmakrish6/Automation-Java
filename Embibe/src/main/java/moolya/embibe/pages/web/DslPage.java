package moolya.embibe.pages.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.json.JSONException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import moolya.embibe.utils.EmbibeUtils;
import moolya.embibe.utils.JavaUtils;

public class DslPage extends W_BasePage {

	public DslPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="query")
	private WebElement query_TB;
	
	@FindBy(name="stream")
	private WebElement stream_TB;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit_Btn;
	
	@FindBy(tagName="body")
	private WebElement resultBody;
	
	public LinkedHashMap<String, String> getSearchQueryJson(String query, String goalCode, String examCode, int maxLength) throws IOException, JSONException{
		query = query.trim().replaceAll(" ", "+");
		wdriver.navigate().to(JavaUtils.getPropValue("dslUrl")+"?query="+query);
		String url = wdriver.getCurrentUrl();
		if(!goalCode.equalsIgnoreCase("na"))
			url = url+"&goal_code="+goalCode;
		if(!examCode.equalsIgnoreCase("na"))
			url = url+"&exam_code="+examCode;
		url = url+"&consumer=tech";
		wdriver.navigate().to(url);
		String pagesource = wdriver.getPageSource();
		pagesource = pagesource.replace("<html xmlns=\"http://www.w3.org/1999/xhtml\"><head></head><body>", "");
		pagesource = pagesource.replace("</body></html>", "");
		pagesource = pagesource.replace("<pre style=\"word-wrap: break-word; white-space: pre-wrap;\">", "");
		pagesource = pagesource.replace("</pre>", "");
//		String response = EmbibeUtils.getDslResponse(query);
//		JavaUtils.writeResultsToFile("dslResults.txt", pagesource);
		LinkedHashMap<String,String> results = EmbibeUtils.getResultsFromJson(pagesource, maxLength);
		return results;
	}
	
	public LinkedHashMap<String,String> searchQuery(String query,String stream) throws InterruptedException{
		LinkedHashMap<String, String> dslData = new LinkedHashMap<String, String>();
		waitUntilElementAppears(query_TB);
		query_TB.clear();
		query_TB.sendKeys(query);
		if(!stream.equalsIgnoreCase("na")){
			stream_TB.clear();
			stream_TB.sendKeys(stream);
		}
		waitUntilElementclickable(submit_Btn);
		submit_Btn.click();
		String resultText = null;
		String[] resultTextLines1 = null;
		boolean flag = true;
		int c=0;
		while(c<10){
			try{
			resultText = resultBody.getText();
			resultTextLines1 = resultText.split("\n");
			if(resultTextLines1.length>4)
				c=10;
			}catch(Exception e){}
			Thread.sleep(500);
			c++;
		}
		String[] finalResult;
		boolean disambiguated = Boolean.parseBoolean(resultTextLines1[1].split(" ")[1].trim());
		String searchResultText = ""; 
		dslData.put("Disambiguated", Boolean.toString(disambiguated));
		if(disambiguated){
			searchResultText = resultTextLines1[2].split(":")[1].trim();
			try{
				searchResultText = searchResultText + ":" + resultTextLines1[2].split(":")[2].trim();
			}catch(Exception e){}
			dslData.put("Target Page", "Search Results Page");
		}
		else{
			dslData.put("Target Page", "Search Home Page");
			int n=0;
			for(int i=0;i<resultTextLines1.length;i++){
				if(resultTextLines1[i].toLowerCase().contains("suggestions")){
					n = i+1;
					break;
				}
			}
			if(resultTextLines1.length-n<12){
				finalResult = new String[resultTextLines1.length-n];
				for(int i=n;i<resultTextLines1.length;i++)
					finalResult[i-n] = resultTextLines1[i];
			}
			else{
				finalResult = new String[12];
				for(int i=n;i<n+12;i++)
					finalResult[i-n] = resultTextLines1[i];
			}
			int count = 0;
			for(String res:finalResult){
				if(count==0)
					searchResultText = res;
				else
					searchResultText = searchResultText + "," + res;
				count++;
			}
		}
		dslData.put("Dsl Result", searchResultText);
		return dslData;
	}

}
