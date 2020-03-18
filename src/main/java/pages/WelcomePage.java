package pages;

import base.ProjectSpecificMethods;

public class WelcomePage extends ProjectSpecificMethods {

	public LoginPage clickLogin() {
		driver.findElementByClassName("header_user_info").click();
		return new LoginPage();
	}
	
	
}
