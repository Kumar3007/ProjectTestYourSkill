package com.testYourSkill;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDBExecuteQuery 
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
	
	//step5:- Excecute the query -provide table name
	String query="select * from emp; ";
	String expdata="santhosh";
	ResultSet result = state.executeQuery(query);
	boolean flag=false;
	
	
	while(result.next())
	{
		String actData=result.getString(2);
		if(actData.equalsIgnoreCase(expdata))
		{
			System.out.println(actData);
			flag=true;//flag rising
			break;
		}
	}
	if(flag)
	{
		System.out.println("data Present");
	}
	else
	{
		System.out.println("data not Present");
	}
	
	
	//step 6:- validate
	//step7:- close connection
	con.close();
}
}