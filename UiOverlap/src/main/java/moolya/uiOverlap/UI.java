package moolya.uiOverlap;

import org.openqa.selenium.Point;
import org.testng.Assert;
import org.testng.Reporter;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class UI {

	// verify two elements one in left and one in right does not overlap
	public Boolean isHorizontalOverlapping(MobileElement left,MobileElement right){
		Point p1 = left.getCenter();
		Point p2 = right.getCenter();
		Point r1 = p1;
		r1.x = p1.getX()+(left.getSize().getWidth()/2);
		r1.y = p1.getY();
		Point r2 = p2;
		r2.x = p2.getX()-(right.getSize().getWidth()/2);
		r2.y = p2.getY();
		try{
		Assert.assertTrue(r1.x<=r2.x, "Element left and right is overlapping by "+Math.abs(r2.x-r1.x)+" pixels Horizontally");
		Reporter.log("Elements are "+(r2.x-r1.x)+" pixels apart Horizontally");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	// verify two elements one in top and one in bottom does not overlap
	public boolean isVerticalOverlapping(MobileElement top,MobileElement bottom){

		Point p1 = top.getCenter();
		Point p2 = bottom.getCenter();
		Point r1 = p1;
		r1.x = p1.getX();
		r1.y = p1.getY()+(top.getSize().getHeight()/2);
		Point r2 = p2;
		r2.x = p2.getX();
		r2.y = p2.getY()-(bottom.getSize().getHeight()/2);
		try{
		Assert.assertTrue(r1.y<=r2.y, "Element top and bottom is overlapping by "+Math.abs(r2.y-r1.y)+" pixels Vertically");
		Reporter.log("Elements are "+(r2.y-r1.y)+" pixels apart Vertically");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	// Verify and element is inside the screen view(not out of screen)
	public boolean isElementInView(AppiumDriver driver, MobileElement element){
		int h = driver.manage().window().getSize().getHeight();
		int w = driver.manage().window().getSize().getWidth();
		Point p = element.getCenter();
		Point r = p;
		r.x = p.getX()+(element.getSize().getWidth()/2);
		Point l = p;
		l.x = p.getX()-(element.getSize().getWidth()/2);
		Point t = p;
		t.y = p.getY()-(element.getSize().getHeight()/2);
		Point b = p;
		b.y = p.getY()+(element.getSize().getHeight()/2);
		try{
		Assert.assertTrue(t.y>=0, "Element is "+t.y+"  pixels outside the top of screen");
		Reporter.log("Element is "+t.y+"  pixels inside the top of screen");
		Assert.assertTrue(b.y<=h, "Element is "+(h-b.y)+" pixels outside the bottom of screen");
		Reporter.log("Element is "+(h-b.y)+" pixels inside the bottom of screen");
		Assert.assertTrue(r.x<=w, "Element is "+(w-r.x)+" pixels outside the right of screen");
		Reporter.log("Element is "+(w-r.x)+" pixels inside the right of screen");
		Assert.assertTrue(l.x>=0, "Element is "+l.x+" pixels outside the left of screen");
		Reporter.log("Element is "+l.x+" pixels inside the left of screen");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	// Verify and element is inside from top the screen view(not out of screen)
	public boolean isElementInsideTop(MobileElement top){
		Point p = top.getCenter();
		Point t = p;
		t.y = p.getY()-(top.getSize().getHeight()/2);
		try{
		Assert.assertTrue(t.y>=0, "Element is "+Math.abs(t.y)+"  pixels outside the top of screen");
		Reporter.log("Element is "+t.y+"  pixels inside the top of screen");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	// Verify and element is inside from bottom the screen view(not out of screen)
	public boolean isElementInsideBottom(AppiumDriver driver, MobileElement bottom){
		int h = driver.manage().window().getSize().getHeight();
		Point p = bottom.getCenter();
		Point b = p;
		b.y = p.getY()+(bottom.getSize().getHeight()/2);
		try{
		Assert.assertTrue(b.y<=h, "Element is "+Math.abs(h-b.y)+" pixels outside the bottom of screen");
		Reporter.log("Element is "+(h-b.y)+" pixels inside the bottom of screen");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}

	// Verify and element is inside from right the screen view(not out of screen)
	public boolean isElementInsideRight(AppiumDriver driver, MobileElement right){
		int w = driver.manage().window().getSize().getWidth();
		Point p = right.getCenter();
		Point r = p;
		r.x = p.getX()+(right.getSize().getWidth()/2);
		try{
		Assert.assertTrue(r.x<=w, "Element is "+Math.abs(w-r.x)+" pixels outside the right of screen");
		Reporter.log("Element is "+(w-r.x)+" pixels inside the right of screen");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
	
	// Verify and element is inside from left the screen view(not out of screen)
	public boolean isElementInsideLeft(MobileElement left){
		Point p = left.getCenter();
		Point l = p;
		l.x = p.getX()-(left.getSize().getWidth()/2);
		try{
		Assert.assertTrue(l.x>=0, "Element is "+Math.abs(l.x)+" pixels outside the left of screen");
		Reporter.log("Element is "+l.x+" pixels inside the left of screen");
		return true;
		}
		catch(Exception e){
			return false;
		}
	}
}
