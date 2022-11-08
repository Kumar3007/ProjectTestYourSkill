package com.TestNgPractice;

import org.testng.annotations.Test;

public class StudentModuleTests 
{
	@Test(priority=1)
	public void StudentSignup()
	{
		System.out.println("Enter all the Mandatory Details for student for Signup");
	}
	

	@Test(priority=6)
	public void StudentGivingFeedBack()
	{
		System.out.println("Student Giving FeedBack to the Admin");
	}
	
	@Test(priority=2)
	public void StudentHomePage()
	{
		System.out.println("Student HomePage");
		
	}
	
	@Test(priority=3)
	public void StudentTakingQuiz()
	{
		System.out.println("Student taking AGILE METHODOLOGY QUIZ");
	}
	
	@Test(priority=4)
	public void StudentCheckingRank()
	{
		System.out.println("Student Checking his rank in Ranking Module");
	}
	
	@Test(priority=5)
	public void StudentHistory()
	{
		System.out.println("student checking his test in History Module");
	}
}
