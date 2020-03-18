package pages;

import base.ProjectSpecificMethods;

public class ConfirmCheck extends ProjectSpecificMethods{
	public ConfirmAddress confirmProceedCheck() {
		driver.findElementByXPath("(//a[@title='Proceed to checkout'])[2]").click();
		return new ConfirmAddress();
	}

}
