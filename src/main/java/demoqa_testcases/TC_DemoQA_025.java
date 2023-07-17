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

public class TC_DemoQA_025 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_025");

			driver.get(s.getCell(1, 0).getContents());

			driver.manage().window().maximize();
			Thread.sleep(4000);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");

			driver.findElement(By.xpath(s.getCell(2, 0).getContents())).click();
			Thread.sleep(2000);

			driver.findElement(By.xpath(s.getCell(3, 0).getContents())).click();
			Thread.sleep(2000);

			driver.findElement(By.id(s.getCell(4, 0).getContents())).sendKeys(s.getCell(5, 0).getContents());
			Thread.sleep(2000);
			driver.findElement(By.id(s.getCell(6, 0).getContents())).sendKeys(s.getCell(7, 0).getContents());
			Thread.sleep(2000);
			driver.findElement(By.id(s.getCell(8, 0).getContents())).sendKeys(s.getCell(9, 0).getContents());
			Thread.sleep(2000);
			JavascriptExecutor js2 = (JavascriptExecutor) driver;
			js2.executeScript("window.scrollBy(0,300)", "");
			driver.findElement(By.xpath(s.getCell(10, 0).getContents())).click();
			Thread.sleep(2000);
			driver.findElement(By.id(s.getCell(11, 0).getContents())).sendKeys(s.getCell(12, 0).getContents());
			Thread.sleep(2000);

			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollBy(0,400)", "");
			WebElement autoOptions = driver.findElement(By.xpath(s.getCell(13, 0).getContents()));
			Thread.sleep(4000);

			List<WebElement> optionsToSelect = autoOptions.findElements(By.tagName(s.getCell(14, 0).getContents()));
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(s.getCell(15, 0).getContents())) {

					option.click();
				}
				break;
			}
			driver.findElement(By.xpath(s.getCell(16, 0).getContents())).click();
			Thread.sleep(2000);

			WebElement uploadfile = driver.findElement(By.id(s.getCell(17, 0).getContents()));
			uploadfile.sendKeys(s.getCell(18, 0).getContents());

			driver.findElement(By.id(s.getCell(19, 0).getContents())).sendKeys(s.getCell(20, 0).getContents());
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.close();
		}
	}
}
