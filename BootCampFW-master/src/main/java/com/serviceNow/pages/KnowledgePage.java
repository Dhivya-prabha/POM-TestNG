package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class KnowledgePage extends SeleniumBase {
	public KnowledgePage() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame(0);
	}
	@FindBy(how = How.XPATH, using="//button[@data-original-title='Create an Article']//span[1]")
	private WebElement createAnArticle;
	public ArticlePage clickOnCreateAnArticle(){
		click(createAnArticle);
	defaultContent();
	return new ArticlePage();
	}
	@FindBy(how = How.XPATH, using="//button[@data-original-title='Post a Question']")
	private WebElement postAQuestion;
	public void clickOnPostAQuestion(){
		click(postAQuestion);	
	//return page;
	}

}
