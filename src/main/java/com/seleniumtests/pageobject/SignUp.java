package com.seleniumtests.pageobject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.seleniumtests.utility.Log;

public class SignUp {
	private WebDriver driver;
	
	public SignUp(WebDriver driver) {
		this.driver = driver;
	}
	@CacheLookup
	@FindBy(css = "img[alt*='Sign me up for FREE membership'][src*='/home/-/image_get_file/82da26e9-ad87-4ec9-a37c-1fab5f55141e']")
	WebElement freeSignup;
	
	@CacheLookup
	@FindBy(css = "img[alt*='YES! Sign me up for Club membership'][src*='/home/-/image_get_file/3fbe16a5-d075-46f7-aebb-43d54b15bded']")
	WebElement clubSignup;

	private TimeUnit SECONDS;
	
	public FreeSignupPage clickFreeSignup() {
		freeSignup.click();
		Log.info("Free SignUp found");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.manage().timeouts().pageLoadTimeout(25, SECONDS);
		return PageFactory.initElements(driver, FreeSignupPage.class);
	}
	
	public ClubSignupPage clickClubSignup() {
		clubSignup.click();
		Log.info("Club SignUp found");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return PageFactory.initElements(driver, ClubSignupPage.class);
	}
}
