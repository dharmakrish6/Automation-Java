package Moolya.CashE.testCases;

import org.testng.annotations.Test;
import org.xeustechnologies.googleapi.spelling.SpellChecker;
import org.xeustechnologies.googleapi.spelling.SpellCorrection;
import org.xeustechnologies.googleapi.spelling.SpellResponse;

public class Sample {
	
	@Test
	public void demoTest(){
		SpellChecker checker = new SpellChecker();
		SpellResponse spellResponse = checker.check( "helloo worlrd" );
		for( SpellCorrection sc : spellResponse.getCorrections() )
		System.out.println( sc.getValue() );
	}

}
