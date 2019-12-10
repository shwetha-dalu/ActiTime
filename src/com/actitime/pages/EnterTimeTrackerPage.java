package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.generic.BasePage;

public class EnterTimeTrackerPage extends BasePage
{
	//Declaration
	@FindBy(id= "logoutLink")
	private WebElement logOutLink;
	
	//Initialization
	public EnterTimeTrackerPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	//utilization
	public void clickOnLogOut()
	{
		logOutLink.click();
	}
}
