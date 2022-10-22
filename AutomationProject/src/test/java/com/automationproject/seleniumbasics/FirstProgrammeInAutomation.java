package com.automationproject.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FirstProgrammeInAutomation {
	
	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();// this line of command automatically download required
		//.exe file of browser based on browser version (100)
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();  // it is used maximize our web-browser
		 
		driver.get("https://github.com/"); // this command open any url in existingly opened browser
		
		
		driver.close();  // This command will close the browser with out manual interferance
	}

}
