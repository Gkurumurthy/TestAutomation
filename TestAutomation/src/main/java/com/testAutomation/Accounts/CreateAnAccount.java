package com.testAutomation.Accounts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testAutomation.BasePage;

public class CreateAnAccount extends BasePage{
	
	private WebDriver driver;
	
	@FindBy(id = "id_gender1")
	private WebElement titleMr;
	
	@FindBy(id = "id_gender2")
	private WebElement titleMrs;
	
	@FindBy(id = "customer_firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "customer_lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "email")
	private WebElement emailIDField;
	
    @FindBy(id = "passwd")
    private WebElement passwordField;
    
    @FindBy(xpath = "//select[@id='days']")
    private WebElement dateDropDown;
    
    @FindBy(id = "months")
    private WebElement monthsDropDown;
    
    @FindBy(id = "years")
    private WebElement yearsDropDown;
    
    @FindBy(id = "firstname")
    private WebElement firstNameInAddress;
    
    @FindBy(id = "lastname")
    private WebElement lastNameInAddress;
    
    @FindBy(id = "company")
    private WebElement companyField;
    
    @FindBy(id = "address1")
    private WebElement addressLine1Field;
    
    @FindBy(id = "address2")
    private WebElement addressLine2Field;
    
    @FindBy(id = "city")
    private WebElement cityField;
    
    @FindBy(id = "id_state")
    private WebElement stateDropDown;
    
    @FindBy(id = "postcode")
    private WebElement postCodeField;
    
    @FindBy(id = "id_country")
    private WebElement countryField;
    
    @FindBy(id = "other")
    private WebElement additionalInfoField;
    
    @FindBy(id = "phone")
    private WebElement homephoneField;
    
    @FindBy(id = "phone_mobile")
    private WebElement mobilePhoneField;
    
    @FindBy(id = "alias")
    private WebElement aliasAddress;
    
    @FindBy(xpath = "//span[contains(text(),'Register')]")
    private WebElement registerButton;
    
	
	public CreateAnAccount(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void createNewAccount(String title, String firstName, String lastName, String emialId, String password, String date,
			String month, String year) {
		
		this.getPageTitle();
		this.waitForElementToBeVisible(titleMr);
		
		if(title.equalsIgnoreCase("Mr"))
		{
			this.click(titleMr);
		}
		else {
			this.click(titleMrs);
	    }
		this.type(firstNameField, firstName);
		this.type(lastNameField, lastName);
		this.getText(emailIDField);
		this.type(passwordField, password);
		//this.click(dateDropDown);
		
		this.selectFromOptionList(dateDropDown, date);
		this.selectFromOptionList(monthsDropDown, month);
		this.selectFromOptionList(yearsDropDown, year);
}
	public AccountPage yourAddressSection(String aFirstName, String aLastName, String company, String address1, String address2,
			String city, String state, String zipCode, String country, String additionalInfo, String homePhone, String mobilePhone)
	{
		
		this.type(firstNameInAddress, aFirstName);
		this.type(lastNameInAddress, aLastName);
		this.type(companyField, company);
		this.type(addressLine1Field, address1);
		this.type(addressLine2Field, address2);
		this.type(cityField, city);
		this.selectOptionByValue(stateDropDown, state);
		this.type(postCodeField, zipCode);
		this.type(countryField, country);
		this.type(additionalInfoField, additionalInfo);
		this.type(homephoneField, homePhone);
		this.type(mobilePhoneField, mobilePhone);
		this.click(registerButton);
		return new AccountPage(this.driver);
		
	}
}
