package com.framework.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.TestBase;

public class GmailSignInPageTest extends TestBase{

	@Test
	public void testGmailSignIn(){
		gmailPageHeader.signInLink.click();
		gmailSignInPage.gmailSignIn("nyseekers@gmail.com", "01818365827");
		Assert.assertNotEquals(gmailPageHeader.signedInUser.getText(), "+You");
	}
}
