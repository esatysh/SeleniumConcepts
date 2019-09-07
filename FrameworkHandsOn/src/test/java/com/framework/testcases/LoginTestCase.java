package com.framework.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.framework.pages.BaseClass;
import com.framework.pages.LoginPage;
import com.framework.utilities.BrowserFactory;
import com.framework.utilities.ExcelDataReadedr;
import com.framework.utilities.Helper;

public class LoginTestCase extends BaseClass {

		
	@Test
	public void loginApp() throws IOException
	{
		Reporter.log("Login Test Started", true);
		logger=extent.createTest("Login Test");
		
		String username=excel.getStringData("login", 0,0);
		System.out.println(username);
		String pwd=excel.getStringData("login", 0, 1);
		System.out.println(pwd);
		
		
		String title=driver.getTitle();
		System.out.println(" "+title);
		
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		logger.info("Application Started");
		loginPage.enterUserName(username);
		Reporter.log("User name enetred", true);
		logger.info("Entered username");
		loginPage.enterPassword(pwd);
		Reporter.log("Password entered", true);
		logger.info("Entered password");
		//loginPage.enterUserName("AccidentalTester");
		//loginPage.enterPassword("Abcd@123456");
		loginPage.clickLoginButton();
		Reporter.log("Login button clicked", true);
		logger.info("clicked on login button");
		logger.fail("click failed");
		//Action act=new Action(driver);
				
	}
	
	@Test
	public void testMethod2()
	{
		logger=extent.createTest("Login Test2");
		logger.info("Inside second test");
		logger.fail("Inside second test");
	}
	
	
}
