package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentSignOut
{
	@FindBy(xpath="//li[@class='pull-right']")
	private WebElement signout_btn;

	
	public WebElement getSignout_btn() {
		return signout_btn;
	}


	public StudentSignOut(WebDriver  driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void Signout()
	{
		signout_btn.click();
	}
	
}
