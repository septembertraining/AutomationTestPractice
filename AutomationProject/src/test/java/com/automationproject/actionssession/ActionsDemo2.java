package com.automationproject.actionssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://demo.guru99.com/test/simple_context_menu.html");
		
		
		WebElement doubleclick_element=driver.findElement(By.xpath("//button[text()='Double-Click Me To See Alert']"));
		
		Actions button= new Actions(driver);
		
		button.doubleClick(doubleclick_element).perform();
		
		//with out perform() method actions class won't execute
		
		Alert alert=driver.switchTo().alert();
		
		System.out.println(alert.getText()); // This line print text which is available on alert
		
		alert.accept();
		
		Thread.sleep(5000);
		
		driver.close();
	}

}
