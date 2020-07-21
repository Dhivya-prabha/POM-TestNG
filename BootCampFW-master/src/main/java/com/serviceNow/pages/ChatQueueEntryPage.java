package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class ChatQueueEntryPage extends ProjectSpecificMethods {
	public ChatQueueEntryPage() {
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

	@FindBy(how = How.ID, using = "chat_queue_entry.short_description")
	private WebElement eleShortDescription;

	public ChatQueueEntryPage enterShortDescription(String description) {
		clearAndType(eleShortDescription, description);
		return this;
	}

	@FindBy(how = How.ID, using = "chat_queue_entry.work_notes")
	private WebElement eleWorkNotes;

	public ChatQueueEntryPage enterWorkNotes(String workNotes) {
		clearAndType(eleWorkNotes, workNotes);
		return this;
	}

	@FindBy(how = How.ID, using = "chat_queue_entry.number")
	private WebElement eleChatEntryNumber;

	public String getChatEntryNumber() {
		String chatEntryNumber = getAttribute(eleChatEntryNumber, "value");
		return chatEntryNumber;
	}

	@FindBy(how = How.ID, using = "sysverb_insert")
	private WebElement eleSubmit;

	public TaskPage clickSubmit() {
		click(eleSubmit);
		return new TaskPage();
	}

	
	
	
	
	
	
	
}
