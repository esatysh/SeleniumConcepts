package com.framework.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.framework.utilities.BrowserFactory;
import com.framework.utilities.ConfigDataProvider;
import com.framework.utilities.ExcelDataReadedr;
import com.framework.utilities.Helper;

public class BaseClass {

	public WebDriver driver;
	public ExcelDataReadedr excel; 
	public ConfigDataProvider config;
	public ExtentReports extent;
	public ExtentTest logger;
   
	
	@BeforeSuite
	public void setupSuite() throws IOException
	{
		excel=new ExcelDataReadedr();
		config=new ConfigDataProvider();
		ExtentHtmlReporter report=new ExtentHtmlReporter(new File(System.getProperty("user.dir"))+"\\Reports\\FreeCRM\\Report_"+Helper.getCurrentDateTime()+".html" );
		extent=new ExtentReports();
		extent.attachReporter(report);
	}
		
	@BeforeClass
	public void setup()
	{
		driver=BrowserFactory.startApplication(driver, config.getBrowserFromConfig(), config.getAppURLFromConfig());
	}
		
	@AfterClass
	public void tearDown(){
		BrowserFactory.tearDown(driver);
	}
	
	@AfterMethod
	public void tearDownMethod(ITestResult result) throws IOException
	{
		if (result.getStatus()==ITestResult.FAILURE)
		{
				
			logger.fail("Failed test case", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
			//logger.fail("Failed test case", MediaEntityBuilder.createScreenCaptureFromBase64String(Helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS)
		{
			logger.pass("Passed test case", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
		}
		extent.flush();
	
		
	}
	
	
	
}
