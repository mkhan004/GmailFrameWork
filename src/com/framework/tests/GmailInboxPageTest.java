package com.framework.tests;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.AfterGroups;
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
	
	@Test(dependsOnMethods = "testGmailInbox", groups = "a")
	public void testPrimaryMailFolder(){
		Assert.assertEquals(gmailInboxPage.getFolderByName(driver, "Primary"), "Primary");
	}
	
	@Test(dependsOnMethods = "testGmailInbox", groups = "a")
	public void testSocialEmailFolder(){
		gmailInboxPage.gmailSocialFolder.click();
		Assert.assertEquals(gmailInboxPage.getFolderByName(driver, "Social"), "Social");
	}
	
	@Test(dependsOnMethods = "testGmailInbox", groups = "a")
	public void testPromotionsEmailFolder(){
		gmailInboxPage.gmailPromotionsFolder.click();
		Assert.assertEquals(gmailInboxPage.getFolderByName(driver, "Promotions"), "Promotions");
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	public void testNoOfEmailPerPage(){
		int firstBoundary = gmailInboxPage.convertStringToInteger(gmailInboxPage.firstBoundaryEmailCount.getText());
		int secondBoundary = gmailInboxPage.convertStringToInteger(gmailInboxPage.secondBoundaryEmailCount.getText());
		int totalEmailCountOnCurrentPage = secondBoundary - firstBoundary + 1;
		int noOfEmailOnCurrentPage = gmailInboxPage.getListOfWebElements(driver, "tr[class='zA zE'],tr[class='zA yO']").size();
		Assert.assertEquals(noOfEmailOnCurrentPage, totalEmailCountOnCurrentPage);
	}
	
	@Test(dependsOnMethods = "testGmailInbox")
	@AfterGroups(dependsOnGroups = "a")
	public void testTotalNoOfEmail(){
		int totalEmail = gmailInboxPage.convertStringToInteger(gmailInboxPage.totalEmailCount.getText());
		int runningSumOfEmail = 0;
		for(int i=0; i<totalEmail; i=runningSumOfEmail){
			int noOfEmailOnCurrentPage = gmailInboxPage.getListOfWebElements(driver, "tr[class='zA zE'],tr[class='zA yO']").size();
			runningSumOfEmail += noOfEmailOnCurrentPage;
			
			if(runningSumOfEmail<totalEmail){
				gmailInboxPage.nextPageButton.click();
			}
			
			for(int c=0; c<gmailInboxPage.getListOfWebElements(driver, "tr[class='zA zE'],tr[class='zA yO']").size(); c++){
				gmailInboxPage.getListOfWebElements(driver, "tr[class='zA zE'],tr[class='zA yO']").remove(c);
			}
		}
		Assert.assertEquals(runningSumOfEmail, totalEmail);
	}
	
	@Test(dependsOnMethods = "testPromotionsEmailFolder")
	public void testOpeningRandomEmail(){
		int emailCount = gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").size();
		Random rand = new Random();
		int index = rand.nextInt(emailCount)+0;
		String emailSender = gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(index).getText();
		gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(index).click();
		String emailSenderCheck = gmailInboxPage.emailSender.getText();
		gmailInboxPage.backToInboxButton.click();
		Assert.assertEquals(emailSenderCheck, emailSender);
	}
	
	@Test(dependsOnMethods = "testPromotionsEmailFolder")
	public void testDeleteEmail(){
		int emailCount = gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").size();
		Random rand = new Random();
		int index = rand.nextInt(emailCount)+0;
		gmailInboxPage.getListOfWebElements(driver, "div[class='yW']").get(index).click();
		int totalEmailCount = gmailInboxPage.convertStringToInteger(gmailInboxPage.totalEmailCountInEmailOpenPage.getText().substring(6))-1;
		gmailInboxPage.emailDeleteButton.click();
		int finalEmailCount = gmailInboxPage.convertStringToInteger(gmailInboxPage.totalEmailCount.getText());
		Assert.assertEquals(totalEmailCount, finalEmailCount);
	}
}