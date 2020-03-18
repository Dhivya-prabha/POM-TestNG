package pages;

import base.ProjectSpecificMethods;

public class MyAddress extends ProjectSpecificMethods{

	public NewAddress clik_in_MyAddress()
	{
		driver.findElementByXPath("//span[text() = 'My addresses']").click();
		return new NewAddress();
	}
}
