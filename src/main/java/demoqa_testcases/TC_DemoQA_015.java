package demoqa_testcases;

import java.io.FileInputStream;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_015 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_015");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			// elements
			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);

			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,300)", "");
			Thread.sleep(2000);
			// links
			driver.findElement(By.id(s.getCell(3, 0).getContents())).click();
			Thread.sleep(3000);

			driver.findElement(By.linkText(s.getCell(4, 0).getContents())).click();
			Thread.sleep(2000);
			if (driver.getTitle().contains(s.getCell(5, 0).getContents())) {
				System.out.println(s.getCell(6, 0).getContents());
			} else {
				System.out.println(s.getCell(7, 0).getContents());
			}
			Thread.sleep(3000);

			ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());

			driver.switchTo().window(newTb.get(1));
			System.out.println("Page title of new tab: " + driver.getTitle());

			driver.switchTo().window(newTb.get(0));

			driver.findElement(By.id(s.getCell(8, 0).getContents()));
			Thread.sleep(2000);
			if (driver.getTitle().contains(s.getCell(9, 0).getContents())) {
				System.out.println(s.getCell(10, 0).getContents());
			} else {
				System.out.println(s.getCell(11, 0).getContents());
			}
			Thread.sleep(3000);

			ArrayList<String> newTb1 = new ArrayList<String>(driver.getWindowHandles());

			driver.switchTo().window(newTb1.get(1));
			System.out.println("Page title of new tab: " + driver.getTitle());

			driver.switchTo().window(newTb1.get(0));

			driver.findElement(By.linkText(s.getCell(12, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(13, 0).getContents())) {
				System.out.println(s.getCell(14, 0).getContents());
			} else {
				System.out.println(s.getCell(15, 0).getContents());
			}
			Thread.sleep(2000);

			JavascriptExecutor js3 = (JavascriptExecutor) driver;
			js3.executeScript("window.scrollBy(0,400)", "");
			Thread.sleep(2000);

			driver.findElement(By.linkText(s.getCell(16, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(17, 0).getContents())) {
				System.out.println(s.getCell(18, 0).getContents());
			} else {
				System.out.println(s.getCell(19, 0).getContents());
			}
			Thread.sleep(3000);
			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			js7.executeScript("window.scrollBy(0,350)", "");

			driver.findElement(By.linkText(s.getCell(20, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(21, 0).getContents())) {
				System.out.println(s.getCell(22, 0).getContents());
			} else {
				System.out.println(s.getCell(23, 0).getContents());
			}
			Thread.sleep(3000);

			driver.findElement(By.linkText(s.getCell(24, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(25, 0).getContents())) {
				System.out.println(s.getCell(26, 0).getContents());
			} else {
				System.out.println(s.getCell(27, 0).getContents());
			}
			Thread.sleep(3000);

			driver.findElement(By.linkText(s.getCell(28, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(29, 0).getContents())) {
				System.out.println(s.getCell(30, 0).getContents());
			} else {
				System.out.println(s.getCell(31, 0).getContents());
			}
			Thread.sleep(3000);

			driver.findElement(By.linkText(s.getCell(32, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(33, 0).getContents())) {
				System.out.println(s.getCell(34, 0).getContents());
			} else {
				System.out.println(s.getCell(35, 0).getContents());
			}
			Thread.sleep(3000);

			driver.findElement(By.linkText(s.getCell(36, 0).getContents())).click();
			Thread.sleep(3000);
			if (driver.getPageSource().contains(s.getCell(37, 0).getContents())) {
				System.out.println(s.getCell(38, 0).getContents());
			} else {
				System.out.println(s.getCell(39, 0).getContents());
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.quit();
		}
	}

}
