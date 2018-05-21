package moolya.embibe.tests.mobile.android;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dummy {

	public static void main(String[] args) throws IOException{
		String packageName = "com.whatsapp";	//com.whatsapp, com.facebook.katana
		Process p = Runtime.getRuntime().exec("adb shell pm list packages | grep "+packageName);
		BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
		boolean flag = false;
		try{
			String line;
			while((line = br.readLine().trim())!=null){
				System.out.println("App Package: "+line.split(":")[1]);
				if(line.contains(packageName)){
		    		flag = true;
		    	}
			}
		}catch(Exception e){}
		if(flag){
			System.out.println("App is Installed");
			Process p1 = Runtime.getRuntime().exec("adb shell dumpsys package "+packageName+" | grep versionName");
			BufferedReader br1 = new BufferedReader(new InputStreamReader(p1.getInputStream()));
			String line = br1.readLine().trim();
			System.out.println("App Version: "+line.split("=")[1]);
		}
		else
			System.out.println("App is not Installed");
	}
}
