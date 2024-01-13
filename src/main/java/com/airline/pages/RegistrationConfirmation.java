package com.airline.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.airline.common.AbstractPage;

public class RegistrationConfirmation extends AbstractPage{
	
	@FindBy(id = "go-to-flights-search")
	private WebElement flight_search_btn;
	

	
	public RegistrationConfirmation(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
	
	}
	
	public void printMessage() {
		
		String message =  this.driver.findElement(By.xpath("//*[@id=\"registration-confirmation-section\"]/div/div/div/p")).getText();
		
		System.out.println(message);
	}
	
	public void goToFlight() {
		
		this.flight_search_btn.click();
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(flight_search_btn));
		return this.flight_search_btn.isDisplayed();
	}
	
	

}
