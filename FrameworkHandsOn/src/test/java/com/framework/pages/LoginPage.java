package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	//a constructor cannot return anything, not even void
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
				
	}
	
	//using the PagteFactory FindBy method as it is advisable to use this when using Page Object model
	@FindBy(name="username") WebElement uname;
	
	@FindBy(name="password") WebElement pwd;
	
	@FindBy(xpath="//input[@value='Login']") WebElement loginButton;
	
	
	public void enterUserName(String username)
	{
		uname.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		pwd.sendKeys(password);
	}
	
	public void clickLoginButton()
	{
		//loginButton.click();
		Actions act=new Actions(driver);
		act.moveToElement(loginButton).click().build().perform();
		
	}
	
	
	
	
	
}
