package com.automationproject.actionssession;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ActionsDemo3 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://demo.guru99.com/test/simple_context_menu.html");

		WebElement rightclick_btn = driver.findElement(By.xpath("//span[.='right click me']"));

		WebElement sub_options_delete = driver.findElement(By.xpath("//li/span[text()='Delete']"));

		Actions action = new Actions(driver);
		action.contextClick(rightclick_btn).click(sub_options_delete).perform();

		// In actions class we can perform multiple operations in same line

		Alert alert = driver.switchTo().alert();

		System.out.println(alert.getText());

		alert.accept();

		Thread.sleep(5000);

		driver.close();
	}

}
