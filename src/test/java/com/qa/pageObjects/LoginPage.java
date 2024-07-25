package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass {

	public LoginPage() {
		
		PageFactory.initElements(getDriver(), this);
	}

	@FindBy(xpath = "//input[@name='Email']")
	WebElement email;

	@FindBy(xpath = "//input[@name='Password']")
	WebElement password;

	@FindBy(xpath = "//button[text()='Log in']")
	WebElement loginButton;

	public void setEmail(String emailID) {
		email.sendKeys(emailID);
	}

	public void setPassword(String userPassword) {
		password.sendKeys(userPassword);
	}

	public void loginButtonClick() {
		loginButton.click();
	}
}
