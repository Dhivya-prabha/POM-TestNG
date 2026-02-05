package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class LoginPage extends BaseClass {
	
	
	public LoginPage(ChromeDriver driver) {
		this.driver = driver;
		
	}
	
	

	public LoginPage enterUserName() {
		
		driver.findElementById("username").sendKeys("Demosalesmanager");
		
		return this;

	}

	public LoginPage enterPassword() throws InterruptedException {
		
		driver.findElementById("password").sendKeys("crmsfa");
		
		return this;
	}

	public HomePage clickLoginButton() {
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		return new HomePage(driver);

	}
	
	public LoginPage verifyErrorMessage() {
		System.out.println("error message should be displayed");
		
		return this;

	}

}
