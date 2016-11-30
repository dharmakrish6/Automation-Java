package moolya.hungama.tests;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import moolya.hungama.pages.HomePage;
import moolya.hungama.pages.MusicPage;
import moolya.hungama.pages.SettingsPage;

public class HungamaTest extends M_BaseTest{

	HomePage hp;
	SettingsPage sp;
	MusicPage mp;
	
	@Test(priority=1)
	public void hdAudioFreeUserTest() throws InterruptedException{
		hp = new HomePage(mdriver);
		hp.openNavDrawer();
		sp = hp.clickOnSettings();
		sp.selectAudioQuality();
		sp.checkForUpgradePage();
	}
	
	@Test(priority=2)
	public void adPresentPlaylistMoreThan10Test() throws EncryptedDocumentException, InvalidFormatException, IOException, InterruptedException{
		hp = new HomePage(mdriver);
		mp = hp.selectMusicTab();
		mp.selectAlbum("Love Etc.");
		mp.checkForAdPresent();
		mp.downloadAll();
		mp.checkForUpgradePage();
	}
	
	@AfterMethod
	public void afterMethodTest() throws IllegalArgumentException, IOException{
		((AndroidDriver<MobileElement>)mdriver).startActivity(getPropValue("appPackage"), getPropValue("appActivity"));
	}
}
