package moolya.filpkartdemo.tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import moolya.filpkartdemo.pages.W_BasePage;
import moolya.filpkartdemo.utils.ExtentManager;
import moolya.filpkartdemo.utils.JavaUtils;
import moolya.filpkartdemo.utils.ReporterUtils;

public class W_BaseTest2 
{

	private static ExtentReports extent;
	private static ThreadLocal parentTest = new ThreadLocal();
	protected static ThreadLocal test = new ThreadLocal();
	protected WebDriver wdriver;
	protected W_BasePage basepage;

	@BeforeSuite
	public void beforeSuite() {
		extent = ExtentManager.createInstance();
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
		extent.attachReporter(htmlReporter);
	}

	@BeforeClass
	public synchronized void beforeClass() throws IOException {
		ExtentTest parent = extent.createTest(getClass().getSimpleName());
		parentTest.set(parent);
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp();
	}

	@BeforeMethod
	public synchronized void beforeMethod(Method method) {
		ExtentTest child = ((ExtentTest) parentTest.get()).createNode(method.getName());
		test.set(child);
	}

	@AfterMethod
	public synchronized void afterMethod(ITestResult result) throws IOException {
		String dir = System.getProperty("user.dir");
		String[] clsParts = result.getInstanceName().split("\\.");
		String clsName = clsParts[(clsParts.length)-1];
		if (result.getStatus() == ITestResult.FAILURE){
			File scrFile = ((TakesScreenshot)wdriver).getScreenshotAs(OutputType.FILE);
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
			Date date = new Date();
			String strDate = dateFormat.format(date);

			String filePath = dir+"\\screenshots\\"+clsName+"-"+strDate+".png";
			System.out.println(filePath);
			try {
				FileUtils.copyFile(scrFile, new File(filePath));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			MediaEntityModelProvider mediaModel = null;
			try {
				mediaModel = MediaEntityBuilder.createScreenCaptureFromPath(filePath).build();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			((ExtentTest) test.get()).fail(result.getThrowable(),mediaModel);
		}
		else if (result.getStatus() == ITestResult.SKIP)
			((ExtentTest) test.get()).skip(result.getThrowable());
		else
			((ExtentTest) test.get()).pass(result.getMethod().getMethodName()+" passed");

		extent.flush();
		wdriver.get(JavaUtils.getPropValue("appUrl"));
	}
	
	@AfterClass
	public void tearDown(){
		wdriver.close();
	}

}
