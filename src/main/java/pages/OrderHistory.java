package pages;

import base.ProjectSpecificMethods;

public class OrderHistory extends ProjectSpecificMethods{

	public ScreenShotPage ClickOrderHistory() {
		
		driver.findElementByXPath("//a[@title='Orders']").click();
		return new ScreenShotPage();
		
	}
}
