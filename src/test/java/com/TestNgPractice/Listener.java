package com.TestNgPractice;

import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.Test;

import com.TestYourSkill.GenericUtility.BaseClass2;
import com.TestYourSkill.PomRepositoryLib.StudentHomePage;
import java.io.File;
import java.io.IOException;

public class Listener extends BaseClass2
{
		@Test
		public void VerifyHome(Method StudentHomePage) throws Throwable
		{
			System.out.println(StudentHomePage.getName());
			String CurrentTestName = StudentHomePage.getName();
		EventFiringWebDriver eDriver = new EventFiringWebDriver(BaseClass2.sdriver);
			TakesScreenshot t= (TakesScreenshot) driver;
			System.out.println("=========Start Test=============");
			
		StudentHomePage SHPS = new StudentHomePage(driver);
		File src = t.getScreenshotAs(OutputType.FILE);//near output use control+
		
		File dest = new File("./screenshot/+title+.png");
	    FileUtils.copyFile(src, dest);

		
		}
}
