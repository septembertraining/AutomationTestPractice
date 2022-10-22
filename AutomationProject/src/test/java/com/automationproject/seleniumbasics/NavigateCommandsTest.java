package com.automationproject.seleniumbasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigateCommandsTest {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		Thread.sleep(2000); // This command halt the execution for 2 seconds, it will take milli sec as
							// parameter

		driver.get("https://google.com/"); // first google page wil opened

		String title1 = driver.getTitle();

		System.out.println(title1);

		String url = driver.getCurrentUrl();
		System.out.println(url);

		Thread.sleep(2000);

		driver.navigate().to("https://facebook.com/"); // and then it will switch from one url to another url

		System.out.println(driver.getCurrentUrl());

		System.out.println(driver.getTitle());

		Thread.sleep(2000);

		driver.navigate().back(); // It will go back to google page

		Thread.sleep(2000);

		driver.navigate().forward(); // This command will move to forward of the browser

		Thread.sleep(2000);

		driver.navigate().refresh(); // This command refresh particualr opened page

		Thread.sleep(2000);

		driver.close();// This command will close opened browser

	}

}
