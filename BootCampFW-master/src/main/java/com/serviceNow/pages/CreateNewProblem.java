package com.serviceNow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class CreateNewProblem extends SeleniumBase {
	public CreateNewProblem() {
		PageFactory.initElements(getDriver(), this);
		defaultContent();
		switchToFrame(0);
	}

	@FindBy(how = How.ID, using = "problem.number")
	private WebElement probNum;

	public String getAttributeOfProb() {
		String probID = getTypedText(probNum);
		return probID;
	}

	@FindBy(how = How.ID, using = "problem.impact")
	private WebElement problemImpact;

	public CreateNewProblem selectProblemImpact(int index) {
		selectDropDownUsingIndex(problemImpact, index);
		return this;
	}

	@FindBy(how = How.ID, using = "problem.urgency")
	private WebElement problemUrgency;

	public CreateNewProblem selectProblemUrgency(int index) {
		selectDropDownUsingIndex(problemUrgency, index);
		return this;
	}

	@FindBy(how = How.ID, using = "sysverb_insert")
	private WebElement sysverb_insert;

	public SearchProblem clickSubmit() throws InterruptedException {
		click(sysverb_insert);
		return new SearchProblem();
	}

	@FindBy(how = How.ID, using = "sysverb_update")
	private WebElement sysverb_update;

	public SearchProblem clickUpdate() throws InterruptedException {
		click(sysverb_update);
		return new SearchProblem();
	}
	
	@FindBy(how = How.ID, using = "sysverb_delete")
	private WebElement sysverb_delete;

	public CreateNewProblem clickDelete() throws InterruptedException {
		click(sysverb_delete);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//button[@id='ok_button']")
	private WebElement accept_delete;

	public SearchProblem acceptDelete() throws InterruptedException {
		click(accept_delete);
		return new SearchProblem();
	}

	/**
	 * This is mandatory Field
	 */
	@FindBy(how = How.ID, using = "sys_display.problem.cmdb_ci")
	private WebElement configItem;
	public CreateNewProblem enterConfigItem(String str) throws InterruptedException {
		Thread.sleep(2000);
		clearAndType(configItem, str,Keys.ENTER);
		
		return this;
	}

	@FindBy(how = How.ID, using = "problem.short_description")
	private WebElement short_description;

	public CreateNewProblem enterShortDescription(String str) {
		clearAndType(short_description, str);
		return this;
	}

	@FindBy(how = How.ID, using = "activity-stream-work_notes-textarea")
	private WebElement workNotes;

	public CreateNewProblem enterWorkNotes(String str) {
		clearAndType(workNotes, str);
		return this;
	}

}
