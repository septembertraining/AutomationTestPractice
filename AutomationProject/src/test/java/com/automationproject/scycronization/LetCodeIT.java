package com.automationproject.scycronization;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeIT {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://letcode.in/signin");
		
		driver.findElement(By.xpath("//input[@name='email']")).sendKeys("testingtraining@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("G@testing2022");
		
		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();
		
		
		//WebElement toastmessage= driver.findElement(By.xpath("//div[text()=' Welcome MRTrainig ']"));
		
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[text()=' Welcome MRTrainig ']"))));
		
		driver.findElement(By.xpath("//a[text()='Sign out']")).click();
	}

}
