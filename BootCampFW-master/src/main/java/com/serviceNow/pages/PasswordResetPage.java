package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.testleaf.selenium.api.base.SeleniumBase;

public class PasswordResetPage extends SeleniumBase{
	@FindBy(how = How.ID, using="sysparm_user_id_0")
	private WebElement sysparm_user_id_;
	public PasswordResetPage enterOnSysparm_user_id_(String str){
		clearAndType(sysparm_user_id_,str);
		return this;
	}
	@FindBy(how = How.ID, using="sysverb_pwd_reset")
	private WebElement next;
	public PasswordResetPage clickOnNext(){
		click(next);
		return this;
	}

}
