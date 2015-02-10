package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailPageHeader {

	@FindBy(linkText = "Sign in")
	public WebElement signInLink;
	
	@FindBy(xpath = "//*[@class='gb_g gb_i']")
	public WebElement signedInUser;
	
	@FindBy(xpath = "//*[@class='gb_D gb_ea gb_i']")
	public WebElement signedInUserProfile;
	
	@FindBy(xpath = "//*[@class='gb_5b gb_cc gb_Z']")
	public WebElement signOutLink;
	
	@FindBy(xpath = "//*[@class='gb_g']")
	public WebElement gmailLink;
	
	
	public void gmailSignOut(){
		signedInUserProfile.click();
		signOutLink.click();
	}
}
