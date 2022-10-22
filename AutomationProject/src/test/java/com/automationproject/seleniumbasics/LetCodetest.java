package com.automationproject.seleniumbasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodetest {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://github.com/login");
		
		Thread.sleep(2000);
		
		driver.findElement(By.id("login_field")).sendKeys("testingtraining@gmail.com");
		
		Thread.sleep(4000);
		
		driver.findElement(By.id("password")).sendKeys("testing@123");
		
		Thread.sleep(4000);
		
		driver.findElement(By.name("commit")).click();
		
		Thread.sleep(4000);
		
		String pagetitle=driver.getTitle();
		
		System.out.println(pagetitle);
		
		System.out.println(driver.getCurrentUrl());
		
		driver.close();
		
	}

}
