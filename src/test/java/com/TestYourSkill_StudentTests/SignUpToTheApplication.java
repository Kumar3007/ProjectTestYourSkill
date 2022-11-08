package com.TestYourSkill_StudentTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUpToTheApplication 
{
		public static void main(String[] args) throws Throwable 
		{
			
			WebDriver driver=null;
			
			//step1:-Read all the necessary common data
			FileInputStream fis = new FileInputStream(".\\data\\commondata.properties");
			Properties prop = new Properties();
			prop.load(fis);
			String BROWSER = prop.getProperty("browser");
			String EYN = prop.getProperty("EnterYourName");
			String C_name = prop.getProperty("EnterYourCollegeName");
			String Email = prop.getProperty("EnterYourEmailid");
			String mobile = prop.getProperty("EnterYourMobileNumber");
			String password = prop.getProperty("EnterYourPassword");
			String C_password = prop.getProperty("ConfirmPassword");
			//step2:-Read the test data from ExcelSheet
			//step3:-launch the browser
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
			
			//step4:-SignUpToTheApplication
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get("http://rmgtestingserver/domain/Online_Examination_System/index.php");
			
			driver.findElement(By.id("name")).sendKeys(EYN);
			WebElement ele = driver.findElement(By.id("gender"));
			Select b=new Select(ele);
			b.selectByIndex(1);
		
			//driver.findElement(By.xpath("//option[@value='Male']")).click();
			driver.findElement(By.id("college")).sendKeys(C_name);
			driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys(Email);
			driver.findElement(By.id("mob")).sendKeys(mobile);
			driver.findElement(By.xpath("//input[@placeholder='Enter your password']")).sendKeys(password);
			driver.findElement(By.id("cpassword")).sendKeys(C_password);
			driver.findElement(By.xpath("//input[@class='sub']")).click();
		}
}
