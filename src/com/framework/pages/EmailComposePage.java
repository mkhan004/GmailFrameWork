package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.framework.base.PageBase;

public class EmailComposePage extends PageBase{

	@FindBy(css = "div[class = 'aYF']")
	public WebElement composeNewEmailHeader;
	
	@FindBy(css = "textarea[class = 'vO']")
	public WebElement recepientEmailField;
	
	@FindBy(css = "input[class = 'aoT']")
	public WebElement emailSubjectField;
	
	@FindBy(css = "div[class = 'Am Al editable LW-avf']")
	public WebElement emailBodyTextArea;
	
	
}
