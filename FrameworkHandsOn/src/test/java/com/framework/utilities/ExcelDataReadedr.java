package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelDataReadedr {

	
	XSSFWorkbook workbook;
	//no return type for the constructor
	public ExcelDataReadedr() throws IOException
	{
		File excelFile=new File("F:\\Sathish\\gitCheckouts\\SeleniumConcepts\\FrameworkHandsOn\\TestData\\TestData.xlsx");
		FileInputStream fis=new FileInputStream(excelFile);
		workbook=new XSSFWorkbook(fis);
	}
	//this is method overloading 
	public String getStringData(String sheetName, int row, int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}

	public String getStringData(int sheetIndex, int row, int column)
	{
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
	}
	
	public double getNumericData(String sheetName, int row, int column)
	{
		return workbook.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	
	public double getNumericData(int sheetIndex, int row, int column)
	{
		return workbook.getSheetAt(sheetIndex).getRow(row).getCell(column).getNumericCellValue();
	}
	
	
}
