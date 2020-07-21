package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class KnowledgeBasePopUp extends SeleniumBase{
	public KnowledgeBasePopUp() {
		PageFactory.initElements(getDriver(), this);
//		switchToFrame(0);
	}
	@FindBy(how = How.LINK_TEXT, using="IT")
	private WebElement iT;
	public ArticlePage clickOnIT(){
		clickWithNoSnap(iT);
		switchToWindow(0);
		return new ArticlePage();
	}
}
