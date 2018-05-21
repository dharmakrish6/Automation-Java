package moolya.slicepay.tests.mobile.android.orders;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Reporter;
import org.testng.annotations.Test;

import moolya.slicepay.pages.mobile.android.HomePage;
import moolya.slicepay.pages.mobile.android.OrdersPage;
import moolya.slicepay.tests.mobile.M_BaseTest;

public class Check_Orders_Page_When_User_Has_Not_Placed_Any_Orders extends M_BaseTest {

	private String uniqueValue = "Login001";
	private HomePage hp;
	private OrdersPage op;

	@Test
	public void check_Orders_Page_When_User_Has_Not_Placed_Any_Orders_Test() throws EncryptedDocumentException, InvalidFormatException, InterruptedException, IOException{
		Reporter.log("Starting Test: Check_Orders_Page_When_User_Has_Not_Placed_Any_Orders_Test", true);
		hp = new HomePage(mdriver);
		op = hp.goToOrdersPage();
		op.verifyForNoOrders();
	}
}
