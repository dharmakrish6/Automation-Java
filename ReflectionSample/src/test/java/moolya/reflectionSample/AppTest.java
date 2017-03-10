package moolya.reflectionSample;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.testng.annotations.Test;


/**
 * Unit test for simple App.
 */
public class AppTest 
{
	String scenarioName = "Scenario1";
	
	
	@SuppressWarnings("rawtypes")
	@Test
	public void reflectionTest() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, ClassNotFoundException, InstantiationException{
		String[] steps = PoiUtils.getScenarioSteps(scenarioName);
		for(int i=1;i<steps.length;i=i+2){
			Class<?> cls = Class.forName("moolya.reflectionSample.App");
			Object obj = cls.newInstance();
			Class[] params = new Class[]{String.class};
			Method m = cls.getDeclaredMethod(steps[i], params);
			m.invoke(obj, steps[i+1]);
		}

	}
}
