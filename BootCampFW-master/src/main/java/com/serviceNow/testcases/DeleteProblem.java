package com.serviceNow.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.serviceNow.pages.LoginPage;
import com.serviceNow.pages.SearchProblem;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class DeleteProblem extends ProjectSpecificMethods{
	@BeforeSuite
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Delete an existing Problem";
		author = "Hari";
		category = "Smoke";
	}

	@Test
	void updateProblem() throws InterruptedException {
		 String firstProbId = new LoginPage()
				.login()
				.enterOnFilterNavigator("Problem")
				.clickOnOpenProblem()
				.sortProblemByNumber()
				.getFirstProbId();
		 new SearchProblem()
				.clickFirstProbId()
				.clickDelete()
				.acceptDelete()
				.searchProblemByNumber(firstProbId)
				.verifyProblemDeleted("No records to display");
		
	}

}
