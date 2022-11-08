package com.TestNgPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FlipKart {

	public static void main(String[] args) throws Throwable {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://WWW.flipkart.com");//opens flipkart website
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();//clicks on close button
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("woodland shoes");//enters the woodland shoes into test box
		driver.findElement(By.xpath("//button[@class='L0Z3Pu']")).click();//clicks on search button
		Thread.sleep(8000);
	
		//identifies all the tiles
				List<WebElement> titles = driver.findElements(By.xpath("//a[@class='IRpwTa']"));
				
				
				//identifies all the prices
				List<WebElement> prices = driver.findElements(By.xpath("//a[@class='IRpwTa ']/..//div[@class='_30jeq3']"));

				for (int i = 0; i < titles.size(); i++) 
				{		
						 String p = prices.get(i).getText();
						 		
						 int p3 = Integer.parseInt(p.substring(1).replace(",", ""));
						 	
						 if(p3>2000)
						 {
							 System.out.println(titles.get(i).getText()+"="+p3);
							 
							
						}
					
					
					
				}
				
				// System.out.println(titles.size());
	}
}
