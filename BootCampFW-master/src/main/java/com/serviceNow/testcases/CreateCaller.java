package com.serviceNow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class CreateCaller extends ProjectSpecificMethods{
	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Creating a new Caller";
		author = "Koushik";
		category = "Smoke";
	}
	@Test
	public void createCaller() {
		String user = "Koushik";
		new LoginPage()
		.login()
		.enterOnFilterNavigator("Caller")
		.clickOnCallers()
		.clickNewButton()
		.enterUserfirstname(user)
		.enterUserlastname("Chatterjee")
		.enterUsermobile_phone("9962251412")
		.clickSubmit()
		.typeSearch(user)
		.verifyIfUserCreated(user);
		
	}
}
