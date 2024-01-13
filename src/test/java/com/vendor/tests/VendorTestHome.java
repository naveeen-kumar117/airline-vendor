package com.vendor.tests;

import org.testng.Assert;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.airline.testData.VendorRecords;
import com.airline.utils.Config;
import com.airline.utils.Constants;
import com.airline.utils.JSONUtils;
import com.base.test.AbstractTest;
import com.vendor.pages.VendorDashboard;
import com.vendor.pages.VendorLogin;
public class VendorTestHome extends AbstractTest{

	private VendorLogin login;
	private VendorDashboard dashboard;
	private VendorRecords records;
	
	@BeforeTest
	@Parameters("recordsPath")
	public void setPageObjects(String recordsPath) {
		login = new VendorLogin(this.driver);
		dashboard = new VendorDashboard(this.driver);
	
		this.records = JSONUtils.getVendorRecords(recordsPath,VendorRecords.class);
	}
	
	@Test
	public void login_page() {
		
		login.goToPage(Config.get(Constants.VENDOR_PORTAL));
		Assert.assertTrue(login.isAt());
		
		login.login(records.username(), records.password());
	}
	
	@Test(dependsOnMethods = "login_page")
	public void dashboard_test() {
		
		
		Assert.assertTrue(dashboard.isAt());
		
		Assert.assertEquals(dashboard.getMonthlyEarning(), records.monthlyEarning());
		Assert.assertEquals(dashboard.getAnnualEarning(), records.annualEarning());
		
		dashboard.search_data(records.search());
		
		Assert.assertEquals(dashboard.search_results(), records.searchCount());
		
		dashboard.logout();
	}

}
