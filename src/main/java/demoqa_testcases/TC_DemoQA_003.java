package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_003 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_003");
			driver.get(s.getCell(1, 0).getContents());
			Thread.sleep(2000);
			driver.manage().window().maximize();

			boolean ele = driver.findElement(By.xpath(s.getCell(2, 0).getContents())).isEnabled();
			if (ele == true) {
				System.out.println(s.getCell(3, 0).getContents());
			} else {
				System.out.println(s.getCell(4, 0).getContents());
			}

			boolean forms = driver.findElement(By.xpath(s.getCell(5, 0).getContents())).isEnabled();
			if (forms == true) {
				System.out.println(s.getCell(6, 0).getContents());
			} else {
				System.out.println(s.getCell(7, 0).getContents());
			}

			boolean alerts = driver.findElement(By.xpath(s.getCell(8, 0).getContents())).isEnabled();
			if (alerts == true) {
				System.out.println(s.getCell(9, 0).getContents());
			} else {
				System.out.println(s.getCell(10, 0).getContents());
			}

			boolean widgets = driver.findElement(By.xpath(s.getCell(11, 0).getContents())).isEnabled();
			if (widgets == true) {
				System.out.println(s.getCell(12, 0).getContents());
			} else {
				System.out.println(s.getCell(13, 0).getContents());
			}

			boolean interact = driver.findElement(By.xpath(s.getCell(14, 0).getContents())).isEnabled();
			if (interact == true) {
				System.out.println(s.getCell(15, 0).getContents());
			} else {
				System.out.println(s.getCell(16, 0).getContents());
			}

			boolean bookstore = driver.findElement(By.xpath(s.getCell(17, 0).getContents())).isEnabled();
			if (bookstore == true) {
				System.out.println(s.getCell(18, 0).getContents());
			} else {
				System.out.println(s.getCell(19, 0).getContents());
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}
	}
}
