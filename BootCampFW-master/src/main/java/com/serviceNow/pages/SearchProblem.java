package com.serviceNow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class SearchProblem extends SeleniumBase {
	public SearchProblem() {
		PageFactory.initElements(getDriver(), this);
		defaultContent();
		switchToFrame(0);
	}

	@FindBy(how = How.XPATH, using = "((//label[text()='Search'])[2]/following::input)[1]")
	private WebElement search;

	public SearchProblem searchProblemByNumber(String data) throws InterruptedException {
		Thread.sleep(2000);
		clearAndType(search, data, Keys.ENTER);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//a[@class='linked formlink']")
	private WebElement probNum;
	public SearchProblem verifyProblemCreated(String expectedText) {
		verifyExactText(probNum, expectedText);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//td[text()='No records to display']")
	private WebElement probNum1;
	public SearchProblem verifyProblemDeleted(String expectedText) {
		verifyExactText(probNum1, expectedText);
		return this;
	}
	
	@FindBy(how = How.XPATH, using = "//table[@id='problem_table']//tr[1]/td[9]")
	private WebElement probPriority;
	public SearchProblem verifyProblemPriority(String expectedText) {
		verifyExactText(probPriority, expectedText);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='Number']")
	private WebElement sortByNumber;
	public SearchProblem sortProblemByNumber() {
		String sortText = getElementText(sortByNumber);
		if (sortText.equals("Sorted in ascending order")) {
			System.out.println(sortText);
			// sort in descending order
			click(sortByNumber);
		}
		return this;
	}
	
	@FindBy(how = How.XPATH, using="//table[@id='problem_table']//tr[1]/td[3]/a")
	private WebElement firstProb;
	public String getFirstProbId() {
		String probID = getElementText(firstProb);
		return probID;
	}
	
	@FindBy(how = How.XPATH, using="//table[@id='problem_table']//tr[1]/td[3]/a")
	private WebElement firstProbId;
	public CreateNewProblem clickFirstProbId(){
		 click(firstProbId);
		 return new CreateNewProblem();
	}

}
