package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentHomePage //Rule 1:   Create a separate java class for every page in a application
{
	//Rule2: Identify all the elements using @findBy , @findbys , @findAll(Declaration)
	
	@FindBy(xpath="//td[text()='Agile Methedology']/parent::tr/child::td[6]//b[text()='Start']")
	private WebElement StartBtn;
	
	//Rule3: Execute all the elements and initilize the elements
	public StudentHomePage(WebDriver driver)			 
	{
		PageFactory.initElements(driver, this);
	}

	//Rule4: Declare all the elements as private and provide getters method,business method for(utilization)
	public WebElement getStartBtn() {
		return StartBtn;
	}
	
	public void StartQuiz() 
	{
		StartBtn.click();
	}
	
}

