package com.framework.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.TestBase;

public class EmailViewPageTest extends TestBase{

	@Test
	public void testGmailInbox(){
		gmailPageHeader.signInLink.click();
		gmailSignInPage.gmailSignIn("nyseekers@gmail.com", "01818365827");
		gmailPageHeader.gmailLink.click();
		String[] inbox = gmailInboxPage.gmailInboxLink.getText().split(" ");
		Assert.assertEquals(inbox[0], "Inbox");
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	public void testOpeningRandomEmail(){
		int emailCount = gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").size();
		Random rand = new Random();
		int index = rand.nextInt(emailCount)+0;
		String emailSender = gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(index).getText();
		gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(index).click();
		String emailSenderCheck = emailViewPage.emailSender.getText();
		emailViewPage.backToInboxButton.click();
		Assert.assertEquals(emailSenderCheck, emailSender);
	}
	
	@Test(dependsOnMethods = "testOpeningRandomEmail")
	public void testDeleteEmail(){
		int emailCount = gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").size();
		Random rand = new Random();
		int index = rand.nextInt(emailCount)+0;
		gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(index).click();
		int totalEmailCount = emailViewPage.convertStringToInteger(emailViewPage.totalEmailCountInEmailOpenPage.getText().substring(6))-1;
		emailViewPage.emailDeleteButton.click();
		int finalEmailCount = gmailInboxPage.convertStringToInteger(gmailInboxPage.totalEmailCount.getText());
		Assert.assertEquals(totalEmailCount, finalEmailCount);
	}
	
	@Test(dependsOnMethods = "testDeleteEmail")
	public void testEmailReply(){
		gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(3).click();
		Random rand = new Random();
		int randomNumber = rand.nextInt(100)+0;
		String message = "hi this is an auto reply "+randomNumber;
		emailViewPage.emailReplyLink.click();
		emailViewPage.replyEmailTextField.sendKeys(message);
		emailViewPage.replyEmailSendButton.click();
		System.out.println(emailViewPage.lastReplyText.getText()+"nn");
		String confirmation = emailViewPage.replyConfirmation.getText();
		System.out.println(confirmation);
		Assert.assertEquals(confirmation, "Your message has been sent.");
	}
}
