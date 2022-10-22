package com.automationproject.radiocheckboxsession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenderTest {
	
	WebDriver driver;

	public void genderSelect(String Requiredgender) {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://only-testing-blog.blogspot.com/2013/09/test.html");

		List<WebElement> genders = driver.findElements(By.xpath("//input[@name= 'gender']"));

		for (WebElement gender : genders) {

			String gendertype = gender.getAttribute("value");

			if (Requiredgender.equals(gendertype)) {
				gender.click();
				break;
			}
		}

	}
	
	public void tearDown() {
		driver.close();
	}
	
	public static void main(String[] args) throws InterruptedException {
		GenderTest test= new GenderTest();
		test.genderSelect("male");
		Thread.sleep(3000);
		test.tearDown();
	}

}
