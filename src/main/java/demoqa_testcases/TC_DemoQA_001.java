package demoqa_testcases;

import java.io.FileInputStream;

import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_001 {

	public static void main(String[] args) {

		WebDriver driver = WebDriverManager.chromedriver().create();
		try {

			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_001");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			driver.close();
		}
	}

}
