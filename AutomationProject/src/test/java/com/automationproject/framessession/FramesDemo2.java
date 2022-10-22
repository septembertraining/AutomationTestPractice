package com.automationproject.framessession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.get("https://jqueryui.com/droppable/");
		
		WebElement frame1= driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		
		driver.switchTo().frame(frame1);
		
		WebElement drag_box=driver.findElement(By.id("draggable"));
		
		WebElement drop_box=driver.findElement(By.id("droppable"));
		
		Actions action= new Actions(driver);
		action.dragAndDrop(drag_box, drop_box).perform();
		
		
	}

}
