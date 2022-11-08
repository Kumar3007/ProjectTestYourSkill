package com.TestYourSkill.PomRepositoryLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Admin_Homepage 
{
@FindBy(xpath="//a[text()='Quiz']")
private WebElement Quiz_drd;

@FindBy(xpath="//a[text()='Add Quiz']")
private WebElement AddQuiz_btn;

@FindBy(xpath="")
private WebElement RemoveQuiz_btn;

public WebElement getQuiz_drd() {
	return Quiz_drd;
}

public WebElement getAddQuiz_btn() {
	return AddQuiz_btn;
}

public WebElement getRemoveQuiz_btn() {
	return RemoveQuiz_btn;
}

public Admin_Homepage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}

public void AddQuiz()
{
	Quiz_drd.click();
	AddQuiz_btn.click();
}

public void Removequiz() {
	Quiz_drd.click();
	RemoveQuiz_btn.click();
}



}

