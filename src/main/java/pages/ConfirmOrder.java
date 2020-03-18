package pages;

import base.ProjectSpecificMethods;

public class ConfirmOrder extends ProjectSpecificMethods{
	
	public Account OderConfirmation() {		
	driver.findElementByXPath("//span[text() = 'I confirm my order']").click();
	return new Account();
	}
}
