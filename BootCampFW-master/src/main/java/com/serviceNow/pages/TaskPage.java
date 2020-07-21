package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class TaskPage extends ProjectSpecificMethods {

	public TaskPage() {
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

	@FindBy(how = How.ID, using = "sysverb_new")
	private WebElement eleNewButton;

	public TaskTypeChoosePage clickNew() {
		click(eleNewButton);
		return new TaskTypeChoosePage();
	}

	@FindBy(how = How.XPATH, using = "//select[@class='form-control']")
	private WebElement elesearchDD;

	public TaskPage chooseSearchType(String type) {
		selectDropDownUsingText(elesearchDD, type);
		return this;
	}
	@FindBy(how = How.XPATH, using = "((//label[text()='Search'])[2]/following::input)[1]")
	private WebElement eleSearchBox;

	public TaskPage enterChatEntryNumber(String chatEntryNumber) {
		clearAndType(eleSearchBox, chatEntryNumber,Keys.ENTER);
		return this;
	}

	@FindBy(how =How.XPATH, using="(//tr[@data-list_id='task']//td)[3]")
	private WebElement eleResultChatEntryNumber;
	public TaskPage verifyChatEntryCreation(String chatEntryNumber) {
		System.out.println(verifyPartialText(eleResultChatEntryNumber, chatEntryNumber)?
				"Chat entry created successfully":"Chat entry failed to create");
		return this;
	}
	
	
	
}
