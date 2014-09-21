	package com.seleniumtests.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.seleniumtests.dataobject.BBRegistrationDataClub;
import com.seleniumtests.utility.Log;
import com.thoughtworks.selenium.Wait;
import com.thoughtworks.selenium.webdriven.commands.WaitForPageToLoad;

public class ClubSignupPage {
	private WebDriver driver;

	public ClubSignupPage(WebDriver driver) {
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
	@FindBy(name = "billingInfo.cardHolderFirstName")
	WebElement ccFirstName;
	
	@CacheLookup
	@FindBy(name = "billingInfo.cardHolderLastName")
	WebElement ccLastName;
	
	@CacheLookup
	@FindBy(name = "billingInfo.ccType")
	WebElement ccType;	

	@CacheLookup
	@FindBy(name = "billingInfo.ccNumber")
	WebElement ccNumber;
	
	@CacheLookup
	@FindBy(name = "billingInfo.expYear")
	WebElement ccExp;
	
	@CacheLookup
	@FindBy(name = "billingInfo.cvv")
	WebElement ccCvv;
	
	@CacheLookup
	@FindBy(name = "billingAddressForm.billingSameAsShipping")
	WebElement billingCB;	

	
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
	
	//@CacheLookup
	//@FindBy(name = "termsAndConditionsForm.canadaOptIn")
	//WebElement CASL;	
	
	@CacheLookup
	@FindBy(name = "_TBBSIGNUP_WAR_signuprefactorportlet_captchaText")
	WebElement captchaText;	
	
	@CacheLookup
	@FindBy(id = "club_submit")
	WebElement submitClubSignup;
	
	@CacheLookup
	@FindBy(id = "*.errors")
	WebElement errors;

	private TimeUnit SECONDS;	
	
	
	public ClubSignupPage enterFirstName(String fName) {
		try{firstName.sendKeys(fName);
		Log.info("First Name picked from Excel is "+ fName );}
		catch(NullPointerException  e){}
		return this;
	}

	public ClubSignupPage enterLastName(String lName) {
		try{lastName.sendKeys(lName);
		Log.info("Last Name picked from Excel is "+ lName );
		}
		catch(NullPointerException  e){}
		return this;
	}

	public ClubSignupPage enterEmail(String mail) {
		try{email.sendKeys(mail);
		Log.info("Email picked from Excel is "+ mail );}
	catch(NullPointerException  e){}
		return this;
	}

	public ClubSignupPage enterConfirmEmail(String confirmmail) {
		try{confirmEmail.sendKeys(confirmmail);}
		catch(NullPointerException  e){}
		return this;
	}

	public ClubSignupPage enterPassword(String pw) {
		try{password.sendKeys(pw);
		Log.info("Password picked from Excel is "+ pw );}
		catch(NullPointerException  e){}
		return this;
	}

	public ClubSignupPage enterConfirmPassword(String email) {
		try{confirmPassword.sendKeys(email);}
		catch(NullPointerException  e){}
		return this;
	}

	public ClubSignupPage enterScreenName(String screenname) {
		try{screenName.sendKeys(screenname);
		Log.info("ScreenName picked from Excel is "+ screenname );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterDateOfBirth(String dob) {
		try{new Select(dateOfBirth).selectByVisibleText(dob);
		Log.info("DOB picked from Excel is "+ dob );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterPhoneTextbox(String phone) {
		try{phoneTextbox.sendKeys(phone);
		Log.info("Phone no picked from Excel is "+ phone );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterShippingCountry(String country) {
		try{new Select(shippingCountry).selectByVisibleText(country);
		Log.info("Shipping Country picked from Excel is "+ country );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterShippingStreet1(String street1) {
		try{shippingStreet1.sendKeys(street1);}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterShippingStreet2(String street2) {
		try{shippingStreet2.sendKeys(street2);}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterShippingCity(String city) {
		if (shippingCountry.isDisplayed())
			try{shippingCity.sendKeys(city);
			Log.info("Shipping City picked from Excel is "+ city );}
			catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterShippingState(String state) {
		try{new Select(shippingState).selectByVisibleText(state);
		Log.info("Shipping State picked from Excel is "+ state );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterShippingZip(String zip) {
		try{shippingZip.sendKeys(zip);
		Log.info("Shipping ZIP picked from Excel is "+ zip );}
		catch(NullPointerException  e){}
		return this;
	}
	
	
	public ClubSignupPage enterCCFirstName(String ccfname) {
		try{ccFirstName.sendKeys(ccfname);}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterCCLastName(String cclname) {
		try{ccLastName.sendKeys(cclname);}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterCCType(String cctype) {
		try{new Select(ccType).selectByVisibleText(cctype);
		Log.info("Credit Card picked from Excel is "+ cctype );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterCCNumber(String ccnum) {
		try{ccNumber.sendKeys(ccnum);
		Log.info("Credit Card Number picked from Excel is "+ ccnum );}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterCCExp(String ccexp) {
		try{new Select(ccExp).selectByVisibleText(ccexp);}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage enterCVV(String cvv) {
		try{ccCvv.sendKeys(cvv);}
		catch(NullPointerException  e){}
		return this;
	}
	
	public ClubSignupPage clickBillingCB(Boolean billCB) {
		if(billCB==true)
		{
		try{billingCB.click();}
		catch(NullPointerException  e){}
		}
		return this;
	}
	
	public ClubSignupPage enterCoachReferral(Boolean value, String coachId) {
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
		try{
		 if(value == true){
			 coachReferral.get(0).click();
				new Select(pleaseSelect).selectByVisibleText("Coach I.D.");
					try{searchCriteria.sendKeys(coachId);
					Log.info("Coach Id provided from Excel is "+ coachId );}
					catch(NullPointerException  e){}
				while (1==1){
					confirmCoach.click();
				if(driver.findElement(By.tagName("body")).getText().contains("Corporate Test"))
					break;
				else if (driver.findElement(By.tagName("body")).getText().contains("not found"))
					{
					System.out.println("Invalid Coach Provided, it will be selected by lead wheel now");
					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					    WebDriverWait wait = new WebDriverWait(driver, 15);
					    WebElement element= driver.findElement(By.id("_TBBSIGNUP_WAR_signuprefactorportlet_coachErrorMessageDiv"));
					    wait.until(ExpectedConditions.visibilityOf(element));   // 	presenceOfElementLocated
					//driver.manage().timeouts().pageLoadTimeout(25, SECONDS);
					coachReferral.get(1).click();
					break;
					}
				}
						 
		 }if (value == false)
			 coachReferral.get(1).click();
		 }
		 catch(NullPointerException  e){}
		 
		return this;
	}

	
	public ClubSignupPage enterTnC(Boolean value) {
		try{
		if (value==true)
		TnC.click();
		System.out.println("TNC"+value);
		}		//CheckBox
		catch(NullPointerException  e){}
		return this;
		}
	
	protected boolean isElementHiddenNow(By locator) {
	    //turnOffImplicitWaits();
	    boolean result = false;
	    try {
	       result = ExpectedConditions.invisibilityOfElementLocated(locator).apply(driver);
	       System.out.println("Invisibility"+result);
	    }
	    finally {
	    //turnOnImplicitWaits();
	    }
	    return result;
	}
	
	
	public ClubSignupPage enterCASL(Boolean value) {
		try {
		//if (driver.findElement(By.name("termsAndConditionsForm.canadaOptIn")).size() > 0) {
		//	System.out.println("size of tnc exist");
		//if ( value == true ){
		By casl = By.name("termsAndConditionsForm.canadaOptIn");
		//casl.click();
		//}
			while (1==1){
			if(isElementHiddenNow(casl)){
				System.out.println("hidden true");
				break;}
			else {
				System.out.println("hidden false");
				try {
					WebDriverWait wait = new WebDriverWait(driver, 15);
				    WebElement element1= driver.findElement(By.name("termsAndConditionsForm.canadaOptIn"));
				    wait.until(ExpectedConditions.visibilityOf(element1));
					if ( value == true )
						((WebElement) casl).click();
					}catch(NullPointerException npe){}
				break;}
			}
		
		//}
		//else ()
		//WebDriverWait wait = new WebDriverWait(driver, 3);
		//if(driver.findElements(By.name("termsAndConditionsForm.canadaOptIn")).size() > 0) {}
		//By element1= driver.findElement(By.name("termsAndConditionsForm.canadaOptIn"));
		//if(ExpectedConditions.invisibilityOfElementLocated(By.name("termsAndConditionsForm.canadaOptIn"))); 
		//}
		}										//CheckBox
		//catch(NullPointerException  e){}
		//catch(NoSuchElementException nse){}
		catch(Exception  e){}
		return this;
	}
	
	public ClubSignupPage enterCaptcha(String captcha) {
		try{captchaText.sendKeys(captcha);}
		catch(NullPointerException  e){}
		return this;
	}
	

	public Welcome clickSubmit() {
		try{submitClubSignup.click();}
		catch(NullPointerException  e){}
		return PageFactory.initElements(driver, Welcome.class);
	}

	public ClubSignupPage clickInvalid() {
		try{submitClubSignup.click();}
		catch(NullPointerException  e){}
		//if(errors.getText().contains("You already have an account") || errors.getText().contains("Please try again") || errors.getText().contains("Please enter") || errors.getText().contains("You must be 13 years"))
		return this;
	}


	public ClubSignupPage createNewUser(BBRegistrationDataClub registrationData) {
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
		Reporter.log("ccFirstName: " +registrationData.getCcFirstName()+"<br>");
		Reporter.log("ccLastName: " +registrationData.getCcLastName()+"<br>");
		Reporter.log("ccType: " +registrationData.getCcType()+"<br>");
		Reporter.log("ccNumber: " +registrationData.getCcNumber()+"<br>");
		Reporter.log("ccExp: " +registrationData.getCcExp()+"<br>");
		Reporter.log("ccCvv: " +registrationData.getCcCvv()+"<br>");
		Reporter.log("billingCB: " +registrationData.getBillingCB()+"<br>");
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
		.enterCCFirstName(registrationData.getCcFirstName())
		.enterCCLastName(registrationData.getCcLastName())
		.enterCCType(registrationData.getCcType())
		.enterCCNumber(registrationData.getCcNumber())
		.enterCCExp(registrationData.getCcExp())
		.enterCVV(registrationData.getCcCvv())
		.clickBillingCB(registrationData.getBillingCB())
		.enterCoachReferral(registrationData.getCoachReferral(),registrationData.getCoachId())
		.enterTnC(registrationData.getTnC())
		.enterCASL(registrationData.getCASL())
		.enterCaptcha(registrationData.getCaptchaText());
		//.clickSubmit();

	}

}

