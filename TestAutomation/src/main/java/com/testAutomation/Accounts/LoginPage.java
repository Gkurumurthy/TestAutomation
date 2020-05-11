package com.testAutomation.Accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomation.BasePage;

public class LoginPage extends BasePage{
	
	//
	 WebDriver driver;

	
	@FindBy(id="email")
	private WebElement emailField;
	
	@FindBy(id = "passwd")
	private WebElement passwordField;
	
	@FindBy(xpath = "//a[contains(text(),'Forgot your password?')]")
	private WebElement forgotPasswordLink;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	private WebElement submitButton;
	
	@FindBy(id = "email_create")
	private WebElement createAccEmailField;
	
	@FindBy(id = "SubmitCreate")
	private WebElement createAnAccButton;
	
	

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	
	}
	
	public void userLogin(String userName , String password) {
		
		this.type(emailField, userName);
		this.type(passwordField, password);
		this.click(submitButton);
	}
	
	public CreateAnAccount createAccountSection(String emailId) 
	{
		this.type(createAccEmailField, emailId);
		this.click(createAnAccButton);
		return new CreateAnAccount(this.driver);
		
	}
	

}
