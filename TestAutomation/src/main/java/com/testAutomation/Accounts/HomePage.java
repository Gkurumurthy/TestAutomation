package com.testAutomation.Accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomation.BasePage;

public class HomePage extends BasePage {
	
	private WebDriver driver;
	
	
	@FindBy(xpath = "//a[@class='login']")
	private WebElement signInLink;

	@FindBy(xpath = "//a[@title='Contact Us']")
	private WebElement contactUsLink;
	
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	public LoginPage navigateToSignInPage() {
		
		this.click(signInLink);
		return new LoginPage(this.driver);
	}
}
