package com.automationproject.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookSignUpDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://www.facebook.com/reg/");

		driver.findElement(By.name("firstname")).sendKeys("Ram");

		driver.findElement(By.name("lastname")).sendKeys("Kallathuri");

		driver.findElement(By.name("reg_email__")).sendKeys("988765443226");

		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("testing@123");

		WebElement month = driver.findElement(By.name("birthday_month"));

		System.out.println("Page Title is --" + driver.getTitle());

		Select monthvalue = new Select(month);

		monthvalue.selectByIndex(10); // Nov

		System.out.println("Birth Month select is ::" + monthvalue.getFirstSelectedOption().getText());
		
		Thread.sleep(5000);
		
		driver.close();
		
		

	}

}
