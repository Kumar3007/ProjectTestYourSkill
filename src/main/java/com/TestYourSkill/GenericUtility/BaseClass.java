package com.TestYourSkill.GenericUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.TestYourSkill.PomRepositoryLib.LoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	
		public WebDriver driver;//??????
		//object creation for lib
		
		public ExcelUtility exlib = new ExcelUtility();
		public FileUtility filelib = new FileUtility();
		public JavaUtility javalib = new JavaUtility();
		public WebDriverUtlity weblib = new WebDriverUtlity();
		

		@BeforeSuite
		public void configBS() {
			System.out.println("===========================connect to DB=======================");
		}
		
		@BeforeClass
		public void openBrowserandApplication() throws Throwable
		{
			System.out.println("Launching the Browser- BeforeClass");
			
			//common data
			String BROWSER = filelib.getPropertyKeyValue("browser");
			
			
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
			String URL = filelib.getPropertyKeyValue("url");
			driver.get(URL);
			String ADMINLOGIN = filelib.getPropertyKeyValue("adminlogin");
			String ADMINPASSWORD = filelib.getPropertyKeyValue("Apassword");
			
		}
		
		@BeforeMethod
		public void login() throws Throwable
		{
			System.out.println("====================Before Method===========");
			
		}
		
		@AfterMethod 
		public void signout()
		{
			System.out.println("===================After method======================");
			
		}
		
		@AfterClass
		public void closebrowser()
		{
			System.out.println("======================close the browser-AfterClass===============");
			driver.quit();
		}
		
		@AfterSuite
		public void closeDB()
		{
			System.out.println("=============Close DB-AfterSuite===============================");
		}
		
}
