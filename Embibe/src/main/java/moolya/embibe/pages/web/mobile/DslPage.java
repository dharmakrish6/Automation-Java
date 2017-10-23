package moolya.embibe.pages.web.mobile;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	public HashMap<String,Object> searchQuery(String query,String stream) throws InterruptedException{
		HashMap<String, Object> dslData = new HashMap<String, Object>();
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
			if(resultTextLines1.length>3)
				c=10;
			}catch(Exception e){}
			Thread.sleep(500);
			c++;
		}
		String[] finalResult;
		boolean disambiguated = Boolean.parseBoolean(resultTextLines1[1].split(" ")[1].trim());
		String searchResultText = ""; 
		for(String res: resultTextLines1)
		dslData.put("Disambiguated", disambiguated);
		if(disambiguated){
			searchResultText = resultTextLines1[2].split(":")[1].trim();
			dslData.put("Target Page", "Search Results Page");
		}
		else{
			dslData.put("Target Page", "Search Home Page");
			if(resultTextLines1.length-3<12){
				finalResult = new String[resultTextLines1.length-3];
				for(int i=3;i<resultTextLines1.length;i++)
					finalResult[i-3] = resultTextLines1[i];
			}
			else{
				finalResult = new String[12];
				for(int i=3;i<15;i++)
					finalResult[i-3] = resultTextLines1[i];
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
