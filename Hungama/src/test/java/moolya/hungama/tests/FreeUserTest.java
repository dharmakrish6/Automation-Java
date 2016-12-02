package moolya.hungama.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.hungama.pages.DownloadsPage;
import moolya.hungama.pages.HomePage;
import moolya.hungama.pages.MusicPage;
import moolya.hungama.pages.SettingsPage;
import moolya.hungama.pages.VideosPage;

public class FreeUserTest extends M_BaseTest{

	HomePage hp;
	SettingsPage sp;
	MusicPage mp;
	DownloadsPage dp;
	VideosPage vp;
	
	@Test(priority=1)
	public void hdAudioFreeUserTest() throws InterruptedException{
		hp = new HomePage(mdriver);
		hp.gotIt();
		hp.openNavDrawer();
		sp = hp.clickOnSettings();
		sp.selectAudioQuality();
		sp.checkForUpgradePage();
	}
	
	@Test(priority=2)
	public void playlistMoreThan10Test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		hp = new HomePage(mdriver);
		hp.searchMusic("Ultimate Udit");
		mp.checkForAdPresent();
		mp.downloadAll();
		mp.downloadAll();
		mp.checkForUpgradePage();
	}
	
	
	@Test(priority=3)
	public void downloadVideoTest() throws InterruptedException{
		hp = new HomePage(mdriver);
		vp = hp.searchVideo("Toh Dishoom");
		vp.checkForAdPresent();
		vp.downloadVideo();
		vp.checkForUpgradePage();
	}
	
//	@Test(priority=4,dependsOnMethods="playlistMoreThan10Test")
	public void verifyMusicDownloadTest() throws IOException, InterruptedException{
		hp = new HomePage(mdriver);
		hp.gotIt();
		dp = hp.selectMyDownloads();
		dp.apnModeON();
		dp.verifyMusicDownloaded(10);
		dp.apnModeOFF();
	}
	
//	@Test(priority=5,dependsOnMethods="verifyMusicDownloadTest")
	public void playMusicTest(){
		
	}
	
	@AfterMethod
	public void afterMethodTest() throws IllegalArgumentException, IOException{
		((AndroidDriver<MobileElement>)mdriver).startActivity(getPropValue("appPackage"), getPropValue("appActivity"));
	}
}
