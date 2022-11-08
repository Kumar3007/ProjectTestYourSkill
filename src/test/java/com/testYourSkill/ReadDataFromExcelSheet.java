package com.testYourSkill;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet
{
		public static void main(String[] args) throws Throwable
		{
		//step1:-read the file using fileinput stream
		FileInputStream fis = new FileInputStream(".\\data\\TESTYOURSKILL_WORKBOOK.xlsx");
			
		//step2:- create workbook
		Workbook workbook = WorkbookFactory.create(fis);
		
		//step3:- load the sheet
		Sheet sh = workbook.getSheet("Sheet1");
		
		//step4:- Navigate to the row
			Row row = sh.getRow(1);
		
		//step5:- Navigate to the cell
			Cell cell = row.getCell(1);
			
			
		//step6:- read the value inside the cell
			System.out.println(cell.getStringCellValue());
			
		}
}
