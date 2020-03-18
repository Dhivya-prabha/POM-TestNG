package pages;

import base.ProjectSpecificMethods;

public class processCarrier extends ProjectSpecificMethods{

	public PaymentMethod Shipping() {
		driver.findElementByXPath("//input[@type='checkbox']").click();
		driver.findElementByXPath("//button[@name='processCarrier']").click();
		return new PaymentMethod();
	}
}
