package com.framework.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BrowserFactory {

	//WebDriver driver;
	//return type is set as WebDriver bcoz once the broiwser is started we need the WebDriver which ll be returned
	// it is advisable to pass the webdriver as a parameter, so that only the respective browser ll be started
	public static WebDriver startApplication(WebDriver driver,String browserName, String appURL)

	{	
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);	
		}
		else if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",".\\Drivers\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		else if(browserName.equalsIgnoreCase("IE"))
		{
		
			System.setProperty("webdriver.ie.driver",".\\Drivers\\IEDriverServer_32Bit.exe");
			driver=new InternetExplorerDriver();
		}
		else
		{
			System.out.println("We don't support this browser");
		}
		driver.manage().window().maximize();
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	//It is better to pass the WebDriver as a Parameter, so that only the respective browser ll be closed.
public static void tearDown(WebDriver driver)
{
	driver.quit();
	
}
	
	
	
}
 