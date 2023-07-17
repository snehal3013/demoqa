package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_029 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_029");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,500)", "");

			driver.findElement(By.xpath(s.getCell(3, 0).getContents())).click();

			driver.findElement(By.id(s.getCell(4, 0).getContents())).click();
			org.openqa.selenium.Alert a = driver.switchTo().alert();
			System.out.println("Alert Message: " + a.getText());

			a.accept();
			Thread.sleep(3000);
			driver.findElement(By.id(s.getCell(5, 0).getContents())).click();
			Thread.sleep(8000);
			org.openqa.selenium.Alert a1 = driver.switchTo().alert();
			System.out.println("Alert Message: " + a1.getText());

			a.accept();
			Thread.sleep(3000);
			driver.findElement(By.id(s.getCell(6, 0).getContents())).click();
			org.openqa.selenium.Alert a2 = driver.switchTo().alert();
			System.out.println("Alert Message: " + a2.getText());

			a.accept();

			Thread.sleep(3000);
			driver.findElement(By.id(s.getCell(7, 0).getContents())).click();
			org.openqa.selenium.Alert a3 = driver.switchTo().alert();
			System.out.println("Alert Message: " + a3.getText());
			driver.switchTo().alert().sendKeys(s.getCell(8, 0).getContents());
			a.accept();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}

	}

}
