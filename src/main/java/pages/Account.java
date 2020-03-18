package pages;

import base.ProjectSpecificMethods;

public class Account extends ProjectSpecificMethods{
	public OrderHistory ClickAccount()
	{
		driver.findElementByXPath("//a[@class='account']").click();
		return new OrderHistory();
	}
	

}
