package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class CreateChangeNew extends ProjectSpecificMethods {
	public CreateChangeNew() {
		PageFactory.initElements(getDriver(), this);
		waitTillLoadCompletes();
	}

	public void waitTillLoadCompletes() {
		List<WebElement> loader = locateElements(Locators.XPATH, "//div[text()='Loading...']");
		if (loader.size() > 0) {
			verifyDisappeared(loader.get(0));
		} else {
			reportStep("loader is not handle", "info");
		}
	}

	@FindBy(how = How.ID, using = "change_request.number")
	private WebElement elechangeNumber;

	public String getChangeNumber() {
		String changeNumber = getAttribute(elechangeNumber, "value");
		return changeNumber;
	}

	@FindBy(how = How.ID, using = "change_request.category")
	private WebElement eleCategoryDropDown;

	public CreateChangeNew selectCategory(String category) {
		selectDropDownUsingText(eleCategoryDropDown, category);
		return this;
	}

	@FindBy(how = How.ID, using = "change_request.short_description")
	private WebElement eleshortDescription;

	public CreateChangeNew enterShortDescription(String description) {
		clearAndType(eleshortDescription, description);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(//button[text()='Submit'])[2]")
	private WebElement eleSubmitButton;

	public ChangeRequest clickSubmitButton() {
		click(eleSubmitButton);
		return new ChangeRequest();
	}

}
