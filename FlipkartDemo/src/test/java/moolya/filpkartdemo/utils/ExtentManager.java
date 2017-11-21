package moolya.filpkartdemo.utils;

import java.io.IOException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.KlovReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
    
    private static ExtentReports extent;
    
    public static ExtentReports getInstance() {
    	if (extent == null)
    		createInstance();
    	
        return extent;
    }
    
    public static ExtentReports createInstance() {
    	String dir = System.getProperty("user.dir");
    	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(dir+"\\reports\\Extent.html");
    	htmlReporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setEncoding("utf-8");
		String host="";
		int port=0;
		String project="";
		String report="";
		String klovServerPort="";
		String url="";
		try {
			host = JavaUtils.getPropValue("host");
			port = Integer.parseInt(JavaUtils.getPropValue("port"));
			project = JavaUtils.getPropValue("project");
			report = JavaUtils.getPropValue("report");
			klovServerPort = JavaUtils.getPropValue("klovServerPort");
			url = "http://"+host+":"+klovServerPort;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		htmlReporter.config().setDocumentTitle(project);
		htmlReporter.config().setReportName(report);
		
		KlovReporter klov = new KlovReporter();
		klov.initMongoDbConnection(host, port);
		klov.setProjectName(project);
		klov.setReportName(report);
		klov.setKlovUrl("http://"+host+":"+klovServerPort);
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter,klov);
        
        return extent;
    }
}