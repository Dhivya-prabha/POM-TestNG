package com.serviceNow.testcases;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class ServiceCatalogMobiles extends ProjectSpecificMethods {
	@BeforeSuite
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Create new Service catalog";
		author = "Naveen";
		category = "Smoke";
	}

	@Test
	void CreateNewServiceCatalog() throws InterruptedException {
		new LoginPage().login().enterOnFilterNavigator("Service Catalog").clickServiceCatalog().clickMobile()
				.clickAppleIphone6s().selectMonthlyDataAllowances("unlimited").selectColor(2)
				.selectStorage("128GB [add $50.00]").clickOrderNow()
				.verifyingMessage("Thank you, your request has been submitted");
	}
}
