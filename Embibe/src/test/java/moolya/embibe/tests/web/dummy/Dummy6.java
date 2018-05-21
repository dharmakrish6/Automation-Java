package moolya.embibe.tests.web.dummy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import moolya.embibe.utils.JavaUtils;
import moolya.embibe.utils.MysqlUtils;

public class Dummy6 {

	private static String inputString = "physics";
	private static String[] outputstrings;
	static int count = 0;
	public static void main (String args[]) throws ClassNotFoundException, IOException
	{
		//combine(inputString, new StringBuffer(), 0);
		MysqlUtils.createQuestionIds(1, 262413);
	}

	static void combine(String instr, StringBuffer outstr, int index)
	{
			for (int i = index; i < instr.length(); i++)
			{
				outstr.append(instr.charAt(i));
				System.out.println(outstr);
				combine(instr, outstr, i + 1);
				outstr.deleteCharAt(outstr.length() - 1);
			}
	} 

} 

