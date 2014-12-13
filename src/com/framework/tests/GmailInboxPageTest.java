package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.TestBase;

public class GmailInboxPageTest extends TestBase{

	@Test
	public void testGmailInbox(){
		gmailPageHeader.signInLink.click();
		gmailSignInPage.gmailSignIn("nyseekers@gmail.com", "01818365827");
		gmailPageHeader.gmailLink.click();
		String[] inbox = gmailInboxPage.gmailInboxLink.getText().split(" ");
		Assert.assertEquals(inbox[0], "Inbox");
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	public void testPrimaryMailFolder(){
		Assert.assertEquals(gmailInboxPage.gmailPrimaryFolder.getText(), "Primary");
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	public void testSocialEmailFolder(){
		gmailInboxPage.gmailSocialFolder.click();
		Assert.assertEquals(gmailInboxPage.gmailSocialFolder.getText(), "Social");
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	public void testPromotionsEmailFolder(){
		gmailInboxPage.gmailPromotionsFolder.click();
		Assert.assertEquals(gmailInboxPage.gmailPromotionsFolder.getText(), "Promotions");
	}
}
