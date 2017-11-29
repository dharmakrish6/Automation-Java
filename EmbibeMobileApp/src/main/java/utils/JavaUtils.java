package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

public class JavaUtils {
	
	public static String getPropValue(String key) throws IOException
	{
		File configFile = new File("./config.properties");
		String host = null;
		try {
			FileReader reader = new FileReader(configFile);
			Properties props = new Properties();
			props.load(reader);
			host = props.getProperty(key);
			reader.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}

		return host;
	}

	public static void setPropValue(String key,String value){
		File configFile = new File("./config.properties");
		try {
			FileInputStream in = new FileInputStream(configFile);
	        Properties props = new Properties();
	        props.load(in);
	        in.close();
	        FileOutputStream out = new FileOutputStream(configFile);
	        props.setProperty(key, value);
	        props.store(out, null);
	        out.close();
	    }
	    catch (Exception e ) {
	        e.printStackTrace();
	    }
	}
	
	public static void setPValue(String key,String value){
		File configFile = new File("./config.properties");
		try {
	        FileInputStream in = new FileInputStream(configFile);
	        Properties props = new Properties();
	        props.load(in);
	        in.close();
	        FileOutputStream out = new FileOutputStream(configFile);
	        props.setProperty(key, value);
	        props.store(out, null);
	        out.close();
		} catch (FileNotFoundException ex) {
			// file does not exist
		} catch (IOException ex) {
			// I/O error
		}
	}

}
