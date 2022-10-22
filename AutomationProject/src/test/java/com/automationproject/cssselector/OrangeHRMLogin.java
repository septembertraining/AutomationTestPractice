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

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRMLogin {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.findElement(By.cssSelector("input[name*='name']")).sendKeys("Admin");
		
		driver.findElement(By.cssSelector("input[name$='word']")).sendKeys("admin123");
		
		driver.findElement(By.cssSelector("button[class$='login-button']")).click();
		
		String actual_url=driver.getCurrentUrl();
		
		String expected= "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
		
		String location=System.getProperty("user.dir");
		
		
		
		System.out.println(location);
		
		if(expected.equals(actual_url)) {  // if my expected equal to actual then only it will login
			
			File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			File destination= new File(location+"/CaptureImage"+"OrangeLoginSuccess"+".png");
			
			FileUtils.copyFile(source, destination);
			
			driver.findElement(By.cssSelector("li.oxd-userdropdown")).click();
			
			driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
			
		}
		
		Thread.sleep(3000);
		
		driver.close();
		
	}

}
