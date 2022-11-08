package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage   //Rule 1:   Create a separate java class for every page in a application

{
	//Rule2: Identify all the elements using @findBy , @findbys , @findAll(Declaration)
	
	@FindBy(id="name")
	private WebElement EnterYourNameEdt;
	
	@FindBy(id="gender")
	private WebElement genderEdt;
	
	@FindBy(id="college")
	private WebElement EnterYourCollegeNameEdt;
	
	@FindBy(xpath="(//input[@id='email'])[2]")
	private WebElement EnterYourEmailEdt;
	
	@FindBy(xpath="//input[@id='mob']")
	private WebElement EnterYourMobilenoEdt;
	
	@FindBy(xpath="//input[@placeholder='Enter your password']")
	private WebElement EnterYourPasswordEdt;
	
	@FindBy(id="cpassword")
	private WebElement ConfirmPasswordEdt;
	
	@FindBy(xpath="//input[@class='sub']")
	private WebElement clickEdt;
	
	
	
	
	//Rule 3: Execute all the elements and initilize the elements
	public LoginPage(WebDriver driver)			 
	{
		PageFactory.initElements(driver, this);
	}

	//Rule 4: Declare all the elements as private and provide getters method,business method for(utilization)
	
	public WebElement getEnterYourName() {
		return EnterYourNameEdt;
	}


	public WebElement getGender() {
		return genderEdt;
	}


	public WebElement getEnterYourCollegeName() {
		return EnterYourCollegeNameEdt;
	}


	public WebElement getEnterYourEmail() {
		return EnterYourEmailEdt;
	}


	public WebElement getEnterYourMobileno() {
		return EnterYourMobilenoEdt;
	}


	public WebElement getEnterYourPassword() {
		return EnterYourPasswordEdt;
	}


	public WebElement getConfirmPassword() {
		return ConfirmPasswordEdt;
	}


	public WebElement getClick() {
		return clickEdt;
	}
	
	//Step1:loginToTheApplication
	
	public void LoginToTheApp(String EnterYourName,String gender, String EnterYourCollegeName,String EnterYourEmail,String EnterYourMobileno,String EnterYourPassword,String ConfirmPassword)
	{
		EnterYourNameEdt.sendKeys(EnterYourName);
		genderEdt.sendKeys(gender);
		EnterYourCollegeNameEdt.sendKeys(EnterYourCollegeName);
		EnterYourEmailEdt.sendKeys(EnterYourEmail);
		EnterYourMobilenoEdt.sendKeys(EnterYourMobileno);
		EnterYourPasswordEdt.sendKeys(EnterYourPassword);
		ConfirmPasswordEdt.sendKeys(ConfirmPassword);
		clickEdt.click();
	}
	
	
	
	
	
}
