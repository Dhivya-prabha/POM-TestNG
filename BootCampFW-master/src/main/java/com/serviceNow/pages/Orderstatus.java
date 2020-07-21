package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class Orderstatus extends SeleniumBase {
	public Orderstatus() {
		PageFactory.initElements(getDriver(), this);

}

	@FindBy(how = How.XPATH, using = "(//a[@class='linked requestItemUrl'])[2]")
	private WebElement AppleIphone6s ;

	public String getAttributeOfRequestNumber() {
		String Rqno = getElementText(AppleIphone6s);
		return Rqno;
		
	}
	
	@FindBy(how = How.XPATH, using = "//span[text()='Thank you, your request has been submitted']")
	private WebElement VerifyMessage ;
	
	public Orderstatus verifyingMessage(String expMsg) {
		//String actMsg = getElementText(VerifyMessage);
		verifyExactText(VerifyMessage, expMsg);
		return this;
		
	}
	
}
