package com.takeScreensShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.apache.commons.io.FileUtils;


public class TakeScreenShotTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.gecko.driver", "F:\\Sathish\\geckodriver-v0.24.0-win64\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.facebook.com");
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File destination=new File("F:\\Sathish\\gitCheckouts\\SeleniumConcepts\\SeleniumConcepts\\src\\com\\takeScreensShot\\screenshots\\Facebook.jpg");
		FileUtils.copyFile(source, destination);
		
		driver.close();
		
		
		
	}

}
