package com.actitime.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements AutoConstants
{
	public WebDriver driver;
	static
	{
		System.setProperty(chrome_key, chrome_value);
		System.setProperty(firefox_key, firefox_value);
	}

@BeforeMethod
public void preCondition()
{
	driver=new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.get("https://demo.actiTime.com");
	}

@AfterMethod
public void postCondition(ITestResult res)
{
	int status=res.getStatus();
	if(status==2)
	{
		String name=res.getName();
		GenericUtiles.takeScreenShot(driver, name);
	}
}
}
