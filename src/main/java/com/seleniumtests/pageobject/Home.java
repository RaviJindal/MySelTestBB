package com.seleniumtests.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;


public class Home {

	private WebDriver driver;

	public Home(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(linkText = "Not a Member?")
	WebElement notAMember;
	
	public SignUp clickNotAMember() {
		notAMember.click();
		return PageFactory.initElements(driver, SignUp.class);
	}
	/*public SignUp createNewUser(BBRegistrationData registrationData) {
		Reporter.log("firstName: " +registrationData.getFirstName()+"<br>");
		Reporter.log("lastName: " +registrationData.getLastName()+"<br>");
		Reporter.log("phone: " +registrationData.getPhoneNumber()+"<br>");
		Reporter.log("userName: " +registrationData.getUserName()+"<br>");
		Reporter.log("country: " +registrationData.getCountry()+"<br>");
		Reporter.log("email: " +registrationData.getEmail()+"<br>");
		Reporter.log("password: " +registrationData.getPassword()+"<br>");
		Reporter.log("confirmPassword: " +registrationData.getConfirmPassword()+"<br>");
		return enterFirstName(registrationData.getFirstName())
				.enterLastName(registrationData.getLastName())
				.enterPhone(registrationData.getPhoneNumber())
				.enterUserName(registrationData.getUserName())
				.selectCountry(registrationData.getCountry())
				.enterEmail(registrationData.getEmail())
				.enterPassword(registrationData.getPassword())
				.enterConfirmPassword(registrationData.getConfirmPassword())
				.clickRegister();
	}*/
}
