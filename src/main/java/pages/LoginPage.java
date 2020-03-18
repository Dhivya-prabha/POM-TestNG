package pages;

import org.openqa.selenium.By;

import base.ProjectSpecificMethods;

public class LoginPage extends ProjectSpecificMethods {
	
	public LoginPage clickSignIn() {
		driver.findElementByClassName("header_user_info").click();
		return this;
	}
	
	public LoginPage enterUserName(String name) {
		driver.findElementById("email").sendKeys(name);
		return this;
	}

	public LoginPage enterPassword(String pass) {
		driver.findElementById("passwd").sendKeys(pass);
		return this;
	}

	public MyAddress clickSign_in_button() {
		driver.findElement(By.id("SubmitLogin")).click();
		return new MyAddress();
	}
}
