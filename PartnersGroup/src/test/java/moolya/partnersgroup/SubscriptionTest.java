package moolya.partnersgroup;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import moolya.partnersgroup.pages.HomePage;
import moolya.partnersgroup.pages.SubscriptionPage;

public class SubscriptionTest extends W_BaseTest{
	HomePage hp;
	SubscriptionPage sp;
	
	
	@Test(priority=1)
	public void subscriptionNegativeTest() throws InterruptedException{
		hp = new HomePage(driver);
		sp = hp.clickSubscribe();
		sp.subscribeNegative();
		boolean flag = sp.assertSuccessMessage();
		if(!flag)
			Assert.fail("No Validation Message is Displayed!");
	}
	
	@Test(priority=2)
	public void duplicateSubscriptionTest() throws InterruptedException{
		int count = 0;
		for (int i = 0; i < 2; i++) {
			hp = new HomePage(driver);
			sp = hp.clickSubscribe();
			sp.subscribe();
			boolean flag = sp.assertSuccessMessage();
			if (flag)
				count++;
		}
		if(count>1){
			Assert.fail("Application is Accepting Duplicate Subscription");
		}
	}
}
