package pages;

import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificMethods;

public class AddAddress extends ProjectSpecificMethods {

	public ChooseItem AddNewAdress() {
		driver.findElementById("firstname").sendKeys("Divya");
		driver.findElementById("lastname").sendKeys("Prabha");
		driver.findElementById("company").sendKeys("TestCompany");
		driver.findElementByName("address1").sendKeys("Gandhi Nagar");
		driver.findElementByName("address2").sendKeys("Vinoba Nagar");
		driver.findElementById("city").sendKeys("Albany");
		Select state = new Select(driver.findElementById("id_state"));
		state.selectByVisibleText("California");
		driver.findElementByName("postcode").sendKeys("12204");
		Select company = new Select(driver.findElementById("id_country"));
		company.selectByValue("21");
		driver.findElementById("phone").sendKeys("(510) 981-5244");
		driver.findElementById("phone_mobile").sendKeys("(510) 982-5076");
		driver.findElementByName("other").sendKeys("checking message");
		driver.findElementById("alias").clear();
		driver.findElementById("alias").sendKeys("Home address");
		driver.findElementById("submitAddress").click();
		return new ChooseItem();
	}
	
	
}
