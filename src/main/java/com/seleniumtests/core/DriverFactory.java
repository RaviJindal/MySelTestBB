package com.seleniumtests.core;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.seleniumtests.utility.Log;


public class DriverFactory {
	
	protected WebDriver driver;
	protected String appURL;
	//protected static final Logger log = Logger.getLogger(Log4JSettings.class);
	
	@BeforeMethod()
	@Parameters("appURL")
	public void setEnv(@Optional("http://tbbqabeta.productpartners.com") String appURL) {
		//Log.info("********************TEST CASE STARTED*******************");
		this.appURL = appURL;
	}

	@BeforeMethod()
	@Parameters({"browser","port"})
	public void launchBrowser(@Optional("FF") String browser,@Optional("4444") String port) throws MalformedURLException{
						
			if (browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"C:\\D\\grid\\seleniumtests\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setBrowserName(DesiredCapabilities.chrome().getBrowserName());
			//capabilities.setPlatform(Platform.WINDOWS);
			//capabilities.setJavascriptEnabled(true);
			//URL url = new URL("http://localhost:".concat(port).concat("/wd/hub"));
			//WebDriver driver = new RemoteWebDriver(url, capabilities);
			//driver.get(appURL);
		}else if (browser.equalsIgnoreCase("FF")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			//DesiredCapabilities capabilities = new DesiredCapabilities();
			//capabilities.setBrowserName(DesiredCapabilities.firefox().getBrowserName());
			//capabilities.setPlatform(Platform.WINDOWS);
			//capabilities.setJavascriptEnabled(true);
			//URL url = new URL("http://localhost:".concat(port).concat("/wd/hub"));
			//WebDriver driver = new RemoteWebDriver(url, capabilities);
			//driver.get(appURL);

		}else if (browser.equalsIgnoreCase("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\D\\grid\\seleniumtests\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			/*DesiredCapabilities capabilities = new DesiredCapabilities();
			System.out.println(DesiredCapabilities.internetExplorer().getBrowserName());
			capabilities.setBrowserName(DesiredCapabilities.internetExplorer().getBrowserName());
			capabilities.setVersion("9"); 
			capabilities.setPlatform(Platform.WINDOWS);
			//capabilities.setJavascriptEnabled(true);
			URL url = new URL("http://localhost:4444/wd/hub");
			@SuppressWarnings("unused")
			RemoteWebDriver driver = new RemoteWebDriver(url, capabilities);*/
			//driver.get(appURL);

		}
	}

	@AfterMethod
	public void closeBrowser(ITestResult result) throws IOException {
		if (!result.isSuccess()) {
			Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX --FAILED-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			File imageFile = ((TakesScreenshot) new Augmenter().augment(driver))
					.getScreenshotAs(OutputType.FILE);
			String failureImageFileName = result.getMethod().getMethodName()+ new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())
					+ ".png";
			File failureImageFile = new File("C:\\D\\MySelWorkspaceBackups\\seleniumtestsbb\\screenshots\\"+failureImageFileName);
			FileUtils.moveFile(imageFile, failureImageFile);
		}
		else if(result.isSuccess()){
			Log.info("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX --PASSED-- XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		}
		driver.close();
		driver.quit();
		Log.endTestCase(result.getMethod().getMethodName());
	}
}
