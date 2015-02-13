package com.framework.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.framework.base.TestBase;

public class GmailSentMailPageTest extends TestBase{
	
	@Test
	public void testSentMailPage(){
		gmailPageHeader.signInLink.click();
		gmailSignInPage.gmailSignIn("nyseekers@gmail.com", "01818365827");
		gmailPageHeader.gmailLink.click();
		Assert.assertEquals(gmailPageSideBar.sentMailLink.getText(), "Sent Mail");
	}
	
	@Test(dependsOnMethods = "testSentMailPage")
	public void testSentMailLink(){
		gmailPageSideBar.sentMailLink.click();
		Assert.assertTrue(driver.getCurrentUrl().endsWith("sent"));
	}
	
	@Test(dependsOnMethods = "testSentMailLink")
	public void testTotalNoOfEmail(){
		//gmailPageSideBar.sentMailLink.click();
		System.out.println(driver.findElement(By.className("Di")).getText()+"mmm");
	}
}