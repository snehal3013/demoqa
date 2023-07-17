package demoqa_testcases;

import java.io.FileInputStream;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;

public class TC_DemoQA_027 {

	public static void main(String[] args) {
		WebDriver driver = WebDriverManager.chromedriver().create();
		try {
			FileInputStream f = new FileInputStream("D:\\Snehal\\Demoqa locators.xls");

			Workbook wb = Workbook.getWorkbook(f);

			Sheet s = wb.getSheet("TC_DemoQA_027");

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
			driver.findElement(By.xpath(s.getCell(4, 0).getContents())).click();
			Thread.sleep(2000);

			if (driver.getPageSource().contains(s.getCell(5, 0).getContents())) {
				System.out.println(s.getCell(6, 0).getContents());
			} else {
				System.out.println(s.getCell(7, 0).getContents());
			}

			driver.findElement(By.id(s.getCell(8, 0).getContents())).click();

			String mainWindowHandle = driver.getWindowHandle();
			Set<String> allWindowHandles = driver.getWindowHandles();
			java.util.Iterator<String> iterator = allWindowHandles.iterator();

			while (iterator.hasNext()) {
				String ChildWindow = iterator.next();
				if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
					driver.switchTo().window(ChildWindow);
					WebElement text = driver.findElement(By.id(s.getCell(9, 0).getContents()));
					if (driver.getPageSource().contains(s.getCell(10, 0).getContents())) {
						System.out.println(s.getCell(11, 0).getContents());
					} else {
						System.out.println(s.getCell(12, 0).getContents());
					}
					driver.switchTo().window(mainWindowHandle);
					Thread.sleep(2000);

					driver.findElement(By.id(s.getCell(13, 0).getContents())).click();

					String mainWindowHandle1 = driver.getWindowHandle();
					Set<String> allWindowHandles1 = driver.getWindowHandles();
					java.util.Iterator<String> iterator1 = allWindowHandles.iterator();

					while (iterator.hasNext()) {
						String ChildWindow1 = iterator.next();
						if (!mainWindowHandle.equalsIgnoreCase(ChildWindow)) {
							driver.switchTo().window(ChildWindow);
							WebElement text1 = driver.findElement(By.xpath(s.getCell(14, 0).getContents()));
							if (driver.getPageSource().contains(s.getCell(15, 0).getContents())) {
								System.out.println(s.getCell(16, 0).getContents());
							} else {
								System.out.println(s.getCell(17, 0).getContents());
							}
							driver.switchTo().window(mainWindowHandle);
							Thread.sleep(2000);
						}
					}
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.quit();
		}
	}
}
