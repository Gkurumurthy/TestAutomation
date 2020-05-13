package com.Test.HappyFlow;

import java.util.LinkedHashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Test.TestBase;
import com.testAutomation.Accounts.AccountPage;
import com.testAutomation.Accounts.CreateAnAccount;
import com.testAutomation.Accounts.HomePage;
import com.testAutomation.Accounts.LoginPage;

public class TestCreateAnAccount extends TestBase{
	
	HomePage homePage;
	LoginPage loginPage;
	CreateAnAccount createAnAccountPage;
	AccountPage accountPage;
	
	@Test
	(dataProvider = "TestDataProvider")
	public void testCreatAnNewAccount(LinkedHashMap<String, String> testData) {
		
		homePage = new HomePage(super.driver);
		loginPage = homePage.navigateToSignInPage();
		createAnAccountPage = loginPage.createAccountSection(testData.get("EmailId"));
		createAnAccountPage.createNewAccount(testData.get("Title"), testData.get("FirstName"), testData.get("LastName"),testData.get("EmailId") 
				,testData.get("Password"),testData.get("Date")+"  ", testData.get("Month")+" ", testData.get("Year")+"  ");
		accountPage = createAnAccountPage.yourAddressSection(testData.get("AFirstName"), testData.get("ALastName"), testData.get("Company"), 
				testData.get("Address1"),
				testData.get("Address2"), testData.get("City"), testData.get("State"),testData.get("ZipCode"),testData.get("Country"),
				testData.get("AdditionalInfo"), testData.get("HomePhone"), testData.get("MobilePhone"));
		String userName = testData.get("FirstName") +" " +testData.get("LastName");
		//verify loggedin username
		Assert.assertEquals(accountPage.getUserName(), userName ,"Validating the Loggedin UserName");
		
	}
}
