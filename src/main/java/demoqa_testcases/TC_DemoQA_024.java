package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_024 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_024");

			driver.get(s.getCell(1, 0).getContents());
			driver.manage().window().maximize();
			Thread.sleep(2000);
			boolean forms = driver.findElement(By.xpath(s.getCell(2, 0).getContents())).isEnabled();
			if (forms == true) {
				System.out.println(s.getCell(3, 0).getContents());
			} else {
				System.out.println(s.getCell(4, 0).getContents());
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			driver.close();
		}
	}
}