package com.framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GmailSignInPage {

	@FindBy(id = "Email")
	WebElement emailField;
	
	@FindBy(id = "Passwd")
	WebElement passwordField;
	
	@FindBy(id = "signIn")
	WebElement signInButton;
	
	
	public void gmailSignIn(String email, String password){
		emailField.sendKeys(email);
		passwordField.sendKeys(password);
		signInButton.click();
	}
}
