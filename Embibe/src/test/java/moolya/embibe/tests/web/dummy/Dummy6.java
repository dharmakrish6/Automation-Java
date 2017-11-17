package moolya.embibe.tests.web.dummy;

public class Dummy6 {

	private static String inputString = "physics";
	private static String[] outputstrings;
	static int count = 0;
	public static void main (String args[])
	{
		combine(inputString, new StringBuffer(), 0);
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

