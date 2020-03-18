package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import base.ProjectSpecificMethods;

public class ChooseItem extends ProjectSpecificMethods {

	public AddToCart Click_Item() throws InterruptedException {
		Actions act = new Actions(driver);
		WebElement type = driver.findElementByXPath("//li/a[@title='Women']");
		act.moveToElement(type).perform();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@title='Blouses']").click();
		return new AddToCart();

	}
}
