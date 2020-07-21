package com.serviceNow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class SearchIncident extends SeleniumBase{
	public SearchIncident() {
		PageFactory.initElements(getDriver(), this);
//		switchToFrame(0);
	}
	@FindBy(how = How.XPATH, using="(//input[@class='form-control'])[1]")
	private WebElement search;
	public SearchIncident searchIncidentByNumber(String data){
		clearAndType(search, data, Keys.ENTER);
	return this;
	}
	@FindBy(how = How.XPATH, using="//a[@class='linked formlink']")
	private WebElement iNC;
	public SearchIncident verifyIncidentCreated(String expectedText){
		verifyExactText(iNC,expectedText);
	return this;
	}


}
