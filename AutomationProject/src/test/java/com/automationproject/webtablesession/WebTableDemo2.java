package com.automationproject.webtablesession;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTableDemo2 {
	
	public static void attendance(String stndfirstname) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		driver.get("https://letcode.in/table");

		WebElement simple_table = driver.findElement(By.id("simpletable"));

		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();", simple_table);

		List<WebElement> tablerows = simple_table.findElements(By.tagName("tr"));

		// int rows =tablerows.size(); // This method will provide count of rows in
		// table

		for (int i = 1; i <= tablerows.size() - 1; i++) {
			List<WebElement> tablecolumns = tablerows.get(i).findElements(By.tagName("td"));// row

			for (int j = 0; j <= tablecolumns.size() - 1; j++) { // columns

				if (tablecolumns.get(j).getText().equalsIgnoreCase(stndfirstname)) {
					tablecolumns.get(3).findElement(By.tagName("input")).click();

				}
				break;
			}

		}
	}


	public static void main(String[] args) {
		attendance("iron");

	}

}
