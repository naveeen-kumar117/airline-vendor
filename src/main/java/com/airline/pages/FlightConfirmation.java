package com.airline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airline.common.AbstractPage;

public class FlightConfirmation extends AbstractPage{
	
	private static final Logger log = LoggerFactory.getLogger(FlightConfirmation.class);
	
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(1) .col:nth-child(2)")
	private WebElement flight_confirmation;
	
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(3) .col:nth-child(2)")
	private WebElement total_price;
	
	@FindBy(css = "#flights-confirmation-section .card-body .row:nth-child(2) .col:nth-child(2)")
	private WebElement tax;
	
	

	public FlightConfirmation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(flight_confirmation));
		return this.flight_confirmation.isDisplayed();
	}
	
	public String details() {
		
		log.info("Status" + this.flight_confirmation.getText() + " TOTAL PRICE" + this.total_price.getText());
		
		return this.total_price.getText();
		
	}

}
