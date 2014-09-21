package com.seleniumtests.pageobject;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class Welcome {
	private WebDriver driver;
	
	public Welcome(WebDriver driver) {
		this.driver = driver;
	}
	
	@CacheLookup
	@FindBy(className = "title")
	WebElement Title;
	
	@CacheLookup
	@FindBy(className = "portlet-msg-error")
	WebElement errors;


	public boolean WelcomeFree() {
		boolean b1 = Title.getText().contains("Welcome Free Member!");
		return b1;
	}
	
	public boolean WelcomeClub() {
		boolean b2 = Title.getText().contains("You are a Club Member!");
		return b2;	
	}

	/*public boolean Errors() {
		boolean b2 = false;
		if(errors.getText().contains("You already have an account") || errors.getText().contains("Please try again") || errors.getText().contains("Please enter") || errors.getText().contains("You must be 13 years"))
		{
		b2 = true;
		}
		//boolean b2 = assertEquals(driver.findElements(By.id("*.errors")).size(), 1);
		return b2;	
	}*/
	
	
}
