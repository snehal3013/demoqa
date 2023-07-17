package demoqa_testcases;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_002 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_002");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(2000);
			List<WebElement> tabs = driver.findElements(By.tagName(s.getCell(2, 0).getContents()));
			Thread.sleep(2000);

			for (int i = 0; i <= tabs.size(); i++) {
				System.out.println(tabs.get(i).getText());

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {

			driver.close();
		}
	}
}
