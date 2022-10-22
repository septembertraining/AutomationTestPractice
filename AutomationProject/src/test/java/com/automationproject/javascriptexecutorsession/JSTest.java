package com.automationproject.javascriptexecutorsession;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.manage().deleteAllCookies();

		driver.get("https://www.browserstack.com/users/sign_in");

		// Now I want enter text based on java script Executor
		// when ever our selenium code unable to perform click,sendKeys, scroll
		// using selenium then we need use JS commands[Due to element interact
		// exception]

		WebElement username_textbox = driver.findElement(By.cssSelector("input#user_email_login"));

		WebElement password_textbox = driver.findElement(By.cssSelector("input#user_password"));
		WebElement sign_in_btn = driver.findElement(By.cssSelector("input[value^= 'Sign']"));
		

		JavascriptExecutor js = ((JavascriptExecutor) driver); // one time we can create js and use mult times
		
		js.executeScript("arguments[0].value= 'gurumohanreddymadem@gmail.com';", username_textbox);

		js.executeScript("arguments[0].value= 'G@testing2022';", password_textbox);
		
		js.executeScript("arguments[0].scrollIntoView();", sign_in_btn);
		
		Thread.sleep(5000);

		js.executeScript("arguments[0].click();", sign_in_btn);

		Thread.sleep(5000);
		
		driver.close();
	}

}
