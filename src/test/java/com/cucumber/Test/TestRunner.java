package com.cucumber.Test;

import java.lang.reflect.InvocationTargetException;

import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import frameworkcore.webdriverFactory.DriverManager;

//@RunWith(Cucumber.class)

@CucumberOptions
(features={"src\\test\\resources\\Features\\cucumbertest.feature"},
glue={"com.cucumber.TestSteps"},
tags = {},
//dryRun = true,
plugin = {"com.cucumber.listener.ExtentCucumberFormatter:Reporting/CucumberReports/report.html"})
public class TestRunner extends AbstractTestNGCucumberTests {
	
	private static Logger logger = LoggerFactory.getLogger(TestRunner.class);
    protected static WebDriver driver;
	
	@BeforeTest @Parameters ({"BrowserName"})
	public static void InitializeTest( String BrowserName) throws InvocationTargetException, IllegalAccessException{
			
		/*List<String> list = new ArrayList<String>();
		 Properties properties = new Properties();
		    properties.setProperty("cucumber.options", "--tags @foo");
		    RuntimeOptions runtimeOptions = new RuntimeOptions(new Env(
		            properties), list);*/
		
		logger.info("Inside Runner class");
		
		try{
			driver = DriverManager.getDriver(BrowserName);
			}catch(Exception e){
				logger.error("not able to initialize Webdriver. Please check the logs");
				logger.error(e.toString());
			}
	}

	    @AfterTest
	    public void afterMethod() {
	    	DriverManager.quitDriver();
	    }
	
	
}
