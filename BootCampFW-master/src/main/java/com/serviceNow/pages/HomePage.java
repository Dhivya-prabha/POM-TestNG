package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;
import com.testleaft.selenium.api.design.Locators;

public class HomePage extends SeleniumBase {
	public HomePage() {
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

	@FindBy(how = How.ID, using = "filter")
	private WebElement filterNavigator;

	public HomePage enterOnFilterNavigator(String str) {
		clearAndType(filterNavigator, str);
		return this;
	}
	@FindBy(how = How.XPATH, using="(//div[text()='Incidents'])[1]")
	private WebElement eleIncidents;
	public Incidents clickIncidents() {
		click(eleIncidents);
		switchToFrame(0);
		return new Incidents();
	}

	@FindBy(how = How.XPATH, using = "//span[text()='Incident']/following::div[text()='Create New']")
	private WebElement createNew;

	public CreateNewIncident clickOnCreateNew() {
		click(createNew);
		return new CreateNewIncident();
	}

	@FindBy(how = How.XPATH, using = "//div[text()='Callers']")
	private WebElement callers;

	public Callers clickOnCallers() {
		click(callers);
		return new Callers();
	}
	@FindBy(how = How.XPATH, using = "//span[text()='Change']/following::div[1]")
	private WebElement eleNewChange;
	public ChangeRequest clickonCreateNewChange() {
		click(eleNewChange);
		switchToFrame(0);
		return new ChangeRequest();
	}
	@FindBy(how = How.XPATH, using="(//div[text()='Knowledge'])[1]")

	private WebElement knowledge;

	public KnowledgePage clickOnKnowledge() {
		click(knowledge);
		return new KnowledgePage();
	}

	@FindBy(how = How.XPATH, using = "(//div[text()='Create New'])[2]")
	private WebElement createNewProblem;

	public CreateNewProblem clickOnCreateNewProblem() {
		click(createNewProblem);
		return new CreateNewProblem();
	}

	@FindBy(how = How.XPATH, using = "(//div[text()='Open'])[2]")
	private WebElement openProblem;

	public SearchProblem clickOnOpenProblem() {
		click(openProblem);
		return new SearchProblem();
	}
	@FindBy(how = How.XPATH, using="(//div[text()='My Work'])[1]")
	private WebElement eleMyWork;
	public TaskPage clickMyWork() {
		click(eleMyWork);
		switchToFrame(0);
		return new TaskPage();
		
	}
	@FindBy(how = How.XPATH, using="(//div[@class='sn-widget-list-title'])[4]")
	private WebElement serviceCat;
	public ServiceCatalog clickServiceCatalog() {
		click(serviceCat);
		return new ServiceCatalog();
	}
	

}
