package moolya.partnersgroup;

import java.io.IOException;

import org.testng.annotations.Test;

import moolya.partnersgroup.pages.HomePage;
import moolya.partnersgroup.pages.SearchPage;

public class SearchResultsTest extends W_BaseTest {

	private HomePage hp;
	private SearchPage sp;

	@Test
	public void searchAndReadResultsTest() throws InterruptedException, IOException{
		hp = new HomePage(driver);
		sp = hp.search("test");
		sp.readResults();
	}
}
