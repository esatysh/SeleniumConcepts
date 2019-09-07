package com.framework.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {

	Properties propertyObj;

	public ConfigDataProvider() 
	{
		File src = new File("F:\\Sathish\\gitCheckouts\\SeleniumConcepts\\FrameworkHandsOn\\Config\\Config.properties");
		FileInputStream fis;
		try 
		{

			fis = new FileInputStream(src);
			propertyObj = new Properties();
			propertyObj.load(fis);
		}

		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			System.out.println(" " + e);
		}
	}
	
	public String getBrowserFromConfig()
	{
		System.out.println("Browser is :"+propertyObj.getProperty("Browser"));
		return propertyObj.getProperty("Browser");
		
		
	} 

	public String getAppURLFromConfig()
	{
		return propertyObj.getProperty("Url");
		
	}
}
