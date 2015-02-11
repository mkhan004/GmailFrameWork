package com.framework.base;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.framework.pages.EmailComposePage;
import com.framework.pages.EmailViewPage;
import com.framework.pages.GmailInboxPage;
import com.framework.pages.GmailSentMailPage;
import com.framework.pages.GmailSignInPage;
import com.framework.pages.GmailPageHeader;

public class TestBase {
	
	// Variables Declaration
	protected WebDriver driver;
	protected String url = "https://www.google.com/";
	String browser = "ff";

	// Pages Instantiation
	protected GmailPageHeader gmailPageHeader;
	protected GmailSignInPage gmailSignInPage;
	protected GmailInboxPage gmailInboxPage;
	protected GmailSentMailPage gmailSentMailPage;
	protected EmailViewPage emailViewPage;
	protected EmailComposePage emailComposePage;
	
	
	@BeforeSuite
	public void setUp() throws MalformedURLException {
		if (browser.equalsIgnoreCase("Safari")) {
			driver = new SafariDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Remote")) {
			DesiredCapabilities capabilities = DesiredCapabilities.safari();
			capabilities.setCapability("version", "5");
			capabilities.setCapability("platform", Platform.MAC);
			// Create the connection to Sauce Labs to run the tests
			driver = new RemoteWebDriver(
					new URL(
							"http://mkhan004:b7e1f054-e3fc-4f8f-ba1c-875d19b4c81d@ondemand.saucelabs.com:80/wd/hub"),
					capabilities);
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(url);
		driver.manage().window().maximize();
		
		// Accessing pages webelements using PageFactory
		gmailPageHeader = PageFactory.initElements(driver, GmailPageHeader.class);
		gmailSignInPage = PageFactory.initElements(driver, GmailSignInPage.class);
		gmailInboxPage = PageFactory.initElements(driver, GmailInboxPage.class);
		gmailSentMailPage = PageFactory.initElements(driver, GmailSentMailPage.class);
		emailViewPage = PageFactory.initElements(driver, EmailViewPage.class);
		emailComposePage = PageFactory.initElements(driver, EmailComposePage.class);
	}
	// comment
	@AfterSuite
	public void tearDown(){
		//gmailPageHeader.gmailSignOut();
		//driver.quit();
	}
}
