package testcases;

import org.testng.annotations.Test;

import base.BaseClass;
import pages.HomePage;
import pages.LoginPage;

public class LoginAndLogout extends BaseClass {
	
	
	@Test
	public void runLoginLogout() throws InterruptedException {
		
	//	LoginPage lp = new LoginPage();
		new LoginPage(driver)
		.enterUserName()
		.enterPassword()
		.clickLoginButton()
		.verifyHomePage()
		.clickLogoutButton();
		
		
	}

}
