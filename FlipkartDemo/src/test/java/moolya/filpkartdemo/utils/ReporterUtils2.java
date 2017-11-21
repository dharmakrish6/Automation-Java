package moolya.filpkartdemo.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.testng.IExecutionListener;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.IResultListener;
import org.testng.xml.XmlSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.ReportConfigurator;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

import moolya.filpkartdemo.pages.W_BasePage;

public class ReporterUtils2 implements ITestListener,ISuiteListener,IResultListener,IExecutionListener,IReporter{

	public ExtentReports extent;
	public ExtentXReporter extentxReporter;
	public static ExtentTest test;
	public ExtentHtmlReporter htmlReporter;
	public ReportConfigurator rc;

	String dir = System.getProperty("user.dir");

	public void onStart(ISuite arg0) {
		
		// initialize the HtmlReporter
		htmlReporter = new ExtentHtmlReporter(dir+"/reports/Extent.html");
		String host="";
		int port=0;
		String project="";
		String report="";
		String nodejsPort="";
		String url="";
		try {
			host = JavaUtils.getPropValue("host");
			port = Integer.parseInt(JavaUtils.getPropValue("port"));
			project = JavaUtils.getPropValue("project");
			report = JavaUtils.getPropValue("report");
			nodejsPort = JavaUtils.getPropValue("nodejsPort");
			url = "http://"+host+":"+nodejsPort;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		extentxReporter = new ExtentXReporter(host, port);
		extentxReporter.config().setProjectName(project);
		extentxReporter.config().setReportName(report);
		extentxReporter.config().setServerUrl(url);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter,extentxReporter);
		
	}

	public void onFinish(ISuite arg0) {

		extent.flush();
		//extent.close();
	}

	public void onStart(ITestContext result) {
	}

	public void onFinish(ITestContext result) {

		//extent.endTest(test);
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage " + result.getName());
	}

	public void onTestStart(ITestResult result) {

		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];

		test = extent.createTest(clsName);
		test.log(Status.INFO, clsName+" initiated..!");
	}

	public void onTestSuccess(ITestResult result) {

		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];

		W_BasePage bp=new W_BasePage(null);
		/*Row ids=bp.readExcel("Execution sheet", clsName, 1);
		try {
			bp.writeexcel("Execution sheet", clsName, "Report", "PASS");
		} catch (Exception e) {

		}
		 */
		test.pass(clsName+" PASS");
	}

	public void onTestFailure(ITestResult result) 
	{
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];

//		W_BasePage bp=new W_BasePage(null);
		/*Row ids=bp.readExcel("Execution sheet", clsName, 1);
		try {
			bp.writeexcel("Execution sheet", clsName, "Report", "FAIL");
		} catch (Exception e) {

		}*/

		test.log(Status.FAIL, clsName +" failed..!");
		
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		String strDate = dateFormat.format(date);
		
		String filePath = dir+"/screenshots/"+strDate+".png";
		System.out.println(filePath);
		File file = new File(filePath);
		try {
			FileUtils.copyFile(file, file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		byte imageData[] = new byte[(int) file.length()];
		try {
			FileInputStream imageInFile = new FileInputStream(file);
			imageInFile.read(imageData);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Converting Image byte array into Base64 String
		String imageDataString = Base64.encodeBase64URLSafeString(imageData);
		MediaEntityModelProvider mediaModel = null;
		try {
			mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(filePath).build();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		test.log(Status.INFO, "<img alt=\"Screenshot\" src=\"data:image/png;base64,"+imageDataString+"\" width=\"500\" height=\"600\"/>");
		test.fail(result.getThrowable());
	}

	public void onTestSkipped(ITestResult result) {

		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];

		W_BasePage bp=new W_BasePage(null);
		test.skip(clsName+"Skipped"+"\n"+result.getThrowable());
	}


	@SuppressWarnings("unused")
	private String getTestMethodName(ITestResult result)
	{
		return result.getMethod().getConstructorOrMethod().getName();

	}

	public void onConfigurationFailure(ITestResult result) {

		//		String[] clsParts = result.getInstanceName().split("\\.");
		//		String clsName = clsParts[(clsParts.length)-1];
		//		test.log(LogStatus.FAIL, "Failed "+clsName+" because of configuration failure..!");
	}

	public void onConfigurationSkip(ITestResult result) {


	}

	public void onConfigurationSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		//		System.out.println("onConfigurationSuccess");
	}

	public void onExecutionFinish() {

		System.out.println("Test Execution Has Been Completed..!");
	}

	public void onExecutionStart() {

		
		System.out.println("Test Execution Has Begun..!");
	}

	public void generateReport(List<XmlSuite> xmlSuites, List<ISuite> suites, String outputDirectory) {
		// TODO Auto-generated method stub
		
	}

}
