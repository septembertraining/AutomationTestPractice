package com.automationproject.actionssession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo4 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement mouse_btn = driver.findElement(By.xpath("//button[contains(@id,'mouse')]"));

		WebElement top_btn = driver.findElement(By.xpath("//div/a[text()='Top']"));

		Actions action = new Actions(driver);

		action.moveToElement(mouse_btn).click(top_btn).perform();

		// above syntax will perform two operations in single line by using actions
		// class

		Thread.sleep(5000);

		driver.close();

	}

}
