package com.serviceNow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.serviceNow.pages.ChatQueueEntryPage;
import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class ChatQueueEntry extends ProjectSpecificMethods{
	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Create a Chat Queue Entry";
		author = "Balaji";
		category = "Smoke";
	}
	@Test
	public void createChatQueueEntry() throws InterruptedException {
		String chatEntryNumber = new LoginPage()
		.login()
		.enterOnFilterNavigator(" My Work")
		.clickMyWork()
		.clickNew()
		.clickChatQueueEntry()
		.enterShortDescription("Test Description")
		.enterWorkNotes("Selenium")
		.getChatEntryNumber();
		
		new ChatQueueEntryPage()
		.clickSubmit()
		.chooseSearchType("Number")
		.enterChatEntryNumber(chatEntryNumber)
		.verifyChatEntryCreation(chatEntryNumber);
}}
