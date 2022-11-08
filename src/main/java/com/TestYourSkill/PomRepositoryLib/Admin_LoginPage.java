package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_LoginPage { //Rule 1: Create a separate java class for every page in a application

	//Rule 2: Identify elements and getter methods
	@FindBy(xpath="//a[text()='Admin Login']")
	private WebElement adminlogin_btn;
	
	@FindBy(name="uname")
	private WebElement admin_name;
	
	@FindBy(xpath="//form[@method='post']/descendant::input[@name='password']")
	private WebElement admin_password;
	
	@FindBy(name="login")
	private WebElement login_btn;

	public WebElement getAdminlogin_btn() {
		return adminlogin_btn;
	}

	public WebElement getAdmin_name() {
		return admin_name;
	}

	public WebElement getAdmin_password() {
		return admin_password;
	}

	public WebElement getLogin_btn() {
		return login_btn;
	}
	
	//Rule 3: execute all the elements & initialize the elements PageFactory.initElements[inotialization] 
	public Admin_LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// Rule 4: Create methods
	public void AdminLoginPage(String ADMINLOGIN, String ADMINPASSWORD)
	{
		adminlogin_btn.click();
		admin_name.sendKeys(ADMINLOGIN);
		admin_password.sendKeys(ADMINPASSWORD);
		login_btn.click();
	}
	
}


