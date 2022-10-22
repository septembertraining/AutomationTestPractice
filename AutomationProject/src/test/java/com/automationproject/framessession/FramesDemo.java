package com.automationproject.framessession;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FramesDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver= new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		
		WebElement frm_textbox=driver.findElement(By.xpath("//input[@class='frmTextBox']"));
		
		Actions action= new Actions(driver);
		
		action.moveToElement(frm_textbox).perform();
		
		frm_textbox.sendKeys("Cloud Naradha");
		
		Thread.sleep(2000);
		
		WebElement frame1=driver.findElement(By.id("frm1"));
		
		driver.switchTo().frame(frame1);
		
		
		WebElement  menu_dropdown =driver.findElement(By.id("selectnav2"));
		
		Select menu= new Select(menu_dropdown);
		
		menu.selectByVisibleText("Contact");
		
		driver.switchTo().defaultContent();
		
		Thread.sleep(2000);
		
		frm_textbox.clear();
		
		frm_textbox.sendKeys("Cloud naradha hyderabad");
		
		Thread.sleep(8000);
		
		driver.close();
		
		
	}

}
