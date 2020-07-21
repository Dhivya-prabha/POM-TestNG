package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class HardwareMobiles extends SeleniumBase{
	public HardwareMobiles() {
		PageFactory.initElements(getDriver(), this);
		
	}
	@FindBy(how = How.XPATH, using = "//strong[text()='Apple iPhone 6s']")
	private WebElement appleIphone6s;
    public MobAppleIphone6S clickAppleIphone6s(){
		click(appleIphone6s);
		return new MobAppleIphone6S() ;
	}

}
