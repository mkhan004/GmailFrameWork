package com.framework.tests;

import java.util.Iterator;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.TestBase;

public class EmailComposePageTest extends TestBase{

	@Test
	public void testGmailInbox(){
		gmailPageHeader.signInLink.click();
		gmailSignInPage.gmailSignIn("nyseekers@gmail.com", "01818365827");
		gmailPageHeader.gmailLink.click();
		String[] inbox = gmailInboxPage.gmailInboxLink.getText().split(" ");
		Assert.assertEquals(inbox[0], "Inbox");
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	public void testNewEmailComposeLink(){
		gmailPageSideBar.emailComposeButton.click();
		String header = emailComposePage.composeNewEmailHeader.getText();
		Assert.assertEquals(header, "New Message");
	}
	
	@Test(dependsOnMethods = "testNewEmailComposeLink")
	public void testSendNewMail(){
		emailComposePage.recepientEmailField.sendKeys("banglaoutfitters@gmail.com");
		emailComposePage.emailSubjectField.sendKeys("This is an auto Mail");
		emailComposePage.emailBodyTextArea.sendKeys("This is an auto mail content body. Simply ignore this mail!");
		emailComposePage.emailSendButton.click();
		String confirmationMessage = emailComposePage.cofirmationMessage.getText();
		Assert.assertEquals(confirmationMessage, "Your message has been sent. View message");
	}
}
