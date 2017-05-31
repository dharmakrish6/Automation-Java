package moolya.sunnxt.pages.webpages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MoviesPage extends W_BasePage{
	public MoviesPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//a[text()='view all movies ']") 
	private WebElement View_All_Movies;
	
	@FindBy(xpath = "//a[text()='LATEST MOVIES ']/span") 
	private WebElement View_All_Latest_Movies;
	
	@FindBy(xpath = "//input[@id='search']") 
	private WebElement Search_bar;
	
	@FindBy(xpath = "//button[text()='Apply']") 
	private WebElement Apply_Btn;
	
	@FindBy(xpath = "//button[text()='Reset']") 
	private WebElement Reset_Btn;
	
	@FindBy(xpath = "(//button[@class='genre_filter_btn filter-trigger']/span)[2]") 
	private WebElement Actors_dropdown;
	
	
	
	public MoviesPage click_view_all_movies(){
		View_All_Movies.click();
		return new MoviesPage(driver);
	}
	
	public MoviesPage Search_movie(){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Search_bar));
		Search_bar.sendKeys("Dharmadurai");
		//WebElement Search_btn = driver.findElement(By.xpath("//span[@class='inside_search_icon']"));
		//Search_btn.click();
		Search_bar.sendKeys(Keys.ENTER);
		
		return new MoviesPage(driver);
		
	}
	public MoviesPage Select_genre(ArrayList<String> GenreList){
		
		WebElement genre_dropdown = driver.findElement(By.xpath("(//button[@class='genre_filter_btn filter-trigger']/span)[1]"));
		genre_dropdown.click();
		for(int i=0;i<GenreList.size();i++){
			WebElement select_genre = driver.findElement(By.xpath("//label[text()='"+GenreList.get(i)+"']"));
			select_genre.click();
		}
		Apply_Btn.click();
		
		return new MoviesPage(driver);
		
	}
	
	public MoviesPage Select_Actor(String Actor_name){
		Actors_dropdown.click();
		WebElement actor_name = driver.findElement(By.xpath("//a[text()='"+Actor_name+"']"));
		actor_name.click();
		
		
		return new MoviesPage(driver);
	}
	
	

}
