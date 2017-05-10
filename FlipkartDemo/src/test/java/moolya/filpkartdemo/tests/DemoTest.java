package moolya.filpkartdemo.tests;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class DemoTest{

	@Test
	public void demoTest() {

		String dir = System.getProperty("user.dir");
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(dir+"/extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("MyFirstTest", "Sample description");

		// info(details)
		test.info("This step shows usage of info(details)");

		// calling flush writes everything to the log file
		extent.flush();
	}
}
