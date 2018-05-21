package Moolya.CashE.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.poi.ss.usermodel.Row;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.internal.IResultListener;
import org.testng.xml.XmlSuite;

import com.relevantcodes.extentreports.LogStatus;

import Moolya.CashE.pages.BasePage;

public class TestNGEventHandler implements ITestListener,ISuiteListener,IResultListener,IExecutionListener,IReporter{

	String dir = System.getProperty("user.dir");

	public void onFinish(ITestContext result) {
		System.out.println("on finish of test " + result.getName());

	}
	
	public void onStart(ITestContext result) {
		Reporter.log("Entered the value to the element '" + result.getName() + "'", true);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage " + result.getName());
	}

	public void onTestFailure(ITestResult result) 
	{
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		
		BasePage bp=new BasePage(null);
		Row ids=bp.readExcel("sheet1", clsName, 1);

		Reporter.log("Test with ID's : "+ids.getCell(2).getStringCellValue() +" failed..!");
		
	}

	public void onTestSkipped(ITestResult result) {
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		
		BasePage bp=new BasePage(null);
		Row ids=bp.readExcel("sheet1", clsName, 1);
		
		Reporter.log("Test with ID's : "+ids.getCell(2).getStringCellValue() +" skipped..!",true);
	}

	public void onTestStart(ITestResult result) {
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		
		Reporter.log(clsName+" initiated..!",true);
	}

	public void onTestSuccess(ITestResult result) {
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		
		BasePage bp=new BasePage(null);
		Row ids=bp.readExcel("sheet1", clsName, 1);
		
		Reporter.log("Test with ID's : "+ids.getCell(2).getStringCellValue() +" passed..!",true);
	}
	

	@SuppressWarnings("unused")
	private String getTestMethodName(ITestResult result)
	{
		return result.getMethod().getConstructorOrMethod().getName();
		
	}

	public void onConfigurationFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationSkip(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onConfigurationSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void generateReport(List<XmlSuite> arg0, List<ISuite> arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	public void onExecutionFinish() {
		// TODO Auto-generated method stub
		
	}

	public void onExecutionStart() {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

}
