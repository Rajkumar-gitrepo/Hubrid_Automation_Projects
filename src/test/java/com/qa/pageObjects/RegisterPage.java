package com.qa.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage extends BaseClass {

	public RegisterPage() {
		
		PageFactory.initElements(getDriver(), this);

	}

	@FindBy(xpath = "//*[text()='Register']")
	WebElement registerLink;

	public void registrationLink() {
		registerLink.click();
	}
}
