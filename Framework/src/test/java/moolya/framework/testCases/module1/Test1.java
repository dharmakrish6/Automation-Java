package moolya.framework.testCases.module1;

import org.testng.annotations.Test;

import moolya.framework.pages.module1.Page1;
import moolya.framework.pages.module2.Page3;
import moolya.framework.testCases.BaseTest;

public class Test1 extends BaseTest {
	
	Page1 p1;
	Page3 p3;
	
	@Test
	public void test1(){
		p1 = new Page1(driver);
		p3 = p1.login();
		p3.verifyPageTitle();
		System.out.println("Test1 executed");
	}

}
