package com.airline.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import com.airline.common.AbstractPage;

public class FlightSearch extends AbstractPage {

	@FindBy(id = "oneway")
	private WebElement trip_mode;
	
	@FindBy(id = "passengers")
	private WebElement passengers;
	
	@FindBy(id = "depart-from")
	private WebElement departure;
	
	@FindBy(id = "arrive-in")
	private WebElement arrival;
	
	@FindBy(id = "service-class1")
	private WebElement service_class;
	
	@FindBy(id = "search-flights")
	private WebElement search_flight_btn;
	
	public FlightSearch(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.departure));
		return this.departure.isDisplayed();
	}
	
	public void trip_details(String passengers, String depature, String arrival) {
		
		this.trip_mode.click();
		Select s_pass= new Select(this.passengers);
		s_pass.selectByVisibleText(passengers);
		
		Select s_dep=new Select(this.departure);
		s_dep.selectByVisibleText(depature);
		
		Select s_arrival = new Select(this.arrival);
		s_arrival.selectByVisibleText(arrival);
		
		this.service_class.click();
		this.search_flight_btn.click();
	}
	
	
	
}
