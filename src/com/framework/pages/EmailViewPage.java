package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.PageBase;

public class EmailViewPage extends PageBase{

	@FindBy(xpath = "//*[@id=':5']/div[2]/div[1]/div/div[1]/div")
	public WebElement backToInboxButton;
	
	@FindBy(className = "gD")
	public WebElement emailSender;
	
	@FindBy(css = "span[class='adl']")
	public WebElement totalEmailCountInEmailOpenPage;
	
	@FindBy(xpath = "//*[@id=':5']/div[2]/div[1]/div/div[2]/div[3]")
	public WebElement emailDeleteButton;
}
