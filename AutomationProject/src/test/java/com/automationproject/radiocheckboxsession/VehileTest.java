package com.automationproject.radiocheckboxsession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VehileTest {
	
	WebDriver driver;

	public void vehicleSelect(String Requiredvehicle1, String Requiredvehicle2) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://only-testing-blog.blogspot.com/2013/09/test.html");

		List<WebElement> vehicles = driver.findElements(By.xpath("//input[@name= 'vehicle']"));

		for (WebElement vehicle : vehicles) {

			String vehicletype = vehicle.getAttribute("value");

			if (Requiredvehicle1.equals(vehicletype)) {
				   
				 if(!(vehicle.isSelected())) {  // boolean return type //false  // true
					 vehicle.click(); 
				 }
				
				
			}
			if(Requiredvehicle2.equals(vehicletype)) {
				vehicle.click();
			}
		}

	}
	
	public void tearDown() {
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		VehileTest test= new VehileTest();
		test.vehicleSelect("Boat", "Bike");
		Thread.sleep(3000);
		test.tearDown();
	}

}
