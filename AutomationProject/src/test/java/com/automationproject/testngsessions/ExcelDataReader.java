package com.automationproject.testngsessions;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataReader {

	
	public static void main(String[] args) throws IOException {
		
		FileInputStream fi= new FileInputStream("C:\\Users\\gurum\\Desktop\\EmpData.xlsx");
		
		XSSFWorkbook wb= new XSSFWorkbook(fi);
		
		XSSFSheet sh= wb.getSheet("Data1");
		
		int rowcount=sh.getLastRowNum();
		
		System.out.println("Total rows in table "+rowcount );
		
		short cellcount=sh.getRow(rowcount).getLastCellNum();
		
		System.out.println("Total Cell count "+cellcount);
		
		String data=sh.getRow(2).getCell(1).getStringCellValue();
		
		System.out.println(data);
			
	}
}
