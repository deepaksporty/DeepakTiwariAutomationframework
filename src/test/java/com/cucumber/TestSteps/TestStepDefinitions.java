package com.cucumber.TestSteps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.AssertJUnit;

import com.cucumber.Test.TestRunner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestStepDefinitions extends TestRunner{
	
	private static Logger logger = LoggerFactory.getLogger(TestStepDefinitions.class);
	
	
	@Given("^open Gmail$")
	public void open_Gmail(){
		
		
		logger.info("Open Gmail");
		driver.get("https://accounts.google.com");
	}

	@When("^Login to Gmail$")
	public void login_to_Gmail(){
		
		logger.info("Login to Gmail");
	}

	@Then("^Login Successful$")
	public void login_Successful(){
		logger.info("Login to Gmail Successful");
		AssertJUnit.assertTrue("This Step Failed", false);
	}
	
	
	
}
