package com.automationproject.webtablesession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");	
		
		//I want to print headers of the table
		
		WebElement table=driver.findElement(By.xpath("//table[@id='shopping']"));
		
		List<WebElement> tablesheaders=table.findElements(By.tagName("th"));
		
		for(WebElement header:tablesheaders) {
			System.out.println(header.getText());
		}
		
	// In this code we are finding elements with another webElements	
		
		//This code will printer header of the webtable.

		
	}

}
