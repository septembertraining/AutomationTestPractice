package com.automationproject.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomationScriptDemo {

	public static void main(String[] args) {

		// This is called default approach

		System.setProperty("webdriver.chrome.driver", "F:\\Desktop\\SeptemberEvening-22\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://google.com/");

		driver.close();
		
	
	}

}
