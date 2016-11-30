package moolya.bookMyShow.tests.webTests;

import org.testng.annotations.Test;

import moolya.bookMyShow.pages.webPages.HomePage;
import moolya.bookMyShow.pages.webPages.LoginPage;
import moolya.bookMyShow.pages.webPages.MoviesPage;

public class VerifyOrderSummary extends W_BaseTest {
	
	HomePage hp;
	LoginPage lp;
	MoviesPage mp;

	@Test(priority=1)
	public void loginTest() throws InterruptedException{
		hp = new HomePage(wdriver);
		hp.selectCity();
		lp = hp.goToLoginPage();
		hp = lp.login();
	}
	
	@Test(priority=2,dependsOnMethods="loginTest")
	public void bookMovieTest() throws InterruptedException{
		hp = new HomePage(wdriver);
		mp = hp.goToMoviesPage();
		mp.selectMovie();
		mp.selectShowtimeInTheatre();
		mp.selectSeats();
	}
	
	@Test(priority=3,dependsOnMethods="bookMovieTest")
	public void assertOderSummary() throws InterruptedException{
		mp = new MoviesPage(wdriver);
		mp.assertOrderSummary();
	}

}
