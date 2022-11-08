package com.TestYourSkill_StudentTests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Calender
{
			public static void main(String[] args) 
			{
				
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.get("https://www.goibibo.com/");
			
			
			Actions act = new Actions(driver);
			act.moveByOffset(10, 10).click().perform();
			
			driver.findElement(By.xpath("//span[text()='Departure']")).click();
			String arrowpath="//span[@aria-label='Next Month']";
			String  datexpath="//div[@aria-label='Sun Oct 23 2022']";
			
			for(;;)
			{
				try
				{
					driver.findElement(By.xpath(datexpath)).click();
					break;
				}
				catch(Exception e)
				{
					driver.findElement(By.xpath(arrowpath)).click();
				}
			}
			
}
}
