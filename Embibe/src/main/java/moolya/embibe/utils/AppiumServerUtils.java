package moolya.embibe.utils;

import java.io.IOException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecuteResultHandler;
import org.apache.commons.exec.DefaultExecutor;
import org.openqa.selenium.net.UrlChecker;

public class AppiumServerUtils {
	
	// This method Is responsible for starting appium server. 
	public static void startAppium() throws Exception { 
		// Created object of apache CommandLine class. 
		// It will start command prompt In background.
		String AppiumNodeFilePath = JavaUtils.getPropValue("AppiumNodeFilePath");
        String AppiumJavaScriptServerFile = JavaUtils.getPropValue("AppiumJavaScriptServerFile");
        String AppiumServerAddress = JavaUtils.getPropValue("AppiumServerAddress");
        String AppiumServerPort = JavaUtils.getPropValue("AppiumServerPort");
		CommandLine command = new CommandLine("cmd"); 
		// Add different arguments In command line which requires to start appium server.
		command.addArgument("/c"); 
		command.addArgument(AppiumNodeFilePath); 
		command.addArgument(AppiumJavaScriptServerFile); 
		command.addArgument("--address"); 
		command.addArgument(AppiumServerAddress); 
		command.addArgument("--port"); 
		command.addArgument(AppiumServerPort); 
		command.addArgument("--no-reset");
		command.addArgument("--session-override");
//		command.addArgument("--log"); 
//		//Set path to store appium server log file. 
//		command.addArgument("./Logs/appiumLogs.txt"); 
		// Execute command line arguments to start appium server. 
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler(); 
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.setExitValue(1); 
		executor.execute(command, resultHandler); 
		// Wait for 15 minutes so that appium server can start properly before going for test execution. // Increase this time If face any error. 
		waitUntilAppiumIsRunning();
	}
    private static boolean waitUntilAppiumIsRunning() throws Exception {
	        final URL status = new URL(JavaUtils.getPropValue("AppiumUrl") + "/sessions");
	        long start = System.currentTimeMillis();
	        try {
	            new UrlChecker().waitUntilAvailable(60, TimeUnit.SECONDS, status);
	            long end = System.currentTimeMillis();
	            long elapsed = end - start;
	            System.out.println("Appium Server Started in :"+((double)elapsed/1000));
	            return true;
	        } catch (UrlChecker.TimeoutException e) {
	            return false;
	        }
	    }
	
	
	// This method Is responsible for stopping appium server. 
	public static void stopAppium() throws IOException, InterruptedException { 
		// Add different arguments In command line which requires to stop appium server. 
		Thread.sleep(2000);
		CommandLine command = new CommandLine("cmd"); 
		command.addArgument("/c"); 
		command.addArgument("taskkill"); 
		command.addArgument("/F"); 
		command.addArgument("/IM"); 
		command.addArgument("node.exe"); 
		// Execute command line arguments to stop appium server. 
		DefaultExecuteResultHandler resultHandler = new DefaultExecuteResultHandler(); 
		DefaultExecutor executor = new DefaultExecutor(); 
		executor.setExitValue(1); 
		executor.execute(command, resultHandler);
	}



}
