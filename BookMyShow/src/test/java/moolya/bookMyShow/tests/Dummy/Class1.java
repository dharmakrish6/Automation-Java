package moolya.bookMyShow.tests.Dummy;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Class1 {
	
	@Test(groups = {"smoke"})
	public void test1(){
		Reporter.log("Class1.test1() method",true);
	}
	
	@Test(groups = {"sanity"})
	public void test2(){
		Reporter.log("Class1.test2() method",true);
	}
	
	@Test(groups = {"regression"})
	public void test3(){
		Reporter.log("Class1.test3() method",true);
	}
}
