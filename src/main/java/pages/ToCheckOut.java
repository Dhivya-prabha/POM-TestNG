package pages;

import base.ProjectSpecificMethods;

public class ToCheckOut extends ProjectSpecificMethods{
	public ConfirmCheck ProceedToCheck() throws InterruptedException {
		driver.findElementByXPath("//a[@title='Proceed to checkout']").click();
		Thread.sleep(2000);
		return new ConfirmCheck();
	}

}
