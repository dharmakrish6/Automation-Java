package moolya.embibe.utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import moolya.embibe.pages.web.W_BasePage;

public class DriverManager {
	/**
	 * shares the same web driver and use thread local to handle the multi-thread
	 */
	public static ThreadLocal<WebDriver> ThreadDriver=new ThreadLocal<WebDriver>() ;
	public static String browserType;
	private static WebDriver wdriver;
	private static W_BasePage bp;

	/**
	 * create a driver for this thread if not exist. or return it directly
	 */
	public static WebDriver getDriver() throws IOException{
		WebDriver driver= DriverManager.ThreadDriver.get();
		if (driver==null){
			bp = new W_BasePage(wdriver);
			driver = bp.launchContentAdminApp(browserType);
			ThreadDriver.set(driver);
		}
		return driver;
	}
	/**
	 * save the browser type but not create it
	 */
	public static void setupDriver(String browser){
		browserType=browser;
	}		
	/**
	 * quit the driver
	 */
	public static void quitDriver() throws IOException{
		getDriver().quit();
		DriverManager.ThreadDriver.set(null);
	}
}