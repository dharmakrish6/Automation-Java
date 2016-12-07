package moolya.hungama.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.hungama.pages.DownloadsPage;
import moolya.hungama.pages.HomePage;
import moolya.hungama.pages.LoginPage;
import moolya.hungama.pages.MusicPage;
import moolya.hungama.pages.SettingsPage;
import moolya.hungama.pages.VideosPage;

public class FreeUserDownloadTest extends M_BaseTest{

	HomePage hp;
	SettingsPage sp;
	MusicPage mp;
	DownloadsPage dp;
	VideosPage vp;
	LoginPage lp;

	/*@Test(priority=1)
	public void hdAudioFreeUserTest() throws InterruptedException, IOException{
		hp = new HomePage(mdriver);
		hp.clickLater();
		hp.openNavDrawer();
		hp.deleteDownloadedMusic();
		sp = hp.clickOnSettings();
		sp.selectAudioQuality();
		sp.checkForUpgradePage();
	}
	
	@Test(priority=2,dependsOnMethods="hdAudioFreeUserTest")
	public void downloadMusicFreeUserTest() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		hp = new HomePage(mdriver);
		mp = hp.searchMusic("Ultimate Udit");
		mp.checkForAdPresent();
		mp.downloadAll();
		mp.downloadAll();
		mp.checkForUpgradePage();
	}

	@Test(priority=3,dependsOnMethods="downloadMusicFreeUserTest")
	public void downloadVideoFreeUserTest() throws InterruptedException{
		hp = new HomePage(mdriver);
		vp = hp.searchVideo("Toh Dishoom");
		vp.checkForAdPresent();
		Thread.sleep(25000);
		vp.downloadVideo();
		vp.checkForUpgradePage();
		hp = new HomePage(mdriver);
		hp.clickDeviceBackButton();
		hp.clickDeviceBackButton();
		hp.openNavDrawer();
		lp = hp.Subscriber_Login();
		hp = lp.Login_Screen();
		hp.openNavDrawer();
		hp.checkProUser();
	}
	
	@Test(priority=4,dependsOnMethods="downloadVideoFreeUserTest")
	public void downloadVideoProUserTest() throws InterruptedException, IOException{
		hp = new HomePage(mdriver);
		vp = hp.searchVideo("Jaeger Bomb");
		vp.downloadVideo();
		vp.clickDeviceBackButton();
		vp.clickDeviceBackButton();
		hp = new HomePage(mdriver);
		vp = hp.searchVideo("Ehbaab");
		vp.downloadVideo();
	}

	@DataProvider
	public Object[][] videoData(){
		String[] videos = new String[]{"Jaeger Bomb","Ehbaab"};
		//	,"Red Dress","Chakora","Ae Zindagi Gale Laga Le"
		Object[][] obj = new Object[videos.length][1];
		for(int i=0;i<videos.length;i++)
			obj[i][0] = videos[i];
		return obj;
	}*/

	@Test//(priority=5,dependsOnMethods="downloadVideoProUserTest")
	public void verifyMusicDownloadTest() throws IOException, InterruptedException{
		hp = new HomePage(mdriver);
		dp = hp.scrollToMyDownloads();
		dp.verifyMusicDownloaded(10);
	}
	

	@Test(priority=6,dependsOnMethods="verifyMusicDownloadTest")
	public void playMusicHDProUserTest() throws InterruptedException, IOException{
		hp = new HomePage(mdriver);
		hp.openNavDrawer();
		sp = hp.clickOnSettings();
		sp.selectAudioQuality();
		sp.clickDeviceBackButton();
		dp = hp.scrollToMyDownloads();
		dp.clickSongs();
		dp.apnModeON();
		dp.playAll();
		dp.checkForPlayPauseButton();
	}
	
	@Test(priority=7,dependsOnMethods="playMusicHDProUserTest")
	public void verifyVideoDownloadTest() throws InterruptedException, IOException{
		hp = new HomePage(mdriver);
		dp = hp.scrollToMyDownloads();
		dp.verifyVideoDownloaded(2);
	}
	
}
