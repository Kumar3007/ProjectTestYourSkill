package com.testYourSkill.PomTestScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.TestYourSkill.GenericUtility.ExcelUtility;
import com.TestYourSkill.GenericUtility.FileUtility;
import com.TestYourSkill.GenericUtility.JavaUtility;
import com.TestYourSkill.GenericUtility.WebDriverUtlity;
import com.TestYourSkill.PomRepositoryLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginScript 
{
			public static void main(String[] args) throws Throwable
			{
				
				WebDriver driver=null;
			//create an objects for Generic Uitility
				ExcelUtility exlib = new ExcelUtility();
				FileUtility filelib = new FileUtility();
				JavaUtility javalib = new JavaUtility();
				WebDriverUtlity weblib = new WebDriverUtlity();
			
				//get random number
			   	int intRanNum = javalib.getRanDomNumber();
			   	
			  //step1:-Read all the necessary common data
			   	
			   	String BROWSER = filelib.getPropertyKeyValue("browser");
			   	String URL = filelib.getPropertyKeyValue("url");
			   	String sub = filelib.getPropertyKeyValue("Subject");
			   	String A_login = filelib.getPropertyKeyValue("adminlogin");
			   	String A_pass = filelib.getPropertyKeyValue("Apassword");
			   	
			   //step2:-Read the test data from ExcelSheet
			   	String EnterYourName = exlib.getExcelData("Sheet1", 1, 2);
			   	String EnterYourCollegeName = exlib.getExcelData("Sheet1", 1, 3);
			   	String EnterYourEmail = exlib.getExcelData("Sheet1", 1, 4)+intRanNum;
			   	String EnterYourMobileno = exlib.getExcelData("Sheet1", 1, 5);
			   	String EnterYourPassword = exlib.getExcelData("Sheet1", 1, 6);
			   	String ConfirmPassword = exlib.getExcelData("Sheet1", 1, 7);
				String gender="Male";
				
				
				//step3:-Launch browser
				if(BROWSER.equalsIgnoreCase("chrome"))
				{
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
				}
				else if(BROWSER.equalsIgnoreCase("firefox"))
				{
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
				}
				else
				{
					System.out.println("INCORRECT BROWSER");
				}
				driver.manage().window().maximize();
				weblib.waitForElementInDOM(driver);
				driver.get(URL);
				
			
				
				//creating object for Login page of POM repository
				
			//com.TestYourSkill.PomRepositoryLib.Login LP = new com.TestYourSkill.PomRepositoryLib.Login(driver);
				
				LoginPage LP = new LoginPage(driver);
				LP.LoginToTheApp(EnterYourName, gender, EnterYourCollegeName, EnterYourEmail, EnterYourMobileno, EnterYourPassword, ConfirmPassword);
				
			
				
			}
}
