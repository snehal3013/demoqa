package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_101 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_101");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,800)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,1000)", "");
			driver.findElement(By.xpath(s.getCell(3, 0).getContents())).click();
			Thread.sleep(2000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,300)", "");
			driver.findElement(By.xpath(s.getCell(4, 0).getContents())).click();
			Thread.sleep(2000);

			driver.findElement(By.id(s.getCell(5, 0).getContents())).sendKeys(s.getCell(6, 0).getContents());
			Thread.sleep(2000);
			driver.findElement(By.id(s.getCell(7, 0).getContents())).sendKeys(s.getCell(8, 0).getContents());
			Thread.sleep(2000);
			driver.findElement(By.id(s.getCell(9, 0).getContents())).sendKeys(s.getCell(10, 0).getContents());
			Thread.sleep(2000);
			driver.findElement(By.id(s.getCell(11, 0).getContents())).sendKeys(s.getCell(12, 0).getContents());
			Thread.sleep(7000);

			driver.findElement(By.xpath(s.getCell(13, 0).getContents())).click();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}
	}
}
