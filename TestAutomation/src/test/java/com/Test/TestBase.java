package com.Test;

import java.util.LinkedHashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.testAutomation.Utils.ExcelUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public abstract class TestBase {
	//automationtest11@gmail.com
	//Password@123
	
	public WebDriver driver;
	String url  = "http://automationpractice.com/index.php";
	LinkedHashMap<String , LinkedHashMap<String, String>> testData= new LinkedHashMap<String , LinkedHashMap<String, String>>();
	ExcelUtils dataBook;
	String className;
	
	
	
	  @BeforeTest public void startTest() { Assert.assertEquals(false, false); }
	 
	
	@BeforeClass
	public void setUp() {
		dataBook = new ExcelUtils(System.getProperty("user.dir") + "//resources//testdata//TestData.xlsx");
		className = this.getClass().getSimpleName();
		System.out.println(System.getProperty("user.dir"));
		System.out.println(className);
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	
	@AfterClass
	public void cleanUp() {
		
		driver.quit();
		
	}
	
	@AfterMethod
	public void endTest() {
		
	}
	
	@DataProvider(name = "TestDataProvider")
	public Object[][] getTestData(){
		
		testData.clear();
		this.dataBook.setSheetName(className);
		LinkedHashMap<String , String> data = null;
		int rowCount = this.dataBook.getRowCount();
		String value, key = null;
		String[] rowData;
		String[] columnNames = this.dataBook.getRowContent(1);
		 for(int i = 2; i<rowCount; i++)
		 {
			 rowData = this.dataBook.getRowContent(i);
			 System.out.println(rowData[2]);
			 if(rowData[2].equalsIgnoreCase("Yes"))
			 {
				 data = new LinkedHashMap<String, String>();
				 
				 for(int index = 0; index < columnNames.length; index++) {
					 
					 key = columnNames[index];
					 value = rowData[index];
					 System.out.println("value  is " +value);
					 if(value.startsWith("-")) {
						 
						 value = "";
					 }
					 data.put(key,value);	 
				}
				 testData.put(rowData[0], data);
			 } 
		 }
		  Object[][] objData = new Object[testData.size()][1];
		  int i = 0;
		  for(String eachValue : testData.keySet())
		  {
			  System.out.println("eachValue :"+eachValue);
			  objData[i][0] = testData.get(eachValue);
			  i++;
		  }
		 return objData;
	}
	
}
