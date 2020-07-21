package com.serviceNow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.serviceNow.pages.CreateChangeNew;
import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class Change extends ProjectSpecificMethods{
	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Create a Change";
		author = "Balaji";
		category = "Smoke";
	}
	@Test
	public void createChange() throws InterruptedException {
		String changeNumber = new LoginPage()
		.login()
		.enterOnFilterNavigator(" Change")
		.clickonCreateNewChange()
		.clickNormalChange()
		.getChangeNumber();
		
		new CreateChangeNew()
		.selectCategory("Software")
		.enterShortDescription("Hey Sample Test")
		.clickSubmitButton()
		.selecttype("Number")
		.enterValue(changeNumber)
		.verifyLeadCreation(changeNumber);
		
	}
}
