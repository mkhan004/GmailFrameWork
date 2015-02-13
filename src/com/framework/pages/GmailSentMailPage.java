package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.PageBase;

public class GmailSentMailPage extends PageBase{

	@FindBy(css = "td[class = 'gsib_a']")
	public WebElement sentMailPage;
	
	@FindBy(css = "span[class = 'Dj']")
	public WebElement totalSentEmailCount;
	
	@FindBy(xpath = "//*[@id=':wy']/span/b[1]")
	public WebElement firstBoundarySentEmailCount;
	
	@FindBy(xpath = "//*[@id=':wy']/span/b[2]")
	public WebElement secondBoundarySentEmailCount;
	
	@FindBy(xpath = "//*[@id=':j0']")
	public WebElement nextPageButton;
}
