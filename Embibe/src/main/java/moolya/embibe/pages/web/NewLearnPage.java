package moolya.embibe.pages.web;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewLearnPage extends W_BasePage {

	public NewLearnPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css=".wikiHead")
	private WebElement contentsDiv;
	
	@FindBy(xpath="//a[text()='Start Test']")
	private List<WebElement> startTestList;
	
	public boolean checkForLearnPageLoad(){
		boolean flag = false;
		try {
			waitUntilElementAppears(contentsDiv, 15);
			flag = true;
		} catch (Exception e) {}
		return flag;
	}
	
	public LinkedHashMap<String, String> getTestXpaths(){
		LinkedHashMap<String, String> xpathData = new LinkedHashMap<String, String>();
		Set<String> exams = new HashSet<String>();
		String xpaths = "";
		String status = "Tests Not Available";
		waitUntilElementAppears(contentsDiv);
		for(WebElement e: startTestList){
			String xpath = e.getAttribute("href");
			if(xpaths.length()==0)
				xpaths = xpath;
			else
				xpaths = xpaths + "\n" + xpath;
			String exam = xpath.split("/test/")[1].split("/")[0];
			exams.add(exam);
		}
		if(exams.size()==1)
			status = "Pass";
		xpathData.put("Xpaths", xpaths);
		xpathData.put("Status", status);
		return xpathData;
	}
}
