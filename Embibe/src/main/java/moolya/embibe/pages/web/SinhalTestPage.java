package moolya.embibe.pages.web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.testautomationguru.ocular.snapshot.Snap;

@Snap(value="LandingPage-#{Element}.png")
public class SinhalTestPage extends W_BasePage {

	public SinhalTestPage(WebDriver wdriver) {
		super(wdriver);
		PageFactory.initElements(wdriver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(css="button.instructions__nav-btn")
	private WebElement beginBtn;
	
	@FindBy(xpath="(//button[text()='Finish'])[1]")
	private WebElement finishBtn;
	
	@FindBy(xpath="(//test-question[@question-num='1']//span[text()='A'])[1]")
	private WebElement p_1;
	
	//@FindBy(xpath="(//test-question[@question-num='2']//span[text()='A'])[1]")
	@FindBy(xpath="(//test-question[@question-num='2']//span[text()='B'])[2]")
	private WebElement p_2;
	
	//@FindBy(xpath="(//test-question[@question-num='3']/div//li[2])[1]")
	@FindBy(xpath="(//test-question[@question-num='3']//span[text()='B'])[4]")
	private WebElement p_3;
	
	//@FindBy(xpath="(//test-question[@question-num='4']//span[text()='B'])[1]")
	@FindBy(xpath="(//test-question[@question-num='4']//span[text()='B'])[2]")
	private WebElement p_4;
	
	//@FindBy(xpath="(//test-question[@question-num='5']//span[text()='C'])[1]")
	@FindBy(xpath="(//test-question[@question-num='5']//span[text()='C'])[7]")
	private WebElement p_5;
	
	//@FindBy(xpath="(//test-question[@question-num='6']//span[text()='B'])[1]")
	@FindBy(xpath="(//test-question[@question-num='6']//span[text()='B'])[2]")
	private WebElement p_6;
	
	//@FindBy(xpath="(//test-question[@question-num='7']//span[text()='C'])[1]")
	@FindBy(xpath="(//test-question[@question-num='7']//span[text()='C'])[8]")
	private WebElement p_7;
	
	//@FindBy(xpath="(//test-question[@question-num='8']//span[text()='D'])[1]")
	@FindBy(xpath="(//test-question[@question-num='8']//span[text()='D'])[2]")
	private WebElement p_8;
	
	//@FindBy(xpath="(//test-question[@question-num='9']//span[text()='C'])[1]")
	@FindBy(xpath="(//test-question[@question-num='9']//span[text()='C'])[1]")
	private WebElement p_9;
	
	//@FindBy(xpath="(//test-question[@question-num='10']//span[text()='B'])[1]")
	@FindBy(xpath="(//test-question[@question-num='10']//span[text()='B'])[1]")
	private WebElement p_10;
	
	//@FindBy(xpath="(//test-question[@question-num='11']//span[text()='A'])[1]")
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='A'])[2]")
	private WebElement p_11_a;
	
	//@FindBy(xpath="(//test-question[@question-num='11']//span[text()='C'])[1]")
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='C'])[5]")
	private WebElement p_11_c;
	
	//@FindBy(xpath="(//test-question[@question-num='12']//span[text()='A'])[1]")
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='A'])[3]")
	private WebElement p_12_a;
	
	//@FindBy(xpath="(//test-question[@question-num='12']//span[text()='B'])[1]")
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='B'])[3]")
	private WebElement p_12_b;
	
	//@FindBy(xpath="(//test-question[@question-num='12']//span[text()='D'])[1]")
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='D'])[3]")
	private WebElement p_12_d;
	
	//@FindBy(xpath="(//test-question[@question-num='13']//span[text()='A'])[1]")
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='A'])[3]")
	private WebElement p_13_a;
	
	//@FindBy(xpath="(//test-question[@question-num='13']//span[text()='D'])[1]")
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='D'])[3]")
	private WebElement p_13_d;
	
	//@FindBy(xpath="(//test-question[@question-num='14']//span[text()='B'])[1]")
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='B'])[1]")
	private WebElement p_14_b;
	
	//@FindBy(xpath="(//test-question[@question-num='14']//span[text()='C'])[1]")
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='C'])[1]")
	private WebElement p_14_c;
	
	//@FindBy(xpath="(//test-question[@question-num='15']//span[text()='A'])[1]")
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='A'])[4]")
	private WebElement p_15_a;
	
	//@FindBy(xpath="(//test-question[@question-num='15']//span[text()='B'])[1]")
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='B'])[4]")
	private WebElement p_15_b;
	
	//@FindBy(xpath="(//test-question[@question-num='15']//span[text()='C'])[1]")
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='C'])[8]")
	private WebElement p_15_c;
	
	//@FindBy(xpath="(//test-question[@question-num='15']//span[text()='D'])[1]")
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='D'])[3]")
	private WebElement p_15_d;
	
	//@FindBy(xpath="((//div[@class='integer-option-block'])[1]/div/label)[1]")
	@FindBy(xpath="(//div[@class='integer-option-block'])[2]/div[3]")
	private WebElement p_16;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[4]/div[4]")
	private WebElement p_17;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[9]/div[2]")
	private WebElement p_18;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[11]/div[4]")
	private WebElement p_19;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[14]/div[4]")
	private WebElement p_20;
	
	@FindBy(xpath = "//button[text()='Save']")
	private WebElement saveBtn;
	
	
	public void  goToLink(){
		wdriver.get("https://rearch.embibe.com/engineering/test/jee-advanced/full-test/moc-tift-18-advance-paper-1/paper");
		Reporter.log("Navigated to test paper",true);
	}
	
	public void beginTest(){
		clickElement(beginBtn);
	}
	
	public void finishTest(){
		clickElement(finishBtn);
	}
	
	public void moc_tift_18_advance_paper_1_Physics() throws InterruptedException{
		Thread.sleep(5000);
		System.out.println(p_1.isDisplayed());
		p_1.click();
		Reporter.log("Clicked on  1st Question option",true);
		saveBtn.click();
	    scrollToElementViaJavascript(p_2);
	    Thread.sleep(1000);
		p_2.click();
		saveBtn.click();
		Thread.sleep(1000);
		System.out.println(p_3.isDisplayed());
		p_3.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_4.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_5.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_6.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_7.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_8.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_9.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_10.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_11_a.click();
		p_11_c.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_12_a.click();
		p_12_b.click();
		p_12_d.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_13_a.click();
		p_13_d.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_14_b.click();
		p_14_c.click();
		saveBtn.click();
		Thread.sleep(1000);
		p_15_a.click();
		p_15_b.click();
		p_15_c.click();
		p_15_d.click();
		saveBtn.click();
		Thread.sleep(1000);
		scrollToElementViaJavascript(p_16);
		p_16.click();
		saveBtn.click();
		Thread.sleep(1000);
		scrollToElementViaJavascript(p_17);
		p_17.click();
		saveBtn.click();
		Thread.sleep(1000);
		scrollToElementViaJavascript(p_18);
		p_18.click();
		saveBtn.click();
		Thread.sleep(1000);
		scrollToElementViaJavascript(p_19);
		p_19.click();
		saveBtn.click();
		Thread.sleep(1000);
		scrollToElementViaJavascript(p_20);
		p_20.click();
		saveBtn.click();
		Thread.sleep(1000);
	}
	
	@FindBy(xpath="(//test-question[@question-num='1']//span[text()='A'])[2]")
	private WebElement c_1;
	
	@FindBy(xpath="(//test-question[@question-num='2']//span[text()='B'])[3]")
	private WebElement c_2;
	
	@FindBy(xpath="(//test-question[@question-num='3']//span[text()='C'])[2]")
	private WebElement c_3;
	
	@FindBy(xpath="(//test-question[@question-num='4']//span[text()='C'])[1]")
	private WebElement c_4;
	
	@FindBy(xpath="(//test-question[@question-num='5']//span[text()='A'])[1]")
	private WebElement c_5;
	
	@FindBy(xpath="(//test-question[@question-num='6']//span[text()='C'])[1]")
	private WebElement c_6;
	
	@FindBy(xpath="(//test-question[@question-num='7']//span[text()='A'])[1]")
	private WebElement c_7;
	
	@FindBy(xpath="(//test-question[@question-num='8']//span[text()='D'])[1]")
	private WebElement c_8;
	
	@FindBy(xpath="(//test-question[@question-num='9']//span[text()='B'])[2]")
	private WebElement c_9;
	
	@FindBy(xpath="(//test-question[@question-num='10']//span[text()='D'])[3]")
	private WebElement c_10;
	
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='A'])[1]")
	private WebElement c_11_a;
	
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='B'])[1]")
	private WebElement c_11_b;
	
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='C'])[4]")
	private WebElement c_11_c;
	
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='A'])[2]")
	private WebElement c_12_a;
	
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='B'])[2]")
	private WebElement c_12_b;
	
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='C'])[4]")
	private WebElement c_12_c;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='A'])[2]")
	private WebElement c_13_a;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='B'])[2]")
	private WebElement c_13_b;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='C'])[2]")
	private WebElement c_13_c;
	
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='A'])[3]")
	private WebElement c_14_a;
	
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='B'])[3]")
	private WebElement c_14_b;
	
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='C'])[3]")
	private WebElement c_14_c;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='A'])[3]")
	private WebElement c_15_a;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='B'])[3]")
	private WebElement c_15_b;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='C'])[7]")
	private WebElement c_15_c;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='D'])[2]")
	private WebElement c_15_d;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[3]/div[8]")
	private WebElement c_16;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[6]/div[10]")
	private WebElement c_17;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[7]/div[8]")
	private WebElement c_18;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[10]/div[4]")
	private WebElement c_19;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[13]/div[7]")
	private WebElement c_20;
	
	public void moc_tift_18_advance_paper_1_Chemistry(){
		clickElement(c_1);
		clickElement(saveBtn);
		clickElement(c_2);
		clickElement(saveBtn);
		clickElement(c_3);
		clickElement(saveBtn);
		clickElement(c_4);
		clickElement(saveBtn);
		clickElement(c_5);
		clickElement(saveBtn);
		clickElement(c_6);
		clickElement(saveBtn);
		clickElement(c_7);
		clickElement(saveBtn);
		clickElement(c_8);
		clickElement(saveBtn);
		clickElement(c_9);
		clickElement(saveBtn);
		clickElement(c_10);
		clickElement(saveBtn);
		clickElement(c_11_a);
		clickElement(c_11_b);
		clickElement(c_11_c);
		clickElement(saveBtn);
		scrollToElementViaJavascript(c_12_a);
		//clickElement(c_12_a);
		clickElement(c_12_b);
		clickElement(c_12_c);
		clickElement(saveBtn);
		clickElement(c_13_a);
		clickElement(c_13_b);
		clickElement(c_13_c);
		clickElement(saveBtn);
		clickElement(c_14_a);
		clickElement(c_14_b);
		clickElement(c_14_c);
		clickElement(saveBtn);
		clickElement(c_15_a);
		clickElement(c_15_b);
		clickElement(c_15_c);
		clickElement(c_15_d);
		clickElement(saveBtn);
		clickElement(c_16);
		clickElement(saveBtn);
		clickElement(c_17);
		clickElement(saveBtn);
		clickElement(c_18);
		clickElement(saveBtn);
		clickElement(c_19);
		clickElement(saveBtn);
		clickElement(c_20);
		clickElement(saveBtn);
	}
	
	
	@FindBy(xpath="(//test-question[@question-num='1']//span[text()='C'])[4]")
	private WebElement m_1;
	
	@FindBy(xpath="(//test-question[@question-num='2']//span[text()='C'])[1]")
	private WebElement m_2;
	
	@FindBy(xpath="(//test-question[@question-num='3']//span[text()='A'])[2]")
	private WebElement m_3;
	
	@FindBy(xpath="(//test-question[@question-num='4']//span[text()='D'])[7]")
	private WebElement m_4;
	
	@FindBy(xpath="(//test-question[@question-num='5']//span[text()='D'])[3]")
	private WebElement m_5;
	
	@FindBy(xpath="(//test-question[@question-num='6']//span[text()='A'])[3]")
	private WebElement m_6;
	
	@FindBy(xpath="(//test-question[@question-num='7']//span[text()='C'])[7]")
	private WebElement m_7;
	
	@FindBy(xpath="(//test-question[@question-num='8']//span[text()='D'])[3]")
	private WebElement m_8;
	
	@FindBy(xpath="(//test-question[@question-num='9']//span[text()='D'])[3]")
	private WebElement m_9;
	
	@FindBy(xpath="(//test-question[@question-num='10']//span[text()='A'])[2]")
	private WebElement m_10;
	
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='A'])[3]")
	private WebElement m_11_a;
	
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='B'])[3]")
	private WebElement m_11_b;
	
	@FindBy(xpath="(//test-question[@question-num='11']//span[text()='C'])[6]")
	private WebElement m_11_c;
	
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='B'])[1]")
	private WebElement m_12_b;
	
	@FindBy(xpath="(//test-question[@question-num='12']//span[text()='D'])[1]")
	private WebElement m_12_d;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='A'])[1]")
	private WebElement m_13_a;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='B'])[1]")
	private WebElement m_13_b;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='C'])[1]")
	private WebElement m_13_c;
	
	@FindBy(xpath="(//test-question[@question-num='13']//span[text()='D'])[1]")
	private WebElement m_13_d;
	
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='A'])[2]")
	private WebElement m_14_a;
	
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='C'])[2]")
	private WebElement m_14_c;
	
	@FindBy(xpath="(//test-question[@question-num='14']//span[text()='D'])[2]")
	private WebElement m_14_d;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='A'])[1]")
	private WebElement m_15_a;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='B'])[1]")
	private WebElement m_15_b;
	
	@FindBy(xpath="(//test-question[@question-num='15']//span[text()='C'])[1]")
	private WebElement m_15_c;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[1]/div[3]")
	private WebElement m_16;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[5]/div[3]")
	private WebElement m_17;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[8]/div[4]")
	private WebElement m_18;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[12]/div[2]")
	private WebElement m_19;
	
	@FindBy(xpath="(//div[@class='integer-option-block'])[15]/div[6]")
	private WebElement m_20;
	
	public void moc_tift_18_advance_paper_1_Maths(){
		clickElement(m_1);
		clickElement(saveBtn);
		clickElement(m_2);
		clickElement(saveBtn);
		clickElement(m_3);
		clickElement(saveBtn);
		clickElement(m_4);
		clickElement(saveBtn);
		clickElement(m_5);
		clickElement(saveBtn);
		clickElement(m_6);
		clickElement(saveBtn);
		clickElement(m_7);
		clickElement(saveBtn);
		clickElement(m_8);
		clickElement(saveBtn);
		clickElement(m_9);
		clickElement(saveBtn);
		clickElement(m_10);
		clickElement(saveBtn);
		clickElement(m_11_a);
		clickElement(m_11_b);
		clickElement(m_11_c);
		clickElement(saveBtn);
		clickElement(m_12_b);
		clickElement(m_12_d);
		clickElement(saveBtn);
		clickElement(m_13_a);
		clickElement(m_13_b);
		clickElement(m_13_c);
		clickElement(m_13_d);
		clickElement(saveBtn);
		clickElement(m_14_a);
		clickElement(m_14_c);
		clickElement(m_14_d);
		clickElement(saveBtn);
		clickElement(m_15_a);
		clickElement(m_15_b);
		clickElement(m_15_c);
		clickElement(saveBtn);
		clickElement(m_16);
		clickElement(saveBtn);
		clickElement(m_17);
		clickElement(saveBtn);
		clickElement(m_18);
		clickElement(saveBtn);
		clickElement(m_19);
		clickElement(saveBtn);
		clickElement(m_20);
		clickElement(saveBtn);	
	
	}
	


}
