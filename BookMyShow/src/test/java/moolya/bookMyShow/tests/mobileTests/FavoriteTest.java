package moolya.bookMyShow.tests.mobileTests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.bookMyShow.pages.mobilePages.FavoriteVenuesScreen;
import moolya.bookMyShow.pages.mobilePages.HomeScreen;
import moolya.bookMyShow.pages.mobilePages.LoginScreen;
import moolya.bookMyShow.pages.mobilePages.ProfileScreen;
import moolya.bookMyShow.pages.mobilePages.TicketsScreen;
import moolya.bookMyShow.pages.mobilePages.VenuesScreen;

public class FavoriteTest extends M_BaseTest {
	
	HomeScreen hs;
	ProfileScreen ps;
	LoginScreen ls;
	TicketsScreen ts;
	FavoriteVenuesScreen fvs;
	VenuesScreen vs;
	
	
	
	@Test(priority=1)
	public void loginTest(){
		Reporter.log("Logging in to the BMS App", true);
		hs = new HomeScreen(mdriver);
		ps = hs.goToProfileScreen();
		ls = ps.goToLoginPage();
		ls.login();
		Reporter.log("Logged in to the BMS App Successfully", true);
	}
	
	@Test(priority=2,dependsOnMethods="loginTest")
	public void addFavoriteVenueTest(){
		Reporter.log("Adding a venue as a favorite", true);
		hs = new HomeScreen(mdriver);
		ts = hs.goToTicketsScreen();
		vs = ts.goToSearchVenuesScreen();
		vs.searchVenue();
		vs.addFavorite();
		hs = vs.goBack();
		Reporter.log("Added a venue as a Favorite Successfully", true);
	}
	
	@Test(priority=3,dependsOnMethods="addFavoriteVenueTest")
	public void removeFavoriteTest(){
		Reporter.log("Removing a venue from My Favorites List", true);
		hs = new HomeScreen(mdriver);
		ps = hs.goToProfileScreen();
		fvs = ps.goToFavoriteVenues();
		fvs.removeFavorite();
		hs = fvs.goBack();
		Reporter.log("Removed a venue from My Favorites List Successfully", true);
	}
	
	@Test(priority=4,dependsOnMethods="removeFavoriteTest")
	public void logoutTest(){
		Reporter.log("Logging out from the BMS App", true);
		hs = new HomeScreen(mdriver);
		ps = hs.goToProfileScreen();
		ps.goToSettings();
		hs = ps.logout();
		Reporter.log("Logged out from the BMS App Successfully", true);
	}

}
