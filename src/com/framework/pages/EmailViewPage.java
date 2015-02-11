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
	
	@FindBy(className = "ams")
	public WebElement emailReplyLink;
	
	@FindBy(css = "div[class='Am Al editable LW-avf']")
	public WebElement replyEmailTextField;
	
	@FindBy(css = "div[class = 'T-I J-J5-Ji aoO T-I-atl L3']")
	public WebElement replyEmailSendButton;
	
	@FindBy(css = "div[class = 'a3s']")
	public WebElement lastReplyText;
	
	@FindBy(css = "div[class = 'vh']")
	public WebElement replyConfirmation;
}
