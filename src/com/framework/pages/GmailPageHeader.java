package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPageHeader {

	@FindBy(linkText = "Sign in")
	public WebElement signInLink;
	
	@FindBy(xpath = "//*[@class='gb_f gb_h']")
	public WebElement signedInUser;
	
	@FindBy(xpath = "//*[@class='gb_C gb_da gb_h']")
	public WebElement signedInUserProfile;
	
	@FindBy(xpath = "//*[@class='gb_2b gb_9b gb_X']")
	public WebElement signOutLink;
	
	@FindBy(xpath = "//*[@class='gb_f']")
	public WebElement gmailLink;
	
	
	public void gmailSignOut(){
		signedInUserProfile.click();
		signOutLink.click();
	}
}
