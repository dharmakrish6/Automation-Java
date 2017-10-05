package moolya.embibe.tests.browserStack;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;

import com.browserstack.local.Local;

import moolya.embibe.pages.web.W_BasePage;


public class BrowserStackTestNGTest {
    public WebDriver wdriver;
    private Local l;
	protected String uniqueValue;
	private W_BasePage basepage;
	

    @BeforeMethod(alwaysRun=true)
    @org.testng.annotations.Parameters(value={"config", "environment"})
    public void setUp(@Optional("NA")String config_file,@Optional("chrome") String environment) throws Exception {
    	basepage = new W_BasePage(wdriver);
        wdriver = basepage.launchApp(config_file, environment, this.getClass().getSimpleName());
    }

    @AfterMethod(alwaysRun=true)
    public void tearDown() throws Exception {
        wdriver.quit();
        if(l != null) l.stop();
    }
}
