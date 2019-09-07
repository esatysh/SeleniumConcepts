package com.framework.utilities;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Helper {

	public static String captureScreenshot(WebDriver driver) {
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshots\\" + getCurrentDateTime()+".png";
		System.out.println("Screenshot path is : "+screenshotPath);
		TakesScreenshot scrnShot = (TakesScreenshot) driver;
		File scrnShotSrc = scrnShot.getScreenshotAs(OutputType.FILE);
		File scrnShotFile = new File(screenshotPath);
		// FileUtils.CopyFile()
		// FileUtils.CopyFile(scrnShotSrcscrnShotFile,)
		try {
			FileHandler.copy(scrnShotSrc, scrnShotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			// e.printStackTrace();
			System.out.println("Unable to capture Screenshot. The Exception is : " + e);

		}
return screenshotPath;
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat=new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate=new Date();
		return customFormat.format(currentDate);
		
		
		
	}
	
	
}
