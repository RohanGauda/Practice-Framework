package com.comcast.crm.genericutility.excelutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getReadDataFromExcel(String sheet_name,int rollnum,int colindex) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\rohan\\AdvSelenium\\NewProject\\TestData\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet_name);
		Row row = sh.getRow(rollnum);
		Cell cell = row.getCell(colindex);
		String data = cell.toString();
		
		return data;
	}
	
	public void getWriteDataIntoExcel(String sheet_name,int rollnum,int colindex, String data) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\rohan\\AdvSelenium\\NewProject\\TestData\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheet_name);
		Row row = sh.getRow(rollnum);
		Cell cell = row.createCell(rollnum);
		cell.setCellType(CellType.STRING);
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\rohan\\AdvSelenium\\NewProject\\TestData\\Book1.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public int getLastRowNum(String sheetname) throws Throwable {
		FileInputStream fis = new FileInputStream("C:\\Users\\rohan\\AdvSelenium\\NewProject\\TestData\\Book1.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRowNum = sh.getLastRowNum();
		return lastRowNum;
	}
}
