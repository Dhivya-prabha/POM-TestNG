package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class ServiceCatalog extends SeleniumBase {
	public ServiceCatalog() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame(0);
	}

	@FindBy(how = How.XPATH, using = "//h2[text()[normalize-space()='Mobiles']]")
	private WebElement mobiles;
	 public HardwareMobiles clickMobile(){
			click(mobiles);
			return new HardwareMobiles() ;
		}
	

	

	

}
