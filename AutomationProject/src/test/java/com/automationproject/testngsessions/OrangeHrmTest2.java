package com.automationproject.testngsessions;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmTest2 {

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

		String orange_hrm_url = driver.getCurrentUrl();

		String expected_ulr = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";

		Assert.assertEquals(orange_hrm_url, expected_ulr); // IF this line returns true this method pass
	}

	@Test(priority = 1)
	public void addEmployee() throws InterruptedException {

		driver.findElement(By.xpath("//li/a[text()='Add Employee']")).click();

		Thread.sleep(3000);

		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewDefinedPredefine";

		String actual_url = driver.getCurrentUrl();

		Assert.assertEquals(expectedUrl, actual_url);

		driver.findElement(By.name("firstName")).sendKeys("September");

		driver.findElement(By.name("middleName")).sendKeys("Testing");

		driver.findElement(By.name("lastName")).sendKeys("Batch");

		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div[1]/input"))
				.sendKeys("12345");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 0)
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

	@Test(priority = -1)
	public void reportSearch() {

		driver.findElement(By.xpath("//li/a[text()='Reports']")).click();

		String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewDefinedPredefine";
		String actual_url = driver.getCurrentUrl();

		Assert.assertNotEquals(expectedUrl, actual_url);

		driver.findElement(By.xpath("//label[text()='Report Name']/parent::div/following::div[1]//input"))
				.sendKeys("September Report");

		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(
					"D:\\Students Projects\\SeptemberEveningBatch\\AutomationProject\\CaptureImage\\failed.jpg");
			FileUtils.copyFile(src, dest);

		}

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
