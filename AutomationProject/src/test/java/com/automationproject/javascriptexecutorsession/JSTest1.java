package com.automationproject.javascriptexecutorsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSTest1 {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();

		driver.get("https://only-testing-blog.blogspot.com/2013/09/test.html");
		
		Thread.sleep(4000);
		
		WebElement alert_btn =driver.findElement(By.xpath("//input[@value='Show Me Alert']"));
		
		JavascriptExecutor js= ((JavascriptExecutor)driver);
		
		js.executeScript("arguments[0].scrollIntoView(true)", alert_btn);
		
		Thread.sleep(4000);
		
		js.executeScript("arguments[0].click();", alert_btn);
		
	}

}
