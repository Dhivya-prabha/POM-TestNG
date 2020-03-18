package pages;

import base.ProjectSpecificMethods;

public class NewAddress extends ProjectSpecificMethods{

	public AddAddress click_AddNewAddress()
	{
		driver.findElementByXPath("//span[text() = 'Add a new address']").click();
		return new AddAddress();
	}
	
}
