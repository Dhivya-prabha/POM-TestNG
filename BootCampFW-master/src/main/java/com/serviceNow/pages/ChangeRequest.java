package com.serviceNow.pages;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.testng.api.base.ProjectSpecificMethods;
import com.testleaft.selenium.api.design.Locators;

public class ChangeRequest extends ProjectSpecificMethods{
	public ChangeRequest() {
		PageFactory.initElements(getDriver(), this);
		waitTillLoadCompletes();
	}
	public void waitTillLoadCompletes() {
		List<WebElement> loader = locateElements(Locators.XPATH, "//div[text()='Loading...']");
		if(loader.size() > 0) {
			verifyDisappeared(loader.get(0));
		}else {
			reportStep("loader is not handle", "info");
		}
	}
	@FindBy(how=How.XPATH , using="(//div[@class='container-fluid wizard-container']/a)[1]")
	private WebElement eleNormal;
	public CreateChangeNew clickNormalChange() throws InterruptedException {
		Thread.sleep(5000);
		click(eleNormal);
		return new CreateChangeNew();
	}
	@FindBy(how = How.XPATH , using="//select[@class='form-control']")
	private WebElement eletype;
	public ChangeRequest selecttype(String type) {
		selectDropDownUsingText(eletype, type);
		return this;
	}
	@FindBy(how = How.XPATH , using="//span[@class='sr-only']/following-sibling::input[1]")
	private WebElement elesearchBox;
	public ChangeRequest enterValue(String changeNumber) {
		clearAndType(elesearchBox, changeNumber,Keys.ENTER);
		return this;
	}
	
	@FindBy(how =How.XPATH , using = "//td[contains(@class,'list_decoration_cell col-small')]/following-sibling::td[1]")
	private WebElement eleGetChangeNumber;
	public ChangeRequest verifyLeadCreation(String changeNumber) {
		
		System.out.println(verifyPartialText(eleGetChangeNumber, changeNumber)?
				"Created":"Not Created");
		return this;
	}
}
