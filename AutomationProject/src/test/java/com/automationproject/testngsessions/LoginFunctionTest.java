package com.automationproject.testngsessions;

public class LoginFunctionTest {
	
	
	public void login() {
		System.out.println("Login Succesfully");
	}
	
	public void createAccount() {
		System.out.println("Account Created");
	}
	
	public void accountDeletion() {
		System.out.println("Account Deletion");
	}
	
	public void logOff() {
		System.out.println("LogOff from application");
	}
	
	public void closeBrowser() {
		System.out.println("Close Browser");
	}
	
	public static void main(String[] args) {
		//Normal methods are executed through object creation
		// Static methods are executed directly.
		
		//[ClassName] ref= new[ClassName]();
		
		LoginFunctionTest test= new LoginFunctionTest();
		
		test.login();
		
		test.createAccount();
		
		test.accountDeletion();
		
		test.logOff();
		
		test.closeBrowser();
		
		
	}

}
