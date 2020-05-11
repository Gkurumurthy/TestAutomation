package com.testAutomation;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	 WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		
	}
	//click
	//type
	//typeandsubmit
	//gettext
	//mousehover
	//driverClose
	//getPageTitle
	//selectByValue
	//selectById
	
	
	public boolean isEnabled(WebElement locator) {
		
		return locator.isEnabled();
	}
	
	public boolean isPresent(WebElement locator) {
		
		return locator.isDisplayed();
	}
	
	public String getPageTitle() {
		
		 return driver.getTitle();
	 }
	public boolean close() {
		
			this.driver.quit();
			return true;
		}
	
	public boolean click(WebElement locator ) {
		boolean status = false;
        if (this.isEnabled(locator)) {
            locator.click();
        }
        return status;
	}
	public boolean type(WebElement locator, String value) {
		boolean success =  false;
		try {
			locator.clear();
			locator.sendKeys(value);
			return success = true;
		}
		catch(Exception e){
			System.out.println(e);
			return success= false;
		}
	}
	public boolean typeAndSubmit(WebElement  locator, String value) {
		 boolean success = false;
		 try {
			 locator.clear();
			 locator.sendKeys(value);
			 locator.sendKeys(Keys.ENTER);
			 return success = true;
		 }
		 catch(Exception e) {
			 return success = false;	 
		 }
		 
	 }
	
	public String getText(WebElement locator) {
		
		String text = locator.getText();
		return text;
		
	}
	
	public boolean selectOptionByValue(final WebElement locator, final String option) {
		boolean status = false;
		if (isEnabled(locator)) {
			Select select = new Select(locator);
			//select.
			select.selectByVisibleText(option);
			status = true;
		}
		return status;
	}
	
	public  void waitForElementToBeVisible(WebElement locator) {
		WebDriverWait wait = new WebDriverWait(driver , 30 );
		wait.until(ExpectedConditions.visibilityOf(locator));
	}
	
	public boolean selectFromOptionList(final WebElement locator, final String option) {
		boolean status = false;
		//System.out.println(option);
		if (isEnabled(locator)) {
			Select select = new Select(locator);
			List<WebElement> options = select.getOptions();
			for(WebElement w :  options) {
				String o = w.getText();
				//System.out.println("options are "+o);
				
				if(o.equalsIgnoreCase(option)) {
					
					w.click();
				}
				
			}
			status = true;
		}
		return status;
	}
	

	
	

}
