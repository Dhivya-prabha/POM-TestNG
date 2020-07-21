package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class Incidents extends ProjectSpecificMethods{
	public Incidents() {
		PageFactory.initElements(getDriver(), this);
		waitTillLoadCompletes();
	}

	public void waitTillLoadCompletes() {
		List<WebElement> loader = locateElements(Locators.XPATH, "//div[text()='Loading...']");
		if (loader.size() > 0) {
			verifyDisappeared(loader.get(0));
		} else {
			reportStep("loader is not handle", "info");
		}
	}
	@FindBy(how =How.XPATH, using="//select[@class='form-control']")
	private WebElement eleSearchType;
	public Incidents chooseSearchType(String type) {
		selectDropDownUsingText(eleSearchType, type);
		return this;
	}
	@FindBy(how = How.XPATH, using="(//input[@class='form-control'])[1]")
	private WebElement eleSearchBox;
	public Incidents enterIncidentNumber(String IncidentNumber) throws InterruptedException {
		clearAndType(eleSearchBox, IncidentNumber,Keys.ENTER);
		Thread.sleep(3000);
		return this;
	}
	@FindBy(how = How.XPATH, using="//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td/a[1]")
	private WebElement eleFirstIncident;
		public UpdateIncidentPage clickFirstIncidentNumber(String incidentNumber) {
			click(eleFirstIncident);
			return new UpdateIncidentPage();
			
		}
		@FindBy(how=How.XPATH, using="//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td[4]")
		private WebElement eleIncidentstate;
		public Incidents verifyUpdatedState(String state) {
			verifyPartialText(eleIncidentstate, state);
			return this;
		}
	
	
	
	
	
	
	
	
	
	
	
	
}
