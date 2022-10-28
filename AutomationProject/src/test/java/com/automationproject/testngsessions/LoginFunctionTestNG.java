package com.automationproject.testngsessions;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginFunctionTestNG {

	@BeforeTest
	public void launchrBrowser() {
		System.out.println("Browser Launched");
	}

	@BeforeClass
	public void launchurl() {
		System.out.println("Launch applicaiton url");
	}

	@BeforeMethod
	public void login() {
		System.out.println("Login Succesfully");
	}

	@Test(priority = 1)
	public void inboxMailCheck() {
		System.out.println("Gmail Inbox mails checked");
	}

	@Test(priority = 2)
	public void deleteUnwantedMails() {
		System.out.println("UnwantedMails deleted in Inbox");
	}
	
	@Test(priority = 3)
	public void checkSpamMails() {
		System.out.println("Spam mails checked");
	}
	
	
	@Test(priority = 4)
	public void deleteSpamMails() {
		System.out.println("Unwanted spam mails deleted");
	}
	

	@AfterMethod
	public void logOff() {
		System.out.println("LogOff from application");
	}

	@AfterTest
	public void closeBrowser() {
		System.out.println("Close Browser");
	}

}
