package moolya.embibe.tests.web.dummy;

import org.apache.commons.lang.StringUtils;

public class Dummy2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "Chemistry of Manganese From Pyrosulite,Chemistry,p Block Elements,"
				+ "Chemistry of Chromium From Chromite,Inorganic Chemistry,General Organic Chemistry,"
				+ "Physical Chemistry,Characteristics of P-block elements,Inorganic Compounds in Cellular Pool,"
				+ "Electronic Configuration of p block elements,Nuclear and Surface Chemistry,null";
		String s2 = "Chemistry of Manganese From Pyrosulite,Chemistry,p Block Elements,"
				+ "Chemistry of Chromium From Chromite,Inorganic Chemistry,General Organic Chemistry,"
				+ "Physical Chemistry,Characteristics of P-block elements,Inorganic Compounds in Cellular Pool,"
				+ "Electronic Configuration of p block elements,Nuclear and Surface Chemistry,d and f Block elements";
		System.out.println(s1.equals(s2));
		String diff1 = StringUtils.difference(s1, s2);
		String diff2 = StringUtils.difference(s2, s1);
		System.out.println(diff1);
		System.out.println(diff2);
	}

}
