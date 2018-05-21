package moolya.embibe.tests.web.dummy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import moolya.embibe.utils.JavaUtils;

public class Dummy1 {

	public static void main(String[] args) throws IOException {
		String[] action = {"learn", "practice", "test", "tests", "revice", "revise"};
		String[] subject = {"physics", "chemistry", "mathematics", "math", "maths"};
		String[] concept = {"Optics", "Organic Chemistry"};
		String[] chapter = {"General Organic Chemistry", "Ray optics", "Limits"};
		String[] exam = {"JEE Main", "JEE Advanced"};
		String[] exam2 = {"JEE Main", "JEE Advanced", "AP EAMCET", "BITSAT", "Gujarat CET", "TS EAMCET"};
		String[] action2 = {"full test", "previuos year's papers"};
		
		
		List<String> result = new ArrayList<String>();
		
		List<String> actionList = Arrays.asList(action);
		List<String> subjectList = Arrays.asList(subject);
		List<String> conceptList = Arrays.asList(concept);
		List<String> chapterList = Arrays.asList(chapter);
		List<String> examList = Arrays.asList(exam);
		List<String> exam2List = Arrays.asList(exam2);
		List<String> action2List = Arrays.asList(action2);
		
		List<String> contextList = new ArrayList<String>();
		contextList.addAll(subjectList);
		contextList.addAll(conceptList);
		contextList.addAll(chapterList);
		
		List<List<String>> combination1 = new ArrayList<List<String>>();
		combination1.add(actionList);
		combination1.add(contextList);
		
		List<List<String>> combination2 = new ArrayList<List<String>>();
		combination2.add(contextList);
		combination2.add(actionList);
		
		List<List<String>> combination3 = new ArrayList<List<String>>();
		combination3.add(actionList);
		combination3.add(contextList);
		combination3.add(examList);
		
		List<List<String>> combination4 = new ArrayList<List<String>>();
		combination4.add(actionList);
		combination4.add(examList);
		combination4.add(contextList);
		
		List<List<String>> combination5 = new ArrayList<List<String>>();
		combination5.add(contextList);
		combination5.add(examList);
		combination5.add(actionList);
		
		List<List<String>> combination6 = new ArrayList<List<String>>();
		combination6.add(contextList);
		combination6.add(actionList);
		combination6.add(examList);
		
		List<List<String>> combination7 = new ArrayList<List<String>>();
		combination7.add(examList);
		combination7.add(contextList);
		combination7.add(actionList);
		
		List<List<String>> combination8 = new ArrayList<List<String>>();
		combination8.add(examList);
		combination8.add(actionList);
		combination8.add(contextList);
		
		List<List<String>> combination9 = new ArrayList<List<String>>();
		combination9.add(action2List);
		combination9.add(exam2List);
		
		List<List<String>> combination10 = new ArrayList<List<String>>();
		combination10.add(exam2List);
		combination10.add(action2List);		
		
		List<List<List<String>>> finalList = new ArrayList<List<List<String>>>();
		finalList.add(combination1);
		finalList.add(combination2);
		finalList.add(combination3);
		finalList.add(combination4);
		finalList.add(combination5);
		finalList.add(combination6);
		finalList.add(combination7);
		finalList.add(combination8);
		finalList.add(combination9);
		finalList.add(combination10);
		
		String res = "";
		for(int n=0;n<finalList.size();n++){
			result = GeneratePermutations(finalList.get(n), new ArrayList<String>(), 0, "");
			for(String s:result){
				if(res.length()==0)
					res = res + s;
				else
					res = res + "\n" + s;
			}
		}
		
		JavaUtils.writeResultsToFile("keywords.csv", res);
	}
	
	static List<String> GeneratePermutations(List<List<String>> lists, List<String> result, int depth, String current)
	{
	    if(depth == lists.size())
	    {
	       result.add(current);
	       return result;
	     }

	    for(int i = 0; i < lists.get(depth).size(); ++i)
	    {
	        if(current.length()==0)
	        	GeneratePermutations(lists, result, depth + 1, current + lists.get(depth).get(i));
	        else
	        	GeneratePermutations(lists, result, depth + 1, current + " " + lists.get(depth).get(i));
	    }
	    return result;
	}

}
