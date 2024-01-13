package com.airline.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.airline.pages.FlightConfirmation;
import com.airline.pages.FlightSearch;
import com.airline.pages.FlightSelect;
import com.airline.pages.Registration;
import com.airline.pages.RegistrationConfirmation;
import com.airline.testData.AirlineRecord;
import com.airline.utils.Config;
import com.airline.utils.Constants;
import com.airline.utils.JSONUtils;
import com.base.test.AbstractTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AirlineTestHome extends AbstractTest{
	
	
	private AirlineRecord record;
	
	@BeforeTest
	@Parameters("recordsPath")
	public void setParameters(String recordPath) {
		this.record = JSONUtils.getVendorRecords(recordPath, AirlineRecord.class);
	}
	
	@Test
	public void user_registration() {
		
		Registration registration = new Registration(this.driver);
		
		registration.goToPage(Config.get(Constants.AIRLINE_RESERVATION));
		
		Assert.assertTrue(registration.isAt());
		
		registration.enter_userDetails(this.record.firstName(), 
				this.record.lastName(), 
				this.record.email(),
				this.record.password(), 
				this.record.street(),
				this.record.city(),
				"New York", this.record.zip());
		
		registration.register_user();
		
	}
	
	@Test(dependsOnMethods = "user_registration")
	public void registration_confirmation() {
		
		RegistrationConfirmation regconf = new RegistrationConfirmation(this.driver);
		Assert.assertTrue(regconf.isAt());
		
		regconf.goToFlight();
		
	}
	
	@Test(dependsOnMethods = "registration_confirmation")
	public void flight_search() {
		
		FlightSearch flight_search = new FlightSearch(this.driver);
		Assert.assertTrue(flight_search.isAt());
		
		flight_search.trip_details("Two", "New York", "London");
		
	}
	
	@Test(dependsOnMethods = "flight_search")
	public void flight_select() {
		FlightSelect flight_select = new FlightSelect(this.driver);
		Assert.assertTrue(flight_select.isAt());
		
		flight_select.selectFlight();
	}
	
	@Test(dependsOnMethods = "flight_select")
	public void flight_confirmation() {
		FlightConfirmation confirmation = new FlightConfirmation(this.driver);
		Assert.assertTrue(confirmation.isAt());
		
		String result = confirmation.details();

	}
	
}
