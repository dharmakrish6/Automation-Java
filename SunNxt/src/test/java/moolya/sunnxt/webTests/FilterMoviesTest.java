package moolya.sunnxt.webTests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import moolya.sunnxt.pages.webpages.HomePage;
import moolya.sunnxt.pages.webpages.MoviesPage;

public class FilterMoviesTest extends W_BaseTest {

private HomePage hp;
private MoviesPage mp;
	
	@Test
	public void Filter_Movies() throws InterruptedException
	{    
		ArrayList<String> list = new ArrayList<String>();
		list.add("Comedy");
		list.add("Fantasy");
		list.add("Horror");
		list.add("Drama");
		
		hp = new HomePage(wdriver);
		mp = hp.click_Movies();
		mp.click_view_all_movies();
		//mp.Search_movie();
		mp.Select_genre(list);
		Thread.sleep(5000);
		mp.Select_Actor("Rajinikanth");
		Thread.sleep(10000);
	}
}
