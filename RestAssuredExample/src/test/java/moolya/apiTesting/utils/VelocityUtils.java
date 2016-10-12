package moolya.apiTesting.utils;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;

import groovy.json.JsonOutput;

public class VelocityUtils {
	static String stri;
	static String fileName;

	static Properties velocityProps;
	
	/*
	 * Puts the values to the velocity template by iterating through all the
	 * values in the variable array
	 */
	public static String getJsonFromVelocity(String fileName, Map<String,String> variables) {

		initializeVelocityTemplate();
		VelocityContext velocityContext = new VelocityContext();
		for (Map.Entry<String, String> m :variables.entrySet()) {
				velocityContext.put(m.getKey(), m.getValue());
		}

		Template template = null;
		StringWriter writer = null;
		try {
			template = Velocity.getTemplate(fileName);
			writer = new StringWriter();
			template.merge(velocityContext, writer);
		} catch (ResourceNotFoundException e) {
			throw new NullPointerException("Failed due to ResourceNotFoundException" + e);
		} catch (ParseErrorException e) {
			throw new NullPointerException("Failed due to ParseErrorException" + e);
		} catch (Exception e) {
			throw new NullPointerException("Failed due to Exception" + e);
		}

		stri = writer.toString();
		String requestInStringFormat = JsonOutput.prettyPrint(stri);
		return requestInStringFormat;
	}

	/*
	 * Initializes the velocity templates so as it input the values to it
	 */
	public static void initializeVelocityTemplate() {

		velocityProps = new Properties();
		velocityProps.setProperty("resource.loader", "file");
		velocityProps.setProperty("file.resource.loader.class",
				"org.apache.velocity.runtime.resource.loader.FileResourceLoader");
		velocityProps.setProperty("file.resource.loader.path", System.getProperty("user.dir") + "/test-data/jsons");
		velocityProps.setProperty("file.resource.loader.cache", "true");
		velocityProps.setProperty("file.resource.loader.modificationCheckInterval", "2");

		try {
			Velocity.init(velocityProps);
		} catch (Exception e) {
			System.out.println("Initializing the velocity template failed..!");
			throw new NullPointerException("Failed due to Exception" + e);
		}
	}

}
