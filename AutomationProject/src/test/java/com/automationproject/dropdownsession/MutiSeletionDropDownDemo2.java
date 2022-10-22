package com.automationproject.dropdownsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MutiSeletionDropDownDemo2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement fruitslist = driver.findElement(By.xpath("//select[@id='multiple-select-example']"));

		Select fruit = new Select(fruitslist);

		fruit.selectByIndex(0);
		fruit.selectByVisibleText("Peach");

		// Now I want to print all selected options from dropdown

		List<WebElement> allfruits = fruit.getAllSelectedOptions();

		for (WebElement fruitt : allfruits) {
			System.out.println(fruitt.getText());
		}

	}

}
