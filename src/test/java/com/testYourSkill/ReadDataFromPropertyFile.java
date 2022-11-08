package com.testYourSkill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromPropertyFile 
{
		public static void main(String[] args) throws Throwable
		{
			//step1:- use fileInputStream to load the Property File
		FileInputStream fis = new FileInputStream(".\\data\\commondata.properties");
			
			//step2:-create object of Properties and Load the File
		Properties prop = new Properties();
				prop.load(fis);
		
		
			//step3:-provide the Key to read the Value
			String URL = prop.getProperty("url");
			System.out.println(URL);
			
			String ADMINLOGIN = prop.getProperty("adminlogin");
			System.out.println(ADMINLOGIN);
			
			String A_PASSWORD = prop.getProperty("Apassword");
			System.out.println(A_PASSWORD);
			
			String SLogin = prop.getProperty("studentlogin");
			System.out.println(SLogin);
			
			String S_PASSWORD = prop.getProperty("Spassword");
			System.out.println(S_PASSWORD);
			
			String browser=prop.getProperty("browser");
			System.out.println(browser);
		}
}
