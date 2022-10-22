package com.automationproject.dropdownsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownDemo2 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://courses.letskodeit.com/practice");
		
		//Now my requirement is to get all the options from dropdown
		
		WebElement carslist=driver.findElement(By.xpath("//select[@id= 'carselect']"));
		
		Select cars= new Select(carslist);
		
		List<WebElement> allcars=cars.getOptions();
		
		for(WebElement car:allcars) {
			
			String carname=car.getText();
			
			System.out.println(carname);
		}
		
		Thread.sleep(3000);
		
		driver.close();
		
		
	}

}
