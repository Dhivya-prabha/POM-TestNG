package com.serviceNow.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.serviceNow.pages.CreateNewIncident;
import com.serviceNow.pages.CreateNewProblem;
import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class CreateProblem extends ProjectSpecificMethods{
	@BeforeSuite
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Creating a new Problem";
		author = "Hari";
		category = "Smoke";
	}

	@Test
	void createNewProblem() throws InterruptedException {
		 String probID = new LoginPage()
				.login()
				.enterOnFilterNavigator("Problem")
				.clickOnCreateNewProblem()
				.getAttributeOfProb();
		 
		 new CreateNewProblem()
		 	.enterConfigItem("Oracle FLX")
			.enterShortDescription("oracle problem")
		 	.clickSubmit()
			.searchProblemByNumber(probID)
			.verifyProblemCreated(probID);
		 	
	}

}
