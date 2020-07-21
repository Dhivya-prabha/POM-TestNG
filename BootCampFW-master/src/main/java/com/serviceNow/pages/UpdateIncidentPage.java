package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class UpdateIncidentPage extends ProjectSpecificMethods {
	public UpdateIncidentPage() {
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

	@FindBy(how = How.ID, using = "incident.urgency")
	private WebElement eleUrgency;

	public UpdateIncidentPage updateUrgency(String value) {
		selectDropDownUsingText(eleUrgency, value);
		return this;
	}

	@FindBy(how = How.ID, using = "incident.state")
	private WebElement eleState;

	public UpdateIncidentPage updateState(String value) {
		selectDropDownUsingText(eleState, value);
		return this;
	}
	@FindBy(how = How.ID, using="sysverb_update")
	private WebElement eleUpdate;
	public Incidents clickUpdate() {
		click(eleUpdate);
		return new Incidents();
	}
	
	

}
