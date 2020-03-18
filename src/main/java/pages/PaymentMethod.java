package pages;

import base.ProjectSpecificMethods;

public class PaymentMethod extends ProjectSpecificMethods {

	public ConfirmOrder SelectPyment() {
		driver.findElementByXPath("//a[@title='Pay by bank wire']").click();
		return new ConfirmOrder();
	}
}
