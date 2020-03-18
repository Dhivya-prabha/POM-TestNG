package testcases;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificMethods;
import pages.LoginPage;

public class TC001_LoginLogout extends ProjectSpecificMethods{
	@BeforeTest
	public void sendData() {
		excelFileName = "tabelData";
	}
	@Test(dataProvider = "fetchData")
	public void runTest(String name, String pass) throws IOException, InterruptedException {
		
		new LoginPage()
		.clickSignIn()
		.enterUserName(name)
		.enterPassword(pass)
		.clickSign_in_button()
		.clik_in_MyAddress()
		.click_AddNewAddress()
		.AddNewAdress()
		.Click_Item()
		.ClickAddToCart()
		.ProceedToCheck()
		.confirmProceedCheck()
		.AddressConfirmation()
		.Shipping()
		.SelectPyment()
		.OderConfirmation()
		.ClickAccount()
		.ClickOrderHistory()
		.TakeScreenShot();
		
	}
}
