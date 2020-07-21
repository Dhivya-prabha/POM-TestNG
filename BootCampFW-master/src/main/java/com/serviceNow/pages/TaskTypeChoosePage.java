package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class TaskTypeChoosePage extends ProjectSpecificMethods{
	public TaskTypeChoosePage() {
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
	@FindBy(how=How.XPATH, using="//a[text()[normalize-space()='Chat_queue_entry']]")
	private WebElement eleChatQueueEntry;
public ChatQueueEntryPage clickChatQueueEntry() {
	click(eleChatQueueEntry);
	return new ChatQueueEntryPage();
}
}
