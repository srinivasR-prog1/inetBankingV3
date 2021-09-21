package com.inetBanking.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "uid")
	WebElement txtUserName;

	@FindBy(name = "password")
	WebElement txtPassword;

	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement btnSubmit;
	
	@FindBy(xpath="//a[text()='Log out']")
	@CacheLookup
	WebElement btnLogout;

	public void setUserName(String uname) {
		
		txtUserName.clear();

		txtUserName.sendKeys(uname);

	}
	
	public void setPassword(String pwd)
	{
		
		txtPassword.clear();
		
		txtPassword.sendKeys(pwd);
		
	}
	
	public void btnLogin()
	{
		
		btnSubmit.click();
		
		
	}
	
	public void btnLogOut()
	{
		
		btnLogout.click();
		
		
	}

}
