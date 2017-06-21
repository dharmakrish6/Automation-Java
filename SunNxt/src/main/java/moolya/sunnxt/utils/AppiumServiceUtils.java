package moolya.sunnxt.utils;

import java.io.File;
import java.io.IOException;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServiceUtils {

	public static AppiumDriverLocalService service;
	
	static {
		try{
			AppiumServerUtils.stopAppium();
			Thread.sleep(2000);
		}catch(Exception e){}
		File classpathRoot = new File(System.getProperty("user.dir"));
		try {
			service = new AppiumServiceBuilder()
					.usingPort(Integer.parseInt(JavaUtils.getPropValue("AppiumServerPort")))
					.withIPAddress(JavaUtils.getPropValue("AppiumServerAddress"))
					.withLogFile(new File(classpathRoot, "AppiumServerLogs.txt"))
					.withArgument(GeneralServerFlag.LOG_LEVEL, "warn:info")
					.withAppiumJS(new File(JavaUtils.getPropValue("AppiumJavaScriptServerFile")))
					.usingDriverExecutable(new File(JavaUtils.getPropValue("AppiumNodeFilePath")))
					.withArgument(GeneralServerFlag.SESSION_OVERRIDE)
					.withArgument(GeneralServerFlag.NO_RESET)
					.build();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
