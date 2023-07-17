package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_031 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_031");

			driver.get(s.getCell(1, 0).getContents());
			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,300)", "");

			driver.findElement(By.xpath(s.getCell(3, 0).getContents())).click();
			Thread.sleep(2000);

			driver.switchTo().frame(s.getCell(4, 0).getContents());
			boolean frame = driver.findElement(By.id(s.getCell(5, 0).getContents())).isDisplayed();
			if (frame == true) {
				System.out.println(s.getCell(6, 0).getContents());
			} else {
				System.out.println(s.getCell(7, 0).getContents());
			}
			driver.switchTo().defaultContent();
			Thread.sleep(2000);
			driver.switchTo().frame(s.getCell(8, 0).getContents());
			boolean frame1 = driver.findElement(By.id(s.getCell(9, 0).getContents())).isDisplayed();
			if (frame1 == true) {
				System.out.println(s.getCell(10, 0).getContents());
			} else {
				System.out.println(s.getCell(11, 0).getContents());
			}

			driver.switchTo().defaultContent();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.quit();
		}
	}

}
