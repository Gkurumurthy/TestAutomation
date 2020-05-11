package com.testAutomation.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
//import org.apache.poi.ss.formula.functions.Column;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private Workbook workBook;
	private Sheet sheet;
	private List<String> sheetNames = new ArrayList<String>();
	private String workBookName;
	private Row row;
	//private Column column;
	
	//ExcelUtils(String filePath)
	
	public ExcelUtils(String filePath) {
		
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			workBookName = file.getName();
			workBook = new XSSFWorkbook(inputStream);
			//sheetNames = Arrays.asList(workBook.getS);
		}
		catch(Exception e) {
			
			Assert.fail(e.getMessage());
		}
	}
	
	//getSheetNames()
	public List<String> getSheetNames() {
	
		for(int i=0; i<workBook.getNumberOfSheets(); i++) {
		
			//System.out.println(workBook.getSheetName(i));
			
			sheetNames.add(workBook.getSheetName(i));
		}
		return sheetNames;
	}
	
	//setsheetName(String sheetName)
	public void setSheetName(final String sheetName) {
		
		if(getSheetNames().contains(sheetName)) {
			
			sheet = workBook.getSheet(sheetName);
		}
		else
		{
			Assert.fail(sheetName+" sheet is not found in " +workBookName);
		}
	}
	//getRowCount()
	public int getRowCount() {
		
		int rowCount = sheet.getLastRowNum()+1;
		System.out.println(rowCount);
		return rowCount;
	}
	
	
	public String[] getRowContent(final int rowIndex)
	{
		String[] rowContent = null;
		  try {
		 
			row = sheet.getRow(rowIndex - 1);
			rowContent =  new String[row.getLastCellNum()];
			System.out.println("LastCellNum : " +row.getLastCellNum());
			for (int index = 0; index < row.getLastCellNum(); index++)
			{
				rowContent[index] = row.getCell(index).toString();
			}
			return rowContent;
            }
		catch (Exception e)
		{
			Assert.fail(e.getMessage());
		}
		  return null;
		
	}
	//getRowContent(int rowIndex)
	
	public void getColumnontent(final int columnIndex) {
		 
	}
	//getColumnCount()
	public int getColumnCount() {
		int columnCount =row.getLastCellNum()+1;
		return columnCount;
	}
	//getColumnContent(int columnIndex)
	//getDataMap()
	//getCellContent(int rowIndex, int columnIndex)
	
	/*
	 * public static void main(String args[]) {
	 * 
	 * ExcelUtils excel = new ExcelUtils(System.getProperty("user.dir") +
	 * "//resources//testdata//Test.xlsx"); excel.setSheetName("TestSheet");
	 * System.out.println("row count is " +excel.rowCount());
	 * //excel.getRowContent(2); String[] data = excel.getRowContent(3); for(String
	 * values : data) { System.out.println(values); }
	 * System.out.println("columnCount "+excel.getColumnCount());
	 * 
	 * 
	 * }
	 */
	

}
