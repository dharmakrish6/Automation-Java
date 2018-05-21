package moolya.embibe.tests.web.functional.landingPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import moolya.embibe.tests.web.W_BaseTest;

public class SinhalAITS extends W_BaseTest {

	@FindBy(css="a.paybutton")
	private WebElement startPracticeBtn ;
	
	@FindBy(xpath="//*[contains(text(),' Test Started')]")
	private WebElement pageHeader;
	
	
}
