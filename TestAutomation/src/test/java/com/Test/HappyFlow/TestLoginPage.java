package com.Test.HappyFlow;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.Test.TestBase;
import com.testAutomation.Accounts.AccountPage;
import com.testAutomation.Accounts.HomePage;
import com.testAutomation.Accounts.LoginPage;

public class TestLoginPage extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	AccountPage accountPage;
	//automationtest11@gmail.com
	//Password@123
	
	  @Test
	  (dataProvider = "TestDataProvider") 
	  public void TestUserLogin(LinkedHashMap<String , String> testData) 
	  { 
		  homePage = new HomePage(super.driver); 
		  loginPage = homePage.navigateToSignInPage();
		  System.out.println(testData.get("UserName"));
		  System.out.println(testData.get("Password"));
		  System.out.println(testData.get("Name"));
		  System.out.println(testData.get("Degree"));
	      loginPage.userLogin(testData.get("UserName"), testData.get("Password"));
	 
	  }
	 
    
	/*
	 * @Test public void TestUserLogin() { homePage = new HomePage(super.driver);
	 * loginPage = homePage.navigateToSignInPage();
	 * loginPage.userLogin("automationtest11@gmail.com","Password@123");
	 * 
	 * 
	 * }
	 */
	 
}
