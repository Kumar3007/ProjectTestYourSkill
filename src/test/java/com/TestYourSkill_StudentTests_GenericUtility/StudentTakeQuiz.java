package com.TestYourSkill_StudentTests_GenericUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.TestYourSkill.GenericUtility.ExcelUtility;
import com.TestYourSkill.GenericUtility.FileUtility;
import com.TestYourSkill.GenericUtility.JavaUtility;
import com.TestYourSkill.GenericUtility.WebDriverUtlity;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentTakeQuiz 
{
			
			public static void main(String[] args) throws Throwable
			{
				WebDriver driver=null;
				
				//creating Object for GenericUtility
				ExcelUtility exlib = new ExcelUtility();
				FileUtility filelib = new FileUtility();
				JavaUtility javalib = new JavaUtility();
				WebDriverUtlity weblib = new WebDriverUtlity();
				
				//get random number
			   	int intRanNum = javalib.getRanDomNumber();
					
				//step1:-Read all the necessary common data
			   	
			   	String BROWSER = filelib.getPropertyKeyValue("browser");
			   	String URL = filelib.getPropertyKeyValue("url");
			   	
			   	
			   //step2:-Read the test data from ExcelSheet
			   	String EnterYourName = exlib.getExcelData("Sheet1", 1, 2);
			   	String EnterYourCollegeName = exlib.getExcelData("Sheet1", 1, 3);
			   	String EnterYourEmail = exlib.getExcelData("Sheet1", 1, 4)+intRanNum;
			   	String EnterYourMobileno = exlib.getExcelData("Sheet1", 1, 5);
			   	String EnterYourPassword = exlib.getExcelData("Sheet1", 1, 6);
			   	String ConfirmPassword = exlib.getExcelData("Sheet1", 1, 7);
				
				
				
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
				
				//step4:-signin to the application
				driver.findElement(By.id("name")).sendKeys(EnterYourName);
				WebElement ele = driver.findElement(By.id("gender"));
				weblib.select(ele, 1);
				driver.findElement(By.id("college")).sendKeys(EnterYourCollegeName);
				driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(intRanNum+EnterYourEmail);
				driver.findElement(By.xpath("//input[@id='mob']")).sendKeys(EnterYourMobileno);
				driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(EnterYourPassword);
				driver.findElement(By.id("cpassword")).sendKeys(ConfirmPassword);
				driver.findElement(By.xpath("//input[@class='sub']")).click();
				
				//step5:- Student taking Quiz
				driver.findElement(By.xpath("//td[text()='Agile Methedology']/parent::tr/child::td[6]//b[text()='Start']")).click();
				driver.findElement(By.xpath("//div[@class='panel']/child::form/child::input[@value='62da7556c3916']")).click();
				driver.findElement(By.xpath("//div[@class='panel']/child::form/child::button[@class='btn btn-primary']")).click();
				
				driver.findElement(By.xpath("//div[@class='panel']/child::form/child::input[@value='62da755760195']")).click();
				driver.findElement(By.xpath("//div[@class='panel']/child::form/child::button[@class='btn btn-primary']")).click();
				
				driver.findElement(By.xpath("//div[@class='panel']/child::form/child::input[@value='62da7557d8abc']")).click();
				driver.findElement(By.xpath("//div[@class='panel']/child::form/child::button[@class='btn btn-primary']")).click();
		
				
				
				
			}
}
