package com.actitime.generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class GenericUtiles
{
	public static void takeScreenShot(WebDriver driver,String name)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./Screenshots/"+name+".png");
		try
		{
			Files.copy(src, dest);
		}
		catch(IOException e)
		{
		}
	}
		public static void selectByIndex(WebElement element,int index)
		{
			Select sel=new Select(element);
			sel.selectByIndex(index);
		}
		public static void selectByText(WebElement element,String text)
		{
			Select sel=new Select(element);
			sel.selectByVisibleText(text);
		}
	}
