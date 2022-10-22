package com.automationproject.cssselector;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LetCodeItLogin {

	public static void main(String[] args) throws IOException, InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);

		driver.get("https://letcode.in/signin");

		driver.findElement(By.cssSelector("input[name^='email']")).sendKeys("testingtraining@gmail.com");

		driver.findElement(By.cssSelector("input[name$='password']")).sendKeys("G@testing2022");

		driver.findElement(By.xpath("//button[text()='LOGIN']")).click();

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(
				ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[text()=' Welcome MRTrainig ']"))));

		String actual_url = driver.getCurrentUrl();

		String expected = "https://letcode.in/";

		String location = System.getProperty("user.dir");

		System.out.println(location);

		if (expected.equals(actual_url)) { // if my expected equal to actual then only it will login

			File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

			File destination = new File(location + "/CaptureImage" + "LetCodeSuccessLogin" + ".png");

			FileUtils.copyFile(source, destination);

		}

		Thread.sleep(3000);

		driver.close();

	}
}
