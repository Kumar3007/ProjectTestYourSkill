package com.TestNgPractice;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.TestYourSkill.GenericUtility.BaseClass;
import com.TestYourSkill.GenericUtility.BaseClass2;
import com.TestYourSkill.PomRepositoryLib.Admin_LoginPage;
import com.TestYourSkill.PomRepositoryLib.LoginPage;
import com.TestYourSkill.PomRepositoryLib.StudentHomePage;
import com.TestYourSkill.PomRepositoryLib.StudentSignOut;
import com.TestYourSkill.PomRepositoryLib.StudentTakingQuizPage;
import com.TestYourSkill_StudentTests.StudentTakeTest;


public class StudentModule3_retry extends BaseClass2
{
				@Test(priority=1,groups="Smoke",retryAnalyzer=com.TestYourSkill.GenericUtility.RetryImpClass.class)
				public void SignUp() throws Throwable
				{
					//get random number
				   	int intRanNum = javalib.getRanDomNumber();
				   	
					//Excel data
				 	String EnterYourName = exlib.getExcelData("Sheet1", 1, 2);
				   	String EnterYourCollegeName = exlib.getExcelData("Sheet1", 1, 3);
				   	String EnterYourEmail = exlib.getExcelData("Sheet1", 1, 4)+intRanNum;
				   	String EnterYourMobileno = exlib.getExcelData("Sheet1", 1, 5);
				   	String EnterYourPassword = exlib.getExcelData("Sheet1", 1, 6);
				   	String ConfirmPassword = exlib.getExcelData("Sheet1", 1, 7); 
				   	String gender="Male";
				   	
				   	LoginPage LP = new LoginPage(driver);
				   	LP.LoginToTheApp(EnterYourName, gender, EnterYourCollegeName, EnterYourEmail, EnterYourMobileno, EnterYourPassword, ConfirmPassword);
				   	
				   	//validating Student SignUp
				   	String actUrl=driver.getCurrentUrl();
				   	String ExpUrl="http://192.168.0.190/domain/Online_Examination_System/account.php?q=";
				   	Assert.assertEquals(actUrl, ExpUrl);
				   	System.out.println("Student Login Successfull");
				  
				}
				
				
				@Test(priority=2, groups="Smoke")
				public void SttdHomePage()
				{
				StudentHomePage SHP = new StudentHomePage(driver);
				SHP.StartQuiz();
					
				}
				
				@Test(priority=3,groups="Regression")
				public void stdTakingQuiz()
				{
					StudentTakingQuizPage STT = new StudentTakingQuizPage(driver);
					STT.StudentAttendQuiz();
				}
				
				@Test(priority=4,groups="Smoke")
				public void StdLogOut() throws Throwable
				{
					StudentSignOut LogOut = new StudentSignOut(driver);
					LogOut.Signout();
				Thread.sleep(3000);
				}
				
				@Test(priority=5,groups="Smoke")
				public void AdnLogin() throws Throwable 
				{
					
				String ADMINLOGIN = filelib.getPropertyKeyValue("adminlogin");
				String ADMINPASSWORD = filelib.getPropertyKeyValue("Apassword");
					
				Admin_LoginPage AL = new Admin_LoginPage(driver);
				AL.AdminLoginPage(ADMINLOGIN, ADMINPASSWORD);
				}
				
				
				
				
				
}
