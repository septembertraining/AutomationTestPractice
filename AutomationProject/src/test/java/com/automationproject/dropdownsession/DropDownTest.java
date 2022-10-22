package com.automationproject.dropdownsession;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://courses.letskodeit.com/practice");

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='carselect']"));

		Select down = new Select(dropdown);

		if (down.isMultiple()) { // This will return either true or false if true--> true area executed else
									// false area executed
			down.selectByIndex(0);
			down.selectByIndex(2);
			
			List<WebElement> alloptions=down.getAllSelectedOptions();
			
			for(WebElement option:alloptions) {
				System.out.println(option.getText());
			}
			
        }
		else {
			down.selectByIndex(1);// 
			System.out.println(down.getFirstSelectedOption().getText());
		}
		
		driver.close();
		
			
	}

}
