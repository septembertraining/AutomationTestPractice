package com.automationproject.windowshanldings;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowsDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://github.com/login");

		driver.findElement(By.id("login_field")).sendKeys("Cloudtraining@hyd.com");

		driver.findElement(By.id("password")).sendKeys("Testing@123");

		driver.findElement(By.xpath("//input[@name='commit']")).click();

		String parent_window = driver.getWindowHandle(); // current window will be stored --1

		String keysperform = Keys.chord(Keys.CONTROL, Keys.ENTER);

		driver.findElement(By.linkText("Forgot password?")).sendKeys(keysperform);

		// Now scirpt will open in same page.(forgot password)

		Set<String> allwindows = driver.getWindowHandles(); // 2 windows // In this syntax all windows are stored
            //       1            2                 
		for (String window : allwindows) { // two windows

			driver.switchTo().window(window); // either 1st or 2nd

			if (driver.getCurrentUrl().equals("https://github.com/password_reset")) {// true
				WebElement textbox=driver.findElement(By.id("email_field"));
				
				textbox.clear();
				textbox.sendKeys("ClourdNaradha@gmail.com");
			}

		}
		
		driver.switchTo().window(parent_window);
		
		String parenturl=driver.getCurrentUrl();
		
		System.out.println(parenturl);
		
		Thread.sleep(3000);
		
		//driver.close(); // It will close current active window (one window)
		
		driver.quit(); // It will close all opened windows.
		
		

	}

}
