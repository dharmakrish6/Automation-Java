package TestCases;

import java.io.IOException;

import utils.JavaUtils;

public class Dummy {

	public static void main(String[] args) throws IOException {
//		System.out.println(JavaUtils.getPropValue("subject"));
//		System.out.println(JavaUtils.getPropValue("unit"));
//		System.out.println(JavaUtils.getPropValue("chapter"));
//		System.out.println(JavaUtils.getPropValue("concept"));
		JavaUtils.setPropValue("subject", "5");
		JavaUtils.setPropValue("unit", "6");
		JavaUtils.setPropValue("chapter", "1");
		JavaUtils.setPropValue("concept", "2");
		System.out.println(JavaUtils.getPropValue("subject"));
		System.out.println(JavaUtils.getPropValue("unit"));
		System.out.println(JavaUtils.getPropValue("chapter"));
		System.out.println(JavaUtils.getPropValue("concept"));
	}

}
