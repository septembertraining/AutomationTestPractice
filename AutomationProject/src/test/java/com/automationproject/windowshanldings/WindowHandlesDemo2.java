package com.automationproject.windowshanldings;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandlesDemo2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		
		// how to store parent window
		
		String parent_window = driver.getWindowHandle();
		
		WebElement parent_textbox=driver.findElement(By.xpath("//input[@id='name']"));
		
		parent_textbox.sendKeys("Cloud Naradha Training");
		
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
		
		Set<String> allwindows=driver.getWindowHandles();
		
		Iterator<String> itr=allwindows.iterator();
		
		while(itr.hasNext()) {  // return true or false 
			driver.switchTo().window(itr.next());// this will switch window
			
			if(driver.getCurrentUrl().equals("https://www.hyrtutorials.com/p/basic-controls.html")) {
				
				driver.manage().window().maximize();
				
				
			}
			
		}
		
		driver.switchTo().window(parent_window);
		
		parent_textbox.clear();
		
		parent_textbox.sendKeys("Cloud Naradha Hyderabad");
		
		Thread.sleep(12000);// It will accept milli seconds
		
		driver.quit();
	}

}
