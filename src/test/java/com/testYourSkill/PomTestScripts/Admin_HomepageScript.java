//package com.testYourSkill.PomTestScripts;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//
//import com.TestYourSkill.GenericUtility.ExcelUtility;
//import com.TestYourSkill.GenericUtility.FileUtility;
//import com.TestYourSkill.GenericUtility.JavaUtility;
//import com.TestYourSkill.GenericUtility.WebDriverUtlity;
//import com.TestYourSkill.PomRepositoryLib.Admin_Homepage;
//import com.TestYourSkill.PomRepositoryLib.Admin_LoginPage;
//import com.TestYourSkill.PomRepositoryLib.LoginPage;
//import com.TestYourSkill.PomRepositoryLib.QuestionDetailsPage;
//import com.TestYourSkill.PomRepositoryLib.Quiz_Details_Page;
//import com.TestYourSkill.PomRepositoryLib.StudentHomePage;
//import com.TestYourSkill.PomRepositoryLib.StudentTakingQuizPage;
//
//import io.github.bonigarcia.wdm.WebDriverManager;
//
//public class Admin_HomepageScript 
//{
//	public static void main(String[] args) throws Throwable {
//		
//		
//		FirefoxDriver driver=null;
//		//create an objects for Generic Uitility
//			ExcelUtility exlib = new ExcelUtility();
//			FileUtility filelib = new FileUtility();
//			JavaUtility javalib = new JavaUtility();
//			WebDriverUtlity weblib = new WebDriverUtlity();
//		
//			//Step 1:Read all the necessary common data
//			String URL = filelib.getPropertyKeyValue("url")	;
//			String ADMINLOGIN = filelib.getPropertyKeyValue("adminlogin");
//			String ADMINPASSWORD = filelib.getPropertyKeyValue("Apassword");
//			String BROWSER = filelib.getPropertyKeyValue("browser");
//			
//			//Step 2:Read all the data from excel sheet
//			String QuizTitle = exlib.getExcelData("Sheet1", 10, 2);
//			String NoOfQuestions = exlib.getExcelData("Sheet1", 10, 3);
//			String MarksForRightAns = exlib.getExcelData("Sheet1", 10, 4);
//			String MarksforWrongAnswer = exlib.getExcelData("Sheet1", 10, 5);
//			String TimeLimit = exlib.getExcelData("Sheet1", 10, 6);
//			String TagName = exlib.getExcelData("Sheet1", 10, 7);
//			String Description = exlib.getExcelData("Sheet1", 10, 8);
//			String QuestionNumber1 = exlib.getExcelData("Sheet1", 10, 9);
//			String OptionAofQuestion1 = exlib.getExcelData("Sheet1", 10, 10);
//			String OptionBofQuestion1 = exlib.getExcelData("Sheet1", 10, 11);
//			String OptionCofquestion1 = exlib.getExcelData("Sheet1", 10, 12);
//			String OptionDofQuestion1 = exlib.getExcelData("Sheet1", 10, 13);
//			String QuestionNumber2 = exlib.getExcelData("Sheet1", 10, 14);
//			String OptionAofQuestion2 = exlib.getExcelData("Sheet1", 10, 15);
//			String OptionBofQuestion2 = exlib.getExcelData("Sheet1", 10, 16);
//			String OptionCofquestion2 = exlib.getExcelData("Sheet1", 10, 17);
//			String OptionDofQuestion2 = exlib.getExcelData("Sheet1", 10, 18);
//			
//			//Step 3:Launch the browser
//			if (BROWSER.equalsIgnoreCase("chrome")) {
//				WebDriverManager.chromedriver().setup();
//				driver=new ChromeDriver();
//			}
//			else if (BROWSER.equalsIgnoreCase("firefox")) {
//				WebDriverManager.firefoxdriver().setup();
//				driver=new FirefoxDriver();
//			}
//			else {
//				System.out.println("incorrect browser");
//			}
//
//			driver.manage().window().maximize();
//			weblib.waitForElementInDOM(driver);
//			driver.get(URL);
//			
//			Admin_LoginPage ALP = new Admin_LoginPage(driver);
//			ALP.AdminLoginPage(ADMINLOGIN, ADMINPASSWORD);
//			
//			Admin_Homepage AHP = new Admin_Homepage(driver);
//			AHP.AddQuiz();
//			
//			Quiz_Details_Page QDP = new Quiz_Details_Page(driver);
//			QDP.Quiz_Details(QuizTitle, NoOfQuestions, MarksForRightAns, MarksforWrongAnswer, TimeLimit, TagName, Description);
//
//			QuestionDetailsPage QueDP = new QuestionDetailsPage(driver);
//			QueDP.Question1(QuestionNumber1, OptionAofQuestion1, OptionBofQuestion1, OptionCofquestion1, OptionDofQuestion1);
//			//QueDP.AnsDropDownQ1();
//
//			QueDP.Question2(QuestionNumber2, OptionAofQuestion2, OptionBofQuestion2, OptionCofquestion2, OptionDofQuestion2);
//			//QueDP.AnsDropDownQ2();
//			QueDP.Submit();
//
//			
//}
//}