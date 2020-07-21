package com.serviceNow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class CreateNewIncident extends SeleniumBase {
	public CreateNewIncident() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame(0);
	}
	@FindBy(how = How.ID, using="incident.number")
	private WebElement iNC;
	public String getAttributeOfINC(){
		 String typedText = getTypedText(iNC);
		 defaultContent();
		 return typedText;
	}
	/**
	 * This is mandatory Field
	 */
	@FindBy(how = How.ID, using="sys_display.incident.caller_id")
	private WebElement caller_id;
	public CreateNewIncident enterOnCaller(String str){
		clearAndType(caller_id,str, Keys.DOWN, Keys.ENTER);
		return this;
	}
	@FindBy(how = How.ID, using="incident.category")
	private WebElement incidentcategory;
	public CreateNewIncident selectIncidentcategory (String text){
		selectDropDownUsingText(incidentcategory, text);
		return this;
	}
	@FindBy(how = How.ID, using="incident.subcategory")
	private WebElement incidentsubcategory;
	public CreateNewIncident selectIncidentsubcategory (String text){
		selectDropDownUsingText(incidentsubcategory, text);
		return this;
	}
	@FindBy(how = How.ID, using="incident.contact_type")
	private WebElement incidentcontact_type;
	public CreateNewIncident selectIncidentcontact_type (String text){
		selectDropDownUsingText(incidentcontact_type, text);
		return this;
	}
	/**
	 * This is mandatory Field
	 */
	@FindBy(how = How.ID, using="incident.short_description")
	private WebElement short_description;
	public CreateNewIncident enterShortDescription(String str){
		clearAndType(short_description,str);
		return this;
	}
	@FindBy(how = How.XPATH, using="(//button[@id='sysverb_insert'])[1]")
	private WebElement sysverb_insert;
	public SearchIncident clickSubmit(){
		click(sysverb_insert);
	return new SearchIncident();
	}


}
