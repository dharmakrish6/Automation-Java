package moolya.embibe.pages.web;

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
	
	public boolean checkForLearnPageLoad(){
		boolean flag = false;
		try {
			waitUntilElementAppears(contentsDiv, 15);
			flag = true;
		} catch (Exception e) {}
		return flag;
	}
}
