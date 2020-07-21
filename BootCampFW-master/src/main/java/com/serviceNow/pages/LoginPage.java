package com.serviceNow.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testleaf.selenium.api.base.SeleniumBase;

public class LoginPage extends SeleniumBase {
	public LoginPage() {
		PageFactory.initElements(getDriver(), this);
		switchToFrame(0);
	}

	public HomePage login() {
		enterOnUser_name("admin");
		enterOnUser_password("India@123");
		clickOnLogin();
		return new HomePage();
	}

	@FindBy(how = How.ID, using = "user_name")
	private WebElement user_name;

	public LoginPage enterOnUser_name(String str) {
		clearAndType(user_name, str);
		return this;
	}

	@FindBy(how = How.ID, using = "user_password")
	private WebElement user_password;

	public LoginPage enterOnUser_password(String str) {
		clearAndType(user_password, str);
		return this;
	}

	@FindBy(how = How.ID, using = "sysverb_login")
	private WebElement login;

	public HomePage clickOnLogin() {
		click(login);
		return new HomePage();
	}

	@FindBy(how = How.LINK_TEXT, using = "Forgot Password ?")
	private WebElement forgotPassword;

	public PasswordResetPage clickOnForgotPassword() {
		click(forgotPassword);
		return new PasswordResetPage();
	}
}
