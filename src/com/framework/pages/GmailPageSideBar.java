package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.PageBase;

public class GmailPageSideBar extends PageBase{

	@FindBy(css = "div[class = 'T-I J-J5-Ji T-I-KE L3']")
	public WebElement emailComposeButton;
	
	
}
