package demoqa_testcases;

import java.io.FileInputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_034 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_034");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(3000);

			List<WebElement> tabs = driver.findElements(By.xpath(s.getCell(3, 0).getContents()));
			Thread.sleep(2000);

			for (int i = 0; i <= tabs.size(); i++) {
				if (tabs.get(i).getText().contains(s.getCell(4, 0).getContents()))

				{
					System.out.println(s.getCell(5, 0).getContents());
				} else {
					System.out.println(s.getCell(6, 0).getContents());
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}
	}
}
