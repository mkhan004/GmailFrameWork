package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.TestBase;

public class GmailSentMailPageTest extends TestBase{

	@Test
	public void testSentMailPage(){
		gmailPageHeader.signInLink.click();
		gmailSignInPage.gmailSignIn("nyseekers@gmail.com", "01818365827");
		gmailPageHeader.gmailLink.click();
		Assert.assertEquals(gmailSentMailPage.sentMailLink.getText(), "Sent Mail");
	}
}
