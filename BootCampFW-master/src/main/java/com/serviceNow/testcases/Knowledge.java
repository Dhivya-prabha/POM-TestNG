package com.serviceNow.testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.serviceNow.pages.ArticlePage;
import com.serviceNow.pages.LoginPage;
import com.testleaf.testng.api.base.ProjectSpecificMethods;

public class Knowledge extends ProjectSpecificMethods {
	@BeforeTest
	void setReportDetails() {
		testcaseName = this.getClass().getSimpleName();
		testcaseDec = "Creating a new Caller";
		author = "Koushik";
		category = "Smoke";
	}

	@Test
	public void createKnwowledge() {
		String kbNumber = new LoginPage().login().enterOnFilterNavigator("Knowledge").clickOnKnowledge()
				.clickOnCreateAnArticle().getKBNumber();
		new ArticlePage().enterOnKnowledgeBase("IT").enteShortDescription("Dummmy desc").clickSubmit();
		System.out.println(kbNumber);
	}

}
