package com.qa.testCases;

import org.testng.annotations.Test;

import com.qa.pageObjects.BaseClass;
import com.qa.pageObjects.RegisterPage;

public class RegistrationPageTestCase_TC2 extends BaseClass {
	RegisterPage rp;
	@Test
	public void registerTest()
	{
		rp = new RegisterPage();
		rp.registrationLink();
	}
}
