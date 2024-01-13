package com.base.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import com.airline.utils.Config;
import com.airline.utils.Constants;
import com.base.listener.TestListener;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.util.Constant;

@Listeners({TestListener.class})
public abstract class AbstractTest {
	
	private static final Logger log = LoggerFactory.getLogger(AbstractTest.class);

	protected WebDriver driver;
	
	@BeforeSuite
	public void call_config() {
		
		Config.initialize();
		
	}
	
	@BeforeTest
	public void setUp(ITestContext context) throws MalformedURLException {
		
		this.driver = (Boolean.parseBoolean(Config.get(Constants.GRID_ENABLED))) ?  getRemoteDriver(): getLocalDriver();
			
		context.setAttribute(Constants.DRIVER, this.driver);
		//this.driver.manage().window().maximize();
	}
	
	private WebDriver getLocalDriver() {
		WebDriverManager.chromedriver().setup();
		return new ChromeDriver();
	}
	
	private WebDriver getRemoteDriver() throws MalformedURLException {
		
		Capabilities capabilities= new ChromeOptions();
		if(Constants.FIREFOX.equalsIgnoreCase(Config.get(Constants.BROWSER))) {
			capabilities= new FirefoxOptions(); 
		}
								//url, capabilities
		String url_format = Config.get(Constants.GRID_URL_FORMAT);
		String hub_host = Config.get(Constants.GRID_HOST_ADDRESS);
		
		String url = String.format(url_format, hub_host);
		
		log.info("\nGRID URL --->"+url);
		
		return new RemoteWebDriver(new URL(url),capabilities);
		
	}
	
	@AfterTest
	public void tearDown() {
		
		this.driver.quit();
		
	}
	
	
}
