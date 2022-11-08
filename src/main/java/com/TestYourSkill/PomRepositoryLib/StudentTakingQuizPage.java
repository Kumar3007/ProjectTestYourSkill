package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class StudentTakingQuizPage
{
	@FindBy(xpath="//div[@class='panel']/child::form/child::input[@value='62da7556c3916']")
	private WebElement clickRbtn1;
	
	@FindBy(xpath="//div[@class='panel']/child::form/child::button[@class='btn btn-primary']")
	private WebElement submitbtn1;
	
	//...................................................................................................Q1//
	@FindBy(xpath="//div[@class='panel']/child::form/child::input[@value='62da755760195']")
	private WebElement clickRbtn2;
	
	@FindBy(xpath="//div[@class='panel']/child::form/child::button[@class='btn btn-primary']")
	private WebElement submitbtn2;
	
	//....................................................................................................Q2//
	@FindBy(xpath="//div[@class='panel']/child::form/child::input[@value='62da7557d8abc']")
	private WebElement clickRbtn3;
	
	@FindBy(xpath="//div[@class='panel']/child::form/child::button[@class='btn btn-primary']")
	private WebElement submitbtn3;

	//......................................................................................................Q3//
	
	public WebElement getClickRbtn1() {
		return clickRbtn1;
	}

	public WebElement getSubmitbtn1() {
		return submitbtn1;
	}

	public WebElement getClickRbtn2() {
		return clickRbtn2;
	}

	public WebElement getSubmitbtn2() {
		return submitbtn2;
	}

	public WebElement getClickRbtn3() {
		return clickRbtn3;
	}

	public WebElement getSubmitbtn3() {
		return submitbtn3;
	}
	
	public StudentTakingQuizPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void StudentAttendQuiz()
	{
		clickRbtn1.click();
		submitbtn1.click();
		clickRbtn2.click();
		submitbtn2.click();
		clickRbtn3.click();
		submitbtn3.click();
		
		
	}
	
}
