package com.TestYourSkill_StudentTests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Highlighter.Highlight;

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

public class StudentTakingQuizAndGivingFeedback {

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
		String sub = prop.getProperty("Subject");
		String A_login = prop.getProperty("adminlogin");
		String A_pass = prop.getProperty("Apassword");
	
		//step2:-read all necessary data from excel sheet
		
		FileInputStream fis1 = new FileInputStream(".\\data\\TestCasesTys.xlsx");
		Workbook workbook = WorkbookFactory.create(fis1);
		Sheet sh = workbook.getSheet("Sheet1");
		String EnterYourName = sh.getRow(1).getCell(2).getStringCellValue();
		String EnterYourCollegeName = sh.getRow(1).getCell(3).getStringCellValue();
		String EnterYourEmail = sh.getRow(1).getCell(4).getStringCellValue();
		String EnterYourMobileno = sh.getRow(1).getCell(5).getStringCellValue();
		String EnterYourPassword = sh.getRow(1).getCell(6).getStringCellValue();
		String ConfirmPassword = sh.getRow(1).getCell(7).getStringCellValue();
		
		
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
		
		//student viewing his ranking
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[3]/a/span[@class='glyphicon glyphicon-stats']")).click();
		
		//student viewing history page
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/descendant::span[@class='glyphicon glyphicon-list-alt']")).click();
		
		//Highlight(driver.findElement(By.xpath("//div[@class='table-responsive']/child::table/tbody/child::tr[4]")));

		//student giving feedback
		driver.findElement(By.xpath("//div[@class='row footer']/descendant::a[text()='Feedback']")).click();
		
		//Handling MultipleWindows
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();
		for(String lv:allWindows)
		{
			driver.switchTo().window(lv);
		}
		
		
		driver.findElement(By.name("name")).sendKeys(EnterYourName);
		driver.findElement(By.name("subject")).sendKeys(sub);
		driver.findElement(By.xpath("//b[text()='E-Mail address:']/parent::div/following-sibling::div/child::div/child::input[@name='email']")).sendKeys("124djaj@gmail.c om");
		driver.findElement(By.xpath("//b[text()='E-Mail address:']/parent::div/parent::div/following-sibling::div/textarea[@name='feedback']")).sendKeys("ljfgklsgklsahgklhws");
		driver.findElement(By.xpath("//input[@name='submit']")).click();
		
		driver.close();
		driver.switchTo().window(mainWindow);
		
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[@class='pull-right']/a")).click();
		driver.findElement(By.xpath("//a[text()='Admin Login']")).click();
		driver.findElement(By.xpath("//input[@name='uname']")).sendKeys(A_login);
		driver.findElement(By.xpath("//span[text()='LOGIN']/parent::h4/following::div/child::form/div/input[@name='password']")).sendKeys(A_pass);
		driver.findElement(By.xpath("//span[text()='LOGIN']/parent::h4/following::div/child::form/div/input[@name='login']")).click();
		driver.findElement(By.xpath("//a[text()='Feedback']")).click();
		
		String ExpectedName=EnterYourName;
		boolean flag=false;
		List<WebElement> Names = driver.findElements(By.xpath("//td[text()='1']/parent::tr/child::td[contains(.,'RAM')]"));
		
		for (WebElement wb : Names)
	{
		String Actualname = wb.getText();
		
		if(Actualname.equalsIgnoreCase(ExpectedName))
		{
			System.out.println("Feedback  Sent Succesfully");
			flag=true;
			break;
		}
	}
		if(!flag)
		{
			System.out.println(ExpectedName+"is not avaible==FAIL");
		}
		
		
		
		
		
		
		
		
		
	/*	//switching to other window
		String mainWindow1 = driver.getWindowHandle();
		Set<String> allWindows1 = driver.getWindowHandles();
		for(String lv:allWindows1)
		{
			driver.switchTo().window(lv);
		}
		driver.findElement(By.xpath("//ul[@class='nav navbar-nav']/child::li[@class='pull-right']/child::a/span")).click();*/
		
	//	driver.findElement(By.xpath("//span[text()='Test Your Skill']/parent::div/following-sibling::div/a/span[@class='glyphicon glyphicon-home']")).click();
		
		
		
	}

	

}
