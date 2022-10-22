package com.automationproject.alertssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertsDemo2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		driver.findElement(By.name("enter-name")).sendKeys("CloudNaradha");
		
		driver.findElement(By.id("alertbtn")).click();
		
		Alert ref =driver.switchTo().alert();
		
		String alert_msg=ref.getText();
		
		System.out.println("Alert Message is::"+alert_msg);
		
		String actual= "CloudNaradha";
		
		
		
		if(alert_msg.contains(actual)) {
			System.out.println("Expected text available in alert");
		}
		else {
			System.out.println("Expected text not available in alert");
		}
		
		ref.accept();
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
