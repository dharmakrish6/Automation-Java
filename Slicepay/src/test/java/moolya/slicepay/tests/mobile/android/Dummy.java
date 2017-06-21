package moolya.slicepay.tests.mobile.android;

public class Dummy {
	
	public static void main(String[] args){
		Dummy d = new Dummy();
		String[] classNames = d.getClass().getName().split(".");
		for(String className:classNames)
			System.out.println(className);
	}

}
