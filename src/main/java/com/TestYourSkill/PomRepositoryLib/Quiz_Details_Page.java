package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Quiz_Details_Page
{

	@FindBy(xpath="//input[@placeholder='Enter Quiz title']")
	private WebElement QuizTitle_tf ;

	@FindBy(xpath="//input[@placeholder='Enter total number of questions']")
	private WebElement NoOfQuestions_tf;

	@FindBy(xpath="//input[@placeholder='Enter marks on right answer']")
	private WebElement MarksForRightAns_tf;

	@FindBy(xpath="//input[@placeholder='Enter minus marks on wrong answer without sign']")
	private WebElement MarksforWrongAnswer_tf;

	@FindBy(xpath="//input[@placeholder='Enter time limit for test in minute']")
	private WebElement TimeLimit_tf;

	@FindBy(xpath="//input[@placeholder='Enter #tag which is used for searching']")
	private WebElement TagName_tf;

	@FindBy(xpath="//textarea[@placeholder='Write description here...']")
	private WebElement Description_taf;

	@FindBy(xpath="//input[@type='submit']")
	private WebElement Submit_btn;

	public WebElement getQuizTitle_tf() {
		return QuizTitle_tf;
	}

	public WebElement getNoOfQuestions_tf() {
		return NoOfQuestions_tf;
	}

	public WebElement getMarksForRightAns_tf() {
		return MarksForRightAns_tf;
	}

	public WebElement getMarksforWrongAnswer_tf() {
		return MarksforWrongAnswer_tf;
	}

	public WebElement getTimeLimit_tf() {
		return TimeLimit_tf;
	}

	public WebElement getTagName_tf() {
		return TagName_tf;
	}

	public WebElement getDescription_taf() {
		return Description_taf;
	}

	public WebElement getSubmit_btn() {
		return Submit_btn;
	}

	public Quiz_Details_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public void Quiz_Details(String QuizTitle,String NoOfQuestions,String MarksForRightAns, String MarksforWrongAnswer,String TimeLimit, String TagName,String Description)
	{
		QuizTitle_tf.sendKeys(QuizTitle);
		NoOfQuestions_tf.sendKeys(NoOfQuestions);
		MarksForRightAns_tf.sendKeys(MarksForRightAns);
		MarksforWrongAnswer_tf.sendKeys(MarksforWrongAnswer);
		TimeLimit_tf.sendKeys(TimeLimit);
		TagName_tf.sendKeys(TagName);
		Description_taf.sendKeys(Description);
		Submit_btn.click();

	}
}
