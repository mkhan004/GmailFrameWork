package com.framework.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.PageBase;

public class GmailInboxPage extends PageBase{

	@FindBy(xpath = "//*[@id=':jb']/div/div[1]/span/a")
	public WebElement gmailInboxLink;
	
	@FindBy(xpath = "//*[@id=':36']")
	public WebElement gmailPrimaryFolder;
	
	@FindBy(xpath = "//*[@id=':37']")
	public WebElement gmailSocialFolder;
	
	@FindBy(xpath = "//*[@id=':38']")
	public WebElement gmailPromotionsFolder;
	
	@FindBy(xpath = "//*[@id=':ix']/span/b[3]")
	public WebElement totalEmailCount;
	
	@FindBy(xpath = "//*[@id=':ix']/span/b[1]")
	public WebElement firstBoundaryEmailCount;
	
	@FindBy(xpath = "//*[@id=':ix']/span/b[2]")
	public WebElement secondBoundaryEmailCount;
	
	@FindBy(xpath = "//*[@id=':j0']")
	public WebElement nextPageButton;
	
	
}
