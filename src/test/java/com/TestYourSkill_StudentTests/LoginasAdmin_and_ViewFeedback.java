package com.TestYourSkill_StudentTests;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginasAdmin_and_ViewFeedback
{
	public static void main(String[] args) throws Throwable
	{
		WebDriver driver=null;
		
			//step1:- read all the necessary common data
		FileInputStream fis = new FileInputStream(".\\data\\commondata.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String URL = prop.getProperty("url");
		String browser=prop.getProperty("browser");
		String ALogin = prop.getProperty("adminlogin");
		String A_PASSWORD = prop.getProperty("Apassword");
		
	
			//step2:- read the test data from excel sheet
		FileInputStream fis1 = new FileInputStream(".\\data\\TESTYOURSKILL_WORKBOOK.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		Sheet sh = workbook.getSheet("Sheet1");
		Row row = sh.getRow(1);
		Cell cell = row.getCell(1);
		cell.getStringCellValue();
		
		
			//step3:- launch the browser
		if (browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("INCORRECT BROWSER");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(URL);
		
		//step4.0:- student signup
		
		
		
			//step4:- login to application
	driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
	driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(ALogin);
	driver.findElement(By.xpath("(//input[@id='password'])[1]")).sendKeys(A_PASSWORD);
	driver.findElement(By.xpath("//input[@name='login']")).click();
}
}