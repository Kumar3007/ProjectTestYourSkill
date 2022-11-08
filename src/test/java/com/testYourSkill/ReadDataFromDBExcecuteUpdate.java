package com.testYourSkill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBExcecuteUpdate 
{
		public static void main(String[] args) throws Throwable
		{
		//step1:- create object for driver
			Driver driverRef=new com.mysql.jdbc.Driver();
			Connection con=null;
			
		//step2:- Register the driver
			DriverManager.registerDriver(driverRef);
			
		//step3:- Establish the connection- provide provide database name
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "root");
			
		//step4:- create statement 
		Statement state = con.createStatement();
		
		//step5:- execute the query
		String query="insert into EMP values(14,'santhosh',46000)";
		int result = state.executeUpdate(query);
		System.out.println(result);
		
		//step6:- validate
		if(result==1)
		{
			System.out.println("data added successfully");
		}
		else
		{
			System.out.println("data not added");
			
		}
		
		//step7:- closed connection
		con.close();
		System.out.println("connection closed");
		
			
		}
}
