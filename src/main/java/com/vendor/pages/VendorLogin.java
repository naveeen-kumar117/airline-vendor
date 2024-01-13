package com.vendor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterTest;

import com.airline.common.AbstractPage;

public class VendorLogin extends AbstractPage {

	
	@FindBy(id = "username")
	private WebElement username;
	
	@FindBy(id = "password")
	private WebElement password;
	
	@FindBy(id = "login")
	private WebElement login_btn;
	
	public VendorLogin(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(login_btn));
		return this.login_btn.isDisplayed();
	}
	
	
	public void goToPage(String url1) {
		System.out.println(url1);
		this.driver.get(url1);
	}
	
	public void login(String username, String password) {
		
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		
		this.login_btn.click();
	
	}
	
	
	
	

}
