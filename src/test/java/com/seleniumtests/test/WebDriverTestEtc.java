package com.seleniumtests.test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.seleniumtests.core.CustomVerification;
import com.seleniumtests.core.DriverFactory;

public class WebDriverTestEtc extends DriverFactory{
		
	@Test (enabled=false)
	public void hardAssertion() {
		driver.get(appURL);
		Assert.assertTrue("first name field is missing",
				driver.findElements(By.name("firstName")).size() == 1);
		
		 //Deliberate  test failure
		/*Assert.assertTrue("last name field is missing",
				driver.findElements(By.name("wrongLastName")).size() == 1);
		Assert.assertTrue("Phone number field is missing",
				driver.findElements(By.name("wrongPhoneNumber")).size() == 1);
		
		Assert.assertTrue("email address field is missing",
				driver.findElements(By.name("userName")).size() == 1);*/
	}
	
	/**
	 * Test method execution continues even if any assertion fails
	 */
	@Test (enabled=false)
	public void softAssertion() {
		driver.get(appURL);
		CustomVerification customVerification = new CustomVerification();
		customVerification.verifyTrue("first name field is missing",
				driver.findElements(By.name("firstName")).size() == 1);
		
		// Deliberate  test failure but yet test execution continues
		customVerification.verifyTrue("last name field is missing",
				driver.findElements(By.name("wrongLastName")).size() == 1);
		customVerification.verifyTrue("Phone number field is missing",
				driver.findElements(By.name("wrongPhoneNumber")).size() == 1);
		
		customVerification.verifyTrue("email address field is missing",
				driver.findElements(By.name("userName")).size() == 1);
		customVerification.checkForVerificationErrors();
	}

}
