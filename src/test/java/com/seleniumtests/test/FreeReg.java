package com.seleniumtests.test;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.seleniumtests.core.CustomVerification;
import com.seleniumtests.core.DriverFactory;
import com.seleniumtests.dataobject.BBRegistrationData;
import com.seleniumtests.dataobject.BBRegistrationDataClub;
import com.seleniumtests.pageobject.ClubSignupPage;
import com.seleniumtests.pageobject.FreeSignupPage;
import com.seleniumtests.pageobject.Home;
import com.seleniumtests.pageobject.SignUp;
import com.seleniumtests.pageobject.Welcome;

public class FreeReg extends DriverFactory {
	
	@Test(dataProvider = "regCSVDataBB", dataProviderClass = BBRegistrationData.class, enabled=true)
	public void newFreeRegistrationUsingCSVFile(BBRegistrationData registrationData) {
		driver.get(appURL);
		Home newHome = PageFactory.initElements(driver,
				Home.class);
		newHome.clickNotAMember();
		SignUp newSignUp = PageFactory.initElements(driver,
				SignUp.class);
		newSignUp.clickFreeSignup();
		FreeSignupPage registration = PageFactory.initElements(driver,
				FreeSignupPage.class);
		registration.createNewUser(registrationData);
		assert driver
				.findElement(By.tagName("body"))
				.getText()
				.contains(
						"Welcome");
	}
	

	@Test(dataProvider = "regDataBB", dataProviderClass = BBRegistrationData.class, enabled=false)
	public void newFreeRegistrationUsingDP2(BBRegistrationData registrationData) {
		driver.get(appURL);
		Home newHome = PageFactory.initElements(driver,
				Home.class);
		newHome.clickNotAMember();
		SignUp newSignUp = PageFactory.initElements(driver,
				SignUp.class);
		newSignUp.clickFreeSignup();
		FreeSignupPage registration = PageFactory.initElements(driver,
				FreeSignupPage.class);
		registration.createNewUser(registrationData);
		assert driver
				.findElement(By.tagName("body"))
				.getText()
				.contains(
						"You already have an account with us! ");
	}

	
	/**
	 * Data driven testing using csv file
	 * 
	 * @param registrationData
	 */

}
