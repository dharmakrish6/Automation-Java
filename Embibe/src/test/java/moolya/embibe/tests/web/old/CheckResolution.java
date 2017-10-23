package moolya.embibe.tests.web.old;

import java.io.IOException;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;

import moolya.embibe.pages.web.W_BasePage;

public class CheckResolution {

	private static W_BasePage basepage;
	private static WebDriver wdriver;

	public static void main(String[] args) throws IOException {
		basepage = new W_BasePage(wdriver);
		wdriver = basepage.launchWebApp("chrome");
		wdriver.manage().window().setSize(new Dimension(1440, 900));
		int width = wdriver.manage().window().getSize().width;
		int height = wdriver.manage().window().getSize().height;
		System.out.println(width);
		System.out.println(height);
	}

}
