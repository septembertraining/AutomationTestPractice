package com.automationproject.testngsessions;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmTest {

	WebDriver driver;

	@BeforeTest
	public void lauchBrowser() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod
	public void orangeHRMLogin() {

		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[text()=' Login ']")).click();
	}

	@Test
	public void addEmployee() throws InterruptedException {

		driver.findElement(By.xpath("//li/a[text()='Add Employee']")).click();

		Thread.sleep(3000);

		driver.findElement(By.name("firstName")).sendKeys("September");

		driver.findElement(By.name("middleName")).sendKeys("Testing");

		driver.findElement(By.name("lastName")).sendKeys("Batch");

		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div[1]/input"))
				.sendKeys("12345");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}

	@Test
	public void deleteEmployee() throws InterruptedException {
		Thread.sleep(3000);

		driver.findElement(By.xpath("//li/a[text()='Employee List']")).click();
		driver.findElement(By.xpath("//label[text()='Employee Name']/parent::div/following::div[1]//input"))
				.sendKeys("September");

		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div[1]//input"))
				.sendKeys("12345");

		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(5000);
	}
	
	@Test
	public void reportSearch() {
		
		driver.findElement(By.xpath("//li/a[text()='Reports']")).click();
		
		driver.findElement(By.xpath("//label[text()='Report Name']/parent::div/following::div[1]//input")).sendKeys("September Report");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@AfterMethod
	public void logOff() {
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();

		driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
