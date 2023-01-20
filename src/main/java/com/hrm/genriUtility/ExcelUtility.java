package com.hrm.genriUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ExcelUtility {
/**
 * It is used to the data from excel following argument
 * @param sheetname
 * @param rowNum
 * @param celNum
 * @param data
 * @param Throwable
 * @throws Throwable 
 */
	public String getDataFromExcel(String sheetName,int rowNum, int celNum) throws Throwable {
		FileInputStream fis = new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);		
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(celNum);
		String data=row.getCell(celNum).getStringCellValue();
		wb.close();
		return data;
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @return
	 * @throws Throwable
	 */
	public int getCellCount(String sheetName, int rowNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		short cellCount = row.getLastCellNum();
		return cellCount;
	}

	/**
	 * 
	 * @param sheetName
	 * @return
	 * @throws Throwable
	 */
	
	public int getRowCount(String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);		
		wb.close();
		return sheet.getLastRowNum();
	}
	/**
	 * 
	 * @param sheetName
	 * @param rowNum
	 * @param celNum
	 * @param data
	 * @throws Throwable
	 */
	
	public void setDataExcel(String sheetName,int rowNum, int celNum, String data) throws Throwable {
		FileInputStream fis = new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);		
		Row row=sheet.getRow(rowNum);
		Cell cell=row.createCell(celNum);
		cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(iPathContent.ExcelPath);
		wb.write(fos);
		wb.close();
}
	public Map<String,String> getList(WebDriver driver, String sheetName) throws Throwable {
		FileInputStream fis = new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(0); 
		int count= row.getLastCellNum();
	
		Map<String,String> map=new HashMap<String, String>();
		for (int i = 0; i <count; i++) {
			String key = sheet.getRow(0).getCell(i).getStringCellValue();
			String value= sheet.getRow(1).getCell(i).getStringCellValue();
			map.put(key, value);
		}
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
}
		return map;	
	}
	public Map<String,String> getList(WebDriver driver, String sheetName,int rownum,int valuecell) throws Throwable {
		FileInputStream fis = new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);
		Row row = sheet.getRow(0); 
		int count= row.getLastCellNum();
	
		Map<String,String> map=new HashMap<String, String>();
		for (int i = 0; i <count; i++) {
			String key = sheet.getRow(0).getCell(i).getStringCellValue();
			String value= sheet.getRow(1).getCell(i).getStringCellValue();
			map.put(key, value);
		}
		for (Entry<String, String> set : map.entrySet()) {
			driver.findElement(By.name(set.getKey())).sendKeys(set.getValue());
}
		return map;	
	}
	
	public  Object[][] getReadMultipleData(String sheetname) throws Throwable
	{
		FileInputStream fis=new FileInputStream(iPathContent.ExcelPath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetname);
		int rownum = sheet.getLastRowNum()+1;
		int colnum = sheet.getRow(0).getLastCellNum();
		Object[][] obj = new Object[rownum][colnum];
		for (int i = 0; i < rownum; i++) {
			for (int j = 0; j<colnum; j++) {
				obj[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
				
			}
		}
		
		return obj;
		
		
		
		
	}
}
