package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class MobAppleIphone6S extends SeleniumBase {
	public MobAppleIphone6S() {
		PageFactory.initElements(getDriver(), this);
}
	@FindBy(how = How.XPATH, using = "(//select[@class='form-control cat_item_option '])[1]")
	private WebElement dataAllowance;

	public MobAppleIphone6S selectMonthlyDataAllowances(String value) {
		selectDropDownUsingValue(dataAllowance, value);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(//select[@class='form-control cat_item_option '])[1]")
	private WebElement color ;

	public MobAppleIphone6S selectColor(int index) throws InterruptedException {
		Thread.sleep(2000);
		selectDropDownUsingIndex(color, index);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(//select[@class='form-control cat_item_option '])[3]")
	private WebElement Storage ;

	public MobAppleIphone6S selectStorage(String visibleText) {
		selectDropDownUsingText(Storage,visibleText );
		return this;
	}

	@FindBy(how = How.ID, using = "oi_order_now_button")
	private WebElement order ;

	public Orderstatus clickOrderNow() {
		click(order);
		return new Orderstatus();
	}

}

