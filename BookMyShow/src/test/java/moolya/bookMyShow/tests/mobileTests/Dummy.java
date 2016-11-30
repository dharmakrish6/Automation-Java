package moolya.bookMyShow.tests.mobileTests;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import moolya.bookMyShow.pages.mobilePages.M_BasePage;

public class Dummy {


	public static void main(String[] args) throws EncryptedDocumentException, InvalidFormatException, IOException {
		HashMap<String, String> data = M_BasePage.readExcelData("Movie", "book1");
		for(Map.Entry<String, String> m:data.entrySet())
			System.out.println("Key: "+m.getKey()+" Value: "+m.getValue());
	}

}
