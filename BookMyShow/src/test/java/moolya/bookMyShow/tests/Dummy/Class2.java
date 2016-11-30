package moolya.bookMyShow.tests.Dummy;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Class2 {
	
	@Test(groups = {"smoke"})
	public void test1(){
		Reporter.log("Class2.test1() method",true);
	}
	
	@Test(groups = {"sanity"})
	public void test2(){
		Reporter.log("Class2.test2() method",true);
	}
	
	@Test(groups = {"regression"})
	public void test3(){
		Reporter.log("Class2.test3() method",true);
	}

}
