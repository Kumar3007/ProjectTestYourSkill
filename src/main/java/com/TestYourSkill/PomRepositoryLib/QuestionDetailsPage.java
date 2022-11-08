package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QuestionDetailsPage 
{
			
	@FindBy(xpath="//textarea[@placeholder='Write question number 1 here...']")
	private WebElement QuestionNumber1_tf;
	
	@FindBy(xpath="//input[@id=11 and @placeholder='Enter option a']")
	private WebElement OptionAofQuestion1_tf;
	
	@FindBy(xpath="//input[@id=12 and @placeholder='Enter option b']")
	private WebElement OptionBofQuestion1_tf;
	
	@FindBy(xpath="//input[@id=13 and @placeholder='Enter option c']")
	private WebElement OptionCofquestion1_tf;
	
	@FindBy(xpath="//input[@id=14 and @placeholder='Enter option d']")
	private WebElement OptionDofQuestion1_tf;

	// option drd @FindBy(xpath="")
	

//........................................................................quesyion 2//
	
	@FindBy(xpath="//textarea[@placeholder='Write question number 2 here...']")
	private WebElement QuestionNumber2_tf;
	
	@FindBy(xpath="//input[@id=21 and @placeholder='Enter option a']")
	private WebElement OptionAofQuestion2_tf;
	
	@FindBy(xpath="//input[@id=22 and @placeholder='Enter option b']")
	private WebElement OptionBofQuestion2_tf;
	
	@FindBy(xpath="//input[@id=23 and @placeholder='Enter option c']")
	private WebElement OptionCofquestion2_tf;
	
	@FindBy(xpath="//input[@id=24 and @placeholder='Enter option d']")
	private WebElement OptionDofQuestion2_tf;

	public WebElement getQuestionNumber2_tf() {
		return QuestionNumber2_tf;
	}
//..........................................................................................................Getter methods for Q1 and Q2//
	public WebElement getQuestionNumber1_tf() {
		return QuestionNumber1_tf;
	}

	public WebElement getOptionAofQuestion1_tf() {
		return OptionAofQuestion1_tf;
	}

	public WebElement getOptionBofQuestion1_tf() {
		return OptionBofQuestion1_tf;
	}

	public WebElement getOptionCofquestion1_tf() {
		return OptionCofquestion1_tf;
	}

	public WebElement getOptionDofQuestion1_tf() {
		return OptionDofQuestion1_tf;
	}

	public WebElement getOptionAofQuestion2_tf() {
		return OptionAofQuestion2_tf;
	}

	public WebElement getOptionBofQuestion2_tf() {
		return OptionBofQuestion2_tf;
	}

	public WebElement getOptionCofquestion2_tf() {
		return OptionCofquestion2_tf;
	}

	public WebElement getOptionDofQuestion2_tf() {
		return OptionDofQuestion2_tf;
	}

	
	// option drd @FindBy(xpath="")
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	private WebElement  submit_btn;

	public WebElement getSubmit_btn() {
		return submit_btn;
	}
	
	//page factory
	public QuestionDetailsPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void  Question1(String QuestionNumber1,String OptionAofQuestion1 , String OptionBofQuestion1,  String OptionCofquestion1 , String OptionDofQuestion1)
	{
		QuestionNumber1_tf.sendKeys(QuestionNumber1);
		OptionAofQuestion1_tf.sendKeys(OptionAofQuestion1);
		OptionBofQuestion1_tf.sendKeys(OptionBofQuestion1);
		OptionCofquestion1_tf.sendKeys(OptionCofquestion1);
		OptionDofQuestion1_tf.sendKeys(OptionDofQuestion1);
	}
	
	public void  Question2(String QuestionNumber2,String OptionAofQuestion2 , String OptionBofQuestion2,  String OptionCofquestion2 , String OptionDofQuestion2)
	{
		QuestionNumber2_tf.sendKeys(QuestionNumber2);
		OptionAofQuestion2_tf.sendKeys(OptionAofQuestion2);
		OptionBofQuestion2_tf.sendKeys(OptionBofQuestion2);
		OptionCofquestion2_tf.sendKeys(OptionCofquestion2);
		OptionDofQuestion2_tf.sendKeys(OptionDofQuestion2);
		
	}
	
	
	public void Submit()
	{
		submit_btn.click();
	}
	
}

