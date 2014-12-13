package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailInboxPage {

	@FindBy(xpath = "//*[@id=':jb']/div/div[1]/span/a")
	public WebElement gmailInboxLink;
	
	@FindBy(xpath = "//*[@id=':36']")
	public WebElement gmailPrimaryFolder;
	
	@FindBy(xpath = "//*[@id=':37']")
	public WebElement gmailSocialFolder;
	
	@FindBy(xpath = "//*[@id=':38']")
	public WebElement gmailPromotionsFolder;
}
