package com.automationproject.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorsDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://github.com/login");
		
		WebElement headerpage=driver.findElement(By.tagName("h1"));
		
		String  header_name= headerpage.getText();
		
		System.out.println("Header of github is ::"+header_name);
		
		driver.findElement(By.name("login")).sendKeys("testingtraining@gmail.com");
		
		Thread.sleep(2000);  //By using thread.sleep we will halt the execution time of Script
		
		driver.findElement(By.id("password")).sendKeys("testing@123");
		
		Thread.sleep(2000);
		
		driver.findElement(By.name("commit")).click();
		
		Thread.sleep(2000);
		
		//driver.findElement(By.linkText("Forgot password?")).click(); // This is called LinkText.
		
		driver.findElement(By.partialLinkText("password?")).click();// This is called partial link text
		
		Thread.sleep(2000);
		
		driver.close();		
	
	}

}
