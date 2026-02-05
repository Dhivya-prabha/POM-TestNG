package pages;

import org.openqa.selenium.chrome.ChromeDriver;

import base.BaseClass;

public class HomePage extends BaseClass {
	
	
	public HomePage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	
	public LoginPage clickLogoutButton() {
		
		driver.findElementByClassName("decorativeSubmit").click();
		
		return new LoginPage(driver);

	}
	
	public HomePage verifyHomePage() {
		String title = driver.getTitle();
		
		if (title.contains("Leaftaps")) {
			System.out.println("we are in right page");
		}
		else {
			System.out.println("we are not in right page");
		}

		return this;
	}

}
