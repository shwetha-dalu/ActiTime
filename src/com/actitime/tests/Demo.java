package com.actitime.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.actitime.generic.BaseTest;

public class Demo extends BaseTest
{
	@Test
	public void testA()
	{
		Reporter.log("Hi..!",true);
		Assert.fail();
	}
	
}
