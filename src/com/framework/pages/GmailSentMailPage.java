package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailSentMailPage {

	@FindBy(xpath = "//*[@id=':jf']/div/div[1]/span/a")
	public WebElement sentMailLink;
}
