package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_035 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_035");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,700)", "");

			driver.findElement(By.xpath(s.getCell(3, 0).getContents())).click();
			Thread.sleep(2000);

			driver.findElement(By.id(s.getCell(4, 0).getContents())).click();
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(s.getCell(5, 0).getContents())));

			System.out.println(s.getCell(6, 0).getContents());
			WebElement modalContainer = driver.findElement(By.id(s.getCell(7, 0).getContents()));

			System.out.println(s.getCell(8, 0).getContents());
			WebElement modalAcceptButton = driver.findElement(By.id(s.getCell(9, 0).getContents()));
			modalAcceptButton.click();
			Thread.sleep(2000);

			driver.findElement(By.id(s.getCell(10, 0).getContents())).click();
			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(s.getCell(11, 0).getContents())));

			System.out.println(s.getCell(12, 0).getContents());
			WebElement modalContainer1 = driver.findElement(By.id(s.getCell(13, 0).getContents()));

			System.out.println(s.getCell(14, 0).getContents());
			WebElement modalAcceptButton1 = driver.findElement(By.id(s.getCell(15, 0).getContents()));
			modalAcceptButton1.click();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}

	}

}
