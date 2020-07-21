package com.serviceNow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class UpdateIncident extends ProjectSpecificMethods {
	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Update an incident";
		author = "Balaji";
		category = "Smoke";
	}
	@Test
	public void runUpdateIncident() throws InterruptedException {
		String incidentNumber="INC0010088";
		new LoginPage()
		.login()
		.enterOnFilterNavigator(" Incidents")
		.clickIncidents()
		.chooseSearchType("Number")
		.enterIncidentNumber(incidentNumber)
		.clickFirstIncidentNumber(incidentNumber)
		.updateUrgency("1 - High")
		.updateState("In Progress")
		.clickUpdate()
		.verifyUpdatedState("Moderate");
}}
