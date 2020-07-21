package com.serviceNow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class Callers extends ProjectSpecificMethods {
	public Callers() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame(0);
	}

	@FindBy(how = How.XPATH, using = "//button[text()='New']")
	private WebElement sysverb_new;
	int i = 0;

	public Callers clickNewButton() {
		String url = getDriver().getCurrentUrl();
		click(sysverb_new);
		if (!url.equals(getDriver().getCurrentUrl())) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
			}
			clickNewButton();
		}
		return this;
	}

	@FindBy(how = How.ID, using = "sys_user.first_name")
	private WebElement sys_userfirst_name;

	public Callers enterUserfirstname(String str) {
		clearAndType(sys_userfirst_name, str);
		return this;
	}

	/**
	 * This is mandatory field
	 */
	@FindBy(how = How.ID, using = "sys_user.mobile_phone")
	private WebElement sys_usermobile_phone;

	public Callers enterUsermobile_phone(String str) {
		clearAndType(sys_usermobile_phone, str);
		return this;
	}

	@FindBy(how = How.ID, using = "sys_user.last_name")
	private WebElement sys_userlast_name;

	public Callers enterUserlastname(String str) {
		clearAndType(sys_userlast_name, str);
		return this;

	}

	@FindBy(how = How.XPATH, using = "(//button[@id='sysverb_insert'])[2]")
	private WebElement sysverb_insert;

	public Callers clickSubmit() {
		click(sysverb_insert);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(//input[@placeholder='Search'])[1]")
	private WebElement search;

	public Callers typeSearch(String searchData) {
		clearAndType(search, searchData, Keys.ENTER);
		return this;
	}

	public void verifyIfUserCreated(String expectedText) {
		boolean isCreated = verifyExactText(
				locateElement(Locators.XPATH, "//a[text()='First name']/following::td[text()='" + expectedText + "']"),
				expectedText);
		if (!isCreated) {
			reportStep("Caller not created", "fail");
		}
	}
}
