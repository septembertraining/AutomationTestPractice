package com.automationproject.testngsessions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmTest3 {

	WebDriver driver;

	@DataProvider(name = "addempdata")
	public Object[][] addEmployeeData() {

		Object[][] data = new Object[4][4];

		data[0][0] = "Ram";
		data[0][1] = "Mohan";
		data[0][2] = "Singh";
		data[0][3] = "20455";

		data[1][0] = "Sitha";
		data[1][1] = "Ram";
		data[1][2] = "Sethu";
		data[1][3] = "20466";

		data[2][0] = "Rahim";
		data[2][1] = "Mohammed";
		data[2][2] = "Basha";
		data[2][3] = "20477";

		data[3][0] = "John";
		data[3][1] = "Son";
		data[3][2] = "baby";
		data[3][3] = "20488";

		return data;
	}

	@DataProvider(name = "empdata")
	public Object[][] empData() throws IOException {
		File f = new File("C:\\Users\\gurum\\Desktop\\EmpData.xlsx");

		FileInputStream fi = new FileInputStream(f);

		Workbook book = WorkbookFactory.create(fi);

		Sheet sh = book.getSheet("Data1");

		Object[][] data = new Object[sh.getLastRowNum()][sh.getRow(0).getLastCellNum()];

		for (int i = 0; i < sh.getLastRowNum(); i++) { // row 1 2
			for (int j = 0; j < sh.getRow(0).getLastCellNum(); j++) { //cell ram, mohan, reddy, 101 
				data[i][j] = sh.getRow(i + 1).getCell(j).toString();
			}
		}
		return data;

	}

	@BeforeTest
	public void lauchBrowser() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();

		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	@BeforeClass
	public void launchUrl() {
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@BeforeMethod
	public void orangeHRMLogin() {

		driver.findElement(By.name("username")).sendKeys("Admin");

		driver.findElement(By.name("password")).sendKeys("admin123");

		driver.findElement(By.xpath("//button[text()=' Login ']")).click();

		// IF this line returns true this method pass
	}

	@Test(dataProvider = "empdata")
	public void addEmployee(String firstname, String midname, String lastname, String empid)
			throws InterruptedException {

		driver.findElement(By.xpath("//li/a[text()='Add Employee']")).click();

		Thread.sleep(3000);

		driver.findElement(By.name("firstName")).sendKeys(firstname);

		driver.findElement(By.name("middleName")).sendKeys(midname);

		driver.findElement(By.name("lastName")).sendKeys(lastname);

		driver.findElement(By.xpath("//label[text()='Employee Id']/parent::div/following::div[1]/input"))
				.sendKeys(empid);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Thread.sleep(3000);
	}

	@AfterMethod
	public void captureScreenshot(ITestResult result) throws IOException {

		if (result.getStatus() == ITestResult.FAILURE) {
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			File dest = new File(
					"D:\\Students Projects\\SeptemberEveningBatch\\AutomationProject\\CaptureImage\\failed.jpg");
			FileUtils.copyFile(src, dest);

		}

	}

	@AfterMethod
	public void logOff() {
		driver.findElement(By.xpath("//li[@class='oxd-userdropdown']")).click();

		driver.findElement(By.xpath("//li/a[text()='Logout']")).click();
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
