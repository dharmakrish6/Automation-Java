package moolya.embibe.pages.web;

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
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submit_Btn;
	
	@FindBy(tagName="body")
	private WebElement resultBody;
	
	public void searchQuery(String query) throws InterruptedException{
		waitUntilElementAppears(query_TB);
		query_TB.clear();
		query_TB.sendKeys(query);
		waitUntilElementclickable(submit_Btn);
		submit_Btn.click();
		Thread.sleep(5000);
		String resultText = resultBody.getText(); 
		String[] resultTextLines1 = resultText.split("\n");
		String[] finalResult = new String[resultTextLines1.length-3];
		for(int i=3;i<resultTextLines1.length;i++)
			finalResult[i-3] = resultTextLines1[i];
		System.out.println("Disambiguated: "+resultTextLines1[1].split(" ")[1]);
//		System.out.println(resultTextLines1.length-3);
//		for(String res:finalResult)
//			System.out.println(res);
	}

}
