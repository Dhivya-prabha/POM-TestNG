package pages;

import org.openqa.selenium.interactions.Actions;

import base.ProjectSpecificMethods;

public class AddToCart extends ProjectSpecificMethods{

	public ToCheckOut ClickAddToCart() {
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElementByXPath("//div[@class='product-image-container']")).perform();
		driver.findElementByXPath("//span[text()='Add to cart']").click();
		return new ToCheckOut();
	}
	
}
