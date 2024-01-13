package com.airline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.airline.common.AbstractPage;

public class Registration extends AbstractPage{
	
	
	@FindBy(id = "firstName")
	private WebElement firstName;
	
	@FindBy(id = "lastName")
	private WebElement lastName;
	
	@FindBy(id = "email")
	private WebElement email;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(name = "street")
	private WebElement street;
	
	@FindBy(name = "city")
	private WebElement city;
	
	@FindBy(id = "inputState")
	private WebElement state;
	
	@FindBy(name = "zip")
	private WebElement zip;
	
	@FindBy(id = "register-btn")
	private WebElement register_button;
	
		public Registration(WebDriver driver) {
		super(driver);
	}
	
	public void goToPage(String url) {
		this.driver.get(url);
	}
	
	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
        this.wait.until(ExpectedConditions.visibilityOf(this.firstName));
        return this.firstName.isDisplayed();
	}
	
	public void enter_userDetails(String first_name, String last_name,String email, String password, String street, String city, String state, String zip) {
		
		this.firstName.sendKeys(first_name);
		this.lastName.sendKeys(last_name);
		this.email.sendKeys(email);
		this.password.sendKeys(password);
		this.street.sendKeys(street);
		Select select_state = new Select(this.state);
		select_state.selectByVisibleText(state);
		this.city.sendKeys(city);
		this.zip.sendKeys(zip);
		
	}
	
	public void register_user() {
		this.register_button.click();
	}



}
