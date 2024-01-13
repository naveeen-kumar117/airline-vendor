package com.base.listener;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.airline.utils.Constants;

public class TestListener implements ITestListener {


	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot screenshot =  (TakesScreenshot) result.getTestContext().getAttribute(Constants.DRIVER);
		
		String img =  screenshot.getScreenshotAs(OutputType.BASE64);
		
		String htmlImageFormat = "<img width=700px src='data:image/png;base64,%s' />";
		
		String htmlImg = String.format(htmlImageFormat, img);
		
		Reporter.log(htmlImg);
		
		
	}




}
