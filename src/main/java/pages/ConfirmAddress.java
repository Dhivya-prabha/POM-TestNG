package pages;

import base.ProjectSpecificMethods;

public class ConfirmAddress extends ProjectSpecificMethods{
	public processCarrier AddressConfirmation()
	{
		driver.findElementByXPath("//button[@name='processAddress']").click();
		return new processCarrier();
	}
	
}
