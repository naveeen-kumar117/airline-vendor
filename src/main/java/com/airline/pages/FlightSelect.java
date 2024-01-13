package com.airline.pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.airline.common.AbstractPage;

public class FlightSelect extends AbstractPage{
	
	@FindBy(name = "departure-flight")
	private List<WebElement> depatureOptions;
	
	@FindBy(name ="arrival-flight")
	private List<WebElement> arrivalOptions;
	
	@FindBy(id = "confirm-flights")
	private WebElement confirm_btn;

	public FlightSelect(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(this.confirm_btn));
		return this.confirm_btn.isDisplayed();
	}
	
	public void selectFlight() {
		
		int random= ThreadLocalRandom.current().nextInt(0,this.depatureOptions.size());
		
		this.depatureOptions.get(random).click();
		this.arrivalOptions.get(random).click();
		
		this.confirm_btn.click();
		
	}

}
