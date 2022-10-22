package com.automationproject.scycronization;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		driver.get("https://www.hyrtutorials.com/p/waits-demo.html");

		driver.findElement(By.xpath("//button[text()='Add Textbox1']")).click();

		// Thread.sleep(15000); // this will completly halt the execution

		driver.findElement(By.xpath("//p/following-sibling::h3/input[@placeholder='Textbox1']"))
				.sendKeys("Cloud Naradha Training");
	}

}
