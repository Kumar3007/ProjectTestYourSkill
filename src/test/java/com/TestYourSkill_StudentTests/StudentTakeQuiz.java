package com.TestYourSkill_StudentTests;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class StudentTakeQuiz 
{
			
			public static void main(String[] args) throws Throwable
			{
				Random ran = new Random();
				int random = ran.nextInt(500);
				
				WebDriver driver=null;
				//step1:-read all necessary data from common property
				FileInputStream fis = new FileInputStream(".\\data\\commondata.properties");
				Properties prop = new Properties();
				prop.load(fis);
				String BROWSER = prop.getProperty("browser");
				String URL = prop.getProperty("url");
			
				//step2:-read all necessary data from excel sheet
				
				FileInputStream fis1 = new FileInputStream(".\\data\\TestCasesTys.xlsx");
				Workbook workbook = WorkbookFactory.create(fis1);
				Sheet sh = workbook.getSheet("Sheet1");
				String EnterYourName = sh.getRow(4).getCell(2).getStringCellValue();
				String EnterYourCollegeName = sh.getRow(4).getCell(3).getStringCellValue();
				String EnterYourEmail = sh.getRow(4).getCell(4).getStringCellValue();
				String EnterYourMobileno = sh.getRow(4).getCell(5).getStringCellValue();
				String EnterYourPassword = sh.getRow(4).getCell(6).getStringCellValue();
				String ConfirmPassword = sh.getRow(4).getCell(7).getStringCellValue();
				
				
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
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.get(URL);
				
				//step4:-signin to the application
				driver.findElement(By.id("name")).sendKeys(EnterYourName);
				WebElement ele = driver.findElement(By.id("gender"));
				Select b=new Select(ele);
				b.selectByIndex(1);
				driver.findElement(By.id("college")).sendKeys(EnterYourCollegeName);
				driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(random+EnterYourEmail);
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
