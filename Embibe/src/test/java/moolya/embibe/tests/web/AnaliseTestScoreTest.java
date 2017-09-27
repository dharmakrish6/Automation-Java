package moolya.embibe.tests.web;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;

import moolya.embibe.pages.web.EngineeringPage;
import moolya.embibe.pages.web.HomePage;
import moolya.embibe.pages.web.TestPage;

public class AnaliseTestScoreTest extends W_BaseTest {

	private HomePage hp;
	private EngineeringPage ep;
	private TestPage tp;
	private String uniqueValue = "Demo001";

	@Test(invocationCount=10)
	public void analiseTestScoreTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException {
		hp = new HomePage(wdriver);
		ep = hp.clickStartForEngineering();
		tp = ep.clickTestTab();
		tp.selectTest(uniqueValue);
		tp.startTest();
		tp.chooseAnswers();
		tp.finishTest();
		tp.clickNext();
		tp.closeLoginPopUp();
		tp.getTestScore();
	}

}
