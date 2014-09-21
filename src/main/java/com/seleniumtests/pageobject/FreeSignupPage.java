package com.seleniumtests.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.seleniumtests.dataobject.BBRegistrationData;
//import com.seleniumtests.dataobject.RegistrationData;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class FreeSignupPage {
	private WebDriver driver;

	public FreeSignupPage(WebDriver driver) {
		this.driver = driver;
	}

	@CacheLookup
	@FindBy(name = "loginForm.firstName")
	WebElement firstName;

	@CacheLookup
	@FindBy(name = "loginForm.lastName")
	WebElement lastName;

	@CacheLookup
	@FindBy(name = "emailForm.email")
	WebElement email;

	@CacheLookup
	@FindBy(name = "emailForm.confirmEmail")
	WebElement confirmEmail;

	@CacheLookup
	@FindBy(name = "passwordScreennameForm.password")
	WebElement password;

	@CacheLookup
	@FindBy(name = "passwordScreennameForm.confirmPassword")
	WebElement confirmPassword;

	@CacheLookup
	@FindBy(name = "passwordScreennameForm.screenName")
	WebElement screenName;

	@CacheLookup
	@FindBy(name = "_TBBSIGNUP_WAR_signuprefactorportlet_birthdayYear")
	WebElement dateOfBirth;
	
	@CacheLookup
	@FindBy(name = "profile.phone")
	WebElement phoneTextbox;	
	
	@CacheLookup
	@FindBy(name = "shippingAddressForm.street1")
	WebElement shippingStreet1;
	
	@CacheLookup
	@FindBy(name = "shippingAddressForm.street2")
	WebElement shippingStreet2;
	
	@CacheLookup
	@FindBy(name = "shippingAddressForm.city")
	WebElement shippingCity;	
	
	@CacheLookup
	@FindBy(name = "addressRegionId")
	WebElement shippingState;	
	
	@CacheLookup
	@FindBy(name = "shippingAddressForm.postalCode")
	WebElement shippingZip;
	
	@CacheLookup
	@FindBy(name = "addressCountryId")
	WebElement shippingCountry;	

	@CacheLookup
	//@FindBy(id = "_TBBSIGNUP_WAR_signuprefactorportlet_coachExistingMessage")//_TBBSIGNUP_WAR_signuprefactorportlet_selectMyCoachMessage
	@FindBy(name = "profile.coachSelectedInput")
	public List<WebElement>  coachReferral;
	
	@CacheLookup
	@FindBy(id = "coachLookupType")
	WebElement  pleaseSelect;
	
	@CacheLookup
	@FindBy(id = "coachSearchField")
	WebElement  searchCriteria;
	
	@CacheLookup
	@FindBy(id = "_TBBSIGNUP_WAR_signuprefactorportlet_lookupCoachBtn")
	WebElement  confirmCoach;
	
	@CacheLookup
	@FindBy(name = "termsAndConditionsForm.termsAndConditionsAgree")
	WebElement TnC;		
	
	@CacheLookup
	@FindBy(name = "termsAndConditionsForm.canadaOptIn")
	WebElement CASL;	
	
	@CacheLookup
	@FindBy(name = "_TBBSIGNUP_WAR_signuprefactorportlet_captchaText")
	WebElement captchaText;	
	
	@CacheLookup
	@FindBy(id = "free_submit")
	WebElement submitFreeSignup;

	private TimeUnit SECONDS;	
	
	
	public FreeSignupPage enterFirstName(String fName) {
		firstName.sendKeys(fName);
		return this;
	}

	public FreeSignupPage enterLastName(String lName) {
		lastName.sendKeys(lName);
		return this;
	}

	public FreeSignupPage enterEmail(String mail) {
		email.sendKeys(mail);
		return this;
	}

	public FreeSignupPage enterConfirmEmail(String confirmmail) {
		confirmEmail.sendKeys(confirmmail);
		return this;
	}

	public FreeSignupPage enterPassword(String pw) {
		password.sendKeys(pw);
		return this;
	}

	public FreeSignupPage enterConfirmPassword(String email) {
		confirmPassword.sendKeys(email);
		return this;
	}

	public FreeSignupPage enterScreenName(String screenname) {
		screenName.sendKeys(screenname);
		return this;
	}
	
	public FreeSignupPage enterDateOfBirth(String dob) {
		new Select(dateOfBirth).selectByVisibleText(dob);
		return this;
	}
	
	public FreeSignupPage enterPhoneTextbox(String phone) {
		phoneTextbox.sendKeys(phone);
		return this;
	}
	
	public FreeSignupPage enterShippingCountry(String country) {
		new Select(shippingCountry).selectByVisibleText(country);
		return this;
	}
	
	public FreeSignupPage enterShippingStreet1(String street1) {
		shippingStreet1.sendKeys(street1);
		return this;
	}
	
	public FreeSignupPage enterShippingStreet2(String street2) {
		shippingStreet2.sendKeys(street2);
		return this;
	}
	
	public FreeSignupPage enterShippingCity(String city) {
		if (shippingCountry.isDisplayed())
			shippingCity.sendKeys(city);
		return this;
	}
	
	public FreeSignupPage enterShippingState(String state) {
		new Select(shippingState).selectByVisibleText(state);
		return this;
	}
	
	public FreeSignupPage enterShippingZip(String zip) {
		shippingZip.sendKeys(zip);
		return this;
	}
	

	
	public FreeSignupPage enterCoachReferral(Boolean value, String coachId) {
	/*
		if (value=false){
		 int cbSize = coachReferral.size();
		 for(int i=0; i < cbSize ; i++ ){
	     String sValue = coachReferral.get(i).getAttribute("value");
	     if (sValue.equalsIgnoreCase("6")){
		 	    	 coachReferral.get(i).click();
			         break;
			         }
			    }
		
		}
	*/
		//boolean bValue = false;
		//bValue = coachReferral.get(0).isSelected();

		 if(value == true){
			 coachReferral.get(0).click();
				new Select(pleaseSelect).selectByVisibleText("Coach I.D.");
				searchCriteria.sendKeys(coachId);
				while (1==1){
				confirmCoach.click();
				if(driver.findElement(By.tagName("body")).getText().contains("Corporate Test"))
					break;
				else if (driver.findElement(By.tagName("body")).getText().contains("not found"))
					{
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					    WebDriverWait wait = new WebDriverWait(driver, 15);
					    WebElement element= driver.findElement(By.id("_TBBSIGNUP_WAR_signuprefactorportlet_coachErrorMessageDiv"));
					    wait.until(ExpectedConditions.visibilityOf(element));   
					//driver.manage().timeouts().pageLoadTimeout(25, SECONDS);
					coachReferral.get(1).click();
					break;
					}
				}
						 
		 }try { if (value == false)
			 coachReferral.get(1).click();}
		 catch(NullPointerException  e){}
		 
		 
		return this;
	}

	
	public FreeSignupPage enterTnC(Boolean value) {
		if (value==true)
		TnC.click();										//CheckBox
		return this;
	}
	
	public FreeSignupPage enterCASL(Boolean value) {
		if (value==true)
		CASL.click();										//CheckBox
		return this;
	}
	
	public FreeSignupPage enterCaptcha(String captcha) {
		captchaText.sendKeys(captcha);
		return this;
	}
	

	public Welcome clickSubmit() {
		submitFreeSignup.click();
		return PageFactory.initElements(driver, Welcome.class);
	}

	public Welcome createNewUser(BBRegistrationData registrationData) {
		Reporter.log("firstName: " +registrationData.getFirstName()+"<br>");
		Reporter.log("lastName: " +registrationData.getLastName()+"<br>");
		Reporter.log("email: " +registrationData.getEmail()+"<br>");
		Reporter.log("confirmEmail: " +registrationData.getConfirmEmail()+"<br>");
		Reporter.log("password: " +registrationData.getPassword()+"<br>");
		Reporter.log("confirmPassword: " +registrationData.getConfirmPassword()+"<br>");
		Reporter.log("screenName: " +registrationData.getScreenName()+"<br>");
		Reporter.log("dateOfBirth: " +registrationData.getDateOfBirth()+"<br>");
		Reporter.log("phoneTextbox: " +registrationData.getPhoneTextbox()+"<br>");
		Reporter.log("shippingStreet1: " +registrationData.getShippingStreet1()+"<br>");
		Reporter.log("shippingStreet2: " +registrationData.getShippingStreet2()+"<br>");
		Reporter.log("shippingCity: " +registrationData.getShippingCity()+"<br>");
		Reporter.log("shippingState: " +registrationData.getShippingState()+"<br>");
		Reporter.log("shippingZip: " +registrationData.getShippingZip()+"<br>");
		Reporter.log("shippingCountry: " +registrationData.getShippingCountry()+"<br>");
		Reporter.log("coachReferral: " +registrationData.getCoachReferral()+"<br>");
		Reporter.log("coachReferral: " +registrationData.getCoachId()+"<br>");
		Reporter.log("TnC: " +registrationData.getTnC()+"<br>");
		Reporter.log("CASL: " +registrationData.getCASL()+"<br>");
		Reporter.log("captchaText: " +registrationData.getCaptchaText()+"<br>");
		return 	enterFirstName(registrationData.getFirstName())
		.enterLastName(registrationData.getLastName())
		.enterEmail(registrationData.getEmail())
		.enterConfirmEmail(registrationData.getConfirmEmail())
		.enterPassword(registrationData.getPassword())
		.enterConfirmPassword(registrationData.getConfirmPassword())
		.enterScreenName(registrationData.getScreenName())
		.enterDateOfBirth(registrationData.getDateOfBirth())
		.enterPhoneTextbox(registrationData.getPhoneTextbox())
		.enterShippingCountry(registrationData.getShippingCountry())
		.enterShippingStreet1(registrationData.getShippingStreet1())
		.enterShippingStreet2(registrationData.getShippingStreet2())
		.enterShippingCity(registrationData.getShippingCity())
		.enterShippingState(registrationData.getShippingState())
		.enterShippingZip(registrationData.getShippingZip())
		.enterCoachReferral(registrationData.getCoachReferral(),registrationData.getCoachId())
		.enterTnC(registrationData.getTnC())
		.enterCASL(registrationData.getCASL())
		.enterCaptcha(registrationData.getCaptchaText())
		.clickSubmit();
	}
}

