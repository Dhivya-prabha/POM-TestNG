package com.serviceNow.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class ArticlePage extends SeleniumBase {
	public ArticlePage() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame(0);
	}

	@FindBy(how = How.ID, using = "kb_knowledge.number")
	private WebElement kB;

	public String getKBNumber() {
		String text = getTypedText(kB);
		defaultContent();
		return text;
	}

	@FindBy(how = How.ID, using = "sys_display.kb_knowledge.kb_knowledge_base")
	private WebElement iT;

	public ArticlePage enterOnKnowledgeBase(String str) {
		clearAndType(iT, str, Keys.DOWN, Keys.ENTER);
		return this;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='icon icon-search']")
	private WebElement aNewRecord;

	public KnowledgeBasePopUp clickOnSearchIcon() {
		int retry = 0;
		clickWithNoSnap(aNewRecord);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (getDriver().getWindowHandles().size() > 0) {
			switchToWindow(1);
		} else if (retry < 2) {
			clickOnSearchIcon();
			retry++;
		}
		return new KnowledgeBasePopUp();
	}

	@FindBy(how = How.ID, using = "kb_knowledge.short_description")
	private WebElement ele;

	public ArticlePage enteShortDescription(String str) {
		clearAndType(ele, str);
		return this;
	}

	@FindBy(how = How.XPATH, using = "(//button[text()='Submit'])[1]")
	private WebElement sysverb_insert;

	public void clickSubmit() {
		click(sysverb_insert);
		// return page;
	}

	@FindBy(how = How.ID, using = "kb_knowledge.article_type")
	private WebElement kb_knowledgearticle_type;

	public void selectKb_knowledgearticle_type(String text) {
		selectDropDownUsingIndex(kb_knowledgearticle_type, 1);
	}
}
