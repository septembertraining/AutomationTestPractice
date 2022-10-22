package com.automationproject.dropdownsession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		String urlpage = driver.getCurrentUrl();

		System.out.println(urlpage);

		String pagetitle = driver.getTitle();

		System.out.println(pagetitle);

		WebElement carslist = driver.findElement(By.xpath("//select[@id= 'carselect']"));

		Select cars = new Select(carslist);

		cars.selectByIndex(2);// It will select Benz

		WebElement selectedOption = cars.getFirstSelectedOption();

		System.out.println("Selected option in dropdown is -- " + selectedOption.getText());
		
		Thread.sleep(5000);
		
		driver.close();// This method will close currently active browser

	}

}
