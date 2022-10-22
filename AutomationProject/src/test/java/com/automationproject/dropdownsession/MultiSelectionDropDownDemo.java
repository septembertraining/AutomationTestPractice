package com.automationproject.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiSelectionDropDownDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement multidropdown = driver.findElement(By.xpath("//select[@id='multiple-select-example']"));

		Select ref = new Select(multidropdown);

		ref.selectByIndex(0);
		
		Thread.sleep(2000);

		ref.selectByValue("peach");
		
		Thread.sleep(2000);
		
		ref.deselectByValue("apple");
		
		ref.deselectAll();// this will deslect all options what ever selected as of now.
		
		Thread.sleep(4000);
		
		ref.selectByIndex(1);
		
		driver.close();
	}

}
