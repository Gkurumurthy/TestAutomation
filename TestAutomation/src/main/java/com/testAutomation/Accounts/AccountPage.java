package com.testAutomation.Accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomation.BasePage;

public class AccountPage extends BasePage{
	
	private WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
    
	@FindBy(xpath = "//a[@class = 'account']/span")
	private WebElement loggedInUserName;
	
	public String getUserName() {
		this.waitForElementToBeVisible(loggedInUserName);
		
		String userName = this.getText(loggedInUserName);
		return userName;
	}
}
