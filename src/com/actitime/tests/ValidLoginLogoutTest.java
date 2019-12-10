package com.actitime.tests;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.EnterTimeTrackerPage;
import com.actitime.pages.LoginPage;

public class ValidLoginLogoutTest extends BaseTest {
	@Test(priority = 1)
	public void testValidLoginLogout() {
		// to read excel sheet
		String loginTitle = ExcelData.getData(file_path, "TC01", 1, 2);
		String un = ExcelData.getData(file_path, "TC01", 1, 0);
		String pw = ExcelData.getData(file_path, "TC01", 1, 1);
		String enterTitle = ExcelData.getData(file_path, "TC01", 1, 3);

		LoginPage lp = new LoginPage(driver);
		EnterTimeTrackerPage ep = new EnterTimeTrackerPage(driver);

		// verify login title
		lp.verifyPageTitle(loginTitle);

		// enter Valid user name
		lp.enterUsername(un);
		Reporter.log("valid Username: " + un, true);

		// Enter Valid password
		lp.enterPassword(pw);
		Reporter.log("valid password: " + pw, true);

		// Click on Login button
		lp.clickOnLogin();

		// Verify entered Title
		lp.verifyPageTitle(enterTitle);

		// Click on log out button
		ep.clickOnLogOut();

		// verify login Title
		lp.verifyPageTitle(loginTitle);
	}
}
