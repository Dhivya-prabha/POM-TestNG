package com.serviceNow.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.serviceNow.pages.CreateNewIncident;
import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class CreateIncident extends ProjectSpecificMethods {
	@BeforeSuite
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Creating a new Incident";
		author = "Koushik";
		category = "Smoke";
	}

	@Test
	void createNewIncident() {
		String incidentNumber = new LoginPage().login().enterOnFilterNavigator("incident").clickOnCreateNew()
				.getAttributeOfINC();
		System.out.println(incidentNumber);
		new CreateNewIncident().enterOnCaller("Abel").enterShortDescription("short description by koushik")
				.clickSubmit().searchIncidentByNumber(incidentNumber).verifyIncidentCreated(incidentNumber);

	}

}
