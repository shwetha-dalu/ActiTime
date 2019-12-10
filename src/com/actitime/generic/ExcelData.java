package com.actitime.generic;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	public static String getData(String file_path,String sheet_name,int rn,int cn)
	{
		try {
			FileInputStream file=new FileInputStream(new File(file_path));
			String data=WorkbookFactory.create(file).getSheet(sheet_name).getRow(rn).getCell(cn).toString();
			return data;
			}
		catch(Exception e)
		{
			return "";
			}
	}
	public static int getRowNum(String file_path,String sheetName)
	{
		try
		{
			int rc=WorkbookFactory.create(new FileInputStream(file_path)).getSheet(sheetName).getLastRowNum();
			return rc;
			}
		catch(Exception e)
		{
			return 0;
		}
	}
}
