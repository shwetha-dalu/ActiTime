package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;
import com.actitime.generic.ExcelData;
import com.actitime.pages.LoginPage;

public class InvalidLoginTest extends BaseTest
{
	@Test(priority=2)
	public void testInvalidLogin() throws InterruptedException
	{
		String loginTitle= ExcelData.getData(file_path, "TC01", 1, 2);
		String eErrorMsg=ExcelData.getData(file_path, "TC02", 1, 2);
		int rc=ExcelData.getRowNum(file_path, "TC02");
		LoginPage lp=new LoginPage(driver);
		
		//verify login title
		lp.verifyPageTitle(loginTitle);
		for(int i=1;i<=rc;i++)
		{
			String un=ExcelData.getData(file_path, "TC02", i, 0);
			String pw=ExcelData.getData(file_path, "TC02", i, 1);
			
			//enter Invalid User name
			lp.enterUsername(un);
			Reporter.log("Invalid Username: ",true);
			
			//Enter Invalid password
			lp.enterPassword(pw);
			Reporter.log("Invalid password: ",true);
			
			//Click on Login button
			lp.clickOnLogin();
			
			//Verify Error Message
			String aErrorMsg=lp.verifyErrorMsg();
			Reporter.log("Actual Error message :"+aErrorMsg,true);
			Reporter.log(" Expected Error message: "+eErrorMsg,true);
			
			Assert.assertEquals(aErrorMsg,eErrorMsg);
			Reporter.log("Both Error Messages are Matching.....",true);
			Reporter.log("================================",true);
			Thread.sleep(1000);
		}
	}
}
