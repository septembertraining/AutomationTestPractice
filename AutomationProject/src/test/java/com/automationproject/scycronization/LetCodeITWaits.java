package com.automationproject.scycronization;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeITWaits {

	
	public static void main(String[] args) throws InterruptedException {
		
WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/waits");
		
		driver.findElement(By.xpath("//button[.='Simple Alert']")).click();
		
		//Alert alert=driver.switchTo().alert();
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		Alert alert=wait.until(ExpectedConditions.alertIsPresent());
		
		String alertmessage=alert.getText();
		
		System.out.println("Alert mesasge is:: "+alertmessage);
		
		alert.accept();
		
		Thread.sleep(3000);
		
		driver.close();
	}
}
