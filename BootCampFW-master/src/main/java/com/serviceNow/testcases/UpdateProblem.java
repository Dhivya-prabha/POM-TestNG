package com.serviceNow.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


import com.serviceNow.pages.CreateNewProblem;
import com.serviceNow.pages.LoginPage;
import com.serviceNow.pages.SearchProblem;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class UpdateProblem extends ProjectSpecificMethods{
	@BeforeSuite
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Update an existing Problem";
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
				.selectProblemImpact(1)
				.selectProblemUrgency(1)
				.enterWorkNotes("testing")
				.clickUpdate()
				.searchProblemByNumber(firstProbId)
				.verifyProblemPriority("Moderate");
		
	}

}
