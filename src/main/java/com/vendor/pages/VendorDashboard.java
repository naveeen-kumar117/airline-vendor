package com.vendor.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.airline.common.AbstractPage;

public class VendorDashboard extends AbstractPage{
	
	@FindBy(id = "monthly-earning")
	private WebElement monthlyEarning;
	
	@FindBy(id="annual-earning")
	private WebElement annualEarning;
	
	@FindBy(id = "profit-margin")
	private WebElement profitMargin;
	
	@FindBy(id="available-inventory")
	private WebElement inventory;
	
	@FindBy(css = "#dataTable_filter input")
	private WebElement search;
	
	@FindBy(id = "dataTable_info")
	private WebElement result;
	
	@FindBy(xpath = "//*[@id=\"userDropdown\"]/img")
	private WebElement profile;
	
	@FindBy(linkText = "Logout")
	private WebElement logout;
	
	@FindBy(css = "#logoutModal a")
	private WebElement logout_button;

	private static final Logger log =  LoggerFactory.getLogger(VendorDashboard.class);
	
	public VendorDashboard(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean isAt() {
		// TODO Auto-generated method stub
		this.wait.until(ExpectedConditions.visibilityOf(annualEarning));
		return this.annualEarning.isDisplayed();
	}
	
	public String getMonthlyEarning() {
		
		return this.monthlyEarning.getText();
	}
	
	public String getAnnualEarning() {
		return this.annualEarning.getText();
	}
	
	public String getProfit() {
		return this.getProfit();
		
	}
	
	public void search_data(String data) {
		
		this.search.sendKeys(data);
	}

	public int search_results() {
		
		String local = this.result.getText();
		String[] arr = local.split(" ");
		
		int result = Integer.parseInt(arr[5]);
		
		log.info("Results ---> "+result);
		
		return result;
	}
	
	public void logout() {
		
		this.profile.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.logout));
		
		this.logout.click();
		this.wait.until(ExpectedConditions.visibilityOf(this.logout_button));
		this.logout_button.click();
	}
}
