package com.automationproject.alertssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo {
	
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert ref =driver.switchTo().alert();
		
		String alert_message=ref.getText(); // this method will get text from alert
		
		System.out.println("Alert Message is ::"+alert_message);
		
		ref.accept();
		
		Thread.sleep(5000);
		
		driver.close();
	}
	
}
