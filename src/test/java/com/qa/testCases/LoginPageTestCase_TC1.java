package com.qa.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.pageObjects.BaseClass;
import com.qa.pageObjects.LoginPage;
import com.qa.utilities.XLUtils;

public class LoginPageTestCase_TC1 extends BaseClass {
	LoginPage lp;
	public String DataSheet = "./TestData/TestDataSheet.xlsx";

	@Test(dataProvider = "LoginData")
	public void loginTest(String user, String pwd) {
		lp = new LoginPage(driver);
		lp.setEmail(user);
		logger.info("Email id is entered");
		lp.setPassword(pwd);
		logger.info("Password  is entered");
		lp.loginButtonClick();
		logger.info("clicked on Login Button");
		String titleOfPage = driver.getTitle();
		Assert.assertTrue(titleOfPage.equals("nopCommerce demo store. Login"));
	}

	@DataProvider(name = "LoginData")
	String[][] getData() throws IOException {
		int rownum = XLUtils.getRowCount(DataSheet, "LoginData");
		int colnum = XLUtils.getCellCount(DataSheet, "LoginData", 1);

		String logindata[][] = new String[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			for (int j = 0; j < colnum; j++) {
				logindata[i - 1][j] = XLUtils.getCellData(DataSheet, "LoginData", i, j);
			}
		}
		return logindata;

	}
}
